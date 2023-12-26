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
 * WindType3or4UserDefined business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of WindType3or4UserDefined related services in the case of a WindType3or4UserDefined business related service failing.</li>
 * <li>Exposes a simpler, uniform WindType3or4UserDefined interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill WindType3or4UserDefined business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class WindType3or4UserDefinedBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public WindType3or4UserDefinedBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* WindType3or4UserDefined Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	WindType3or4UserDefinedBusinessDelegate
	*/
	public static WindType3or4UserDefinedBusinessDelegate getWindType3or4UserDefinedInstance() {
		return( new WindType3or4UserDefinedBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createWindType3or4UserDefined( CreateWindType3or4UserDefinedCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getWindType3or4UserDefinedId() == null )
				command.setWindType3or4UserDefinedId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindType3or4UserDefinedValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateWindType3or4UserDefinedCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateWindType3or4UserDefinedCommand of WindType3or4UserDefined is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create WindType3or4UserDefined - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateWindType3or4UserDefinedCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateWindType3or4UserDefined( UpdateWindType3or4UserDefinedCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	WindType3or4UserDefinedValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateWindType3or4UserDefinedCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save WindType3or4UserDefined - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteWindType3or4UserDefinedCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteWindType3or4UserDefinedCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindType3or4UserDefinedValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteWindType3or4UserDefinedCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete WindType3or4UserDefined using Id = "  + command.getWindType3or4UserDefinedId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the WindType3or4UserDefined via WindType3or4UserDefinedFetchOneSummary
     * @param 	summary WindType3or4UserDefinedFetchOneSummary 
     * @return 	WindType3or4UserDefinedFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public WindType3or4UserDefined getWindType3or4UserDefined( WindType3or4UserDefinedFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "WindType3or4UserDefinedFetchOneSummary arg cannot be null" );
    	
    	WindType3or4UserDefined entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	WindType3or4UserDefinedValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a WindType3or4UserDefined
        	// --------------------------------------
        	CompletableFuture<WindType3or4UserDefined> futureEntity = queryGateway.query(new FindWindType3or4UserDefinedQuery( new LoadWindType3or4UserDefinedFilter( summary.getWindType3or4UserDefinedId() ) ), ResponseTypes.instanceOf(WindType3or4UserDefined.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate WindType3or4UserDefined with id " + summary.getWindType3or4UserDefinedId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all WindType3or4UserDefineds
     *
     * @return 	List<WindType3or4UserDefined> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<WindType3or4UserDefined> getAllWindType3or4UserDefined() 
    throws ProcessingException {
        List<WindType3or4UserDefined> list = null;

        try {
        	CompletableFuture<List<WindType3or4UserDefined>> futureList = queryGateway.query(new FindAllWindType3or4UserDefinedQuery(), ResponseTypes.multipleInstancesOf(WindType3or4UserDefined.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all WindType3or4UserDefined";
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
	 * @return		WindType3or4UserDefined
	 */
	protected WindType3or4UserDefined load( UUID id ) throws ProcessingException {
		windType3or4UserDefined = WindType3or4UserDefinedBusinessDelegate.getWindType3or4UserDefinedInstance().getWindType3or4UserDefined( new WindType3or4UserDefinedFetchOneSummary(id) );	
		return windType3or4UserDefined;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private WindType3or4UserDefined windType3or4UserDefined 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(WindType3or4UserDefinedBusinessDelegate.class.getName());
    
}
