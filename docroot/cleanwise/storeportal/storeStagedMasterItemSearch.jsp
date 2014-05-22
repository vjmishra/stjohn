<%@ page language="java" %>
<%@ page import="com.cleanwise.view.utils.Constants" %>
<%@ page import="com.cleanwise.service.api.value.*" %>
<%@ page import="com.cleanwise.service.api.util.RefCodeNames" %>
<%@ page import="com.cleanwise.view.utils.ClwCustomizer" %>
<%@ page import="com.cleanwise.view.utils.CleanwiseUser" %>
<%@ page import="com.cleanwise.view.i18n.ClwI18nUtil" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/pager-taglib.tld" prefix="pg" %>
<%@ taglib uri="/WEB-INF/application.tld" prefix="app" %>

<script language="JavaScript1.2">
<!--
document.onkeypress = freeKeyHit;

function freeKeyHit(evt) {
    var evt = (evt) ? evt : event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;

    if (charCode == 13) {
        actionSubmit(0,'SearchStagedMasterItem');
    }
}

function actionSubmit(formNum, action) {
    var actions;
    actions=document.forms[formNum]["action"];
    //alert(actions.length);
    for (ii=actions.length-1; ii>=0; ii--) {
        if (actions[ii].value=='hiddenAction') {
            actions[ii].value=action;
            document.forms[formNum].submit();
        break;
        }
    }
return false;
}

dml = document.forms;
for (i = 0; i < dml.length; i++) {
    ellen = dml[i].elements.length;
    for ( j = 0; j < ellen; j++) {
        if (dml[i].elements[j].name == 'searchField') {
            dml[i].elements[j].focus();
            break;
        }
    }
}
//-->
</script>


<bean:define id="ip" name="<%=Constants.IMAGES_PATH%>" scope="session"/>


<%
    CleanwiseUser appUser = (CleanwiseUser) session.getAttribute(Constants.APP_USER);
    String selectStr = ClwI18nUtil.getMessageOrNull(request, "global.action.label.select");
    if (selectStr != null) {
        selectStr = "-" + selectStr + "-";
    } else {
        selectStr = "-Select-";
    }
%>

<div class="text">

<table ID="1584" width="<%=Constants.TABLEWIDTH%>" cellspacing="0" border="0" class="mainbody">
<html:form styleId="1583" name="STORE_ADMIN_ITEM_FORM"
                          action="/storeportal/searchStagedMasterItems.do"
                          scope="session"
                          type="com.cleanwise.view.forms.StoreItemMgrForm">
    <tr>
        <td colspan="5">
            <span style="font-size: 14px; font-weight: bold; line-height: 200%;">
                <app:storeMessage key="global.action.label.search"/>&nbsp;<app:storeMessage key="userAssets.text.assetStagedMasterItem"/>
            </span>
        </td>
    </tr>
    <tr>
        <td align="right">
            <b><app:storeMessage key="userItems.text.itemMasterItemName"/>:</b>
        </td>
        <td></td>
        <td>
            <html:text styleId="searchField" size="25" name="STORE_ADMIN_ITEM_FORM" property="shortDescTempl" />
        </td>
        <td align="left" nowrap="nowrap">
            <html:radio name="STORE_ADMIN_ITEM_FORM" property="nameSearchType"
                        value="<%=RefCodeNames.SEARCH_TYPE_CD.BEGINS%>"/>
            <app:storeMessage key="admin2.search.criteria.label.startsWith"/>
            <html:radio name="STORE_ADMIN_ITEM_FORM" property="nameSearchType"
                        value="<%=RefCodeNames.SEARCH_TYPE_CD.CONTAINS%>"/>
            <app:storeMessage key="admin2.search.criteria.label.contains"/>
        </td>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <td align="right">
            <b><app:storeMessage key="userAssets.shop.text.param.skuNumber"/>:</b>
        </td>
        <td></td>
        <td>
            <html:text styleId="searchModel" size="25" name="STORE_ADMIN_ITEM_FORM" property="skuTempl" />
        </td>
        <td align="left" nowrap="nowrap">
            <html:radio name="STORE_ADMIN_ITEM_FORM" property="skuSearchType"
                        value="<%=RefCodeNames.SEARCH_TYPE_CD.BEGINS%>"/>
            <app:storeMessage key="admin2.search.criteria.label.startsWith"/>
            <html:radio name="STORE_ADMIN_ITEM_FORM" property="skuSearchType"
                        value="<%=RefCodeNames.SEARCH_TYPE_CD.CONTAINS%>"/>
            <app:storeMessage key="admin2.search.criteria.label.contains"/>
        </td>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <td colspan="5">&nbsp;</td>
    </tr>
    <tr>
        <td colspan="2">&nbsp;</td>
        <td>
            <html:button property="action" onclick="actionSubmit(0,'SearchStagedMasterItem');">
                <app:storeMessage key="global.action.label.search"/>
            </html:button>
        </td>
        <td>&nbsp;</td>
        <td align="left" width="15%">
            <html:button property="action" onclick="actionSubmit(0,'StagedCreateAll');">
                <app:storeMessage key="admin.button.createAll"/>
            </html:button>
        </td>
    </tr>
    <tr>
        <td colspan="5">&nbsp;</td>
    </tr>
    <tr class="results">
        <td colspan="5"></td>
    </tr>
    <tr>
        <td colspan="5" style="font-size: 3pt">&nbsp;</td>
    </tr>
    <tr>
        <td colspan="4" align="left">
            <logic:present name="STORE_ADMIN_ITEM_FORM" property="stagedItems">
                <bean:size id="rescount" name="STORE_ADMIN_ITEM_FORM" property="stagedItems"/>
                &nbsp;&nbsp;<app:storeMessage key="locateItem.label.searchResultCount"/>:&nbsp;<%=rescount%>
            </logic:present>
            <logic:notPresent name="STORE_ADMIN_ITEM_FORM" property="stagedItems">
                &nbsp;&nbsp;<app:storeMessage key="locateItem.label.searchResultCount"/>:&nbsp;0
            </logic:notPresent>
        </td>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <td colspan="5" style="font-size: 3pt">&nbsp;</td>
    </tr>
<html:hidden property="action" value="hiddenAction"/>
</html:form>
</table>

  <script type="text/javascript" language="JavaScript">
  <!--
     dml=document.forms;
     for(i=0; i<dml.length; i++) {
      ellen = dml[i].elements.length;
      for(j=0; j<ellen; j++) {
        if (dml[i].elements[j].name=='searchField') {
          dml[i].elements[j].focus();
          break;
        }
      }
     }
  // -->
  </script>

<logic:present name="STORE_ADMIN_ITEM_FORM" property="stagedItems">
<table ID="9941" width="<%=Constants.TABLEWIDTH%>">
<tr align="left">
    <td>
        <div class="fivemargin">
            <a class="storeassetsearchlinks" href="searchStagedMasterItems.do?action=sort_staged&sortField=itemid">
                <app:storeMessage key="userItems.text.itemMasterItemID"/>
            </a>
        </div>
    </td>
    <td>
        <div class="fivemargin">
            <a class="storeassetsearchlinks" href="searchStagedMasterItems.do?action=sort_staged&sortField=itemname">
                <app:storeMessage key="userItems.text.itemMasterItemName"/>
            </a>
        </div>
    </td>
        <td>
        <div class="fivemargin">
            <a class="storeassetsearchlinks" href="searchStagedMasterItems.do?action=sort_staged&sortField=itemcategory">
                <app:storeMessage key="userAssets.text.assetCategory"/>
            </a>
        </div>
    </td>
    <td>
        <div class="fivemargin">
            <a class="storeassetsearchlinks" href="searchStagedMasterItems.do?action=sort_staged&sortField=itemmanufacturer">
                <app:storeMessage key="userAssets.shop.text.param.manufacturer"/>
            </a>
        </div>
    </td>
    <td>
        <div class="fivemargin">
            <a class="storeassetsearchlinks" href="searchStagedMasterItems.do?action=sort_staged&sortField=itemskunum">
                <app:storeMessage key="userAssets.shop.text.param.manufacturerSku"/>
            </a>
        </div>
    </td>
    <td>
        <div class="fivemargin">
            <a class="storeassetsearchlinks" href="searchStagedMasterItems.do?action=sort_staged&sortField=itemstatus">
                <app:storeMessage key="userAssets.shop.text.param.status"/>
            </a>
        </div>
    </td>
    <td>
        <div class="fivemargin" style="font-weight: bold">
            <app:storeMessage key="userAssets.shop.text.param.action"/>
        </div>
    </td>
</tr>

<logic:iterate id="arrele" name="STORE_ADMIN_ITEM_FORM" property="stagedItems" indexId="i">
    <bean:define id="eleid" name="arrele" property="itemId"/>
    <%
    String bgcolor = "";
    if (i % 2 == 0 ) {  
        bgcolor = "rowa";
    } else {
        bgcolor = "rowb";
    } 
    %>
    <tr class='<%=bgcolor%>'>
        <td>
            <bean:write name="arrele" property="itemId"/>
        </td>
        <td>
            <bean:write name="arrele" property="name"/>
        </td>
        <td>
            <bean:write name="arrele" property="category"/>
        </td>
        <td>
            <bean:write name="arrele" property="manufName"/>
        </td>
        <td>
            <bean:write name="arrele" property="manufSku"/>
        </td>
        <td>
            <bean:write name="arrele" property="statusCd"/>
        </td>
        <td>
            <logic:equal name="arrele" property="matchedItemId" value="0">
                <a href="../storeportal/searchStagedMasterItems.do?action=MasterItemMatch&masterItemIndex=<%=i%>">
                    <app:storeMessage key="userAssets.text.match"/>
                </a>
            </logic:equal>
            <logic:greaterThan name="arrele" property="matchedItemId" value="0">
                <a href="../storeportal/searchStagedMasterItems.do?action=UnmatchMatchedItem&masterItemIndex=<%=i%>">
                    <app:storeMessage key="userAssets.text.unMatch"/>
                </a>
            </logic:greaterThan>
        </td>
    </tr>
</logic:iterate>
</table>
</logic:present>

</div>






