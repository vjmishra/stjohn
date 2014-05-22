<%@ page language="java" %>
<%@ page import="com.cleanwise.view.utils.Constants" %>
<%@ page import="com.cleanwise.view.utils.ClwCustomizer" %>
<%@ page import="com.cleanwise.view.logic.*" %>
<%@ page import="com.cleanwise.service.api.util.RefCodeNames" %>
<%@ page import="com.cleanwise.service.api.value.*" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.cleanwise.service.api.value.*" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/application.tld" prefix="app" %>
<%@ taglib uri="/WEB-INF/i18n.tld" prefix="i18n" %>

<script language="JavaScript1.2">

function calcTotal2() {

  var calcTotal = 0.0;

  if (document.ORDER_OP_DETAIL_FORM.elements["subTotal"].value != "") {
        calcTotal += document.ORDER_OP_DETAIL_FORM.elements["subTotal"].value * 1.0;
  }
  if (document.ORDER_OP_DETAIL_FORM.elements["totalFreightCostS"].value != "") {
        calcTotal += document.ORDER_OP_DETAIL_FORM.elements["totalFreightCostS"].value * 1.0;
  }
  if (document.ORDER_OP_DETAIL_FORM.elements["totalTaxCost"].value != "") {
        calcTotal += document.ORDER_OP_DETAIL_FORM.elements["totalTaxCost"].value * 1.0;
  }
  if (document.ORDER_OP_DETAIL_FORM.elements["totalMiscCostS"].value != "") {
        calcTotal += document.ORDER_OP_DETAIL_FORM.elements["totalMiscCostS"].value * 1.0;
  }
  if (document.ORDER_OP_DETAIL_FORM.elements["rushOrderChargeS"].value != "") {
        calcTotal += document.ORDER_OP_DETAIL_FORM.elements["rushOrderChargeS"].value * 1.0;
  }
  if (document.ORDER_OP_DETAIL_FORM.elements["fuelSurcharge"] &&
      document.ORDER_OP_DETAIL_FORM.elements["fuelSurcharge"].value != "") {
        calcTotal += document.ORDER_OP_DETAIL_FORM.elements["fuelSurcharge"].value * 1.0;
  }
  if (document.ORDER_OP_DETAIL_FORM.elements["discountStr"] &&
      document.ORDER_OP_DETAIL_FORM.elements["discountStr"].value != "") {
        var discountValue = document.ORDER_OP_DETAIL_FORM.elements["discountStr"].value * 1.0;
        if (discountValue > 0) {
            calcTotal = calcTotal - discountValue;
        } else {
            calcTotal = calcTotal + discountValue;
        }
  }
  if ( 0.0 != calcTotal )  {
        document.ORDER_OP_DETAIL_FORM.elements["totalAmount"].value = calcTotal;
  }
  else {
        document.ORDER_OP_DETAIL_FORM.elements["totalAmount"].value = 0;
  }

  return true;
}

</script>


<bean:define id="theForm" name="ORDER_OP_DETAIL_FORM"
  type="com.cleanwise.view.forms.OrderOpDetailForm"/>

<%
boolean allowMod = false;
String p = request.getParameter("allowEdits");
if ( p != null && p.equals("true")) {
  allowMod = true;
}
boolean hideDiscountField = false;
String strHideDiscountField = request.getParameter("hideDiscountField");
if (strHideDiscountField != null && strHideDiscountField.equalsIgnoreCase("true")) {
    hideDiscountField = true;
}
%>

<!-- order charges 0 -->

<tr>
<td><b>Sub-Total:</b></td>
<td><bean:define id="subtotal"  name="ORDER_OP_DETAIL_FORM" 
  property="subTotal"/>
<i18n:formatCurrency value="<%=subtotal%>" locale="<%=Locale.US%>"/>
<html:hidden name="ORDER_OP_DETAIL_FORM" property="subTotal"/>
</td>
</tr>

<tr>
<td><b>Freight:</b></td>
<% if (allowMod) { %>
<td><html:text styleClass="text" size="7" maxlength="13" 
  name="ORDER_OP_DETAIL_FORM" property="totalFreightCostS" 
  onchange="return calcTotal2();"/>
<% } else { %>
<td>
<logic:present name="ORDER_OP_DETAIL_FORM" 
  property="orderStatusDetail.orderDetail.totalFreightCost">
<bean:define id="freight"  name="ORDER_OP_DETAIL_FORM" 
  property="orderStatusDetail.orderDetail.totalFreightCost"/>
<i18n:formatCurrency value="<%=freight%>" locale="<%=Locale.US%>"/>
</logic:present>
</td>
<% }  %>
</td>
</tr>

<tr>
<td><b>Fuel Surcharge:</b></td>
<% if (allowMod) { %>
<td><html:text styleClass="text" size="7" maxlength="13" 
  name="ORDER_OP_DETAIL_FORM" property="fuelSurcharge" 
  onchange="return calcTotal2();"/>
<% } else { %>
<td>
<logic:present name="ORDER_OP_DETAIL_FORM" 
  property="fuelSurcharge">
<bean:define id="fuel"  name="ORDER_OP_DETAIL_FORM" 
  property="fuelSurcharge"/>
<bean:define id="fuelS" name="ORDER_OP_DETAIL_FORM" property="fuelSurchargeAmt"/>
<i18n:formatCurrency value="<%=fuelS%>" locale="<%=Locale.US%>"/>
</logic:present>
</td>
<% }  %>
</td>
</tr>
<tr>
<td></td>
</tr>

    <tr>
        <td><b>Handling:</b></td>
            <% if (allowMod) { %>
        <td>
            <html:text styleClass="text" size="7" maxlength="13"  
                name="ORDER_OP_DETAIL_FORM" property="totalMiscCostS" 
                onchange="return calcTotal2();"/>
            <% } else { %>
        <td>
            <logic:present name="ORDER_OP_DETAIL_FORM" property="orderStatusDetail.orderDetail.totalMiscCost">
                <bean:define id="misc"  name="ORDER_OP_DETAIL_FORM" property="orderStatusDetail.orderDetail.totalMiscCost"/>
                <i18n:formatCurrency value="<%=misc%>" locale="<%=Locale.US%>"/>
            </logic:present>
        </td>
            <% }  %>
        </td>
    </tr>

    <%
    if (!hideDiscountField) {
    %>
    <logic:notEmpty name="ORDER_OP_DETAIL_FORM" property="discountAmt">
    <logic:greaterThan name="ORDER_OP_DETAIL_FORM" property="discountAmt" value="0">
    <tr>
        <td><b>Discount:</b></td>
            <% if (allowMod) { %>
        <td>
            <html:text styleClass="text" size="7" maxlength="13" name="ORDER_OP_DETAIL_FORM" property="discountStr" onchange="return calcTotal2();"/>
        </td>
            <% } else { %>
        <td>
            <logic:present name="ORDER_OP_DETAIL_FORM" property="discountAmt">
                <bean:define id="discountAmt"  name="ORDER_OP_DETAIL_FORM" property="discountAmt"/>
                <i18n:formatCurrency value="<%=discountAmt%>" locale="<%=Locale.US%>"/>
            </logic:present>
        </td>
            <% }  %>
    </tr>
    </logic:greaterThan>
    </logic:notEmpty>
    <%
    }
    %>

<% if ( theForm.getRushOrderCharge() != null ) { %>
<tr><td><b>Rush Order Charge:</b>
</td>
<% if (allowMod) { %>
<td><html:text styleClass="text" size="7" maxlength="13"  
  name="ORDER_OP_DETAIL_FORM" property="rushOrderChargeS" 
  onchange="return calcTotal2();"/>
  </td>
<% } else { %>
<td>
<i18n:formatCurrency value="<%=theForm.getRushOrderCharge()%>" 
  locale="<%=Locale.US%>"/>
</td>
</tr>
<% 
}


}
else { // null rush charge %>
<html:hidden  name="ORDER_OP_DETAIL_FORM" property="rushOrderChargeS"/>
<% } /* Hidden value for rush charge. */ %>


<tr>
<td><b>Tax:</b></td>
<td><bean:define id="tax"  name="ORDER_OP_DETAIL_FORM" 
  property="totalTaxCost"/>
<i18n:formatCurrency value="<%=tax%>" locale="<%=Locale.US%>"/>
<html:hidden name="ORDER_OP_DETAIL_FORM" property="totalTaxCost"/>
</td>
</tr>


<tr>
<td><b>Total:</b></td>
<td><html:text styleClass="textreadonly" size="7" 
 maxlength="13" name="ORDER_OP_DETAIL_FORM" 
 property="totalAmount" readonly="true"/>
</td>
</tr>

<!-- order charges 1 -->



