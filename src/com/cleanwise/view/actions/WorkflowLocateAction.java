
package com.cleanwise.view.actions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;
import com.cleanwise.view.logic.WorkflowMgrLogic;
import com.cleanwise.view.utils.*;


/**
 *  Implementation of <strong>Action</strong> that processes the
 *  Account Workflow entries.
 *
 *@author     durval
 *@created    December 10, 2001
 */
public final class WorkflowLocateAction extends ActionSuper {

    // ----------------------------------------------- Public Methods

    /**
     *  Process the specified HTTP request, and create the
     *  corresponding HTTP response (or forward to another web
     *  component that will create it).  Return an
     *  <code>ActionForward</code> instance describing where and how
     *  control should be forwarded, or <code>null</code> if the
     *  response has already been completed.
     *
     *@param  mapping               The ActionMapping used to select this
     *      instance
     *@param  request               The HTTP request we are processing
     *@param  response              The HTTP response we are creating
     *@param  form                  Description of Parameter
     *@return                       Description of the Returned Value
     *@exception  IOException       if an input/output error occurs
     *@exception  ServletException  if a servlet exception occurs
     */
    public ActionForward performSub(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response)
    throws IOException, ServletException {

        // Determine the account manager action to be performed
        String action = request.getParameter("action");
        if (action == null) {
            action = "init";
        }

        // Is there a currently logged on user?
        SessionTool st = new SessionTool(request);
        if ( st.checkSession() == false ) {
           return mapping.findForward("/userportal/logon");
        }   



        MessageResources mr = getResources(request);

        // Get the form buttons as specified in the properties file.
        String searchStr = getMessage(mr,request,"global.action.label.search");
        String viewallStr = getMessage(mr,request,"admin.button.viewall");

        // Process the action
        try {

            if (action.equals("init")) {
                WorkflowMgrLogic.initLocate(request, form);
                return (mapping.findForward("success"));
            }
            else if (action.equals(searchStr)) {
                WorkflowMgrLogic.locateByBusEntity(request, form);
                return (mapping.findForward("success"));
            }
            else if (action.equals(viewallStr)) {
                WorkflowMgrLogic.locateListAll(request, form);
                return (mapping.findForward("success"));
            }
            else if (action.equals("sort")) {
                WorkflowMgrLogic.sortWorkflows(request, form);
                return (mapping.findForward("success"));
            }
            else {
                WorkflowMgrLogic.init(request, form);
                return (mapping.findForward("success"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return (mapping.findForward("success"));
        }
    }

}

