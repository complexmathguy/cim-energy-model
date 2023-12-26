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
 * TapChangerControl business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of TapChangerControl related services in the case of a TapChangerControl business related service failing.</li>
 * <li>Exposes a simpler, uniform TapChangerControl interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill TapChangerControl business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class TapChangerControlBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public TapChangerControlBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* TapChangerControl Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	TapChangerControlBusinessDelegate
	*/
	public static TapChangerControlBusinessDelegate getTapChangerControlInstance() {
		return( new TapChangerControlBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createTapChangerControl( CreateTapChangerControlCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getTapChangerControlId() == null )
				command.setTapChangerControlId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	TapChangerControlValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateTapChangerControlCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateTapChangerControlCommand of TapChangerControl is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create TapChangerControl - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateTapChangerControlCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateTapChangerControl( UpdateTapChangerControlCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	TapChangerControlValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateTapChangerControlCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save TapChangerControl - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteTapChangerControlCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteTapChangerControlCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	TapChangerControlValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteTapChangerControlCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete TapChangerControl using Id = "  + command.getTapChangerControlId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the TapChangerControl via TapChangerControlFetchOneSummary
     * @param 	summary TapChangerControlFetchOneSummary 
     * @return 	TapChangerControlFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public TapChangerControl getTapChangerControl( TapChangerControlFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "TapChangerControlFetchOneSummary arg cannot be null" );
    	
    	TapChangerControl entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	TapChangerControlValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a TapChangerControl
        	// --------------------------------------
        	CompletableFuture<TapChangerControl> futureEntity = queryGateway.query(new FindTapChangerControlQuery( new LoadTapChangerControlFilter( summary.getTapChangerControlId() ) ), ResponseTypes.instanceOf(TapChangerControl.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate TapChangerControl with id " + summary.getTapChangerControlId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all TapChangerControls
     *
     * @return 	List<TapChangerControl> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<TapChangerControl> getAllTapChangerControl() 
    throws ProcessingException {
        List<TapChangerControl> list = null;

        try {
        	CompletableFuture<List<TapChangerControl>> futureList = queryGateway.query(new FindAllTapChangerControlQuery(), ResponseTypes.multipleInstancesOf(TapChangerControl.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all TapChangerControl";
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
	 * @return		TapChangerControl
	 */
	protected TapChangerControl load( UUID id ) throws ProcessingException {
		tapChangerControl = TapChangerControlBusinessDelegate.getTapChangerControlInstance().getTapChangerControl( new TapChangerControlFetchOneSummary(id) );	
		return tapChangerControl;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private TapChangerControl tapChangerControl 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(TapChangerControlBusinessDelegate.class.getName());
    
}
