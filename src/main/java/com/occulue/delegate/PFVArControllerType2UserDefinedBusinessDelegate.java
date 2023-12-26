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
 * PFVArControllerType2UserDefined business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of PFVArControllerType2UserDefined related services in the case of a PFVArControllerType2UserDefined business related service failing.</li>
 * <li>Exposes a simpler, uniform PFVArControllerType2UserDefined interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill PFVArControllerType2UserDefined business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class PFVArControllerType2UserDefinedBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public PFVArControllerType2UserDefinedBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* PFVArControllerType2UserDefined Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	PFVArControllerType2UserDefinedBusinessDelegate
	*/
	public static PFVArControllerType2UserDefinedBusinessDelegate getPFVArControllerType2UserDefinedInstance() {
		return( new PFVArControllerType2UserDefinedBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createPFVArControllerType2UserDefined( CreatePFVArControllerType2UserDefinedCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getPFVArControllerType2UserDefinedId() == null )
				command.setPFVArControllerType2UserDefinedId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PFVArControllerType2UserDefinedValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreatePFVArControllerType2UserDefinedCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreatePFVArControllerType2UserDefinedCommand of PFVArControllerType2UserDefined is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create PFVArControllerType2UserDefined - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdatePFVArControllerType2UserDefinedCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updatePFVArControllerType2UserDefined( UpdatePFVArControllerType2UserDefinedCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	PFVArControllerType2UserDefinedValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdatePFVArControllerType2UserDefinedCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save PFVArControllerType2UserDefined - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeletePFVArControllerType2UserDefinedCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeletePFVArControllerType2UserDefinedCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PFVArControllerType2UserDefinedValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeletePFVArControllerType2UserDefinedCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete PFVArControllerType2UserDefined using Id = "  + command.getPFVArControllerType2UserDefinedId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the PFVArControllerType2UserDefined via PFVArControllerType2UserDefinedFetchOneSummary
     * @param 	summary PFVArControllerType2UserDefinedFetchOneSummary 
     * @return 	PFVArControllerType2UserDefinedFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public PFVArControllerType2UserDefined getPFVArControllerType2UserDefined( PFVArControllerType2UserDefinedFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "PFVArControllerType2UserDefinedFetchOneSummary arg cannot be null" );
    	
    	PFVArControllerType2UserDefined entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	PFVArControllerType2UserDefinedValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a PFVArControllerType2UserDefined
        	// --------------------------------------
        	CompletableFuture<PFVArControllerType2UserDefined> futureEntity = queryGateway.query(new FindPFVArControllerType2UserDefinedQuery( new LoadPFVArControllerType2UserDefinedFilter( summary.getPFVArControllerType2UserDefinedId() ) ), ResponseTypes.instanceOf(PFVArControllerType2UserDefined.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate PFVArControllerType2UserDefined with id " + summary.getPFVArControllerType2UserDefinedId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all PFVArControllerType2UserDefineds
     *
     * @return 	List<PFVArControllerType2UserDefined> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<PFVArControllerType2UserDefined> getAllPFVArControllerType2UserDefined() 
    throws ProcessingException {
        List<PFVArControllerType2UserDefined> list = null;

        try {
        	CompletableFuture<List<PFVArControllerType2UserDefined>> futureList = queryGateway.query(new FindAllPFVArControllerType2UserDefinedQuery(), ResponseTypes.multipleInstancesOf(PFVArControllerType2UserDefined.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all PFVArControllerType2UserDefined";
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
	 * @return		PFVArControllerType2UserDefined
	 */
	protected PFVArControllerType2UserDefined load( UUID id ) throws ProcessingException {
		pFVArControllerType2UserDefined = PFVArControllerType2UserDefinedBusinessDelegate.getPFVArControllerType2UserDefinedInstance().getPFVArControllerType2UserDefined( new PFVArControllerType2UserDefinedFetchOneSummary(id) );	
		return pFVArControllerType2UserDefined;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private PFVArControllerType2UserDefined pFVArControllerType2UserDefined 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(PFVArControllerType2UserDefinedBusinessDelegate.class.getName());
    
}
