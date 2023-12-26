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
 * MeasurementValueSource business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of MeasurementValueSource related services in the case of a MeasurementValueSource business related service failing.</li>
 * <li>Exposes a simpler, uniform MeasurementValueSource interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill MeasurementValueSource business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class MeasurementValueSourceBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public MeasurementValueSourceBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* MeasurementValueSource Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	MeasurementValueSourceBusinessDelegate
	*/
	public static MeasurementValueSourceBusinessDelegate getMeasurementValueSourceInstance() {
		return( new MeasurementValueSourceBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createMeasurementValueSource( CreateMeasurementValueSourceCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getMeasurementValueSourceId() == null )
				command.setMeasurementValueSourceId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	MeasurementValueSourceValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateMeasurementValueSourceCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateMeasurementValueSourceCommand of MeasurementValueSource is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create MeasurementValueSource - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateMeasurementValueSourceCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateMeasurementValueSource( UpdateMeasurementValueSourceCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	MeasurementValueSourceValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateMeasurementValueSourceCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save MeasurementValueSource - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteMeasurementValueSourceCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteMeasurementValueSourceCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	MeasurementValueSourceValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteMeasurementValueSourceCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete MeasurementValueSource using Id = "  + command.getMeasurementValueSourceId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the MeasurementValueSource via MeasurementValueSourceFetchOneSummary
     * @param 	summary MeasurementValueSourceFetchOneSummary 
     * @return 	MeasurementValueSourceFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public MeasurementValueSource getMeasurementValueSource( MeasurementValueSourceFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "MeasurementValueSourceFetchOneSummary arg cannot be null" );
    	
    	MeasurementValueSource entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	MeasurementValueSourceValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a MeasurementValueSource
        	// --------------------------------------
        	CompletableFuture<MeasurementValueSource> futureEntity = queryGateway.query(new FindMeasurementValueSourceQuery( new LoadMeasurementValueSourceFilter( summary.getMeasurementValueSourceId() ) ), ResponseTypes.instanceOf(MeasurementValueSource.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate MeasurementValueSource with id " + summary.getMeasurementValueSourceId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all MeasurementValueSources
     *
     * @return 	List<MeasurementValueSource> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<MeasurementValueSource> getAllMeasurementValueSource() 
    throws ProcessingException {
        List<MeasurementValueSource> list = null;

        try {
        	CompletableFuture<List<MeasurementValueSource>> futureList = queryGateway.query(new FindAllMeasurementValueSourceQuery(), ResponseTypes.multipleInstancesOf(MeasurementValueSource.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all MeasurementValueSource";
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
	 * @return		MeasurementValueSource
	 */
	protected MeasurementValueSource load( UUID id ) throws ProcessingException {
		measurementValueSource = MeasurementValueSourceBusinessDelegate.getMeasurementValueSourceInstance().getMeasurementValueSource( new MeasurementValueSourceFetchOneSummary(id) );	
		return measurementValueSource;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private MeasurementValueSource measurementValueSource 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(MeasurementValueSourceBusinessDelegate.class.getName());
    
}
