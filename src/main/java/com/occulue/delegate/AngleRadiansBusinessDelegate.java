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
 * AngleRadians business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of AngleRadians related services in the case of a AngleRadians business related service failing.</li>
 * <li>Exposes a simpler, uniform AngleRadians interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill AngleRadians business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class AngleRadiansBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public AngleRadiansBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* AngleRadians Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	AngleRadiansBusinessDelegate
	*/
	public static AngleRadiansBusinessDelegate getAngleRadiansInstance() {
		return( new AngleRadiansBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createAngleRadians( CreateAngleRadiansCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getAngleRadiansId() == null )
				command.setAngleRadiansId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	AngleRadiansValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateAngleRadiansCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateAngleRadiansCommand of AngleRadians is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create AngleRadians - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateAngleRadiansCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateAngleRadians( UpdateAngleRadiansCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	AngleRadiansValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateAngleRadiansCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save AngleRadians - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteAngleRadiansCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteAngleRadiansCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	AngleRadiansValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteAngleRadiansCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete AngleRadians using Id = "  + command.getAngleRadiansId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the AngleRadians via AngleRadiansFetchOneSummary
     * @param 	summary AngleRadiansFetchOneSummary 
     * @return 	AngleRadiansFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public AngleRadians getAngleRadians( AngleRadiansFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "AngleRadiansFetchOneSummary arg cannot be null" );
    	
    	AngleRadians entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	AngleRadiansValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a AngleRadians
        	// --------------------------------------
        	CompletableFuture<AngleRadians> futureEntity = queryGateway.query(new FindAngleRadiansQuery( new LoadAngleRadiansFilter( summary.getAngleRadiansId() ) ), ResponseTypes.instanceOf(AngleRadians.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate AngleRadians with id " + summary.getAngleRadiansId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all AngleRadianss
     *
     * @return 	List<AngleRadians> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<AngleRadians> getAllAngleRadians() 
    throws ProcessingException {
        List<AngleRadians> list = null;

        try {
        	CompletableFuture<List<AngleRadians>> futureList = queryGateway.query(new FindAllAngleRadiansQuery(), ResponseTypes.multipleInstancesOf(AngleRadians.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all AngleRadians";
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
	 * @return		AngleRadians
	 */
	protected AngleRadians load( UUID id ) throws ProcessingException {
		angleRadians = AngleRadiansBusinessDelegate.getAngleRadiansInstance().getAngleRadians( new AngleRadiansFetchOneSummary(id) );	
		return angleRadians;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private AngleRadians angleRadians 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(AngleRadiansBusinessDelegate.class.getName());
    
}
