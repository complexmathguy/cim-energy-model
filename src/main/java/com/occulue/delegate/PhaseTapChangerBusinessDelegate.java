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
 * PhaseTapChanger business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of PhaseTapChanger related services in the case of a PhaseTapChanger business related service failing.</li>
 * <li>Exposes a simpler, uniform PhaseTapChanger interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill PhaseTapChanger business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class PhaseTapChangerBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public PhaseTapChangerBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* PhaseTapChanger Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	PhaseTapChangerBusinessDelegate
	*/
	public static PhaseTapChangerBusinessDelegate getPhaseTapChangerInstance() {
		return( new PhaseTapChangerBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createPhaseTapChanger( CreatePhaseTapChangerCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getPhaseTapChangerId() == null )
				command.setPhaseTapChangerId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PhaseTapChangerValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreatePhaseTapChangerCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreatePhaseTapChangerCommand of PhaseTapChanger is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create PhaseTapChanger - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdatePhaseTapChangerCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updatePhaseTapChanger( UpdatePhaseTapChangerCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	PhaseTapChangerValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdatePhaseTapChangerCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save PhaseTapChanger - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeletePhaseTapChangerCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeletePhaseTapChangerCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PhaseTapChangerValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeletePhaseTapChangerCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete PhaseTapChanger using Id = "  + command.getPhaseTapChangerId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the PhaseTapChanger via PhaseTapChangerFetchOneSummary
     * @param 	summary PhaseTapChangerFetchOneSummary 
     * @return 	PhaseTapChangerFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public PhaseTapChanger getPhaseTapChanger( PhaseTapChangerFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "PhaseTapChangerFetchOneSummary arg cannot be null" );
    	
    	PhaseTapChanger entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	PhaseTapChangerValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a PhaseTapChanger
        	// --------------------------------------
        	CompletableFuture<PhaseTapChanger> futureEntity = queryGateway.query(new FindPhaseTapChangerQuery( new LoadPhaseTapChangerFilter( summary.getPhaseTapChangerId() ) ), ResponseTypes.instanceOf(PhaseTapChanger.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate PhaseTapChanger with id " + summary.getPhaseTapChangerId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all PhaseTapChangers
     *
     * @return 	List<PhaseTapChanger> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<PhaseTapChanger> getAllPhaseTapChanger() 
    throws ProcessingException {
        List<PhaseTapChanger> list = null;

        try {
        	CompletableFuture<List<PhaseTapChanger>> futureList = queryGateway.query(new FindAllPhaseTapChangerQuery(), ResponseTypes.multipleInstancesOf(PhaseTapChanger.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all PhaseTapChanger";
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
	 * @return		PhaseTapChanger
	 */
	protected PhaseTapChanger load( UUID id ) throws ProcessingException {
		phaseTapChanger = PhaseTapChangerBusinessDelegate.getPhaseTapChangerInstance().getPhaseTapChanger( new PhaseTapChangerFetchOneSummary(id) );	
		return phaseTapChanger;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private PhaseTapChanger phaseTapChanger 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(PhaseTapChangerBusinessDelegate.class.getName());
    
}
