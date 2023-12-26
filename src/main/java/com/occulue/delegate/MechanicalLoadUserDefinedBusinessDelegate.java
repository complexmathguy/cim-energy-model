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
 * MechanicalLoadUserDefined business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of MechanicalLoadUserDefined related services in the case of a MechanicalLoadUserDefined business related service failing.</li>
 * <li>Exposes a simpler, uniform MechanicalLoadUserDefined interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill MechanicalLoadUserDefined business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class MechanicalLoadUserDefinedBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public MechanicalLoadUserDefinedBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* MechanicalLoadUserDefined Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	MechanicalLoadUserDefinedBusinessDelegate
	*/
	public static MechanicalLoadUserDefinedBusinessDelegate getMechanicalLoadUserDefinedInstance() {
		return( new MechanicalLoadUserDefinedBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createMechanicalLoadUserDefined( CreateMechanicalLoadUserDefinedCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getMechanicalLoadUserDefinedId() == null )
				command.setMechanicalLoadUserDefinedId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	MechanicalLoadUserDefinedValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateMechanicalLoadUserDefinedCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateMechanicalLoadUserDefinedCommand of MechanicalLoadUserDefined is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create MechanicalLoadUserDefined - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateMechanicalLoadUserDefinedCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateMechanicalLoadUserDefined( UpdateMechanicalLoadUserDefinedCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	MechanicalLoadUserDefinedValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateMechanicalLoadUserDefinedCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save MechanicalLoadUserDefined - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteMechanicalLoadUserDefinedCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteMechanicalLoadUserDefinedCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	MechanicalLoadUserDefinedValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteMechanicalLoadUserDefinedCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete MechanicalLoadUserDefined using Id = "  + command.getMechanicalLoadUserDefinedId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the MechanicalLoadUserDefined via MechanicalLoadUserDefinedFetchOneSummary
     * @param 	summary MechanicalLoadUserDefinedFetchOneSummary 
     * @return 	MechanicalLoadUserDefinedFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public MechanicalLoadUserDefined getMechanicalLoadUserDefined( MechanicalLoadUserDefinedFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "MechanicalLoadUserDefinedFetchOneSummary arg cannot be null" );
    	
    	MechanicalLoadUserDefined entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	MechanicalLoadUserDefinedValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a MechanicalLoadUserDefined
        	// --------------------------------------
        	CompletableFuture<MechanicalLoadUserDefined> futureEntity = queryGateway.query(new FindMechanicalLoadUserDefinedQuery( new LoadMechanicalLoadUserDefinedFilter( summary.getMechanicalLoadUserDefinedId() ) ), ResponseTypes.instanceOf(MechanicalLoadUserDefined.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate MechanicalLoadUserDefined with id " + summary.getMechanicalLoadUserDefinedId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all MechanicalLoadUserDefineds
     *
     * @return 	List<MechanicalLoadUserDefined> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<MechanicalLoadUserDefined> getAllMechanicalLoadUserDefined() 
    throws ProcessingException {
        List<MechanicalLoadUserDefined> list = null;

        try {
        	CompletableFuture<List<MechanicalLoadUserDefined>> futureList = queryGateway.query(new FindAllMechanicalLoadUserDefinedQuery(), ResponseTypes.multipleInstancesOf(MechanicalLoadUserDefined.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all MechanicalLoadUserDefined";
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
	 * @return		MechanicalLoadUserDefined
	 */
	protected MechanicalLoadUserDefined load( UUID id ) throws ProcessingException {
		mechanicalLoadUserDefined = MechanicalLoadUserDefinedBusinessDelegate.getMechanicalLoadUserDefinedInstance().getMechanicalLoadUserDefined( new MechanicalLoadUserDefinedFetchOneSummary(id) );	
		return mechanicalLoadUserDefined;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private MechanicalLoadUserDefined mechanicalLoadUserDefined 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(MechanicalLoadUserDefinedBusinessDelegate.class.getName());
    
}
