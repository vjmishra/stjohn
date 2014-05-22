/*
 * FaxException.java
 *
 * Created on February 20, 2009, 4:29 PM
 */

package com.cleanwise.service.apps.dataexchange;

/**
 * Wrapper for any FAX exception generated by either the API that talks to the FAX server, or 
 * any internal exceptions that are generated during sending or construction of a FAX document.
 * @author  scher
 */
public class FaxExceptionMyFax extends java.lang.Exception {

    /**
     * Creates a new instance of <code>FaxException</code> without detail message.
     */
    public FaxExceptionMyFax() {
    }


    /**
     * Constructs an instance of <code>FaxException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public FaxExceptionMyFax(String msg) {
        super(msg);
    }
}


