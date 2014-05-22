
<%@ page language="java" %>
<%@ page import="com.cleanwise.view.utils.*" %>
<%@ page import="java.util.*" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/application.tld" prefix="app" %>

<%
String storeDir=ClwCustomizer.getStoreDir();
boolean clwSwitch = ClwCustomizer.getClwSwitch();
SessionTool st = new SessionTool(request);
CleanwiseUser appUser = st.getUserData();

%>
<bean:define id="ip" name="<%=Constants.IMAGES_PATH%>" scope="session"/>

<script src="../externals/lib.js" language="javascript"></script>

<%
/* Get the page being accessed. */
String pg = request.getRequestURI();
if(pg.indexOf("related") > 0) {
        pg = " " + request.getParameter("action");
}

%>

<%--render the image and the menuing system--%>
<table border="0" cellpadding="0" cellspacing="0" width="<%=Constants.TABLEWIDTH%>" style="border-collapse: collapse;">
	<tr valign="top">
		<td align="left" valign="middle">
		  <img src='<app:custom  pageElement="pages.store.logo1.image" addImagePath="true" encodeForHTML="true"/>' border="0">
		</td>
		<%--The navigation bar--%>
		<td align="right" colspan="4">
		    <jsp:include flush='true' page="/general/navMenu.jsp"/>
			<br>
			<% java.util.Date currd = new java.util.Date(); %>
			<%= currd.toString() %><br/>
			<% try { %>
            <b>Server</b> <%=java.net.InetAddress.getLocalHost()%></br>
            <% } catch (Exception e) { %>
             <b>Server</b> N/A</br>
           <% }  %>
            <b>Branch</b> <%=System.getProperty("build.branch.stjohn")%><b>   Build</b> <%=System.getProperty("build.number.stjohn")%>
		</td>
		<%--END The navigation bar--%>
	</tr>
</table>

<table width=769 cellspacing=0 cellpadding=2>
<tr>

<%
String tabClass = ""; String linkClass = "";
%>


<%
if ( pg.indexOf("orderguide") == -1 ) { tabClass = "atoff"; linkClass = "tbar2";
} else { tabClass = "aton"; linkClass = "tbar";}
%>
  <td class="<%=tabClass%>">
      <a class="<%=linkClass%>" href="orderguidesmgr.do">Order&nbsp;Guide</a>
    </td>



</tr>

<tr>
<%
if ( pg.indexOf("group") == -1 ) { tabClass = "atoff"; linkClass = "tbar2";
} else { tabClass = "aton"; linkClass = "tbar";}
%>
  <td class="<%=tabClass%>">
      <a class="<%=linkClass%>" href="groupmgr.do">Group</a>
    </td>





<td class="atoff" colspan="2">&nbsp; </td>
</tr>
</table>


