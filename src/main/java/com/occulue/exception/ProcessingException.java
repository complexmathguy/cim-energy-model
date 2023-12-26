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

//***********************************
// Imports
//***********************************

/**
 * Used to indicate an error occured in generic processing.
 * <p>
 * @author your_name_here
 */
public class ProcessingException extends Exception
{

//************************************************************************    
// Public Methods
//************************************************************************

    /** 
     * Base constructor.
     */
    public ProcessingException()
    {
        super(); 
    }

    /** Constructor with message.
     * @param message text of the exception
     */
    public ProcessingException( String message )
    {
        super( message ); 
    }

    /**
     * Constructor with a Throwabe for chained exception and a message.
     * 
     * @param message
     * @param exception
     */
    public ProcessingException( String message, Throwable exception )
    {
        super( message ); 
    }

//************************************************************************    
// Private / Protected Methods
//************************************************************************

//************************************************************************    
// Attributes
//************************************************************************
}

