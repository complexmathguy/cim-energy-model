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
 * RegulatingControl business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of RegulatingControl related services in the case of a RegulatingControl business related service failing.</li>
 * <li>Exposes a simpler, uniform RegulatingControl interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill RegulatingControl business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class RegulatingControlBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public RegulatingControlBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* RegulatingControl Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	RegulatingControlBusinessDelegate
	*/
	public static RegulatingControlBusinessDelegate getRegulatingControlInstance() {
		return( new RegulatingControlBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createRegulatingControl( CreateRegulatingControlCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getRegulatingControlId() == null )
				command.setRegulatingControlId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	RegulatingControlValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateRegulatingControlCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateRegulatingControlCommand of RegulatingControl is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create RegulatingControl - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateRegulatingControlCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateRegulatingControl( UpdateRegulatingControlCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	RegulatingControlValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateRegulatingControlCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save RegulatingControl - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteRegulatingControlCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteRegulatingControlCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	RegulatingControlValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteRegulatingControlCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete RegulatingControl using Id = "  + command.getRegulatingControlId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the RegulatingControl via RegulatingControlFetchOneSummary
     * @param 	summary RegulatingControlFetchOneSummary 
     * @return 	RegulatingControlFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public RegulatingControl getRegulatingControl( RegulatingControlFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "RegulatingControlFetchOneSummary arg cannot be null" );
    	
    	RegulatingControl entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	RegulatingControlValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a RegulatingControl
        	// --------------------------------------
        	CompletableFuture<RegulatingControl> futureEntity = queryGateway.query(new FindRegulatingControlQuery( new LoadRegulatingControlFilter( summary.getRegulatingControlId() ) ), ResponseTypes.instanceOf(RegulatingControl.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate RegulatingControl with id " + summary.getRegulatingControlId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all RegulatingControls
     *
     * @return 	List<RegulatingControl> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<RegulatingControl> getAllRegulatingControl() 
    throws ProcessingException {
        List<RegulatingControl> list = null;

        try {
        	CompletableFuture<List<RegulatingControl>> futureList = queryGateway.query(new FindAllRegulatingControlQuery(), ResponseTypes.multipleInstancesOf(RegulatingControl.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all RegulatingControl";
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
	 * @return		RegulatingControl
	 */
	protected RegulatingControl load( UUID id ) throws ProcessingException {
		regulatingControl = RegulatingControlBusinessDelegate.getRegulatingControlInstance().getRegulatingControl( new RegulatingControlFetchOneSummary(id) );	
		return regulatingControl;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private RegulatingControl regulatingControl 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(RegulatingControlBusinessDelegate.class.getName());
    
}
