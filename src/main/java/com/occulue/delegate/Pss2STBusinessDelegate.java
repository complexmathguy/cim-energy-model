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
 * Pss2ST business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of Pss2ST related services in the case of a Pss2ST business related service failing.</li>
 * <li>Exposes a simpler, uniform Pss2ST interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill Pss2ST business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class Pss2STBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public Pss2STBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* Pss2ST Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	Pss2STBusinessDelegate
	*/
	public static Pss2STBusinessDelegate getPss2STInstance() {
		return( new Pss2STBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createPss2ST( CreatePss2STCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getPss2STId() == null )
				command.setPss2STId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	Pss2STValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreatePss2STCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreatePss2STCommand of Pss2ST is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create Pss2ST - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdatePss2STCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updatePss2ST( UpdatePss2STCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	Pss2STValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdatePss2STCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save Pss2ST - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeletePss2STCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeletePss2STCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	Pss2STValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeletePss2STCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete Pss2ST using Id = "  + command.getPss2STId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the Pss2ST via Pss2STFetchOneSummary
     * @param 	summary Pss2STFetchOneSummary 
     * @return 	Pss2STFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public Pss2ST getPss2ST( Pss2STFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "Pss2STFetchOneSummary arg cannot be null" );
    	
    	Pss2ST entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	Pss2STValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a Pss2ST
        	// --------------------------------------
        	CompletableFuture<Pss2ST> futureEntity = queryGateway.query(new FindPss2STQuery( new LoadPss2STFilter( summary.getPss2STId() ) ), ResponseTypes.instanceOf(Pss2ST.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate Pss2ST with id " + summary.getPss2STId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all Pss2STs
     *
     * @return 	List<Pss2ST> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<Pss2ST> getAllPss2ST() 
    throws ProcessingException {
        List<Pss2ST> list = null;

        try {
        	CompletableFuture<List<Pss2ST>> futureList = queryGateway.query(new FindAllPss2STQuery(), ResponseTypes.multipleInstancesOf(Pss2ST.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all Pss2ST";
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
	 * @return		Pss2ST
	 */
	protected Pss2ST load( UUID id ) throws ProcessingException {
		pss2ST = Pss2STBusinessDelegate.getPss2STInstance().getPss2ST( new Pss2STFetchOneSummary(id) );	
		return pss2ST;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private Pss2ST pss2ST 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(Pss2STBusinessDelegate.class.getName());
    
}
