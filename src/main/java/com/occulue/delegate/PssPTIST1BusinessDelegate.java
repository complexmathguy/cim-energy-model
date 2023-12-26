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
 * PssPTIST1 business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of PssPTIST1 related services in the case of a PssPTIST1 business related service failing.</li>
 * <li>Exposes a simpler, uniform PssPTIST1 interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill PssPTIST1 business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class PssPTIST1BusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public PssPTIST1BusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* PssPTIST1 Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	PssPTIST1BusinessDelegate
	*/
	public static PssPTIST1BusinessDelegate getPssPTIST1Instance() {
		return( new PssPTIST1BusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createPssPTIST1( CreatePssPTIST1Command command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getPssPTIST1Id() == null )
				command.setPssPTIST1Id( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PssPTIST1Validator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreatePssPTIST1Command - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreatePssPTIST1Command of PssPTIST1 is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create PssPTIST1 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdatePssPTIST1Command
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updatePssPTIST1( UpdatePssPTIST1Command command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	PssPTIST1Validator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdatePssPTIST1Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save PssPTIST1 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeletePssPTIST1Command
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeletePssPTIST1Command command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PssPTIST1Validator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeletePssPTIST1Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete PssPTIST1 using Id = "  + command.getPssPTIST1Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the PssPTIST1 via PssPTIST1FetchOneSummary
     * @param 	summary PssPTIST1FetchOneSummary 
     * @return 	PssPTIST1FetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public PssPTIST1 getPssPTIST1( PssPTIST1FetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "PssPTIST1FetchOneSummary arg cannot be null" );
    	
    	PssPTIST1 entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	PssPTIST1Validator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a PssPTIST1
        	// --------------------------------------
        	CompletableFuture<PssPTIST1> futureEntity = queryGateway.query(new FindPssPTIST1Query( new LoadPssPTIST1Filter( summary.getPssPTIST1Id() ) ), ResponseTypes.instanceOf(PssPTIST1.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate PssPTIST1 with id " + summary.getPssPTIST1Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all PssPTIST1s
     *
     * @return 	List<PssPTIST1> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<PssPTIST1> getAllPssPTIST1() 
    throws ProcessingException {
        List<PssPTIST1> list = null;

        try {
        	CompletableFuture<List<PssPTIST1>> futureList = queryGateway.query(new FindAllPssPTIST1Query(), ResponseTypes.multipleInstancesOf(PssPTIST1.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all PssPTIST1";
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
	 * @return		PssPTIST1
	 */
	protected PssPTIST1 load( UUID id ) throws ProcessingException {
		pssPTIST1 = PssPTIST1BusinessDelegate.getPssPTIST1Instance().getPssPTIST1( new PssPTIST1FetchOneSummary(id) );	
		return pssPTIST1;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private PssPTIST1 pssPTIST1 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(PssPTIST1BusinessDelegate.class.getName());
    
}
