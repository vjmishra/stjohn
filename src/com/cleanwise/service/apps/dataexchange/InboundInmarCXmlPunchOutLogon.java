/**
 * 
 */
package com.cleanwise.service.apps.dataexchange;

import java.rmi.RemoteException;
import java.sql.Connection;

import org.dom4j.Node;

import com.cleanwise.service.api.value.*;
import com.cleanwise.service.api.dao.UserDataAccess;
import com.cleanwise.service.api.util.DBCriteria;
import com.cleanwise.service.api.util.InvalidLoginException;
import com.cleanwise.service.api.util.RefCodeNames;

/**
 * @author ssharma
 *
 */
public class InboundInmarCXmlPunchOutLogon extends InboundcXMLPunchOutLogon {
	
	public InboundInmarCXmlPunchOutLogon(){
		siteRefNumType = RefCodeNames.PROPERTY_TYPE_CD.SITE_REFERENCE_NUMBER;
	}

    /**Hard coded as they cannot send enough information to know about the site*/
	protected int getValidSite(String siteRefNum) throws Exception{
		return super.getValidSite("InmarDEFLOC");
	}

	/**
	 * This is used only by Pollock -Inmar. Get the user from PunchOutSetupRequest/ShipTo
	 * There is a one-to-one correspondence between a user and a shipTo location
	 * 
	 * @param args
	 * @throws InvalidLoginException 
	 * @throws RemoteException 
	 */
	protected UserAcessTokenViewData getAccess(Node nodeToOperateOn) throws Exception{
		UserAcessTokenViewData tokenView;
		LdapItemData ldap = parseLdapItem(nodeToOperateOn); 
		//uniqueName = ldap.getUserName();
		
		Connection pCon = null;
		try{
			/*Node shipToNode = nodeToOperateOn.getDocument().selectSingleNode("//cXML/Request/PunchOutSetupRequest/ShipTo/Address");
			if(shipToNode == null){
				throw new Exception("Could not parse cXML (ShipTo/Address)");
			}
		
			String siteRefNum = shipToNode.valueOf("@addressID");
			if(siteRefNum == null || !(siteRefNum.trim().length()>0)){
				throw new Exception("Could not parse cXML (AddressID)");
			}*/
			String siteRefNum = "InmarDEFLOC";
			
			//String usrname = "IN"+siteRefNum;
			String usrname = "inmar_def_site";
		
			Node credentialNode = nodeToOperateOn.getDocument().selectSingleNode("//cXML/Header/Sender/Credential");
	        if(credentialNode == null){
	        	throw new Exception("Could not parse cXML (Credential)");
	        }
	        
	        Node passNameNode = credentialNode.selectSingleNode("SharedSecret");
	        if(passNameNode == null){
	        	throw new Exception("Could not parse cXML (SharedSecret)");
	        }
	        
	        String pass = passNameNode.getText();
		
	        String passval = mPassword;
	        if(!pass.equalsIgnoreCase(passval)){
	        	throw new Exception("Authorization failed.  Check username and trading profile authorization setup.");
	        }
			
			//check if user exists in our system else login as default user
			DBCriteria cr = new DBCriteria();
			pCon= this.getConnection();
			
			cr.addEqualTo(UserDataAccess.USER_NAME, usrname);
			cr.addEqualTo(UserDataAccess.USER_STATUS_CD, RefCodeNames.USER_STATUS_CD.ACTIVE);
			
			UserDataVector udv = UserDataAccess.select(pCon, cr);
			
			if(udv!=null && udv.size()>0){
				ldap.setUserName(usrname);
			}else{
				throw new Exception("User Name not valid: " + usrname);
			}		
			
			tokenView = Translator.intSvc.createAccessToken(ldap,false);
			return tokenView;
			
		
		}catch(Exception exc){
			exc.printStackTrace();
			throw new Exception(exc.getMessage());
		}finally{
			if(pCon!=null){
				pCon.close();
			}
		}
	}
		
	protected void getChangeLocationEnabled(){
		changeLocation = true;
    }
	
}
