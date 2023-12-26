/*******************************************************************************
  Turnstone Biologics Confidential
  
  2018 Turnstone Biologics
  All Rights Reserved.
  
  This file is subject to the terms and conditions defined in
  file 'license.txt', which is part of this source code package.
   
  Contributors :
        Turnstone Biologics - General Release
 ******************************************************************************/
package com.occulue.delegate;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import java.util.concurrent.*;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.validator.*;

/**
 * StringMeasurementValue business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of StringMeasurementValue related services in the case of a StringMeasurementValue business related service failing.</li>
 * <li>Exposes a simpler, uniform StringMeasurementValue interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill StringMeasurementValue business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class StringMeasurementValueBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public StringMeasurementValueBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* StringMeasurementValue Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	StringMeasurementValueBusinessDelegate
	*/
	public static StringMeasurementValueBusinessDelegate getStringMeasurementValueInstance() {
		return( new StringMeasurementValueBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createStringMeasurementValue( CreateStringMeasurementValueCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getStringMeasurementValueId() == null )
				command.setStringMeasurementValueId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	StringMeasurementValueValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateStringMeasurementValueCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateStringMeasurementValueCommand of StringMeasurementValue is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create StringMeasurementValue - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateStringMeasurementValueCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateStringMeasurementValue( UpdateStringMeasurementValueCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	StringMeasurementValueValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateStringMeasurementValueCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save StringMeasurementValue - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteStringMeasurementValueCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteStringMeasurementValueCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	StringMeasurementValueValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteStringMeasurementValueCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete StringMeasurementValue using Id = "  + command.getStringMeasurementValueId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the StringMeasurementValue via StringMeasurementValueFetchOneSummary
     * @param 	summary StringMeasurementValueFetchOneSummary 
     * @return 	StringMeasurementValueFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public StringMeasurementValue getStringMeasurementValue( StringMeasurementValueFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "StringMeasurementValueFetchOneSummary arg cannot be null" );
    	
    	StringMeasurementValue entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	StringMeasurementValueValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a StringMeasurementValue
        	// --------------------------------------
        	CompletableFuture<StringMeasurementValue> futureEntity = queryGateway.query(new FindStringMeasurementValueQuery( new LoadStringMeasurementValueFilter( summary.getStringMeasurementValueId() ) ), ResponseTypes.instanceOf(StringMeasurementValue.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate StringMeasurementValue with id " + summary.getStringMeasurementValueId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all StringMeasurementValues
     *
     * @return 	List<StringMeasurementValue> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<StringMeasurementValue> getAllStringMeasurementValue() 
    throws ProcessingException {
        List<StringMeasurementValue> list = null;

        try {
        	CompletableFuture<List<StringMeasurementValue>> futureList = queryGateway.query(new FindAllStringMeasurementValueQuery(), ResponseTypes.multipleInstancesOf(StringMeasurementValue.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all StringMeasurementValue";
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return list;
    }




	/**
	 * Internal helper method to load the root 
	 * 
	 * @param		id	UUID
	 * @return		StringMeasurementValue
	 */
	protected StringMeasurementValue load( UUID id ) throws ProcessingException {
		stringMeasurementValue = StringMeasurementValueBusinessDelegate.getStringMeasurementValueInstance().getStringMeasurementValue( new StringMeasurementValueFetchOneSummary(id) );	
		return stringMeasurementValue;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private StringMeasurementValue stringMeasurementValue 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(StringMeasurementValueBusinessDelegate.class.getName());
    
}
