var imagePath="../externals/images/";var ie=document.all;var dom=document.getElementById;var ns4=document.layers;var bShow=false;var textCtl;function setTimePicker(A){textCtl.value=A;closeTimePicker();}function refreshTimePicker(B){if(B==0){suffix="am";}else{suffix="pm";}sHTML="<table><tr><td><table cellpadding=1 cellspacing=0 bgcolor='#ffffff'>";
for(i=0;i<12;i++){sHTML+="<tr align=right style='font-family:verdana,Arial,Helvetica,Geneva,Swiss,sans-serif;font-size:11px;font-weight:bold;color:#000000;'>";if(i==0){hr=12;}else{hr=i;}for(j=0;j<4;j++){var A=((suffix=="am")?((hr<12)?hr:hr-12):((hr<12)?hr+12:hr));sHTML+="<td width=40 style='cursor:hand;font-family:verdana,Arial,Helvetica,Geneva,Swiss,sans-serif;font-size:11px;font-weight:bold;' onmouseover='this.style.backgroundColor=\"#B0B0B0\"' onmouseout='this.style.backgroundColor=\"\"' onclick='setTimePicker(\""+A+":"+padZero(j*15)+"\")'><a style='text-decoration:none;color:#000000' href='javascript:setTimePicker(\""+A+":"+padZero(j*15)+"\")'>"+A+":"+padZero(j*15)+"&nbsp;"+'<font color="#808080">'+"&nbsp;</font></a></td>";
}sHTML+="</tr>";}sHTML+="</table></td></tr></table>";document.getElementById("timePickerContent").innerHTML=sHTML;}var ieTitle="<div id='timepicker' style='z-index:9;position:absolute;visibility:hidden;'><table style='border-width:3px;border-style:solid;border-color:#000000' bgcolor='#ffffff' cellpadding=0><tr bgcolor='#808080'><td><table cellpadding=0 cellspacing=0 width='100%' background='"+imagePath+"titleback.gif'><tr valign=bottom height=21><td style='font-family:verdana,Arial,Helvetica,Geneva,Swiss,sans-serif;font-size:11px;color:#ffffff;padding:3px' valign=center><B>&nbsp;Select&nbsp;Time </B></td><td><img id='iconAM' src='"+imagePath+'am1.gif\' onclick=\'document.getElementById("iconAM").src="'+imagePath+'am1.gif";document.getElementById("iconPM").src="'+imagePath+"pm2.gif\";refreshTimePicker(0)' style='cursor:hand'></td><td><img id='iconPM' src='"+imagePath+'pm2.gif\' onclick=\'document.getElementById("iconAM").src="'+imagePath+'am2.gif";document.getElementById("iconPM").src="'+imagePath+"pm1.gif\";refreshTimePicker(1)' style='cursor:hand'></td></tr></table></td></tr><tr><td colspan=2><span id='timePickerContent'></span></td></tr><TR><TD HEIGHT=1 BGCOLOR=#000000></TD></TR><TR><TD HEIGHT=20 ALIGN=MIDDLE><A STYLE=\"color: #336699\" HREF=\"javascript:closeTimePicker()\">Cancel</A></TD></TR></table></div>";
var otherTitle="<div id='timepicker' style='z-index:9;position:absolute;visibility:hidden;'><table style='border-width:3px;border-style:solid;border-color:#6666CC' bgcolor='#ffffff' cellpadding=0><tr bgcolor='#6666CC'><td><table cellpadding=0 cellspacing=0 width='100%' background='"+imagePath+"titleback.gif'><tr valign=bottom height=21><td style='font-family:verdana,Arial,Helvetica,Geneva,Swiss,sans-serif;font-size:11px;color:#ffffff;padding:3px' valign=center><B>&nbsp;Select&nbsp;Time </B></td><td><img id='iconAM' src='"+imagePath+'am1.gif\' onclick=\'document.getElementById("iconAM").src="'+imagePath+'am1.gif";document.getElementById("iconPM").src="'+imagePath+"pm2a.gif\";refreshTimePicker(0)' style='cursor:hand'></td><td><img id='iconPM' src='"+imagePath+'pm2a.gif\' onclick=\'document.getElementById("iconAM").src="'+imagePath+'am2a.gif";document.getElementById("iconPM").src="'+imagePath+"pm1.gif\";refreshTimePicker(1)' style='cursor:hand'></td></tr></table></td></tr><tr><td colspan=2><span id='timePickerContent'></span></td></tr><TR><TD HEIGHT=1 BGCOLOR=#000000></TD></TR><TR><TD HEIGHT=20 ALIGN=MIDDLE><A STYLE=\"color: #336699\" HREF=\"javascript:closeTimePicker()\">Cancel</A></TD></TR></table></div>";
var title=otherTitle;if(window.navigator.userAgent.indexOf("MSIE")>=0){title=ieTitle;}if(dom){document.write(title);refreshTimePicker(0);}var crossobj=(dom)?document.getElementById("timepicker").style:ie?document.all.timepicker:document.timepicker;var currentCtl;function selectTime(A,E){var B=document.getElementById("timepicker");
var D=0;var C=0;textCtl=E;currentCtl=A;currentCtl.src=imagePath+"showCalendar.gif";aTag=A;var F=getOffset(A);D=F.left;C=F.top;crossobj.left=D+A.offsetWidth;crossobj.top=C+A.offsetHeight+2;fit(B,aTag);crossobj.visibility=(dom||ie)?"visible":"show";hideElement("SELECT",B);hideElement("APPLET",B);bShow=true;
}function hideElement(A,B){if(ie){for(i=0;i<document.all.tags(A).length;i++){obj=document.all.tags(A)[i];if(!obj||!obj.offsetParent){continue;}objLeft=obj.offsetLeft;objTop=obj.offsetTop;objParent=obj.offsetParent;while(objParent.tagName.toUpperCase()!="BODY"){objLeft+=objParent.offsetLeft;objTop+=objParent.offsetTop;
objParent=objParent.offsetParent;}objHeight=obj.offsetHeight;objWidth=obj.offsetWidth;if((B.offsetLeft+B.offsetWidth)<=objLeft){}else{if((B.offsetTop+B.offsetHeight)<=objTop){}else{if(B.offsetTop>=(objTop+objHeight+obj.height)){}else{if(B.offsetLeft>=(objLeft+objWidth)){}else{obj.style.visibility="hidden";
}}}}}}}function showElement(A){if(ie){for(i=0;i<document.all.tags(A).length;i++){obj=document.all.tags(A)[i];if(!obj||!obj.offsetParent){continue;}obj.style.visibility="";}}}function closeTimePicker(){crossobj.visibility="hidden";showElement("SELECT");showElement("APPLET");currentCtl.src=imagePath+"showCalendar.gif";
}document.onkeypress=function hideTimePicker1(){if(event.keyCode==27){if(!bShow){closeTimePicker();}}};function isDigit(A){return((A=="0")||(A=="1")||(A=="2")||(A=="3")||(A=="4")||(A=="5")||(A=="6")||(A=="7")||(A=="8")||(A=="9"));}function isNumeric(A){num=parseInt(A,10);return !isNaN(num);}function padZero(A){v="";
if(A<10){return("0"+A);}else{return A;}}function validateDatePicker(B){C=B.value.toLowerCase();C=C.replace(" ","");C=C.replace(".",":");C=C.replace("-","");if((isNumeric(C))&&(C.length==4)){C=C.charAt(0)+C.charAt(1)+":"+C.charAt(2)+C.charAt(3);}var C=new String(C);tl=C.length;if(tl==1){if(isDigit(C)){B.value=C+":00 am";
}else{return false;}}else{if(tl==2){if(isNumeric(C)){if(parseInt(C,10)<13){if(C.charAt(1)!=":"){B.value=C+":00 am";}else{B.value=C+"00 am";}}else{if(parseInt(C,10)==24){B.value="0:00 am";}else{if(parseInt(C,10)<24){if(C.charAt(1)!=":"){B.value=(C-12)+":00 pm";}else{B.value=(C-12)+"00 pm";}}else{if(parseInt(C,10)<=60){B.value="0:"+padZero(C)+" am";
}else{B.value="1:"+padZero(C%60)+" am";}}}}}else{if((C.charAt(0)==":")&&(isDigit(C.charAt(1)))){B.value="0:"+padZero(parseInt(C.charAt(1),10))+" am";}else{return false;}}}else{if(tl>=3){var A=C.split(":");if(C.indexOf(":")>0){hr=parseInt(A[0],10);mn=parseInt(A[1],10);if(C.indexOf("pm")>0){mode="pm";}else{mode="am";
}if(isNaN(hr)){hr=0;}else{if(hr>24){return false;}else{if(hr==24){mode="am";hr=0;}else{if(hr>12){mode="pm";hr-=12;}}}}if(isNaN(mn)){mn=0;}else{if(mn>60){mn=mn%60;hr+=1;}}}else{hr=parseInt(A[0],10);if(isNaN(hr)){hr=0;}else{if(hr>24){return false;}else{if(hr==24){mode="am";hr=0;}else{if(hr>12){mode="pm";
hr-=12;}}}}mn=0;}if(hr==24){hr=0;mode="am";}B.value=hr+":"+padZero(mn)+" "+mode;}}}}function fit(C,J){var G=getOffset(C);var E=getViewPortSize();var A=parseInt(C.offsetWidth);var I=parseInt(C.offsetHeight);var H=document.body;var F=document.documentElement;var B=window.pageYOffset||F.scrollTop||H.scrollTop;
var D=window.pageXOffset||F.scrollLeft||H.scrollLeft;if(((G.left+A+J.offsetWidth)-D)>E.width){C.style.left=Math.max((H.scrollLeft||F.scrollLeft),G.left-((G.left+A-D)-E.width)-J.offsetWidth)+"px";}if(((G.top+I+J.offsetHeight)-B)>E.height){C.style.top=Math.max((H.scrollTop||F.scrollTop),G.top-I-J.offsetHeight)+"px";
}}function getViewPortSize(){var A={};if(typeof window.innerWidth!="undefined"){A.width=window.innerWidth;A.height=window.innerHeight;}else{if(typeof document.documentElement!="undefined"&&typeof document.documentElement.clientWidth!="undefined"&&document.documentElement.clientWidth!=0){A.width=document.documentElement.clientWidth;
A.height=document.documentElement.clientHeight;}else{A.width=document.getElementsByTagName("body")[0].clientWidth;A.height=document.getElementsByTagName("body")[0].clientHeight;}}return A;}function getOffsetSum(A){var C=0,B=0;while(A){C=C+parseInt(A.offsetTop);B=B+parseInt(A.offsetLeft);A=A.offsetParent;
}return{top:C,left:B};}function getOffsetRect(D){var G=D.getBoundingClientRect();var H=document.body;var B=document.documentElement;var A=window.pageYOffset||B.scrollTop||H.scrollTop;var E=window.pageXOffset||B.scrollLeft||H.scrollLeft;var F=B.clientTop||H.clientTop||0;var I=B.clientLeft||H.clientLeft||0;
var J=G.top+A-F;var C=G.left+E-I;return{top:Math.round(J),left:Math.round(C)};}function getOffset(A){if(A.getBoundingClientRect){return getOffsetRect(A);}else{return getOffsetSum(A);}}