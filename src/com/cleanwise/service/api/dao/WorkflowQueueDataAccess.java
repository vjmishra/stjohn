
/* DO NOT EDIT - Generated code from XSL file DataAccess.xsl */

package com.cleanwise.service.api.dao;

/**
 * Title:        WorkflowQueueDataAccess
 * Description:  This class is used to build access methods to the CLW_WORKFLOW_QUEUE table.
 * Purpose:
 * Copyright:    Copyright (c) 2001
 * Company:      CleanWise, Inc.
 * @author       Generated Code from XSL file DataAccess.xsl
 */

import com.cleanwise.service.api.value.WorkflowQueueData;
import com.cleanwise.service.api.value.WorkflowQueueDataVector;
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
 * <code>WorkflowQueueDataAccess</code>
 */
public class WorkflowQueueDataAccess extends DataAccessImpl
{
    private static Category log = Category.getInstance(WorkflowQueueDataAccess.class.getName());

    /** <code>CLW_WORKFLOW_QUEUE</code> table name */
	/* Primary key: WORKFLOW_QUEUE_ID */
	
    public static final String CLW_WORKFLOW_QUEUE = "CLW_WORKFLOW_QUEUE";
    
    /** <code>WORKFLOW_QUEUE_ID</code> WORKFLOW_QUEUE_ID column of table CLW_WORKFLOW_QUEUE */
    public static final String WORKFLOW_QUEUE_ID = "WORKFLOW_QUEUE_ID";
    /** <code>SHORT_DESC</code> SHORT_DESC column of table CLW_WORKFLOW_QUEUE */
    public static final String SHORT_DESC = "SHORT_DESC";
    /** <code>ORDER_ID</code> ORDER_ID column of table CLW_WORKFLOW_QUEUE */
    public static final String ORDER_ID = "ORDER_ID";
    /** <code>BUS_ENTITY_ID</code> BUS_ENTITY_ID column of table CLW_WORKFLOW_QUEUE */
    public static final String BUS_ENTITY_ID = "BUS_ENTITY_ID";
    /** <code>WORKFLOW_ROLE_CD</code> WORKFLOW_ROLE_CD column of table CLW_WORKFLOW_QUEUE */
    public static final String WORKFLOW_ROLE_CD = "WORKFLOW_ROLE_CD";
    /** <code>WORKFLOW_ID</code> WORKFLOW_ID column of table CLW_WORKFLOW_QUEUE */
    public static final String WORKFLOW_ID = "WORKFLOW_ID";
    /** <code>WORKFLOW_RULE_ID</code> WORKFLOW_RULE_ID column of table CLW_WORKFLOW_QUEUE */
    public static final String WORKFLOW_RULE_ID = "WORKFLOW_RULE_ID";
    /** <code>ADD_DATE</code> ADD_DATE column of table CLW_WORKFLOW_QUEUE */
    public static final String ADD_DATE = "ADD_DATE";
    /** <code>ADD_BY</code> ADD_BY column of table CLW_WORKFLOW_QUEUE */
    public static final String ADD_BY = "ADD_BY";
    /** <code>MOD_DATE</code> MOD_DATE column of table CLW_WORKFLOW_QUEUE */
    public static final String MOD_DATE = "MOD_DATE";
    /** <code>MOD_BY</code> MOD_BY column of table CLW_WORKFLOW_QUEUE */
    public static final String MOD_BY = "MOD_BY";
    /** <code>MESSAGE</code> MESSAGE column of table CLW_WORKFLOW_QUEUE */
    public static final String MESSAGE = "MESSAGE";

    /**
     * Constructor.
     */
    public WorkflowQueueDataAccess()
    {
    }

    /**
     * Gets a WorkflowQueueData object with the specified
     * key from the database.
     * @param pCon An open database connection.
     * @param pWorkflowQueueId The key requested.
     * @return new WorkflowQueueData()
     * @throws            SQLException
     */
    public static WorkflowQueueData select(Connection pCon, int pWorkflowQueueId)
        throws SQLException, DataNotFoundException {
        WorkflowQueueData x=null;
        String sql="SELECT WORKFLOW_QUEUE_ID,SHORT_DESC,ORDER_ID,BUS_ENTITY_ID,WORKFLOW_ROLE_CD,WORKFLOW_ID,WORKFLOW_RULE_ID,ADD_DATE,ADD_BY,MOD_DATE,MOD_BY,MESSAGE FROM CLW_WORKFLOW_QUEUE WHERE WORKFLOW_QUEUE_ID = ?";

        if (log.isDebugEnabled()) {
            log.debug("SQL: pWorkflowQueueId=" + pWorkflowQueueId);
            log.debug("SQL: " + sql);
        }

        PreparedStatement stmt = pCon.prepareStatement(sql);
        stmt.setInt(1,pWorkflowQueueId);
        ResultSet rs=stmt.executeQuery();
        if (rs.next()) {
            // build the object
            x=WorkflowQueueData.createValue();
            
            x.setWorkflowQueueId(rs.getInt(1));
            x.setShortDesc(rs.getString(2));
            x.setOrderId(rs.getInt(3));
            x.setBusEntityId(rs.getInt(4));
            x.setWorkflowRoleCd(rs.getString(5));
            x.setWorkflowId(rs.getInt(6));
            x.setWorkflowRuleId(rs.getInt(7));
            x.setAddDate(rs.getTimestamp(8));
            x.setAddBy(rs.getString(9));
            x.setModDate(rs.getTimestamp(10));
            x.setModBy(rs.getString(11));
            x.setMessage(rs.getString(12));

        } else {
            rs.close();
            stmt.close();
            throw new DataNotFoundException("WORKFLOW_QUEUE_ID :" + pWorkflowQueueId);
        }

        rs.close();
        stmt.close();

        return x;
    }

    /**
     * Gets a WorkflowQueueDataVector object that consists
     * of WorkflowQueueData objects that match the supplied
     * criteria.
     * @param pCon An open database connection.
     * @param pCriteria A DBCriteria with the SQL 'where clause'
     * @return new WorkflowQueueDataVector()
     * @throws            SQLException
     */
    public static WorkflowQueueDataVector select(Connection pCon, DBCriteria pCriteria)
        throws SQLException{
        // Specify the maximum row limit to zero, unlimited size.
        return select(pCon, pCriteria, 0);
    }

    /**
    *@Returns a String of the columns suitable for using in a sql statement that may then be parsed into a WorkflowQueueData Object
    *using the parseResultSet method.
    */
    public String getSelectColumns(){
        return "CLW_WORKFLOW_QUEUE.WORKFLOW_QUEUE_ID,CLW_WORKFLOW_QUEUE.SHORT_DESC,CLW_WORKFLOW_QUEUE.ORDER_ID,CLW_WORKFLOW_QUEUE.BUS_ENTITY_ID,CLW_WORKFLOW_QUEUE.WORKFLOW_ROLE_CD,CLW_WORKFLOW_QUEUE.WORKFLOW_ID,CLW_WORKFLOW_QUEUE.WORKFLOW_RULE_ID,CLW_WORKFLOW_QUEUE.ADD_DATE,CLW_WORKFLOW_QUEUE.ADD_BY,CLW_WORKFLOW_QUEUE.MOD_DATE,CLW_WORKFLOW_QUEUE.MOD_BY,CLW_WORKFLOW_QUEUE.MESSAGE";
    }


    /**
    *Parses a result set into a value object.  Uses the position of the columns as its key so this method should only
    *be used in conjunction with the getSelectColumns() method or the wrong data will be parsed into the wrong properties.
    *The result set is not incremented, so calls to this method leave the resultset object unchanged.
    *@param ResultSet an open result set.
    *@returns a populated WorkflowQueueData Object.
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
    *@returns a populated WorkflowQueueData Object.
    *@throws SQLException
    */
    public com.cleanwise.service.api.framework.ValueObject parseResultSet(ResultSet rs, int offset) throws SQLException{
         // build the object
         WorkflowQueueData x = WorkflowQueueData.createValue();
         
         x.setWorkflowQueueId(rs.getInt(1+offset));
         x.setShortDesc(rs.getString(2+offset));
         x.setOrderId(rs.getInt(3+offset));
         x.setBusEntityId(rs.getInt(4+offset));
         x.setWorkflowRoleCd(rs.getString(5+offset));
         x.setWorkflowId(rs.getInt(6+offset));
         x.setWorkflowRuleId(rs.getInt(7+offset));
         x.setAddDate(rs.getTimestamp(8+offset));
         x.setAddBy(rs.getString(9+offset));
         x.setModDate(rs.getTimestamp(10+offset));
         x.setModBy(rs.getString(11+offset));
         x.setMessage(rs.getString(12+offset));
         return x;
    }

    /**
    *@Returns a count of the number of columns the WorkflowQueueData Object represents.
    */
    public int getColumnCount(){
        return 12;
    }

    /**
     * Gets a WorkflowQueueDataVector object that consists
     * of WorkflowQueueData objects that match the supplied
     * criteria.
     * @param pCon An open database connection.
     * @param pCriteria A DBCriteria with the SQL 'where clause'
     * @param pMaxRows the maximum number of rows to return.
     * @return new WorkflowQueueDataVector()
     * @throws            SQLException
     */
    public static WorkflowQueueDataVector select(Connection pCon, DBCriteria pCriteria, int pMaxRows)
        throws SQLException{
        StringBuffer sqlBuf;
        Collection otherTables = pCriteria.getJoinTables();
        String where;
        if(otherTables == null || otherTables.isEmpty()){
                sqlBuf = new StringBuffer("SELECT WORKFLOW_QUEUE_ID,SHORT_DESC,ORDER_ID,BUS_ENTITY_ID,WORKFLOW_ROLE_CD,WORKFLOW_ID,WORKFLOW_RULE_ID,ADD_DATE,ADD_BY,MOD_DATE,MOD_BY,MESSAGE FROM CLW_WORKFLOW_QUEUE");
                where = pCriteria.getSqlClause();
        }else{
                sqlBuf = new StringBuffer("SELECT CLW_WORKFLOW_QUEUE.WORKFLOW_QUEUE_ID,CLW_WORKFLOW_QUEUE.SHORT_DESC,CLW_WORKFLOW_QUEUE.ORDER_ID,CLW_WORKFLOW_QUEUE.BUS_ENTITY_ID,CLW_WORKFLOW_QUEUE.WORKFLOW_ROLE_CD,CLW_WORKFLOW_QUEUE.WORKFLOW_ID,CLW_WORKFLOW_QUEUE.WORKFLOW_RULE_ID,CLW_WORKFLOW_QUEUE.ADD_DATE,CLW_WORKFLOW_QUEUE.ADD_BY,CLW_WORKFLOW_QUEUE.MOD_DATE,CLW_WORKFLOW_QUEUE.MOD_BY,CLW_WORKFLOW_QUEUE.MESSAGE FROM CLW_WORKFLOW_QUEUE");
                where = pCriteria.getSqlClause("CLW_WORKFLOW_QUEUE");

                Iterator it = otherTables.iterator();
                while(it.hasNext()){
                        String otherTable = (String) it.next();
                        if(!CLW_WORKFLOW_QUEUE.equals(otherTable)){
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
        WorkflowQueueDataVector v = new WorkflowQueueDataVector();
        while (rs.next()) {
            WorkflowQueueData x = WorkflowQueueData.createValue();
            
            x.setWorkflowQueueId(rs.getInt(1));
            x.setShortDesc(rs.getString(2));
            x.setOrderId(rs.getInt(3));
            x.setBusEntityId(rs.getInt(4));
            x.setWorkflowRoleCd(rs.getString(5));
            x.setWorkflowId(rs.getInt(6));
            x.setWorkflowRuleId(rs.getInt(7));
            x.setAddDate(rs.getTimestamp(8));
            x.setAddBy(rs.getString(9));
            x.setModDate(rs.getTimestamp(10));
            x.setModBy(rs.getString(11));
            x.setMessage(rs.getString(12));
            v.add(x);
        }

        rs.close();
        stmt.close();

        return v;
    }

    /**
     * Gets a WorkflowQueueDataVector object that consists
     * of WorkflowQueueData objects with the keys requested.
     * @param pCon An open database connection.
     * @param pIdVector A collection of keys for WorkflowQueueData
     * to retrieve from the database (i.e. select 'IN' pIdVector)
     * @return new WorkflowQueueDataVector()
     * @throws            SQLException
     */
    public static WorkflowQueueDataVector select(Connection pCon, IdVector pIdVector)
        throws SQLException{
        WorkflowQueueDataVector v = new WorkflowQueueDataVector();
        StringBuffer sqlBuf = new StringBuffer("SELECT WORKFLOW_QUEUE_ID,SHORT_DESC,ORDER_ID,BUS_ENTITY_ID,WORKFLOW_ROLE_CD,WORKFLOW_ID,WORKFLOW_RULE_ID,ADD_DATE,ADD_BY,MOD_DATE,MOD_BY,MESSAGE FROM CLW_WORKFLOW_QUEUE WHERE WORKFLOW_QUEUE_ID IN (");

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
            WorkflowQueueData x=null;
            while (rs.next()) {
                // build the object
                x=WorkflowQueueData.createValue();
                
                x.setWorkflowQueueId(rs.getInt(1));
                x.setShortDesc(rs.getString(2));
                x.setOrderId(rs.getInt(3));
                x.setBusEntityId(rs.getInt(4));
                x.setWorkflowRoleCd(rs.getString(5));
                x.setWorkflowId(rs.getInt(6));
                x.setWorkflowRuleId(rs.getInt(7));
                x.setAddDate(rs.getTimestamp(8));
                x.setAddBy(rs.getString(9));
                x.setModDate(rs.getTimestamp(10));
                x.setModBy(rs.getString(11));
                x.setMessage(rs.getString(12));
                v.add(x);
            }

            rs.close();
            stmt.close();
        }

        return v;
    }

    /**
     * Gets a WorkflowQueueDataVector object of all
     * WorkflowQueueData objects in the database.
     * @param pCon An open database connection.
     * @return new WorkflowQueueDataVector()
     * @throws            SQLException
     */
    public static WorkflowQueueDataVector selectAll(Connection pCon)
        throws SQLException{
        String sql = "SELECT WORKFLOW_QUEUE_ID,SHORT_DESC,ORDER_ID,BUS_ENTITY_ID,WORKFLOW_ROLE_CD,WORKFLOW_ID,WORKFLOW_RULE_ID,ADD_DATE,ADD_BY,MOD_DATE,MOD_BY,MESSAGE FROM CLW_WORKFLOW_QUEUE";

        if (log.isDebugEnabled()) {
            log.debug("SQL: " + sql);
        }

        Statement stmt = pCon.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        WorkflowQueueDataVector v = new WorkflowQueueDataVector();
        WorkflowQueueData x = null;
        while (rs.next()) {
            // build the object
            x = WorkflowQueueData.createValue();
            
            x.setWorkflowQueueId(rs.getInt(1));
            x.setShortDesc(rs.getString(2));
            x.setOrderId(rs.getInt(3));
            x.setBusEntityId(rs.getInt(4));
            x.setWorkflowRoleCd(rs.getString(5));
            x.setWorkflowId(rs.getInt(6));
            x.setWorkflowRuleId(rs.getInt(7));
            x.setAddDate(rs.getTimestamp(8));
            x.setAddBy(rs.getString(9));
            x.setModDate(rs.getTimestamp(10));
            x.setModBy(rs.getString(11));
            x.setMessage(rs.getString(12));

            v.add(x);
        }

        rs.close();
        stmt.close();

        return v;
    }

    /**
     * Gets an IdVector of Integers representing the Ids of the matching
     * WorkflowQueueData objects in the database.
     * @param pCon An open database connection.
     * @param pCriteria A DBCriteria with the SQL 'where clause'
     * @return new IdVector()
     * @throws            SQLException
     */
    public static IdVector selectIdOnly(Connection pCon, DBCriteria pCriteria)
        throws SQLException{
        StringBuffer sqlBuf = new StringBuffer("SELECT WORKFLOW_QUEUE_ID FROM CLW_WORKFLOW_QUEUE");
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
        StringBuffer sqlBuf = new StringBuffer("SELECT DISTINCT "+pIdName+" FROM CLW_WORKFLOW_QUEUE");
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
        StringBuffer sqlBuf = new StringBuffer("SELECT DISTINCT "+pIdName+" FROM CLW_WORKFLOW_QUEUE");
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
     * Inserts a WorkflowQueueData object into the database.
     * @param pCon  An open database connection.
     * @param pData  A WorkflowQueueData object to insert.
     * The object id will be set to the one generated.  The "AddDate" and
     * "ModDate" fields will be set to the current date. 
     * @return new WorkflowQueueData() with the generated
     *         key set
     * @throws            SQLException
     */
    public static WorkflowQueueData insert(Connection pCon, WorkflowQueueData pData)
        throws SQLException {

        if (log.isDebugEnabled()) {
            log.debug("SELECT CLW_WORKFLOW_QUEUE_SEQ.NEXTVAL FROM DUAL");
        }
        String exceptionMessage=null;
        Statement stmt = pCon.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT CLW_WORKFLOW_QUEUE_SEQ.NEXTVAL FROM DUAL");
        rs.next();
        pData.setWorkflowQueueId(rs.getInt(1));
        stmt.close();

        String sql = "INSERT INTO CLW_WORKFLOW_QUEUE (WORKFLOW_QUEUE_ID,SHORT_DESC,ORDER_ID,BUS_ENTITY_ID,WORKFLOW_ROLE_CD,WORKFLOW_ID,WORKFLOW_RULE_ID,ADD_DATE,ADD_BY,MOD_DATE,MOD_BY,MESSAGE) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)"; PreparedStatement pstmt = pCon.prepareStatement(sql);

        
        java.util.Date current = new java.util.Date(System.currentTimeMillis());
        pData.setAddDate(current);
        pData.setModDate(current);

        pstmt.setInt(1,pData.getWorkflowQueueId());
        pstmt.setString(2,pData.getShortDesc());
        if (pData.getOrderId() == 0) {
            pstmt.setNull(3, java.sql.Types.INTEGER);
        } else {
            pstmt.setInt(3,pData.getOrderId());
        }

        if (pData.getBusEntityId() == 0) {
            pstmt.setNull(4, java.sql.Types.INTEGER);
        } else {
            pstmt.setInt(4,pData.getBusEntityId());
        }

        pstmt.setString(5,pData.getWorkflowRoleCd());
        if (pData.getWorkflowId() == 0) {
            pstmt.setNull(6, java.sql.Types.INTEGER);
        } else {
            pstmt.setInt(6,pData.getWorkflowId());
        }

        if (pData.getWorkflowRuleId() == 0) {
            pstmt.setNull(7, java.sql.Types.INTEGER);
        } else {
            pstmt.setInt(7,pData.getWorkflowRuleId());
        }

        pstmt.setTimestamp(8,DBAccess.toSQLTimestamp(pData.getAddDate()));
        pstmt.setString(9,pData.getAddBy());
        pstmt.setTimestamp(10,DBAccess.toSQLTimestamp(pData.getModDate()));
        pstmt.setString(11,pData.getModBy());
        pstmt.setString(12,pData.getMessage());

        if (log.isDebugEnabled()) {
            log.debug("SQL:   WORKFLOW_QUEUE_ID="+pData.getWorkflowQueueId());
            log.debug("SQL:   SHORT_DESC="+pData.getShortDesc());
            log.debug("SQL:   ORDER_ID="+pData.getOrderId());
            log.debug("SQL:   BUS_ENTITY_ID="+pData.getBusEntityId());
            log.debug("SQL:   WORKFLOW_ROLE_CD="+pData.getWorkflowRoleCd());
            log.debug("SQL:   WORKFLOW_ID="+pData.getWorkflowId());
            log.debug("SQL:   WORKFLOW_RULE_ID="+pData.getWorkflowRuleId());
            log.debug("SQL:   ADD_DATE="+pData.getAddDate());
            log.debug("SQL:   ADD_BY="+pData.getAddBy());
            log.debug("SQL:   MOD_DATE="+pData.getModDate());
            log.debug("SQL:   MOD_BY="+pData.getModBy());
            log.debug("SQL:   MESSAGE="+pData.getMessage());
            log.debug("SQL: " + sql);
        }
        try {
        pstmt.executeUpdate();
        pData.setDirty(false);
        }
        catch(SQLException e){
        pData.setWorkflowQueueId(0);
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
     * Updates a WorkflowQueueData object in the database.
     * @param pCon  An open database connection.
     * @param pData  A WorkflowQueueData object to update. 
     * The "ModDate" field of the object will be set to the current date.
     * @return int Number of rows updated (0 or 1).
     * @throws            SQLException
     */
    public static int update(Connection pCon, WorkflowQueueData pData)
        throws SQLException {

        int n = 0;

        String sql = "UPDATE CLW_WORKFLOW_QUEUE SET SHORT_DESC = ?,ORDER_ID = ?,BUS_ENTITY_ID = ?,WORKFLOW_ROLE_CD = ?,WORKFLOW_ID = ?,WORKFLOW_RULE_ID = ?,ADD_DATE = ?,ADD_BY = ?,MOD_DATE = ?,MOD_BY = ?,MESSAGE = ? WHERE WORKFLOW_QUEUE_ID = ?";

        PreparedStatement pstmt = pCon.prepareStatement(sql);

        
        pData.setModDate(new java.util.Date(System.currentTimeMillis()));

        int i = 1;
        
        pstmt.setString(i++,pData.getShortDesc());
        if (pData.getOrderId() == 0) {
            pstmt.setNull(i++, java.sql.Types.INTEGER);
        } else {
            pstmt.setInt(i++,pData.getOrderId());
        }

        if (pData.getBusEntityId() == 0) {
            pstmt.setNull(i++, java.sql.Types.INTEGER);
        } else {
            pstmt.setInt(i++,pData.getBusEntityId());
        }

        pstmt.setString(i++,pData.getWorkflowRoleCd());
        if (pData.getWorkflowId() == 0) {
            pstmt.setNull(i++, java.sql.Types.INTEGER);
        } else {
            pstmt.setInt(i++,pData.getWorkflowId());
        }

        if (pData.getWorkflowRuleId() == 0) {
            pstmt.setNull(i++, java.sql.Types.INTEGER);
        } else {
            pstmt.setInt(i++,pData.getWorkflowRuleId());
        }

        pstmt.setTimestamp(i++,DBAccess.toSQLTimestamp(pData.getAddDate()));
        pstmt.setString(i++,pData.getAddBy());
        pstmt.setTimestamp(i++,DBAccess.toSQLTimestamp(pData.getModDate()));
        pstmt.setString(i++,pData.getModBy());
        pstmt.setString(i++,pData.getMessage());
        pstmt.setInt(i++,pData.getWorkflowQueueId());

        if (log.isDebugEnabled()) {
            log.debug("SQL:   SHORT_DESC="+pData.getShortDesc());
            log.debug("SQL:   ORDER_ID="+pData.getOrderId());
            log.debug("SQL:   BUS_ENTITY_ID="+pData.getBusEntityId());
            log.debug("SQL:   WORKFLOW_ROLE_CD="+pData.getWorkflowRoleCd());
            log.debug("SQL:   WORKFLOW_ID="+pData.getWorkflowId());
            log.debug("SQL:   WORKFLOW_RULE_ID="+pData.getWorkflowRuleId());
            log.debug("SQL:   ADD_DATE="+pData.getAddDate());
            log.debug("SQL:   ADD_BY="+pData.getAddBy());
            log.debug("SQL:   MOD_DATE="+pData.getModDate());
            log.debug("SQL:   MOD_BY="+pData.getModBy());
            log.debug("SQL:   MESSAGE="+pData.getMessage());
            log.debug("SQL: " + sql);
        }

        n = pstmt.executeUpdate();
        pstmt.close();

        pData.setDirty(false);

        return n;
    }

    /**
     * Deletes a WorkflowQueueData object with the specified
     * key from the database.
     * @param pCon  An open database connection.
     * @param pWorkflowQueueId Key of object to be deleted.
     * @return int Number of rows deleted (0 or 1).
     * @throws            SQLException
     */
    public static int remove(Connection pCon, int pWorkflowQueueId)
        throws SQLException{
        int n = 0;
        String sql="DELETE FROM CLW_WORKFLOW_QUEUE WHERE WORKFLOW_QUEUE_ID = " + pWorkflowQueueId;

        if (log.isDebugEnabled()) {
            log.debug("SQL: " + sql);
        }

        Statement stmt = pCon.createStatement();
        n = stmt.executeUpdate(sql);
        stmt.close();

        return n;
     }

    /**
     * Deletes WorkflowQueueData objects that match the specified criteria.
     * @param pCon  An open database connection.
     * @param pCriteria A DBCriteria with the SQL 'where clause'
     * @return int Number of rows deleted.
     * @throws            SQLException
     */
    public static int remove(Connection pCon, DBCriteria pCriteria)
        throws SQLException {
        int n = 0;
        StringBuffer sqlBuf = new StringBuffer("DELETE FROM CLW_WORKFLOW_QUEUE");
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
     * Inserts a WorkflowQueueData log object into the database.
     * @param pCon  An open database connection.
     * @param pData  A WorkflowQueueData object to insert
     * @param pMillis current time in milliseconds
     * @param pAction action made (I, U, D)
     * @param pStatus record status (O, N)
     * @throws            SQLException
     */
    public static void insertLog(Connection pCon, WorkflowQueueData pData, long pMillis, String pAction, String pStatus)
        throws SQLException {

        String sql = "INSERT INTO LCLW_WORKFLOW_QUEUE (LOG_DATE_MS,LOG_DATE,ACTION, STATUS,"+
          "WORKFLOW_QUEUE_ID,SHORT_DESC,ORDER_ID,BUS_ENTITY_ID,WORKFLOW_ROLE_CD,WORKFLOW_ID,WORKFLOW_RULE_ID,ADD_DATE,ADD_BY,MOD_DATE,MOD_BY,MESSAGE) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement pstmt = pCon.prepareStatement(sql);
        
        pstmt.setLong(1,pMillis);
        pstmt.setTimestamp(2,DBAccess.toSQLTimestamp(new java.util.Date(pMillis)));
        pstmt.setString(3,pAction);
        pstmt.setString(4,pStatus);

        pstmt.setInt(1+4,pData.getWorkflowQueueId());
        pstmt.setString(2+4,pData.getShortDesc());
        if (pData.getOrderId() == 0) {
            pstmt.setNull(3+4, java.sql.Types.INTEGER);
        } else {
            pstmt.setInt(3+4,pData.getOrderId());
        }

        if (pData.getBusEntityId() == 0) {
            pstmt.setNull(4+4, java.sql.Types.INTEGER);
        } else {
            pstmt.setInt(4+4,pData.getBusEntityId());
        }

        pstmt.setString(5+4,pData.getWorkflowRoleCd());
        if (pData.getWorkflowId() == 0) {
            pstmt.setNull(6+4, java.sql.Types.INTEGER);
        } else {
            pstmt.setInt(6+4,pData.getWorkflowId());
        }

        if (pData.getWorkflowRuleId() == 0) {
            pstmt.setNull(7+4, java.sql.Types.INTEGER);
        } else {
            pstmt.setInt(7+4,pData.getWorkflowRuleId());
        }

        pstmt.setTimestamp(8+4,DBAccess.toSQLTimestamp(pData.getAddDate()));
        pstmt.setString(9+4,pData.getAddBy());
        pstmt.setTimestamp(10+4,DBAccess.toSQLTimestamp(pData.getModDate()));
        pstmt.setString(11+4,pData.getModBy());
        pstmt.setString(12+4,pData.getMessage());


        pstmt.executeUpdate();
        pstmt.close();
    }




///////////////////////////////////////////////
    /**
     * Inserts a WorkflowQueueData object into the database.
     * @param pCon  An open database connection.
     * @param pData  A WorkflowQueueData object to insert.
     * The object id will be set to the one generated.  The "AddDate" and
     * "ModDate" fields will be set to the current date. 
     * @param pLogFl  Creates record in log table if true
     * @return new WorkflowQueueData() with the generated
     *         key set
     * @throws            SQLException
     */
    public static WorkflowQueueData insert(Connection pCon, WorkflowQueueData pData, boolean pLogFl)
        throws SQLException {
        pData = insert(pCon, pData);

        if(pLogFl) {
          long millis = System.currentTimeMillis();
          insertLog(pCon, pData, millis, "I", "N");
        }

        return pData;
    }

    /**
     * Updates a WorkflowQueueData object in the database.
     * @param pCon  An open database connection.
     * @param pData  A WorkflowQueueData object to update. 
     * The "ModDate" field of the object will be set to the current date.
     * @param pLogFl  Creates record in log table if true
     * @return int Number of rows updated (0 or 1).
     * @throws            SQLException
     */
    public static int update(Connection pCon, WorkflowQueueData pData, boolean pLogFl)
        throws SQLException {
        WorkflowQueueData oldData = null;
        if(pLogFl) {
          int id = pData.getWorkflowQueueId();
          try {
          oldData = WorkflowQueueDataAccess.select(pCon,id);
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
     * Deletes a WorkflowQueueData object with the specified
     * key from the database.
     * @param pCon  An open database connection.
     * @param pWorkflowQueueId Key of object to be deleted.
     * @param pLogFl  Create record in log table if true
     * @return int Number of rows deleted (0 or 1).
     * @throws            SQLException
     */
    public static int remove(Connection pCon, int pWorkflowQueueId, boolean pLogFl)
        throws SQLException{
        if(pLogFl){
          long millis = System.currentTimeMillis();
          java.util.Date rmDate = new java.util.Date(millis);
          java.text.SimpleDateFormat smf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          String oracleDate = "to_date('"+smf.format(rmDate)+"','YYYY-MM-DD HH24:MI:SS')";
          String sqlLog ="INSERT INTO LCLW_WORKFLOW_QUEUE SELECT "+millis+ ","+oracleDate+",'D','O',d.* FROM CLW_WORKFLOW_QUEUE d WHERE WORKFLOW_QUEUE_ID = " + pWorkflowQueueId;
          Statement stmt = pCon.createStatement();
          stmt.executeUpdate(sqlLog);
           stmt.close();
        }
        int n = remove(pCon,pWorkflowQueueId);
        return n;
     }

    /**
     * Deletes WorkflowQueueData objects that match the specified criteria.
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
             new StringBuffer("INSERT INTO LCLW_WORKFLOW_QUEUE SELECT "+millis+ ","+oracleDate+",'D','O',d.* FROM CLW_WORKFLOW_QUEUE d ");
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

