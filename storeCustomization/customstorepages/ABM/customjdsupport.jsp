

<%@ page language="java" %>
<%@ page import="com.cleanwise.view.utils.Constants" %>
<%@ page import="com.cleanwise.view.utils.ClwCustomizer" %>

<%@ taglib uri='/WEB-INF/struts-template.tld' prefix='template' %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/application.tld" prefix="app" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<table width="100%">
<tr>
<td width="20%">&nbsp;</td>
<td width="80%" class="contenttext">
    <ul>
        <li><a target="_blank" href='<%=ClwCustomizer.getFilePath(session, "..", "content/abmfieldsupport.pdf")%>'>JD Support Map Reps</a></li>
        <li><a target="_blank" href='<%=ClwCustomizer.getFilePath(session, "..", "content/abmzonesupport.pdf")%>'>JD Support Map Zones</a></li>
    </ul>
</td>
</tr>
</table>
