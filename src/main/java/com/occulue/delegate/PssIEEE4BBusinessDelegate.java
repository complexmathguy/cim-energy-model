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
 * PssIEEE4B business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of PssIEEE4B related services in the case of a PssIEEE4B business related service failing.</li>
 * <li>Exposes a simpler, uniform PssIEEE4B interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill PssIEEE4B business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class PssIEEE4BBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public PssIEEE4BBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* PssIEEE4B Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	PssIEEE4BBusinessDelegate
	*/
	public static PssIEEE4BBusinessDelegate getPssIEEE4BInstance() {
		return( new PssIEEE4BBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createPssIEEE4B( CreatePssIEEE4BCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getPssIEEE4BId() == null )
				command.setPssIEEE4BId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PssIEEE4BValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreatePssIEEE4BCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreatePssIEEE4BCommand of PssIEEE4B is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create PssIEEE4B - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdatePssIEEE4BCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updatePssIEEE4B( UpdatePssIEEE4BCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	PssIEEE4BValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdatePssIEEE4BCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save PssIEEE4B - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeletePssIEEE4BCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeletePssIEEE4BCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PssIEEE4BValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeletePssIEEE4BCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete PssIEEE4B using Id = "  + command.getPssIEEE4BId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the PssIEEE4B via PssIEEE4BFetchOneSummary
     * @param 	summary PssIEEE4BFetchOneSummary 
     * @return 	PssIEEE4BFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public PssIEEE4B getPssIEEE4B( PssIEEE4BFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "PssIEEE4BFetchOneSummary arg cannot be null" );
    	
    	PssIEEE4B entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	PssIEEE4BValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a PssIEEE4B
        	// --------------------------------------
        	CompletableFuture<PssIEEE4B> futureEntity = queryGateway.query(new FindPssIEEE4BQuery( new LoadPssIEEE4BFilter( summary.getPssIEEE4BId() ) ), ResponseTypes.instanceOf(PssIEEE4B.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate PssIEEE4B with id " + summary.getPssIEEE4BId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all PssIEEE4Bs
     *
     * @return 	List<PssIEEE4B> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<PssIEEE4B> getAllPssIEEE4B() 
    throws ProcessingException {
        List<PssIEEE4B> list = null;

        try {
        	CompletableFuture<List<PssIEEE4B>> futureList = queryGateway.query(new FindAllPssIEEE4BQuery(), ResponseTypes.multipleInstancesOf(PssIEEE4B.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all PssIEEE4B";
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
	 * @return		PssIEEE4B
	 */
	protected PssIEEE4B load( UUID id ) throws ProcessingException {
		pssIEEE4B = PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().getPssIEEE4B( new PssIEEE4BFetchOneSummary(id) );	
		return pssIEEE4B;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private PssIEEE4B pssIEEE4B 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(PssIEEE4BBusinessDelegate.class.getName());
    
}
