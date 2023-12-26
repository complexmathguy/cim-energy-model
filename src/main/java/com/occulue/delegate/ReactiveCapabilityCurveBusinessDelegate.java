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
 * ReactiveCapabilityCurve business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of ReactiveCapabilityCurve related services in the case of a ReactiveCapabilityCurve business related service failing.</li>
 * <li>Exposes a simpler, uniform ReactiveCapabilityCurve interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill ReactiveCapabilityCurve business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class ReactiveCapabilityCurveBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public ReactiveCapabilityCurveBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* ReactiveCapabilityCurve Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	ReactiveCapabilityCurveBusinessDelegate
	*/
	public static ReactiveCapabilityCurveBusinessDelegate getReactiveCapabilityCurveInstance() {
		return( new ReactiveCapabilityCurveBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createReactiveCapabilityCurve( CreateReactiveCapabilityCurveCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getReactiveCapabilityCurveId() == null )
				command.setReactiveCapabilityCurveId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ReactiveCapabilityCurveValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateReactiveCapabilityCurveCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateReactiveCapabilityCurveCommand of ReactiveCapabilityCurve is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create ReactiveCapabilityCurve - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateReactiveCapabilityCurveCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateReactiveCapabilityCurve( UpdateReactiveCapabilityCurveCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	ReactiveCapabilityCurveValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateReactiveCapabilityCurveCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save ReactiveCapabilityCurve - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteReactiveCapabilityCurveCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteReactiveCapabilityCurveCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ReactiveCapabilityCurveValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteReactiveCapabilityCurveCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete ReactiveCapabilityCurve using Id = "  + command.getReactiveCapabilityCurveId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the ReactiveCapabilityCurve via ReactiveCapabilityCurveFetchOneSummary
     * @param 	summary ReactiveCapabilityCurveFetchOneSummary 
     * @return 	ReactiveCapabilityCurveFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public ReactiveCapabilityCurve getReactiveCapabilityCurve( ReactiveCapabilityCurveFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "ReactiveCapabilityCurveFetchOneSummary arg cannot be null" );
    	
    	ReactiveCapabilityCurve entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	ReactiveCapabilityCurveValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a ReactiveCapabilityCurve
        	// --------------------------------------
        	CompletableFuture<ReactiveCapabilityCurve> futureEntity = queryGateway.query(new FindReactiveCapabilityCurveQuery( new LoadReactiveCapabilityCurveFilter( summary.getReactiveCapabilityCurveId() ) ), ResponseTypes.instanceOf(ReactiveCapabilityCurve.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate ReactiveCapabilityCurve with id " + summary.getReactiveCapabilityCurveId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all ReactiveCapabilityCurves
     *
     * @return 	List<ReactiveCapabilityCurve> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<ReactiveCapabilityCurve> getAllReactiveCapabilityCurve() 
    throws ProcessingException {
        List<ReactiveCapabilityCurve> list = null;

        try {
        	CompletableFuture<List<ReactiveCapabilityCurve>> futureList = queryGateway.query(new FindAllReactiveCapabilityCurveQuery(), ResponseTypes.multipleInstancesOf(ReactiveCapabilityCurve.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all ReactiveCapabilityCurve";
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
	 * @return		ReactiveCapabilityCurve
	 */
	protected ReactiveCapabilityCurve load( UUID id ) throws ProcessingException {
		reactiveCapabilityCurve = ReactiveCapabilityCurveBusinessDelegate.getReactiveCapabilityCurveInstance().getReactiveCapabilityCurve( new ReactiveCapabilityCurveFetchOneSummary(id) );	
		return reactiveCapabilityCurve;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private ReactiveCapabilityCurve reactiveCapabilityCurve 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(ReactiveCapabilityCurveBusinessDelegate.class.getName());
    
}
