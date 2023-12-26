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
 * GeographicalRegion business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of GeographicalRegion related services in the case of a GeographicalRegion business related service failing.</li>
 * <li>Exposes a simpler, uniform GeographicalRegion interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill GeographicalRegion business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class GeographicalRegionBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public GeographicalRegionBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* GeographicalRegion Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	GeographicalRegionBusinessDelegate
	*/
	public static GeographicalRegionBusinessDelegate getGeographicalRegionInstance() {
		return( new GeographicalRegionBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createGeographicalRegion( CreateGeographicalRegionCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getGeographicalRegionId() == null )
				command.setGeographicalRegionId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GeographicalRegionValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateGeographicalRegionCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateGeographicalRegionCommand of GeographicalRegion is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create GeographicalRegion - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateGeographicalRegionCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateGeographicalRegion( UpdateGeographicalRegionCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	GeographicalRegionValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateGeographicalRegionCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save GeographicalRegion - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteGeographicalRegionCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteGeographicalRegionCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GeographicalRegionValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteGeographicalRegionCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete GeographicalRegion using Id = "  + command.getGeographicalRegionId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the GeographicalRegion via GeographicalRegionFetchOneSummary
     * @param 	summary GeographicalRegionFetchOneSummary 
     * @return 	GeographicalRegionFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public GeographicalRegion getGeographicalRegion( GeographicalRegionFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "GeographicalRegionFetchOneSummary arg cannot be null" );
    	
    	GeographicalRegion entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	GeographicalRegionValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a GeographicalRegion
        	// --------------------------------------
        	CompletableFuture<GeographicalRegion> futureEntity = queryGateway.query(new FindGeographicalRegionQuery( new LoadGeographicalRegionFilter( summary.getGeographicalRegionId() ) ), ResponseTypes.instanceOf(GeographicalRegion.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate GeographicalRegion with id " + summary.getGeographicalRegionId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all GeographicalRegions
     *
     * @return 	List<GeographicalRegion> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<GeographicalRegion> getAllGeographicalRegion() 
    throws ProcessingException {
        List<GeographicalRegion> list = null;

        try {
        	CompletableFuture<List<GeographicalRegion>> futureList = queryGateway.query(new FindAllGeographicalRegionQuery(), ResponseTypes.multipleInstancesOf(GeographicalRegion.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all GeographicalRegion";
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
	 * @return		GeographicalRegion
	 */
	protected GeographicalRegion load( UUID id ) throws ProcessingException {
		geographicalRegion = GeographicalRegionBusinessDelegate.getGeographicalRegionInstance().getGeographicalRegion( new GeographicalRegionFetchOneSummary(id) );	
		return geographicalRegion;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private GeographicalRegion geographicalRegion 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(GeographicalRegionBusinessDelegate.class.getName());
    
}
