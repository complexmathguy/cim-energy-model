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
 * MeasurementValueQuality business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of MeasurementValueQuality related services in the case of a MeasurementValueQuality business related service failing.</li>
 * <li>Exposes a simpler, uniform MeasurementValueQuality interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill MeasurementValueQuality business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class MeasurementValueQualityBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public MeasurementValueQualityBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* MeasurementValueQuality Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	MeasurementValueQualityBusinessDelegate
	*/
	public static MeasurementValueQualityBusinessDelegate getMeasurementValueQualityInstance() {
		return( new MeasurementValueQualityBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createMeasurementValueQuality( CreateMeasurementValueQualityCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getMeasurementValueQualityId() == null )
				command.setMeasurementValueQualityId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	MeasurementValueQualityValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateMeasurementValueQualityCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateMeasurementValueQualityCommand of MeasurementValueQuality is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create MeasurementValueQuality - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateMeasurementValueQualityCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateMeasurementValueQuality( UpdateMeasurementValueQualityCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	MeasurementValueQualityValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateMeasurementValueQualityCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save MeasurementValueQuality - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteMeasurementValueQualityCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteMeasurementValueQualityCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	MeasurementValueQualityValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteMeasurementValueQualityCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete MeasurementValueQuality using Id = "  + command.getMeasurementValueQualityId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the MeasurementValueQuality via MeasurementValueQualityFetchOneSummary
     * @param 	summary MeasurementValueQualityFetchOneSummary 
     * @return 	MeasurementValueQualityFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public MeasurementValueQuality getMeasurementValueQuality( MeasurementValueQualityFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "MeasurementValueQualityFetchOneSummary arg cannot be null" );
    	
    	MeasurementValueQuality entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	MeasurementValueQualityValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a MeasurementValueQuality
        	// --------------------------------------
        	CompletableFuture<MeasurementValueQuality> futureEntity = queryGateway.query(new FindMeasurementValueQualityQuery( new LoadMeasurementValueQualityFilter( summary.getMeasurementValueQualityId() ) ), ResponseTypes.instanceOf(MeasurementValueQuality.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate MeasurementValueQuality with id " + summary.getMeasurementValueQualityId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all MeasurementValueQualitys
     *
     * @return 	List<MeasurementValueQuality> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<MeasurementValueQuality> getAllMeasurementValueQuality() 
    throws ProcessingException {
        List<MeasurementValueQuality> list = null;

        try {
        	CompletableFuture<List<MeasurementValueQuality>> futureList = queryGateway.query(new FindAllMeasurementValueQualityQuery(), ResponseTypes.multipleInstancesOf(MeasurementValueQuality.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all MeasurementValueQuality";
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
	 * @return		MeasurementValueQuality
	 */
	protected MeasurementValueQuality load( UUID id ) throws ProcessingException {
		measurementValueQuality = MeasurementValueQualityBusinessDelegate.getMeasurementValueQualityInstance().getMeasurementValueQuality( new MeasurementValueQualityFetchOneSummary(id) );	
		return measurementValueQuality;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private MeasurementValueQuality measurementValueQuality 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(MeasurementValueQualityBusinessDelegate.class.getName());
    
}
