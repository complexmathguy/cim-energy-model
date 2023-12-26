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
 * PhaseTapChangerNonLinear business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of PhaseTapChangerNonLinear related services in the case of a PhaseTapChangerNonLinear business related service failing.</li>
 * <li>Exposes a simpler, uniform PhaseTapChangerNonLinear interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill PhaseTapChangerNonLinear business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class PhaseTapChangerNonLinearBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public PhaseTapChangerNonLinearBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* PhaseTapChangerNonLinear Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	PhaseTapChangerNonLinearBusinessDelegate
	*/
	public static PhaseTapChangerNonLinearBusinessDelegate getPhaseTapChangerNonLinearInstance() {
		return( new PhaseTapChangerNonLinearBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createPhaseTapChangerNonLinear( CreatePhaseTapChangerNonLinearCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getPhaseTapChangerNonLinearId() == null )
				command.setPhaseTapChangerNonLinearId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PhaseTapChangerNonLinearValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreatePhaseTapChangerNonLinearCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreatePhaseTapChangerNonLinearCommand of PhaseTapChangerNonLinear is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create PhaseTapChangerNonLinear - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdatePhaseTapChangerNonLinearCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updatePhaseTapChangerNonLinear( UpdatePhaseTapChangerNonLinearCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	PhaseTapChangerNonLinearValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdatePhaseTapChangerNonLinearCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save PhaseTapChangerNonLinear - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeletePhaseTapChangerNonLinearCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeletePhaseTapChangerNonLinearCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PhaseTapChangerNonLinearValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeletePhaseTapChangerNonLinearCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete PhaseTapChangerNonLinear using Id = "  + command.getPhaseTapChangerNonLinearId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the PhaseTapChangerNonLinear via PhaseTapChangerNonLinearFetchOneSummary
     * @param 	summary PhaseTapChangerNonLinearFetchOneSummary 
     * @return 	PhaseTapChangerNonLinearFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public PhaseTapChangerNonLinear getPhaseTapChangerNonLinear( PhaseTapChangerNonLinearFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "PhaseTapChangerNonLinearFetchOneSummary arg cannot be null" );
    	
    	PhaseTapChangerNonLinear entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	PhaseTapChangerNonLinearValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a PhaseTapChangerNonLinear
        	// --------------------------------------
        	CompletableFuture<PhaseTapChangerNonLinear> futureEntity = queryGateway.query(new FindPhaseTapChangerNonLinearQuery( new LoadPhaseTapChangerNonLinearFilter( summary.getPhaseTapChangerNonLinearId() ) ), ResponseTypes.instanceOf(PhaseTapChangerNonLinear.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate PhaseTapChangerNonLinear with id " + summary.getPhaseTapChangerNonLinearId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all PhaseTapChangerNonLinears
     *
     * @return 	List<PhaseTapChangerNonLinear> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<PhaseTapChangerNonLinear> getAllPhaseTapChangerNonLinear() 
    throws ProcessingException {
        List<PhaseTapChangerNonLinear> list = null;

        try {
        	CompletableFuture<List<PhaseTapChangerNonLinear>> futureList = queryGateway.query(new FindAllPhaseTapChangerNonLinearQuery(), ResponseTypes.multipleInstancesOf(PhaseTapChangerNonLinear.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all PhaseTapChangerNonLinear";
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
	 * @return		PhaseTapChangerNonLinear
	 */
	protected PhaseTapChangerNonLinear load( UUID id ) throws ProcessingException {
		phaseTapChangerNonLinear = PhaseTapChangerNonLinearBusinessDelegate.getPhaseTapChangerNonLinearInstance().getPhaseTapChangerNonLinear( new PhaseTapChangerNonLinearFetchOneSummary(id) );	
		return phaseTapChangerNonLinear;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private PhaseTapChangerNonLinear phaseTapChangerNonLinear 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(PhaseTapChangerNonLinearBusinessDelegate.class.getName());
    
}
