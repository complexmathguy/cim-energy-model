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
 * UnderexcLimIEEE1 business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of UnderexcLimIEEE1 related services in the case of a UnderexcLimIEEE1 business related service failing.</li>
 * <li>Exposes a simpler, uniform UnderexcLimIEEE1 interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill UnderexcLimIEEE1 business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class UnderexcLimIEEE1BusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public UnderexcLimIEEE1BusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* UnderexcLimIEEE1 Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	UnderexcLimIEEE1BusinessDelegate
	*/
	public static UnderexcLimIEEE1BusinessDelegate getUnderexcLimIEEE1Instance() {
		return( new UnderexcLimIEEE1BusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createUnderexcLimIEEE1( CreateUnderexcLimIEEE1Command command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getUnderexcLimIEEE1Id() == null )
				command.setUnderexcLimIEEE1Id( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	UnderexcLimIEEE1Validator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateUnderexcLimIEEE1Command - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateUnderexcLimIEEE1Command of UnderexcLimIEEE1 is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create UnderexcLimIEEE1 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateUnderexcLimIEEE1Command
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateUnderexcLimIEEE1( UpdateUnderexcLimIEEE1Command command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	UnderexcLimIEEE1Validator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateUnderexcLimIEEE1Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save UnderexcLimIEEE1 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteUnderexcLimIEEE1Command
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteUnderexcLimIEEE1Command command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	UnderexcLimIEEE1Validator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteUnderexcLimIEEE1Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete UnderexcLimIEEE1 using Id = "  + command.getUnderexcLimIEEE1Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the UnderexcLimIEEE1 via UnderexcLimIEEE1FetchOneSummary
     * @param 	summary UnderexcLimIEEE1FetchOneSummary 
     * @return 	UnderexcLimIEEE1FetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public UnderexcLimIEEE1 getUnderexcLimIEEE1( UnderexcLimIEEE1FetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "UnderexcLimIEEE1FetchOneSummary arg cannot be null" );
    	
    	UnderexcLimIEEE1 entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	UnderexcLimIEEE1Validator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a UnderexcLimIEEE1
        	// --------------------------------------
        	CompletableFuture<UnderexcLimIEEE1> futureEntity = queryGateway.query(new FindUnderexcLimIEEE1Query( new LoadUnderexcLimIEEE1Filter( summary.getUnderexcLimIEEE1Id() ) ), ResponseTypes.instanceOf(UnderexcLimIEEE1.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate UnderexcLimIEEE1 with id " + summary.getUnderexcLimIEEE1Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all UnderexcLimIEEE1s
     *
     * @return 	List<UnderexcLimIEEE1> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<UnderexcLimIEEE1> getAllUnderexcLimIEEE1() 
    throws ProcessingException {
        List<UnderexcLimIEEE1> list = null;

        try {
        	CompletableFuture<List<UnderexcLimIEEE1>> futureList = queryGateway.query(new FindAllUnderexcLimIEEE1Query(), ResponseTypes.multipleInstancesOf(UnderexcLimIEEE1.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all UnderexcLimIEEE1";
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
	 * @return		UnderexcLimIEEE1
	 */
	protected UnderexcLimIEEE1 load( UUID id ) throws ProcessingException {
		underexcLimIEEE1 = UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().getUnderexcLimIEEE1( new UnderexcLimIEEE1FetchOneSummary(id) );	
		return underexcLimIEEE1;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private UnderexcLimIEEE1 underexcLimIEEE1 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(UnderexcLimIEEE1BusinessDelegate.class.getName());
    
}
