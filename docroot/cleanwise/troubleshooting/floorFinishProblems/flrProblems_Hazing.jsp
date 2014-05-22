
<%@ page language="java" %>
<%@ page import="com.cleanwise.view.utils.Constants" %>
<%@ page import="com.cleanwise.view.utils.ClwCustomizer" %>
<%@ page import="com.cleanwise.view.utils.SessionTool" %>

<%@ taglib uri='/WEB-INF/struts-template.tld' prefix='template' %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/application.tld" prefix="app" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>



<% String storeDir=ClwCustomizer.getStoreDir(); %>
<% 
String query=request.getQueryString();
String currUri=SessionTool.getActualRequestedURI(request) +"?"; 
if(query!=null){
    currUri+=query+"&";
}
%>
<bean:define id="ip" name="<%=Constants.IMAGES_PATH%>" scope="session"/>




      <table align="center" border="0" cellpadding="0" cellspacing="0" width="<%=Constants.TABLEWIDTH1%>">
        <tr>
          <td class="smalltext" valign="up" width="20%">
          <td>
		  
		  
            <table align="center" border="0" cellpadding="0" cellspacing="0" width="100%">
              <!--    Heading     -->	
  <tr><td></td><td class="text">
<span class="subheaders">
   Hazing
  </span><br><br></td></tr>
  <tr><!-- question -->
    <td valign="top"><img src="/<%=storeDir%>/<%=ip%>images/cw_troubleshooterQ.gif" vspace="3" hspace="3" WIDTH="8" HEIGHT="12"></td>
    <td class="text"><b>Why does my finish have a steamy look instead of a gloss?</b></td>
  </tr>
  <tr><!-- horizontal space -->
    <td colspan="2"><img src="/<%=storeDir%>/<%=ip%>images/cw_spacer.gif" height="5" width="1"></td>
  </tr>				
  <tr><!-- answer -->
    <td valign="top"><img src="/<%=storeDir%>/<%=ip%>images/cw_troubleshooterA.gif" vspace="0" hspace="3" WIDTH="8" HEIGHT="11"></td>
    <td class="text">
	<p>Hazing and ghosting are floor finish problems that give a steamy appearance to the gloss.  Hazing can be described as a film or steamy look on the finish and usually goes deeper than just one coat.  Hazing is almost always caused by a procedural error in the daily maintenance so try to pinpoint what has caused the hazing and train everyone on how to avoid it.  Since this problem can escalate labor and chemical costs it is cost effective to correct the procedure that created the problem.</p>
	The following can cause hazing:
	   <ul class="text">
	    <li class="troubleshootingbullet"><span class="text"><a href="#1"><span class="subheaders">Stripper residue</span></a></span></li>
	    <li class="troubleshootingbullet"><span class="text"><a href="#2"><span class="subheaders">Contaminated mops and buckets</span></a></span></li>
	    <li class="troubleshootingbullet"><span class="text"><a href="#3"><span class="subheaders">Recoating too soon</span></a></span></li>
	    <li class="troubleshootingbullet"><span class="text"><a href="#4"><span class="subheaders">Applying finish too thin</span></a></span></li>
	    <li class="troubleshootingbullet"><span class="text"><a href="#5"><span class="subheaders">Using hot water for daily cleaning</span></a></span></li>
	   </ul><br>
     </td>
   </tr>
   <tr><!-- horizontal rule -->
     <td class="troubleshooterrulecolor" colspan="2"><img src="/<%=storeDir%>/<%=ip%>images/cw_spacer.gif" height="1" width="1"></td>
   </tr>
   <tr>
     <td valign="top"><img src="/<%=storeDir%>/<%=ip%>images/cw_spacer.gif" vspace="0" hspace="3" WIDTH="8" HEIGHT="11"></td>
     <td><br><ul class="text">
	  <li class="troubleshootingbullet"><span class="text"><a name="1"><span class="subheaders">Stripper residue</span></a>
             <br><b>How to Fix:</b><br>The problem can only be fixed by removing the effected finish.  To remove hazing from finish you will need to scrub with a general purpose cleaner using a green or blue floor pad and apply new finish.  In more severe cases, it may be necessary to strip the floor.
             <p><b>How to Prevent:</b><br>Rinse!  Make sure to rinse the floor.  Many strippers on the market today are labeled as "no rinse" strippers.  This term means only that a flood rinse is not required.  However, a damp mop rinse still must be done.</p>
             <table align="right"><tr><td align="right" class="text"><div class="searchmargin"><a href="#">[<img src="/<%=storeDir%>/<%=ip%>images/cw_greentop.gif" border="0" WIDTH="6" HEIGHT="6">]&nbsp;Top</a></div></td></tr></table></span></li>
          </ul><br>
	</td>
       </tr>
<tr><!-- horizontal rule -->
     <td class="troubleshooterrulecolor" colspan="2"><img src="/<%=storeDir%>/<%=ip%>images/cw_spacer.gif" height="1" width="1"></td>
   </tr>
   <tr>
     <td valign="top"><img src="/<%=storeDir%>/<%=ip%>images/cw_spacer.gif" vspace="0" hspace="1" WIDTH="8" HEIGHT="11"></td>
     <td><br>
         <ul class="text">
	  <li class="troubleshootingbullet"><span class="text"><a name="2"><span class="subheaders">Contaminated mops and buckets</span></a>
             <br><b>How to Fix:</b><br>The problem can only be fixed by removing the effected finish.  To remove hazing from finish you will need to scrub with a general purpose cleaner using a green or blue floor pad and apply new finish.  In more severe cases, it may be necessary to strip the floor.
             <p><b>How to Prevent:</b><br>Always line the bucket with a plastic liner before pouring the finish into it.
Unused finish should be disposed of and not poured back into the container.
Always use clean mops specifically designed for finish to apply the finish with.</p>
             <ul class="text">
               <li class="troubleshootingbullet"><span class="text">Never use the mop that was used for applying the stripper to apply finish.</span></li>
               <li class="troubleshootingbullet"><span class="text">Never use the mop that was used for damp rinsing the floor after stripping</span></li>
               <li class="troubleshootingbullet"><span class="text">Never use the mop that was used to apply a restorer.</span></li></ul>
             <table align="right"><tr><td align="right" class="text"><div class="searchmargin"><a href="#">[<img src="/<%=storeDir%>/<%=ip%>images/cw_greentop.gif" border="0" WIDTH="6" HEIGHT="6">]&nbsp;Top</a></div></td></tr></table></span></li>
          </ul><br>
	</td>
       </tr>
<tr><!-- horizontal rule -->
     <td class="troubleshooterrulecolor" colspan="2"><img src="/<%=storeDir%>/<%=ip%>images/cw_spacer.gif" height="1" width="1"></td>
   </tr>
   <tr>
     <td valign="top"><img src="/<%=storeDir%>/<%=ip%>images/cw_spacer.gif" vspace="0" hspace="1" WIDTH="8" HEIGHT="11"></td>
     <td><br>
         <ul class="text">
	  <li class="troubleshootingbullet"><span class="text"><a name="3"><span class="subheaders">Recoating too soon</span></a>
             <br><b>How to Fix:</b><br>The problem can only be fixed by removing the effected finish.  To remove hazing from finish you will need to scrub with a general purpose cleaner using a green or blue floor pad and apply new finish.  In more severe cases, it may be necessary to strip the floor.
             <p><b>How to Prevent:</b><br>Be patient!  Do not rush the dry time of the finish.  You will save much more time waiting an extra 10 minutes for the finish to dry completely than you will re-stripping a floor.  Many manufacturers will give recommended dry times.  The key word is recommended - always take into account the climate.  A humid climate will require more dry time than a dry climate.  No matter what the recommended dry time is, make sure the finish is dry to the touch and then wait another 15 minutes no matter.</p>
             <table align="right"><tr><td align="right" class="text"><div class="searchmargin"><a href="#">[<img src="/<%=storeDir%>/<%=ip%>images/cw_greentop.gif" border="0" WIDTH="6" HEIGHT="6">]&nbsp;Top</a></div></td></tr></table></span></li>
          </ul><br>
	</td>
       </tr>
<tr><!-- horizontal rule -->
     <td class="troubleshooterrulecolor" colspan="2"><img src="/<%=storeDir%>/<%=ip%>images/cw_spacer.gif" height="1" width="1"></td>
   </tr>
   <tr>
     <td valign="top"><img src="/<%=storeDir%>/<%=ip%>images/cw_spacer.gif" vspace="0" hspace="1" WIDTH="8" HEIGHT="11"></td>
     <td><br>
         <ul class="text">
	  <li class="troubleshootingbullet"><span class="text"><a name="4"><span class="subheaders">Applying finish too thin</span></a>
             <br><b>How to Fix:</b><br>The problem can only be fixed by removing the effected finish.  To remove hazing from finish you will need to scrub with a general purpose cleaner using a green or blue floor pad and apply new finish.  In more severe cases, it may be necessary to strip the floor.
             <p><b>How to Prevent:</b><br>Make sure you are applying an even medium coat.  The finish should not be applied too thickly or too thinly.  To ensure the right kind of coat, try wringing the mop out halfway.  Or, try giving the mop a half twist and tamping (pressing down) on the mop until only an occasional drip of finish comes off the mop.</p>
             <table align="right"><tr><td align="right" class="text"><div class="searchmargin"><a href="#">[<img src="/<%=storeDir%>/<%=ip%>images/cw_greentop.gif" border="0" WIDTH="6" HEIGHT="6">]&nbsp;Top</a></div></td></tr></table></span></li>
          </ul><br>
	</td>
       </tr>
<tr><!-- horizontal rule -->
     <td class="troubleshooterrulecolor" colspan="2"><img src="/<%=storeDir%>/<%=ip%>images/cw_spacer.gif" height="1" width="1"></td>
   </tr>
   <tr>
     <td valign="top"><img src="/<%=storeDir%>/<%=ip%>images/cw_spacer.gif" vspace="0" hspace="1" WIDTH="8" HEIGHT="11"></td>
     <td><br>
         <ul class="text">
	  <li class="troubleshootingbullet"><span class="text"><a name="5"><span class="subheaders">Using hot water for daily cleaning</span></a>
             <br><b>How to Fix:</b><br>The problem can only be fixed by removing the effected finish.  To remove hazing from finish you will need to scrub with a general purpose cleaner using a green or blue floor pad and apply new finish.  In more severe cases, it may be necessary to strip the floor.
             <p><b>How to Prevent:</b><br>Use cool water when damp mopping.</p>
             </span></li>
          </ul><br>
	</td>
       </tr>
<tr><!-- horizontal rule -->
     <td class="troubleshooterrulecolor" colspan="2"><img src="/<%=storeDir%>/<%=ip%>images/cw_spacer.gif" height="1" width="1"></td>
   </tr>
   <tr>
     <td valign="top"><img src="/<%=storeDir%>/<%=ip%>images/cw_spacer.gif" vspace="0" hspace="1" WIDTH="8" HEIGHT="11"></td>
     <td><br>
         <ul class="text">
      </ul>
     </td>
   </tr>														
</table>


          </td>
		  <td class="smalltext" valign="up" width="20%"></td>
        </tr>
      </table>
      