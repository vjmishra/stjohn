<%@ page import="com.cleanwise.service.api.process.operations.BudgetWorkflow" %>
<%@ page import="com.cleanwise.service.api.util.RefCodeNames" %>
<%@ page language="java" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/pager-taglib.tld" prefix="pg" %>
<%@ taglib uri="/WEB-INF/application.tld" prefix="app" %>

<bean:define id="theForm"
             name="STORE_WORKFLOW_DETAIL_FORM"
             type="com.cleanwise.view.forms.StoreWorkflowDetailForm"/>

<script language="JavaScript1.2">

function f_hideBox(boxid) {
  document.getElementById(boxid).style.display = 'none';
}

function f_hideAll() {
  /* Reset the radio button for rule type selection. */
  STORE_WORKFLOW_DETAIL_FORM.ruleTypeCd.value="";
  f_hideBox("BOX_userlocate");
  f_hideBox("BOX_agerule");
}

function f_showBox(boxid) {
  document.getElementById(boxid).style.display = 'block';
}

function f_userbox1(actionVal) {
  switch (actionVal) {
  case "Forward for approval":
    f_hideBox("BOX_userlocate");
    f_showBox("BOX_agerule");
  break;
  case "Hold order for review":
    f_hideBox("BOX_userlocate");
    f_showBox("BOX_agerule");
  break;
  case "Send Email":
    f_showBox("BOX_userlocate");
    f_hideBox("BOX_agerule");
  break;
  default:
    f_hideBox("BOX_userlocate");
    f_hideBox("BOX_agerule");
  }
}

function f_userbox2(actionVal) {
  switch (actionVal) {
  case "Forward for approval":
    f_hideBox("BOX_userlocate");
    f_showBox("BOX_agerule");
  break;
  case "Hold order for review":
    f_hideBox("BOX_userlocate");
    f_showBox("BOX_agerule");
  break;
  case "Send Email":
    f_showBox("BOX_userlocate");
    f_hideBox("BOX_agerule");
  break;
  default:
    f_hideBox("BOX_userlocate");
    f_hideBox("BOX_agerule");
  }
}

</script>

<%
 String fwdmsg = RefCodeNames.WORKFLOW_RULE_ACTION.FWD_FOR_APPROVAL;
 String emailmsg = RefCodeNames.WORKFLOW_RULE_ACTION.SEND_EMAIL;
%>



<div id="BOX_orderTotal">
<span class="wkrule">
If&nbsp;Budget&nbsp;Remaining&nbsp;
<html:select name="STORE_WORKFLOW_DETAIL_FORM" property="totalExp">
<html:option value=""><app:storeMessage  key="admin.select"/></html:option>
<html:option value="==">==</html:option>
<html:option value=">">&gt;</html:option>
<html:option value=">=">&gt;=</html:option>
<html:option value="<">&lt;</html:option>
<html:option value="<=">&lt;=</html:option>
</html:select>
&nbsp;
<html:text name="STORE_WORKFLOW_DETAIL_FORM" property="totalValue"/>
<br>
Then
&nbsp;
<html:select name="STORE_WORKFLOW_DETAIL_FORM" property="ruleAction" onchange="f_userbox1(this.value);">
<html:option value=""><app:storeMessage  key="admin.select"/></html:option>
<html:option value="<%=fwdmsg%>"><%=fwdmsg%></html:option>
<html:option value="<%=emailmsg%>"><%=emailmsg%></html:option>
</html:select>
</span>
</div>
