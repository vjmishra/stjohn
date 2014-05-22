/**
 * Title:        CheckLogonTag
 * Description:  This is the tag class of CheckLogon.
 * Purpose:      
 * Copyright:    Copyright (c) 2001
 * Company:      CleanWise, Inc.
 * @author       Liang Li
 */

package com.cleanwise.view.taglibs;


import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;
import org.apache.struts.action.Action;
//import org.apache.struts.util.MessageResources;
import com.cleanwise.view.utils.Constants;
import com.cleanwise.view.utils.CleanwiseUser;

/**
 * Check for a valid User logged on in the current session.  If there is no
 * such user, forward control to the logon page.
 */

public class AuthorizedForFunction extends TagSupport {

    /** Holds value of property name. */
    private String name;    



    // ------------------------------------------------------- Public Methods


    /**
     * Checks if the currently logged in user is authorized for the provided function.  If there is no
     * user logged in the body will not be rendered.
     *
     * @exception JspException if a JSP exception has occurred
     */
    public int doStartTag() throws JspException {
        if(getName() == null || pageContext == null || pageContext.getSession() == null){
            return SKIP_BODY;
        }
        CleanwiseUser appUser = (CleanwiseUser) pageContext.getSession().getAttribute(Constants.APP_USER);
        if(appUser == null){
            return SKIP_BODY;
        }
	if(appUser.isAuthorizedForFunction(getName())){
            return EVAL_BODY_INCLUDE;
        }
        return SKIP_BODY;
    }

    


    /**
     * Release any acquired resources.
     */
    public void release() {
        super.release();
    }

    /** Getter for property name.
     * @return Value of property name.
     *
     */
    public String getName() {
        return this.name;
    }    

    /** Setter for property name.
     * @param name New value of property name.
     *
     */
    public void setName(String name) {
        this.name = name;
    }
    
}
