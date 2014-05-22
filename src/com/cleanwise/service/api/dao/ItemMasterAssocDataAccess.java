
/* DO NOT EDIT - Generated code from XSL file DataAccess.xsl */

package com.cleanwise.service.api.dao;

/**
 * Title:        ItemMasterAssocDataAccess
 * Description:  This class is used to build access methods to the CLW_ITEM_MASTER_ASSOC table.
 * Purpose:
 * Copyright:    Copyright (c) 2001
 * Company:      CleanWise, Inc.
 * @author       Generated Code from XSL file DataAccess.xsl
 */

import com.cleanwise.service.api.value.ItemMasterAssocData;
import com.cleanwise.service.api.value.ItemMasterAssocDataVector;
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
 * <code>ItemMasterAssocDataAccess</code>
 */
public class ItemMasterAssocDataAccess extends DataAccessImpl
{
    private static Category log = Category.getInstance(ItemMasterAssocDataAccess.class.getName());

    /** <code>CLW_ITEM_MASTER_ASSOC</code> table name */
	/* Primary key: ITEM_MASTER_ASSOC_ID */
	
    public static final String CLW_ITEM_MASTER_ASSOC = "CLW_ITEM_MASTER_ASSOC";
    
    /** <code>ITEM_MASTER_ASSOC_ID</code> ITEM_MASTER_ASSOC_ID column of table CLW_ITEM_MASTER_ASSOC */
    public static final String ITEM_MASTER_ASSOC_ID = "ITEM_MASTER_ASSOC_ID";
    /** <code>PARENT_MASTER_ITEM_ID</code> PARENT_MASTER_ITEM_ID column of table CLW_ITEM_MASTER_ASSOC */
    public static final String PARENT_MASTER_ITEM_ID = "PARENT_MASTER_ITEM_ID";
    /** <code>CHILD_MASTER_ITEM_ID</code> CHILD_MASTER_ITEM_ID column of table CLW_ITEM_MASTER_ASSOC */
    public static final String CHILD_MASTER_ITEM_ID = "CHILD_MASTER_ITEM_ID";
    /** <code>ITEM_MASTER_ASSOC_STATUS_CD</code> ITEM_MASTER_ASSOC_STATUS_CD column of table CLW_ITEM_MASTER_ASSOC */
    public static final String ITEM_MASTER_ASSOC_STATUS_CD = "ITEM_MASTER_ASSOC_STATUS_CD";
    /** <code>ADD_DATE</code> ADD_DATE column of table CLW_ITEM_MASTER_ASSOC */
    public static final String ADD_DATE = "ADD_DATE";
    /** <code>ADD_BY</code> ADD_BY column of table CLW_ITEM_MASTER_ASSOC */
    public static final String ADD_BY = "ADD_BY";
    /** <code>MOD_DATE</code> MOD_DATE column of table CLW_ITEM_MASTER_ASSOC */
    public static final String MOD_DATE = "MOD_DATE";
    /** <code>MOD_BY</code> MOD_BY column of table CLW_ITEM_MASTER_ASSOC */
    public static final String MOD_BY = "MOD_BY";

    /**
     * Constructor.
     */
    public ItemMasterAssocDataAccess()
    {
    }

    /**
     * Gets a ItemMasterAssocData object with the specified
     * key from the database.
     * @param pCon An open database connection.
     * @param pItemMasterAssocId The key requested.
     * @return new ItemMasterAssocData()
     * @throws            SQLException
     */
    public static ItemMasterAssocData select(Connection pCon, int pItemMasterAssocId)
        throws SQLException, DataNotFoundException {
        ItemMasterAssocData x=null;
        String sql="SELECT ITEM_MASTER_ASSOC_ID,PARENT_MASTER_ITEM_ID,CHILD_MASTER_ITEM_ID,ITEM_MASTER_ASSOC_STATUS_CD,ADD_DATE,ADD_BY,MOD_DATE,MOD_BY FROM CLW_ITEM_MASTER_ASSOC WHERE ITEM_MASTER_ASSOC_ID = ?";

        if (log.isDebugEnabled()) {
            log.debug("SQL: pItemMasterAssocId=" + pItemMasterAssocId);
            log.debug("SQL: " + sql);
        }

        PreparedStatement stmt = pCon.prepareStatement(sql);
        stmt.setInt(1,pItemMasterAssocId);
        ResultSet rs=stmt.executeQuery();
        if (rs.next()) {
            // build the object
            x=ItemMasterAssocData.createValue();
            
            x.setItemMasterAssocId(rs.getInt(1));
            x.setParentMasterItemId(rs.getInt(2));
            x.setChildMasterItemId(rs.getInt(3));
            x.setItemMasterAssocStatusCd(rs.getString(4));
            x.setAddDate(rs.getTimestamp(5));
            x.setAddBy(rs.getString(6));
            x.setModDate(rs.getTimestamp(7));
            x.setModBy(rs.getString(8));

        } else {
            rs.close();
            stmt.close();
            throw new DataNotFoundException("ITEM_MASTER_ASSOC_ID :" + pItemMasterAssocId);
        }

        rs.close();
        stmt.close();

        return x;
    }

    /**
     * Gets a ItemMasterAssocDataVector object that consists
     * of ItemMasterAssocData objects that match the supplied
     * criteria.
     * @param pCon An open database connection.
     * @param pCriteria A DBCriteria with the SQL 'where clause'
     * @return new ItemMasterAssocDataVector()
     * @throws            SQLException
     */
    public static ItemMasterAssocDataVector select(Connection pCon, DBCriteria pCriteria)
        throws SQLException{
        // Specify the maximum row limit to zero, unlimited size.
        return select(pCon, pCriteria, 0);
    }

    /**
    *@Returns a String of the columns suitable for using in a sql statement that may then be parsed into a ItemMasterAssocData Object
    *using the parseResultSet method.
    */
    public String getSelectColumns(){
        return "CLW_ITEM_MASTER_ASSOC.ITEM_MASTER_ASSOC_ID,CLW_ITEM_MASTER_ASSOC.PARENT_MASTER_ITEM_ID,CLW_ITEM_MASTER_ASSOC.CHILD_MASTER_ITEM_ID,CLW_ITEM_MASTER_ASSOC.ITEM_MASTER_ASSOC_STATUS_CD,CLW_ITEM_MASTER_ASSOC.ADD_DATE,CLW_ITEM_MASTER_ASSOC.ADD_BY,CLW_ITEM_MASTER_ASSOC.MOD_DATE,CLW_ITEM_MASTER_ASSOC.MOD_BY";
    }


    /**
    *Parses a result set into a value object.  Uses the position of the columns as its key so this method should only
    *be used in conjunction with the getSelectColumns() method or the wrong data will be parsed into the wrong properties.
    *The result set is not incremented, so calls to this method leave the resultset object unchanged.
    *@param ResultSet an open result set.
    *@returns a populated ItemMasterAssocData Object.
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
    *@returns a populated ItemMasterAssocData Object.
    *@throws SQLException
    */
    public com.cleanwise.service.api.framework.ValueObject parseResultSet(ResultSet rs, int offset) throws SQLException{
         // build the object
         ItemMasterAssocData x = ItemMasterAssocData.createValue();
         
         x.setItemMasterAssocId(rs.getInt(1+offset));
         x.setParentMasterItemId(rs.getInt(2+offset));
         x.setChildMasterItemId(rs.getInt(3+offset));
         x.setItemMasterAssocStatusCd(rs.getString(4+offset));
         x.setAddDate(rs.getTimestamp(5+offset));
         x.setAddBy(rs.getString(6+offset));
         x.setModDate(rs.getTimestamp(7+offset));
         x.setModBy(rs.getString(8+offset));
         return x;
    }

    /**
    *@Returns a count of the number of columns the ItemMasterAssocData Object represents.
    */
    public int getColumnCount(){
        return 8;
    }

    /**
     * Gets a ItemMasterAssocDataVector object that consists
     * of ItemMasterAssocData objects that match the supplied
     * criteria.
     * @param pCon An open database connection.
     * @param pCriteria A DBCriteria with the SQL 'where clause'
     * @param pMaxRows the maximum number of rows to return.
     * @return new ItemMasterAssocDataVector()
     * @throws            SQLException
     */
    public static ItemMasterAssocDataVector select(Connection pCon, DBCriteria pCriteria, int pMaxRows)
        throws SQLException{
        StringBuffer sqlBuf;
        Collection otherTables = pCriteria.getJoinTables();
        String where;
        if(otherTables == null || otherTables.isEmpty()){
                sqlBuf = new StringBuffer("SELECT ITEM_MASTER_ASSOC_ID,PARENT_MASTER_ITEM_ID,CHILD_MASTER_ITEM_ID,ITEM_MASTER_ASSOC_STATUS_CD,ADD_DATE,ADD_BY,MOD_DATE,MOD_BY FROM CLW_ITEM_MASTER_ASSOC");
                where = pCriteria.getSqlClause();
        }else{
                sqlBuf = new StringBuffer("SELECT CLW_ITEM_MASTER_ASSOC.ITEM_MASTER_ASSOC_ID,CLW_ITEM_MASTER_ASSOC.PARENT_MASTER_ITEM_ID,CLW_ITEM_MASTER_ASSOC.CHILD_MASTER_ITEM_ID,CLW_ITEM_MASTER_ASSOC.ITEM_MASTER_ASSOC_STATUS_CD,CLW_ITEM_MASTER_ASSOC.ADD_DATE,CLW_ITEM_MASTER_ASSOC.ADD_BY,CLW_ITEM_MASTER_ASSOC.MOD_DATE,CLW_ITEM_MASTER_ASSOC.MOD_BY FROM CLW_ITEM_MASTER_ASSOC");
                where = pCriteria.getSqlClause("CLW_ITEM_MASTER_ASSOC");

                Iterator it = otherTables.iterator();
                while(it.hasNext()){
                        String otherTable = (String) it.next();
                        if(!CLW_ITEM_MASTER_ASSOC.equals(otherTable)){
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
        ItemMasterAssocDataVector v = new ItemMasterAssocDataVector();
        while (rs.next()) {
            ItemMasterAssocData x = ItemMasterAssocData.createValue();
            
            x.setItemMasterAssocId(rs.getInt(1));
            x.setParentMasterItemId(rs.getInt(2));
            x.setChildMasterItemId(rs.getInt(3));
            x.setItemMasterAssocStatusCd(rs.getString(4));
            x.setAddDate(rs.getTimestamp(5));
            x.setAddBy(rs.getString(6));
            x.setModDate(rs.getTimestamp(7));
            x.setModBy(rs.getString(8));
            v.add(x);
        }

        rs.close();
        stmt.close();

        return v;
    }

    /**
     * Gets a ItemMasterAssocDataVector object that consists
     * of ItemMasterAssocData objects with the keys requested.
     * @param pCon An open database connection.
     * @param pIdVector A collection of keys for ItemMasterAssocData
     * to retrieve from the database (i.e. select 'IN' pIdVector)
     * @return new ItemMasterAssocDataVector()
     * @throws            SQLException
     */
    public static ItemMasterAssocDataVector select(Connection pCon, IdVector pIdVector)
        throws SQLException{
        ItemMasterAssocDataVector v = new ItemMasterAssocDataVector();
        StringBuffer sqlBuf = new StringBuffer("SELECT ITEM_MASTER_ASSOC_ID,PARENT_MASTER_ITEM_ID,CHILD_MASTER_ITEM_ID,ITEM_MASTER_ASSOC_STATUS_CD,ADD_DATE,ADD_BY,MOD_DATE,MOD_BY FROM CLW_ITEM_MASTER_ASSOC WHERE ITEM_MASTER_ASSOC_ID IN (");

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
            ItemMasterAssocData x=null;
            while (rs.next()) {
                // build the object
                x=ItemMasterAssocData.createValue();
                
                x.setItemMasterAssocId(rs.getInt(1));
                x.setParentMasterItemId(rs.getInt(2));
                x.setChildMasterItemId(rs.getInt(3));
                x.setItemMasterAssocStatusCd(rs.getString(4));
                x.setAddDate(rs.getTimestamp(5));
                x.setAddBy(rs.getString(6));
                x.setModDate(rs.getTimestamp(7));
                x.setModBy(rs.getString(8));
                v.add(x);
            }

            rs.close();
            stmt.close();
        }

        return v;
    }

    /**
     * Gets a ItemMasterAssocDataVector object of all
     * ItemMasterAssocData objects in the database.
     * @param pCon An open database connection.
     * @return new ItemMasterAssocDataVector()
     * @throws            SQLException
     */
    public static ItemMasterAssocDataVector selectAll(Connection pCon)
        throws SQLException{
        String sql = "SELECT ITEM_MASTER_ASSOC_ID,PARENT_MASTER_ITEM_ID,CHILD_MASTER_ITEM_ID,ITEM_MASTER_ASSOC_STATUS_CD,ADD_DATE,ADD_BY,MOD_DATE,MOD_BY FROM CLW_ITEM_MASTER_ASSOC";

        if (log.isDebugEnabled()) {
            log.debug("SQL: " + sql);
        }

        Statement stmt = pCon.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        ItemMasterAssocDataVector v = new ItemMasterAssocDataVector();
        ItemMasterAssocData x = null;
        while (rs.next()) {
            // build the object
            x = ItemMasterAssocData.createValue();
            
            x.setItemMasterAssocId(rs.getInt(1));
            x.setParentMasterItemId(rs.getInt(2));
            x.setChildMasterItemId(rs.getInt(3));
            x.setItemMasterAssocStatusCd(rs.getString(4));
            x.setAddDate(rs.getTimestamp(5));
            x.setAddBy(rs.getString(6));
            x.setModDate(rs.getTimestamp(7));
            x.setModBy(rs.getString(8));

            v.add(x);
        }

        rs.close();
        stmt.close();

        return v;
    }

    /**
     * Gets an IdVector of Integers representing the Ids of the matching
     * ItemMasterAssocData objects in the database.
     * @param pCon An open database connection.
     * @param pCriteria A DBCriteria with the SQL 'where clause'
     * @return new IdVector()
     * @throws            SQLException
     */
    public static IdVector selectIdOnly(Connection pCon, DBCriteria pCriteria)
        throws SQLException{
        StringBuffer sqlBuf = new StringBuffer("SELECT ITEM_MASTER_ASSOC_ID FROM CLW_ITEM_MASTER_ASSOC");
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
        StringBuffer sqlBuf = new StringBuffer("SELECT DISTINCT "+pIdName+" FROM CLW_ITEM_MASTER_ASSOC");
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
        StringBuffer sqlBuf = new StringBuffer("SELECT DISTINCT "+pIdName+" FROM CLW_ITEM_MASTER_ASSOC");
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
     * Inserts a ItemMasterAssocData object into the database.
     * @param pCon  An open database connection.
     * @param pData  A ItemMasterAssocData object to insert.
     * The object id will be set to the one generated.  The "AddDate" and
     * "ModDate" fields will be set to the current date. 
     * @return new ItemMasterAssocData() with the generated
     *         key set
     * @throws            SQLException
     */
    public static ItemMasterAssocData insert(Connection pCon, ItemMasterAssocData pData)
        throws SQLException {

        if (log.isDebugEnabled()) {
            log.debug("SELECT CLW_ITEM_MASTER_ASSOC_SEQ.NEXTVAL FROM DUAL");
        }
        String exceptionMessage=null;
        Statement stmt = pCon.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT CLW_ITEM_MASTER_ASSOC_SEQ.NEXTVAL FROM DUAL");
        rs.next();
        pData.setItemMasterAssocId(rs.getInt(1));
        stmt.close();

        String sql = "INSERT INTO CLW_ITEM_MASTER_ASSOC (ITEM_MASTER_ASSOC_ID,PARENT_MASTER_ITEM_ID,CHILD_MASTER_ITEM_ID,ITEM_MASTER_ASSOC_STATUS_CD,ADD_DATE,ADD_BY,MOD_DATE,MOD_BY) VALUES(?,?,?,?,?,?,?,?)"; PreparedStatement pstmt = pCon.prepareStatement(sql);

        
        java.util.Date current = new java.util.Date(System.currentTimeMillis());
        pData.setAddDate(current);
        pData.setModDate(current);

        pstmt.setInt(1,pData.getItemMasterAssocId());
        if (pData.getParentMasterItemId() == 0) {
            pstmt.setNull(2, java.sql.Types.INTEGER);
        } else {
            pstmt.setInt(2,pData.getParentMasterItemId());
        }

        if (pData.getChildMasterItemId() == 0) {
            pstmt.setNull(3, java.sql.Types.INTEGER);
        } else {
            pstmt.setInt(3,pData.getChildMasterItemId());
        }

        pstmt.setString(4,pData.getItemMasterAssocStatusCd());
        pstmt.setTimestamp(5,DBAccess.toSQLTimestamp(pData.getAddDate()));
        pstmt.setString(6,pData.getAddBy());
        pstmt.setTimestamp(7,DBAccess.toSQLTimestamp(pData.getModDate()));
        pstmt.setString(8,pData.getModBy());

        if (log.isDebugEnabled()) {
            log.debug("SQL:   ITEM_MASTER_ASSOC_ID="+pData.getItemMasterAssocId());
            log.debug("SQL:   PARENT_MASTER_ITEM_ID="+pData.getParentMasterItemId());
            log.debug("SQL:   CHILD_MASTER_ITEM_ID="+pData.getChildMasterItemId());
            log.debug("SQL:   ITEM_MASTER_ASSOC_STATUS_CD="+pData.getItemMasterAssocStatusCd());
            log.debug("SQL:   ADD_DATE="+pData.getAddDate());
            log.debug("SQL:   ADD_BY="+pData.getAddBy());
            log.debug("SQL:   MOD_DATE="+pData.getModDate());
            log.debug("SQL:   MOD_BY="+pData.getModBy());
            log.debug("SQL: " + sql);
        }
        try {
        pstmt.executeUpdate();
        pData.setDirty(false);
        }
        catch(SQLException e){
        pData.setItemMasterAssocId(0);
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
     * Updates a ItemMasterAssocData object in the database.
     * @param pCon  An open database connection.
     * @param pData  A ItemMasterAssocData object to update. 
     * The "ModDate" field of the object will be set to the current date.
     * @return int Number of rows updated (0 or 1).
     * @throws            SQLException
     */
    public static int update(Connection pCon, ItemMasterAssocData pData)
        throws SQLException {

        int n = 0;

        String sql = "UPDATE CLW_ITEM_MASTER_ASSOC SET PARENT_MASTER_ITEM_ID = ?,CHILD_MASTER_ITEM_ID = ?,ITEM_MASTER_ASSOC_STATUS_CD = ?,ADD_DATE = ?,ADD_BY = ?,MOD_DATE = ?,MOD_BY = ? WHERE ITEM_MASTER_ASSOC_ID = ?";

        PreparedStatement pstmt = pCon.prepareStatement(sql);

        
        pData.setModDate(new java.util.Date(System.currentTimeMillis()));

        int i = 1;
        
        if (pData.getParentMasterItemId() == 0) {
            pstmt.setNull(i++, java.sql.Types.INTEGER);
        } else {
            pstmt.setInt(i++,pData.getParentMasterItemId());
        }

        if (pData.getChildMasterItemId() == 0) {
            pstmt.setNull(i++, java.sql.Types.INTEGER);
        } else {
            pstmt.setInt(i++,pData.getChildMasterItemId());
        }

        pstmt.setString(i++,pData.getItemMasterAssocStatusCd());
        pstmt.setTimestamp(i++,DBAccess.toSQLTimestamp(pData.getAddDate()));
        pstmt.setString(i++,pData.getAddBy());
        pstmt.setTimestamp(i++,DBAccess.toSQLTimestamp(pData.getModDate()));
        pstmt.setString(i++,pData.getModBy());
        pstmt.setInt(i++,pData.getItemMasterAssocId());

        if (log.isDebugEnabled()) {
            log.debug("SQL:   PARENT_MASTER_ITEM_ID="+pData.getParentMasterItemId());
            log.debug("SQL:   CHILD_MASTER_ITEM_ID="+pData.getChildMasterItemId());
            log.debug("SQL:   ITEM_MASTER_ASSOC_STATUS_CD="+pData.getItemMasterAssocStatusCd());
            log.debug("SQL:   ADD_DATE="+pData.getAddDate());
            log.debug("SQL:   ADD_BY="+pData.getAddBy());
            log.debug("SQL:   MOD_DATE="+pData.getModDate());
            log.debug("SQL:   MOD_BY="+pData.getModBy());
            log.debug("SQL: " + sql);
        }

        n = pstmt.executeUpdate();
        pstmt.close();

        pData.setDirty(false);

        return n;
    }

    /**
     * Deletes a ItemMasterAssocData object with the specified
     * key from the database.
     * @param pCon  An open database connection.
     * @param pItemMasterAssocId Key of object to be deleted.
     * @return int Number of rows deleted (0 or 1).
     * @throws            SQLException
     */
    public static int remove(Connection pCon, int pItemMasterAssocId)
        throws SQLException{
        int n = 0;
        String sql="DELETE FROM CLW_ITEM_MASTER_ASSOC WHERE ITEM_MASTER_ASSOC_ID = " + pItemMasterAssocId;

        if (log.isDebugEnabled()) {
            log.debug("SQL: " + sql);
        }

        Statement stmt = pCon.createStatement();
        n = stmt.executeUpdate(sql);
        stmt.close();

        return n;
     }

    /**
     * Deletes ItemMasterAssocData objects that match the specified criteria.
     * @param pCon  An open database connection.
     * @param pCriteria A DBCriteria with the SQL 'where clause'
     * @return int Number of rows deleted.
     * @throws            SQLException
     */
    public static int remove(Connection pCon, DBCriteria pCriteria)
        throws SQLException {
        int n = 0;
        StringBuffer sqlBuf = new StringBuffer("DELETE FROM CLW_ITEM_MASTER_ASSOC");
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
     * Inserts a ItemMasterAssocData log object into the database.
     * @param pCon  An open database connection.
     * @param pData  A ItemMasterAssocData object to insert
     * @param pMillis current time in milliseconds
     * @param pAction action made (I, U, D)
     * @param pStatus record status (O, N)
     * @throws            SQLException
     */
    public static void insertLog(Connection pCon, ItemMasterAssocData pData, long pMillis, String pAction, String pStatus)
        throws SQLException {

        String sql = "INSERT INTO LCLW_ITEM_MASTER_ASSOC (LOG_DATE_MS,LOG_DATE,ACTION, STATUS,"+
          "ITEM_MASTER_ASSOC_ID,PARENT_MASTER_ITEM_ID,CHILD_MASTER_ITEM_ID,ITEM_MASTER_ASSOC_STATUS_CD,ADD_DATE,ADD_BY,MOD_DATE,MOD_BY) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement pstmt = pCon.prepareStatement(sql);
        
        pstmt.setLong(1,pMillis);
        pstmt.setTimestamp(2,DBAccess.toSQLTimestamp(new java.util.Date(pMillis)));
        pstmt.setString(3,pAction);
        pstmt.setString(4,pStatus);

        pstmt.setInt(1+4,pData.getItemMasterAssocId());
        if (pData.getParentMasterItemId() == 0) {
            pstmt.setNull(2+4, java.sql.Types.INTEGER);
        } else {
            pstmt.setInt(2+4,pData.getParentMasterItemId());
        }

        if (pData.getChildMasterItemId() == 0) {
            pstmt.setNull(3+4, java.sql.Types.INTEGER);
        } else {
            pstmt.setInt(3+4,pData.getChildMasterItemId());
        }

        pstmt.setString(4+4,pData.getItemMasterAssocStatusCd());
        pstmt.setTimestamp(5+4,DBAccess.toSQLTimestamp(pData.getAddDate()));
        pstmt.setString(6+4,pData.getAddBy());
        pstmt.setTimestamp(7+4,DBAccess.toSQLTimestamp(pData.getModDate()));
        pstmt.setString(8+4,pData.getModBy());


        pstmt.executeUpdate();
        pstmt.close();
    }




///////////////////////////////////////////////
    /**
     * Inserts a ItemMasterAssocData object into the database.
     * @param pCon  An open database connection.
     * @param pData  A ItemMasterAssocData object to insert.
     * The object id will be set to the one generated.  The "AddDate" and
     * "ModDate" fields will be set to the current date. 
     * @param pLogFl  Creates record in log table if true
     * @return new ItemMasterAssocData() with the generated
     *         key set
     * @throws            SQLException
     */
    public static ItemMasterAssocData insert(Connection pCon, ItemMasterAssocData pData, boolean pLogFl)
        throws SQLException {
        pData = insert(pCon, pData);

        if(pLogFl) {
          long millis = System.currentTimeMillis();
          insertLog(pCon, pData, millis, "I", "N");
        }

        return pData;
    }

    /**
     * Updates a ItemMasterAssocData object in the database.
     * @param pCon  An open database connection.
     * @param pData  A ItemMasterAssocData object to update. 
     * The "ModDate" field of the object will be set to the current date.
     * @param pLogFl  Creates record in log table if true
     * @return int Number of rows updated (0 or 1).
     * @throws            SQLException
     */
    public static int update(Connection pCon, ItemMasterAssocData pData, boolean pLogFl)
        throws SQLException {
        ItemMasterAssocData oldData = null;
        if(pLogFl) {
          int id = pData.getItemMasterAssocId();
          try {
          oldData = ItemMasterAssocDataAccess.select(pCon,id);
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
     * Deletes a ItemMasterAssocData object with the specified
     * key from the database.
     * @param pCon  An open database connection.
     * @param pItemMasterAssocId Key of object to be deleted.
     * @param pLogFl  Create record in log table if true
     * @return int Number of rows deleted (0 or 1).
     * @throws            SQLException
     */
    public static int remove(Connection pCon, int pItemMasterAssocId, boolean pLogFl)
        throws SQLException{
        if(pLogFl){
          long millis = System.currentTimeMillis();
          java.util.Date rmDate = new java.util.Date(millis);
          java.text.SimpleDateFormat smf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          String oracleDate = "to_date('"+smf.format(rmDate)+"','YYYY-MM-DD HH24:MI:SS')";
          String sqlLog ="INSERT INTO LCLW_ITEM_MASTER_ASSOC SELECT "+millis+ ","+oracleDate+",'D','O',d.* FROM CLW_ITEM_MASTER_ASSOC d WHERE ITEM_MASTER_ASSOC_ID = " + pItemMasterAssocId;
          Statement stmt = pCon.createStatement();
          stmt.executeUpdate(sqlLog);
           stmt.close();
        }
        int n = remove(pCon,pItemMasterAssocId);
        return n;
     }

    /**
     * Deletes ItemMasterAssocData objects that match the specified criteria.
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
             new StringBuffer("INSERT INTO LCLW_ITEM_MASTER_ASSOC SELECT "+millis+ ","+oracleDate+",'D','O',d.* FROM CLW_ITEM_MASTER_ASSOC d ");
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

