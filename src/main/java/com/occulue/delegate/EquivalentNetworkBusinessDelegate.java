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
 * EquivalentNetwork business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of EquivalentNetwork related services in the case of a EquivalentNetwork business related service failing.</li>
 * <li>Exposes a simpler, uniform EquivalentNetwork interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill EquivalentNetwork business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class EquivalentNetworkBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public EquivalentNetworkBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* EquivalentNetwork Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	EquivalentNetworkBusinessDelegate
	*/
	public static EquivalentNetworkBusinessDelegate getEquivalentNetworkInstance() {
		return( new EquivalentNetworkBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createEquivalentNetwork( CreateEquivalentNetworkCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getEquivalentNetworkId() == null )
				command.setEquivalentNetworkId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	EquivalentNetworkValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateEquivalentNetworkCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateEquivalentNetworkCommand of EquivalentNetwork is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create EquivalentNetwork - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateEquivalentNetworkCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateEquivalentNetwork( UpdateEquivalentNetworkCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	EquivalentNetworkValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateEquivalentNetworkCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save EquivalentNetwork - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteEquivalentNetworkCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteEquivalentNetworkCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	EquivalentNetworkValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteEquivalentNetworkCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete EquivalentNetwork using Id = "  + command.getEquivalentNetworkId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the EquivalentNetwork via EquivalentNetworkFetchOneSummary
     * @param 	summary EquivalentNetworkFetchOneSummary 
     * @return 	EquivalentNetworkFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public EquivalentNetwork getEquivalentNetwork( EquivalentNetworkFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "EquivalentNetworkFetchOneSummary arg cannot be null" );
    	
    	EquivalentNetwork entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	EquivalentNetworkValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a EquivalentNetwork
        	// --------------------------------------
        	CompletableFuture<EquivalentNetwork> futureEntity = queryGateway.query(new FindEquivalentNetworkQuery( new LoadEquivalentNetworkFilter( summary.getEquivalentNetworkId() ) ), ResponseTypes.instanceOf(EquivalentNetwork.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate EquivalentNetwork with id " + summary.getEquivalentNetworkId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all EquivalentNetworks
     *
     * @return 	List<EquivalentNetwork> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<EquivalentNetwork> getAllEquivalentNetwork() 
    throws ProcessingException {
        List<EquivalentNetwork> list = null;

        try {
        	CompletableFuture<List<EquivalentNetwork>> futureList = queryGateway.query(new FindAllEquivalentNetworkQuery(), ResponseTypes.multipleInstancesOf(EquivalentNetwork.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all EquivalentNetwork";
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
	 * @return		EquivalentNetwork
	 */
	protected EquivalentNetwork load( UUID id ) throws ProcessingException {
		equivalentNetwork = EquivalentNetworkBusinessDelegate.getEquivalentNetworkInstance().getEquivalentNetwork( new EquivalentNetworkFetchOneSummary(id) );	
		return equivalentNetwork;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private EquivalentNetwork equivalentNetwork 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(EquivalentNetworkBusinessDelegate.class.getName());
    
}
