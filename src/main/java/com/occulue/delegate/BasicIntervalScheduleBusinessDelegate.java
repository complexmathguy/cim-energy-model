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
 * BasicIntervalSchedule business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of BasicIntervalSchedule related services in the case of a BasicIntervalSchedule business related service failing.</li>
 * <li>Exposes a simpler, uniform BasicIntervalSchedule interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill BasicIntervalSchedule business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class BasicIntervalScheduleBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public BasicIntervalScheduleBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* BasicIntervalSchedule Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	BasicIntervalScheduleBusinessDelegate
	*/
	public static BasicIntervalScheduleBusinessDelegate getBasicIntervalScheduleInstance() {
		return( new BasicIntervalScheduleBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createBasicIntervalSchedule( CreateBasicIntervalScheduleCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getBasicIntervalScheduleId() == null )
				command.setBasicIntervalScheduleId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	BasicIntervalScheduleValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateBasicIntervalScheduleCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateBasicIntervalScheduleCommand of BasicIntervalSchedule is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create BasicIntervalSchedule - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateBasicIntervalScheduleCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateBasicIntervalSchedule( UpdateBasicIntervalScheduleCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	BasicIntervalScheduleValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateBasicIntervalScheduleCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save BasicIntervalSchedule - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteBasicIntervalScheduleCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteBasicIntervalScheduleCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	BasicIntervalScheduleValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteBasicIntervalScheduleCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete BasicIntervalSchedule using Id = "  + command.getBasicIntervalScheduleId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the BasicIntervalSchedule via BasicIntervalScheduleFetchOneSummary
     * @param 	summary BasicIntervalScheduleFetchOneSummary 
     * @return 	BasicIntervalScheduleFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public BasicIntervalSchedule getBasicIntervalSchedule( BasicIntervalScheduleFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "BasicIntervalScheduleFetchOneSummary arg cannot be null" );
    	
    	BasicIntervalSchedule entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	BasicIntervalScheduleValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a BasicIntervalSchedule
        	// --------------------------------------
        	CompletableFuture<BasicIntervalSchedule> futureEntity = queryGateway.query(new FindBasicIntervalScheduleQuery( new LoadBasicIntervalScheduleFilter( summary.getBasicIntervalScheduleId() ) ), ResponseTypes.instanceOf(BasicIntervalSchedule.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate BasicIntervalSchedule with id " + summary.getBasicIntervalScheduleId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all BasicIntervalSchedules
     *
     * @return 	List<BasicIntervalSchedule> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<BasicIntervalSchedule> getAllBasicIntervalSchedule() 
    throws ProcessingException {
        List<BasicIntervalSchedule> list = null;

        try {
        	CompletableFuture<List<BasicIntervalSchedule>> futureList = queryGateway.query(new FindAllBasicIntervalScheduleQuery(), ResponseTypes.multipleInstancesOf(BasicIntervalSchedule.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all BasicIntervalSchedule";
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
	 * @return		BasicIntervalSchedule
	 */
	protected BasicIntervalSchedule load( UUID id ) throws ProcessingException {
		basicIntervalSchedule = BasicIntervalScheduleBusinessDelegate.getBasicIntervalScheduleInstance().getBasicIntervalSchedule( new BasicIntervalScheduleFetchOneSummary(id) );	
		return basicIntervalSchedule;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private BasicIntervalSchedule basicIntervalSchedule 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(BasicIntervalScheduleBusinessDelegate.class.getName());
    
}
