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
 * InductancePerLength business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of InductancePerLength related services in the case of a InductancePerLength business related service failing.</li>
 * <li>Exposes a simpler, uniform InductancePerLength interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill InductancePerLength business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class InductancePerLengthBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public InductancePerLengthBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* InductancePerLength Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	InductancePerLengthBusinessDelegate
	*/
	public static InductancePerLengthBusinessDelegate getInductancePerLengthInstance() {
		return( new InductancePerLengthBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createInductancePerLength( CreateInductancePerLengthCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getInductancePerLengthId() == null )
				command.setInductancePerLengthId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	InductancePerLengthValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateInductancePerLengthCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateInductancePerLengthCommand of InductancePerLength is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create InductancePerLength - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateInductancePerLengthCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateInductancePerLength( UpdateInductancePerLengthCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	InductancePerLengthValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateInductancePerLengthCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save InductancePerLength - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteInductancePerLengthCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteInductancePerLengthCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	InductancePerLengthValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteInductancePerLengthCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete InductancePerLength using Id = "  + command.getInductancePerLengthId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the InductancePerLength via InductancePerLengthFetchOneSummary
     * @param 	summary InductancePerLengthFetchOneSummary 
     * @return 	InductancePerLengthFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public InductancePerLength getInductancePerLength( InductancePerLengthFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "InductancePerLengthFetchOneSummary arg cannot be null" );
    	
    	InductancePerLength entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	InductancePerLengthValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a InductancePerLength
        	// --------------------------------------
        	CompletableFuture<InductancePerLength> futureEntity = queryGateway.query(new FindInductancePerLengthQuery( new LoadInductancePerLengthFilter( summary.getInductancePerLengthId() ) ), ResponseTypes.instanceOf(InductancePerLength.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate InductancePerLength with id " + summary.getInductancePerLengthId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all InductancePerLengths
     *
     * @return 	List<InductancePerLength> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<InductancePerLength> getAllInductancePerLength() 
    throws ProcessingException {
        List<InductancePerLength> list = null;

        try {
        	CompletableFuture<List<InductancePerLength>> futureList = queryGateway.query(new FindAllInductancePerLengthQuery(), ResponseTypes.multipleInstancesOf(InductancePerLength.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all InductancePerLength";
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
	 * @return		InductancePerLength
	 */
	protected InductancePerLength load( UUID id ) throws ProcessingException {
		inductancePerLength = InductancePerLengthBusinessDelegate.getInductancePerLengthInstance().getInductancePerLength( new InductancePerLengthFetchOneSummary(id) );	
		return inductancePerLength;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private InductancePerLength inductancePerLength 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(InductancePerLengthBusinessDelegate.class.getName());
    
}
