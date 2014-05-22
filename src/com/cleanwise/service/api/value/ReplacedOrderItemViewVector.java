
/* DO NOT EDIT - Generated code from XSL file ValueObjectVector.xsl */

package com.cleanwise.service.api.value;
import java.util.Comparator;
import java.util.Collections;


/**
 * Title:        ReplacedOrderItemViewVector
 * Description:  Container object for ReplacedOrderItemView objects
 * Purpose:      Provides container storage for ReplacedOrderItemView objects.
 * Copyright:    Copyright (c) 2001
 * Company:      CleanWise, Inc.
 * @author       Generated Code from XSL file ValueObjectVector.xsl
 */

/**
 * <code>ReplacedOrderItemViewVector</code>
 */
public class ReplacedOrderItemViewVector extends java.util.ArrayList implements Comparator
{
    private static final long serialVersionUID = 3897685864141375786L;
    /**
     * Constructor.
     */
    public ReplacedOrderItemViewVector () {}

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
      ReplacedOrderItemView obj1 = (ReplacedOrderItemView)o1;
      ReplacedOrderItemView obj2 = (ReplacedOrderItemView)o2;
      
      if(!_ascFl) retcode = -retcode;
      return retcode;
    }
}
