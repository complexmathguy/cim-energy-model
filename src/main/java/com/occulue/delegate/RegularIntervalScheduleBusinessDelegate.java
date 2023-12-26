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
 * RegularIntervalSchedule business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of RegularIntervalSchedule related services in the case of a RegularIntervalSchedule business related service failing.</li>
 * <li>Exposes a simpler, uniform RegularIntervalSchedule interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill RegularIntervalSchedule business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class RegularIntervalScheduleBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public RegularIntervalScheduleBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* RegularIntervalSchedule Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	RegularIntervalScheduleBusinessDelegate
	*/
	public static RegularIntervalScheduleBusinessDelegate getRegularIntervalScheduleInstance() {
		return( new RegularIntervalScheduleBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createRegularIntervalSchedule( CreateRegularIntervalScheduleCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getRegularIntervalScheduleId() == null )
				command.setRegularIntervalScheduleId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	RegularIntervalScheduleValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateRegularIntervalScheduleCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateRegularIntervalScheduleCommand of RegularIntervalSchedule is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create RegularIntervalSchedule - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateRegularIntervalScheduleCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateRegularIntervalSchedule( UpdateRegularIntervalScheduleCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	RegularIntervalScheduleValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateRegularIntervalScheduleCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save RegularIntervalSchedule - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteRegularIntervalScheduleCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteRegularIntervalScheduleCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	RegularIntervalScheduleValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteRegularIntervalScheduleCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete RegularIntervalSchedule using Id = "  + command.getRegularIntervalScheduleId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the RegularIntervalSchedule via RegularIntervalScheduleFetchOneSummary
     * @param 	summary RegularIntervalScheduleFetchOneSummary 
     * @return 	RegularIntervalScheduleFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public RegularIntervalSchedule getRegularIntervalSchedule( RegularIntervalScheduleFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "RegularIntervalScheduleFetchOneSummary arg cannot be null" );
    	
    	RegularIntervalSchedule entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	RegularIntervalScheduleValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a RegularIntervalSchedule
        	// --------------------------------------
        	CompletableFuture<RegularIntervalSchedule> futureEntity = queryGateway.query(new FindRegularIntervalScheduleQuery( new LoadRegularIntervalScheduleFilter( summary.getRegularIntervalScheduleId() ) ), ResponseTypes.instanceOf(RegularIntervalSchedule.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate RegularIntervalSchedule with id " + summary.getRegularIntervalScheduleId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all RegularIntervalSchedules
     *
     * @return 	List<RegularIntervalSchedule> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<RegularIntervalSchedule> getAllRegularIntervalSchedule() 
    throws ProcessingException {
        List<RegularIntervalSchedule> list = null;

        try {
        	CompletableFuture<List<RegularIntervalSchedule>> futureList = queryGateway.query(new FindAllRegularIntervalScheduleQuery(), ResponseTypes.multipleInstancesOf(RegularIntervalSchedule.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all RegularIntervalSchedule";
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
	 * @return		RegularIntervalSchedule
	 */
	protected RegularIntervalSchedule load( UUID id ) throws ProcessingException {
		regularIntervalSchedule = RegularIntervalScheduleBusinessDelegate.getRegularIntervalScheduleInstance().getRegularIntervalSchedule( new RegularIntervalScheduleFetchOneSummary(id) );	
		return regularIntervalSchedule;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private RegularIntervalSchedule regularIntervalSchedule 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(RegularIntervalScheduleBusinessDelegate.class.getName());
    
}
