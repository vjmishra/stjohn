var locationDynamicBox={streetAdressVal:"",cityVal:"",stateVal:"",postalCdVal:"",streetAdressMess:"",cityMess:"",stateMess:"",postalCdMess:"",streetAdressBody:"",cityBody:"",stateBody:"",postalCdBody:"",streetAdressHeader:"",cityHeader:"",stateHeader:"",postalCdHeader:"",body:"",to:"",initWriterFlag:"",header:"",mainBody:"",headerMessage:"",control:"",update:function(){locationDynamicBox.mainBody='<TABLE width="100%" border="0" cellpadding="2" cellspacing="1">'+locationDynamicBox.header+locationDynamicBox.body+"</TABLE>";
},init:function(A,K,C,G,E,F,H,B,L,J,I,D){locationDynamicBox.loadControl(J,I,D);locationDynamicBox.loadMessage(A,K,C,G,E);locationDynamicBox.loadHeader();locationDynamicBox.loadVal(F,H,B,L);locationDynamicBox.loadBody();},loadControl:function(C,B,A){if(A=="true"){locationDynamicBox.control+='<input class="store_fb" type="button" name="action" value="'+C+'" onclick="'+B+'"/>';
}else{locationDynamicBox.control="";}},loadHeader:function(){locationDynamicBox.streetAdressHeader='<td class="shopcharthead"><div class="fivemargin" id="lStreetAdressMess">'+locationDynamicBox.streetAdressMess+"</div></td>";locationDynamicBox.cityHeader='<td class="shopcharthead"><div class="fivemargin" id="lCityMess">'+locationDynamicBox.cityMess+"</div></td>";
locationDynamicBox.stateHeader='<td class="shopcharthead"><div class="fivemargin" id="lStateMess">'+locationDynamicBox.stateMess+"</div></td>";locationDynamicBox.postalCdHeader='<td class="shopcharthead"><div class="fivemargin" id="lPostalCdMess">'+locationDynamicBox.postalCdMess+"</div></td>";locationDynamicBox.header="<tr>"+'<td class=customerltbkground vAlign=top align=middle colspan="4">'+"<SPAN class=shopassetdetailtxt><B>"+locationDynamicBox.headerMessage+"</B></SPAN>"+"&nbsp;"+locationDynamicBox.control+"</tr>";
locationDynamicBox.header+='<tr class="tableheaderinfo">'+locationDynamicBox.streetAdressHeader+locationDynamicBox.cityHeader+locationDynamicBox.stateHeader+locationDynamicBox.postalCdHeader+"</tr>";},loadMessage:function(D,B,E,A,C){locationDynamicBox.headerMessage=D;locationDynamicBox.streetAdressMess=B;
locationDynamicBox.cityMess=E;locationDynamicBox.stateMess=A;locationDynamicBox.postalCdMess=C;},loadBody:function(){locationDynamicBox.streetAdressBody='<td><div id="lStreetAdress">'+locationDynamicBox.streetAdressVal+"</div></td>";locationDynamicBox.cityBody='<td><div id="lCity">'+locationDynamicBox.cityVal+"</div></td>";
locationDynamicBox.stateBody='<td><div id="lState">'+locationDynamicBox.stateVal+"</div></td>";locationDynamicBox.postalCdBody='<td><div id="lPostalCd">'+locationDynamicBox.postalCdVal+"</div></td>";locationDynamicBox.body="<tr>"+locationDynamicBox.streetAdressBody+locationDynamicBox.cityBody+locationDynamicBox.stateBody+locationDynamicBox.postalCdBody+"</tr>";
},loadVal:function(B,D,C,A){locationDynamicBox.streetAdressVal=B;locationDynamicBox.cityVal=D;locationDynamicBox.stateVal=C;locationDynamicBox.postalCdVal=A;},initWriter:function(A){locationDynamicBox.to=A;locationDynamicBox.initWriterFlag=true;},write:function(){if(locationDynamicBox.initWriterFlag){var A=document.getElementById(locationDynamicBox.to);
locationDynamicBox.update();A.innerHTML=locationDynamicBox.mainBody;}},redraw:function(){if(locationDynamicBox.initWriterFlag){var A=document.getElementById(locationDynamicBox.to);locationDynamicBox.loadBody();locationDynamicBox.update();A.innerHTML=locationDynamicBox.mainBody;}},redrawVal:function(){if(locationDynamicBox.initWriterFlag){var A=document.getElementById(locationDynamicBox.to);
locationDynamicBox.update();document.getElementById("lStreetAdress").innerHTML=locationDynamicBox.streetAdressVal;document.getElementById("lCity").innerHTML=locationDynamicBox.cityVal;document.getElementById("lState").innerHTML=locationDynamicBox.stateVal;document.getElementById("lPostalCd").innerHTML=locationDynamicBox.postalCdVal;
}},populateAndReDraw:function(D,C){var E="";var B="";var K="";var H="";if(D!=null){var I=D.getElementsByTagName("Address")[0];if(I!=null&&"undefined"!=typeof I){var G=I.getElementsByTagName("Address1")[0];if(G!=null&&"undefined"!=typeof G){H=G.firstChild.nodeValue;}var J=I.getElementsByTagName("City")[0];
if(J!=null&&"undefined"!=typeof J){E=J.firstChild.nodeValue;}var A=I.getElementsByTagName("StateProvinceCd")[0];if(A!=null&&"undefined"!=typeof A){B=A.firstChild.nodeValue;}var F=I.getElementsByTagName("PostalCode")[0];if(F!=null&&"undefined"!=typeof F){K=F.firstChild.nodeValue;}}}if(H==null||H=="null"){H="";
}if(E==null||E=="null"){E="";}if(B==null||B=="null"){B="";}if(K==null||K=="null"){K="";}locationDynamicBox.loadVal(H,E,B,K);locationDynamicBox.redrawVal();}};