
/* DO NOT EDIT - Generated code from XSL file ValueObjectVector.xsl */

package com.cleanwise.service.api.value;
import java.util.Comparator;
import java.util.Collections;


/**
 * Title:        WorkOrderSiteNameViewVector
 * Description:  Container object for WorkOrderSiteNameView objects
 * Purpose:      Provides container storage for WorkOrderSiteNameView objects.
 * Copyright:    Copyright (c) 2001
 * Company:      CleanWise, Inc.
 * @author       Generated Code from XSL file ValueObjectVector.xsl
 */

/**
 * <code>WorkOrderSiteNameViewVector</code>
 */
public class WorkOrderSiteNameViewVector extends java.util.ArrayList implements Comparator
{
    private static final long serialVersionUID = -1L;
    /**
     * Constructor.
     */
    public WorkOrderSiteNameViewVector () {}

    String _sortField = "";
    boolean _ascFl = true;
    /**
     * Sort
     */
    public void sort(String pFieldName) {
       sort(pFieldName,true);     
    }

    public void sort(String pFieldName, boolean pAscFl) {
       _sortField = pFieldName;
       _ascFl = pAscFl;       
       Collections.sort(this,this);
    }

    /*
    *
    */
    public int compare(Object o1, Object o2)
    {
      int retcode = -1;
      WorkOrderSiteNameView obj1 = (WorkOrderSiteNameView)o1;
      WorkOrderSiteNameView obj2 = (WorkOrderSiteNameView)o2;
      
      if(!_ascFl) retcode = -retcode;
      return retcode;
    }
}
