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
 * GovCT1 business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of GovCT1 related services in the case of a GovCT1 business related service failing.</li>
 * <li>Exposes a simpler, uniform GovCT1 interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill GovCT1 business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class GovCT1BusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public GovCT1BusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* GovCT1 Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	GovCT1BusinessDelegate
	*/
	public static GovCT1BusinessDelegate getGovCT1Instance() {
		return( new GovCT1BusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createGovCT1( CreateGovCT1Command command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getGovCT1Id() == null )
				command.setGovCT1Id( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GovCT1Validator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateGovCT1Command - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateGovCT1Command of GovCT1 is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create GovCT1 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateGovCT1Command
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateGovCT1( UpdateGovCT1Command command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	GovCT1Validator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateGovCT1Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save GovCT1 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteGovCT1Command
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteGovCT1Command command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GovCT1Validator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteGovCT1Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete GovCT1 using Id = "  + command.getGovCT1Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the GovCT1 via GovCT1FetchOneSummary
     * @param 	summary GovCT1FetchOneSummary 
     * @return 	GovCT1FetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public GovCT1 getGovCT1( GovCT1FetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "GovCT1FetchOneSummary arg cannot be null" );
    	
    	GovCT1 entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	GovCT1Validator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a GovCT1
        	// --------------------------------------
        	CompletableFuture<GovCT1> futureEntity = queryGateway.query(new FindGovCT1Query( new LoadGovCT1Filter( summary.getGovCT1Id() ) ), ResponseTypes.instanceOf(GovCT1.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate GovCT1 with id " + summary.getGovCT1Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all GovCT1s
     *
     * @return 	List<GovCT1> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<GovCT1> getAllGovCT1() 
    throws ProcessingException {
        List<GovCT1> list = null;

        try {
        	CompletableFuture<List<GovCT1>> futureList = queryGateway.query(new FindAllGovCT1Query(), ResponseTypes.multipleInstancesOf(GovCT1.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all GovCT1";
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
	 * @return		GovCT1
	 */
	protected GovCT1 load( UUID id ) throws ProcessingException {
		govCT1 = GovCT1BusinessDelegate.getGovCT1Instance().getGovCT1( new GovCT1FetchOneSummary(id) );	
		return govCT1;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private GovCT1 govCT1 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(GovCT1BusinessDelegate.class.getName());
    
}
