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
 * PFVArType1IEEEVArController business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of PFVArType1IEEEVArController related services in the case of a PFVArType1IEEEVArController business related service failing.</li>
 * <li>Exposes a simpler, uniform PFVArType1IEEEVArController interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill PFVArType1IEEEVArController business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class PFVArType1IEEEVArControllerBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public PFVArType1IEEEVArControllerBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* PFVArType1IEEEVArController Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	PFVArType1IEEEVArControllerBusinessDelegate
	*/
	public static PFVArType1IEEEVArControllerBusinessDelegate getPFVArType1IEEEVArControllerInstance() {
		return( new PFVArType1IEEEVArControllerBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createPFVArType1IEEEVArController( CreatePFVArType1IEEEVArControllerCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getPFVArType1IEEEVArControllerId() == null )
				command.setPFVArType1IEEEVArControllerId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PFVArType1IEEEVArControllerValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreatePFVArType1IEEEVArControllerCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreatePFVArType1IEEEVArControllerCommand of PFVArType1IEEEVArController is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create PFVArType1IEEEVArController - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdatePFVArType1IEEEVArControllerCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updatePFVArType1IEEEVArController( UpdatePFVArType1IEEEVArControllerCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	PFVArType1IEEEVArControllerValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdatePFVArType1IEEEVArControllerCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save PFVArType1IEEEVArController - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeletePFVArType1IEEEVArControllerCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeletePFVArType1IEEEVArControllerCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PFVArType1IEEEVArControllerValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeletePFVArType1IEEEVArControllerCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete PFVArType1IEEEVArController using Id = "  + command.getPFVArType1IEEEVArControllerId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the PFVArType1IEEEVArController via PFVArType1IEEEVArControllerFetchOneSummary
     * @param 	summary PFVArType1IEEEVArControllerFetchOneSummary 
     * @return 	PFVArType1IEEEVArControllerFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public PFVArType1IEEEVArController getPFVArType1IEEEVArController( PFVArType1IEEEVArControllerFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "PFVArType1IEEEVArControllerFetchOneSummary arg cannot be null" );
    	
    	PFVArType1IEEEVArController entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	PFVArType1IEEEVArControllerValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a PFVArType1IEEEVArController
        	// --------------------------------------
        	CompletableFuture<PFVArType1IEEEVArController> futureEntity = queryGateway.query(new FindPFVArType1IEEEVArControllerQuery( new LoadPFVArType1IEEEVArControllerFilter( summary.getPFVArType1IEEEVArControllerId() ) ), ResponseTypes.instanceOf(PFVArType1IEEEVArController.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate PFVArType1IEEEVArController with id " + summary.getPFVArType1IEEEVArControllerId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all PFVArType1IEEEVArControllers
     *
     * @return 	List<PFVArType1IEEEVArController> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<PFVArType1IEEEVArController> getAllPFVArType1IEEEVArController() 
    throws ProcessingException {
        List<PFVArType1IEEEVArController> list = null;

        try {
        	CompletableFuture<List<PFVArType1IEEEVArController>> futureList = queryGateway.query(new FindAllPFVArType1IEEEVArControllerQuery(), ResponseTypes.multipleInstancesOf(PFVArType1IEEEVArController.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all PFVArType1IEEEVArController";
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
	 * @return		PFVArType1IEEEVArController
	 */
	protected PFVArType1IEEEVArController load( UUID id ) throws ProcessingException {
		pFVArType1IEEEVArController = PFVArType1IEEEVArControllerBusinessDelegate.getPFVArType1IEEEVArControllerInstance().getPFVArType1IEEEVArController( new PFVArType1IEEEVArControllerFetchOneSummary(id) );	
		return pFVArType1IEEEVArController;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private PFVArType1IEEEVArController pFVArType1IEEEVArController 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(PFVArType1IEEEVArControllerBusinessDelegate.class.getName());
    
}
