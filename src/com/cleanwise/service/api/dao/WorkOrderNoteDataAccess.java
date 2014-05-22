
/* DO NOT EDIT - Generated code from XSL file DataAccess.xsl */

package com.cleanwise.service.api.dao;

/**
 * Title:        WorkOrderNoteDataAccess
 * Description:  This class is used to build access methods to the CLW_WORK_ORDER_NOTE table.
 * Purpose:
 * Copyright:    Copyright (c) 2001
 * Company:      CleanWise, Inc.
 * @author       Generated Code from XSL file DataAccess.xsl
 */

import com.cleanwise.service.api.value.WorkOrderNoteData;
import com.cleanwise.service.api.value.WorkOrderNoteDataVector;
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
 * <code>WorkOrderNoteDataAccess</code>
 */
public class WorkOrderNoteDataAccess extends DataAccessImpl
{
    private static Category log = Category.getInstance(WorkOrderNoteDataAccess.class.getName());

    /** <code>CLW_WORK_ORDER_NOTE</code> table name */
	/* Primary key: WORK_ORDER_NOTE_ID */
	
    public static final String CLW_WORK_ORDER_NOTE = "CLW_WORK_ORDER_NOTE";
    
    /** <code>WORK_ORDER_NOTE_ID</code> WORK_ORDER_NOTE_ID column of table CLW_WORK_ORDER_NOTE */
    public static final String WORK_ORDER_NOTE_ID = "WORK_ORDER_NOTE_ID";
    /** <code>WORK_ORDER_ID</code> WORK_ORDER_ID column of table CLW_WORK_ORDER_NOTE */
    public static final String WORK_ORDER_ID = "WORK_ORDER_ID";
    /** <code>SHORT_DESC</code> SHORT_DESC column of table CLW_WORK_ORDER_NOTE */
    public static final String SHORT_DESC = "SHORT_DESC";
    /** <code>NOTE</code> NOTE column of table CLW_WORK_ORDER_NOTE */
    public static final String NOTE = "NOTE";
    /** <code>TYPE_CD</code> TYPE_CD column of table CLW_WORK_ORDER_NOTE */
    public static final String TYPE_CD = "TYPE_CD";
    /** <code>ADD_DATE</code> ADD_DATE column of table CLW_WORK_ORDER_NOTE */
    public static final String ADD_DATE = "ADD_DATE";
    /** <code>ADD_BY</code> ADD_BY column of table CLW_WORK_ORDER_NOTE */
    public static final String ADD_BY = "ADD_BY";
    /** <code>MOD_DATE</code> MOD_DATE column of table CLW_WORK_ORDER_NOTE */
    public static final String MOD_DATE = "MOD_DATE";
    /** <code>MOD_BY</code> MOD_BY column of table CLW_WORK_ORDER_NOTE */
    public static final String MOD_BY = "MOD_BY";

    /**
     * Constructor.
     */
    public WorkOrderNoteDataAccess()
    {
    }

    /**
     * Gets a WorkOrderNoteData object with the specified
     * key from the database.
     * @param pCon An open database connection.
     * @param pWorkOrderNoteId The key requested.
     * @return new WorkOrderNoteData()
     * @throws            SQLException
     */
    public static WorkOrderNoteData select(Connection pCon, int pWorkOrderNoteId)
        throws SQLException, DataNotFoundException {
        WorkOrderNoteData x=null;
        String sql="SELECT WORK_ORDER_NOTE_ID,WORK_ORDER_ID,SHORT_DESC,NOTE,TYPE_CD,ADD_DATE,ADD_BY,MOD_DATE,MOD_BY FROM CLW_WORK_ORDER_NOTE WHERE WORK_ORDER_NOTE_ID = ?";

        if (log.isDebugEnabled()) {
            log.debug("SQL: pWorkOrderNoteId=" + pWorkOrderNoteId);
            log.debug("SQL: " + sql);
        }

        PreparedStatement stmt = pCon.prepareStatement(sql);
        stmt.setInt(1,pWorkOrderNoteId);
        ResultSet rs=stmt.executeQuery();
        if (rs.next()) {
            // build the object
            x=WorkOrderNoteData.createValue();
            
            x.setWorkOrderNoteId(rs.getInt(1));
            x.setWorkOrderId(rs.getInt(2));
            x.setShortDesc(rs.getString(3));
            x.setNote(rs.getString(4));
            x.setTypeCd(rs.getString(5));
            x.setAddDate(rs.getTimestamp(6));
            x.setAddBy(rs.getString(7));
            x.setModDate(rs.getTimestamp(8));
            x.setModBy(rs.getString(9));

        } else {
            rs.close();
            stmt.close();
            throw new DataNotFoundException("WORK_ORDER_NOTE_ID :" + pWorkOrderNoteId);
        }

        rs.close();
        stmt.close();

        return x;
    }

    /**
     * Gets a WorkOrderNoteDataVector object that consists
     * of WorkOrderNoteData objects that match the supplied
     * criteria.
     * @param pCon An open database connection.
     * @param pCriteria A DBCriteria with the SQL 'where clause'
     * @return new WorkOrderNoteDataVector()
     * @throws            SQLException
     */
    public static WorkOrderNoteDataVector select(Connection pCon, DBCriteria pCriteria)
        throws SQLException{
        // Specify the maximum row limit to zero, unlimited size.
        return select(pCon, pCriteria, 0);
    }

    /**
    *@Returns a String of the columns suitable for using in a sql statement that may then be parsed into a WorkOrderNoteData Object
    *using the parseResultSet method.
    */
    public String getSelectColumns(){
        return "CLW_WORK_ORDER_NOTE.WORK_ORDER_NOTE_ID,CLW_WORK_ORDER_NOTE.WORK_ORDER_ID,CLW_WORK_ORDER_NOTE.SHORT_DESC,CLW_WORK_ORDER_NOTE.NOTE,CLW_WORK_ORDER_NOTE.TYPE_CD,CLW_WORK_ORDER_NOTE.ADD_DATE,CLW_WORK_ORDER_NOTE.ADD_BY,CLW_WORK_ORDER_NOTE.MOD_DATE,CLW_WORK_ORDER_NOTE.MOD_BY";
    }


    /**
    *Parses a result set into a value object.  Uses the position of the columns as its key so this method should only
    *be used in conjunction with the getSelectColumns() method or the wrong data will be parsed into the wrong properties.
    *The result set is not incremented, so calls to this method leave the resultset object unchanged.
    *@param ResultSet an open result set.
    *@returns a populated WorkOrderNoteData Object.
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
    *@returns a populated WorkOrderNoteData Object.
    *@throws SQLException
    */
    public com.cleanwise.service.api.framework.ValueObject parseResultSet(ResultSet rs, int offset) throws SQLException{
         // build the object
         WorkOrderNoteData x = WorkOrderNoteData.createValue();
         
         x.setWorkOrderNoteId(rs.getInt(1+offset));
         x.setWorkOrderId(rs.getInt(2+offset));
         x.setShortDesc(rs.getString(3+offset));
         x.setNote(rs.getString(4+offset));
         x.setTypeCd(rs.getString(5+offset));
         x.setAddDate(rs.getTimestamp(6+offset));
         x.setAddBy(rs.getString(7+offset));
         x.setModDate(rs.getTimestamp(8+offset));
         x.setModBy(rs.getString(9+offset));
         return x;
    }

    /**
    *@Returns a count of the number of columns the WorkOrderNoteData Object represents.
    */
    public int getColumnCount(){
        return 9;
    }

    /**
     * Gets a WorkOrderNoteDataVector object that consists
     * of WorkOrderNoteData objects that match the supplied
     * criteria.
     * @param pCon An open database connection.
     * @param pCriteria A DBCriteria with the SQL 'where clause'
     * @param pMaxRows the maximum number of rows to return.
     * @return new WorkOrderNoteDataVector()
     * @throws            SQLException
     */
    public static WorkOrderNoteDataVector select(Connection pCon, DBCriteria pCriteria, int pMaxRows)
        throws SQLException{
        StringBuffer sqlBuf;
        Collection otherTables = pCriteria.getJoinTables();
        String where;
        if(otherTables == null || otherTables.isEmpty()){
                sqlBuf = new StringBuffer("SELECT WORK_ORDER_NOTE_ID,WORK_ORDER_ID,SHORT_DESC,NOTE,TYPE_CD,ADD_DATE,ADD_BY,MOD_DATE,MOD_BY FROM CLW_WORK_ORDER_NOTE");
                where = pCriteria.getSqlClause();
        }else{
                sqlBuf = new StringBuffer("SELECT CLW_WORK_ORDER_NOTE.WORK_ORDER_NOTE_ID,CLW_WORK_ORDER_NOTE.WORK_ORDER_ID,CLW_WORK_ORDER_NOTE.SHORT_DESC,CLW_WORK_ORDER_NOTE.NOTE,CLW_WORK_ORDER_NOTE.TYPE_CD,CLW_WORK_ORDER_NOTE.ADD_DATE,CLW_WORK_ORDER_NOTE.ADD_BY,CLW_WORK_ORDER_NOTE.MOD_DATE,CLW_WORK_ORDER_NOTE.MOD_BY FROM CLW_WORK_ORDER_NOTE");
                where = pCriteria.getSqlClause("CLW_WORK_ORDER_NOTE");

                Iterator it = otherTables.iterator();
                while(it.hasNext()){
                        String otherTable = (String) it.next();
                        if(!CLW_WORK_ORDER_NOTE.equals(otherTable)){
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
        WorkOrderNoteDataVector v = new WorkOrderNoteDataVector();
        while (rs.next()) {
            WorkOrderNoteData x = WorkOrderNoteData.createValue();
            
            x.setWorkOrderNoteId(rs.getInt(1));
            x.setWorkOrderId(rs.getInt(2));
            x.setShortDesc(rs.getString(3));
            x.setNote(rs.getString(4));
            x.setTypeCd(rs.getString(5));
            x.setAddDate(rs.getTimestamp(6));
            x.setAddBy(rs.getString(7));
            x.setModDate(rs.getTimestamp(8));
            x.setModBy(rs.getString(9));
            v.add(x);
        }

        rs.close();
        stmt.close();

        return v;
    }

    /**
     * Gets a WorkOrderNoteDataVector object that consists
     * of WorkOrderNoteData objects with the keys requested.
     * @param pCon An open database connection.
     * @param pIdVector A collection of keys for WorkOrderNoteData
     * to retrieve from the database (i.e. select 'IN' pIdVector)
     * @return new WorkOrderNoteDataVector()
     * @throws            SQLException
     */
    public static WorkOrderNoteDataVector select(Connection pCon, IdVector pIdVector)
        throws SQLException{
        WorkOrderNoteDataVector v = new WorkOrderNoteDataVector();
        StringBuffer sqlBuf = new StringBuffer("SELECT WORK_ORDER_NOTE_ID,WORK_ORDER_ID,SHORT_DESC,NOTE,TYPE_CD,ADD_DATE,ADD_BY,MOD_DATE,MOD_BY FROM CLW_WORK_ORDER_NOTE WHERE WORK_ORDER_NOTE_ID IN (");

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
            WorkOrderNoteData x=null;
            while (rs.next()) {
                // build the object
                x=WorkOrderNoteData.createValue();
                
                x.setWorkOrderNoteId(rs.getInt(1));
                x.setWorkOrderId(rs.getInt(2));
                x.setShortDesc(rs.getString(3));
                x.setNote(rs.getString(4));
                x.setTypeCd(rs.getString(5));
                x.setAddDate(rs.getTimestamp(6));
                x.setAddBy(rs.getString(7));
                x.setModDate(rs.getTimestamp(8));
                x.setModBy(rs.getString(9));
                v.add(x);
            }

            rs.close();
            stmt.close();
        }

        return v;
    }

    /**
     * Gets a WorkOrderNoteDataVector object of all
     * WorkOrderNoteData objects in the database.
     * @param pCon An open database connection.
     * @return new WorkOrderNoteDataVector()
     * @throws            SQLException
     */
    public static WorkOrderNoteDataVector selectAll(Connection pCon)
        throws SQLException{
        String sql = "SELECT WORK_ORDER_NOTE_ID,WORK_ORDER_ID,SHORT_DESC,NOTE,TYPE_CD,ADD_DATE,ADD_BY,MOD_DATE,MOD_BY FROM CLW_WORK_ORDER_NOTE";

        if (log.isDebugEnabled()) {
            log.debug("SQL: " + sql);
        }

        Statement stmt = pCon.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        WorkOrderNoteDataVector v = new WorkOrderNoteDataVector();
        WorkOrderNoteData x = null;
        while (rs.next()) {
            // build the object
            x = WorkOrderNoteData.createValue();
            
            x.setWorkOrderNoteId(rs.getInt(1));
            x.setWorkOrderId(rs.getInt(2));
            x.setShortDesc(rs.getString(3));
            x.setNote(rs.getString(4));
            x.setTypeCd(rs.getString(5));
            x.setAddDate(rs.getTimestamp(6));
            x.setAddBy(rs.getString(7));
            x.setModDate(rs.getTimestamp(8));
            x.setModBy(rs.getString(9));

            v.add(x);
        }

        rs.close();
        stmt.close();

        return v;
    }

    /**
     * Gets an IdVector of Integers representing the Ids of the matching
     * WorkOrderNoteData objects in the database.
     * @param pCon An open database connection.
     * @param pCriteria A DBCriteria with the SQL 'where clause'
     * @return new IdVector()
     * @throws            SQLException
     */
    public static IdVector selectIdOnly(Connection pCon, DBCriteria pCriteria)
        throws SQLException{
        StringBuffer sqlBuf = new StringBuffer("SELECT WORK_ORDER_NOTE_ID FROM CLW_WORK_ORDER_NOTE");
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
        StringBuffer sqlBuf = new StringBuffer("SELECT DISTINCT "+pIdName+" FROM CLW_WORK_ORDER_NOTE");
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
        StringBuffer sqlBuf = new StringBuffer("SELECT DISTINCT "+pIdName+" FROM CLW_WORK_ORDER_NOTE");
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
     * Inserts a WorkOrderNoteData object into the database.
     * @param pCon  An open database connection.
     * @param pData  A WorkOrderNoteData object to insert.
     * The object id will be set to the one generated.  The "AddDate" and
     * "ModDate" fields will be set to the current date. 
     * @return new WorkOrderNoteData() with the generated
     *         key set
     * @throws            SQLException
     */
    public static WorkOrderNoteData insert(Connection pCon, WorkOrderNoteData pData)
        throws SQLException {

        if (log.isDebugEnabled()) {
            log.debug("SELECT CLW_WORK_ORDER_NOTE_SEQ.NEXTVAL FROM DUAL");
        }
        String exceptionMessage=null;
        Statement stmt = pCon.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT CLW_WORK_ORDER_NOTE_SEQ.NEXTVAL FROM DUAL");
        rs.next();
        pData.setWorkOrderNoteId(rs.getInt(1));
        stmt.close();

        String sql = "INSERT INTO CLW_WORK_ORDER_NOTE (WORK_ORDER_NOTE_ID,WORK_ORDER_ID,SHORT_DESC,NOTE,TYPE_CD,ADD_DATE,ADD_BY,MOD_DATE,MOD_BY) VALUES(?,?,?,?,?,?,?,?,?)"; PreparedStatement pstmt = pCon.prepareStatement(sql);

        
        java.util.Date current = new java.util.Date(System.currentTimeMillis());
        pData.setAddDate(current);
        pData.setModDate(current);

        pstmt.setInt(1,pData.getWorkOrderNoteId());
        pstmt.setInt(2,pData.getWorkOrderId());
        pstmt.setString(3,pData.getShortDesc());
        pstmt.setString(4,pData.getNote());
        pstmt.setString(5,pData.getTypeCd());
        pstmt.setTimestamp(6,DBAccess.toSQLTimestamp(pData.getAddDate()));
        pstmt.setString(7,pData.getAddBy());
        pstmt.setTimestamp(8,DBAccess.toSQLTimestamp(pData.getModDate()));
        pstmt.setString(9,pData.getModBy());

        if (log.isDebugEnabled()) {
            log.debug("SQL:   WORK_ORDER_NOTE_ID="+pData.getWorkOrderNoteId());
            log.debug("SQL:   WORK_ORDER_ID="+pData.getWorkOrderId());
            log.debug("SQL:   SHORT_DESC="+pData.getShortDesc());
            log.debug("SQL:   NOTE="+pData.getNote());
            log.debug("SQL:   TYPE_CD="+pData.getTypeCd());
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
        pData.setWorkOrderNoteId(0);
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
     * Updates a WorkOrderNoteData object in the database.
     * @param pCon  An open database connection.
     * @param pData  A WorkOrderNoteData object to update. 
     * The "ModDate" field of the object will be set to the current date.
     * @return int Number of rows updated (0 or 1).
     * @throws            SQLException
     */
    public static int update(Connection pCon, WorkOrderNoteData pData)
        throws SQLException {

        int n = 0;

        String sql = "UPDATE CLW_WORK_ORDER_NOTE SET WORK_ORDER_ID = ?,SHORT_DESC = ?,NOTE = ?,TYPE_CD = ?,ADD_DATE = ?,ADD_BY = ?,MOD_DATE = ?,MOD_BY = ? WHERE WORK_ORDER_NOTE_ID = ?";

        PreparedStatement pstmt = pCon.prepareStatement(sql);

        
        pData.setModDate(new java.util.Date(System.currentTimeMillis()));

        int i = 1;
        
        pstmt.setInt(i++,pData.getWorkOrderId());
        pstmt.setString(i++,pData.getShortDesc());
        pstmt.setString(i++,pData.getNote());
        pstmt.setString(i++,pData.getTypeCd());
        pstmt.setTimestamp(i++,DBAccess.toSQLTimestamp(pData.getAddDate()));
        pstmt.setString(i++,pData.getAddBy());
        pstmt.setTimestamp(i++,DBAccess.toSQLTimestamp(pData.getModDate()));
        pstmt.setString(i++,pData.getModBy());
        pstmt.setInt(i++,pData.getWorkOrderNoteId());

        if (log.isDebugEnabled()) {
            log.debug("SQL:   WORK_ORDER_ID="+pData.getWorkOrderId());
            log.debug("SQL:   SHORT_DESC="+pData.getShortDesc());
            log.debug("SQL:   NOTE="+pData.getNote());
            log.debug("SQL:   TYPE_CD="+pData.getTypeCd());
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
     * Deletes a WorkOrderNoteData object with the specified
     * key from the database.
     * @param pCon  An open database connection.
     * @param pWorkOrderNoteId Key of object to be deleted.
     * @return int Number of rows deleted (0 or 1).
     * @throws            SQLException
     */
    public static int remove(Connection pCon, int pWorkOrderNoteId)
        throws SQLException{
        int n = 0;
        String sql="DELETE FROM CLW_WORK_ORDER_NOTE WHERE WORK_ORDER_NOTE_ID = " + pWorkOrderNoteId;

        if (log.isDebugEnabled()) {
            log.debug("SQL: " + sql);
        }

        Statement stmt = pCon.createStatement();
        n = stmt.executeUpdate(sql);
        stmt.close();

        return n;
     }

    /**
     * Deletes WorkOrderNoteData objects that match the specified criteria.
     * @param pCon  An open database connection.
     * @param pCriteria A DBCriteria with the SQL 'where clause'
     * @return int Number of rows deleted.
     * @throws            SQLException
     */
    public static int remove(Connection pCon, DBCriteria pCriteria)
        throws SQLException {
        int n = 0;
        StringBuffer sqlBuf = new StringBuffer("DELETE FROM CLW_WORK_ORDER_NOTE");
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
     * Inserts a WorkOrderNoteData log object into the database.
     * @param pCon  An open database connection.
     * @param pData  A WorkOrderNoteData object to insert
     * @param pMillis current time in milliseconds
     * @param pAction action made (I, U, D)
     * @param pStatus record status (O, N)
     * @throws            SQLException
     */
    public static void insertLog(Connection pCon, WorkOrderNoteData pData, long pMillis, String pAction, String pStatus)
        throws SQLException {

        String sql = "INSERT INTO LCLW_WORK_ORDER_NOTE (LOG_DATE_MS,LOG_DATE,ACTION, STATUS,"+
          "WORK_ORDER_NOTE_ID,WORK_ORDER_ID,SHORT_DESC,NOTE,TYPE_CD,ADD_DATE,ADD_BY,MOD_DATE,MOD_BY) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement pstmt = pCon.prepareStatement(sql);
        
        pstmt.setLong(1,pMillis);
        pstmt.setTimestamp(2,DBAccess.toSQLTimestamp(new java.util.Date(pMillis)));
        pstmt.setString(3,pAction);
        pstmt.setString(4,pStatus);

        pstmt.setInt(1+4,pData.getWorkOrderNoteId());
        pstmt.setInt(2+4,pData.getWorkOrderId());
        pstmt.setString(3+4,pData.getShortDesc());
        pstmt.setString(4+4,pData.getNote());
        pstmt.setString(5+4,pData.getTypeCd());
        pstmt.setTimestamp(6+4,DBAccess.toSQLTimestamp(pData.getAddDate()));
        pstmt.setString(7+4,pData.getAddBy());
        pstmt.setTimestamp(8+4,DBAccess.toSQLTimestamp(pData.getModDate()));
        pstmt.setString(9+4,pData.getModBy());


        pstmt.executeUpdate();
        pstmt.close();
    }




///////////////////////////////////////////////
    /**
     * Inserts a WorkOrderNoteData object into the database.
     * @param pCon  An open database connection.
     * @param pData  A WorkOrderNoteData object to insert.
     * The object id will be set to the one generated.  The "AddDate" and
     * "ModDate" fields will be set to the current date. 
     * @param pLogFl  Creates record in log table if true
     * @return new WorkOrderNoteData() with the generated
     *         key set
     * @throws            SQLException
     */
    public static WorkOrderNoteData insert(Connection pCon, WorkOrderNoteData pData, boolean pLogFl)
        throws SQLException {
        pData = insert(pCon, pData);

        if(pLogFl) {
          long millis = System.currentTimeMillis();
          insertLog(pCon, pData, millis, "I", "N");
        }

        return pData;
    }

    /**
     * Updates a WorkOrderNoteData object in the database.
     * @param pCon  An open database connection.
     * @param pData  A WorkOrderNoteData object to update. 
     * The "ModDate" field of the object will be set to the current date.
     * @param pLogFl  Creates record in log table if true
     * @return int Number of rows updated (0 or 1).
     * @throws            SQLException
     */
    public static int update(Connection pCon, WorkOrderNoteData pData, boolean pLogFl)
        throws SQLException {
        WorkOrderNoteData oldData = null;
        if(pLogFl) {
          int id = pData.getWorkOrderNoteId();
          try {
          oldData = WorkOrderNoteDataAccess.select(pCon,id);
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
     * Deletes a WorkOrderNoteData object with the specified
     * key from the database.
     * @param pCon  An open database connection.
     * @param pWorkOrderNoteId Key of object to be deleted.
     * @param pLogFl  Create record in log table if true
     * @return int Number of rows deleted (0 or 1).
     * @throws            SQLException
     */
    public static int remove(Connection pCon, int pWorkOrderNoteId, boolean pLogFl)
        throws SQLException{
        if(pLogFl){
          long millis = System.currentTimeMillis();
          java.util.Date rmDate = new java.util.Date(millis);
          java.text.SimpleDateFormat smf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          String oracleDate = "to_date('"+smf.format(rmDate)+"','YYYY-MM-DD HH24:MI:SS')";
          String sqlLog ="INSERT INTO LCLW_WORK_ORDER_NOTE SELECT "+millis+ ","+oracleDate+",'D','O',d.* FROM CLW_WORK_ORDER_NOTE d WHERE WORK_ORDER_NOTE_ID = " + pWorkOrderNoteId;
          Statement stmt = pCon.createStatement();
          stmt.executeUpdate(sqlLog);
           stmt.close();
        }
        int n = remove(pCon,pWorkOrderNoteId);
        return n;
     }

    /**
     * Deletes WorkOrderNoteData objects that match the specified criteria.
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
             new StringBuffer("INSERT INTO LCLW_WORK_ORDER_NOTE SELECT "+millis+ ","+oracleDate+",'D','O',d.* FROM CLW_WORK_ORDER_NOTE d ");
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

