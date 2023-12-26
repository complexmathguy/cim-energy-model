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
 * GovSteamFV4 business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of GovSteamFV4 related services in the case of a GovSteamFV4 business related service failing.</li>
 * <li>Exposes a simpler, uniform GovSteamFV4 interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill GovSteamFV4 business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class GovSteamFV4BusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public GovSteamFV4BusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* GovSteamFV4 Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	GovSteamFV4BusinessDelegate
	*/
	public static GovSteamFV4BusinessDelegate getGovSteamFV4Instance() {
		return( new GovSteamFV4BusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createGovSteamFV4( CreateGovSteamFV4Command command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getGovSteamFV4Id() == null )
				command.setGovSteamFV4Id( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GovSteamFV4Validator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateGovSteamFV4Command - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateGovSteamFV4Command of GovSteamFV4 is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create GovSteamFV4 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateGovSteamFV4Command
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateGovSteamFV4( UpdateGovSteamFV4Command command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	GovSteamFV4Validator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateGovSteamFV4Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save GovSteamFV4 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteGovSteamFV4Command
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteGovSteamFV4Command command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GovSteamFV4Validator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteGovSteamFV4Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete GovSteamFV4 using Id = "  + command.getGovSteamFV4Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the GovSteamFV4 via GovSteamFV4FetchOneSummary
     * @param 	summary GovSteamFV4FetchOneSummary 
     * @return 	GovSteamFV4FetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public GovSteamFV4 getGovSteamFV4( GovSteamFV4FetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "GovSteamFV4FetchOneSummary arg cannot be null" );
    	
    	GovSteamFV4 entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	GovSteamFV4Validator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a GovSteamFV4
        	// --------------------------------------
        	CompletableFuture<GovSteamFV4> futureEntity = queryGateway.query(new FindGovSteamFV4Query( new LoadGovSteamFV4Filter( summary.getGovSteamFV4Id() ) ), ResponseTypes.instanceOf(GovSteamFV4.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate GovSteamFV4 with id " + summary.getGovSteamFV4Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all GovSteamFV4s
     *
     * @return 	List<GovSteamFV4> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<GovSteamFV4> getAllGovSteamFV4() 
    throws ProcessingException {
        List<GovSteamFV4> list = null;

        try {
        	CompletableFuture<List<GovSteamFV4>> futureList = queryGateway.query(new FindAllGovSteamFV4Query(), ResponseTypes.multipleInstancesOf(GovSteamFV4.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all GovSteamFV4";
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
	 * @return		GovSteamFV4
	 */
	protected GovSteamFV4 load( UUID id ) throws ProcessingException {
		govSteamFV4 = GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().getGovSteamFV4( new GovSteamFV4FetchOneSummary(id) );	
		return govSteamFV4;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private GovSteamFV4 govSteamFV4 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(GovSteamFV4BusinessDelegate.class.getName());
    
}
