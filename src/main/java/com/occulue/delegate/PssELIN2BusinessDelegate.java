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
 * PssELIN2 business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of PssELIN2 related services in the case of a PssELIN2 business related service failing.</li>
 * <li>Exposes a simpler, uniform PssELIN2 interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill PssELIN2 business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class PssELIN2BusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public PssELIN2BusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* PssELIN2 Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	PssELIN2BusinessDelegate
	*/
	public static PssELIN2BusinessDelegate getPssELIN2Instance() {
		return( new PssELIN2BusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createPssELIN2( CreatePssELIN2Command command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getPssELIN2Id() == null )
				command.setPssELIN2Id( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PssELIN2Validator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreatePssELIN2Command - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreatePssELIN2Command of PssELIN2 is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create PssELIN2 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdatePssELIN2Command
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updatePssELIN2( UpdatePssELIN2Command command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	PssELIN2Validator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdatePssELIN2Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save PssELIN2 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeletePssELIN2Command
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeletePssELIN2Command command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PssELIN2Validator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeletePssELIN2Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete PssELIN2 using Id = "  + command.getPssELIN2Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the PssELIN2 via PssELIN2FetchOneSummary
     * @param 	summary PssELIN2FetchOneSummary 
     * @return 	PssELIN2FetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public PssELIN2 getPssELIN2( PssELIN2FetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "PssELIN2FetchOneSummary arg cannot be null" );
    	
    	PssELIN2 entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	PssELIN2Validator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a PssELIN2
        	// --------------------------------------
        	CompletableFuture<PssELIN2> futureEntity = queryGateway.query(new FindPssELIN2Query( new LoadPssELIN2Filter( summary.getPssELIN2Id() ) ), ResponseTypes.instanceOf(PssELIN2.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate PssELIN2 with id " + summary.getPssELIN2Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all PssELIN2s
     *
     * @return 	List<PssELIN2> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<PssELIN2> getAllPssELIN2() 
    throws ProcessingException {
        List<PssELIN2> list = null;

        try {
        	CompletableFuture<List<PssELIN2>> futureList = queryGateway.query(new FindAllPssELIN2Query(), ResponseTypes.multipleInstancesOf(PssELIN2.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all PssELIN2";
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
	 * @return		PssELIN2
	 */
	protected PssELIN2 load( UUID id ) throws ProcessingException {
		pssELIN2 = PssELIN2BusinessDelegate.getPssELIN2Instance().getPssELIN2( new PssELIN2FetchOneSummary(id) );	
		return pssELIN2;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private PssELIN2 pssELIN2 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(PssELIN2BusinessDelegate.class.getName());
    
}
