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
 * PssPTIST3 business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of PssPTIST3 related services in the case of a PssPTIST3 business related service failing.</li>
 * <li>Exposes a simpler, uniform PssPTIST3 interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill PssPTIST3 business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class PssPTIST3BusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public PssPTIST3BusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* PssPTIST3 Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	PssPTIST3BusinessDelegate
	*/
	public static PssPTIST3BusinessDelegate getPssPTIST3Instance() {
		return( new PssPTIST3BusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createPssPTIST3( CreatePssPTIST3Command command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getPssPTIST3Id() == null )
				command.setPssPTIST3Id( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PssPTIST3Validator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreatePssPTIST3Command - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreatePssPTIST3Command of PssPTIST3 is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create PssPTIST3 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdatePssPTIST3Command
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updatePssPTIST3( UpdatePssPTIST3Command command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	PssPTIST3Validator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdatePssPTIST3Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save PssPTIST3 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeletePssPTIST3Command
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeletePssPTIST3Command command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PssPTIST3Validator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeletePssPTIST3Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete PssPTIST3 using Id = "  + command.getPssPTIST3Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the PssPTIST3 via PssPTIST3FetchOneSummary
     * @param 	summary PssPTIST3FetchOneSummary 
     * @return 	PssPTIST3FetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public PssPTIST3 getPssPTIST3( PssPTIST3FetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "PssPTIST3FetchOneSummary arg cannot be null" );
    	
    	PssPTIST3 entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	PssPTIST3Validator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a PssPTIST3
        	// --------------------------------------
        	CompletableFuture<PssPTIST3> futureEntity = queryGateway.query(new FindPssPTIST3Query( new LoadPssPTIST3Filter( summary.getPssPTIST3Id() ) ), ResponseTypes.instanceOf(PssPTIST3.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate PssPTIST3 with id " + summary.getPssPTIST3Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all PssPTIST3s
     *
     * @return 	List<PssPTIST3> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<PssPTIST3> getAllPssPTIST3() 
    throws ProcessingException {
        List<PssPTIST3> list = null;

        try {
        	CompletableFuture<List<PssPTIST3>> futureList = queryGateway.query(new FindAllPssPTIST3Query(), ResponseTypes.multipleInstancesOf(PssPTIST3.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all PssPTIST3";
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
	 * @return		PssPTIST3
	 */
	protected PssPTIST3 load( UUID id ) throws ProcessingException {
		pssPTIST3 = PssPTIST3BusinessDelegate.getPssPTIST3Instance().getPssPTIST3( new PssPTIST3FetchOneSummary(id) );	
		return pssPTIST3;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private PssPTIST3 pssPTIST3 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(PssPTIST3BusinessDelegate.class.getName());
    
}
