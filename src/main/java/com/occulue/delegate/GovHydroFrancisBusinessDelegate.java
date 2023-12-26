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
 * GovHydroFrancis business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of GovHydroFrancis related services in the case of a GovHydroFrancis business related service failing.</li>
 * <li>Exposes a simpler, uniform GovHydroFrancis interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill GovHydroFrancis business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class GovHydroFrancisBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public GovHydroFrancisBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* GovHydroFrancis Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	GovHydroFrancisBusinessDelegate
	*/
	public static GovHydroFrancisBusinessDelegate getGovHydroFrancisInstance() {
		return( new GovHydroFrancisBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createGovHydroFrancis( CreateGovHydroFrancisCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getGovHydroFrancisId() == null )
				command.setGovHydroFrancisId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GovHydroFrancisValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateGovHydroFrancisCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateGovHydroFrancisCommand of GovHydroFrancis is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create GovHydroFrancis - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateGovHydroFrancisCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateGovHydroFrancis( UpdateGovHydroFrancisCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	GovHydroFrancisValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateGovHydroFrancisCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save GovHydroFrancis - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteGovHydroFrancisCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteGovHydroFrancisCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GovHydroFrancisValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteGovHydroFrancisCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete GovHydroFrancis using Id = "  + command.getGovHydroFrancisId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the GovHydroFrancis via GovHydroFrancisFetchOneSummary
     * @param 	summary GovHydroFrancisFetchOneSummary 
     * @return 	GovHydroFrancisFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public GovHydroFrancis getGovHydroFrancis( GovHydroFrancisFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "GovHydroFrancisFetchOneSummary arg cannot be null" );
    	
    	GovHydroFrancis entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	GovHydroFrancisValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a GovHydroFrancis
        	// --------------------------------------
        	CompletableFuture<GovHydroFrancis> futureEntity = queryGateway.query(new FindGovHydroFrancisQuery( new LoadGovHydroFrancisFilter( summary.getGovHydroFrancisId() ) ), ResponseTypes.instanceOf(GovHydroFrancis.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate GovHydroFrancis with id " + summary.getGovHydroFrancisId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all GovHydroFranciss
     *
     * @return 	List<GovHydroFrancis> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<GovHydroFrancis> getAllGovHydroFrancis() 
    throws ProcessingException {
        List<GovHydroFrancis> list = null;

        try {
        	CompletableFuture<List<GovHydroFrancis>> futureList = queryGateway.query(new FindAllGovHydroFrancisQuery(), ResponseTypes.multipleInstancesOf(GovHydroFrancis.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all GovHydroFrancis";
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
	 * @return		GovHydroFrancis
	 */
	protected GovHydroFrancis load( UUID id ) throws ProcessingException {
		govHydroFrancis = GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().getGovHydroFrancis( new GovHydroFrancisFetchOneSummary(id) );	
		return govHydroFrancis;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private GovHydroFrancis govHydroFrancis 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(GovHydroFrancisBusinessDelegate.class.getName());
    
}
