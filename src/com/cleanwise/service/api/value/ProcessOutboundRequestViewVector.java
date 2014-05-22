
/* DO NOT EDIT - Generated code from XSL file ValueObjectVector.xsl */

package com.cleanwise.service.api.value;
import java.util.Comparator;
import java.util.Collections;


/**
 * Title:        ProcessOutboundRequestViewVector
 * Description:  Container object for ProcessOutboundRequestView objects
 * Purpose:      Provides container storage for ProcessOutboundRequestView objects.
 * Copyright:    Copyright (c) 2001
 * Company:      CleanWise, Inc.
 * @author       Generated Code from XSL file ValueObjectVector.xsl
 */

/**
 * <code>ProcessOutboundRequestViewVector</code>
 */
public class ProcessOutboundRequestViewVector extends java.util.ArrayList implements Comparator
{
    private static final long serialVersionUID = -8916929773330118087L;
    /**
     * Constructor.
     */
    public ProcessOutboundRequestViewVector () {}

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
      ProcessOutboundRequestView obj1 = (ProcessOutboundRequestView)o1;
      ProcessOutboundRequestView obj2 = (ProcessOutboundRequestView)o2;
      
      if("Key".equalsIgnoreCase(_sortField)) {
        String i1 = obj1.getKey();
        String i2 = obj2.getKey();
        if(i1==null) if(i2==null) retcode = 0; else  retcode = -1;
        else if(i2==null) retcode = 1; else retcode = i1.compareTo(i2);
      }
      
      if(!_ascFl) retcode = -retcode;
      return retcode;
    }
}
