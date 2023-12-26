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
 * GovHydroWEH business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of GovHydroWEH related services in the case of a GovHydroWEH business related service failing.</li>
 * <li>Exposes a simpler, uniform GovHydroWEH interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill GovHydroWEH business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class GovHydroWEHBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public GovHydroWEHBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* GovHydroWEH Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	GovHydroWEHBusinessDelegate
	*/
	public static GovHydroWEHBusinessDelegate getGovHydroWEHInstance() {
		return( new GovHydroWEHBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createGovHydroWEH( CreateGovHydroWEHCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getGovHydroWEHId() == null )
				command.setGovHydroWEHId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GovHydroWEHValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateGovHydroWEHCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateGovHydroWEHCommand of GovHydroWEH is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create GovHydroWEH - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateGovHydroWEHCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateGovHydroWEH( UpdateGovHydroWEHCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	GovHydroWEHValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateGovHydroWEHCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save GovHydroWEH - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteGovHydroWEHCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteGovHydroWEHCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GovHydroWEHValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteGovHydroWEHCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete GovHydroWEH using Id = "  + command.getGovHydroWEHId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the GovHydroWEH via GovHydroWEHFetchOneSummary
     * @param 	summary GovHydroWEHFetchOneSummary 
     * @return 	GovHydroWEHFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public GovHydroWEH getGovHydroWEH( GovHydroWEHFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "GovHydroWEHFetchOneSummary arg cannot be null" );
    	
    	GovHydroWEH entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	GovHydroWEHValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a GovHydroWEH
        	// --------------------------------------
        	CompletableFuture<GovHydroWEH> futureEntity = queryGateway.query(new FindGovHydroWEHQuery( new LoadGovHydroWEHFilter( summary.getGovHydroWEHId() ) ), ResponseTypes.instanceOf(GovHydroWEH.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate GovHydroWEH with id " + summary.getGovHydroWEHId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all GovHydroWEHs
     *
     * @return 	List<GovHydroWEH> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<GovHydroWEH> getAllGovHydroWEH() 
    throws ProcessingException {
        List<GovHydroWEH> list = null;

        try {
        	CompletableFuture<List<GovHydroWEH>> futureList = queryGateway.query(new FindAllGovHydroWEHQuery(), ResponseTypes.multipleInstancesOf(GovHydroWEH.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all GovHydroWEH";
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
	 * @return		GovHydroWEH
	 */
	protected GovHydroWEH load( UUID id ) throws ProcessingException {
		govHydroWEH = GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().getGovHydroWEH( new GovHydroWEHFetchOneSummary(id) );	
		return govHydroWEH;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private GovHydroWEH govHydroWEH 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(GovHydroWEHBusinessDelegate.class.getName());
    
}
