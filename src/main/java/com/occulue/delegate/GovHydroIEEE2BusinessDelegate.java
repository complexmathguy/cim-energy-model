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
 * GovHydroIEEE2 business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of GovHydroIEEE2 related services in the case of a GovHydroIEEE2 business related service failing.</li>
 * <li>Exposes a simpler, uniform GovHydroIEEE2 interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill GovHydroIEEE2 business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class GovHydroIEEE2BusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public GovHydroIEEE2BusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* GovHydroIEEE2 Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	GovHydroIEEE2BusinessDelegate
	*/
	public static GovHydroIEEE2BusinessDelegate getGovHydroIEEE2Instance() {
		return( new GovHydroIEEE2BusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createGovHydroIEEE2( CreateGovHydroIEEE2Command command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getGovHydroIEEE2Id() == null )
				command.setGovHydroIEEE2Id( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GovHydroIEEE2Validator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateGovHydroIEEE2Command - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateGovHydroIEEE2Command of GovHydroIEEE2 is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create GovHydroIEEE2 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateGovHydroIEEE2Command
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateGovHydroIEEE2( UpdateGovHydroIEEE2Command command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	GovHydroIEEE2Validator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateGovHydroIEEE2Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save GovHydroIEEE2 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteGovHydroIEEE2Command
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteGovHydroIEEE2Command command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GovHydroIEEE2Validator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteGovHydroIEEE2Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete GovHydroIEEE2 using Id = "  + command.getGovHydroIEEE2Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the GovHydroIEEE2 via GovHydroIEEE2FetchOneSummary
     * @param 	summary GovHydroIEEE2FetchOneSummary 
     * @return 	GovHydroIEEE2FetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public GovHydroIEEE2 getGovHydroIEEE2( GovHydroIEEE2FetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "GovHydroIEEE2FetchOneSummary arg cannot be null" );
    	
    	GovHydroIEEE2 entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	GovHydroIEEE2Validator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a GovHydroIEEE2
        	// --------------------------------------
        	CompletableFuture<GovHydroIEEE2> futureEntity = queryGateway.query(new FindGovHydroIEEE2Query( new LoadGovHydroIEEE2Filter( summary.getGovHydroIEEE2Id() ) ), ResponseTypes.instanceOf(GovHydroIEEE2.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate GovHydroIEEE2 with id " + summary.getGovHydroIEEE2Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all GovHydroIEEE2s
     *
     * @return 	List<GovHydroIEEE2> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<GovHydroIEEE2> getAllGovHydroIEEE2() 
    throws ProcessingException {
        List<GovHydroIEEE2> list = null;

        try {
        	CompletableFuture<List<GovHydroIEEE2>> futureList = queryGateway.query(new FindAllGovHydroIEEE2Query(), ResponseTypes.multipleInstancesOf(GovHydroIEEE2.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all GovHydroIEEE2";
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
	 * @return		GovHydroIEEE2
	 */
	protected GovHydroIEEE2 load( UUID id ) throws ProcessingException {
		govHydroIEEE2 = GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().getGovHydroIEEE2( new GovHydroIEEE2FetchOneSummary(id) );	
		return govHydroIEEE2;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private GovHydroIEEE2 govHydroIEEE2 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(GovHydroIEEE2BusinessDelegate.class.getName());
    
}
