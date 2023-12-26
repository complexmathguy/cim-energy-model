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
 * PhaseTapChangerTablePoint business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of PhaseTapChangerTablePoint related services in the case of a PhaseTapChangerTablePoint business related service failing.</li>
 * <li>Exposes a simpler, uniform PhaseTapChangerTablePoint interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill PhaseTapChangerTablePoint business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class PhaseTapChangerTablePointBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public PhaseTapChangerTablePointBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* PhaseTapChangerTablePoint Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	PhaseTapChangerTablePointBusinessDelegate
	*/
	public static PhaseTapChangerTablePointBusinessDelegate getPhaseTapChangerTablePointInstance() {
		return( new PhaseTapChangerTablePointBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createPhaseTapChangerTablePoint( CreatePhaseTapChangerTablePointCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getPhaseTapChangerTablePointId() == null )
				command.setPhaseTapChangerTablePointId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PhaseTapChangerTablePointValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreatePhaseTapChangerTablePointCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreatePhaseTapChangerTablePointCommand of PhaseTapChangerTablePoint is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create PhaseTapChangerTablePoint - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdatePhaseTapChangerTablePointCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updatePhaseTapChangerTablePoint( UpdatePhaseTapChangerTablePointCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	PhaseTapChangerTablePointValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdatePhaseTapChangerTablePointCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save PhaseTapChangerTablePoint - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeletePhaseTapChangerTablePointCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeletePhaseTapChangerTablePointCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PhaseTapChangerTablePointValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeletePhaseTapChangerTablePointCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete PhaseTapChangerTablePoint using Id = "  + command.getPhaseTapChangerTablePointId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the PhaseTapChangerTablePoint via PhaseTapChangerTablePointFetchOneSummary
     * @param 	summary PhaseTapChangerTablePointFetchOneSummary 
     * @return 	PhaseTapChangerTablePointFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public PhaseTapChangerTablePoint getPhaseTapChangerTablePoint( PhaseTapChangerTablePointFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "PhaseTapChangerTablePointFetchOneSummary arg cannot be null" );
    	
    	PhaseTapChangerTablePoint entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	PhaseTapChangerTablePointValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a PhaseTapChangerTablePoint
        	// --------------------------------------
        	CompletableFuture<PhaseTapChangerTablePoint> futureEntity = queryGateway.query(new FindPhaseTapChangerTablePointQuery( new LoadPhaseTapChangerTablePointFilter( summary.getPhaseTapChangerTablePointId() ) ), ResponseTypes.instanceOf(PhaseTapChangerTablePoint.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate PhaseTapChangerTablePoint with id " + summary.getPhaseTapChangerTablePointId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all PhaseTapChangerTablePoints
     *
     * @return 	List<PhaseTapChangerTablePoint> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<PhaseTapChangerTablePoint> getAllPhaseTapChangerTablePoint() 
    throws ProcessingException {
        List<PhaseTapChangerTablePoint> list = null;

        try {
        	CompletableFuture<List<PhaseTapChangerTablePoint>> futureList = queryGateway.query(new FindAllPhaseTapChangerTablePointQuery(), ResponseTypes.multipleInstancesOf(PhaseTapChangerTablePoint.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all PhaseTapChangerTablePoint";
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
	 * @return		PhaseTapChangerTablePoint
	 */
	protected PhaseTapChangerTablePoint load( UUID id ) throws ProcessingException {
		phaseTapChangerTablePoint = PhaseTapChangerTablePointBusinessDelegate.getPhaseTapChangerTablePointInstance().getPhaseTapChangerTablePoint( new PhaseTapChangerTablePointFetchOneSummary(id) );	
		return phaseTapChangerTablePoint;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private PhaseTapChangerTablePoint phaseTapChangerTablePoint 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(PhaseTapChangerTablePointBusinessDelegate.class.getName());
    
}
