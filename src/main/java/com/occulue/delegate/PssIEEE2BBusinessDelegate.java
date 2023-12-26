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
 * PssIEEE2B business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of PssIEEE2B related services in the case of a PssIEEE2B business related service failing.</li>
 * <li>Exposes a simpler, uniform PssIEEE2B interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill PssIEEE2B business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class PssIEEE2BBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public PssIEEE2BBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* PssIEEE2B Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	PssIEEE2BBusinessDelegate
	*/
	public static PssIEEE2BBusinessDelegate getPssIEEE2BInstance() {
		return( new PssIEEE2BBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createPssIEEE2B( CreatePssIEEE2BCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getPssIEEE2BId() == null )
				command.setPssIEEE2BId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PssIEEE2BValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreatePssIEEE2BCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreatePssIEEE2BCommand of PssIEEE2B is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create PssIEEE2B - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdatePssIEEE2BCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updatePssIEEE2B( UpdatePssIEEE2BCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	PssIEEE2BValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdatePssIEEE2BCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save PssIEEE2B - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeletePssIEEE2BCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeletePssIEEE2BCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PssIEEE2BValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeletePssIEEE2BCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete PssIEEE2B using Id = "  + command.getPssIEEE2BId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the PssIEEE2B via PssIEEE2BFetchOneSummary
     * @param 	summary PssIEEE2BFetchOneSummary 
     * @return 	PssIEEE2BFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public PssIEEE2B getPssIEEE2B( PssIEEE2BFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "PssIEEE2BFetchOneSummary arg cannot be null" );
    	
    	PssIEEE2B entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	PssIEEE2BValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a PssIEEE2B
        	// --------------------------------------
        	CompletableFuture<PssIEEE2B> futureEntity = queryGateway.query(new FindPssIEEE2BQuery( new LoadPssIEEE2BFilter( summary.getPssIEEE2BId() ) ), ResponseTypes.instanceOf(PssIEEE2B.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate PssIEEE2B with id " + summary.getPssIEEE2BId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all PssIEEE2Bs
     *
     * @return 	List<PssIEEE2B> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<PssIEEE2B> getAllPssIEEE2B() 
    throws ProcessingException {
        List<PssIEEE2B> list = null;

        try {
        	CompletableFuture<List<PssIEEE2B>> futureList = queryGateway.query(new FindAllPssIEEE2BQuery(), ResponseTypes.multipleInstancesOf(PssIEEE2B.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all PssIEEE2B";
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
	 * @return		PssIEEE2B
	 */
	protected PssIEEE2B load( UUID id ) throws ProcessingException {
		pssIEEE2B = PssIEEE2BBusinessDelegate.getPssIEEE2BInstance().getPssIEEE2B( new PssIEEE2BFetchOneSummary(id) );	
		return pssIEEE2B;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private PssIEEE2B pssIEEE2B 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(PssIEEE2BBusinessDelegate.class.getName());
    
}
