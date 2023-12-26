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
 * GovHydroR business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of GovHydroR related services in the case of a GovHydroR business related service failing.</li>
 * <li>Exposes a simpler, uniform GovHydroR interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill GovHydroR business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class GovHydroRBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public GovHydroRBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* GovHydroR Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	GovHydroRBusinessDelegate
	*/
	public static GovHydroRBusinessDelegate getGovHydroRInstance() {
		return( new GovHydroRBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createGovHydroR( CreateGovHydroRCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getGovHydroRId() == null )
				command.setGovHydroRId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GovHydroRValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateGovHydroRCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateGovHydroRCommand of GovHydroR is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create GovHydroR - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateGovHydroRCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateGovHydroR( UpdateGovHydroRCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	GovHydroRValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateGovHydroRCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save GovHydroR - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteGovHydroRCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteGovHydroRCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GovHydroRValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteGovHydroRCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete GovHydroR using Id = "  + command.getGovHydroRId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the GovHydroR via GovHydroRFetchOneSummary
     * @param 	summary GovHydroRFetchOneSummary 
     * @return 	GovHydroRFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public GovHydroR getGovHydroR( GovHydroRFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "GovHydroRFetchOneSummary arg cannot be null" );
    	
    	GovHydroR entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	GovHydroRValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a GovHydroR
        	// --------------------------------------
        	CompletableFuture<GovHydroR> futureEntity = queryGateway.query(new FindGovHydroRQuery( new LoadGovHydroRFilter( summary.getGovHydroRId() ) ), ResponseTypes.instanceOf(GovHydroR.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate GovHydroR with id " + summary.getGovHydroRId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all GovHydroRs
     *
     * @return 	List<GovHydroR> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<GovHydroR> getAllGovHydroR() 
    throws ProcessingException {
        List<GovHydroR> list = null;

        try {
        	CompletableFuture<List<GovHydroR>> futureList = queryGateway.query(new FindAllGovHydroRQuery(), ResponseTypes.multipleInstancesOf(GovHydroR.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all GovHydroR";
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
	 * @return		GovHydroR
	 */
	protected GovHydroR load( UUID id ) throws ProcessingException {
		govHydroR = GovHydroRBusinessDelegate.getGovHydroRInstance().getGovHydroR( new GovHydroRFetchOneSummary(id) );	
		return govHydroR;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private GovHydroR govHydroR 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(GovHydroRBusinessDelegate.class.getName());
    
}
