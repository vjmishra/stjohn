var clCountryListDynamicBox={display:false,countrySelectElementName:"",countryEmptyMessage:"",countrySelectElement:"",setCountryBody:function(D,A,C,B){clCountryListDynamicBox.countrySelectElementId=B;clCountryListDynamicBox.countryEmptyMessage=C;clCountryListDynamicBox.countrySelectElement=document.getElementById(clCountryListDynamicBox.countrySelectElementId);
loadDataToSelectObject(clCountryListDynamicBox.countrySelectElement,D,A,C);},updateCountryBody:function(B,A){loadDataToSelectObject(clCountryListDynamicBox.countrySelectElement,B,A,clCountryListDynamicBox.countryEmptyMessage);},init:function(D,A,C,B){clCountryListDynamicBox.setCountryBody(D,A,C,B);clCountryListDynamicBox.display=true;
},populateAndReDraw:function(G,C){var F;var E="";if(G.list&&G.list.length){E=G.selected;F=new Array();for(var D=0,B=0;D<G.list.length;D++){var A=G.list[D].val;F[B]=new Array();F[B][0]=A;F[B][1]=A;B++;}}clCountryListDynamicBox.updateCountryBody(F,E);}};var clSiteListDynamicBox={display:false,siteSelectElementId:"",siteEmptyMessage:"",siteSelectElement:"",setSiteBody:function(D,B,A,C){clSiteListDynamicBox.siteSelectElementId=C;
clSiteListDynamicBox.siteEmptyMessage=A;clSiteListDynamicBox.siteSelectElement=document.getElementById(clSiteListDynamicBox.siteSelectElementId);loadDataToSelectObject(clSiteListDynamicBox.siteSelectElement,D,B,A);},updateSiteBody:function(B,A){loadDataToSelectObject(clSiteListDynamicBox.siteSelectElement,B,A,clSiteListDynamicBox.siteEmptyMessage);
},init:function(D,B,A,C){clSiteListDynamicBox.setSiteBody(D,B,A,C);clSiteListDynamicBox.display=true;},populateAndReDraw:function(H,C){var G;var E="";if(H.list&&H.list.length){E=H.selected;G=new Array();for(var D=0,B=0;D<H.list.length;D++){var A=H.list[D].val;var F=H.list[D].id;G[B]=new Array();G[B][0]=F;
G[B][1]=A;B++;}}clSiteListDynamicBox.updateSiteBody(G,E);}};var clStateListDynamicBox={display:false,stateSelectElementId:"",stateEmptyMessage:"",stateSelectElement:"",setStateBody:function(D,B,A,C){clStateListDynamicBox.stateSelectElementId=C;clStateListDynamicBox.stateEmptyMessage=A;clStateListDynamicBox.stateSelectElement=document.getElementById(C);
loadDataToSelectObject(clStateListDynamicBox.stateSelectElement,D,B,A);},updateStateBody:function(B,A){loadDataToSelectObject(clStateListDynamicBox.stateSelectElement,B,A,clStateListDynamicBox.stateEmptyMessage);},init:function(D,B,A,C){clStateListDynamicBox.setStateBody(D,B,A,C);clStateListDynamicBox.display=true;
},populateAndReDraw:function(F,B){var G;var E="";if(F.list&&F.list.length){E=F.selected;G=new Array();for(var D=0,A=0;D<F.list.length;D++){var C=F.list[D].val;G[A]=new Array();G[A][0]=C;G[A][1]=C;A++;}}clStateListDynamicBox.updateStateBody(G,E);}};var locationCriteria={update:function(A,B){if(A.response.sites&&A.response.sites.redraw&&clSiteListDynamicBox.display){clSiteListDynamicBox.populateAndReDraw(A.response.sites,B);
}if(A.response.states&&A.response.states.redraw&&clStateListDynamicBox.display){clStateListDynamicBox.populateAndReDraw(A.response.states,B);}if(A.response.countries&&A.response.countries.redraw&&clCountryListDynamicBox.display){clCountryListDynamicBox.populateAndReDraw(A.response.countries,B);}}};function addOptionToSelectObject(F,E,B,D,A){var C=document.createElement("option");
C.appendChild(document.createTextNode(E));C.setAttribute("value",B);if(D){C.defaultSelected=true;}else{if(A){C.selected=true;}}F.appendChild(C);}function removeAllSelectObjectOptions(A){if(A.options){A.options.length=0;}}function loadDataToSelectObject(B,E,D,A){if(B){removeAllSelectObjectOptions(B);addOptionToSelectObject(B,A,"",true);
if(E!=null&&"undefined"!=typeof E&&E.length!=null&&"undefined"!=typeof E.length){for(var C=0;C<E.length;C++){if(D==E[C][0]){addOptionToSelectObject(B,E[C][1],E[C][0],false,true);}else{addOptionToSelectObject(B,E[C][1],E[C][0]);}}}}}