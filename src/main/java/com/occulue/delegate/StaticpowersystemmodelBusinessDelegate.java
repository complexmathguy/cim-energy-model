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
 * Staticpowersystemmodel business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of Staticpowersystemmodel related services in the case of a Staticpowersystemmodel business related service failing.</li>
 * <li>Exposes a simpler, uniform Staticpowersystemmodel interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill Staticpowersystemmodel business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class StaticpowersystemmodelBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public StaticpowersystemmodelBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* Staticpowersystemmodel Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	StaticpowersystemmodelBusinessDelegate
	*/
	public static StaticpowersystemmodelBusinessDelegate getStaticpowersystemmodelInstance() {
		return( new StaticpowersystemmodelBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createStaticpowersystemmodel( CreateStaticpowersystemmodelCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getStaticpowersystemmodelId() == null )
				command.setStaticpowersystemmodelId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	StaticpowersystemmodelValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateStaticpowersystemmodelCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateStaticpowersystemmodelCommand of Staticpowersystemmodel is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create Staticpowersystemmodel - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateStaticpowersystemmodelCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateStaticpowersystemmodel( UpdateStaticpowersystemmodelCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	StaticpowersystemmodelValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateStaticpowersystemmodelCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save Staticpowersystemmodel - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteStaticpowersystemmodelCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteStaticpowersystemmodelCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	StaticpowersystemmodelValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteStaticpowersystemmodelCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete Staticpowersystemmodel using Id = "  + command.getStaticpowersystemmodelId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the Staticpowersystemmodel via StaticpowersystemmodelFetchOneSummary
     * @param 	summary StaticpowersystemmodelFetchOneSummary 
     * @return 	StaticpowersystemmodelFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public Staticpowersystemmodel getStaticpowersystemmodel( StaticpowersystemmodelFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "StaticpowersystemmodelFetchOneSummary arg cannot be null" );
    	
    	Staticpowersystemmodel entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	StaticpowersystemmodelValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a Staticpowersystemmodel
        	// --------------------------------------
        	CompletableFuture<Staticpowersystemmodel> futureEntity = queryGateway.query(new FindStaticpowersystemmodelQuery( new LoadStaticpowersystemmodelFilter( summary.getStaticpowersystemmodelId() ) ), ResponseTypes.instanceOf(Staticpowersystemmodel.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate Staticpowersystemmodel with id " + summary.getStaticpowersystemmodelId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all Staticpowersystemmodels
     *
     * @return 	List<Staticpowersystemmodel> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<Staticpowersystemmodel> getAllStaticpowersystemmodel() 
    throws ProcessingException {
        List<Staticpowersystemmodel> list = null;

        try {
        	CompletableFuture<List<Staticpowersystemmodel>> futureList = queryGateway.query(new FindAllStaticpowersystemmodelQuery(), ResponseTypes.multipleInstancesOf(Staticpowersystemmodel.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all Staticpowersystemmodel";
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
	 * @return		Staticpowersystemmodel
	 */
	protected Staticpowersystemmodel load( UUID id ) throws ProcessingException {
		staticpowersystemmodel = StaticpowersystemmodelBusinessDelegate.getStaticpowersystemmodelInstance().getStaticpowersystemmodel( new StaticpowersystemmodelFetchOneSummary(id) );	
		return staticpowersystemmodel;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private Staticpowersystemmodel staticpowersystemmodel 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(StaticpowersystemmodelBusinessDelegate.class.getName());
    
}
