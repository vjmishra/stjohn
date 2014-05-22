<%@ page language="java" %>
<%@ page import="com.cleanwise.view.utils.Constants" %>
<%@ page import="com.cleanwise.view.utils.CleanwiseUser" %>
<%@ page import="com.cleanwise.view.utils.ClwCustomizer" %>
<%@ page import="com.cleanwise.service.api.value.*"%>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/pager-taglib.tld" prefix="pg" %>
<%@ taglib uri="/WEB-INF/application.tld" prefix="app" %>

<bean:define id="IMGPath" type="java.lang.String" name="pages.store.images"/>
<% CleanwiseUser appUser = (CleanwiseUser) session.getAttribute(Constants.APP_USER); %>

<div class="text"><font color=red><html:errors/></font></div>

<table align=center CELLSPACING=0 CELLPADDING=0
  width="<%=Constants.TABLEWIDTH%>">

<bean:define id="toolBarTab" type="java.lang.String"
  value="default_shop_og" toScope="request"/>
<jsp:include flush='true' page="f_msbToolbar.jsp"/>

<tr>
<td>
<table align=center CELLSPACING=0 CELLPADDING=0 width="<%=Constants.TABLEWIDTH%>">
<tr>
<td  bgcolor="black" width="1"><img src="<%=IMGPath%>/cw_spacer.gif" height="1" width="1"></td>
<td>
<table align=center CELLSPACING=0 CELLPADDING=0 width="647">
<tr><td>
<br>
<html:form name="MSB_SHOP_OG_FORM"
scope="session"
type="com.cleanwise.view.forms.MsbShopOrderGuideForm"
action="userportal/msbshop_order_guide.do?action=shop_og1">

<bean:define id="ogid" type="java.lang.Integer" toScope="request"
  name="msb.currentOrderGuide" property="orderGuideId" />

<bean:define id="catid" type="java.lang.Integer" toScope="request"
  name="msb.currentOrderGuide" property="catalogId" />

<html:hidden name="MSB_SHOP_OG_FORM" property="orderGuideData"
  value="<%= ogid.toString() %>" />
<html:hidden name="MSB_SHOP_OG_FORM" property="catalogId"
  value="<%= catid.toString() %>" />
<html:hidden name="MSB_SHOP_OG_FORM" property="userId"
  value='<%= (String) request.getSession().getAttribute("LoginUserId") %>' />

<%
String reqAction = request.getParameter("action");

if ( reqAction == null ) {
    reqAction = "init";
    request.getSession().setAttribute( "msb.expand.items", "true");
}

if ( reqAction.equals("ogitems_ex") ) {
    request.getSession().setAttribute( "msb.expand.items", "true");
}
else if ( reqAction.equals("ogitems_zip") ) {
    request.getSession().setAttribute( "msb.expand.items", "false");
}

String s = (String)
    request.getSession().getAttribute( "msb.expand.items");

boolean lExpandItems = true;
if ( s != null && s.equals("false") ) {
    lExpandItems = false;
}

String reqSiteIdStr = request.getParameter("siteId");
if ( null == reqSiteIdStr ) { reqSiteIdStr = "0"; }
Integer reqSiteId = new Integer( reqSiteIdStr );

%>

<span class="largeheader">
&nbsp;&nbsp;
<% if ( lExpandItems ) { %>
<a class="tbar2" href="msbshop_order_guide.do?action=ogitems_zip">[-]</a>
<% } else { %>
<a class="tbar2" href="msbshop_order_guide.do?action=ogitems_ex">[+]</a>
<% } %>
<bean:write name="msb.currentOrderGuide" property="orderGuideName"/>
</span>&nbsp;

<span class="fivemargin">
Order Guide Total:&nbsp;$&nbsp;<bean:write
  name="MSB_SHOP_OG_FORM" property="total" scope="session"/>
</span>

<% if ( lExpandItems ) { %>
<br><br>

<table WIDTH="750"  CELLSPACING=0 CELLPADDING=0 >
<tr>
  <td class="shopcharthead"><div class="fivemargin">Qty</div></td>
  <td class="shopcharthead"><div class="fivemargin">Our Sku #</div></td>
  <td class="shopcharthead"><div class="fivemargin">Name</div></td>
  <td class="shopcharthead"><div class="fivemargin">Size</div></td>
  <td class="shopcharthead"><div class="fivemargin">Pack</div></td>
  <td class="shopcharthead"><div class="fivemargin">UOM</div></td>
  <td class="shopcharthead"><div class="fivemargin">Manufacturer</div></td>
  <td class="shopcharthead"><div class="fivemargin">Mfg.Sku #</div></td>
  <td class="shopcharthead"><div class="fivemargin">Price</div></td>
  <td class="shopcharthead"><div class="fivemargin">Amount</div></td>
  <td class="shopcharthead"><div class="fivemargin">&nbsp;</div></td>

</tr>

<logic:iterate id="item" name="msb.orderGuideItems" indexId="i">

<tr bgcolor="<%=ClwCustomizer.getEvenRowColor(session,(Integer)i)%>">

<bean:define id="qtyVal" type="java.lang.Integer"
  name="item" property="quantity"/>

     <td class="text"><div class="fivemargin">
        <html:text size="3" maxlength="6"
        name="MSB_SHOP_OG_FORM" property='<%="itemQty[" + i + "].value" %>'
        value='<%=qtyVal.toString()%>'/>
     </div></td>

     <td class="text"><div class="fivemargin">
       <bean:write name="item" property="product.catalogSkuNum"/>&nbsp;
     </div></td>

    <td class="text" ><div class="fivemargin">
   <bean:write name="item" property="product.catalogProductShortDesc"/>&nbsp;
     </div></td>

     <td class="text" ><div class="fivemargin">
       <bean:write name="item" property="product.size"/>&nbsp;
     </div></td>

     <td class="text" ><div class="fivemargin">
       <bean:write name="item" property="product.pack"/>&nbsp;
     </div></td>

     <td class="text" ><div class="fivemargin">
       <bean:write name="item" property="product.uom"/>&nbsp;
     </div></td>

     <td class="text" ><div class="fivemargin">
       <bean:write name="item" property="product.manufacturerName"/>&nbsp;
     </div></td>

     <td class="text" ><div class="fivemargin">
       <bean:write name="item" property="product.manufacturerSku"/>&nbsp;
     </div></td>

       <td class="text" ><div class="fivemargin">
       $<bean:write name="item" property="price"/>
       </div></td>

       <td class="text"><div class="fivemargin">
       $<bean:write name="item" property="amount"/></div></td>
</tr>
</logic:iterate>
</table>

<a onClick="document.MSB_SHOP_OG_FORM.submit();">
<html:image  page='/en/images/a_recalculate.jpg'
  property="recalc" border="0"/>
</a>

<% } /* expand all the items in the order guide */ %>
<br><br>

<bean:size id="lSelectedCount"  name="msb.selectedSites.vector"/>

<% if ( lSelectedCount.intValue() > 0 ) { %>

<table WIDTH="750" CELLSPACING=0 CELLPADDING=0 > <% /* Sites to shop for. */ %>

<tr align=left>
<td class="shopcharthead"><div class="fivemargin">Site&nbsp;Id</div></td>
<td class="shopcharthead"><div class="fivemargin">Site Name</div></td>
<td class="shopcharthead"><div class="fivemargin">Street Address</div></td>
<td class="shopcharthead"><div class="fivemargin">City</div></td>
<td class="shopcharthead"><div class="fivemargin">State/Province</div></td>
<td class="shopcharthead"><div class="fivemargin">&nbsp;</div></td>
</tr>

<logic:iterate id="arrele" name="msb.selectedSites.vector" indexId="i2">

<tr bgcolor="<%=ClwCustomizer.getEvenRowColor(session,(Integer)i2)%>">

<td><bean:write name="arrele" property="busEntity.busEntityId"/></td>
<td>
<bean:define id="eleid" type="java.lang.Integer"
  name="arrele" property="busEntity.busEntityId"/>
<bean:write name="arrele" property="busEntity.shortDesc"/>
</td>
<td>
<bean:write name="arrele" property="siteAddress.address1"/>
</td>
<td>
<bean:write name="arrele" property="siteAddress.city"/>
</td>
<% if (appUser.getUserStore().isStateProvinceRequired()) { %>
<td>
<bean:write name="arrele" property="siteAddress.stateProvinceCd"/>
</td>
<%} %>
<%
if ( reqAction.equals("shop_og2") && reqSiteId.equals(eleid) ) {
%>
<td>
Shopping for site id <%= eleid %>.
</td>
<% } else { %>

<td align=right>
<a href="msbshop_order_guide.do?action=shop_og2&amp;siteId=<%=eleid.toString()%>">
<img  src='<%=IMGPath%>/cw_placeorder.gif' border="0" >
</a>
</td>
<% } %>

</tr>
</logic:iterate>
</table>

<% }  else  { %>

<table WIDTH="750" CELLSPACING=0 CELLPADDING=0 > <% // start of list sites %>
<tr align=left>
<td class="shopcharthead"><div class="fivemargin"><a href="msbshop_order_guide.do?action=sort_ogsites&sortField=id">Site&nbsp;Id</div></td>
<td class="shopcharthead"><div class="fivemargin"><a href="msbshop_order_guide.do?action=sort_ogsites&sortField=name">Site Name</div></td>
<td class="shopcharthead"><div class="fivemargin"><a href="msbshop_order_guide.do?action=sort_ogsites&sortField=address">Street Address</div></td>
<td class="shopcharthead"><div class="fivemargin"><a href="msbshop_order_guide.do?action=sort_ogsites&sortField=city">City</div></td>
<td class="shopcharthead"><div class="fivemargin"><a href="msbshop_order_guide.do?action=sort_ogsites&sortField=state">State/Province</div></td>
<td class="shopcharthead"><div class="fivemargin">&nbsp;</div></td>
</tr>

<logic:iterate id="arrele" name="msb.orderGuideSites.vector" indexId="i3">

<tr bgcolor="<%=ClwCustomizer.getEvenRowColor(session,(Integer)i3)%>">

<td><bean:write name="arrele" property="busEntity.busEntityId"/></td>
<td>
<bean:define id="eleid" name="arrele" property="busEntity.busEntityId"/>
<bean:write name="arrele" property="busEntity.shortDesc"/>
</td>
<td>
<bean:write name="arrele" property="siteAddress.address1"/>
</td>
<td>
<bean:write name="arrele" property="siteAddress.city"/>
</td>
<% if (appUser.getUserStore().isStateProvinceRequired()) { %>
<td>
<bean:write name="arrele" property="siteAddress.stateProvinceCd"/>
</td>
<%} %>
<td>
<html:multibox property="sitesSelected" > <%=eleid%> </html:multibox>
</td>

</logic:iterate>

<tr><td colspan=6 align=right>
<a onclick="document.forms[0].submit();">
<img alt="GO" src="<%=IMGPath%>/cw_go.gif">
</a>
</td></tr>
</table> <% // end of list sites %>

<% } /* sites selected   */ %>


</html:form>

</td></tr>
</table>
</td>
<td bgcolor="black" width="1"><img src="<%=IMGPath%>/cw_spacer.gif" height="1" width="1"></td>
</tr>
</table>

</td>
</tr>
</table>

<table align="center" border="0" cellpadding="0" cellspacing="0" width="<%=Constants.TABLEWIDTH%>">
<tr>
<td>
 <img src="<%=IMGPath%>/cw_left_footer_shop.gif" ALIGN="top">
</td>
<td>
 <img src="<%=IMGPath%>/cw_middle_footer_shop.gif" ALIGN="top" width="<%=Constants.TABLE_BOTTOM_MIDDLE_BORDER_WIDTH%>" height="8">
</td>
<td>
 <img src="<%=IMGPath%>/cw_right_footer_shop.gif" ALIGN="top">
</td>
</tr>

</table>




