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
 * UnderexcLimIEEE2 business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of UnderexcLimIEEE2 related services in the case of a UnderexcLimIEEE2 business related service failing.</li>
 * <li>Exposes a simpler, uniform UnderexcLimIEEE2 interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill UnderexcLimIEEE2 business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class UnderexcLimIEEE2BusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public UnderexcLimIEEE2BusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* UnderexcLimIEEE2 Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	UnderexcLimIEEE2BusinessDelegate
	*/
	public static UnderexcLimIEEE2BusinessDelegate getUnderexcLimIEEE2Instance() {
		return( new UnderexcLimIEEE2BusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createUnderexcLimIEEE2( CreateUnderexcLimIEEE2Command command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getUnderexcLimIEEE2Id() == null )
				command.setUnderexcLimIEEE2Id( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	UnderexcLimIEEE2Validator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateUnderexcLimIEEE2Command - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateUnderexcLimIEEE2Command of UnderexcLimIEEE2 is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create UnderexcLimIEEE2 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateUnderexcLimIEEE2Command
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateUnderexcLimIEEE2( UpdateUnderexcLimIEEE2Command command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	UnderexcLimIEEE2Validator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateUnderexcLimIEEE2Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save UnderexcLimIEEE2 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteUnderexcLimIEEE2Command
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteUnderexcLimIEEE2Command command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	UnderexcLimIEEE2Validator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteUnderexcLimIEEE2Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete UnderexcLimIEEE2 using Id = "  + command.getUnderexcLimIEEE2Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the UnderexcLimIEEE2 via UnderexcLimIEEE2FetchOneSummary
     * @param 	summary UnderexcLimIEEE2FetchOneSummary 
     * @return 	UnderexcLimIEEE2FetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public UnderexcLimIEEE2 getUnderexcLimIEEE2( UnderexcLimIEEE2FetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "UnderexcLimIEEE2FetchOneSummary arg cannot be null" );
    	
    	UnderexcLimIEEE2 entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	UnderexcLimIEEE2Validator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a UnderexcLimIEEE2
        	// --------------------------------------
        	CompletableFuture<UnderexcLimIEEE2> futureEntity = queryGateway.query(new FindUnderexcLimIEEE2Query( new LoadUnderexcLimIEEE2Filter( summary.getUnderexcLimIEEE2Id() ) ), ResponseTypes.instanceOf(UnderexcLimIEEE2.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate UnderexcLimIEEE2 with id " + summary.getUnderexcLimIEEE2Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all UnderexcLimIEEE2s
     *
     * @return 	List<UnderexcLimIEEE2> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<UnderexcLimIEEE2> getAllUnderexcLimIEEE2() 
    throws ProcessingException {
        List<UnderexcLimIEEE2> list = null;

        try {
        	CompletableFuture<List<UnderexcLimIEEE2>> futureList = queryGateway.query(new FindAllUnderexcLimIEEE2Query(), ResponseTypes.multipleInstancesOf(UnderexcLimIEEE2.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all UnderexcLimIEEE2";
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
	 * @return		UnderexcLimIEEE2
	 */
	protected UnderexcLimIEEE2 load( UUID id ) throws ProcessingException {
		underexcLimIEEE2 = UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().getUnderexcLimIEEE2( new UnderexcLimIEEE2FetchOneSummary(id) );	
		return underexcLimIEEE2;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private UnderexcLimIEEE2 underexcLimIEEE2 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(UnderexcLimIEEE2BusinessDelegate.class.getName());
    
}
