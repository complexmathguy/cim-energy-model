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
 * ACDCConverter business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of ACDCConverter related services in the case of a ACDCConverter business related service failing.</li>
 * <li>Exposes a simpler, uniform ACDCConverter interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill ACDCConverter business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class ACDCConverterBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public ACDCConverterBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* ACDCConverter Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	ACDCConverterBusinessDelegate
	*/
	public static ACDCConverterBusinessDelegate getACDCConverterInstance() {
		return( new ACDCConverterBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createACDCConverter( CreateACDCConverterCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getACDCConverterId() == null )
				command.setACDCConverterId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ACDCConverterValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateACDCConverterCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateACDCConverterCommand of ACDCConverter is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create ACDCConverter - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateACDCConverterCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateACDCConverter( UpdateACDCConverterCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	ACDCConverterValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateACDCConverterCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save ACDCConverter - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteACDCConverterCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteACDCConverterCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ACDCConverterValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteACDCConverterCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete ACDCConverter using Id = "  + command.getACDCConverterId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the ACDCConverter via ACDCConverterFetchOneSummary
     * @param 	summary ACDCConverterFetchOneSummary 
     * @return 	ACDCConverterFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public ACDCConverter getACDCConverter( ACDCConverterFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "ACDCConverterFetchOneSummary arg cannot be null" );
    	
    	ACDCConverter entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	ACDCConverterValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a ACDCConverter
        	// --------------------------------------
        	CompletableFuture<ACDCConverter> futureEntity = queryGateway.query(new FindACDCConverterQuery( new LoadACDCConverterFilter( summary.getACDCConverterId() ) ), ResponseTypes.instanceOf(ACDCConverter.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate ACDCConverter with id " + summary.getACDCConverterId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all ACDCConverters
     *
     * @return 	List<ACDCConverter> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<ACDCConverter> getAllACDCConverter() 
    throws ProcessingException {
        List<ACDCConverter> list = null;

        try {
        	CompletableFuture<List<ACDCConverter>> futureList = queryGateway.query(new FindAllACDCConverterQuery(), ResponseTypes.multipleInstancesOf(ACDCConverter.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all ACDCConverter";
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
	 * @return		ACDCConverter
	 */
	protected ACDCConverter load( UUID id ) throws ProcessingException {
		aCDCConverter = ACDCConverterBusinessDelegate.getACDCConverterInstance().getACDCConverter( new ACDCConverterFetchOneSummary(id) );	
		return aCDCConverter;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private ACDCConverter aCDCConverter 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(ACDCConverterBusinessDelegate.class.getName());
    
}
