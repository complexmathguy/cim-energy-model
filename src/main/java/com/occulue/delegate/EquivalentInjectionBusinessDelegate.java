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
 * EquivalentInjection business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of EquivalentInjection related services in the case of a EquivalentInjection business related service failing.</li>
 * <li>Exposes a simpler, uniform EquivalentInjection interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill EquivalentInjection business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class EquivalentInjectionBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public EquivalentInjectionBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* EquivalentInjection Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	EquivalentInjectionBusinessDelegate
	*/
	public static EquivalentInjectionBusinessDelegate getEquivalentInjectionInstance() {
		return( new EquivalentInjectionBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createEquivalentInjection( CreateEquivalentInjectionCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getEquivalentInjectionId() == null )
				command.setEquivalentInjectionId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	EquivalentInjectionValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateEquivalentInjectionCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateEquivalentInjectionCommand of EquivalentInjection is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create EquivalentInjection - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateEquivalentInjectionCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateEquivalentInjection( UpdateEquivalentInjectionCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	EquivalentInjectionValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateEquivalentInjectionCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save EquivalentInjection - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteEquivalentInjectionCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteEquivalentInjectionCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	EquivalentInjectionValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteEquivalentInjectionCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete EquivalentInjection using Id = "  + command.getEquivalentInjectionId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the EquivalentInjection via EquivalentInjectionFetchOneSummary
     * @param 	summary EquivalentInjectionFetchOneSummary 
     * @return 	EquivalentInjectionFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public EquivalentInjection getEquivalentInjection( EquivalentInjectionFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "EquivalentInjectionFetchOneSummary arg cannot be null" );
    	
    	EquivalentInjection entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	EquivalentInjectionValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a EquivalentInjection
        	// --------------------------------------
        	CompletableFuture<EquivalentInjection> futureEntity = queryGateway.query(new FindEquivalentInjectionQuery( new LoadEquivalentInjectionFilter( summary.getEquivalentInjectionId() ) ), ResponseTypes.instanceOf(EquivalentInjection.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate EquivalentInjection with id " + summary.getEquivalentInjectionId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all EquivalentInjections
     *
     * @return 	List<EquivalentInjection> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<EquivalentInjection> getAllEquivalentInjection() 
    throws ProcessingException {
        List<EquivalentInjection> list = null;

        try {
        	CompletableFuture<List<EquivalentInjection>> futureList = queryGateway.query(new FindAllEquivalentInjectionQuery(), ResponseTypes.multipleInstancesOf(EquivalentInjection.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all EquivalentInjection";
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
	 * @return		EquivalentInjection
	 */
	protected EquivalentInjection load( UUID id ) throws ProcessingException {
		equivalentInjection = EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance().getEquivalentInjection( new EquivalentInjectionFetchOneSummary(id) );	
		return equivalentInjection;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private EquivalentInjection equivalentInjection 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(EquivalentInjectionBusinessDelegate.class.getName());
    
}
