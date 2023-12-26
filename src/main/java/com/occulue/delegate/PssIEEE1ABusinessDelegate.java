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
 * PssIEEE1A business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of PssIEEE1A related services in the case of a PssIEEE1A business related service failing.</li>
 * <li>Exposes a simpler, uniform PssIEEE1A interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill PssIEEE1A business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class PssIEEE1ABusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public PssIEEE1ABusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* PssIEEE1A Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	PssIEEE1ABusinessDelegate
	*/
	public static PssIEEE1ABusinessDelegate getPssIEEE1AInstance() {
		return( new PssIEEE1ABusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createPssIEEE1A( CreatePssIEEE1ACommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getPssIEEE1AId() == null )
				command.setPssIEEE1AId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PssIEEE1AValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreatePssIEEE1ACommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreatePssIEEE1ACommand of PssIEEE1A is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create PssIEEE1A - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdatePssIEEE1ACommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updatePssIEEE1A( UpdatePssIEEE1ACommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	PssIEEE1AValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdatePssIEEE1ACommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save PssIEEE1A - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeletePssIEEE1ACommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeletePssIEEE1ACommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PssIEEE1AValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeletePssIEEE1ACommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete PssIEEE1A using Id = "  + command.getPssIEEE1AId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the PssIEEE1A via PssIEEE1AFetchOneSummary
     * @param 	summary PssIEEE1AFetchOneSummary 
     * @return 	PssIEEE1AFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public PssIEEE1A getPssIEEE1A( PssIEEE1AFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "PssIEEE1AFetchOneSummary arg cannot be null" );
    	
    	PssIEEE1A entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	PssIEEE1AValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a PssIEEE1A
        	// --------------------------------------
        	CompletableFuture<PssIEEE1A> futureEntity = queryGateway.query(new FindPssIEEE1AQuery( new LoadPssIEEE1AFilter( summary.getPssIEEE1AId() ) ), ResponseTypes.instanceOf(PssIEEE1A.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate PssIEEE1A with id " + summary.getPssIEEE1AId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all PssIEEE1As
     *
     * @return 	List<PssIEEE1A> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<PssIEEE1A> getAllPssIEEE1A() 
    throws ProcessingException {
        List<PssIEEE1A> list = null;

        try {
        	CompletableFuture<List<PssIEEE1A>> futureList = queryGateway.query(new FindAllPssIEEE1AQuery(), ResponseTypes.multipleInstancesOf(PssIEEE1A.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all PssIEEE1A";
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
	 * @return		PssIEEE1A
	 */
	protected PssIEEE1A load( UUID id ) throws ProcessingException {
		pssIEEE1A = PssIEEE1ABusinessDelegate.getPssIEEE1AInstance().getPssIEEE1A( new PssIEEE1AFetchOneSummary(id) );	
		return pssIEEE1A;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private PssIEEE1A pssIEEE1A 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(PssIEEE1ABusinessDelegate.class.getName());
    
}
