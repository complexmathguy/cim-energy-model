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
 * RatioTapChanger business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of RatioTapChanger related services in the case of a RatioTapChanger business related service failing.</li>
 * <li>Exposes a simpler, uniform RatioTapChanger interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill RatioTapChanger business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class RatioTapChangerBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public RatioTapChangerBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* RatioTapChanger Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	RatioTapChangerBusinessDelegate
	*/
	public static RatioTapChangerBusinessDelegate getRatioTapChangerInstance() {
		return( new RatioTapChangerBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createRatioTapChanger( CreateRatioTapChangerCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getRatioTapChangerId() == null )
				command.setRatioTapChangerId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	RatioTapChangerValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateRatioTapChangerCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateRatioTapChangerCommand of RatioTapChanger is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create RatioTapChanger - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateRatioTapChangerCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateRatioTapChanger( UpdateRatioTapChangerCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	RatioTapChangerValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateRatioTapChangerCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save RatioTapChanger - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteRatioTapChangerCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteRatioTapChangerCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	RatioTapChangerValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteRatioTapChangerCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete RatioTapChanger using Id = "  + command.getRatioTapChangerId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the RatioTapChanger via RatioTapChangerFetchOneSummary
     * @param 	summary RatioTapChangerFetchOneSummary 
     * @return 	RatioTapChangerFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public RatioTapChanger getRatioTapChanger( RatioTapChangerFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "RatioTapChangerFetchOneSummary arg cannot be null" );
    	
    	RatioTapChanger entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	RatioTapChangerValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a RatioTapChanger
        	// --------------------------------------
        	CompletableFuture<RatioTapChanger> futureEntity = queryGateway.query(new FindRatioTapChangerQuery( new LoadRatioTapChangerFilter( summary.getRatioTapChangerId() ) ), ResponseTypes.instanceOf(RatioTapChanger.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate RatioTapChanger with id " + summary.getRatioTapChangerId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all RatioTapChangers
     *
     * @return 	List<RatioTapChanger> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<RatioTapChanger> getAllRatioTapChanger() 
    throws ProcessingException {
        List<RatioTapChanger> list = null;

        try {
        	CompletableFuture<List<RatioTapChanger>> futureList = queryGateway.query(new FindAllRatioTapChangerQuery(), ResponseTypes.multipleInstancesOf(RatioTapChanger.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all RatioTapChanger";
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
	 * @return		RatioTapChanger
	 */
	protected RatioTapChanger load( UUID id ) throws ProcessingException {
		ratioTapChanger = RatioTapChangerBusinessDelegate.getRatioTapChangerInstance().getRatioTapChanger( new RatioTapChangerFetchOneSummary(id) );	
		return ratioTapChanger;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private RatioTapChanger ratioTapChanger 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(RatioTapChangerBusinessDelegate.class.getName());
    
}
