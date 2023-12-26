/*******************************************************************************
  Turnstone Biologics Confidential
  
  2018 Turnstone Biologics
  All Rights Reserved.
  
  This file is subject to the terms and conditions defined in
  file 'license.txt', which is part of this source code package.
   
  Contributors :
        Turnstone Biologics - General Release
 ******************************************************************************/

package com.occulue.exception;


//************************************
// Imports
//************************************

/**
 * Exception class for authorization related errors
 * <p>
 * @author    realMethods, Inc.
 * @see		  com.harbormaster.foundational.presentation.request.HTTPRequestHandler
 */
public class AuthorizationException extends Exception
{
//****************************************************
// Public Methods
//****************************************************
    /**
     * default constructor
     */
    public AuthorizationException()
    {
    }

    /**
     * constructor
     *
     * @param message   text of the exception
     */
    public AuthorizationException( String message )
    {
        super( message );
    }
    
    /**
     * Constructor with a Throwable for chained exception and a message.
     * @param message
     * @param exception
     */
    public AuthorizationException( String message, Throwable exception )
    {
        super( message, exception ); 
    }
    
}

/*
 * Change Log:
 * $Log: AuthorizationException.java,v $
 */




