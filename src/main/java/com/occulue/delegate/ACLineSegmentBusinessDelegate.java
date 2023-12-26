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
 * ACLineSegment business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of ACLineSegment related services in the case of a ACLineSegment business related service failing.</li>
 * <li>Exposes a simpler, uniform ACLineSegment interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill ACLineSegment business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class ACLineSegmentBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public ACLineSegmentBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* ACLineSegment Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	ACLineSegmentBusinessDelegate
	*/
	public static ACLineSegmentBusinessDelegate getACLineSegmentInstance() {
		return( new ACLineSegmentBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createACLineSegment( CreateACLineSegmentCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getACLineSegmentId() == null )
				command.setACLineSegmentId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ACLineSegmentValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateACLineSegmentCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateACLineSegmentCommand of ACLineSegment is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create ACLineSegment - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateACLineSegmentCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateACLineSegment( UpdateACLineSegmentCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	ACLineSegmentValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateACLineSegmentCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save ACLineSegment - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteACLineSegmentCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteACLineSegmentCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ACLineSegmentValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteACLineSegmentCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete ACLineSegment using Id = "  + command.getACLineSegmentId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the ACLineSegment via ACLineSegmentFetchOneSummary
     * @param 	summary ACLineSegmentFetchOneSummary 
     * @return 	ACLineSegmentFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public ACLineSegment getACLineSegment( ACLineSegmentFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "ACLineSegmentFetchOneSummary arg cannot be null" );
    	
    	ACLineSegment entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	ACLineSegmentValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a ACLineSegment
        	// --------------------------------------
        	CompletableFuture<ACLineSegment> futureEntity = queryGateway.query(new FindACLineSegmentQuery( new LoadACLineSegmentFilter( summary.getACLineSegmentId() ) ), ResponseTypes.instanceOf(ACLineSegment.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate ACLineSegment with id " + summary.getACLineSegmentId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all ACLineSegments
     *
     * @return 	List<ACLineSegment> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<ACLineSegment> getAllACLineSegment() 
    throws ProcessingException {
        List<ACLineSegment> list = null;

        try {
        	CompletableFuture<List<ACLineSegment>> futureList = queryGateway.query(new FindAllACLineSegmentQuery(), ResponseTypes.multipleInstancesOf(ACLineSegment.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all ACLineSegment";
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
	 * @return		ACLineSegment
	 */
	protected ACLineSegment load( UUID id ) throws ProcessingException {
		aCLineSegment = ACLineSegmentBusinessDelegate.getACLineSegmentInstance().getACLineSegment( new ACLineSegmentFetchOneSummary(id) );	
		return aCLineSegment;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private ACLineSegment aCLineSegment 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(ACLineSegmentBusinessDelegate.class.getName());
    
}
