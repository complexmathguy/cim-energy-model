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
 * PssIEEE3B business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of PssIEEE3B related services in the case of a PssIEEE3B business related service failing.</li>
 * <li>Exposes a simpler, uniform PssIEEE3B interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill PssIEEE3B business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class PssIEEE3BBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public PssIEEE3BBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* PssIEEE3B Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	PssIEEE3BBusinessDelegate
	*/
	public static PssIEEE3BBusinessDelegate getPssIEEE3BInstance() {
		return( new PssIEEE3BBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createPssIEEE3B( CreatePssIEEE3BCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getPssIEEE3BId() == null )
				command.setPssIEEE3BId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PssIEEE3BValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreatePssIEEE3BCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreatePssIEEE3BCommand of PssIEEE3B is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create PssIEEE3B - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdatePssIEEE3BCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updatePssIEEE3B( UpdatePssIEEE3BCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	PssIEEE3BValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdatePssIEEE3BCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save PssIEEE3B - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeletePssIEEE3BCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeletePssIEEE3BCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PssIEEE3BValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeletePssIEEE3BCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete PssIEEE3B using Id = "  + command.getPssIEEE3BId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the PssIEEE3B via PssIEEE3BFetchOneSummary
     * @param 	summary PssIEEE3BFetchOneSummary 
     * @return 	PssIEEE3BFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public PssIEEE3B getPssIEEE3B( PssIEEE3BFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "PssIEEE3BFetchOneSummary arg cannot be null" );
    	
    	PssIEEE3B entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	PssIEEE3BValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a PssIEEE3B
        	// --------------------------------------
        	CompletableFuture<PssIEEE3B> futureEntity = queryGateway.query(new FindPssIEEE3BQuery( new LoadPssIEEE3BFilter( summary.getPssIEEE3BId() ) ), ResponseTypes.instanceOf(PssIEEE3B.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate PssIEEE3B with id " + summary.getPssIEEE3BId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all PssIEEE3Bs
     *
     * @return 	List<PssIEEE3B> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<PssIEEE3B> getAllPssIEEE3B() 
    throws ProcessingException {
        List<PssIEEE3B> list = null;

        try {
        	CompletableFuture<List<PssIEEE3B>> futureList = queryGateway.query(new FindAllPssIEEE3BQuery(), ResponseTypes.multipleInstancesOf(PssIEEE3B.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all PssIEEE3B";
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
	 * @return		PssIEEE3B
	 */
	protected PssIEEE3B load( UUID id ) throws ProcessingException {
		pssIEEE3B = PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().getPssIEEE3B( new PssIEEE3BFetchOneSummary(id) );	
		return pssIEEE3B;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private PssIEEE3B pssIEEE3B 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(PssIEEE3BBusinessDelegate.class.getName());
    
}
