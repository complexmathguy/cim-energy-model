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
 * MeasurementValue business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of MeasurementValue related services in the case of a MeasurementValue business related service failing.</li>
 * <li>Exposes a simpler, uniform MeasurementValue interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill MeasurementValue business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class MeasurementValueBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public MeasurementValueBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* MeasurementValue Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	MeasurementValueBusinessDelegate
	*/
	public static MeasurementValueBusinessDelegate getMeasurementValueInstance() {
		return( new MeasurementValueBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createMeasurementValue( CreateMeasurementValueCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getMeasurementValueId() == null )
				command.setMeasurementValueId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	MeasurementValueValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateMeasurementValueCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateMeasurementValueCommand of MeasurementValue is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create MeasurementValue - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateMeasurementValueCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateMeasurementValue( UpdateMeasurementValueCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	MeasurementValueValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateMeasurementValueCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save MeasurementValue - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteMeasurementValueCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteMeasurementValueCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	MeasurementValueValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteMeasurementValueCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete MeasurementValue using Id = "  + command.getMeasurementValueId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the MeasurementValue via MeasurementValueFetchOneSummary
     * @param 	summary MeasurementValueFetchOneSummary 
     * @return 	MeasurementValueFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public MeasurementValue getMeasurementValue( MeasurementValueFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "MeasurementValueFetchOneSummary arg cannot be null" );
    	
    	MeasurementValue entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	MeasurementValueValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a MeasurementValue
        	// --------------------------------------
        	CompletableFuture<MeasurementValue> futureEntity = queryGateway.query(new FindMeasurementValueQuery( new LoadMeasurementValueFilter( summary.getMeasurementValueId() ) ), ResponseTypes.instanceOf(MeasurementValue.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate MeasurementValue with id " + summary.getMeasurementValueId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all MeasurementValues
     *
     * @return 	List<MeasurementValue> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<MeasurementValue> getAllMeasurementValue() 
    throws ProcessingException {
        List<MeasurementValue> list = null;

        try {
        	CompletableFuture<List<MeasurementValue>> futureList = queryGateway.query(new FindAllMeasurementValueQuery(), ResponseTypes.multipleInstancesOf(MeasurementValue.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all MeasurementValue";
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
	 * @return		MeasurementValue
	 */
	protected MeasurementValue load( UUID id ) throws ProcessingException {
		measurementValue = MeasurementValueBusinessDelegate.getMeasurementValueInstance().getMeasurementValue( new MeasurementValueFetchOneSummary(id) );	
		return measurementValue;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private MeasurementValue measurementValue 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(MeasurementValueBusinessDelegate.class.getName());
    
}
