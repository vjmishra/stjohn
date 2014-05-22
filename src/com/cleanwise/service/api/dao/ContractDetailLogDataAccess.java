
/* DO NOT EDIT - Generated code from XSL file DataAccess.xsl */

package com.cleanwise.service.api.dao;

/**
 * Title:        ContractDetailLogDataAccess
 * Description:  This class is used to build access methods to the CLW_CONTRACT_DETAIL_LOG table.
 * Purpose:
 * Copyright:    Copyright (c) 2001
 * Company:      CleanWise, Inc.
 * @author       Generated Code from XSL file DataAccess.xsl
 */

import com.cleanwise.service.api.value.ContractDetailLogData;
import com.cleanwise.service.api.value.ContractDetailLogDataVector;
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
 * <code>ContractDetailLogDataAccess</code>
 */
public class ContractDetailLogDataAccess extends DataAccessImpl
{
    private static Category log = Category.getInstance(ContractDetailLogDataAccess.class.getName());

    /** <code>CLW_CONTRACT_DETAIL_LOG</code> table name */
	/* Primary key: CONTRACT_DETAIL_LOG_ID */
	
    public static final String CLW_CONTRACT_DETAIL_LOG = "CLW_CONTRACT_DETAIL_LOG";
    
    /** <code>CONTRACT_DETAIL_LOG_ID</code> CONTRACT_DETAIL_LOG_ID column of table CLW_CONTRACT_DETAIL_LOG */
    public static final String CONTRACT_DETAIL_LOG_ID = "CONTRACT_DETAIL_LOG_ID";
    /** <code>CONTRACT_ITEM_ID</code> CONTRACT_ITEM_ID column of table CLW_CONTRACT_DETAIL_LOG */
    public static final String CONTRACT_ITEM_ID = "CONTRACT_ITEM_ID";
    /** <code>CLW_DATE</code> CLW_DATE column of table CLW_CONTRACT_DETAIL_LOG */
    public static final String CLW_DATE = "CLW_DATE";
    /** <code>CLW_TIME</code> CLW_TIME column of table CLW_CONTRACT_DETAIL_LOG */
    public static final String CLW_TIME = "CLW_TIME";
    /** <code>CHANGE</code> CHANGE column of table CLW_CONTRACT_DETAIL_LOG */
    public static final String CHANGE = "CHANGE";

    /**
     * Constructor.
     */
    public ContractDetailLogDataAccess()
    {
    }

    /**
     * Gets a ContractDetailLogData object with the specified
     * key from the database.
     * @param pCon An open database connection.
     * @param pContractDetailLogId The key requested.
     * @return new ContractDetailLogData()
     * @throws            SQLException
     */
    public static ContractDetailLogData select(Connection pCon, int pContractDetailLogId)
        throws SQLException, DataNotFoundException {
        ContractDetailLogData x=null;
        String sql="SELECT CONTRACT_DETAIL_LOG_ID,CONTRACT_ITEM_ID,CLW_DATE,CLW_TIME,CHANGE FROM CLW_CONTRACT_DETAIL_LOG WHERE CONTRACT_DETAIL_LOG_ID = ?";

        if (log.isDebugEnabled()) {
            log.debug("SQL: pContractDetailLogId=" + pContractDetailLogId);
            log.debug("SQL: " + sql);
        }

        PreparedStatement stmt = pCon.prepareStatement(sql);
        stmt.setInt(1,pContractDetailLogId);
        ResultSet rs=stmt.executeQuery();
        if (rs.next()) {
            // build the object
            x=ContractDetailLogData.createValue();
            
            x.setContractDetailLogId(rs.getInt(1));
            x.setContractItemId(rs.getInt(2));
            x.setDate(rs.getDate(3));
            x.setTime(rs.getTimestamp(4));
            x.setChange(rs.getString(5));

        } else {
            rs.close();
            stmt.close();
            throw new DataNotFoundException("CONTRACT_DETAIL_LOG_ID :" + pContractDetailLogId);
        }

        rs.close();
        stmt.close();

        return x;
    }

    /**
     * Gets a ContractDetailLogDataVector object that consists
     * of ContractDetailLogData objects that match the supplied
     * criteria.
     * @param pCon An open database connection.
     * @param pCriteria A DBCriteria with the SQL 'where clause'
     * @return new ContractDetailLogDataVector()
     * @throws            SQLException
     */
    public static ContractDetailLogDataVector select(Connection pCon, DBCriteria pCriteria)
        throws SQLException{
        // Specify the maximum row limit to zero, unlimited size.
        return select(pCon, pCriteria, 0);
    }

    /**
    *@Returns a String of the columns suitable for using in a sql statement that may then be parsed into a ContractDetailLogData Object
    *using the parseResultSet method.
    */
    public String getSelectColumns(){
        return "CLW_CONTRACT_DETAIL_LOG.CONTRACT_DETAIL_LOG_ID,CLW_CONTRACT_DETAIL_LOG.CONTRACT_ITEM_ID,CLW_CONTRACT_DETAIL_LOG.CLW_DATE,CLW_CONTRACT_DETAIL_LOG.CLW_TIME,CLW_CONTRACT_DETAIL_LOG.CHANGE";
    }


    /**
    *Parses a result set into a value object.  Uses the position of the columns as its key so this method should only
    *be used in conjunction with the getSelectColumns() method or the wrong data will be parsed into the wrong properties.
    *The result set is not incremented, so calls to this method leave the resultset object unchanged.
    *@param ResultSet an open result set.
    *@returns a populated ContractDetailLogData Object.
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
    *@returns a populated ContractDetailLogData Object.
    *@throws SQLException
    */
    public com.cleanwise.service.api.framework.ValueObject parseResultSet(ResultSet rs, int offset) throws SQLException{
         // build the object
         ContractDetailLogData x = ContractDetailLogData.createValue();
         
         x.setContractDetailLogId(rs.getInt(1+offset));
         x.setContractItemId(rs.getInt(2+offset));
         x.setDate(rs.getDate(3+offset));
         x.setTime(rs.getTimestamp(4+offset));
         x.setChange(rs.getString(5+offset));
         return x;
    }

    /**
    *@Returns a count of the number of columns the ContractDetailLogData Object represents.
    */
    public int getColumnCount(){
        return 5;
    }

    /**
     * Gets a ContractDetailLogDataVector object that consists
     * of ContractDetailLogData objects that match the supplied
     * criteria.
     * @param pCon An open database connection.
     * @param pCriteria A DBCriteria with the SQL 'where clause'
     * @param pMaxRows the maximum number of rows to return.
     * @return new ContractDetailLogDataVector()
     * @throws            SQLException
     */
    public static ContractDetailLogDataVector select(Connection pCon, DBCriteria pCriteria, int pMaxRows)
        throws SQLException{
        StringBuffer sqlBuf;
        Collection otherTables = pCriteria.getJoinTables();
        String where;
        if(otherTables == null || otherTables.isEmpty()){
                sqlBuf = new StringBuffer("SELECT CONTRACT_DETAIL_LOG_ID,CONTRACT_ITEM_ID,CLW_DATE,CLW_TIME,CHANGE FROM CLW_CONTRACT_DETAIL_LOG");
                where = pCriteria.getSqlClause();
        }else{
                sqlBuf = new StringBuffer("SELECT CLW_CONTRACT_DETAIL_LOG.CONTRACT_DETAIL_LOG_ID,CLW_CONTRACT_DETAIL_LOG.CONTRACT_ITEM_ID,CLW_CONTRACT_DETAIL_LOG.CLW_DATE,CLW_CONTRACT_DETAIL_LOG.CLW_TIME,CLW_CONTRACT_DETAIL_LOG.CHANGE FROM CLW_CONTRACT_DETAIL_LOG");
                where = pCriteria.getSqlClause("CLW_CONTRACT_DETAIL_LOG");

                Iterator it = otherTables.iterator();
                while(it.hasNext()){
                        String otherTable = (String) it.next();
                        if(!CLW_CONTRACT_DETAIL_LOG.equals(otherTable)){
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
        ContractDetailLogDataVector v = new ContractDetailLogDataVector();
        while (rs.next()) {
            ContractDetailLogData x = ContractDetailLogData.createValue();
            
            x.setContractDetailLogId(rs.getInt(1));
            x.setContractItemId(rs.getInt(2));
            x.setDate(rs.getDate(3));
            x.setTime(rs.getTimestamp(4));
            x.setChange(rs.getString(5));
            v.add(x);
        }

        rs.close();
        stmt.close();

        return v;
    }

    /**
     * Gets a ContractDetailLogDataVector object that consists
     * of ContractDetailLogData objects with the keys requested.
     * @param pCon An open database connection.
     * @param pIdVector A collection of keys for ContractDetailLogData
     * to retrieve from the database (i.e. select 'IN' pIdVector)
     * @return new ContractDetailLogDataVector()
     * @throws            SQLException
     */
    public static ContractDetailLogDataVector select(Connection pCon, IdVector pIdVector)
        throws SQLException{
        ContractDetailLogDataVector v = new ContractDetailLogDataVector();
        StringBuffer sqlBuf = new StringBuffer("SELECT CONTRACT_DETAIL_LOG_ID,CONTRACT_ITEM_ID,CLW_DATE,CLW_TIME,CHANGE FROM CLW_CONTRACT_DETAIL_LOG WHERE CONTRACT_DETAIL_LOG_ID IN (");

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
            ContractDetailLogData x=null;
            while (rs.next()) {
                // build the object
                x=ContractDetailLogData.createValue();
                
                x.setContractDetailLogId(rs.getInt(1));
                x.setContractItemId(rs.getInt(2));
                x.setDate(rs.getDate(3));
                x.setTime(rs.getTimestamp(4));
                x.setChange(rs.getString(5));
                v.add(x);
            }

            rs.close();
            stmt.close();
        }

        return v;
    }

    /**
     * Gets a ContractDetailLogDataVector object of all
     * ContractDetailLogData objects in the database.
     * @param pCon An open database connection.
     * @return new ContractDetailLogDataVector()
     * @throws            SQLException
     */
    public static ContractDetailLogDataVector selectAll(Connection pCon)
        throws SQLException{
        String sql = "SELECT CONTRACT_DETAIL_LOG_ID,CONTRACT_ITEM_ID,CLW_DATE,CLW_TIME,CHANGE FROM CLW_CONTRACT_DETAIL_LOG";

        if (log.isDebugEnabled()) {
            log.debug("SQL: " + sql);
        }

        Statement stmt = pCon.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        ContractDetailLogDataVector v = new ContractDetailLogDataVector();
        ContractDetailLogData x = null;
        while (rs.next()) {
            // build the object
            x = ContractDetailLogData.createValue();
            
            x.setContractDetailLogId(rs.getInt(1));
            x.setContractItemId(rs.getInt(2));
            x.setDate(rs.getDate(3));
            x.setTime(rs.getTimestamp(4));
            x.setChange(rs.getString(5));

            v.add(x);
        }

        rs.close();
        stmt.close();

        return v;
    }

    /**
     * Gets an IdVector of Integers representing the Ids of the matching
     * ContractDetailLogData objects in the database.
     * @param pCon An open database connection.
     * @param pCriteria A DBCriteria with the SQL 'where clause'
     * @return new IdVector()
     * @throws            SQLException
     */
    public static IdVector selectIdOnly(Connection pCon, DBCriteria pCriteria)
        throws SQLException{
        StringBuffer sqlBuf = new StringBuffer("SELECT CONTRACT_DETAIL_LOG_ID FROM CLW_CONTRACT_DETAIL_LOG");
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
        StringBuffer sqlBuf = new StringBuffer("SELECT DISTINCT "+pIdName+" FROM CLW_CONTRACT_DETAIL_LOG");
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
        StringBuffer sqlBuf = new StringBuffer("SELECT DISTINCT "+pIdName+" FROM CLW_CONTRACT_DETAIL_LOG");
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
     * Inserts a ContractDetailLogData object into the database.
     * @param pCon  An open database connection.
     * @param pData  A ContractDetailLogData object to insert.
     * @return new ContractDetailLogData() with the generated
     *         key set
     * @throws            SQLException
     */
    public static ContractDetailLogData insert(Connection pCon, ContractDetailLogData pData)
        throws SQLException {

        if (log.isDebugEnabled()) {
            log.debug("SELECT CLW_CONTRACT_DETAIL_LOG_SEQ.NEXTVAL FROM DUAL");
        }
        String exceptionMessage=null;
        Statement stmt = pCon.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT CLW_CONTRACT_DETAIL_LOG_SEQ.NEXTVAL FROM DUAL");
        rs.next();
        pData.setContractDetailLogId(rs.getInt(1));
        stmt.close();

        String sql = "INSERT INTO CLW_CONTRACT_DETAIL_LOG (CONTRACT_DETAIL_LOG_ID,CONTRACT_ITEM_ID,CLW_DATE,CLW_TIME,CHANGE) VALUES(?,?,?,?,?)"; PreparedStatement pstmt = pCon.prepareStatement(sql);

        
        pstmt.setInt(1,pData.getContractDetailLogId());
        pstmt.setInt(2,pData.getContractItemId());
        pstmt.setDate(3,DBAccess.toSQLDate(pData.getDate()));
        pstmt.setTimestamp(4,DBAccess.toSQLTimestamp(pData.getTime()));
        pstmt.setString(5,pData.getChange());

        if (log.isDebugEnabled()) {
            log.debug("SQL:   CONTRACT_DETAIL_LOG_ID="+pData.getContractDetailLogId());
            log.debug("SQL:   CONTRACT_ITEM_ID="+pData.getContractItemId());
            log.debug("SQL:   CLW_DATE="+pData.getDate());
            log.debug("SQL:   CLW_TIME="+pData.getTime());
            log.debug("SQL:   CHANGE="+pData.getChange());
            log.debug("SQL: " + sql);
        }
        try {
        pstmt.executeUpdate();
        pData.setDirty(false);
        }
        catch(SQLException e){
        pData.setContractDetailLogId(0);
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
     * Updates a ContractDetailLogData object in the database.
     * @param pCon  An open database connection.
     * @param pData  A ContractDetailLogData object to update. 
     * @return int Number of rows updated (0 or 1).
     * @throws            SQLException
     */
    public static int update(Connection pCon, ContractDetailLogData pData)
        throws SQLException {

        int n = 0;

        String sql = "UPDATE CLW_CONTRACT_DETAIL_LOG SET CONTRACT_ITEM_ID = ?,CLW_DATE = ?,CLW_TIME = ?,CHANGE = ? WHERE CONTRACT_DETAIL_LOG_ID = ?";

        PreparedStatement pstmt = pCon.prepareStatement(sql);

        
        int i = 1;
        
        pstmt.setInt(i++,pData.getContractItemId());
        pstmt.setDate(i++,DBAccess.toSQLDate(pData.getDate()));
        pstmt.setTimestamp(i++,DBAccess.toSQLTimestamp(pData.getTime()));
        pstmt.setString(i++,pData.getChange());
        pstmt.setInt(i++,pData.getContractDetailLogId());

        if (log.isDebugEnabled()) {
            log.debug("SQL:   CONTRACT_ITEM_ID="+pData.getContractItemId());
            log.debug("SQL:   CLW_DATE="+pData.getDate());
            log.debug("SQL:   CLW_TIME="+pData.getTime());
            log.debug("SQL:   CHANGE="+pData.getChange());
            log.debug("SQL: " + sql);
        }

        n = pstmt.executeUpdate();
        pstmt.close();

        pData.setDirty(false);

        return n;
    }

    /**
     * Deletes a ContractDetailLogData object with the specified
     * key from the database.
     * @param pCon  An open database connection.
     * @param pContractDetailLogId Key of object to be deleted.
     * @return int Number of rows deleted (0 or 1).
     * @throws            SQLException
     */
    public static int remove(Connection pCon, int pContractDetailLogId)
        throws SQLException{
        int n = 0;
        String sql="DELETE FROM CLW_CONTRACT_DETAIL_LOG WHERE CONTRACT_DETAIL_LOG_ID = " + pContractDetailLogId;

        if (log.isDebugEnabled()) {
            log.debug("SQL: " + sql);
        }

        Statement stmt = pCon.createStatement();
        n = stmt.executeUpdate(sql);
        stmt.close();

        return n;
     }

    /**
     * Deletes ContractDetailLogData objects that match the specified criteria.
     * @param pCon  An open database connection.
     * @param pCriteria A DBCriteria with the SQL 'where clause'
     * @return int Number of rows deleted.
     * @throws            SQLException
     */
    public static int remove(Connection pCon, DBCriteria pCriteria)
        throws SQLException {
        int n = 0;
        StringBuffer sqlBuf = new StringBuffer("DELETE FROM CLW_CONTRACT_DETAIL_LOG");
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
     * Inserts a ContractDetailLogData log object into the database.
     * @param pCon  An open database connection.
     * @param pData  A ContractDetailLogData object to insert
     * @param pMillis current time in milliseconds
     * @param pAction action made (I, U, D)
     * @param pStatus record status (O, N)
     * @throws            SQLException
     */
    public static void insertLog(Connection pCon, ContractDetailLogData pData, long pMillis, String pAction, String pStatus)
        throws SQLException {

        String sql = "INSERT INTO LCLW_CONTRACT_DETAIL_LOG (LOG_DATE_MS,LOG_DATE,ACTION, STATUS,"+
          "CONTRACT_DETAIL_LOG_ID,CONTRACT_ITEM_ID,CLW_DATE,CLW_TIME,CHANGE) VALUES(?,?,?,?,?,?,?,?,?)";

        PreparedStatement pstmt = pCon.prepareStatement(sql);
        
        pstmt.setLong(1,pMillis);
        pstmt.setTimestamp(2,DBAccess.toSQLTimestamp(new java.util.Date(pMillis)));
        pstmt.setString(3,pAction);
        pstmt.setString(4,pStatus);

        pstmt.setInt(1+4,pData.getContractDetailLogId());
        pstmt.setInt(2+4,pData.getContractItemId());
        pstmt.setDate(3+4,DBAccess.toSQLDate(pData.getDate()));
        pstmt.setTimestamp(4+4,DBAccess.toSQLTimestamp(pData.getTime()));
        pstmt.setString(5+4,pData.getChange());


        pstmt.executeUpdate();
        pstmt.close();
    }




///////////////////////////////////////////////
    /**
     * Inserts a ContractDetailLogData object into the database.
     * @param pCon  An open database connection.
     * @param pData  A ContractDetailLogData object to insert.
     * @param pLogFl  Creates record in log table if true
     * @return new ContractDetailLogData() with the generated
     *         key set
     * @throws            SQLException
     */
    public static ContractDetailLogData insert(Connection pCon, ContractDetailLogData pData, boolean pLogFl)
        throws SQLException {
        pData = insert(pCon, pData);

        if(pLogFl) {
          long millis = System.currentTimeMillis();
          insertLog(pCon, pData, millis, "I", "N");
        }

        return pData;
    }

    /**
     * Updates a ContractDetailLogData object in the database.
     * @param pCon  An open database connection.
     * @param pData  A ContractDetailLogData object to update. 
     * @param pLogFl  Creates record in log table if true
     * @return int Number of rows updated (0 or 1).
     * @throws            SQLException
     */
    public static int update(Connection pCon, ContractDetailLogData pData, boolean pLogFl)
        throws SQLException {
        ContractDetailLogData oldData = null;
        if(pLogFl) {
          int id = pData.getContractDetailLogId();
          try {
          oldData = ContractDetailLogDataAccess.select(pCon,id);
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
     * Deletes a ContractDetailLogData object with the specified
     * key from the database.
     * @param pCon  An open database connection.
     * @param pContractDetailLogId Key of object to be deleted.
     * @param pLogFl  Create record in log table if true
     * @return int Number of rows deleted (0 or 1).
     * @throws            SQLException
     */
    public static int remove(Connection pCon, int pContractDetailLogId, boolean pLogFl)
        throws SQLException{
        if(pLogFl){
          long millis = System.currentTimeMillis();
          java.util.Date rmDate = new java.util.Date(millis);
          java.text.SimpleDateFormat smf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          String oracleDate = "to_date('"+smf.format(rmDate)+"','YYYY-MM-DD HH24:MI:SS')";
          String sqlLog ="INSERT INTO LCLW_CONTRACT_DETAIL_LOG SELECT "+millis+ ","+oracleDate+",'D','O',d.* FROM CLW_CONTRACT_DETAIL_LOG d WHERE CONTRACT_DETAIL_LOG_ID = " + pContractDetailLogId;
          Statement stmt = pCon.createStatement();
          stmt.executeUpdate(sqlLog);
           stmt.close();
        }
        int n = remove(pCon,pContractDetailLogId);
        return n;
     }

    /**
     * Deletes ContractDetailLogData objects that match the specified criteria.
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
             new StringBuffer("INSERT INTO LCLW_CONTRACT_DETAIL_LOG SELECT "+millis+ ","+oracleDate+",'D','O',d.* FROM CLW_CONTRACT_DETAIL_LOG d ");
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

