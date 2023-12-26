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
 * PFVArType2IEEEVArController business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of PFVArType2IEEEVArController related services in the case of a PFVArType2IEEEVArController business related service failing.</li>
 * <li>Exposes a simpler, uniform PFVArType2IEEEVArController interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill PFVArType2IEEEVArController business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class PFVArType2IEEEVArControllerBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public PFVArType2IEEEVArControllerBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* PFVArType2IEEEVArController Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	PFVArType2IEEEVArControllerBusinessDelegate
	*/
	public static PFVArType2IEEEVArControllerBusinessDelegate getPFVArType2IEEEVArControllerInstance() {
		return( new PFVArType2IEEEVArControllerBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createPFVArType2IEEEVArController( CreatePFVArType2IEEEVArControllerCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getPFVArType2IEEEVArControllerId() == null )
				command.setPFVArType2IEEEVArControllerId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PFVArType2IEEEVArControllerValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreatePFVArType2IEEEVArControllerCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreatePFVArType2IEEEVArControllerCommand of PFVArType2IEEEVArController is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create PFVArType2IEEEVArController - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdatePFVArType2IEEEVArControllerCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updatePFVArType2IEEEVArController( UpdatePFVArType2IEEEVArControllerCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	PFVArType2IEEEVArControllerValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdatePFVArType2IEEEVArControllerCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save PFVArType2IEEEVArController - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeletePFVArType2IEEEVArControllerCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeletePFVArType2IEEEVArControllerCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PFVArType2IEEEVArControllerValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeletePFVArType2IEEEVArControllerCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete PFVArType2IEEEVArController using Id = "  + command.getPFVArType2IEEEVArControllerId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the PFVArType2IEEEVArController via PFVArType2IEEEVArControllerFetchOneSummary
     * @param 	summary PFVArType2IEEEVArControllerFetchOneSummary 
     * @return 	PFVArType2IEEEVArControllerFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public PFVArType2IEEEVArController getPFVArType2IEEEVArController( PFVArType2IEEEVArControllerFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "PFVArType2IEEEVArControllerFetchOneSummary arg cannot be null" );
    	
    	PFVArType2IEEEVArController entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	PFVArType2IEEEVArControllerValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a PFVArType2IEEEVArController
        	// --------------------------------------
        	CompletableFuture<PFVArType2IEEEVArController> futureEntity = queryGateway.query(new FindPFVArType2IEEEVArControllerQuery( new LoadPFVArType2IEEEVArControllerFilter( summary.getPFVArType2IEEEVArControllerId() ) ), ResponseTypes.instanceOf(PFVArType2IEEEVArController.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate PFVArType2IEEEVArController with id " + summary.getPFVArType2IEEEVArControllerId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all PFVArType2IEEEVArControllers
     *
     * @return 	List<PFVArType2IEEEVArController> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<PFVArType2IEEEVArController> getAllPFVArType2IEEEVArController() 
    throws ProcessingException {
        List<PFVArType2IEEEVArController> list = null;

        try {
        	CompletableFuture<List<PFVArType2IEEEVArController>> futureList = queryGateway.query(new FindAllPFVArType2IEEEVArControllerQuery(), ResponseTypes.multipleInstancesOf(PFVArType2IEEEVArController.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all PFVArType2IEEEVArController";
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
	 * @return		PFVArType2IEEEVArController
	 */
	protected PFVArType2IEEEVArController load( UUID id ) throws ProcessingException {
		pFVArType2IEEEVArController = PFVArType2IEEEVArControllerBusinessDelegate.getPFVArType2IEEEVArControllerInstance().getPFVArType2IEEEVArController( new PFVArType2IEEEVArControllerFetchOneSummary(id) );	
		return pFVArType2IEEEVArController;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private PFVArType2IEEEVArController pFVArType2IEEEVArController 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(PFVArType2IEEEVArControllerBusinessDelegate.class.getName());
    
}
