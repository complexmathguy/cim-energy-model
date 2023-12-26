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
 * GovHydroDD business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of GovHydroDD related services in the case of a GovHydroDD business related service failing.</li>
 * <li>Exposes a simpler, uniform GovHydroDD interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill GovHydroDD business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class GovHydroDDBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public GovHydroDDBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* GovHydroDD Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	GovHydroDDBusinessDelegate
	*/
	public static GovHydroDDBusinessDelegate getGovHydroDDInstance() {
		return( new GovHydroDDBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createGovHydroDD( CreateGovHydroDDCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getGovHydroDDId() == null )
				command.setGovHydroDDId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GovHydroDDValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateGovHydroDDCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateGovHydroDDCommand of GovHydroDD is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create GovHydroDD - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateGovHydroDDCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateGovHydroDD( UpdateGovHydroDDCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	GovHydroDDValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateGovHydroDDCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save GovHydroDD - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteGovHydroDDCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteGovHydroDDCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GovHydroDDValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteGovHydroDDCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete GovHydroDD using Id = "  + command.getGovHydroDDId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the GovHydroDD via GovHydroDDFetchOneSummary
     * @param 	summary GovHydroDDFetchOneSummary 
     * @return 	GovHydroDDFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public GovHydroDD getGovHydroDD( GovHydroDDFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "GovHydroDDFetchOneSummary arg cannot be null" );
    	
    	GovHydroDD entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	GovHydroDDValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a GovHydroDD
        	// --------------------------------------
        	CompletableFuture<GovHydroDD> futureEntity = queryGateway.query(new FindGovHydroDDQuery( new LoadGovHydroDDFilter( summary.getGovHydroDDId() ) ), ResponseTypes.instanceOf(GovHydroDD.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate GovHydroDD with id " + summary.getGovHydroDDId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all GovHydroDDs
     *
     * @return 	List<GovHydroDD> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<GovHydroDD> getAllGovHydroDD() 
    throws ProcessingException {
        List<GovHydroDD> list = null;

        try {
        	CompletableFuture<List<GovHydroDD>> futureList = queryGateway.query(new FindAllGovHydroDDQuery(), ResponseTypes.multipleInstancesOf(GovHydroDD.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all GovHydroDD";
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
	 * @return		GovHydroDD
	 */
	protected GovHydroDD load( UUID id ) throws ProcessingException {
		govHydroDD = GovHydroDDBusinessDelegate.getGovHydroDDInstance().getGovHydroDD( new GovHydroDDFetchOneSummary(id) );	
		return govHydroDD;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private GovHydroDD govHydroDD 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(GovHydroDDBusinessDelegate.class.getName());
    
}
