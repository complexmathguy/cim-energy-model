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
 * GovSteam1 business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of GovSteam1 related services in the case of a GovSteam1 business related service failing.</li>
 * <li>Exposes a simpler, uniform GovSteam1 interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill GovSteam1 business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class GovSteam1BusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public GovSteam1BusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* GovSteam1 Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	GovSteam1BusinessDelegate
	*/
	public static GovSteam1BusinessDelegate getGovSteam1Instance() {
		return( new GovSteam1BusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createGovSteam1( CreateGovSteam1Command command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getGovSteam1Id() == null )
				command.setGovSteam1Id( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GovSteam1Validator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateGovSteam1Command - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateGovSteam1Command of GovSteam1 is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create GovSteam1 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateGovSteam1Command
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateGovSteam1( UpdateGovSteam1Command command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	GovSteam1Validator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateGovSteam1Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save GovSteam1 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteGovSteam1Command
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteGovSteam1Command command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GovSteam1Validator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteGovSteam1Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete GovSteam1 using Id = "  + command.getGovSteam1Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the GovSteam1 via GovSteam1FetchOneSummary
     * @param 	summary GovSteam1FetchOneSummary 
     * @return 	GovSteam1FetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public GovSteam1 getGovSteam1( GovSteam1FetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "GovSteam1FetchOneSummary arg cannot be null" );
    	
    	GovSteam1 entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	GovSteam1Validator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a GovSteam1
        	// --------------------------------------
        	CompletableFuture<GovSteam1> futureEntity = queryGateway.query(new FindGovSteam1Query( new LoadGovSteam1Filter( summary.getGovSteam1Id() ) ), ResponseTypes.instanceOf(GovSteam1.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate GovSteam1 with id " + summary.getGovSteam1Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all GovSteam1s
     *
     * @return 	List<GovSteam1> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<GovSteam1> getAllGovSteam1() 
    throws ProcessingException {
        List<GovSteam1> list = null;

        try {
        	CompletableFuture<List<GovSteam1>> futureList = queryGateway.query(new FindAllGovSteam1Query(), ResponseTypes.multipleInstancesOf(GovSteam1.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all GovSteam1";
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
	 * @return		GovSteam1
	 */
	protected GovSteam1 load( UUID id ) throws ProcessingException {
		govSteam1 = GovSteam1BusinessDelegate.getGovSteam1Instance().getGovSteam1( new GovSteam1FetchOneSummary(id) );	
		return govSteam1;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private GovSteam1 govSteam1 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(GovSteam1BusinessDelegate.class.getName());
    
}
