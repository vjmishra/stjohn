<%@ page language="java" %>
<%@ page import="com.cleanwise.view.utils.Constants" %>
<%@ page import="com.cleanwise.view.i18n.ClwI18nUtil"%>
<%@ page import="com.cleanwise.service.api.*" %>
<%@ page import="com.cleanwise.service.api.session.*" %>
<%@ page import="com.cleanwise.service.api.value.*" %>
<%@ page import="com.cleanwise.service.api.util.*" %>
<%@ page import="com.cleanwise.view.utils.*" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/application.tld" prefix="app" %>


<bean:define id="IMGPath" type="java.lang.String" name="pages.store.images"/>

<bean:define id="AccountId" type="java.lang.String" name="pages.account.id"/>
<%CleanwiseUser appUser = (CleanwiseUser) session.getAttribute(Constants.APP_USER);%>


  <table align="center" cellspacing="0"><tr><td  
    style="border-top: solid 1px black; border-right: solid 1px black; border-left: solid 1px black;">
<img src='<app:custom  pageElement="pages.logo1.image" addImagePath="true" encodeForHTML="true"/>' border="0">  
  </td></tr>
  <tr><td  
    style="padding: 10px; border: solid 1px black;">
    <br><br><span class="genericerror">
  We are sorry.
  <p>
  Your request could not be handled at this time.<br>
  Please try again or contact Customer Service:
  </span>
<span class="text">
<p>
<app:storeMessage key="contactus.text.email:"/>   <a href="mailto:<%=Constants.EMAIL_ADDR_EBUSINESS%>"><%=Constants.EMAIL_ADDR_EBUSINESS%></a><br>
<app:storeMessage key="contactus.text.phone:"/>  877-269-1784<br>
  </p>
      </span>
  </td></tr></table>

  <div style="align: center;">
    <br><br><span class="genericerror">
      <html:errors/></span>
  <div>

