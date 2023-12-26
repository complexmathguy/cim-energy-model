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
 * GovHydroPID2 business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of GovHydroPID2 related services in the case of a GovHydroPID2 business related service failing.</li>
 * <li>Exposes a simpler, uniform GovHydroPID2 interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill GovHydroPID2 business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class GovHydroPID2BusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public GovHydroPID2BusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* GovHydroPID2 Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	GovHydroPID2BusinessDelegate
	*/
	public static GovHydroPID2BusinessDelegate getGovHydroPID2Instance() {
		return( new GovHydroPID2BusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createGovHydroPID2( CreateGovHydroPID2Command command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getGovHydroPID2Id() == null )
				command.setGovHydroPID2Id( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GovHydroPID2Validator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateGovHydroPID2Command - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateGovHydroPID2Command of GovHydroPID2 is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create GovHydroPID2 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateGovHydroPID2Command
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateGovHydroPID2( UpdateGovHydroPID2Command command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	GovHydroPID2Validator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateGovHydroPID2Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save GovHydroPID2 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteGovHydroPID2Command
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteGovHydroPID2Command command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GovHydroPID2Validator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteGovHydroPID2Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete GovHydroPID2 using Id = "  + command.getGovHydroPID2Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the GovHydroPID2 via GovHydroPID2FetchOneSummary
     * @param 	summary GovHydroPID2FetchOneSummary 
     * @return 	GovHydroPID2FetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public GovHydroPID2 getGovHydroPID2( GovHydroPID2FetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "GovHydroPID2FetchOneSummary arg cannot be null" );
    	
    	GovHydroPID2 entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	GovHydroPID2Validator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a GovHydroPID2
        	// --------------------------------------
        	CompletableFuture<GovHydroPID2> futureEntity = queryGateway.query(new FindGovHydroPID2Query( new LoadGovHydroPID2Filter( summary.getGovHydroPID2Id() ) ), ResponseTypes.instanceOf(GovHydroPID2.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate GovHydroPID2 with id " + summary.getGovHydroPID2Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all GovHydroPID2s
     *
     * @return 	List<GovHydroPID2> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<GovHydroPID2> getAllGovHydroPID2() 
    throws ProcessingException {
        List<GovHydroPID2> list = null;

        try {
        	CompletableFuture<List<GovHydroPID2>> futureList = queryGateway.query(new FindAllGovHydroPID2Query(), ResponseTypes.multipleInstancesOf(GovHydroPID2.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all GovHydroPID2";
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
	 * @return		GovHydroPID2
	 */
	protected GovHydroPID2 load( UUID id ) throws ProcessingException {
		govHydroPID2 = GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().getGovHydroPID2( new GovHydroPID2FetchOneSummary(id) );	
		return govHydroPID2;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private GovHydroPID2 govHydroPID2 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(GovHydroPID2BusinessDelegate.class.getName());
    
}
