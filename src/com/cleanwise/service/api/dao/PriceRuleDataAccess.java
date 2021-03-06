
/* DO NOT EDIT - Generated code from XSL file DataAccess.xsl */

package com.cleanwise.service.api.dao;

/**
 * Title:        PriceRuleDataAccess
 * Description:  This class is used to build access methods to the CLW_PRICE_RULE table.
 * Purpose:
 * Copyright:    Copyright (c) 2001
 * Company:      CleanWise, Inc.
 * @author       Generated Code from XSL file DataAccess.xsl
 */

import com.cleanwise.service.api.value.PriceRuleData;
import com.cleanwise.service.api.value.PriceRuleDataVector;
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
 * <code>PriceRuleDataAccess</code>
 */
public class PriceRuleDataAccess extends DataAccessImpl
{
    private static Category log = Category.getInstance(PriceRuleDataAccess.class.getName());

    /** <code>CLW_PRICE_RULE</code> table name */
	/* Primary key: PRICE_RULE_ID */
	
    public static final String CLW_PRICE_RULE = "CLW_PRICE_RULE";
    
    /** <code>PRICE_RULE_ID</code> PRICE_RULE_ID column of table CLW_PRICE_RULE */
    public static final String PRICE_RULE_ID = "PRICE_RULE_ID";
    /** <code>SHORT_DESC</code> SHORT_DESC column of table CLW_PRICE_RULE */
    public static final String SHORT_DESC = "SHORT_DESC";
    /** <code>PRICE_RULE_TYPE_CD</code> PRICE_RULE_TYPE_CD column of table CLW_PRICE_RULE */
    public static final String PRICE_RULE_TYPE_CD = "PRICE_RULE_TYPE_CD";
    /** <code>PRICE_RULE_STATUS_CD</code> PRICE_RULE_STATUS_CD column of table CLW_PRICE_RULE */
    public static final String PRICE_RULE_STATUS_CD = "PRICE_RULE_STATUS_CD";
    /** <code>EFF_DATE</code> EFF_DATE column of table CLW_PRICE_RULE */
    public static final String EFF_DATE = "EFF_DATE";
    /** <code>EXP_DATE</code> EXP_DATE column of table CLW_PRICE_RULE */
    public static final String EXP_DATE = "EXP_DATE";
    /** <code>ADD_DATE</code> ADD_DATE column of table CLW_PRICE_RULE */
    public static final String ADD_DATE = "ADD_DATE";
    /** <code>ADD_BY</code> ADD_BY column of table CLW_PRICE_RULE */
    public static final String ADD_BY = "ADD_BY";
    /** <code>MOD_DATE</code> MOD_DATE column of table CLW_PRICE_RULE */
    public static final String MOD_DATE = "MOD_DATE";
    /** <code>MOD_BY</code> MOD_BY column of table CLW_PRICE_RULE */
    public static final String MOD_BY = "MOD_BY";
    /** <code>BUS_ENTITY_ID</code> BUS_ENTITY_ID column of table CLW_PRICE_RULE */
    public static final String BUS_ENTITY_ID = "BUS_ENTITY_ID";

    /**
     * Constructor.
     */
    public PriceRuleDataAccess()
    {
    }

    /**
     * Gets a PriceRuleData object with the specified
     * key from the database.
     * @param pCon An open database connection.
     * @param pPriceRuleId The key requested.
     * @return new PriceRuleData()
     * @throws            SQLException
     */
    public static PriceRuleData select(Connection pCon, int pPriceRuleId)
        throws SQLException, DataNotFoundException {
        PriceRuleData x=null;
        String sql="SELECT PRICE_RULE_ID,SHORT_DESC,PRICE_RULE_TYPE_CD,PRICE_RULE_STATUS_CD,EFF_DATE,EXP_DATE,ADD_DATE,ADD_BY,MOD_DATE,MOD_BY,BUS_ENTITY_ID FROM CLW_PRICE_RULE WHERE PRICE_RULE_ID = ?";

        if (log.isDebugEnabled()) {
            log.debug("SQL: pPriceRuleId=" + pPriceRuleId);
            log.debug("SQL: " + sql);
        }

        PreparedStatement stmt = pCon.prepareStatement(sql);
        stmt.setInt(1,pPriceRuleId);
        ResultSet rs=stmt.executeQuery();
        if (rs.next()) {
            // build the object
            x=PriceRuleData.createValue();
            
            x.setPriceRuleId(rs.getInt(1));
            x.setShortDesc(rs.getString(2));
            x.setPriceRuleTypeCd(rs.getString(3));
            x.setPriceRuleStatusCd(rs.getString(4));
            x.setEffDate(rs.getDate(5));
            x.setExpDate(rs.getDate(6));
            x.setAddDate(rs.getTimestamp(7));
            x.setAddBy(rs.getString(8));
            x.setModDate(rs.getTimestamp(9));
            x.setModBy(rs.getString(10));
            x.setBusEntityId(rs.getInt(11));

        } else {
            rs.close();
            stmt.close();
            throw new DataNotFoundException("PRICE_RULE_ID :" + pPriceRuleId);
        }

        rs.close();
        stmt.close();

        return x;
    }

    /**
     * Gets a PriceRuleDataVector object that consists
     * of PriceRuleData objects that match the supplied
     * criteria.
     * @param pCon An open database connection.
     * @param pCriteria A DBCriteria with the SQL 'where clause'
     * @return new PriceRuleDataVector()
     * @throws            SQLException
     */
    public static PriceRuleDataVector select(Connection pCon, DBCriteria pCriteria)
        throws SQLException{
        // Specify the maximum row limit to zero, unlimited size.
        return select(pCon, pCriteria, 0);
    }

    /**
    *@Returns a String of the columns suitable for using in a sql statement that may then be parsed into a PriceRuleData Object
    *using the parseResultSet method.
    */
    public String getSelectColumns(){
        return "CLW_PRICE_RULE.PRICE_RULE_ID,CLW_PRICE_RULE.SHORT_DESC,CLW_PRICE_RULE.PRICE_RULE_TYPE_CD,CLW_PRICE_RULE.PRICE_RULE_STATUS_CD,CLW_PRICE_RULE.EFF_DATE,CLW_PRICE_RULE.EXP_DATE,CLW_PRICE_RULE.ADD_DATE,CLW_PRICE_RULE.ADD_BY,CLW_PRICE_RULE.MOD_DATE,CLW_PRICE_RULE.MOD_BY,CLW_PRICE_RULE.BUS_ENTITY_ID";
    }


    /**
    *Parses a result set into a value object.  Uses the position of the columns as its key so this method should only
    *be used in conjunction with the getSelectColumns() method or the wrong data will be parsed into the wrong properties.
    *The result set is not incremented, so calls to this method leave the resultset object unchanged.
    *@param ResultSet an open result set.
    *@returns a populated PriceRuleData Object.
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
    *@returns a populated PriceRuleData Object.
    *@throws SQLException
    */
    public com.cleanwise.service.api.framework.ValueObject parseResultSet(ResultSet rs, int offset) throws SQLException{
         // build the object
         PriceRuleData x = PriceRuleData.createValue();
         
         x.setPriceRuleId(rs.getInt(1+offset));
         x.setShortDesc(rs.getString(2+offset));
         x.setPriceRuleTypeCd(rs.getString(3+offset));
         x.setPriceRuleStatusCd(rs.getString(4+offset));
         x.setEffDate(rs.getDate(5+offset));
         x.setExpDate(rs.getDate(6+offset));
         x.setAddDate(rs.getTimestamp(7+offset));
         x.setAddBy(rs.getString(8+offset));
         x.setModDate(rs.getTimestamp(9+offset));
         x.setModBy(rs.getString(10+offset));
         x.setBusEntityId(rs.getInt(11+offset));
         return x;
    }

    /**
    *@Returns a count of the number of columns the PriceRuleData Object represents.
    */
    public int getColumnCount(){
        return 11;
    }

    /**
     * Gets a PriceRuleDataVector object that consists
     * of PriceRuleData objects that match the supplied
     * criteria.
     * @param pCon An open database connection.
     * @param pCriteria A DBCriteria with the SQL 'where clause'
     * @param pMaxRows the maximum number of rows to return.
     * @return new PriceRuleDataVector()
     * @throws            SQLException
     */
    public static PriceRuleDataVector select(Connection pCon, DBCriteria pCriteria, int pMaxRows)
        throws SQLException{
        StringBuffer sqlBuf;
        Collection otherTables = pCriteria.getJoinTables();
        String where;
        if(otherTables == null || otherTables.isEmpty()){
                sqlBuf = new StringBuffer("SELECT PRICE_RULE_ID,SHORT_DESC,PRICE_RULE_TYPE_CD,PRICE_RULE_STATUS_CD,EFF_DATE,EXP_DATE,ADD_DATE,ADD_BY,MOD_DATE,MOD_BY,BUS_ENTITY_ID FROM CLW_PRICE_RULE");
                where = pCriteria.getSqlClause();
        }else{
                sqlBuf = new StringBuffer("SELECT CLW_PRICE_RULE.PRICE_RULE_ID,CLW_PRICE_RULE.SHORT_DESC,CLW_PRICE_RULE.PRICE_RULE_TYPE_CD,CLW_PRICE_RULE.PRICE_RULE_STATUS_CD,CLW_PRICE_RULE.EFF_DATE,CLW_PRICE_RULE.EXP_DATE,CLW_PRICE_RULE.ADD_DATE,CLW_PRICE_RULE.ADD_BY,CLW_PRICE_RULE.MOD_DATE,CLW_PRICE_RULE.MOD_BY,CLW_PRICE_RULE.BUS_ENTITY_ID FROM CLW_PRICE_RULE");
                where = pCriteria.getSqlClause("CLW_PRICE_RULE");

                Iterator it = otherTables.iterator();
                while(it.hasNext()){
                        String otherTable = (String) it.next();
                        if(!CLW_PRICE_RULE.equals(otherTable)){
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
        PriceRuleDataVector v = new PriceRuleDataVector();
        while (rs.next()) {
            PriceRuleData x = PriceRuleData.createValue();
            
            x.setPriceRuleId(rs.getInt(1));
            x.setShortDesc(rs.getString(2));
            x.setPriceRuleTypeCd(rs.getString(3));
            x.setPriceRuleStatusCd(rs.getString(4));
            x.setEffDate(rs.getDate(5));
            x.setExpDate(rs.getDate(6));
            x.setAddDate(rs.getTimestamp(7));
            x.setAddBy(rs.getString(8));
            x.setModDate(rs.getTimestamp(9));
            x.setModBy(rs.getString(10));
            x.setBusEntityId(rs.getInt(11));
            v.add(x);
        }

        rs.close();
        stmt.close();

        return v;
    }

    /**
     * Gets a PriceRuleDataVector object that consists
     * of PriceRuleData objects with the keys requested.
     * @param pCon An open database connection.
     * @param pIdVector A collection of keys for PriceRuleData
     * to retrieve from the database (i.e. select 'IN' pIdVector)
     * @return new PriceRuleDataVector()
     * @throws            SQLException
     */
    public static PriceRuleDataVector select(Connection pCon, IdVector pIdVector)
        throws SQLException{
        PriceRuleDataVector v = new PriceRuleDataVector();
        StringBuffer sqlBuf = new StringBuffer("SELECT PRICE_RULE_ID,SHORT_DESC,PRICE_RULE_TYPE_CD,PRICE_RULE_STATUS_CD,EFF_DATE,EXP_DATE,ADD_DATE,ADD_BY,MOD_DATE,MOD_BY,BUS_ENTITY_ID FROM CLW_PRICE_RULE WHERE PRICE_RULE_ID IN (");

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
            PriceRuleData x=null;
            while (rs.next()) {
                // build the object
                x=PriceRuleData.createValue();
                
                x.setPriceRuleId(rs.getInt(1));
                x.setShortDesc(rs.getString(2));
                x.setPriceRuleTypeCd(rs.getString(3));
                x.setPriceRuleStatusCd(rs.getString(4));
                x.setEffDate(rs.getDate(5));
                x.setExpDate(rs.getDate(6));
                x.setAddDate(rs.getTimestamp(7));
                x.setAddBy(rs.getString(8));
                x.setModDate(rs.getTimestamp(9));
                x.setModBy(rs.getString(10));
                x.setBusEntityId(rs.getInt(11));
                v.add(x);
            }

            rs.close();
            stmt.close();
        }

        return v;
    }

    /**
     * Gets a PriceRuleDataVector object of all
     * PriceRuleData objects in the database.
     * @param pCon An open database connection.
     * @return new PriceRuleDataVector()
     * @throws            SQLException
     */
    public static PriceRuleDataVector selectAll(Connection pCon)
        throws SQLException{
        String sql = "SELECT PRICE_RULE_ID,SHORT_DESC,PRICE_RULE_TYPE_CD,PRICE_RULE_STATUS_CD,EFF_DATE,EXP_DATE,ADD_DATE,ADD_BY,MOD_DATE,MOD_BY,BUS_ENTITY_ID FROM CLW_PRICE_RULE";

        if (log.isDebugEnabled()) {
            log.debug("SQL: " + sql);
        }

        Statement stmt = pCon.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        PriceRuleDataVector v = new PriceRuleDataVector();
        PriceRuleData x = null;
        while (rs.next()) {
            // build the object
            x = PriceRuleData.createValue();
            
            x.setPriceRuleId(rs.getInt(1));
            x.setShortDesc(rs.getString(2));
            x.setPriceRuleTypeCd(rs.getString(3));
            x.setPriceRuleStatusCd(rs.getString(4));
            x.setEffDate(rs.getDate(5));
            x.setExpDate(rs.getDate(6));
            x.setAddDate(rs.getTimestamp(7));
            x.setAddBy(rs.getString(8));
            x.setModDate(rs.getTimestamp(9));
            x.setModBy(rs.getString(10));
            x.setBusEntityId(rs.getInt(11));

            v.add(x);
        }

        rs.close();
        stmt.close();

        return v;
    }

    /**
     * Gets an IdVector of Integers representing the Ids of the matching
     * PriceRuleData objects in the database.
     * @param pCon An open database connection.
     * @param pCriteria A DBCriteria with the SQL 'where clause'
     * @return new IdVector()
     * @throws            SQLException
     */
    public static IdVector selectIdOnly(Connection pCon, DBCriteria pCriteria)
        throws SQLException{
        StringBuffer sqlBuf = new StringBuffer("SELECT PRICE_RULE_ID FROM CLW_PRICE_RULE");
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
        StringBuffer sqlBuf = new StringBuffer("SELECT DISTINCT "+pIdName+" FROM CLW_PRICE_RULE");
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
        StringBuffer sqlBuf = new StringBuffer("SELECT DISTINCT "+pIdName+" FROM CLW_PRICE_RULE");
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
     * Inserts a PriceRuleData object into the database.
     * @param pCon  An open database connection.
     * @param pData  A PriceRuleData object to insert.
     * The object id will be set to the one generated.  The "AddDate" and
     * "ModDate" fields will be set to the current date. 
     * @return new PriceRuleData() with the generated
     *         key set
     * @throws            SQLException
     */
    public static PriceRuleData insert(Connection pCon, PriceRuleData pData)
        throws SQLException {

        if (log.isDebugEnabled()) {
            log.debug("SELECT CLW_PRICE_RULE_SEQ.NEXTVAL FROM DUAL");
        }
        String exceptionMessage=null;
        Statement stmt = pCon.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT CLW_PRICE_RULE_SEQ.NEXTVAL FROM DUAL");
        rs.next();
        pData.setPriceRuleId(rs.getInt(1));
        stmt.close();

        String sql = "INSERT INTO CLW_PRICE_RULE (PRICE_RULE_ID,SHORT_DESC,PRICE_RULE_TYPE_CD,PRICE_RULE_STATUS_CD,EFF_DATE,EXP_DATE,ADD_DATE,ADD_BY,MOD_DATE,MOD_BY,BUS_ENTITY_ID) VALUES(?,?,?,?,?,?,?,?,?,?,?)"; PreparedStatement pstmt = pCon.prepareStatement(sql);

        
        java.util.Date current = new java.util.Date(System.currentTimeMillis());
        pData.setAddDate(current);
        pData.setModDate(current);

        pstmt.setInt(1,pData.getPriceRuleId());
        pstmt.setString(2,pData.getShortDesc());
        pstmt.setString(3,pData.getPriceRuleTypeCd());
        pstmt.setString(4,pData.getPriceRuleStatusCd());
        pstmt.setDate(5,DBAccess.toSQLDate(pData.getEffDate()));
        pstmt.setDate(6,DBAccess.toSQLDate(pData.getExpDate()));
        pstmt.setTimestamp(7,DBAccess.toSQLTimestamp(pData.getAddDate()));
        pstmt.setString(8,pData.getAddBy());
        pstmt.setTimestamp(9,DBAccess.toSQLTimestamp(pData.getModDate()));
        pstmt.setString(10,pData.getModBy());
        pstmt.setInt(11,pData.getBusEntityId());

        if (log.isDebugEnabled()) {
            log.debug("SQL:   PRICE_RULE_ID="+pData.getPriceRuleId());
            log.debug("SQL:   SHORT_DESC="+pData.getShortDesc());
            log.debug("SQL:   PRICE_RULE_TYPE_CD="+pData.getPriceRuleTypeCd());
            log.debug("SQL:   PRICE_RULE_STATUS_CD="+pData.getPriceRuleStatusCd());
            log.debug("SQL:   EFF_DATE="+pData.getEffDate());
            log.debug("SQL:   EXP_DATE="+pData.getExpDate());
            log.debug("SQL:   ADD_DATE="+pData.getAddDate());
            log.debug("SQL:   ADD_BY="+pData.getAddBy());
            log.debug("SQL:   MOD_DATE="+pData.getModDate());
            log.debug("SQL:   MOD_BY="+pData.getModBy());
            log.debug("SQL:   BUS_ENTITY_ID="+pData.getBusEntityId());
            log.debug("SQL: " + sql);
        }
        try {
        pstmt.executeUpdate();
        pData.setDirty(false);
        }
        catch(SQLException e){
        pData.setPriceRuleId(0);
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
     * Updates a PriceRuleData object in the database.
     * @param pCon  An open database connection.
     * @param pData  A PriceRuleData object to update. 
     * The "ModDate" field of the object will be set to the current date.
     * @return int Number of rows updated (0 or 1).
     * @throws            SQLException
     */
    public static int update(Connection pCon, PriceRuleData pData)
        throws SQLException {

        int n = 0;

        String sql = "UPDATE CLW_PRICE_RULE SET SHORT_DESC = ?,PRICE_RULE_TYPE_CD = ?,PRICE_RULE_STATUS_CD = ?,EFF_DATE = ?,EXP_DATE = ?,ADD_DATE = ?,ADD_BY = ?,MOD_DATE = ?,MOD_BY = ?,BUS_ENTITY_ID = ? WHERE PRICE_RULE_ID = ?";

        PreparedStatement pstmt = pCon.prepareStatement(sql);

        
        pData.setModDate(new java.util.Date(System.currentTimeMillis()));

        int i = 1;
        
        pstmt.setString(i++,pData.getShortDesc());
        pstmt.setString(i++,pData.getPriceRuleTypeCd());
        pstmt.setString(i++,pData.getPriceRuleStatusCd());
        pstmt.setDate(i++,DBAccess.toSQLDate(pData.getEffDate()));
        pstmt.setDate(i++,DBAccess.toSQLDate(pData.getExpDate()));
        pstmt.setTimestamp(i++,DBAccess.toSQLTimestamp(pData.getAddDate()));
        pstmt.setString(i++,pData.getAddBy());
        pstmt.setTimestamp(i++,DBAccess.toSQLTimestamp(pData.getModDate()));
        pstmt.setString(i++,pData.getModBy());
        pstmt.setInt(i++,pData.getBusEntityId());
        pstmt.setInt(i++,pData.getPriceRuleId());

        if (log.isDebugEnabled()) {
            log.debug("SQL:   SHORT_DESC="+pData.getShortDesc());
            log.debug("SQL:   PRICE_RULE_TYPE_CD="+pData.getPriceRuleTypeCd());
            log.debug("SQL:   PRICE_RULE_STATUS_CD="+pData.getPriceRuleStatusCd());
            log.debug("SQL:   EFF_DATE="+pData.getEffDate());
            log.debug("SQL:   EXP_DATE="+pData.getExpDate());
            log.debug("SQL:   ADD_DATE="+pData.getAddDate());
            log.debug("SQL:   ADD_BY="+pData.getAddBy());
            log.debug("SQL:   MOD_DATE="+pData.getModDate());
            log.debug("SQL:   MOD_BY="+pData.getModBy());
            log.debug("SQL:   BUS_ENTITY_ID="+pData.getBusEntityId());
            log.debug("SQL: " + sql);
        }

        n = pstmt.executeUpdate();
        pstmt.close();

        pData.setDirty(false);

        return n;
    }

    /**
     * Deletes a PriceRuleData object with the specified
     * key from the database.
     * @param pCon  An open database connection.
     * @param pPriceRuleId Key of object to be deleted.
     * @return int Number of rows deleted (0 or 1).
     * @throws            SQLException
     */
    public static int remove(Connection pCon, int pPriceRuleId)
        throws SQLException{
        int n = 0;
        String sql="DELETE FROM CLW_PRICE_RULE WHERE PRICE_RULE_ID = " + pPriceRuleId;

        if (log.isDebugEnabled()) {
            log.debug("SQL: " + sql);
        }

        Statement stmt = pCon.createStatement();
        n = stmt.executeUpdate(sql);
        stmt.close();

        return n;
     }

    /**
     * Deletes PriceRuleData objects that match the specified criteria.
     * @param pCon  An open database connection.
     * @param pCriteria A DBCriteria with the SQL 'where clause'
     * @return int Number of rows deleted.
     * @throws            SQLException
     */
    public static int remove(Connection pCon, DBCriteria pCriteria)
        throws SQLException {
        int n = 0;
        StringBuffer sqlBuf = new StringBuffer("DELETE FROM CLW_PRICE_RULE");
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
     * Inserts a PriceRuleData log object into the database.
     * @param pCon  An open database connection.
     * @param pData  A PriceRuleData object to insert
     * @param pMillis current time in milliseconds
     * @param pAction action made (I, U, D)
     * @param pStatus record status (O, N)
     * @throws            SQLException
     */
    public static void insertLog(Connection pCon, PriceRuleData pData, long pMillis, String pAction, String pStatus)
        throws SQLException {

        String sql = "INSERT INTO LCLW_PRICE_RULE (LOG_DATE_MS,LOG_DATE,ACTION, STATUS,"+
          "PRICE_RULE_ID,SHORT_DESC,PRICE_RULE_TYPE_CD,PRICE_RULE_STATUS_CD,EFF_DATE,EXP_DATE,ADD_DATE,ADD_BY,MOD_DATE,MOD_BY,BUS_ENTITY_ID) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement pstmt = pCon.prepareStatement(sql);
        
        pstmt.setLong(1,pMillis);
        pstmt.setTimestamp(2,DBAccess.toSQLTimestamp(new java.util.Date(pMillis)));
        pstmt.setString(3,pAction);
        pstmt.setString(4,pStatus);

        pstmt.setInt(1+4,pData.getPriceRuleId());
        pstmt.setString(2+4,pData.getShortDesc());
        pstmt.setString(3+4,pData.getPriceRuleTypeCd());
        pstmt.setString(4+4,pData.getPriceRuleStatusCd());
        pstmt.setDate(5+4,DBAccess.toSQLDate(pData.getEffDate()));
        pstmt.setDate(6+4,DBAccess.toSQLDate(pData.getExpDate()));
        pstmt.setTimestamp(7+4,DBAccess.toSQLTimestamp(pData.getAddDate()));
        pstmt.setString(8+4,pData.getAddBy());
        pstmt.setTimestamp(9+4,DBAccess.toSQLTimestamp(pData.getModDate()));
        pstmt.setString(10+4,pData.getModBy());
        pstmt.setInt(11+4,pData.getBusEntityId());


        pstmt.executeUpdate();
        pstmt.close();
    }




///////////////////////////////////////////////
    /**
     * Inserts a PriceRuleData object into the database.
     * @param pCon  An open database connection.
     * @param pData  A PriceRuleData object to insert.
     * The object id will be set to the one generated.  The "AddDate" and
     * "ModDate" fields will be set to the current date. 
     * @param pLogFl  Creates record in log table if true
     * @return new PriceRuleData() with the generated
     *         key set
     * @throws            SQLException
     */
    public static PriceRuleData insert(Connection pCon, PriceRuleData pData, boolean pLogFl)
        throws SQLException {
        pData = insert(pCon, pData);

        if(pLogFl) {
          long millis = System.currentTimeMillis();
          insertLog(pCon, pData, millis, "I", "N");
        }

        return pData;
    }

    /**
     * Updates a PriceRuleData object in the database.
     * @param pCon  An open database connection.
     * @param pData  A PriceRuleData object to update. 
     * The "ModDate" field of the object will be set to the current date.
     * @param pLogFl  Creates record in log table if true
     * @return int Number of rows updated (0 or 1).
     * @throws            SQLException
     */
    public static int update(Connection pCon, PriceRuleData pData, boolean pLogFl)
        throws SQLException {
        PriceRuleData oldData = null;
        if(pLogFl) {
          int id = pData.getPriceRuleId();
          try {
          oldData = PriceRuleDataAccess.select(pCon,id);
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
     * Deletes a PriceRuleData object with the specified
     * key from the database.
     * @param pCon  An open database connection.
     * @param pPriceRuleId Key of object to be deleted.
     * @param pLogFl  Create record in log table if true
     * @return int Number of rows deleted (0 or 1).
     * @throws            SQLException
     */
    public static int remove(Connection pCon, int pPriceRuleId, boolean pLogFl)
        throws SQLException{
        if(pLogFl){
          long millis = System.currentTimeMillis();
          java.util.Date rmDate = new java.util.Date(millis);
          java.text.SimpleDateFormat smf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          String oracleDate = "to_date('"+smf.format(rmDate)+"','YYYY-MM-DD HH24:MI:SS')";
          String sqlLog ="INSERT INTO LCLW_PRICE_RULE SELECT "+millis+ ","+oracleDate+",'D','O',d.* FROM CLW_PRICE_RULE d WHERE PRICE_RULE_ID = " + pPriceRuleId;
          Statement stmt = pCon.createStatement();
          stmt.executeUpdate(sqlLog);
           stmt.close();
        }
        int n = remove(pCon,pPriceRuleId);
        return n;
     }

    /**
     * Deletes PriceRuleData objects that match the specified criteria.
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
             new StringBuffer("INSERT INTO LCLW_PRICE_RULE SELECT "+millis+ ","+oracleDate+",'D','O',d.* FROM CLW_PRICE_RULE d ");
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

