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
 * OverexcLimIEEE business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of OverexcLimIEEE related services in the case of a OverexcLimIEEE business related service failing.</li>
 * <li>Exposes a simpler, uniform OverexcLimIEEE interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill OverexcLimIEEE business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class OverexcLimIEEEBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public OverexcLimIEEEBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* OverexcLimIEEE Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	OverexcLimIEEEBusinessDelegate
	*/
	public static OverexcLimIEEEBusinessDelegate getOverexcLimIEEEInstance() {
		return( new OverexcLimIEEEBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createOverexcLimIEEE( CreateOverexcLimIEEECommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getOverexcLimIEEEId() == null )
				command.setOverexcLimIEEEId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	OverexcLimIEEEValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateOverexcLimIEEECommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateOverexcLimIEEECommand of OverexcLimIEEE is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create OverexcLimIEEE - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateOverexcLimIEEECommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateOverexcLimIEEE( UpdateOverexcLimIEEECommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	OverexcLimIEEEValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateOverexcLimIEEECommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save OverexcLimIEEE - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteOverexcLimIEEECommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteOverexcLimIEEECommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	OverexcLimIEEEValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteOverexcLimIEEECommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete OverexcLimIEEE using Id = "  + command.getOverexcLimIEEEId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the OverexcLimIEEE via OverexcLimIEEEFetchOneSummary
     * @param 	summary OverexcLimIEEEFetchOneSummary 
     * @return 	OverexcLimIEEEFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public OverexcLimIEEE getOverexcLimIEEE( OverexcLimIEEEFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "OverexcLimIEEEFetchOneSummary arg cannot be null" );
    	
    	OverexcLimIEEE entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	OverexcLimIEEEValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a OverexcLimIEEE
        	// --------------------------------------
        	CompletableFuture<OverexcLimIEEE> futureEntity = queryGateway.query(new FindOverexcLimIEEEQuery( new LoadOverexcLimIEEEFilter( summary.getOverexcLimIEEEId() ) ), ResponseTypes.instanceOf(OverexcLimIEEE.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate OverexcLimIEEE with id " + summary.getOverexcLimIEEEId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all OverexcLimIEEEs
     *
     * @return 	List<OverexcLimIEEE> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<OverexcLimIEEE> getAllOverexcLimIEEE() 
    throws ProcessingException {
        List<OverexcLimIEEE> list = null;

        try {
        	CompletableFuture<List<OverexcLimIEEE>> futureList = queryGateway.query(new FindAllOverexcLimIEEEQuery(), ResponseTypes.multipleInstancesOf(OverexcLimIEEE.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all OverexcLimIEEE";
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
	 * @return		OverexcLimIEEE
	 */
	protected OverexcLimIEEE load( UUID id ) throws ProcessingException {
		overexcLimIEEE = OverexcLimIEEEBusinessDelegate.getOverexcLimIEEEInstance().getOverexcLimIEEE( new OverexcLimIEEEFetchOneSummary(id) );	
		return overexcLimIEEE;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private OverexcLimIEEE overexcLimIEEE 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(OverexcLimIEEEBusinessDelegate.class.getName());
    
}
