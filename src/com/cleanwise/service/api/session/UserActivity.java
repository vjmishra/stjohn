package com.cleanwise.service.api.session;

/**
 * Title:        UserActivity
 * Description:  Remote Interface for UserActivity Stateless Session Bean
 * Purpose:      Provides access to user activity tracking methods.
 * Copyright:    Copyright (c) 2001
 * Company:      CleanWise, Inc.
 * @author       Liang Li, CleanWise, Inc.
 *
 */

import javax.ejb.*;
import java.rmi.*;
import java.util.Date;
import java.util.List;
import com.cleanwise.service.api.value.*;

public interface UserActivity extends javax.ejb.EJBObject
{

  /**
   * Adds the user activity information values to be used by the request.
   * @param pAddUpadteData  the user activity data.
   * @param request  the user activity request data
   * @return new UserActivityRequestData()
   * @throws            RemoteException Required by EJB 1.0
   */
  public UserActivityData addUserActivity(UserActivityData pAddUpdateData, 
            UserActivityRequestData request)
      throws RemoteException;


}
