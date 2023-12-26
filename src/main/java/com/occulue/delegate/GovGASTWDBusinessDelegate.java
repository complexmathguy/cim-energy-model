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
 * GovGASTWD business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of GovGASTWD related services in the case of a GovGASTWD business related service failing.</li>
 * <li>Exposes a simpler, uniform GovGASTWD interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill GovGASTWD business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class GovGASTWDBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public GovGASTWDBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* GovGASTWD Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	GovGASTWDBusinessDelegate
	*/
	public static GovGASTWDBusinessDelegate getGovGASTWDInstance() {
		return( new GovGASTWDBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createGovGASTWD( CreateGovGASTWDCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getGovGASTWDId() == null )
				command.setGovGASTWDId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GovGASTWDValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateGovGASTWDCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateGovGASTWDCommand of GovGASTWD is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create GovGASTWD - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateGovGASTWDCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateGovGASTWD( UpdateGovGASTWDCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	GovGASTWDValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateGovGASTWDCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save GovGASTWD - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteGovGASTWDCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteGovGASTWDCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GovGASTWDValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteGovGASTWDCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete GovGASTWD using Id = "  + command.getGovGASTWDId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the GovGASTWD via GovGASTWDFetchOneSummary
     * @param 	summary GovGASTWDFetchOneSummary 
     * @return 	GovGASTWDFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public GovGASTWD getGovGASTWD( GovGASTWDFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "GovGASTWDFetchOneSummary arg cannot be null" );
    	
    	GovGASTWD entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	GovGASTWDValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a GovGASTWD
        	// --------------------------------------
        	CompletableFuture<GovGASTWD> futureEntity = queryGateway.query(new FindGovGASTWDQuery( new LoadGovGASTWDFilter( summary.getGovGASTWDId() ) ), ResponseTypes.instanceOf(GovGASTWD.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate GovGASTWD with id " + summary.getGovGASTWDId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all GovGASTWDs
     *
     * @return 	List<GovGASTWD> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<GovGASTWD> getAllGovGASTWD() 
    throws ProcessingException {
        List<GovGASTWD> list = null;

        try {
        	CompletableFuture<List<GovGASTWD>> futureList = queryGateway.query(new FindAllGovGASTWDQuery(), ResponseTypes.multipleInstancesOf(GovGASTWD.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all GovGASTWD";
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
	 * @return		GovGASTWD
	 */
	protected GovGASTWD load( UUID id ) throws ProcessingException {
		govGASTWD = GovGASTWDBusinessDelegate.getGovGASTWDInstance().getGovGASTWD( new GovGASTWDFetchOneSummary(id) );	
		return govGASTWD;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private GovGASTWD govGASTWD 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(GovGASTWDBusinessDelegate.class.getName());
    
}
