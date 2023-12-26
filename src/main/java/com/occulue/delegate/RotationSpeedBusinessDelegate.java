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
 * RotationSpeed business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of RotationSpeed related services in the case of a RotationSpeed business related service failing.</li>
 * <li>Exposes a simpler, uniform RotationSpeed interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill RotationSpeed business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class RotationSpeedBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public RotationSpeedBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* RotationSpeed Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	RotationSpeedBusinessDelegate
	*/
	public static RotationSpeedBusinessDelegate getRotationSpeedInstance() {
		return( new RotationSpeedBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createRotationSpeed( CreateRotationSpeedCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getRotationSpeedId() == null )
				command.setRotationSpeedId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	RotationSpeedValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateRotationSpeedCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateRotationSpeedCommand of RotationSpeed is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create RotationSpeed - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateRotationSpeedCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateRotationSpeed( UpdateRotationSpeedCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	RotationSpeedValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateRotationSpeedCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save RotationSpeed - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteRotationSpeedCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteRotationSpeedCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	RotationSpeedValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteRotationSpeedCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete RotationSpeed using Id = "  + command.getRotationSpeedId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the RotationSpeed via RotationSpeedFetchOneSummary
     * @param 	summary RotationSpeedFetchOneSummary 
     * @return 	RotationSpeedFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public RotationSpeed getRotationSpeed( RotationSpeedFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "RotationSpeedFetchOneSummary arg cannot be null" );
    	
    	RotationSpeed entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	RotationSpeedValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a RotationSpeed
        	// --------------------------------------
        	CompletableFuture<RotationSpeed> futureEntity = queryGateway.query(new FindRotationSpeedQuery( new LoadRotationSpeedFilter( summary.getRotationSpeedId() ) ), ResponseTypes.instanceOf(RotationSpeed.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate RotationSpeed with id " + summary.getRotationSpeedId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all RotationSpeeds
     *
     * @return 	List<RotationSpeed> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<RotationSpeed> getAllRotationSpeed() 
    throws ProcessingException {
        List<RotationSpeed> list = null;

        try {
        	CompletableFuture<List<RotationSpeed>> futureList = queryGateway.query(new FindAllRotationSpeedQuery(), ResponseTypes.multipleInstancesOf(RotationSpeed.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all RotationSpeed";
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
	 * @return		RotationSpeed
	 */
	protected RotationSpeed load( UUID id ) throws ProcessingException {
		rotationSpeed = RotationSpeedBusinessDelegate.getRotationSpeedInstance().getRotationSpeed( new RotationSpeedFetchOneSummary(id) );	
		return rotationSpeed;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private RotationSpeed rotationSpeed 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(RotationSpeedBusinessDelegate.class.getName());
    
}
