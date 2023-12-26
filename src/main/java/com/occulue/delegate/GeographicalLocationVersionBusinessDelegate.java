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
 * GeographicalLocationVersion business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of GeographicalLocationVersion related services in the case of a GeographicalLocationVersion business related service failing.</li>
 * <li>Exposes a simpler, uniform GeographicalLocationVersion interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill GeographicalLocationVersion business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class GeographicalLocationVersionBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public GeographicalLocationVersionBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* GeographicalLocationVersion Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	GeographicalLocationVersionBusinessDelegate
	*/
	public static GeographicalLocationVersionBusinessDelegate getGeographicalLocationVersionInstance() {
		return( new GeographicalLocationVersionBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createGeographicalLocationVersion( CreateGeographicalLocationVersionCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getGeographicalLocationVersionId() == null )
				command.setGeographicalLocationVersionId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GeographicalLocationVersionValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateGeographicalLocationVersionCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateGeographicalLocationVersionCommand of GeographicalLocationVersion is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create GeographicalLocationVersion - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateGeographicalLocationVersionCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateGeographicalLocationVersion( UpdateGeographicalLocationVersionCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	GeographicalLocationVersionValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateGeographicalLocationVersionCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save GeographicalLocationVersion - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteGeographicalLocationVersionCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteGeographicalLocationVersionCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GeographicalLocationVersionValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteGeographicalLocationVersionCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete GeographicalLocationVersion using Id = "  + command.getGeographicalLocationVersionId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the GeographicalLocationVersion via GeographicalLocationVersionFetchOneSummary
     * @param 	summary GeographicalLocationVersionFetchOneSummary 
     * @return 	GeographicalLocationVersionFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public GeographicalLocationVersion getGeographicalLocationVersion( GeographicalLocationVersionFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "GeographicalLocationVersionFetchOneSummary arg cannot be null" );
    	
    	GeographicalLocationVersion entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	GeographicalLocationVersionValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a GeographicalLocationVersion
        	// --------------------------------------
        	CompletableFuture<GeographicalLocationVersion> futureEntity = queryGateway.query(new FindGeographicalLocationVersionQuery( new LoadGeographicalLocationVersionFilter( summary.getGeographicalLocationVersionId() ) ), ResponseTypes.instanceOf(GeographicalLocationVersion.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate GeographicalLocationVersion with id " + summary.getGeographicalLocationVersionId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all GeographicalLocationVersions
     *
     * @return 	List<GeographicalLocationVersion> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<GeographicalLocationVersion> getAllGeographicalLocationVersion() 
    throws ProcessingException {
        List<GeographicalLocationVersion> list = null;

        try {
        	CompletableFuture<List<GeographicalLocationVersion>> futureList = queryGateway.query(new FindAllGeographicalLocationVersionQuery(), ResponseTypes.multipleInstancesOf(GeographicalLocationVersion.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all GeographicalLocationVersion";
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
	 * @return		GeographicalLocationVersion
	 */
	protected GeographicalLocationVersion load( UUID id ) throws ProcessingException {
		geographicalLocationVersion = GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance().getGeographicalLocationVersion( new GeographicalLocationVersionFetchOneSummary(id) );	
		return geographicalLocationVersion;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private GeographicalLocationVersion geographicalLocationVersion 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(GeographicalLocationVersionBusinessDelegate.class.getName());
    
}
