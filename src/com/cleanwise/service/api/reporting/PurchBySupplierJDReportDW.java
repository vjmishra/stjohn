/*
 * PurchBySupplierJDReport.java
 *
 * Created on October 15, 2008, 4:43 PM
 */

package com.cleanwise.service.api.reporting;
import com.cleanwise.service.api.value.*;
import com.cleanwise.service.api.util.RefCodeNames;
import com.cleanwise.service.api.util.ConnectionContainer;
import java.util.Map;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.sql.*;
import java.sql.Connection;
import java.rmi.RemoteException;
import java.math.BigDecimal;
import com.cleanwise.service.api.framework.ValueObject;
import java.util.*;
import com.cleanwise.service.api.util.Utility;
import java.math.MathContext;

/**
 * Picks up orders and agreates it on Surrplier
 * @params pBeginDate start of the period. pEndDate  end of the period
 * Adapted  to the new GenericReport Framework.
 *
 * @param pBeginDate start of the period,
 * @param pEndDate end of the period,
 * @param pAccountId account Id optionally,
 */
public class PurchBySupplierJDReportDW extends BaseJDReportDW implements GenericReportMulti {

    /** Creates a new instance of PurchBySupplierJDReport */
    public PurchBySupplierJDReportDW() {
    }

    /** Should return a populated GenericReportResultView object.  At a minimum the header should
     * be set so an empty report may be generated to the user.
     *
     */

    protected static final String SUPPLIER = "Supplier";

    protected static final String PRICE_COL = "QUANTITY * PRICE";
    protected static final String QTY_COL   = "QUANTITY";
    protected static final String COST_COL  = "PRICE";
    private String manufFilter = "";

      protected GenericReportColumnViewVector getReportHeader() {

        GenericReportColumnViewVector header = new GenericReportColumnViewVector();
        header.add(ReportingUtils.createGenericReportColumnView(this.SUPPLIER, "COL_SUPPLIER", null,"26"));
        header.add(ReportingUtils.createGenericReportColumnView(this.CURRENT_NET_SALES+" $", "COL_CUR_SALES","TYPE_AMOUNT_DATA",COL_WIDTH[4]));
        header.add(ReportingUtils.createGenericReportColumnView(this.PRIOR_NET_SALES+" $", "COL_PRI_SALES","TYPE_AMOUNT_DATA",COL_WIDTH[5]));
        header.add(ReportingUtils.createGenericReportColumnView(this.PROC_OF_TOTAL,"COL_PROC_TOT","TYPE_PERCENT_DATA",COL_WIDTH[6]));
        header.add(ReportingUtils.createGenericReportColumnView(this.NET_SALES_GROWTH,"COL_SALES_GR","TYPE_PERCENT_DATA",COL_WIDTH[7]));
        header.add(ReportingUtils.createGenericReportColumnView(this.CURRENT_UNITS,"COL_CUR_UNIT","TYPE_QTY_DATA",COL_WIDTH[8]));
        header.add(ReportingUtils.createGenericReportColumnView(this.PRIOR_UNITS, "COL_PRI_UNIT","TYPE_QTY_DATA",COL_WIDTH[9]));
        header.add(ReportingUtils.createGenericReportColumnView(this.UNIT_GROWTH,"COL_UNIT_GR","TYPE_PERCENT_DATA",COL_WIDTH[10]));
        return header;
    }

    protected void addRowToReport(ArrayList row , Map reportRowMap, JDReportView currYItem) {
      boolean totalRowFlag = (((String)reportRowMap.get(this.GROUPBY)).equals(GRAND_TOTAL )) ? true : false;
      String style = null;
      if (currYItem == null && totalRowFlag ) {
        style = BOLD_STYLE;
        row.add(putCellStyle(style,reportRowMap.get(this.GROUPBY)));
      } else {
        row.add(putCellStyle(style,currYItem.getGroupByName()));
      }
      row.add(putCellStyle(style,reportRowMap.get(this.CURRENT_NET_SALES)));
      row.add(putCellStyle(style,reportRowMap.get(this.PRIOR_NET_SALES)));
      row.add(putCellStyle(style,reportRowMap.get(this.PROC_OF_TOTAL)));
      row.add(putCellStyle(style,ReportingUtils.validPercent (reportRowMap.get(this.NET_SALES_GROWTH))));
      row.add(putCellStyle(style,reportRowMap.get(this.CURRENT_UNITS)));
      row.add(putCellStyle(style,reportRowMap.get(this.PRIOR_UNITS)));
      row.add(putCellStyle(style,ReportingUtils.validPercent (reportRowMap.get(this.UNIT_GROWTH))));
    }

    protected ArrayList getResultOfQuery(Connection conn, Map pParams) throws Exception{
      BigDecimal zeroAmt = new BigDecimal(0);
      String selectSqlSites= getQuerySql(  pParams);

      // for accounts if there were sales in "Current Year" and may be there were no sales in "Prior Year"
      String selectSqlCurrY = getQuerySqlForCurrentY(selectSqlSites);

      String selectSql =
          "select \n" +
          "   (select MANUF_NAME from DW_MANUFACTURER_DIM where MANUFACTURER_DIM_ID = g.MANUFACTURER_DIM_ID ) SHORT_DESC, \n" +
          "   g.* \n"+
          " from \n" +
          "  (" +
          selectSqlCurrY +
          "  ) g \n" +
          " order by nvl(SUM_PRICE,0) desc, SHORT_DESC \n";

      PreparedStatement pstmt = conn.prepareStatement(selectSql);

      ResultSet rs = pstmt.executeQuery();
      JDReportViewVector psViewV= new JDReportViewVector();
      while (rs.next()){
        JDReportView psView = new JDReportView ();
        String surrplierName = (rs.getString("SHORT_DESC") != null) ? rs.getString("SHORT_DESC") : "";
        BigDecimal sumPrice = (rs.getBigDecimal("SUM_PRICE") != null) ? rs.getBigDecimal("SUM_PRICE") : zeroAmt;
        BigDecimal sumQty   = (rs.getBigDecimal("SUM_QTY") != null) ? rs.getBigDecimal("SUM_QTY") : zeroAmt;
        BigDecimal sumPricePre = (rs.getBigDecimal("PRIOR_SUM_PRICE") != null) ? rs.getBigDecimal("PRIOR_SUM_PRICE") : zeroAmt;
        BigDecimal sumQtyPre   = (rs.getBigDecimal("PRIOR_SUM_QTY") != null) ? rs.getBigDecimal("PRIOR_SUM_QTY") : zeroAmt;
        psView.setGroupByName(surrplierName);
        psView.setSumPrice(sumPrice);
        psView.setSumQty(sumQty);
        psView.setSumPricePre(sumPricePre);
        psView.setSumQtyPre(sumQtyPre);
        psViewV.add(psView);
      }
      pstmt.close();
      rs.close();
      psViewV.sort("SumPrice", false);

      return psViewV;

    }

    protected String getQuerySqlForCurrentY(String subSelect) {
      String sql =
              "select  MANUFACTURER_DIM_ID, sum(SUM_PRICE) SUM_PRICE, sum(SUM_QTY) SUM_QTY, \n " +
              "       sum(PRIOR_SUM_PRICE) PRIOR_SUM_PRICE, sum(PRIOR_SUM_QTY) PRIOR_SUM_QTY \n" +
              "    from ( \n" +
                   subSelect +
                   "   ) group by MANUFACTURER_DIM_ID  \n" ;
          return sql;
    }

    protected String getQuerySql(  Map pParams) throws Exception {

       String filterCond = createFilterCondition(pParams);
       String begDateStr = (String) pParams.get(BEG_DATE_S);
       String endDateStr = (String) pParams.get(END_DATE_S);

       //======================================================================

       String  subSqlForCurrPeriod  = createDateSqlCond( begDateStr, endDateStr, 0);
       String  subSqlForPriorPeriod = createDateSqlCond( begDateStr, endDateStr, -1);

       String subSqlJdItems =
           " select ITEM_DIM_ID from DW_ITEM_DIM where UPPER(JD_ITEM_FL) = 'TRUE' \n" ;

      String sql=
         " select ITEM_DIM_ID, MANUFACTURER_DIM_ID,\n" +
         "        sum("+ PRICE_COL +") SUM_PRICE, \n" +
         "        sum("+ QTY_COL +") SUM_QTY,  \n" +
         "         0 PRIOR_SUM_PRICE, \n" +
         "         0 PRIOR_SUM_QTY \n" +
         "  from DW_ORDER_FACT \n"+
        "    where  DATE_DIM_ID in ( " + subSqlForCurrPeriod + " ) \n" +
        filterCond +
//        "      and  ITEM_DIM_ID in ( " + subSqlJdItems + " ) \n"+
        "    group by ITEM_DIM_ID, MANUFACTURER_DIM_ID \n" +
         " union all \n" +
         "select ITEM_DIM_ID,MANUFACTURER_DIM_ID, \n" +
         "        0 SUM_PRICE, \n" +
         "        0 SUM_QTY,  \n" +
         "        sum("+ PRICE_COL +") PRIOR_SUM_PRICE, \n" +
         "        sum("+ QTY_COL +")  PRIOR_SUM_QTY \n" +
         "  from DW_ORDER_FACT \n"+
        "    where  DATE_DIM_ID in ( " + subSqlForPriorPeriod + " ) \n" +
        filterCond +
//        "      and  ITEM_DIM_ID in ( " + subSqlJdItems + " ) \n"+
        "    group by ITEM_DIM_ID, MANUFACTURER_DIM_ID \n" ;

        return sql;
    }


}
