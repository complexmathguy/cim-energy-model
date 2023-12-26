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
 * ConformLoadSchedule business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of ConformLoadSchedule related services in the case of a ConformLoadSchedule business related service failing.</li>
 * <li>Exposes a simpler, uniform ConformLoadSchedule interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill ConformLoadSchedule business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class ConformLoadScheduleBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public ConformLoadScheduleBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* ConformLoadSchedule Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	ConformLoadScheduleBusinessDelegate
	*/
	public static ConformLoadScheduleBusinessDelegate getConformLoadScheduleInstance() {
		return( new ConformLoadScheduleBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createConformLoadSchedule( CreateConformLoadScheduleCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getConformLoadScheduleId() == null )
				command.setConformLoadScheduleId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ConformLoadScheduleValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateConformLoadScheduleCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateConformLoadScheduleCommand of ConformLoadSchedule is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create ConformLoadSchedule - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateConformLoadScheduleCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateConformLoadSchedule( UpdateConformLoadScheduleCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	ConformLoadScheduleValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateConformLoadScheduleCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save ConformLoadSchedule - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteConformLoadScheduleCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteConformLoadScheduleCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ConformLoadScheduleValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteConformLoadScheduleCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete ConformLoadSchedule using Id = "  + command.getConformLoadScheduleId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the ConformLoadSchedule via ConformLoadScheduleFetchOneSummary
     * @param 	summary ConformLoadScheduleFetchOneSummary 
     * @return 	ConformLoadScheduleFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public ConformLoadSchedule getConformLoadSchedule( ConformLoadScheduleFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "ConformLoadScheduleFetchOneSummary arg cannot be null" );
    	
    	ConformLoadSchedule entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	ConformLoadScheduleValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a ConformLoadSchedule
        	// --------------------------------------
        	CompletableFuture<ConformLoadSchedule> futureEntity = queryGateway.query(new FindConformLoadScheduleQuery( new LoadConformLoadScheduleFilter( summary.getConformLoadScheduleId() ) ), ResponseTypes.instanceOf(ConformLoadSchedule.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate ConformLoadSchedule with id " + summary.getConformLoadScheduleId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all ConformLoadSchedules
     *
     * @return 	List<ConformLoadSchedule> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<ConformLoadSchedule> getAllConformLoadSchedule() 
    throws ProcessingException {
        List<ConformLoadSchedule> list = null;

        try {
        	CompletableFuture<List<ConformLoadSchedule>> futureList = queryGateway.query(new FindAllConformLoadScheduleQuery(), ResponseTypes.multipleInstancesOf(ConformLoadSchedule.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all ConformLoadSchedule";
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
	 * @return		ConformLoadSchedule
	 */
	protected ConformLoadSchedule load( UUID id ) throws ProcessingException {
		conformLoadSchedule = ConformLoadScheduleBusinessDelegate.getConformLoadScheduleInstance().getConformLoadSchedule( new ConformLoadScheduleFetchOneSummary(id) );	
		return conformLoadSchedule;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private ConformLoadSchedule conformLoadSchedule 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(ConformLoadScheduleBusinessDelegate.class.getName());
    
}
