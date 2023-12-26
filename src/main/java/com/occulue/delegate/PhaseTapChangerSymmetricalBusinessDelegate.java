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
 * PhaseTapChangerSymmetrical business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of PhaseTapChangerSymmetrical related services in the case of a PhaseTapChangerSymmetrical business related service failing.</li>
 * <li>Exposes a simpler, uniform PhaseTapChangerSymmetrical interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill PhaseTapChangerSymmetrical business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class PhaseTapChangerSymmetricalBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public PhaseTapChangerSymmetricalBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* PhaseTapChangerSymmetrical Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	PhaseTapChangerSymmetricalBusinessDelegate
	*/
	public static PhaseTapChangerSymmetricalBusinessDelegate getPhaseTapChangerSymmetricalInstance() {
		return( new PhaseTapChangerSymmetricalBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createPhaseTapChangerSymmetrical( CreatePhaseTapChangerSymmetricalCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getPhaseTapChangerSymmetricalId() == null )
				command.setPhaseTapChangerSymmetricalId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PhaseTapChangerSymmetricalValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreatePhaseTapChangerSymmetricalCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreatePhaseTapChangerSymmetricalCommand of PhaseTapChangerSymmetrical is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create PhaseTapChangerSymmetrical - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdatePhaseTapChangerSymmetricalCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updatePhaseTapChangerSymmetrical( UpdatePhaseTapChangerSymmetricalCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	PhaseTapChangerSymmetricalValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdatePhaseTapChangerSymmetricalCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save PhaseTapChangerSymmetrical - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeletePhaseTapChangerSymmetricalCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeletePhaseTapChangerSymmetricalCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PhaseTapChangerSymmetricalValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeletePhaseTapChangerSymmetricalCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete PhaseTapChangerSymmetrical using Id = "  + command.getPhaseTapChangerSymmetricalId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the PhaseTapChangerSymmetrical via PhaseTapChangerSymmetricalFetchOneSummary
     * @param 	summary PhaseTapChangerSymmetricalFetchOneSummary 
     * @return 	PhaseTapChangerSymmetricalFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public PhaseTapChangerSymmetrical getPhaseTapChangerSymmetrical( PhaseTapChangerSymmetricalFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "PhaseTapChangerSymmetricalFetchOneSummary arg cannot be null" );
    	
    	PhaseTapChangerSymmetrical entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	PhaseTapChangerSymmetricalValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a PhaseTapChangerSymmetrical
        	// --------------------------------------
        	CompletableFuture<PhaseTapChangerSymmetrical> futureEntity = queryGateway.query(new FindPhaseTapChangerSymmetricalQuery( new LoadPhaseTapChangerSymmetricalFilter( summary.getPhaseTapChangerSymmetricalId() ) ), ResponseTypes.instanceOf(PhaseTapChangerSymmetrical.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate PhaseTapChangerSymmetrical with id " + summary.getPhaseTapChangerSymmetricalId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all PhaseTapChangerSymmetricals
     *
     * @return 	List<PhaseTapChangerSymmetrical> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<PhaseTapChangerSymmetrical> getAllPhaseTapChangerSymmetrical() 
    throws ProcessingException {
        List<PhaseTapChangerSymmetrical> list = null;

        try {
        	CompletableFuture<List<PhaseTapChangerSymmetrical>> futureList = queryGateway.query(new FindAllPhaseTapChangerSymmetricalQuery(), ResponseTypes.multipleInstancesOf(PhaseTapChangerSymmetrical.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all PhaseTapChangerSymmetrical";
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
	 * @return		PhaseTapChangerSymmetrical
	 */
	protected PhaseTapChangerSymmetrical load( UUID id ) throws ProcessingException {
		phaseTapChangerSymmetrical = PhaseTapChangerSymmetricalBusinessDelegate.getPhaseTapChangerSymmetricalInstance().getPhaseTapChangerSymmetrical( new PhaseTapChangerSymmetricalFetchOneSummary(id) );	
		return phaseTapChangerSymmetrical;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private PhaseTapChangerSymmetrical phaseTapChangerSymmetrical 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(PhaseTapChangerSymmetricalBusinessDelegate.class.getName());
    
}
