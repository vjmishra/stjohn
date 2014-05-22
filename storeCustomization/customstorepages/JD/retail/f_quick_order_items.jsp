<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.cleanwise.view.utils.*" %>
<%@ page import="com.cleanwise.view.i18n.ClwI18nUtil" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.cleanwise.service.api.value.*"%>
<%@ page import="com.cleanwise.view.forms.QuickOrderForm" %>


<%@ taglib uri='/WEB-INF/struts-template.tld' prefix='template' %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/application.tld" prefix="app" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%
    ShoppingCartData shoppingCart = (ShoppingCartData) session.getAttribute(Constants.SHOPPING_CART);
    SiteData site = null;
    boolean viewAddInvCart = false;
    if (shoppingCart != null) {
        site = shoppingCart.getSite();
        if (site != null) {
            viewAddInvCart
                    = site.hasModernInventoryShopping() && site.hasInventoryShoppingOn();
        }
    }
%>
<table align="left" border="0" cellpadding="0" cellspacing="0"
    width=<%=Constants.TABLEWIDTH_m4%>
  >
<bean:define id="theForm" name="QUICK_ORDER_FORM" type="com.cleanwise.view.forms.QuickOrderForm"/>
<bean:define id="IMGPath" type="java.lang.String" name="pages.store.images"/>

  <html:form styleId="fqoi" action="/store/quickOrder.do?action=quickOrderSubmit">


  <tr>
  <td colspan="3" class="text" align="center">
  <html:radio name="QUICK_ORDER_FORM" property="skuType" value="<%=\"\"+QuickOrderForm.DEFAULT_SKU_TYPE%>"/><app:storeMessage key="shoppingItems.text.ourSkuNum"/>
  <html:radio name="QUICK_ORDER_FORM" property="skuType" value="<%=\"\"+QuickOrderForm.MFG_SKU_TYPE%>"/><app:storeMessage key="shoppingItems.text.mfgSkuNum"/>
  </td>
  </tr>
  <tr>
  <td colspan="3" class="tableoutline"><img src="<%=IMGPath%>/cw_spacer.gif" height="3"></td>  </tr>
  </tr>

  <tr>
  <td colspan="3">
  <table border="0" cellpadding="0" cellspacing="0">
  <tr>
<% String imgExpressCheckout = IMGPath + "/express_checkout.jpg" ; %>
  <td>
      &nbsp; <%if (viewAddInvCart) {%>
          <% String add_img = IMGPath + "/b_addtocart.gif"; %>
              <a href="#" class="linkButton" onclick="setAndSubmit('fqoi','command','qo_addToModInvCart');">
                  <img src="<%=add_img%>" border="0"/>
                  <app:storeMessage key="global.label.addToInventoryCart"/>
              </a>
      <%}%>
  </td>	  
   </tr>

   </table>
   </td>
   </tr>
  <tr>

  <td colspan="3" class="tableoutline"><img src="/images/cw_spacer.gif" height="1"></td>  </tr>
  </tr>
  <tr>
  <td class="shopcharthead" width="11%"><app:storeMessage key="shoppingItems.text.#"/></td>
  <td class="shopcharthead" width="20%"><app:storeMessage key="shoppingItems.text.sku#"/></td>
  <td class="shopcharthead"><app:storeMessage key="shoppingItems.text.quantity"/></td>
  </tr>
  <tr>
  <td colspan="3" class="tableoutline"><img src="/images/cw_spacer.gif" height="1"></td>  
  </tr>
  <% int pagesize = theForm.getPageSize();
     for(int kidx=0; kidx<pagesize; kidx++) {
       String itemSkusEl = "itemSkusElement["+kidx+"]";
       String itemQtysEl = "itemQtysElement["+kidx+"]";
  %>
     <tr bgcolor="<%=ClwCustomizer.getEvenRowColor(session,new Integer(kidx))%>">
     <td class="text"><div class="fivemargin">
        <%=""+(kidx+1)%>
     </div></td>
     <td class="text"><div class="fivemargin">
        <html:text name="QUICK_ORDER_FORM" property="<%=itemSkusEl%>" size="10"/>
     </div></td>
     <td class="text"><div class="fivemargin">
        <html:text name="QUICK_ORDER_FORM" property="<%=itemQtysEl%>" size="4"/>
     </div></td>
     </tr>
  <% } %>
  <tr>
  <td colspan="3" class="tableoutline"><img src="/images/cw_spacer.gif" height="3"></td>
  </tr>
  <tr>
      <td colspan="3">
      &nbsp;	  
      <%if (viewAddInvCart) {%>
          <% String add_img = IMGPath + "/b_addtocart.gif"; %>
          <a href="#" class="linkButton" onclick="setAndSubmit('fqoi','command','qo_addToModInvCart');">
              <img src="<%=add_img%>" border="0"/>
              <app:storeMessage key="global.label.addToInventoryCart"/>
          </a>
      <%}%>
     </td>
  </tr>
  <html:hidden property="command" value="CCCCCCC"/>
  </html:form>
  </table>


<script type="text/javascript" language="JavaScript">
  <!--
  var focusControl = document.forms["QUICK_ORDER_FORM"].elements["itemSkusElement[0]"];
  if (focusControl != undefined && focusControl.type != "hidden" && !focusControl.disabled) {
     focusControl.focus();
  }
  // -->
</script>


