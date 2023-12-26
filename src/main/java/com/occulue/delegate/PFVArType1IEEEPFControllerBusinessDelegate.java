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
 * PFVArType1IEEEPFController business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of PFVArType1IEEEPFController related services in the case of a PFVArType1IEEEPFController business related service failing.</li>
 * <li>Exposes a simpler, uniform PFVArType1IEEEPFController interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill PFVArType1IEEEPFController business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class PFVArType1IEEEPFControllerBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public PFVArType1IEEEPFControllerBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* PFVArType1IEEEPFController Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	PFVArType1IEEEPFControllerBusinessDelegate
	*/
	public static PFVArType1IEEEPFControllerBusinessDelegate getPFVArType1IEEEPFControllerInstance() {
		return( new PFVArType1IEEEPFControllerBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createPFVArType1IEEEPFController( CreatePFVArType1IEEEPFControllerCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getPFVArType1IEEEPFControllerId() == null )
				command.setPFVArType1IEEEPFControllerId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PFVArType1IEEEPFControllerValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreatePFVArType1IEEEPFControllerCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreatePFVArType1IEEEPFControllerCommand of PFVArType1IEEEPFController is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create PFVArType1IEEEPFController - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdatePFVArType1IEEEPFControllerCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updatePFVArType1IEEEPFController( UpdatePFVArType1IEEEPFControllerCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	PFVArType1IEEEPFControllerValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdatePFVArType1IEEEPFControllerCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save PFVArType1IEEEPFController - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeletePFVArType1IEEEPFControllerCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeletePFVArType1IEEEPFControllerCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PFVArType1IEEEPFControllerValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeletePFVArType1IEEEPFControllerCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete PFVArType1IEEEPFController using Id = "  + command.getPFVArType1IEEEPFControllerId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the PFVArType1IEEEPFController via PFVArType1IEEEPFControllerFetchOneSummary
     * @param 	summary PFVArType1IEEEPFControllerFetchOneSummary 
     * @return 	PFVArType1IEEEPFControllerFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public PFVArType1IEEEPFController getPFVArType1IEEEPFController( PFVArType1IEEEPFControllerFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "PFVArType1IEEEPFControllerFetchOneSummary arg cannot be null" );
    	
    	PFVArType1IEEEPFController entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	PFVArType1IEEEPFControllerValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a PFVArType1IEEEPFController
        	// --------------------------------------
        	CompletableFuture<PFVArType1IEEEPFController> futureEntity = queryGateway.query(new FindPFVArType1IEEEPFControllerQuery( new LoadPFVArType1IEEEPFControllerFilter( summary.getPFVArType1IEEEPFControllerId() ) ), ResponseTypes.instanceOf(PFVArType1IEEEPFController.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate PFVArType1IEEEPFController with id " + summary.getPFVArType1IEEEPFControllerId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all PFVArType1IEEEPFControllers
     *
     * @return 	List<PFVArType1IEEEPFController> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<PFVArType1IEEEPFController> getAllPFVArType1IEEEPFController() 
    throws ProcessingException {
        List<PFVArType1IEEEPFController> list = null;

        try {
        	CompletableFuture<List<PFVArType1IEEEPFController>> futureList = queryGateway.query(new FindAllPFVArType1IEEEPFControllerQuery(), ResponseTypes.multipleInstancesOf(PFVArType1IEEEPFController.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all PFVArType1IEEEPFController";
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
	 * @return		PFVArType1IEEEPFController
	 */
	protected PFVArType1IEEEPFController load( UUID id ) throws ProcessingException {
		pFVArType1IEEEPFController = PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance().getPFVArType1IEEEPFController( new PFVArType1IEEEPFControllerFetchOneSummary(id) );	
		return pFVArType1IEEEPFController;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private PFVArType1IEEEPFController pFVArType1IEEEPFController 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(PFVArType1IEEEPFControllerBusinessDelegate.class.getName());
    
}
