<%@ page language="java" %>
<%@ page import="com.cleanwise.view.utils.Constants" %>
<%@ page import="com.cleanwise.view.utils.ClwCustomizer" %>

<%@ taglib uri='/WEB-INF/struts-tiles.tld' prefix='template' %>
<%@ taglib uri='/WEB-INF/struts-html.tld' prefix='html' %>
<%@ taglib uri='/WEB-INF/application.tld' prefix='app' %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>


<template:useAttribute id="simpleContent" name="simpleContent" ignore="true" classname="java.lang.String"/>

<html>
<head>
  <title><template:getAsString name='title'/></title>

  <jsp:include flush='true' page="<%=ClwCustomizer.getStoreFilePath(request, \"htmlHeaderIncludes.jsp\")%>"/>

</head>

<body leftmargin="0" topmargin="0" marginwidth="0"
  marginheight="0" bgcolor="white">

<!-- START PAGE HEADER SECTION -->
<div>
  <template:useAttribute id="headerA" name="header" ignore="true" classname="java.lang.String"/>
  <template:useAttribute id="headerTxtA" name="headerText" ignore="true" classname="java.lang.String"/>
  <logic:present name="headerA">
    <template:get name="header" flush="true" ignore="true"/>
  </logic:present>
  <logic:present name="headerTxtA">
    <bean:write name="headerTxtA" filter="false"/>
  </logic:present>
<template:useAttribute id="tabBar01"    name="tabBar01"    ignore="true" classname="java.lang.String"/>
<template:useAttribute id="tabBar01Txt" name="tabBar01Txt" ignore="true" classname="java.lang.String"/>
<logic:present name="tabBar01">
    <template:get name="tabBar01" flush="true" ignore="true"/>
</logic:present>
<logic:present name="tabBar01Txt">
    <bean:write name="tabBar01Txt" filter="false"/>
</logic:present>

</div>
<!-- END HEADER SECTION -->



<!-- START PAGE CONTENT -->
<div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="100%" valign="top" align="center">
    <%--Render the table outline if this is "simple content"--%>
    <logic:present name="simpleContent">
    <logic:equal name="simpleContent" value="true">
        <!-- bean:define id="IMGPath" type="java.lang.String" name="pages.store.images"/ -->
        <div class="text"><font color=red><html:errors/></font></div>
        <table align="center" border="0" cellpadding="0" cellspacing="0" width="<%=Constants.TABLEWIDTH%>">
          <tr>
            <td class="tableoutline" width="1" bgcolor="black">
              <img src='<%=ClwCustomizer.getSIP(request,"cw_spacer.gif")%>' height="1" width="1">
            </td>
            <td>
    </logic:equal>
    </logic:present>
      <template:useAttribute id="contentA" name="content" ignore="true" classname="java.lang.String"/>
      <template:useAttribute id="contentTxtA" name="contentText" ignore="true" classname="java.lang.String"/>
      
      <logic:present name="contentA">
        <template:get name="content" flush="true" ignore="true"/>
      </logic:present>
      <logic:present name="contentTxtA">
        <bean:write name="contentTxtA" filter="false"/>
      </logic:present>
<%--Render the table outline if this is "simple content"--%>
    <logic:present name="simpleContent">
    <logic:equal name="simpleContent" value="true">
            <!-- bean:define id="IMGPath" type="java.lang.String" name="pages.store.images"/ -->
            </td>
            <td class="tableoutline" width="1">
                <img src='<%=ClwCustomizer.getSIP(request,"cw_spacer.gif")%>' height="1" width="1">
            </td>
            </tr>
        </table>
    </logic:equal>
    </logic:present>
    </td>
  </tr>
</table>
</div>
<!-- END PAGE CONTENT -->

<logic:present name="simpleContent">
<logic:equal name="simpleContent" value="true">
    <!-- bean:define id="IMGPath" type="java.lang.String" name="pages.store.images"/ -->
    <jsp:include flush='true' page='<%=ClwCustomizer.getStoreFilePath(request,"f_table_bottom1.jsp")%>'/>
</logic:equal>
</logic:present>

<!-- END PAGE BODY FRAMEWORK -->

<!-- START PAGE FOOTER SECTION -->
<div>
  <template:useAttribute id="footerA" name="footer" ignore="true" classname="java.lang.String"/>
  <template:useAttribute id="footerTxtA" name="footerText" ignore="true" classname="java.lang.String"/>
  <logic:present name="footerA">
    <template:get name="footer" flush="true" ignore="true"/>
  </logic:present>
  <logic:present name="footerTxtA">
    <bean:write name="footerTxtA" filter="false"/>
  </logic:present>
</div>
<!-- END FOOTER SECTION -->
</body>
</html>
