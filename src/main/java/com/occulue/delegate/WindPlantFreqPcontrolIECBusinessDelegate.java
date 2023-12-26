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
 * WindPlantFreqPcontrolIEC business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of WindPlantFreqPcontrolIEC related services in the case of a WindPlantFreqPcontrolIEC business related service failing.</li>
 * <li>Exposes a simpler, uniform WindPlantFreqPcontrolIEC interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill WindPlantFreqPcontrolIEC business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class WindPlantFreqPcontrolIECBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public WindPlantFreqPcontrolIECBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* WindPlantFreqPcontrolIEC Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	WindPlantFreqPcontrolIECBusinessDelegate
	*/
	public static WindPlantFreqPcontrolIECBusinessDelegate getWindPlantFreqPcontrolIECInstance() {
		return( new WindPlantFreqPcontrolIECBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createWindPlantFreqPcontrolIEC( CreateWindPlantFreqPcontrolIECCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getWindPlantFreqPcontrolIECId() == null )
				command.setWindPlantFreqPcontrolIECId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindPlantFreqPcontrolIECValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateWindPlantFreqPcontrolIECCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateWindPlantFreqPcontrolIECCommand of WindPlantFreqPcontrolIEC is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create WindPlantFreqPcontrolIEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateWindPlantFreqPcontrolIECCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateWindPlantFreqPcontrolIEC( UpdateWindPlantFreqPcontrolIECCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	WindPlantFreqPcontrolIECValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateWindPlantFreqPcontrolIECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save WindPlantFreqPcontrolIEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteWindPlantFreqPcontrolIECCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteWindPlantFreqPcontrolIECCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindPlantFreqPcontrolIECValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteWindPlantFreqPcontrolIECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete WindPlantFreqPcontrolIEC using Id = "  + command.getWindPlantFreqPcontrolIECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the WindPlantFreqPcontrolIEC via WindPlantFreqPcontrolIECFetchOneSummary
     * @param 	summary WindPlantFreqPcontrolIECFetchOneSummary 
     * @return 	WindPlantFreqPcontrolIECFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public WindPlantFreqPcontrolIEC getWindPlantFreqPcontrolIEC( WindPlantFreqPcontrolIECFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "WindPlantFreqPcontrolIECFetchOneSummary arg cannot be null" );
    	
    	WindPlantFreqPcontrolIEC entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	WindPlantFreqPcontrolIECValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a WindPlantFreqPcontrolIEC
        	// --------------------------------------
        	CompletableFuture<WindPlantFreqPcontrolIEC> futureEntity = queryGateway.query(new FindWindPlantFreqPcontrolIECQuery( new LoadWindPlantFreqPcontrolIECFilter( summary.getWindPlantFreqPcontrolIECId() ) ), ResponseTypes.instanceOf(WindPlantFreqPcontrolIEC.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate WindPlantFreqPcontrolIEC with id " + summary.getWindPlantFreqPcontrolIECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all WindPlantFreqPcontrolIECs
     *
     * @return 	List<WindPlantFreqPcontrolIEC> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<WindPlantFreqPcontrolIEC> getAllWindPlantFreqPcontrolIEC() 
    throws ProcessingException {
        List<WindPlantFreqPcontrolIEC> list = null;

        try {
        	CompletableFuture<List<WindPlantFreqPcontrolIEC>> futureList = queryGateway.query(new FindAllWindPlantFreqPcontrolIECQuery(), ResponseTypes.multipleInstancesOf(WindPlantFreqPcontrolIEC.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all WindPlantFreqPcontrolIEC";
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
	 * @return		WindPlantFreqPcontrolIEC
	 */
	protected WindPlantFreqPcontrolIEC load( UUID id ) throws ProcessingException {
		windPlantFreqPcontrolIEC = WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance().getWindPlantFreqPcontrolIEC( new WindPlantFreqPcontrolIECFetchOneSummary(id) );	
		return windPlantFreqPcontrolIEC;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private WindPlantFreqPcontrolIEC windPlantFreqPcontrolIEC 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(WindPlantFreqPcontrolIECBusinessDelegate.class.getName());
    
}
