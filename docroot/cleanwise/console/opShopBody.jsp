<%@ page language="java" %>
<%@ page import="com.cleanwise.view.utils.Constants" %>
<%@ page import="com.cleanwise.service.api.value.*" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/application.tld" prefix="app" %>
<script language="JavaScript">

function f_tcb() {
  if ( document.SITE_SEARCH_FORM.searchField.value == "" ) { 
    document.SITE_SEARCH_FORM.searchType[1].checked='true';
  } 
}

function popLocate(pLoc, name, pDesc) {
  var loc = pLoc + ".do?feedField=" + name + "&amp;feedDesc=" + pDesc;
  locatewin = window.open(loc,"Locate", "menubar=yes,resizable=yes,scrollbars=yes,toolbar=no,status=yes,height=500,width=769,left=100,top=165");
  locatewin.focus();
  return false;
}
</script>

<bean:define id="ip" name="<%=Constants.IMAGES_PATH%>" scope="session"/>

<div class="text">

  <table width="769" cellspacing="0" border="0" class="mainbody">
  <html:form name="SITE_SEARCH_FORM" action="console/opShop.do"
    scope="session" type="com.cleanwise.view.forms.SiteMgrSearchForm"
  focus="searchField"   
  >
  <tr> <td align="right"><b>Search Shopping Sites</b></td>

<td>
<html:text name="SITE_SEARCH_FORM" property="searchField"
    onfocus="javascript: f_tcb();"
/>

<html:radio name="SITE_SEARCH_FORM" property="searchType"
    value="id" />  ID
<html:radio name="SITE_SEARCH_FORM" property="searchType"
    value="nameBegins" />  Name(starts with)
<html:radio name="SITE_SEARCH_FORM" property="searchType"
    value="nameContains" />  Name(contains)
</td>
</tr>

<tr> 
   <td align="right"><b>Account(s)</b></td>
       <td colspan='3'>
       <% String onKeyPress="return submitenter(this,event,'Submit');"; %>
       <% String onClick = "popLocate('../adminportal/accountLocateMulti', 'accountIdList', '');";%>
       <html:text size='50' onkeypress="<%=onKeyPress%>" name="SITE_SEARCH_FORM" property="accountIdList" />
       <html:button property="locateAccount"
                    onclick="<%=onClick%>"
                    value="Locate Account(s)"/>
        </td>
  
  </tr>

<tr>
<td align="right"><b>City</b></td>
<td><html:text name="SITE_SEARCH_FORM" property="city"/> </td>
</tr>

<tr>
<td align="right"><b>State</b></td>
<td><html:text name="SITE_SEARCH_FORM" property="state"/> </td>
</tr>
<% /* *** Searching by reference code needs to be
      *** implemented.

<tr>
<td align="right"><b>Reference</b></td>
<td><html:text name="SITE_SEARCH_FORM" property="refValue"/> </td>
</tr>
*/ %>

  <tr> <td>&nbsp;</td>
       <td>
        <html:submit property="action">
                <app:storeMessage  key="global.action.label.search"/>
        </html:submit>
     </html:form>
    </td>
  </tr>
</table>

<logic:present name="Site.found.vector">
<bean:size id="rescount"  name="Site.found.vector"/>
<% Integer n = (Integer)rescount; %>
<% if (n.intValue() < Constants.MAX_SITES_TO_RETURN) { %>
Search result count:  <bean:write name="rescount" />
<% } else { %>
Search results restricted to maximum of <bean:write name="rescount" />.
Narrow search criteria.
<% } %>


<table cellspacing="0" border="0" width="769" class="results"> <tr
align=left>
<td><a class="tableheader"
href="opShop.do?action=sort&sortField=id">Site&nbsp;Id</td>
<td><a class="tableheader"
href="opShop.do?action=sort&sortField=rank">Rank</td>
<td><a class="tableheader"
href="opShop.do?action=sort&sortField=account">Account
Name</td><td><a class="tableheader"
href="opShop.do?action=sort&sortField=name">Site Name</td><td><a
class="tableheader"
href="opShop.do?action=sort&sortField=address">Street
Address</td><td><a class="tableheader"
href="opShop.do?action=sort&sortField=city">City</td><td><a
class="tableheader"
href="opShop.do?action=sort&sortField=state">State<br>Prov</td><td><a
class="tableheader"
href="opShop.do?action=sort&sortField=status">Status</td> </tr>

<logic:iterate id="arrele" name="Site.found.vector">


<logic:greaterEqual name="arrele" property="targetFacilityRank" value="<%=com.cleanwise.service.api.util.Utility.TARGET_FACILITY_THRESHOLD.toString()%>">
<tr class="rowa">
</logic:greaterEqual>
<logic:lessThan name="arrele" property="targetFacilityRank" value="<%=com.cleanwise.service.api.util.Utility.TARGET_FACILITY_THRESHOLD.toString()%>">
<tr>
</logic:lessThan>

<td><bean:write name="arrele" property="id"/></td>
<td><bean:write name="arrele" property="targetFacilityRank"/></td>
<td>
<bean:write name="arrele" property="accountName"/>
</td>
<td>
<logic:equal name="arrele" property="status" value="ACTIVE">
<bean:define id="eleid" name="arrele" property="id"/>
<%
   String link = "true";
   SiteViewVector svVec = new SiteViewVector();
   svVec = (SiteViewVector)session.getAttribute("Site.noShop.vector");

   for(int i=0; i<svVec.size();i++){
     SiteView sv = (SiteView)svVec.get(i);
     Integer siteId = new Integer(sv.getId());
%>
     <logic:equal name="eleid" value="<%=siteId.toString()%>">
     <%
       link = "false";
     %>
     </logic:equal>
<% }

   if(link.equals("true")){
%>

     <a href="../userportal/msbsites.do?action=shop_site&start_point=shop_quick_order&siteId=<%=eleid%>">
       <bean:write name="arrele" property="name"/>
    </a>
<% }else { %>
    <bean:write name="arrele" property="name"/>
<% } %>
</logic:equal>
<logic:notEqual name="arrele" property="status" value="ACTIVE">
<bean:write name="arrele" property="name"/>
</logic:notEqual>
</td>
<td>
<bean:write name="arrele" property="address"/>
</td>
<td>
<bean:write name="arrele" property="city"/>
</td>
<td>
<bean:write name="arrele" property="state"/>
</td>
<td><bean:write name="arrele" property="status"/></td>
</tr>


</logic:iterate>
</table>

</logic:present>

</div>


