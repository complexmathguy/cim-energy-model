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
 * ApparentPowerLimit business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of ApparentPowerLimit related services in the case of a ApparentPowerLimit business related service failing.</li>
 * <li>Exposes a simpler, uniform ApparentPowerLimit interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill ApparentPowerLimit business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class ApparentPowerLimitBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public ApparentPowerLimitBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* ApparentPowerLimit Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	ApparentPowerLimitBusinessDelegate
	*/
	public static ApparentPowerLimitBusinessDelegate getApparentPowerLimitInstance() {
		return( new ApparentPowerLimitBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createApparentPowerLimit( CreateApparentPowerLimitCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getApparentPowerLimitId() == null )
				command.setApparentPowerLimitId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ApparentPowerLimitValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateApparentPowerLimitCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateApparentPowerLimitCommand of ApparentPowerLimit is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create ApparentPowerLimit - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateApparentPowerLimitCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateApparentPowerLimit( UpdateApparentPowerLimitCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	ApparentPowerLimitValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateApparentPowerLimitCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save ApparentPowerLimit - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteApparentPowerLimitCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteApparentPowerLimitCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ApparentPowerLimitValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteApparentPowerLimitCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete ApparentPowerLimit using Id = "  + command.getApparentPowerLimitId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the ApparentPowerLimit via ApparentPowerLimitFetchOneSummary
     * @param 	summary ApparentPowerLimitFetchOneSummary 
     * @return 	ApparentPowerLimitFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public ApparentPowerLimit getApparentPowerLimit( ApparentPowerLimitFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "ApparentPowerLimitFetchOneSummary arg cannot be null" );
    	
    	ApparentPowerLimit entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	ApparentPowerLimitValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a ApparentPowerLimit
        	// --------------------------------------
        	CompletableFuture<ApparentPowerLimit> futureEntity = queryGateway.query(new FindApparentPowerLimitQuery( new LoadApparentPowerLimitFilter( summary.getApparentPowerLimitId() ) ), ResponseTypes.instanceOf(ApparentPowerLimit.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate ApparentPowerLimit with id " + summary.getApparentPowerLimitId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all ApparentPowerLimits
     *
     * @return 	List<ApparentPowerLimit> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<ApparentPowerLimit> getAllApparentPowerLimit() 
    throws ProcessingException {
        List<ApparentPowerLimit> list = null;

        try {
        	CompletableFuture<List<ApparentPowerLimit>> futureList = queryGateway.query(new FindAllApparentPowerLimitQuery(), ResponseTypes.multipleInstancesOf(ApparentPowerLimit.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all ApparentPowerLimit";
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
	 * @return		ApparentPowerLimit
	 */
	protected ApparentPowerLimit load( UUID id ) throws ProcessingException {
		apparentPowerLimit = ApparentPowerLimitBusinessDelegate.getApparentPowerLimitInstance().getApparentPowerLimit( new ApparentPowerLimitFetchOneSummary(id) );	
		return apparentPowerLimit;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private ApparentPowerLimit apparentPowerLimit 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(ApparentPowerLimitBusinessDelegate.class.getName());
    
}
