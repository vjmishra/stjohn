
/* DO NOT EDIT - Generated code from XSL file DataAccess.xsl */

package com.cleanwise.service.api.dao;

/**
 * Title:        ReturnRequestDetailDataAccess
 * Description:  This class is used to build access methods to the CLW_RETURN_REQUEST_DETAIL table.
 * Purpose:
 * Copyright:    Copyright (c) 2001
 * Company:      CleanWise, Inc.
 * @author       Generated Code from XSL file DataAccess.xsl
 */

import com.cleanwise.service.api.value.ReturnRequestDetailData;
import com.cleanwise.service.api.value.ReturnRequestDetailDataVector;
import com.cleanwise.service.api.framework.DataAccessImpl;
import com.cleanwise.service.api.value.IdVector;
import com.cleanwise.service.api.util.DBAccess;
import com.cleanwise.service.api.util.DBCriteria;
import com.cleanwise.service.api.util.DataNotFoundException;
import org.apache.log4j.Category;
import java.io.ByteArrayInputStream;
import java.sql.*;
import java.util.*;

/**
 * <code>ReturnRequestDetailDataAccess</code>
 */
public class ReturnRequestDetailDataAccess extends DataAccessImpl
{
    private static Category log = Category.getInstance(ReturnRequestDetailDataAccess.class.getName());

    /** <code>CLW_RETURN_REQUEST_DETAIL</code> table name */
	/* Primary key: RETURN_REQUEST_DETAIL_ID */
	
    public static final String CLW_RETURN_REQUEST_DETAIL = "CLW_RETURN_REQUEST_DETAIL";
    
    /** <code>RETURN_REQUEST_DETAIL_ID</code> RETURN_REQUEST_DETAIL_ID column of table CLW_RETURN_REQUEST_DETAIL */
    public static final String RETURN_REQUEST_DETAIL_ID = "RETURN_REQUEST_DETAIL_ID";
    /** <code>RETURN_REQUEST_ID</code> RETURN_REQUEST_ID column of table CLW_RETURN_REQUEST_DETAIL */
    public static final String RETURN_REQUEST_ID = "RETURN_REQUEST_ID";
    /** <code>ORDER_ITEM_ID</code> ORDER_ITEM_ID column of table CLW_RETURN_REQUEST_DETAIL */
    public static final String ORDER_ITEM_ID = "ORDER_ITEM_ID";
    /** <code>QUANTITY_RETURNED</code> QUANTITY_RETURNED column of table CLW_RETURN_REQUEST_DETAIL */
    public static final String QUANTITY_RETURNED = "QUANTITY_RETURNED";
    /** <code>PICKUP_DATE</code> PICKUP_DATE column of table CLW_RETURN_REQUEST_DETAIL */
    public static final String PICKUP_DATE = "PICKUP_DATE";
    /** <code>ADD_BY</code> ADD_BY column of table CLW_RETURN_REQUEST_DETAIL */
    public static final String ADD_BY = "ADD_BY";
    /** <code>ADD_DATE</code> ADD_DATE column of table CLW_RETURN_REQUEST_DETAIL */
    public static final String ADD_DATE = "ADD_DATE";
    /** <code>MOD_BY</code> MOD_BY column of table CLW_RETURN_REQUEST_DETAIL */
    public static final String MOD_BY = "MOD_BY";
    /** <code>MOD_DATE</code> MOD_DATE column of table CLW_RETURN_REQUEST_DETAIL */
    public static final String MOD_DATE = "MOD_DATE";
    /** <code>RECIEVED_DIST_SKU</code> RECIEVED_DIST_SKU column of table CLW_RETURN_REQUEST_DETAIL */
    public static final String RECIEVED_DIST_SKU = "RECIEVED_DIST_SKU";
    /** <code>RECIEVED_DIST_UOM</code> RECIEVED_DIST_UOM column of table CLW_RETURN_REQUEST_DETAIL */
    public static final String RECIEVED_DIST_UOM = "RECIEVED_DIST_UOM";
    /** <code>RECIEVED_DIST_PACK</code> RECIEVED_DIST_PACK column of table CLW_RETURN_REQUEST_DETAIL */
    public static final String RECIEVED_DIST_PACK = "RECIEVED_DIST_PACK";

    /**
     * Constructor.
     */
    public ReturnRequestDetailDataAccess()
    {
    }

    /**
     * Gets a ReturnRequestDetailData object with the specified
     * key from the database.
     * @param pCon An open database connection.
     * @param pReturnRequestDetailId The key requested.
     * @return new ReturnRequestDetailData()
     * @throws            SQLException
     */
    public static ReturnRequestDetailData select(Connection pCon, int pReturnRequestDetailId)
        throws SQLException, DataNotFoundException {
        ReturnRequestDetailData x=null;
        String sql="SELECT RETURN_REQUEST_DETAIL_ID,RETURN_REQUEST_ID,ORDER_ITEM_ID,QUANTITY_RETURNED,PICKUP_DATE,ADD_BY,ADD_DATE,MOD_BY,MOD_DATE,RECIEVED_DIST_SKU,RECIEVED_DIST_UOM,RECIEVED_DIST_PACK FROM CLW_RETURN_REQUEST_DETAIL WHERE RETURN_REQUEST_DETAIL_ID = ?";

        if (log.isDebugEnabled()) {
            log.debug("SQL: pReturnRequestDetailId=" + pReturnRequestDetailId);
            log.debug("SQL: " + sql);
        }

        PreparedStatement stmt = pCon.prepareStatement(sql);
        stmt.setInt(1,pReturnRequestDetailId);
        ResultSet rs=stmt.executeQuery();
        if (rs.next()) {
            // build the object
            x=ReturnRequestDetailData.createValue();
            
            x.setReturnRequestDetailId(rs.getInt(1));
            x.setReturnRequestId(rs.getInt(2));
            x.setOrderItemId(rs.getInt(3));
            x.setQuantityReturned(rs.getInt(4));
            x.setPickupDate(rs.getDate(5));
            x.setAddBy(rs.getString(6));
            x.setAddDate(rs.getTimestamp(7));
            x.setModBy(rs.getString(8));
            x.setModDate(rs.getTimestamp(9));
            x.setRecievedDistSku(rs.getString(10));
            x.setRecievedDistUom(rs.getString(11));
            x.setRecievedDistPack(rs.getString(12));

        } else {
            rs.close();
            stmt.close();
            throw new DataNotFoundException("RETURN_REQUEST_DETAIL_ID :" + pReturnRequestDetailId);
        }

        rs.close();
        stmt.close();

        return x;
    }

    /**
     * Gets a ReturnRequestDetailDataVector object that consists
     * of ReturnRequestDetailData objects that match the supplied
     * criteria.
     * @param pCon An open database connection.
     * @param pCriteria A DBCriteria with the SQL 'where clause'
     * @return new ReturnRequestDetailDataVector()
     * @throws            SQLException
     */
    public static ReturnRequestDetailDataVector select(Connection pCon, DBCriteria pCriteria)
        throws SQLException{
        // Specify the maximum row limit to zero, unlimited size.
        return select(pCon, pCriteria, 0);
    }

    /**
    *@Returns a String of the columns suitable for using in a sql statement that may then be parsed into a ReturnRequestDetailData Object
    *using the parseResultSet method.
    */
    public String getSelectColumns(){
        return "CLW_RETURN_REQUEST_DETAIL.RETURN_REQUEST_DETAIL_ID,CLW_RETURN_REQUEST_DETAIL.RETURN_REQUEST_ID,CLW_RETURN_REQUEST_DETAIL.ORDER_ITEM_ID,CLW_RETURN_REQUEST_DETAIL.QUANTITY_RETURNED,CLW_RETURN_REQUEST_DETAIL.PICKUP_DATE,CLW_RETURN_REQUEST_DETAIL.ADD_BY,CLW_RETURN_REQUEST_DETAIL.ADD_DATE,CLW_RETURN_REQUEST_DETAIL.MOD_BY,CLW_RETURN_REQUEST_DETAIL.MOD_DATE,CLW_RETURN_REQUEST_DETAIL.RECIEVED_DIST_SKU,CLW_RETURN_REQUEST_DETAIL.RECIEVED_DIST_UOM,CLW_RETURN_REQUEST_DETAIL.RECIEVED_DIST_PACK";
    }


    /**
    *Parses a result set into a value object.  Uses the position of the columns as its key so this method should only
    *be used in conjunction with the getSelectColumns() method or the wrong data will be parsed into the wrong properties.
    *The result set is not incremented, so calls to this method leave the resultset object unchanged.
    *@param ResultSet an open result set.
    *@returns a populated ReturnRequestDetailData Object.
    *@throws SQLException
    */
    public com.cleanwise.service.api.framework.ValueObject parseResultSet(ResultSet rs) throws SQLException{
         return parseResultSet(rs,0);
    }

    /**
    *Parses a result set into a value object.  Uses the position of the columns as its key so this method should only
    *be used in conjunction with the getSelectColumns() method or the wrong data will be parsed into the wrong properties.
    *The result set is not incremented, so calls to this method leave the resultset object unchanged.
    *@param ResultSet an open result set.
    *@param int the offset to use which is useful when using 1 query to populate multiple objects
    *@returns a populated ReturnRequestDetailData Object.
    *@throws SQLException
    */
    public com.cleanwise.service.api.framework.ValueObject parseResultSet(ResultSet rs, int offset) throws SQLException{
         // build the object
         ReturnRequestDetailData x = ReturnRequestDetailData.createValue();
         
         x.setReturnRequestDetailId(rs.getInt(1+offset));
         x.setReturnRequestId(rs.getInt(2+offset));
         x.setOrderItemId(rs.getInt(3+offset));
         x.setQuantityReturned(rs.getInt(4+offset));
         x.setPickupDate(rs.getDate(5+offset));
         x.setAddBy(rs.getString(6+offset));
         x.setAddDate(rs.getTimestamp(7+offset));
         x.setModBy(rs.getString(8+offset));
         x.setModDate(rs.getTimestamp(9+offset));
         x.setRecievedDistSku(rs.getString(10+offset));
         x.setRecievedDistUom(rs.getString(11+offset));
         x.setRecievedDistPack(rs.getString(12+offset));
         return x;
    }

    /**
    *@Returns a count of the number of columns the ReturnRequestDetailData Object represents.
    */
    public int getColumnCount(){
        return 12;
    }

    /**
     * Gets a ReturnRequestDetailDataVector object that consists
     * of ReturnRequestDetailData objects that match the supplied
     * criteria.
     * @param pCon An open database connection.
     * @param pCriteria A DBCriteria with the SQL 'where clause'
     * @param pMaxRows the maximum number of rows to return.
     * @return new ReturnRequestDetailDataVector()
     * @throws            SQLException
     */
    public static ReturnRequestDetailDataVector select(Connection pCon, DBCriteria pCriteria, int pMaxRows)
        throws SQLException{
        StringBuffer sqlBuf;
        Collection otherTables = pCriteria.getJoinTables();
        String where;
        if(otherTables == null || otherTables.isEmpty()){
                sqlBuf = new StringBuffer("SELECT RETURN_REQUEST_DETAIL_ID,RETURN_REQUEST_ID,ORDER_ITEM_ID,QUANTITY_RETURNED,PICKUP_DATE,ADD_BY,ADD_DATE,MOD_BY,MOD_DATE,RECIEVED_DIST_SKU,RECIEVED_DIST_UOM,RECIEVED_DIST_PACK FROM CLW_RETURN_REQUEST_DETAIL");
                where = pCriteria.getSqlClause();
        }else{
                sqlBuf = new StringBuffer("SELECT CLW_RETURN_REQUEST_DETAIL.RETURN_REQUEST_DETAIL_ID,CLW_RETURN_REQUEST_DETAIL.RETURN_REQUEST_ID,CLW_RETURN_REQUEST_DETAIL.ORDER_ITEM_ID,CLW_RETURN_REQUEST_DETAIL.QUANTITY_RETURNED,CLW_RETURN_REQUEST_DETAIL.PICKUP_DATE,CLW_RETURN_REQUEST_DETAIL.ADD_BY,CLW_RETURN_REQUEST_DETAIL.ADD_DATE,CLW_RETURN_REQUEST_DETAIL.MOD_BY,CLW_RETURN_REQUEST_DETAIL.MOD_DATE,CLW_RETURN_REQUEST_DETAIL.RECIEVED_DIST_SKU,CLW_RETURN_REQUEST_DETAIL.RECIEVED_DIST_UOM,CLW_RETURN_REQUEST_DETAIL.RECIEVED_DIST_PACK FROM CLW_RETURN_REQUEST_DETAIL");
                where = pCriteria.getSqlClause("CLW_RETURN_REQUEST_DETAIL");

                Iterator it = otherTables.iterator();
                while(it.hasNext()){
                        String otherTable = (String) it.next();
                        if(!CLW_RETURN_REQUEST_DETAIL.equals(otherTable)){
                        sqlBuf.append(",");
                        sqlBuf.append(otherTable);
				}
                }
        }

        if (where != null && !where.equals("")) {
            sqlBuf.append(" WHERE ");
            sqlBuf.append(where);
        }

        String sql = sqlBuf.toString();
        if (log.isDebugEnabled()) {
            log.debug("SQL: " + sql);
        }

        Statement stmt = pCon.createStatement();
        if ( pMaxRows > 0 ) {
            // Insure that only positive values are set.
              stmt.setMaxRows(pMaxRows);
        }
        ResultSet rs=stmt.executeQuery(sql);
        ReturnRequestDetailDataVector v = new ReturnRequestDetailDataVector();
        while (rs.next()) {
            ReturnRequestDetailData x = ReturnRequestDetailData.createValue();
            
            x.setReturnRequestDetailId(rs.getInt(1));
            x.setReturnRequestId(rs.getInt(2));
            x.setOrderItemId(rs.getInt(3));
            x.setQuantityReturned(rs.getInt(4));
            x.setPickupDate(rs.getDate(5));
            x.setAddBy(rs.getString(6));
            x.setAddDate(rs.getTimestamp(7));
            x.setModBy(rs.getString(8));
            x.setModDate(rs.getTimestamp(9));
            x.setRecievedDistSku(rs.getString(10));
            x.setRecievedDistUom(rs.getString(11));
            x.setRecievedDistPack(rs.getString(12));
            v.add(x);
        }

        rs.close();
        stmt.close();

        return v;
    }

    /**
     * Gets a ReturnRequestDetailDataVector object that consists
     * of ReturnRequestDetailData objects with the keys requested.
     * @param pCon An open database connection.
     * @param pIdVector A collection of keys for ReturnRequestDetailData
     * to retrieve from the database (i.e. select 'IN' pIdVector)
     * @return new ReturnRequestDetailDataVector()
     * @throws            SQLException
     */
    public static ReturnRequestDetailDataVector select(Connection pCon, IdVector pIdVector)
        throws SQLException{
        ReturnRequestDetailDataVector v = new ReturnRequestDetailDataVector();
        StringBuffer sqlBuf = new StringBuffer("SELECT RETURN_REQUEST_DETAIL_ID,RETURN_REQUEST_ID,ORDER_ITEM_ID,QUANTITY_RETURNED,PICKUP_DATE,ADD_BY,ADD_DATE,MOD_BY,MOD_DATE,RECIEVED_DIST_SKU,RECIEVED_DIST_UOM,RECIEVED_DIST_PACK FROM CLW_RETURN_REQUEST_DETAIL WHERE RETURN_REQUEST_DETAIL_ID IN (");

        if ( pIdVector.size() > 0 ) {
            sqlBuf.append(pIdVector.get(0).toString());
            int vecsize = pIdVector.size();
            for ( int idx = 1; idx < vecsize; idx++ ) {
                sqlBuf.append("," + pIdVector.get(idx).toString());
            }
            sqlBuf.append(")");


            String sql = sqlBuf.toString();
            if (log.isDebugEnabled()) {
                log.debug("SQL: " + sql);
            }

            Statement stmt = pCon.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            ReturnRequestDetailData x=null;
            while (rs.next()) {
                // build the object
                x=ReturnRequestDetailData.createValue();
                
                x.setReturnRequestDetailId(rs.getInt(1));
                x.setReturnRequestId(rs.getInt(2));
                x.setOrderItemId(rs.getInt(3));
                x.setQuantityReturned(rs.getInt(4));
                x.setPickupDate(rs.getDate(5));
                x.setAddBy(rs.getString(6));
                x.setAddDate(rs.getTimestamp(7));
                x.setModBy(rs.getString(8));
                x.setModDate(rs.getTimestamp(9));
                x.setRecievedDistSku(rs.getString(10));
                x.setRecievedDistUom(rs.getString(11));
                x.setRecievedDistPack(rs.getString(12));
                v.add(x);
            }

            rs.close();
            stmt.close();
        }

        return v;
    }

    /**
     * Gets a ReturnRequestDetailDataVector object of all
     * ReturnRequestDetailData objects in the database.
     * @param pCon An open database connection.
     * @return new ReturnRequestDetailDataVector()
     * @throws            SQLException
     */
    public static ReturnRequestDetailDataVector selectAll(Connection pCon)
        throws SQLException{
        String sql = "SELECT RETURN_REQUEST_DETAIL_ID,RETURN_REQUEST_ID,ORDER_ITEM_ID,QUANTITY_RETURNED,PICKUP_DATE,ADD_BY,ADD_DATE,MOD_BY,MOD_DATE,RECIEVED_DIST_SKU,RECIEVED_DIST_UOM,RECIEVED_DIST_PACK FROM CLW_RETURN_REQUEST_DETAIL";

        if (log.isDebugEnabled()) {
            log.debug("SQL: " + sql);
        }

        Statement stmt = pCon.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        ReturnRequestDetailDataVector v = new ReturnRequestDetailDataVector();
        ReturnRequestDetailData x = null;
        while (rs.next()) {
            // build the object
            x = ReturnRequestDetailData.createValue();
            
            x.setReturnRequestDetailId(rs.getInt(1));
            x.setReturnRequestId(rs.getInt(2));
            x.setOrderItemId(rs.getInt(3));
            x.setQuantityReturned(rs.getInt(4));
            x.setPickupDate(rs.getDate(5));
            x.setAddBy(rs.getString(6));
            x.setAddDate(rs.getTimestamp(7));
            x.setModBy(rs.getString(8));
            x.setModDate(rs.getTimestamp(9));
            x.setRecievedDistSku(rs.getString(10));
            x.setRecievedDistUom(rs.getString(11));
            x.setRecievedDistPack(rs.getString(12));

            v.add(x);
        }

        rs.close();
        stmt.close();

        return v;
    }

    /**
     * Gets an IdVector of Integers representing the Ids of the matching
     * ReturnRequestDetailData objects in the database.
     * @param pCon An open database connection.
     * @param pCriteria A DBCriteria with the SQL 'where clause'
     * @return new IdVector()
     * @throws            SQLException
     */
    public static IdVector selectIdOnly(Connection pCon, DBCriteria pCriteria)
        throws SQLException{
        StringBuffer sqlBuf = new StringBuffer("SELECT RETURN_REQUEST_DETAIL_ID FROM CLW_RETURN_REQUEST_DETAIL");
        String where = pCriteria.getSqlClause();
        if (where != null && !where.equals("")) {
            sqlBuf.append(" WHERE ");
            sqlBuf.append(where);
        }

        String sql = sqlBuf.toString();
        if (log.isDebugEnabled()) {
            log.debug("SQL: " + sql);
        }

        Statement stmt = pCon.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        IdVector v = new IdVector();
        while (rs.next()) {
            Integer x = new Integer(rs.getInt(1));
            v.add(x);
        }

        rs.close();
        stmt.close();

        return v;
    }

    /**
     * Gets an IdVector of Integers representing the Ids of requested
     * objects in the database.
     * @param pCon An open database connection.
     * @param pIdName A column name
     * @param pCriteria A DBCriteria with the SQL 'where clause'
     * @return new IdVector()
     * @throws            SQLException
     */
    public static IdVector selectIdOnly(Connection pCon, String pIdName, DBCriteria pCriteria)
        throws SQLException{
        StringBuffer sqlBuf = new StringBuffer("SELECT DISTINCT "+pIdName+" FROM CLW_RETURN_REQUEST_DETAIL");
        String where = pCriteria.getSqlClause();
        if (where != null && !where.equals("")) {
            sqlBuf.append(" WHERE ");
            sqlBuf.append(where);
        }

        String sql = sqlBuf.toString();
        if (log.isDebugEnabled()) {
            log.debug("SQL: " + sql);
        }

        Statement stmt = pCon.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        IdVector v = new IdVector();
        while (rs.next()) {
            Integer x = new Integer(rs.getInt(1));
            v.add(x);
        }

        rs.close();
        stmt.close();

        return v;
    }


    /**
     * Gets an sql statement to request ids of
     * objects in the database.
     * @param pIdName A column name
     * @param pCriteria A DBCriteria with the SQL 'where clause'
     * @return String
     */
    public static String getSqlSelectIdOnly(String pIdName, DBCriteria pCriteria)
    {
        StringBuffer sqlBuf = new StringBuffer("SELECT DISTINCT "+pIdName+" FROM CLW_RETURN_REQUEST_DETAIL");
        String where = pCriteria.getSqlClause();
        if (where != null && !where.equals("")) {
            sqlBuf.append(" WHERE ");
            sqlBuf.append(where);
        }

        String sql = sqlBuf.toString();
        if (log.isDebugEnabled()) {
            log.debug("SQL text: " + sql);
        }

        return sql;
    }

    /**
     * Inserts a ReturnRequestDetailData object into the database.
     * @param pCon  An open database connection.
     * @param pData  A ReturnRequestDetailData object to insert.
     * The object id will be set to the one generated.  The "AddDate" and
     * "ModDate" fields will be set to the current date. 
     * @return new ReturnRequestDetailData() with the generated
     *         key set
     * @throws            SQLException
     */
    public static ReturnRequestDetailData insert(Connection pCon, ReturnRequestDetailData pData)
        throws SQLException {

        if (log.isDebugEnabled()) {
            log.debug("SELECT CLW_RETURN_REQUEST_DETAIL_SEQ.NEXTVAL FROM DUAL");
        }
        String exceptionMessage=null;
        Statement stmt = pCon.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT CLW_RETURN_REQUEST_DETAIL_SEQ.NEXTVAL FROM DUAL");
        rs.next();
        pData.setReturnRequestDetailId(rs.getInt(1));
        stmt.close();

        String sql = "INSERT INTO CLW_RETURN_REQUEST_DETAIL (RETURN_REQUEST_DETAIL_ID,RETURN_REQUEST_ID,ORDER_ITEM_ID,QUANTITY_RETURNED,PICKUP_DATE,ADD_BY,ADD_DATE,MOD_BY,MOD_DATE,RECIEVED_DIST_SKU,RECIEVED_DIST_UOM,RECIEVED_DIST_PACK) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)"; PreparedStatement pstmt = pCon.prepareStatement(sql);

        
        java.util.Date current = new java.util.Date(System.currentTimeMillis());
        pData.setAddDate(current);
        pData.setModDate(current);

        pstmt.setInt(1,pData.getReturnRequestDetailId());
        if (pData.getReturnRequestId() == 0) {
            pstmt.setNull(2, java.sql.Types.INTEGER);
        } else {
            pstmt.setInt(2,pData.getReturnRequestId());
        }

        pstmt.setInt(3,pData.getOrderItemId());
        pstmt.setInt(4,pData.getQuantityReturned());
        pstmt.setDate(5,DBAccess.toSQLDate(pData.getPickupDate()));
        pstmt.setString(6,pData.getAddBy());
        pstmt.setTimestamp(7,DBAccess.toSQLTimestamp(pData.getAddDate()));
        pstmt.setString(8,pData.getModBy());
        pstmt.setTimestamp(9,DBAccess.toSQLTimestamp(pData.getModDate()));
        pstmt.setString(10,pData.getRecievedDistSku());
        pstmt.setString(11,pData.getRecievedDistUom());
        pstmt.setString(12,pData.getRecievedDistPack());

        if (log.isDebugEnabled()) {
            log.debug("SQL:   RETURN_REQUEST_DETAIL_ID="+pData.getReturnRequestDetailId());
            log.debug("SQL:   RETURN_REQUEST_ID="+pData.getReturnRequestId());
            log.debug("SQL:   ORDER_ITEM_ID="+pData.getOrderItemId());
            log.debug("SQL:   QUANTITY_RETURNED="+pData.getQuantityReturned());
            log.debug("SQL:   PICKUP_DATE="+pData.getPickupDate());
            log.debug("SQL:   ADD_BY="+pData.getAddBy());
            log.debug("SQL:   ADD_DATE="+pData.getAddDate());
            log.debug("SQL:   MOD_BY="+pData.getModBy());
            log.debug("SQL:   MOD_DATE="+pData.getModDate());
            log.debug("SQL:   RECIEVED_DIST_SKU="+pData.getRecievedDistSku());
            log.debug("SQL:   RECIEVED_DIST_UOM="+pData.getRecievedDistUom());
            log.debug("SQL:   RECIEVED_DIST_PACK="+pData.getRecievedDistPack());
            log.debug("SQL: " + sql);
        }
        try {
        pstmt.executeUpdate();
        pData.setDirty(false);
        }
        catch(SQLException e){
        pData.setReturnRequestDetailId(0);
        exceptionMessage=e.getMessage();
        }
        finally{
        pstmt.close();
        }

        if(exceptionMessage!=null) {
                 throw new SQLException(exceptionMessage);
        }

        return pData;
    }

    /**
     * Updates a ReturnRequestDetailData object in the database.
     * @param pCon  An open database connection.
     * @param pData  A ReturnRequestDetailData object to update. 
     * The "ModDate" field of the object will be set to the current date.
     * @return int Number of rows updated (0 or 1).
     * @throws            SQLException
     */
    public static int update(Connection pCon, ReturnRequestDetailData pData)
        throws SQLException {

        int n = 0;

        String sql = "UPDATE CLW_RETURN_REQUEST_DETAIL SET RETURN_REQUEST_ID = ?,ORDER_ITEM_ID = ?,QUANTITY_RETURNED = ?,PICKUP_DATE = ?,ADD_BY = ?,ADD_DATE = ?,MOD_BY = ?,MOD_DATE = ?,RECIEVED_DIST_SKU = ?,RECIEVED_DIST_UOM = ?,RECIEVED_DIST_PACK = ? WHERE RETURN_REQUEST_DETAIL_ID = ?";

        PreparedStatement pstmt = pCon.prepareStatement(sql);

        
        pData.setModDate(new java.util.Date(System.currentTimeMillis()));

        int i = 1;
        
        if (pData.getReturnRequestId() == 0) {
            pstmt.setNull(i++, java.sql.Types.INTEGER);
        } else {
            pstmt.setInt(i++,pData.getReturnRequestId());
        }

        pstmt.setInt(i++,pData.getOrderItemId());
        pstmt.setInt(i++,pData.getQuantityReturned());
        pstmt.setDate(i++,DBAccess.toSQLDate(pData.getPickupDate()));
        pstmt.setString(i++,pData.getAddBy());
        pstmt.setTimestamp(i++,DBAccess.toSQLTimestamp(pData.getAddDate()));
        pstmt.setString(i++,pData.getModBy());
        pstmt.setTimestamp(i++,DBAccess.toSQLTimestamp(pData.getModDate()));
        pstmt.setString(i++,pData.getRecievedDistSku());
        pstmt.setString(i++,pData.getRecievedDistUom());
        pstmt.setString(i++,pData.getRecievedDistPack());
        pstmt.setInt(i++,pData.getReturnRequestDetailId());

        if (log.isDebugEnabled()) {
            log.debug("SQL:   RETURN_REQUEST_ID="+pData.getReturnRequestId());
            log.debug("SQL:   ORDER_ITEM_ID="+pData.getOrderItemId());
            log.debug("SQL:   QUANTITY_RETURNED="+pData.getQuantityReturned());
            log.debug("SQL:   PICKUP_DATE="+pData.getPickupDate());
            log.debug("SQL:   ADD_BY="+pData.getAddBy());
            log.debug("SQL:   ADD_DATE="+pData.getAddDate());
            log.debug("SQL:   MOD_BY="+pData.getModBy());
            log.debug("SQL:   MOD_DATE="+pData.getModDate());
            log.debug("SQL:   RECIEVED_DIST_SKU="+pData.getRecievedDistSku());
            log.debug("SQL:   RECIEVED_DIST_UOM="+pData.getRecievedDistUom());
            log.debug("SQL:   RECIEVED_DIST_PACK="+pData.getRecievedDistPack());
            log.debug("SQL: " + sql);
        }

        n = pstmt.executeUpdate();
        pstmt.close();

        pData.setDirty(false);

        return n;
    }

    /**
     * Deletes a ReturnRequestDetailData object with the specified
     * key from the database.
     * @param pCon  An open database connection.
     * @param pReturnRequestDetailId Key of object to be deleted.
     * @return int Number of rows deleted (0 or 1).
     * @throws            SQLException
     */
    public static int remove(Connection pCon, int pReturnRequestDetailId)
        throws SQLException{
        int n = 0;
        String sql="DELETE FROM CLW_RETURN_REQUEST_DETAIL WHERE RETURN_REQUEST_DETAIL_ID = " + pReturnRequestDetailId;

        if (log.isDebugEnabled()) {
            log.debug("SQL: " + sql);
        }

        Statement stmt = pCon.createStatement();
        n = stmt.executeUpdate(sql);
        stmt.close();

        return n;
     }

    /**
     * Deletes ReturnRequestDetailData objects that match the specified criteria.
     * @param pCon  An open database connection.
     * @param pCriteria A DBCriteria with the SQL 'where clause'
     * @return int Number of rows deleted.
     * @throws            SQLException
     */
    public static int remove(Connection pCon, DBCriteria pCriteria)
        throws SQLException {
        int n = 0;
        StringBuffer sqlBuf = new StringBuffer("DELETE FROM CLW_RETURN_REQUEST_DETAIL");
        String where = pCriteria.getSqlClause();
        if (where != null && !where.equals("")) {
            sqlBuf.append(" WHERE ");
            sqlBuf.append(where);
        }

        String sql = sqlBuf.toString();
        if (log.isDebugEnabled()) {
            log.debug("SQL: " + sql);
        }

        Statement stmt = pCon.createStatement();
        n = stmt.executeUpdate(sql);
        stmt.close();

        return n;
    }

    /**
     * Inserts a ReturnRequestDetailData log object into the database.
     * @param pCon  An open database connection.
     * @param pData  A ReturnRequestDetailData object to insert
     * @param pMillis current time in milliseconds
     * @param pAction action made (I, U, D)
     * @param pStatus record status (O, N)
     * @throws            SQLException
     */
    public static void insertLog(Connection pCon, ReturnRequestDetailData pData, long pMillis, String pAction, String pStatus)
        throws SQLException {

        String sql = "INSERT INTO LCLW_RETURN_REQUEST_DETAIL (LOG_DATE_MS,LOG_DATE,ACTION, STATUS,"+
          "RETURN_REQUEST_DETAIL_ID,RETURN_REQUEST_ID,ORDER_ITEM_ID,QUANTITY_RETURNED,PICKUP_DATE,ADD_BY,ADD_DATE,MOD_BY,MOD_DATE,RECIEVED_DIST_SKU,RECIEVED_DIST_UOM,RECIEVED_DIST_PACK) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement pstmt = pCon.prepareStatement(sql);
        
        pstmt.setLong(1,pMillis);
        pstmt.setTimestamp(2,DBAccess.toSQLTimestamp(new java.util.Date(pMillis)));
        pstmt.setString(3,pAction);
        pstmt.setString(4,pStatus);

        pstmt.setInt(1+4,pData.getReturnRequestDetailId());
        if (pData.getReturnRequestId() == 0) {
            pstmt.setNull(2+4, java.sql.Types.INTEGER);
        } else {
            pstmt.setInt(2+4,pData.getReturnRequestId());
        }

        pstmt.setInt(3+4,pData.getOrderItemId());
        pstmt.setInt(4+4,pData.getQuantityReturned());
        pstmt.setDate(5+4,DBAccess.toSQLDate(pData.getPickupDate()));
        pstmt.setString(6+4,pData.getAddBy());
        pstmt.setTimestamp(7+4,DBAccess.toSQLTimestamp(pData.getAddDate()));
        pstmt.setString(8+4,pData.getModBy());
        pstmt.setTimestamp(9+4,DBAccess.toSQLTimestamp(pData.getModDate()));
        pstmt.setString(10+4,pData.getRecievedDistSku());
        pstmt.setString(11+4,pData.getRecievedDistUom());
        pstmt.setString(12+4,pData.getRecievedDistPack());


        pstmt.executeUpdate();
        pstmt.close();
    }




///////////////////////////////////////////////
    /**
     * Inserts a ReturnRequestDetailData object into the database.
     * @param pCon  An open database connection.
     * @param pData  A ReturnRequestDetailData object to insert.
     * The object id will be set to the one generated.  The "AddDate" and
     * "ModDate" fields will be set to the current date. 
     * @param pLogFl  Creates record in log table if true
     * @return new ReturnRequestDetailData() with the generated
     *         key set
     * @throws            SQLException
     */
    public static ReturnRequestDetailData insert(Connection pCon, ReturnRequestDetailData pData, boolean pLogFl)
        throws SQLException {
        pData = insert(pCon, pData);

        if(pLogFl) {
          long millis = System.currentTimeMillis();
          insertLog(pCon, pData, millis, "I", "N");
        }

        return pData;
    }

    /**
     * Updates a ReturnRequestDetailData object in the database.
     * @param pCon  An open database connection.
     * @param pData  A ReturnRequestDetailData object to update. 
     * The "ModDate" field of the object will be set to the current date.
     * @param pLogFl  Creates record in log table if true
     * @return int Number of rows updated (0 or 1).
     * @throws            SQLException
     */
    public static int update(Connection pCon, ReturnRequestDetailData pData, boolean pLogFl)
        throws SQLException {
        ReturnRequestDetailData oldData = null;
        if(pLogFl) {
          int id = pData.getReturnRequestDetailId();
          try {
          oldData = ReturnRequestDetailDataAccess.select(pCon,id);
          } catch(DataNotFoundException exc) {}
        }
        int n = update(pCon,pData);
        if(pLogFl) {
          long millis = System.currentTimeMillis();
          insertLog(pCon, oldData, millis, "U", "O");
          insertLog(pCon, pData, millis, "U", "N");
        }
        return n;
    }

    /**
     * Deletes a ReturnRequestDetailData object with the specified
     * key from the database.
     * @param pCon  An open database connection.
     * @param pReturnRequestDetailId Key of object to be deleted.
     * @param pLogFl  Create record in log table if true
     * @return int Number of rows deleted (0 or 1).
     * @throws            SQLException
     */
    public static int remove(Connection pCon, int pReturnRequestDetailId, boolean pLogFl)
        throws SQLException{
        if(pLogFl){
          long millis = System.currentTimeMillis();
          java.util.Date rmDate = new java.util.Date(millis);
          java.text.SimpleDateFormat smf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          String oracleDate = "to_date('"+smf.format(rmDate)+"','YYYY-MM-DD HH24:MI:SS')";
          String sqlLog ="INSERT INTO LCLW_RETURN_REQUEST_DETAIL SELECT "+millis+ ","+oracleDate+",'D','O',d.* FROM CLW_RETURN_REQUEST_DETAIL d WHERE RETURN_REQUEST_DETAIL_ID = " + pReturnRequestDetailId;
          Statement stmt = pCon.createStatement();
          stmt.executeUpdate(sqlLog);
           stmt.close();
        }
        int n = remove(pCon,pReturnRequestDetailId);
        return n;
     }

    /**
     * Deletes ReturnRequestDetailData objects that match the specified criteria.
     * @param pCon  An open database connection.
     * @param pCriteria A DBCriteria with the SQL 'where clause'
     * @param pLogFl  Create record in log table if true
     * @return int Number of rows deleted.
     * @throws            SQLException
     */
    public static int remove(Connection pCon, DBCriteria pCriteria, boolean pLogFl)
        throws SQLException {
        if(pLogFl){
          long millis = System.currentTimeMillis();
          java.util.Date rmDate = new java.util.Date(millis);
          java.text.SimpleDateFormat smf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          String oracleDate = "to_date('"+smf.format(rmDate)+"','YYYY-MM-DD HH24:MI:SS')";
          StringBuffer sqlBuf =
             new StringBuffer("INSERT INTO LCLW_RETURN_REQUEST_DETAIL SELECT "+millis+ ","+oracleDate+",'D','O',d.* FROM CLW_RETURN_REQUEST_DETAIL d ");
          String where = pCriteria.getSqlClause();
          sqlBuf.append(" WHERE ");
          sqlBuf.append(where);

          Statement stmt = pCon.createStatement();
          stmt.executeUpdate(sqlBuf.toString());
          stmt.close();
        }
        int n = remove(pCon,pCriteria);
        return n;
    }
///////////////////////////////////////////////
}

