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
 * VCompIEEEType1 business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of VCompIEEEType1 related services in the case of a VCompIEEEType1 business related service failing.</li>
 * <li>Exposes a simpler, uniform VCompIEEEType1 interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill VCompIEEEType1 business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class VCompIEEEType1BusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public VCompIEEEType1BusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* VCompIEEEType1 Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	VCompIEEEType1BusinessDelegate
	*/
	public static VCompIEEEType1BusinessDelegate getVCompIEEEType1Instance() {
		return( new VCompIEEEType1BusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createVCompIEEEType1( CreateVCompIEEEType1Command command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getVCompIEEEType1Id() == null )
				command.setVCompIEEEType1Id( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	VCompIEEEType1Validator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateVCompIEEEType1Command - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateVCompIEEEType1Command of VCompIEEEType1 is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create VCompIEEEType1 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateVCompIEEEType1Command
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateVCompIEEEType1( UpdateVCompIEEEType1Command command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	VCompIEEEType1Validator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateVCompIEEEType1Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save VCompIEEEType1 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteVCompIEEEType1Command
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteVCompIEEEType1Command command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	VCompIEEEType1Validator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteVCompIEEEType1Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete VCompIEEEType1 using Id = "  + command.getVCompIEEEType1Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the VCompIEEEType1 via VCompIEEEType1FetchOneSummary
     * @param 	summary VCompIEEEType1FetchOneSummary 
     * @return 	VCompIEEEType1FetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public VCompIEEEType1 getVCompIEEEType1( VCompIEEEType1FetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "VCompIEEEType1FetchOneSummary arg cannot be null" );
    	
    	VCompIEEEType1 entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	VCompIEEEType1Validator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a VCompIEEEType1
        	// --------------------------------------
        	CompletableFuture<VCompIEEEType1> futureEntity = queryGateway.query(new FindVCompIEEEType1Query( new LoadVCompIEEEType1Filter( summary.getVCompIEEEType1Id() ) ), ResponseTypes.instanceOf(VCompIEEEType1.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate VCompIEEEType1 with id " + summary.getVCompIEEEType1Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all VCompIEEEType1s
     *
     * @return 	List<VCompIEEEType1> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<VCompIEEEType1> getAllVCompIEEEType1() 
    throws ProcessingException {
        List<VCompIEEEType1> list = null;

        try {
        	CompletableFuture<List<VCompIEEEType1>> futureList = queryGateway.query(new FindAllVCompIEEEType1Query(), ResponseTypes.multipleInstancesOf(VCompIEEEType1.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all VCompIEEEType1";
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
	 * @return		VCompIEEEType1
	 */
	protected VCompIEEEType1 load( UUID id ) throws ProcessingException {
		vCompIEEEType1 = VCompIEEEType1BusinessDelegate.getVCompIEEEType1Instance().getVCompIEEEType1( new VCompIEEEType1FetchOneSummary(id) );	
		return vCompIEEEType1;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private VCompIEEEType1 vCompIEEEType1 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(VCompIEEEType1BusinessDelegate.class.getName());
    
}
