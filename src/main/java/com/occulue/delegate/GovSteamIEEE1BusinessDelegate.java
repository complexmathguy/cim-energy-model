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
 * GovSteamIEEE1 business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of GovSteamIEEE1 related services in the case of a GovSteamIEEE1 business related service failing.</li>
 * <li>Exposes a simpler, uniform GovSteamIEEE1 interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill GovSteamIEEE1 business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class GovSteamIEEE1BusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public GovSteamIEEE1BusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* GovSteamIEEE1 Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	GovSteamIEEE1BusinessDelegate
	*/
	public static GovSteamIEEE1BusinessDelegate getGovSteamIEEE1Instance() {
		return( new GovSteamIEEE1BusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createGovSteamIEEE1( CreateGovSteamIEEE1Command command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getGovSteamIEEE1Id() == null )
				command.setGovSteamIEEE1Id( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GovSteamIEEE1Validator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateGovSteamIEEE1Command - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateGovSteamIEEE1Command of GovSteamIEEE1 is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create GovSteamIEEE1 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateGovSteamIEEE1Command
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateGovSteamIEEE1( UpdateGovSteamIEEE1Command command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	GovSteamIEEE1Validator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateGovSteamIEEE1Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save GovSteamIEEE1 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteGovSteamIEEE1Command
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteGovSteamIEEE1Command command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GovSteamIEEE1Validator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteGovSteamIEEE1Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete GovSteamIEEE1 using Id = "  + command.getGovSteamIEEE1Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the GovSteamIEEE1 via GovSteamIEEE1FetchOneSummary
     * @param 	summary GovSteamIEEE1FetchOneSummary 
     * @return 	GovSteamIEEE1FetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public GovSteamIEEE1 getGovSteamIEEE1( GovSteamIEEE1FetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "GovSteamIEEE1FetchOneSummary arg cannot be null" );
    	
    	GovSteamIEEE1 entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	GovSteamIEEE1Validator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a GovSteamIEEE1
        	// --------------------------------------
        	CompletableFuture<GovSteamIEEE1> futureEntity = queryGateway.query(new FindGovSteamIEEE1Query( new LoadGovSteamIEEE1Filter( summary.getGovSteamIEEE1Id() ) ), ResponseTypes.instanceOf(GovSteamIEEE1.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate GovSteamIEEE1 with id " + summary.getGovSteamIEEE1Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all GovSteamIEEE1s
     *
     * @return 	List<GovSteamIEEE1> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<GovSteamIEEE1> getAllGovSteamIEEE1() 
    throws ProcessingException {
        List<GovSteamIEEE1> list = null;

        try {
        	CompletableFuture<List<GovSteamIEEE1>> futureList = queryGateway.query(new FindAllGovSteamIEEE1Query(), ResponseTypes.multipleInstancesOf(GovSteamIEEE1.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all GovSteamIEEE1";
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
	 * @return		GovSteamIEEE1
	 */
	protected GovSteamIEEE1 load( UUID id ) throws ProcessingException {
		govSteamIEEE1 = GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().getGovSteamIEEE1( new GovSteamIEEE1FetchOneSummary(id) );	
		return govSteamIEEE1;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private GovSteamIEEE1 govSteamIEEE1 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(GovSteamIEEE1BusinessDelegate.class.getName());
    
}
