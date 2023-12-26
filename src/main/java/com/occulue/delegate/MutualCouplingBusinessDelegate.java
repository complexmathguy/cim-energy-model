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
 * MutualCoupling business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of MutualCoupling related services in the case of a MutualCoupling business related service failing.</li>
 * <li>Exposes a simpler, uniform MutualCoupling interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill MutualCoupling business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class MutualCouplingBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public MutualCouplingBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* MutualCoupling Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	MutualCouplingBusinessDelegate
	*/
	public static MutualCouplingBusinessDelegate getMutualCouplingInstance() {
		return( new MutualCouplingBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createMutualCoupling( CreateMutualCouplingCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getMutualCouplingId() == null )
				command.setMutualCouplingId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	MutualCouplingValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateMutualCouplingCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateMutualCouplingCommand of MutualCoupling is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create MutualCoupling - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateMutualCouplingCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateMutualCoupling( UpdateMutualCouplingCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	MutualCouplingValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateMutualCouplingCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save MutualCoupling - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteMutualCouplingCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteMutualCouplingCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	MutualCouplingValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteMutualCouplingCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete MutualCoupling using Id = "  + command.getMutualCouplingId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the MutualCoupling via MutualCouplingFetchOneSummary
     * @param 	summary MutualCouplingFetchOneSummary 
     * @return 	MutualCouplingFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public MutualCoupling getMutualCoupling( MutualCouplingFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "MutualCouplingFetchOneSummary arg cannot be null" );
    	
    	MutualCoupling entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	MutualCouplingValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a MutualCoupling
        	// --------------------------------------
        	CompletableFuture<MutualCoupling> futureEntity = queryGateway.query(new FindMutualCouplingQuery( new LoadMutualCouplingFilter( summary.getMutualCouplingId() ) ), ResponseTypes.instanceOf(MutualCoupling.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate MutualCoupling with id " + summary.getMutualCouplingId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all MutualCouplings
     *
     * @return 	List<MutualCoupling> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<MutualCoupling> getAllMutualCoupling() 
    throws ProcessingException {
        List<MutualCoupling> list = null;

        try {
        	CompletableFuture<List<MutualCoupling>> futureList = queryGateway.query(new FindAllMutualCouplingQuery(), ResponseTypes.multipleInstancesOf(MutualCoupling.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all MutualCoupling";
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
	 * @return		MutualCoupling
	 */
	protected MutualCoupling load( UUID id ) throws ProcessingException {
		mutualCoupling = MutualCouplingBusinessDelegate.getMutualCouplingInstance().getMutualCoupling( new MutualCouplingFetchOneSummary(id) );	
		return mutualCoupling;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private MutualCoupling mutualCoupling 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(MutualCouplingBusinessDelegate.class.getName());
    
}
