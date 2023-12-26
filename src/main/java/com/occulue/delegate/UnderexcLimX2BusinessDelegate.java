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
 * UnderexcLimX2 business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of UnderexcLimX2 related services in the case of a UnderexcLimX2 business related service failing.</li>
 * <li>Exposes a simpler, uniform UnderexcLimX2 interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill UnderexcLimX2 business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class UnderexcLimX2BusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public UnderexcLimX2BusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* UnderexcLimX2 Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	UnderexcLimX2BusinessDelegate
	*/
	public static UnderexcLimX2BusinessDelegate getUnderexcLimX2Instance() {
		return( new UnderexcLimX2BusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createUnderexcLimX2( CreateUnderexcLimX2Command command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getUnderexcLimX2Id() == null )
				command.setUnderexcLimX2Id( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	UnderexcLimX2Validator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateUnderexcLimX2Command - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateUnderexcLimX2Command of UnderexcLimX2 is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create UnderexcLimX2 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateUnderexcLimX2Command
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateUnderexcLimX2( UpdateUnderexcLimX2Command command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	UnderexcLimX2Validator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateUnderexcLimX2Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save UnderexcLimX2 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteUnderexcLimX2Command
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteUnderexcLimX2Command command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	UnderexcLimX2Validator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteUnderexcLimX2Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete UnderexcLimX2 using Id = "  + command.getUnderexcLimX2Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the UnderexcLimX2 via UnderexcLimX2FetchOneSummary
     * @param 	summary UnderexcLimX2FetchOneSummary 
     * @return 	UnderexcLimX2FetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public UnderexcLimX2 getUnderexcLimX2( UnderexcLimX2FetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "UnderexcLimX2FetchOneSummary arg cannot be null" );
    	
    	UnderexcLimX2 entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	UnderexcLimX2Validator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a UnderexcLimX2
        	// --------------------------------------
        	CompletableFuture<UnderexcLimX2> futureEntity = queryGateway.query(new FindUnderexcLimX2Query( new LoadUnderexcLimX2Filter( summary.getUnderexcLimX2Id() ) ), ResponseTypes.instanceOf(UnderexcLimX2.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate UnderexcLimX2 with id " + summary.getUnderexcLimX2Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all UnderexcLimX2s
     *
     * @return 	List<UnderexcLimX2> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<UnderexcLimX2> getAllUnderexcLimX2() 
    throws ProcessingException {
        List<UnderexcLimX2> list = null;

        try {
        	CompletableFuture<List<UnderexcLimX2>> futureList = queryGateway.query(new FindAllUnderexcLimX2Query(), ResponseTypes.multipleInstancesOf(UnderexcLimX2.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all UnderexcLimX2";
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
	 * @return		UnderexcLimX2
	 */
	protected UnderexcLimX2 load( UUID id ) throws ProcessingException {
		underexcLimX2 = UnderexcLimX2BusinessDelegate.getUnderexcLimX2Instance().getUnderexcLimX2( new UnderexcLimX2FetchOneSummary(id) );	
		return underexcLimX2;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private UnderexcLimX2 underexcLimX2 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(UnderexcLimX2BusinessDelegate.class.getName());
    
}
