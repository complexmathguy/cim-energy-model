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
 * UnderexcLimX1 business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of UnderexcLimX1 related services in the case of a UnderexcLimX1 business related service failing.</li>
 * <li>Exposes a simpler, uniform UnderexcLimX1 interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill UnderexcLimX1 business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class UnderexcLimX1BusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public UnderexcLimX1BusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* UnderexcLimX1 Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	UnderexcLimX1BusinessDelegate
	*/
	public static UnderexcLimX1BusinessDelegate getUnderexcLimX1Instance() {
		return( new UnderexcLimX1BusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createUnderexcLimX1( CreateUnderexcLimX1Command command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getUnderexcLimX1Id() == null )
				command.setUnderexcLimX1Id( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	UnderexcLimX1Validator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateUnderexcLimX1Command - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateUnderexcLimX1Command of UnderexcLimX1 is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create UnderexcLimX1 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateUnderexcLimX1Command
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateUnderexcLimX1( UpdateUnderexcLimX1Command command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	UnderexcLimX1Validator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateUnderexcLimX1Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save UnderexcLimX1 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteUnderexcLimX1Command
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteUnderexcLimX1Command command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	UnderexcLimX1Validator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteUnderexcLimX1Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete UnderexcLimX1 using Id = "  + command.getUnderexcLimX1Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the UnderexcLimX1 via UnderexcLimX1FetchOneSummary
     * @param 	summary UnderexcLimX1FetchOneSummary 
     * @return 	UnderexcLimX1FetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public UnderexcLimX1 getUnderexcLimX1( UnderexcLimX1FetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "UnderexcLimX1FetchOneSummary arg cannot be null" );
    	
    	UnderexcLimX1 entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	UnderexcLimX1Validator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a UnderexcLimX1
        	// --------------------------------------
        	CompletableFuture<UnderexcLimX1> futureEntity = queryGateway.query(new FindUnderexcLimX1Query( new LoadUnderexcLimX1Filter( summary.getUnderexcLimX1Id() ) ), ResponseTypes.instanceOf(UnderexcLimX1.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate UnderexcLimX1 with id " + summary.getUnderexcLimX1Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all UnderexcLimX1s
     *
     * @return 	List<UnderexcLimX1> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<UnderexcLimX1> getAllUnderexcLimX1() 
    throws ProcessingException {
        List<UnderexcLimX1> list = null;

        try {
        	CompletableFuture<List<UnderexcLimX1>> futureList = queryGateway.query(new FindAllUnderexcLimX1Query(), ResponseTypes.multipleInstancesOf(UnderexcLimX1.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all UnderexcLimX1";
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
	 * @return		UnderexcLimX1
	 */
	protected UnderexcLimX1 load( UUID id ) throws ProcessingException {
		underexcLimX1 = UnderexcLimX1BusinessDelegate.getUnderexcLimX1Instance().getUnderexcLimX1( new UnderexcLimX1FetchOneSummary(id) );	
		return underexcLimX1;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private UnderexcLimX1 underexcLimX1 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(UnderexcLimX1BusinessDelegate.class.getName());
    
}
