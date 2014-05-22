
/* DO NOT EDIT - Generated code from XSL file DataAccess.xsl */

package com.cleanwise.service.api.dao;

/**
 * Title:        UiAssocDataAccess
 * Description:  This class is used to build access methods to the CLW_UI_ASSOC table.
 * Purpose:
 * Copyright:    Copyright (c) 2001
 * Company:      CleanWise, Inc.
 * @author       Generated Code from XSL file DataAccess.xsl
 */

import com.cleanwise.service.api.value.UiAssocData;
import com.cleanwise.service.api.value.UiAssocDataVector;
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
 * <code>UiAssocDataAccess</code>
 */
public class UiAssocDataAccess extends DataAccessImpl
{
    private static Category log = Category.getInstance(UiAssocDataAccess.class.getName());

    /** <code>CLW_UI_ASSOC</code> table name */
	/* Primary key: UI_ASSOC_ID */
	
    public static final String CLW_UI_ASSOC = "CLW_UI_ASSOC";
    
    /** <code>UI_ASSOC_ID</code> UI_ASSOC_ID column of table CLW_UI_ASSOC */
    public static final String UI_ASSOC_ID = "UI_ASSOC_ID";
    /** <code>UI_ID</code> UI_ID column of table CLW_UI_ASSOC */
    public static final String UI_ID = "UI_ID";
    /** <code>GROUP_ID</code> GROUP_ID column of table CLW_UI_ASSOC */
    public static final String GROUP_ID = "GROUP_ID";
    /** <code>ADD_BY</code> ADD_BY column of table CLW_UI_ASSOC */
    public static final String ADD_BY = "ADD_BY";
    /** <code>ADD_DATE</code> ADD_DATE column of table CLW_UI_ASSOC */
    public static final String ADD_DATE = "ADD_DATE";
    /** <code>MOD_BY</code> MOD_BY column of table CLW_UI_ASSOC */
    public static final String MOD_BY = "MOD_BY";
    /** <code>MOD_DATE</code> MOD_DATE column of table CLW_UI_ASSOC */
    public static final String MOD_DATE = "MOD_DATE";

    /**
     * Constructor.
     */
    public UiAssocDataAccess()
    {
    }

    /**
     * Gets a UiAssocData object with the specified
     * key from the database.
     * @param pCon An open database connection.
     * @param pUiAssocId The key requested.
     * @return new UiAssocData()
     * @throws            SQLException
     */
    public static UiAssocData select(Connection pCon, int pUiAssocId)
        throws SQLException, DataNotFoundException {
        UiAssocData x=null;
        String sql="SELECT UI_ASSOC_ID,UI_ID,GROUP_ID,ADD_BY,ADD_DATE,MOD_BY,MOD_DATE FROM CLW_UI_ASSOC WHERE UI_ASSOC_ID = ?";

        if (log.isDebugEnabled()) {
            log.debug("SQL: pUiAssocId=" + pUiAssocId);
            log.debug("SQL: " + sql);
        }

        PreparedStatement stmt = pCon.prepareStatement(sql);
        stmt.setInt(1,pUiAssocId);
        ResultSet rs=stmt.executeQuery();
        if (rs.next()) {
            // build the object
            x=UiAssocData.createValue();
            
            x.setUiAssocId(rs.getInt(1));
            x.setUiId(rs.getInt(2));
            x.setGroupId(rs.getInt(3));
            x.setAddBy(rs.getString(4));
            x.setAddDate(rs.getTimestamp(5));
            x.setModBy(rs.getString(6));
            x.setModDate(rs.getTimestamp(7));

        } else {
            rs.close();
            stmt.close();
            throw new DataNotFoundException("UI_ASSOC_ID :" + pUiAssocId);
        }

        rs.close();
        stmt.close();

        return x;
    }

    /**
     * Gets a UiAssocDataVector object that consists
     * of UiAssocData objects that match the supplied
     * criteria.
     * @param pCon An open database connection.
     * @param pCriteria A DBCriteria with the SQL 'where clause'
     * @return new UiAssocDataVector()
     * @throws            SQLException
     */
    public static UiAssocDataVector select(Connection pCon, DBCriteria pCriteria)
        throws SQLException{
        // Specify the maximum row limit to zero, unlimited size.
        return select(pCon, pCriteria, 0);
    }

    /**
    *@Returns a String of the columns suitable for using in a sql statement that may then be parsed into a UiAssocData Object
    *using the parseResultSet method.
    */
    public String getSelectColumns(){
        return "CLW_UI_ASSOC.UI_ASSOC_ID,CLW_UI_ASSOC.UI_ID,CLW_UI_ASSOC.GROUP_ID,CLW_UI_ASSOC.ADD_BY,CLW_UI_ASSOC.ADD_DATE,CLW_UI_ASSOC.MOD_BY,CLW_UI_ASSOC.MOD_DATE";
    }


    /**
    *Parses a result set into a value object.  Uses the position of the columns as its key so this method should only
    *be used in conjunction with the getSelectColumns() method or the wrong data will be parsed into the wrong properties.
    *The result set is not incremented, so calls to this method leave the resultset object unchanged.
    *@param ResultSet an open result set.
    *@returns a populated UiAssocData Object.
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
    *@returns a populated UiAssocData Object.
    *@throws SQLException
    */
    public com.cleanwise.service.api.framework.ValueObject parseResultSet(ResultSet rs, int offset) throws SQLException{
         // build the object
         UiAssocData x = UiAssocData.createValue();
         
         x.setUiAssocId(rs.getInt(1+offset));
         x.setUiId(rs.getInt(2+offset));
         x.setGroupId(rs.getInt(3+offset));
         x.setAddBy(rs.getString(4+offset));
         x.setAddDate(rs.getTimestamp(5+offset));
         x.setModBy(rs.getString(6+offset));
         x.setModDate(rs.getTimestamp(7+offset));
         return x;
    }

    /**
    *@Returns a count of the number of columns the UiAssocData Object represents.
    */
    public int getColumnCount(){
        return 7;
    }

    /**
     * Gets a UiAssocDataVector object that consists
     * of UiAssocData objects that match the supplied
     * criteria.
     * @param pCon An open database connection.
     * @param pCriteria A DBCriteria with the SQL 'where clause'
     * @param pMaxRows the maximum number of rows to return.
     * @return new UiAssocDataVector()
     * @throws            SQLException
     */
    public static UiAssocDataVector select(Connection pCon, DBCriteria pCriteria, int pMaxRows)
        throws SQLException{
        StringBuffer sqlBuf;
        Collection otherTables = pCriteria.getJoinTables();
        String where;
        if(otherTables == null || otherTables.isEmpty()){
                sqlBuf = new StringBuffer("SELECT UI_ASSOC_ID,UI_ID,GROUP_ID,ADD_BY,ADD_DATE,MOD_BY,MOD_DATE FROM CLW_UI_ASSOC");
                where = pCriteria.getSqlClause();
        }else{
                sqlBuf = new StringBuffer("SELECT CLW_UI_ASSOC.UI_ASSOC_ID,CLW_UI_ASSOC.UI_ID,CLW_UI_ASSOC.GROUP_ID,CLW_UI_ASSOC.ADD_BY,CLW_UI_ASSOC.ADD_DATE,CLW_UI_ASSOC.MOD_BY,CLW_UI_ASSOC.MOD_DATE FROM CLW_UI_ASSOC");
                where = pCriteria.getSqlClause("CLW_UI_ASSOC");

                Iterator it = otherTables.iterator();
                while(it.hasNext()){
                        String otherTable = (String) it.next();
                        if(!CLW_UI_ASSOC.equals(otherTable)){
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
        UiAssocDataVector v = new UiAssocDataVector();
        while (rs.next()) {
            UiAssocData x = UiAssocData.createValue();
            
            x.setUiAssocId(rs.getInt(1));
            x.setUiId(rs.getInt(2));
            x.setGroupId(rs.getInt(3));
            x.setAddBy(rs.getString(4));
            x.setAddDate(rs.getTimestamp(5));
            x.setModBy(rs.getString(6));
            x.setModDate(rs.getTimestamp(7));
            v.add(x);
        }

        rs.close();
        stmt.close();

        return v;
    }

    /**
     * Gets a UiAssocDataVector object that consists
     * of UiAssocData objects with the keys requested.
     * @param pCon An open database connection.
     * @param pIdVector A collection of keys for UiAssocData
     * to retrieve from the database (i.e. select 'IN' pIdVector)
     * @return new UiAssocDataVector()
     * @throws            SQLException
     */
    public static UiAssocDataVector select(Connection pCon, IdVector pIdVector)
        throws SQLException{
        UiAssocDataVector v = new UiAssocDataVector();
        StringBuffer sqlBuf = new StringBuffer("SELECT UI_ASSOC_ID,UI_ID,GROUP_ID,ADD_BY,ADD_DATE,MOD_BY,MOD_DATE FROM CLW_UI_ASSOC WHERE UI_ASSOC_ID IN (");

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
            UiAssocData x=null;
            while (rs.next()) {
                // build the object
                x=UiAssocData.createValue();
                
                x.setUiAssocId(rs.getInt(1));
                x.setUiId(rs.getInt(2));
                x.setGroupId(rs.getInt(3));
                x.setAddBy(rs.getString(4));
                x.setAddDate(rs.getTimestamp(5));
                x.setModBy(rs.getString(6));
                x.setModDate(rs.getTimestamp(7));
                v.add(x);
            }

            rs.close();
            stmt.close();
        }

        return v;
    }

    /**
     * Gets a UiAssocDataVector object of all
     * UiAssocData objects in the database.
     * @param pCon An open database connection.
     * @return new UiAssocDataVector()
     * @throws            SQLException
     */
    public static UiAssocDataVector selectAll(Connection pCon)
        throws SQLException{
        String sql = "SELECT UI_ASSOC_ID,UI_ID,GROUP_ID,ADD_BY,ADD_DATE,MOD_BY,MOD_DATE FROM CLW_UI_ASSOC";

        if (log.isDebugEnabled()) {
            log.debug("SQL: " + sql);
        }

        Statement stmt = pCon.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        UiAssocDataVector v = new UiAssocDataVector();
        UiAssocData x = null;
        while (rs.next()) {
            // build the object
            x = UiAssocData.createValue();
            
            x.setUiAssocId(rs.getInt(1));
            x.setUiId(rs.getInt(2));
            x.setGroupId(rs.getInt(3));
            x.setAddBy(rs.getString(4));
            x.setAddDate(rs.getTimestamp(5));
            x.setModBy(rs.getString(6));
            x.setModDate(rs.getTimestamp(7));

            v.add(x);
        }

        rs.close();
        stmt.close();

        return v;
    }

    /**
     * Gets an IdVector of Integers representing the Ids of the matching
     * UiAssocData objects in the database.
     * @param pCon An open database connection.
     * @param pCriteria A DBCriteria with the SQL 'where clause'
     * @return new IdVector()
     * @throws            SQLException
     */
    public static IdVector selectIdOnly(Connection pCon, DBCriteria pCriteria)
        throws SQLException{
        StringBuffer sqlBuf = new StringBuffer("SELECT UI_ASSOC_ID FROM CLW_UI_ASSOC");
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
        StringBuffer sqlBuf = new StringBuffer("SELECT DISTINCT "+pIdName+" FROM CLW_UI_ASSOC");
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
        StringBuffer sqlBuf = new StringBuffer("SELECT DISTINCT "+pIdName+" FROM CLW_UI_ASSOC");
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
     * Inserts a UiAssocData object into the database.
     * @param pCon  An open database connection.
     * @param pData  A UiAssocData object to insert.
     * The object id will be set to the one generated.  The "AddDate" and
     * "ModDate" fields will be set to the current date. 
     * @return new UiAssocData() with the generated
     *         key set
     * @throws            SQLException
     */
    public static UiAssocData insert(Connection pCon, UiAssocData pData)
        throws SQLException {

        if (log.isDebugEnabled()) {
            log.debug("SELECT CLW_UI_ASSOC_SEQ.NEXTVAL FROM DUAL");
        }
        String exceptionMessage=null;
        Statement stmt = pCon.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT CLW_UI_ASSOC_SEQ.NEXTVAL FROM DUAL");
        rs.next();
        pData.setUiAssocId(rs.getInt(1));
        stmt.close();

        String sql = "INSERT INTO CLW_UI_ASSOC (UI_ASSOC_ID,UI_ID,GROUP_ID,ADD_BY,ADD_DATE,MOD_BY,MOD_DATE) VALUES(?,?,?,?,?,?,?)"; PreparedStatement pstmt = pCon.prepareStatement(sql);

        
        java.util.Date current = new java.util.Date(System.currentTimeMillis());
        pData.setAddDate(current);
        pData.setModDate(current);

        pstmt.setInt(1,pData.getUiAssocId());
        pstmt.setInt(2,pData.getUiId());
        pstmt.setInt(3,pData.getGroupId());
        pstmt.setString(4,pData.getAddBy());
        pstmt.setTimestamp(5,DBAccess.toSQLTimestamp(pData.getAddDate()));
        pstmt.setString(6,pData.getModBy());
        pstmt.setTimestamp(7,DBAccess.toSQLTimestamp(pData.getModDate()));

        if (log.isDebugEnabled()) {
            log.debug("SQL:   UI_ASSOC_ID="+pData.getUiAssocId());
            log.debug("SQL:   UI_ID="+pData.getUiId());
            log.debug("SQL:   GROUP_ID="+pData.getGroupId());
            log.debug("SQL:   ADD_BY="+pData.getAddBy());
            log.debug("SQL:   ADD_DATE="+pData.getAddDate());
            log.debug("SQL:   MOD_BY="+pData.getModBy());
            log.debug("SQL:   MOD_DATE="+pData.getModDate());
            log.debug("SQL: " + sql);
        }
        try {
        pstmt.executeUpdate();
        pData.setDirty(false);
        }
        catch(SQLException e){
        pData.setUiAssocId(0);
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
     * Updates a UiAssocData object in the database.
     * @param pCon  An open database connection.
     * @param pData  A UiAssocData object to update. 
     * The "ModDate" field of the object will be set to the current date.
     * @return int Number of rows updated (0 or 1).
     * @throws            SQLException
     */
    public static int update(Connection pCon, UiAssocData pData)
        throws SQLException {

        int n = 0;

        String sql = "UPDATE CLW_UI_ASSOC SET UI_ID = ?,GROUP_ID = ?,ADD_BY = ?,ADD_DATE = ?,MOD_BY = ?,MOD_DATE = ? WHERE UI_ASSOC_ID = ?";

        PreparedStatement pstmt = pCon.prepareStatement(sql);

        
        pData.setModDate(new java.util.Date(System.currentTimeMillis()));

        int i = 1;
        
        pstmt.setInt(i++,pData.getUiId());
        pstmt.setInt(i++,pData.getGroupId());
        pstmt.setString(i++,pData.getAddBy());
        pstmt.setTimestamp(i++,DBAccess.toSQLTimestamp(pData.getAddDate()));
        pstmt.setString(i++,pData.getModBy());
        pstmt.setTimestamp(i++,DBAccess.toSQLTimestamp(pData.getModDate()));
        pstmt.setInt(i++,pData.getUiAssocId());

        if (log.isDebugEnabled()) {
            log.debug("SQL:   UI_ID="+pData.getUiId());
            log.debug("SQL:   GROUP_ID="+pData.getGroupId());
            log.debug("SQL:   ADD_BY="+pData.getAddBy());
            log.debug("SQL:   ADD_DATE="+pData.getAddDate());
            log.debug("SQL:   MOD_BY="+pData.getModBy());
            log.debug("SQL:   MOD_DATE="+pData.getModDate());
            log.debug("SQL: " + sql);
        }

        n = pstmt.executeUpdate();
        pstmt.close();

        pData.setDirty(false);

        return n;
    }

    /**
     * Deletes a UiAssocData object with the specified
     * key from the database.
     * @param pCon  An open database connection.
     * @param pUiAssocId Key of object to be deleted.
     * @return int Number of rows deleted (0 or 1).
     * @throws            SQLException
     */
    public static int remove(Connection pCon, int pUiAssocId)
        throws SQLException{
        int n = 0;
        String sql="DELETE FROM CLW_UI_ASSOC WHERE UI_ASSOC_ID = " + pUiAssocId;

        if (log.isDebugEnabled()) {
            log.debug("SQL: " + sql);
        }

        Statement stmt = pCon.createStatement();
        n = stmt.executeUpdate(sql);
        stmt.close();

        return n;
     }

    /**
     * Deletes UiAssocData objects that match the specified criteria.
     * @param pCon  An open database connection.
     * @param pCriteria A DBCriteria with the SQL 'where clause'
     * @return int Number of rows deleted.
     * @throws            SQLException
     */
    public static int remove(Connection pCon, DBCriteria pCriteria)
        throws SQLException {
        int n = 0;
        StringBuffer sqlBuf = new StringBuffer("DELETE FROM CLW_UI_ASSOC");
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
     * Inserts a UiAssocData log object into the database.
     * @param pCon  An open database connection.
     * @param pData  A UiAssocData object to insert
     * @param pMillis current time in milliseconds
     * @param pAction action made (I, U, D)
     * @param pStatus record status (O, N)
     * @throws            SQLException
     */
    public static void insertLog(Connection pCon, UiAssocData pData, long pMillis, String pAction, String pStatus)
        throws SQLException {

        String sql = "INSERT INTO LCLW_UI_ASSOC (LOG_DATE_MS,LOG_DATE,ACTION, STATUS,"+
          "UI_ASSOC_ID,UI_ID,GROUP_ID,ADD_BY,ADD_DATE,MOD_BY,MOD_DATE) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement pstmt = pCon.prepareStatement(sql);
        
        pstmt.setLong(1,pMillis);
        pstmt.setTimestamp(2,DBAccess.toSQLTimestamp(new java.util.Date(pMillis)));
        pstmt.setString(3,pAction);
        pstmt.setString(4,pStatus);

        pstmt.setInt(1+4,pData.getUiAssocId());
        pstmt.setInt(2+4,pData.getUiId());
        pstmt.setInt(3+4,pData.getGroupId());
        pstmt.setString(4+4,pData.getAddBy());
        pstmt.setTimestamp(5+4,DBAccess.toSQLTimestamp(pData.getAddDate()));
        pstmt.setString(6+4,pData.getModBy());
        pstmt.setTimestamp(7+4,DBAccess.toSQLTimestamp(pData.getModDate()));


        pstmt.executeUpdate();
        pstmt.close();
    }




///////////////////////////////////////////////
    /**
     * Inserts a UiAssocData object into the database.
     * @param pCon  An open database connection.
     * @param pData  A UiAssocData object to insert.
     * The object id will be set to the one generated.  The "AddDate" and
     * "ModDate" fields will be set to the current date. 
     * @param pLogFl  Creates record in log table if true
     * @return new UiAssocData() with the generated
     *         key set
     * @throws            SQLException
     */
    public static UiAssocData insert(Connection pCon, UiAssocData pData, boolean pLogFl)
        throws SQLException {
        pData = insert(pCon, pData);

        if(pLogFl) {
          long millis = System.currentTimeMillis();
          insertLog(pCon, pData, millis, "I", "N");
        }

        return pData;
    }

    /**
     * Updates a UiAssocData object in the database.
     * @param pCon  An open database connection.
     * @param pData  A UiAssocData object to update. 
     * The "ModDate" field of the object will be set to the current date.
     * @param pLogFl  Creates record in log table if true
     * @return int Number of rows updated (0 or 1).
     * @throws            SQLException
     */
    public static int update(Connection pCon, UiAssocData pData, boolean pLogFl)
        throws SQLException {
        UiAssocData oldData = null;
        if(pLogFl) {
          int id = pData.getUiAssocId();
          try {
          oldData = UiAssocDataAccess.select(pCon,id);
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
     * Deletes a UiAssocData object with the specified
     * key from the database.
     * @param pCon  An open database connection.
     * @param pUiAssocId Key of object to be deleted.
     * @param pLogFl  Create record in log table if true
     * @return int Number of rows deleted (0 or 1).
     * @throws            SQLException
     */
    public static int remove(Connection pCon, int pUiAssocId, boolean pLogFl)
        throws SQLException{
        if(pLogFl){
          long millis = System.currentTimeMillis();
          java.util.Date rmDate = new java.util.Date(millis);
          java.text.SimpleDateFormat smf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          String oracleDate = "to_date('"+smf.format(rmDate)+"','YYYY-MM-DD HH24:MI:SS')";
          String sqlLog ="INSERT INTO LCLW_UI_ASSOC SELECT "+millis+ ","+oracleDate+",'D','O',d.* FROM CLW_UI_ASSOC d WHERE UI_ASSOC_ID = " + pUiAssocId;
          Statement stmt = pCon.createStatement();
          stmt.executeUpdate(sqlLog);
           stmt.close();
        }
        int n = remove(pCon,pUiAssocId);
        return n;
     }

    /**
     * Deletes UiAssocData objects that match the specified criteria.
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
             new StringBuffer("INSERT INTO LCLW_UI_ASSOC SELECT "+millis+ ","+oracleDate+",'D','O',d.* FROM CLW_UI_ASSOC d ");
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

