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
 * SteadyStateHypothesisVersion business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of SteadyStateHypothesisVersion related services in the case of a SteadyStateHypothesisVersion business related service failing.</li>
 * <li>Exposes a simpler, uniform SteadyStateHypothesisVersion interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill SteadyStateHypothesisVersion business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class SteadyStateHypothesisVersionBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public SteadyStateHypothesisVersionBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* SteadyStateHypothesisVersion Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	SteadyStateHypothesisVersionBusinessDelegate
	*/
	public static SteadyStateHypothesisVersionBusinessDelegate getSteadyStateHypothesisVersionInstance() {
		return( new SteadyStateHypothesisVersionBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createSteadyStateHypothesisVersion( CreateSteadyStateHypothesisVersionCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getSteadyStateHypothesisVersionId() == null )
				command.setSteadyStateHypothesisVersionId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	SteadyStateHypothesisVersionValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateSteadyStateHypothesisVersionCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateSteadyStateHypothesisVersionCommand of SteadyStateHypothesisVersion is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create SteadyStateHypothesisVersion - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateSteadyStateHypothesisVersionCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateSteadyStateHypothesisVersion( UpdateSteadyStateHypothesisVersionCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	SteadyStateHypothesisVersionValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateSteadyStateHypothesisVersionCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save SteadyStateHypothesisVersion - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteSteadyStateHypothesisVersionCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteSteadyStateHypothesisVersionCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	SteadyStateHypothesisVersionValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteSteadyStateHypothesisVersionCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete SteadyStateHypothesisVersion using Id = "  + command.getSteadyStateHypothesisVersionId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the SteadyStateHypothesisVersion via SteadyStateHypothesisVersionFetchOneSummary
     * @param 	summary SteadyStateHypothesisVersionFetchOneSummary 
     * @return 	SteadyStateHypothesisVersionFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public SteadyStateHypothesisVersion getSteadyStateHypothesisVersion( SteadyStateHypothesisVersionFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "SteadyStateHypothesisVersionFetchOneSummary arg cannot be null" );
    	
    	SteadyStateHypothesisVersion entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	SteadyStateHypothesisVersionValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a SteadyStateHypothesisVersion
        	// --------------------------------------
        	CompletableFuture<SteadyStateHypothesisVersion> futureEntity = queryGateway.query(new FindSteadyStateHypothesisVersionQuery( new LoadSteadyStateHypothesisVersionFilter( summary.getSteadyStateHypothesisVersionId() ) ), ResponseTypes.instanceOf(SteadyStateHypothesisVersion.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate SteadyStateHypothesisVersion with id " + summary.getSteadyStateHypothesisVersionId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all SteadyStateHypothesisVersions
     *
     * @return 	List<SteadyStateHypothesisVersion> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<SteadyStateHypothesisVersion> getAllSteadyStateHypothesisVersion() 
    throws ProcessingException {
        List<SteadyStateHypothesisVersion> list = null;

        try {
        	CompletableFuture<List<SteadyStateHypothesisVersion>> futureList = queryGateway.query(new FindAllSteadyStateHypothesisVersionQuery(), ResponseTypes.multipleInstancesOf(SteadyStateHypothesisVersion.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all SteadyStateHypothesisVersion";
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
	 * @return		SteadyStateHypothesisVersion
	 */
	protected SteadyStateHypothesisVersion load( UUID id ) throws ProcessingException {
		steadyStateHypothesisVersion = SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance().getSteadyStateHypothesisVersion( new SteadyStateHypothesisVersionFetchOneSummary(id) );	
		return steadyStateHypothesisVersion;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private SteadyStateHypothesisVersion steadyStateHypothesisVersion 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(SteadyStateHypothesisVersionBusinessDelegate.class.getName());
    
}
