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
 * AnalogControl business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of AnalogControl related services in the case of a AnalogControl business related service failing.</li>
 * <li>Exposes a simpler, uniform AnalogControl interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill AnalogControl business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class AnalogControlBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public AnalogControlBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* AnalogControl Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	AnalogControlBusinessDelegate
	*/
	public static AnalogControlBusinessDelegate getAnalogControlInstance() {
		return( new AnalogControlBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createAnalogControl( CreateAnalogControlCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getAnalogControlId() == null )
				command.setAnalogControlId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	AnalogControlValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateAnalogControlCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateAnalogControlCommand of AnalogControl is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create AnalogControl - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateAnalogControlCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateAnalogControl( UpdateAnalogControlCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	AnalogControlValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateAnalogControlCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save AnalogControl - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteAnalogControlCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteAnalogControlCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	AnalogControlValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteAnalogControlCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete AnalogControl using Id = "  + command.getAnalogControlId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the AnalogControl via AnalogControlFetchOneSummary
     * @param 	summary AnalogControlFetchOneSummary 
     * @return 	AnalogControlFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public AnalogControl getAnalogControl( AnalogControlFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "AnalogControlFetchOneSummary arg cannot be null" );
    	
    	AnalogControl entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	AnalogControlValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a AnalogControl
        	// --------------------------------------
        	CompletableFuture<AnalogControl> futureEntity = queryGateway.query(new FindAnalogControlQuery( new LoadAnalogControlFilter( summary.getAnalogControlId() ) ), ResponseTypes.instanceOf(AnalogControl.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate AnalogControl with id " + summary.getAnalogControlId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all AnalogControls
     *
     * @return 	List<AnalogControl> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<AnalogControl> getAllAnalogControl() 
    throws ProcessingException {
        List<AnalogControl> list = null;

        try {
        	CompletableFuture<List<AnalogControl>> futureList = queryGateway.query(new FindAllAnalogControlQuery(), ResponseTypes.multipleInstancesOf(AnalogControl.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all AnalogControl";
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
	 * @return		AnalogControl
	 */
	protected AnalogControl load( UUID id ) throws ProcessingException {
		analogControl = AnalogControlBusinessDelegate.getAnalogControlInstance().getAnalogControl( new AnalogControlFetchOneSummary(id) );	
		return analogControl;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private AnalogControl analogControl 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(AnalogControlBusinessDelegate.class.getName());
    
}
