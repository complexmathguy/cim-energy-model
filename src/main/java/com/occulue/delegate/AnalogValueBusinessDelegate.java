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
 * AnalogValue business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of AnalogValue related services in the case of a AnalogValue business related service failing.</li>
 * <li>Exposes a simpler, uniform AnalogValue interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill AnalogValue business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class AnalogValueBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public AnalogValueBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* AnalogValue Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	AnalogValueBusinessDelegate
	*/
	public static AnalogValueBusinessDelegate getAnalogValueInstance() {
		return( new AnalogValueBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createAnalogValue( CreateAnalogValueCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getAnalogValueId() == null )
				command.setAnalogValueId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	AnalogValueValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateAnalogValueCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateAnalogValueCommand of AnalogValue is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create AnalogValue - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateAnalogValueCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateAnalogValue( UpdateAnalogValueCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	AnalogValueValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateAnalogValueCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save AnalogValue - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteAnalogValueCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteAnalogValueCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	AnalogValueValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteAnalogValueCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete AnalogValue using Id = "  + command.getAnalogValueId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the AnalogValue via AnalogValueFetchOneSummary
     * @param 	summary AnalogValueFetchOneSummary 
     * @return 	AnalogValueFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public AnalogValue getAnalogValue( AnalogValueFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "AnalogValueFetchOneSummary arg cannot be null" );
    	
    	AnalogValue entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	AnalogValueValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a AnalogValue
        	// --------------------------------------
        	CompletableFuture<AnalogValue> futureEntity = queryGateway.query(new FindAnalogValueQuery( new LoadAnalogValueFilter( summary.getAnalogValueId() ) ), ResponseTypes.instanceOf(AnalogValue.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate AnalogValue with id " + summary.getAnalogValueId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all AnalogValues
     *
     * @return 	List<AnalogValue> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<AnalogValue> getAllAnalogValue() 
    throws ProcessingException {
        List<AnalogValue> list = null;

        try {
        	CompletableFuture<List<AnalogValue>> futureList = queryGateway.query(new FindAllAnalogValueQuery(), ResponseTypes.multipleInstancesOf(AnalogValue.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all AnalogValue";
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
	 * @return		AnalogValue
	 */
	protected AnalogValue load( UUID id ) throws ProcessingException {
		analogValue = AnalogValueBusinessDelegate.getAnalogValueInstance().getAnalogValue( new AnalogValueFetchOneSummary(id) );	
		return analogValue;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private AnalogValue analogValue 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(AnalogValueBusinessDelegate.class.getName());
    
}
