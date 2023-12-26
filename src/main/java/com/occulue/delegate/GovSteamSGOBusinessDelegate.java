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
 * GovSteamSGO business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of GovSteamSGO related services in the case of a GovSteamSGO business related service failing.</li>
 * <li>Exposes a simpler, uniform GovSteamSGO interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill GovSteamSGO business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class GovSteamSGOBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public GovSteamSGOBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* GovSteamSGO Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	GovSteamSGOBusinessDelegate
	*/
	public static GovSteamSGOBusinessDelegate getGovSteamSGOInstance() {
		return( new GovSteamSGOBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createGovSteamSGO( CreateGovSteamSGOCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getGovSteamSGOId() == null )
				command.setGovSteamSGOId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GovSteamSGOValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateGovSteamSGOCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateGovSteamSGOCommand of GovSteamSGO is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create GovSteamSGO - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateGovSteamSGOCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateGovSteamSGO( UpdateGovSteamSGOCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	GovSteamSGOValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateGovSteamSGOCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save GovSteamSGO - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteGovSteamSGOCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteGovSteamSGOCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GovSteamSGOValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteGovSteamSGOCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete GovSteamSGO using Id = "  + command.getGovSteamSGOId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the GovSteamSGO via GovSteamSGOFetchOneSummary
     * @param 	summary GovSteamSGOFetchOneSummary 
     * @return 	GovSteamSGOFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public GovSteamSGO getGovSteamSGO( GovSteamSGOFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "GovSteamSGOFetchOneSummary arg cannot be null" );
    	
    	GovSteamSGO entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	GovSteamSGOValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a GovSteamSGO
        	// --------------------------------------
        	CompletableFuture<GovSteamSGO> futureEntity = queryGateway.query(new FindGovSteamSGOQuery( new LoadGovSteamSGOFilter( summary.getGovSteamSGOId() ) ), ResponseTypes.instanceOf(GovSteamSGO.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate GovSteamSGO with id " + summary.getGovSteamSGOId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all GovSteamSGOs
     *
     * @return 	List<GovSteamSGO> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<GovSteamSGO> getAllGovSteamSGO() 
    throws ProcessingException {
        List<GovSteamSGO> list = null;

        try {
        	CompletableFuture<List<GovSteamSGO>> futureList = queryGateway.query(new FindAllGovSteamSGOQuery(), ResponseTypes.multipleInstancesOf(GovSteamSGO.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all GovSteamSGO";
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
	 * @return		GovSteamSGO
	 */
	protected GovSteamSGO load( UUID id ) throws ProcessingException {
		govSteamSGO = GovSteamSGOBusinessDelegate.getGovSteamSGOInstance().getGovSteamSGO( new GovSteamSGOFetchOneSummary(id) );	
		return govSteamSGO;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private GovSteamSGO govSteamSGO 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(GovSteamSGOBusinessDelegate.class.getName());
    
}
