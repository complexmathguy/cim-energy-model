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
 * GovSteamCC business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of GovSteamCC related services in the case of a GovSteamCC business related service failing.</li>
 * <li>Exposes a simpler, uniform GovSteamCC interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill GovSteamCC business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class GovSteamCCBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public GovSteamCCBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* GovSteamCC Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	GovSteamCCBusinessDelegate
	*/
	public static GovSteamCCBusinessDelegate getGovSteamCCInstance() {
		return( new GovSteamCCBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createGovSteamCC( CreateGovSteamCCCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getGovSteamCCId() == null )
				command.setGovSteamCCId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GovSteamCCValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateGovSteamCCCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateGovSteamCCCommand of GovSteamCC is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create GovSteamCC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateGovSteamCCCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateGovSteamCC( UpdateGovSteamCCCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	GovSteamCCValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateGovSteamCCCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save GovSteamCC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteGovSteamCCCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteGovSteamCCCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GovSteamCCValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteGovSteamCCCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete GovSteamCC using Id = "  + command.getGovSteamCCId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the GovSteamCC via GovSteamCCFetchOneSummary
     * @param 	summary GovSteamCCFetchOneSummary 
     * @return 	GovSteamCCFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public GovSteamCC getGovSteamCC( GovSteamCCFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "GovSteamCCFetchOneSummary arg cannot be null" );
    	
    	GovSteamCC entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	GovSteamCCValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a GovSteamCC
        	// --------------------------------------
        	CompletableFuture<GovSteamCC> futureEntity = queryGateway.query(new FindGovSteamCCQuery( new LoadGovSteamCCFilter( summary.getGovSteamCCId() ) ), ResponseTypes.instanceOf(GovSteamCC.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate GovSteamCC with id " + summary.getGovSteamCCId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all GovSteamCCs
     *
     * @return 	List<GovSteamCC> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<GovSteamCC> getAllGovSteamCC() 
    throws ProcessingException {
        List<GovSteamCC> list = null;

        try {
        	CompletableFuture<List<GovSteamCC>> futureList = queryGateway.query(new FindAllGovSteamCCQuery(), ResponseTypes.multipleInstancesOf(GovSteamCC.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all GovSteamCC";
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
	 * @return		GovSteamCC
	 */
	protected GovSteamCC load( UUID id ) throws ProcessingException {
		govSteamCC = GovSteamCCBusinessDelegate.getGovSteamCCInstance().getGovSteamCC( new GovSteamCCFetchOneSummary(id) );	
		return govSteamCC;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private GovSteamCC govSteamCC 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(GovSteamCCBusinessDelegate.class.getName());
    
}
