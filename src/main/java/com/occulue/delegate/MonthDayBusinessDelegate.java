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
 * MonthDay business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of MonthDay related services in the case of a MonthDay business related service failing.</li>
 * <li>Exposes a simpler, uniform MonthDay interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill MonthDay business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class MonthDayBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public MonthDayBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* MonthDay Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	MonthDayBusinessDelegate
	*/
	public static MonthDayBusinessDelegate getMonthDayInstance() {
		return( new MonthDayBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createMonthDay( CreateMonthDayCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getMonthDayId() == null )
				command.setMonthDayId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	MonthDayValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateMonthDayCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateMonthDayCommand of MonthDay is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create MonthDay - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateMonthDayCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateMonthDay( UpdateMonthDayCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	MonthDayValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateMonthDayCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save MonthDay - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteMonthDayCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteMonthDayCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	MonthDayValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteMonthDayCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete MonthDay using Id = "  + command.getMonthDayId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the MonthDay via MonthDayFetchOneSummary
     * @param 	summary MonthDayFetchOneSummary 
     * @return 	MonthDayFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public MonthDay getMonthDay( MonthDayFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "MonthDayFetchOneSummary arg cannot be null" );
    	
    	MonthDay entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	MonthDayValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a MonthDay
        	// --------------------------------------
        	CompletableFuture<MonthDay> futureEntity = queryGateway.query(new FindMonthDayQuery( new LoadMonthDayFilter( summary.getMonthDayId() ) ), ResponseTypes.instanceOf(MonthDay.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate MonthDay with id " + summary.getMonthDayId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all MonthDays
     *
     * @return 	List<MonthDay> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<MonthDay> getAllMonthDay() 
    throws ProcessingException {
        List<MonthDay> list = null;

        try {
        	CompletableFuture<List<MonthDay>> futureList = queryGateway.query(new FindAllMonthDayQuery(), ResponseTypes.multipleInstancesOf(MonthDay.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all MonthDay";
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
	 * @return		MonthDay
	 */
	protected MonthDay load( UUID id ) throws ProcessingException {
		monthDay = MonthDayBusinessDelegate.getMonthDayInstance().getMonthDay( new MonthDayFetchOneSummary(id) );	
		return monthDay;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private MonthDay monthDay 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(MonthDayBusinessDelegate.class.getName());
    
}
