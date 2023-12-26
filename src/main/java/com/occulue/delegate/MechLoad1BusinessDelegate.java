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
 * MechLoad1 business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of MechLoad1 related services in the case of a MechLoad1 business related service failing.</li>
 * <li>Exposes a simpler, uniform MechLoad1 interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill MechLoad1 business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class MechLoad1BusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public MechLoad1BusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* MechLoad1 Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	MechLoad1BusinessDelegate
	*/
	public static MechLoad1BusinessDelegate getMechLoad1Instance() {
		return( new MechLoad1BusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createMechLoad1( CreateMechLoad1Command command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getMechLoad1Id() == null )
				command.setMechLoad1Id( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	MechLoad1Validator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateMechLoad1Command - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateMechLoad1Command of MechLoad1 is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create MechLoad1 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateMechLoad1Command
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateMechLoad1( UpdateMechLoad1Command command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	MechLoad1Validator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateMechLoad1Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save MechLoad1 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteMechLoad1Command
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteMechLoad1Command command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	MechLoad1Validator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteMechLoad1Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete MechLoad1 using Id = "  + command.getMechLoad1Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the MechLoad1 via MechLoad1FetchOneSummary
     * @param 	summary MechLoad1FetchOneSummary 
     * @return 	MechLoad1FetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public MechLoad1 getMechLoad1( MechLoad1FetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "MechLoad1FetchOneSummary arg cannot be null" );
    	
    	MechLoad1 entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	MechLoad1Validator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a MechLoad1
        	// --------------------------------------
        	CompletableFuture<MechLoad1> futureEntity = queryGateway.query(new FindMechLoad1Query( new LoadMechLoad1Filter( summary.getMechLoad1Id() ) ), ResponseTypes.instanceOf(MechLoad1.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate MechLoad1 with id " + summary.getMechLoad1Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all MechLoad1s
     *
     * @return 	List<MechLoad1> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<MechLoad1> getAllMechLoad1() 
    throws ProcessingException {
        List<MechLoad1> list = null;

        try {
        	CompletableFuture<List<MechLoad1>> futureList = queryGateway.query(new FindAllMechLoad1Query(), ResponseTypes.multipleInstancesOf(MechLoad1.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all MechLoad1";
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
	 * @return		MechLoad1
	 */
	protected MechLoad1 load( UUID id ) throws ProcessingException {
		mechLoad1 = MechLoad1BusinessDelegate.getMechLoad1Instance().getMechLoad1( new MechLoad1FetchOneSummary(id) );	
		return mechLoad1;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private MechLoad1 mechLoad1 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(MechLoad1BusinessDelegate.class.getName());
    
}
