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
 * SeasonDayTypeSchedule business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of SeasonDayTypeSchedule related services in the case of a SeasonDayTypeSchedule business related service failing.</li>
 * <li>Exposes a simpler, uniform SeasonDayTypeSchedule interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill SeasonDayTypeSchedule business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class SeasonDayTypeScheduleBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public SeasonDayTypeScheduleBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* SeasonDayTypeSchedule Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	SeasonDayTypeScheduleBusinessDelegate
	*/
	public static SeasonDayTypeScheduleBusinessDelegate getSeasonDayTypeScheduleInstance() {
		return( new SeasonDayTypeScheduleBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createSeasonDayTypeSchedule( CreateSeasonDayTypeScheduleCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getSeasonDayTypeScheduleId() == null )
				command.setSeasonDayTypeScheduleId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	SeasonDayTypeScheduleValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateSeasonDayTypeScheduleCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateSeasonDayTypeScheduleCommand of SeasonDayTypeSchedule is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create SeasonDayTypeSchedule - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateSeasonDayTypeScheduleCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateSeasonDayTypeSchedule( UpdateSeasonDayTypeScheduleCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	SeasonDayTypeScheduleValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateSeasonDayTypeScheduleCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save SeasonDayTypeSchedule - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteSeasonDayTypeScheduleCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteSeasonDayTypeScheduleCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	SeasonDayTypeScheduleValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteSeasonDayTypeScheduleCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete SeasonDayTypeSchedule using Id = "  + command.getSeasonDayTypeScheduleId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the SeasonDayTypeSchedule via SeasonDayTypeScheduleFetchOneSummary
     * @param 	summary SeasonDayTypeScheduleFetchOneSummary 
     * @return 	SeasonDayTypeScheduleFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public SeasonDayTypeSchedule getSeasonDayTypeSchedule( SeasonDayTypeScheduleFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "SeasonDayTypeScheduleFetchOneSummary arg cannot be null" );
    	
    	SeasonDayTypeSchedule entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	SeasonDayTypeScheduleValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a SeasonDayTypeSchedule
        	// --------------------------------------
        	CompletableFuture<SeasonDayTypeSchedule> futureEntity = queryGateway.query(new FindSeasonDayTypeScheduleQuery( new LoadSeasonDayTypeScheduleFilter( summary.getSeasonDayTypeScheduleId() ) ), ResponseTypes.instanceOf(SeasonDayTypeSchedule.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate SeasonDayTypeSchedule with id " + summary.getSeasonDayTypeScheduleId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all SeasonDayTypeSchedules
     *
     * @return 	List<SeasonDayTypeSchedule> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<SeasonDayTypeSchedule> getAllSeasonDayTypeSchedule() 
    throws ProcessingException {
        List<SeasonDayTypeSchedule> list = null;

        try {
        	CompletableFuture<List<SeasonDayTypeSchedule>> futureList = queryGateway.query(new FindAllSeasonDayTypeScheduleQuery(), ResponseTypes.multipleInstancesOf(SeasonDayTypeSchedule.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all SeasonDayTypeSchedule";
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
	 * @return		SeasonDayTypeSchedule
	 */
	protected SeasonDayTypeSchedule load( UUID id ) throws ProcessingException {
		seasonDayTypeSchedule = SeasonDayTypeScheduleBusinessDelegate.getSeasonDayTypeScheduleInstance().getSeasonDayTypeSchedule( new SeasonDayTypeScheduleFetchOneSummary(id) );	
		return seasonDayTypeSchedule;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private SeasonDayTypeSchedule seasonDayTypeSchedule 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(SeasonDayTypeScheduleBusinessDelegate.class.getName());
    
}
