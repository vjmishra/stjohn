function addSubEntityById(B,A){node=document.getElementById(B);addSubEntity(node,A);}function addSubEntity(S,N){var G=S;if(S==null){return ;}var J=getChildernArrayFromNode(S,N,"childrenElement");var I=J[0];var H=Number(J[1])+1;S=J[2];var B=new Date();var R=B.getTime();var K=document.createElement("DIV");
K.id="DIV"+R;var P=document.createElement("INPUT");P.id="INPUT0"+R;P.type="text";P.size="10";P.name=I+"childrenElement["+H+"].profileOrderString";var O=document.createElement("INPUT");O.id="INPUT1"+R;O.type="text";O.size="10";O.name=I+"childrenElement["+H+"].profileView.profileData.shortDesc";var C=document.createElement("A");
C.id="A3"+R;C.href='javaScript:popLocateGlobal("../general/textEdit","INPUT1'+R+'")';W=document.createTextNode("(e)");C.appendChild(W);var M=document.createElement("INPUT");M.id="INPUT2"+R;M.type="text";M.size="10";M.name=I+"childrenElement["+H+"].profileView.profileData.helpText";var U=document.createElement("A");
U.id="A4"+R;U.href='javaScript:popLocateGlobal("../general/textEdit","INPUT2'+R+'")';W=document.createTextNode("(e)");U.appendChild(W);var E=document.createElement("SELECT");E.id="SELECT1"+R;E.name=I+"childrenElement["+H+"].profileView.profileData.profileQuestionTypeCd";E.options[0]=document.createElement("OPTION");
E.options[1]=document.createElement("OPTION");E.options[2]=document.createElement("OPTION");E.options[3]=document.createElement("OPTION");E.options[0].value="FREE_FORM_TEXT";E.options[1].value="MULTIPLE_CHOICE";E.options[2].value="MULTIPLE_CHOICES";E.options[3].value="NUMBER";E.options[0].text=E.options[0].value;
E.options[1].text=E.options[1].value;E.options[2].text=E.options[2].value;E.options[3].text=E.options[3].value;E.options[0].defaultSelected=1;var D=document.createElement("SELECT");D.id="SELECT2"+R;D.name=I+"childrenElement["+H+"].profileView.profileData.readOnly";D.options[0]=document.createElement("OPTION");
D.options[1]=document.createElement("OPTION");D.options[0].value="false";D.options[1].value="true";D.options[0].text=D.options[0].value;D.options[1].text=D.options[1].value;D.options[0].defaultSelected=1;var F=document.createElement("A");F.id="A"+R;F.href="javascript:removeElementByBaseId("+R+")";W=document.createTextNode("(Remove)");
F.appendChild(W);var T=document.createElement("A");T.id="A2"+R;var Q=1+N;T.href="JavaScript:addSubEntityById('A2"+R+"',"+Q+")";T.name=I+"childrenElement["+H+"].";var W=document.createTextNode("Add Child Question");T.appendChild(W);var A=document.createElement("A");A.id="A5"+R;var Q=1+N;A.href="javascript:addMetaData(this,"+Q+")";
var W=document.createTextNode("Add Answer");A.appendChild(W);var L="";for(i=0;i<N;i++){L=L+"*";}var X=document.createTextNode(L);K.appendChild(document.createElement("BR"));K.appendChild(X);K.appendChild(getBoldedTextElement(" Q:"));K.appendChild(O);K.appendChild(C);K.appendChild(getBoldedTextElement(" Order:"));
K.appendChild(P);K.appendChild(getBoldedTextElement(" Help:"));K.appendChild(M);K.appendChild(U);K.appendChild(getBoldedTextElement(" Type:"));K.appendChild(E);K.appendChild(getBoldedTextElement(" Read Only:"));K.appendChild(D);K.appendChild(F);K.appendChild(getBoldedTextElement(" "));K.appendChild(T);
var V=G.parentNode;debug(V.tagName+":"+V.id+":"+V.name);V.appendChild(K);}function addMetaData(F,N){var P=F;if(F==null){return ;}var G=getChildernArrayFromNode(F,N,"profileMetaDataVectorElement");var B=G[0];var C=Number(G[1])+1;F=G[2];var D=new Date();var O=D.getTime();var A=document.createElement("DIV");
A.id="DIV"+O;A.name="metaData";var I=document.createElement("INPUT");I.id="INPUTANS1"+O;I.type="text";I.size="10";I.name=B+"profileView.profileMetaDataVectorElement["+C+"].value";var H=document.createElement("INPUT");H.id="INPUTANS2"+O;H.type="text";H.size="10";H.name=B+"profileView.profileMetaDataVectorElement["+C+"].helpText";
var K=document.createElement("SELECT");K.id="SELECTANS1"+O;K.name=B+"profileView.profileMetaDataVectorElement["+C+"].profileMetaTypeCd";K.options[0]=document.createElement("OPTION");K.options[1]=document.createElement("OPTION");K.options[2]=document.createElement("OPTION");K.options[3]=document.createElement("OPTION");
K.options[0].value="CHOICE";K.options[1].value="OTHER_CHOICE";K.options[2].value="CHOICE_SHOW_CHILDREN";K.options[3].value="OTHER_CHOICE_SHOW_CHILDREN";K.options[0].text=K.options[0].value;K.options[1].text=K.options[1].value;K.options[2].text=K.options[2].value;K.options[3].text=K.options[3].value;K.options[0].defaultSelected=1;
var M=document.createElement("A");M.id="AANS"+O;M.href="javascript:removeElementByBaseId("+O+")";var E=document.createTextNode("(Remove)");M.appendChild(E);var Q="";for(i=1;i<N;i++){Q=Q+"*";}A.appendChild(document.createElement("BR"));A.appendChild(getBoldedTextElement(Q));A.appendChild(getBoldedTextElement("Answer:"));
A.appendChild(I);A.appendChild(getBoldedTextElement("Help:"));A.appendChild(H);A.appendChild(getBoldedTextElement("Type:"));A.appendChild(K);A.appendChild(M);var J=P.parentNode;if(J==null||J==undefined){J=P;}var L=P;while(L.nextSibling!=undefined&&L.nextSibling.name!=undefined&&L.nextSibling.name=="metaData"){L=L.nextSibling;
}appendChildAt(J,A,L);}function removeElementByBaseId(A){eleId="DIV"+A;if(eleId==null){return ;}ele=document.getElementById(eleId);if(ele==null||ele.nodeType!=1){return ;}parentEle=ele.parentNode;parentEle.removeChild(ele);}function stripToPathToProfile(A){return A.split(/profileView/)[0].split(/profileData/)[0].split(/profileMetaDataVectorElement/)[0].split(/profileDetailDataVector/)[0].split(/container/)[0];
}function debug(A){}function getChildernArrayFromNode(I,E,B){var O=I.name;var P;if(I.name==null||I.name==""||I.name==undefined){P="profile.";O="profile.";}else{P=I.name.replace(/\[/g,"\\[").replace(/\]/g,"\\]");if(B=="childrenElement"){P=P.replace(/.profileView/,"");}}P=P+B;var N=new RegExp("^"+P+"");
debug(N);myRootNode=document.getElementById("questions");var H=getAllElementByNameRegex(myRootNode,null,N);var F=new Array();if(H==null||H==undefined||H.length==0){F[0]=stripToPathToProfile(O);F[1]=-1;F[2]=I;}else{var D=new RegExp(B);var G=P.split(D).length;var A=-1;var C="";var J;for(var M=0;M<H.length;
M++){var L=H[M].name;if(L!=null&&L!=""&&L!="Undefined"){var R=L;var N=new RegExp(B+"\\[");var Q=R.split(N);if(Q[G]!=undefined){var K=Q[G].match(/^\d*/);if(new Number(K)>new Number(A)){A=K;J=H[M];}}}}F[0]=stripToPathToProfile(O);F[1]=A;F[2]=J;}return F;}function showMyImediateChildren(A,U,B){if(!A){return ;
}var J="";if(A.tagName.toLowerCase()=="input"){var R=RegExp(" *");if(A.value.replace(R,"")==""){J="none";}}else{if(A.tagName.toLowerCase()=="select"){}}var S=-1;if(A.getAttribute("profileTypeCd")=="NUMBER"){S=new Number(A.value);}else{if(A.getAttribute("profileTypeCd")=="MULTIPLE_CHOICE"||A.getAttribute("profileTypeCd")=="MULTIPLE_CHOICES"){if(contains(U,A.value)){S=1;
}else{S=0;}var E=A.getAttribute("name").replace("value","shortDesc");myOtherNode=document.getElementById(E);if(myOtherNode){if(contains(B,A.value)){myOtherNode.style.display="";}else{myOtherNode.style.display="none";}}}else{var R=RegExp(" *");if(A.value.replace(R,"")==""){S=0;}else{S=1;}}}if(isNaN(S)){S=0;
}var T=stripToPathToProfile(A.name);var H=T.replace(/\[/g,"\\[").replace(/\]/g,"\\]");var R=new RegExp("^"+H+"childrenElement*");var K=document.getElementById("questions");var D=getAllElementByNameRegex(K,null,R);var G=T.split("children").length;var M=0;var Q=[];var P=-1;for(var N=0;N<D.length;N++){var W=D[N];
if(W.name!=null&&W.name!=undefined){var O=W.name.split("childrenElement");var C=O.length;if(C==(G+1)){var I=new String(W.getAttribute("id"));var V=I.split(".",2);if(V.length>1){I=V[1];}var L=new String(I);L=L.replace("<b>","");L=L.replace("</b>","");var F=new Number(L);if(!isNaN(F)&&F>0){if(P+1!=F+1){M++;
P=F;}}if(S>=0&&M>S){J="none";}W.style.display=J;}}}}