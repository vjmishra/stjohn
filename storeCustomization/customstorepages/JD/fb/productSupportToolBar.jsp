

<%@ page language="java" %>
<%@ page import="com.cleanwise.view.utils.Constants" %>
<%@ page import="com.cleanwise.view.utils.ClwCustomizer" %>

<%@ taglib uri='/WEB-INF/struts-template.tld' prefix='template' %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/application.tld" prefix="app" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>


<% 
String t_templatorToolBar = ClwCustomizer.getStoreFilePath(request,"t_templatorToolBar.jsp"); 
String rootDir = (String) session.getAttribute("store.dir");
String toolLink01 = "/"+rootDir+"/userportal/msdsTemplate.do";
String toolLink02 = "/"+rootDir+"/userportal/templator.do";
String toolLink03 = "/"+rootDir+"/userportal/templator.do";
String toolLink04 = "/"+rootDir+"/userportal/templator.do";

%>
<jsp:include flush='true' page="<%=t_templatorToolBar%>" >

   <jsp:param name="toolLink01"  value="<%=toolLink01%>"/>
   <jsp:param name="tabs01"  value="productSupportToolBar"/>
   <jsp:param name="display01"  value="msdsTemplate"/>
   <jsp:param name="toolLable01" value="template.jd.bsc.menu.safety"/>
   <jsp:param name="toolSecondaryToolBar01" value=""/>

   <jsp:param name="toolLink02"  value="<%=toolLink02%>"/>
   <jsp:param name="tabs02"  value="marketingToolBar"/>
   <jsp:param name="display02"  value="services"/>
   <jsp:param name="toolLable02" value="template.jd.bsc.menu.child.services"/>
   <jsp:param name="toolSecondaryToolBar02" value=""/>


   <jsp:param name="color01" value="#FFFFFF"/>
   <jsp:param name="color02" value="#003366"/>
   <jsp:param name="color03" value="#006699"/>

   <jsp:param name="headerLabel" value="template.jd.bsc.heading.productSupport"/>
</jsp:include>   
