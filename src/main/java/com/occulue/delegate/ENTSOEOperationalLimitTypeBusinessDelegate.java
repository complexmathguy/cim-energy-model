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
 * ENTSOEOperationalLimitType business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of ENTSOEOperationalLimitType related services in the case of a ENTSOEOperationalLimitType business related service failing.</li>
 * <li>Exposes a simpler, uniform ENTSOEOperationalLimitType interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill ENTSOEOperationalLimitType business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class ENTSOEOperationalLimitTypeBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public ENTSOEOperationalLimitTypeBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* ENTSOEOperationalLimitType Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	ENTSOEOperationalLimitTypeBusinessDelegate
	*/
	public static ENTSOEOperationalLimitTypeBusinessDelegate getENTSOEOperationalLimitTypeInstance() {
		return( new ENTSOEOperationalLimitTypeBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createENTSOEOperationalLimitType( CreateENTSOEOperationalLimitTypeCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getENTSOEOperationalLimitTypeId() == null )
				command.setENTSOEOperationalLimitTypeId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ENTSOEOperationalLimitTypeValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateENTSOEOperationalLimitTypeCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateENTSOEOperationalLimitTypeCommand of ENTSOEOperationalLimitType is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create ENTSOEOperationalLimitType - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateENTSOEOperationalLimitTypeCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateENTSOEOperationalLimitType( UpdateENTSOEOperationalLimitTypeCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	ENTSOEOperationalLimitTypeValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateENTSOEOperationalLimitTypeCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save ENTSOEOperationalLimitType - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteENTSOEOperationalLimitTypeCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteENTSOEOperationalLimitTypeCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ENTSOEOperationalLimitTypeValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteENTSOEOperationalLimitTypeCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete ENTSOEOperationalLimitType using Id = "  + command.getENTSOEOperationalLimitTypeId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the ENTSOEOperationalLimitType via ENTSOEOperationalLimitTypeFetchOneSummary
     * @param 	summary ENTSOEOperationalLimitTypeFetchOneSummary 
     * @return 	ENTSOEOperationalLimitTypeFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public ENTSOEOperationalLimitType getENTSOEOperationalLimitType( ENTSOEOperationalLimitTypeFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "ENTSOEOperationalLimitTypeFetchOneSummary arg cannot be null" );
    	
    	ENTSOEOperationalLimitType entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	ENTSOEOperationalLimitTypeValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a ENTSOEOperationalLimitType
        	// --------------------------------------
        	CompletableFuture<ENTSOEOperationalLimitType> futureEntity = queryGateway.query(new FindENTSOEOperationalLimitTypeQuery( new LoadENTSOEOperationalLimitTypeFilter( summary.getENTSOEOperationalLimitTypeId() ) ), ResponseTypes.instanceOf(ENTSOEOperationalLimitType.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate ENTSOEOperationalLimitType with id " + summary.getENTSOEOperationalLimitTypeId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all ENTSOEOperationalLimitTypes
     *
     * @return 	List<ENTSOEOperationalLimitType> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<ENTSOEOperationalLimitType> getAllENTSOEOperationalLimitType() 
    throws ProcessingException {
        List<ENTSOEOperationalLimitType> list = null;

        try {
        	CompletableFuture<List<ENTSOEOperationalLimitType>> futureList = queryGateway.query(new FindAllENTSOEOperationalLimitTypeQuery(), ResponseTypes.multipleInstancesOf(ENTSOEOperationalLimitType.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all ENTSOEOperationalLimitType";
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
	 * @return		ENTSOEOperationalLimitType
	 */
	protected ENTSOEOperationalLimitType load( UUID id ) throws ProcessingException {
		eNTSOEOperationalLimitType = ENTSOEOperationalLimitTypeBusinessDelegate.getENTSOEOperationalLimitTypeInstance().getENTSOEOperationalLimitType( new ENTSOEOperationalLimitTypeFetchOneSummary(id) );	
		return eNTSOEOperationalLimitType;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private ENTSOEOperationalLimitType eNTSOEOperationalLimitType 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(ENTSOEOperationalLimitTypeBusinessDelegate.class.getName());
    
}
