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
 * ResistancePerLength business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of ResistancePerLength related services in the case of a ResistancePerLength business related service failing.</li>
 * <li>Exposes a simpler, uniform ResistancePerLength interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill ResistancePerLength business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class ResistancePerLengthBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public ResistancePerLengthBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* ResistancePerLength Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	ResistancePerLengthBusinessDelegate
	*/
	public static ResistancePerLengthBusinessDelegate getResistancePerLengthInstance() {
		return( new ResistancePerLengthBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createResistancePerLength( CreateResistancePerLengthCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getResistancePerLengthId() == null )
				command.setResistancePerLengthId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ResistancePerLengthValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateResistancePerLengthCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateResistancePerLengthCommand of ResistancePerLength is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create ResistancePerLength - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateResistancePerLengthCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateResistancePerLength( UpdateResistancePerLengthCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	ResistancePerLengthValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateResistancePerLengthCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save ResistancePerLength - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteResistancePerLengthCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteResistancePerLengthCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ResistancePerLengthValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteResistancePerLengthCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete ResistancePerLength using Id = "  + command.getResistancePerLengthId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the ResistancePerLength via ResistancePerLengthFetchOneSummary
     * @param 	summary ResistancePerLengthFetchOneSummary 
     * @return 	ResistancePerLengthFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public ResistancePerLength getResistancePerLength( ResistancePerLengthFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "ResistancePerLengthFetchOneSummary arg cannot be null" );
    	
    	ResistancePerLength entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	ResistancePerLengthValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a ResistancePerLength
        	// --------------------------------------
        	CompletableFuture<ResistancePerLength> futureEntity = queryGateway.query(new FindResistancePerLengthQuery( new LoadResistancePerLengthFilter( summary.getResistancePerLengthId() ) ), ResponseTypes.instanceOf(ResistancePerLength.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate ResistancePerLength with id " + summary.getResistancePerLengthId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all ResistancePerLengths
     *
     * @return 	List<ResistancePerLength> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<ResistancePerLength> getAllResistancePerLength() 
    throws ProcessingException {
        List<ResistancePerLength> list = null;

        try {
        	CompletableFuture<List<ResistancePerLength>> futureList = queryGateway.query(new FindAllResistancePerLengthQuery(), ResponseTypes.multipleInstancesOf(ResistancePerLength.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all ResistancePerLength";
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
	 * @return		ResistancePerLength
	 */
	protected ResistancePerLength load( UUID id ) throws ProcessingException {
		resistancePerLength = ResistancePerLengthBusinessDelegate.getResistancePerLengthInstance().getResistancePerLength( new ResistancePerLengthFetchOneSummary(id) );	
		return resistancePerLength;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private ResistancePerLength resistancePerLength 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(ResistancePerLengthBusinessDelegate.class.getName());
    
}
