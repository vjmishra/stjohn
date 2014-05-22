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
public class PurchBySupplierJDReport extends BaseJDReport implements GenericReportMulti {

    /** Creates a new instance of PurchBySupplierJDReport */
    public PurchBySupplierJDReport() {
    }

    /** Should return a populated GenericReportResultView object.  At a minimum the header should
     * be set so an empty report may be generated to the user.
     *
     */

    protected static final String SUPPLIER = "Supplier";

    protected static final String PRICE_COL = "TOTAL_QUANTITY_ORDERED * CUST_CONTRACT_PRICE";
    protected static final String QTY_COL   = "TOTAL_QUANTITY_ORDERED";
    protected static final String COST_COL  = "CUST_CONTRACT_PRICE";
    private String manufFilter = "";

      protected GenericReportColumnViewVector getReportHeader() {

        GenericReportColumnViewVector header = new GenericReportColumnViewVector();
        header.add(ReportingUtils.createGenericReportColumnView("java.lang.String",this.SUPPLIER,0,255,"VARCHAR2","100",false));
        header.add(ReportingUtils.createGenericReportColumnView("java.math.BigDecimal.Separator",this.CURRENT_NET_SALES+" $",0,20,"NUMBER","80",false));
        header.add(ReportingUtils.createGenericReportColumnView("java.math.BigDecimal.Separator",this.PRIOR_NET_SALES+" $",0,20,"NUMBER","80",false));
        header.add(ReportingUtils.createGenericReportColumnView("java.math.BigDecimal",this.PROC_OF_TOTAL,0,20,"NUMBER","60",false,"0.0%"));
        header.add(ReportingUtils.createGenericReportColumnView("java.math.BigDecimal",this.NET_SALES_GROWTH,0,20,"NUMBER","60",false,"0.0%"));
        header.add(ReportingUtils.createGenericReportColumnView("java.math.BigDecimal.Separator",this.CURRENT_UNITS,0,20,"NUMBER","80",false));
        header.add(ReportingUtils.createGenericReportColumnView("java.math.BigDecimal.Separator",this.PRIOR_UNITS,0,20,"NUMBER","80",false));
        header.add(ReportingUtils.createGenericReportColumnView("java.math.BigDecimal",this.UNIT_GROWTH,0,20, "NUMBER","60",false,"0.0%"));
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
//      IdVector listOfManuf = getListOfManuf(conn, JD_GROUP_NAME);
      String selectSqlSites= getQuerySql( null, pParams);

      // for accounts if there were sales in "Current Year" and may be there were no sales in "Prior Year"
      String selectSqlCurrY = getQuerySqlForCurrentY(selectSqlSites);
      // for accounts if there were sales in "Prior Year" and there were no sales in "Current Year"

//      String   selectSqlPriorY = getQuerySqlForPriorY(selectSqlAccount);

      String selectSql =
          "select \n" +
          "   (select SHORT_DESC from CLW_BUS_ENTITY where BUS_ENTITY_ID = BE_ID ) SHORT_DESC, \n" +
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
      boolean manufFl = Utility.isSet(manufFilter);
      String sql =
              " select  BUS_ENTITY_ID as BE_ID, \n" +
              "         sum(SUM_PRICE) SUM_PRICE, \n" +
              "         sum(SUM_QTY) SUM_QTY, \n" +
              "         sum(PRIOR_SUM_PRICE) PRIOR_SUM_PRICE, \n" +
              "         sum(PRIOR_SUM_QTY) PRIOR_SUM_QTY  \n" +
              " from CLW_ITEM_MAPPING im,   \n" +
              "   (select  ITEM_ID, sum(SUM_PRICE) SUM_PRICE, sum(SUM_QTY) SUM_QTY, \n " +
              "       sum(PRIOR_SUM_PRICE) PRIOR_SUM_PRICE, sum(PRIOR_SUM_QTY) PRIOR_SUM_QTY \n" +
              "    from ( \n" +
                   subSelect +
                   "   ) group by ITEM_ID  \n" +
              "   ) s  \n" +
              " where ITEM_MAPPING_CD = '" +RefCodeNames.ITEM_MAPPING_CD.ITEM_MANUFACTURER +"' \n" +
              "   and im.ITEM_ID = s.ITEM_ID \n" +
              (manufFl ?  manufFilter + " \n":"") +
              " group by BUS_ENTITY_ID  \n" ;
          return sql;
    }

    protected String getQuerySql( IdVector listOfManuf, Map pParams) throws Exception {
      //=========== getting parameters =======================================
       int storeId = Integer.parseInt((String) pParams.get(STORE_S));
       String begDateStr = (String) pParams.get(BEG_DATE_S);
       String endDateStr = (String) pParams.get(END_DATE_S);
       Object accountsV = getParamValue(pParams, LOCATE_ACCOUNT_MULTI_S);
       Object sitesV = getParamValue(pParams, SITE_MULTI_OPT_S);
       Object manufV = getParamValue(pParams, LOCATE_MANUFACTURER_OPT_S);
       //======================================================================//

      GregorianCalendar currBegCalendar = new GregorianCalendar();
      currBegCalendar.setTime(ReportingUtils.parseDate(begDateStr));

      GregorianCalendar priorBegCalendar = (GregorianCalendar) currBegCalendar.clone();
      priorBegCalendar.add(GregorianCalendar.YEAR, -1);

      GregorianCalendar currEndCalendar = new GregorianCalendar();
      currEndCalendar.setTime(ReportingUtils.parseDate(endDateStr));

      GregorianCalendar priorEndCalendar = (GregorianCalendar) currEndCalendar.clone();
      priorEndCalendar.add(GregorianCalendar.YEAR, -1);

      String startDateS = ReportingUtils.toSQLDate(currBegCalendar.getTime());
      String endDateS =   ReportingUtils.toSQLDate(currEndCalendar.getTime());

      String startDateSPre = ReportingUtils.toSQLDate(priorBegCalendar.getTime());
      String endDateSPre = ReportingUtils.toSQLDate(priorEndCalendar.getTime());


      String whereForAccounts = (ReportingUtils.isParamSet(accountsV) && !ReportingUtils.isParamSet(sitesV) ) ?
         "    and account_id in (" +ReportingUtils.convertParamToString(accountsV) + ")  \n" : "";

      String whereForSites = (ReportingUtils.isParamSet(sitesV) ) ?
        "    and site_id in (" +ReportingUtils.convertParamToString(sitesV) + ")  \n" : "";

      manufFilter = (ReportingUtils.isParamSet(manufV) ) ?
      "    and BUS_ENTITY_ID in (" +ReportingUtils.convertParamToString(manufV) + ")  \n" : "";

/*
      String subSqlJdItems =
          " SELECT item_Id FROM clw_item_mapping \n" +
          " WHERE bus_entity_id IN (" +IdVector.toCommaString(listOfManuf) + ") \n" +
          "   AND  ITEM_MAPPING_CD = '" + RefCodeNames.ITEM_MAPPING_CD.ITEM_MANUFACTURER + "'" ;
*/

      String sql=
         " select item_id, \n" +
         "        sum("+ PRICE_COL +") SUM_PRICE, \n" +
         "        sum("+ QTY_COL +") SUM_QTY,  \n" +
         "         0 PRIOR_SUM_PRICE, \n" +
         "         0 PRIOR_SUM_QTY \n" +
         "   from clw_order o, clw_order_item oi \n" +
         "  where o.ORDER_ID = oi.ORDER_ID \n" +
         "    and store_id =  " + storeId + " \n" +
         whereForAccounts +
         whereForSites +
         "    and o.ORIGINAL_ORDER_DATE between "+ startDateS+" and "+endDateS + " \n" +
         "    and oi.ERP_PO_NUM is not NULL \n" +
         "    and oi.ORDER_ITEM_STATUS_CD not in ('" + RefCodeNames.ORDER_STATUS_CD.CANCELLED + "') \n" +
////       "    and oi.ITEM_ID in (" + subSqlJdItems +") \n" +
         "    group by item_id \n"+
         " union all \n" +
         "select item_id, \n" +
         "        0 SUM_PRICE, \n" +
         "        0 SUM_QTY,  \n" +
         "        sum("+ PRICE_COL +") PRIOR_SUM_PRICE, \n" +
         "        sum("+ QTY_COL +")  PRIOR_SUM_QTY \n" +
         "   from clw_order o, clw_order_item oi \n" +
         "  where o.ORDER_ID = oi.ORDER_ID \n" +
         "    and store_id =  " + storeId + " \n" +
         whereForAccounts +
         whereForSites +
         "    and o.ORIGINAL_ORDER_DATE between "+ startDateSPre+" and "+endDateSPre + " \n" +
         "    and oi.ERP_PO_NUM is not NULL \n" +
         "    and oi.ORDER_ITEM_STATUS_CD not in ('" + RefCodeNames.ORDER_STATUS_CD.CANCELLED + "') \n" +
 //        "    and oi.ITEM_ID in (" + subSqlJdItems +") \n" +
         "    group by item_id \n" ;

        return sql;
    }



    protected String getTitle() {
      String title = "Purchases by Supplier" ;
      return title;
    }

}
