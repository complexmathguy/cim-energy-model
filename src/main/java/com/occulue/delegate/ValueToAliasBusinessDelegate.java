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
 * ValueToAlias business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of ValueToAlias related services in the case of a ValueToAlias business related service failing.</li>
 * <li>Exposes a simpler, uniform ValueToAlias interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill ValueToAlias business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class ValueToAliasBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public ValueToAliasBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* ValueToAlias Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	ValueToAliasBusinessDelegate
	*/
	public static ValueToAliasBusinessDelegate getValueToAliasInstance() {
		return( new ValueToAliasBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createValueToAlias( CreateValueToAliasCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getValueToAliasId() == null )
				command.setValueToAliasId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ValueToAliasValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateValueToAliasCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateValueToAliasCommand of ValueToAlias is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create ValueToAlias - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateValueToAliasCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateValueToAlias( UpdateValueToAliasCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	ValueToAliasValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateValueToAliasCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save ValueToAlias - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteValueToAliasCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteValueToAliasCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ValueToAliasValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteValueToAliasCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete ValueToAlias using Id = "  + command.getValueToAliasId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the ValueToAlias via ValueToAliasFetchOneSummary
     * @param 	summary ValueToAliasFetchOneSummary 
     * @return 	ValueToAliasFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public ValueToAlias getValueToAlias( ValueToAliasFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "ValueToAliasFetchOneSummary arg cannot be null" );
    	
    	ValueToAlias entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	ValueToAliasValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a ValueToAlias
        	// --------------------------------------
        	CompletableFuture<ValueToAlias> futureEntity = queryGateway.query(new FindValueToAliasQuery( new LoadValueToAliasFilter( summary.getValueToAliasId() ) ), ResponseTypes.instanceOf(ValueToAlias.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate ValueToAlias with id " + summary.getValueToAliasId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all ValueToAliass
     *
     * @return 	List<ValueToAlias> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<ValueToAlias> getAllValueToAlias() 
    throws ProcessingException {
        List<ValueToAlias> list = null;

        try {
        	CompletableFuture<List<ValueToAlias>> futureList = queryGateway.query(new FindAllValueToAliasQuery(), ResponseTypes.multipleInstancesOf(ValueToAlias.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all ValueToAlias";
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
	 * @return		ValueToAlias
	 */
	protected ValueToAlias load( UUID id ) throws ProcessingException {
		valueToAlias = ValueToAliasBusinessDelegate.getValueToAliasInstance().getValueToAlias( new ValueToAliasFetchOneSummary(id) );	
		return valueToAlias;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private ValueToAlias valueToAlias 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(ValueToAliasBusinessDelegate.class.getName());
    
}
