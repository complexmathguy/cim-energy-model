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
 * BusbarSection business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of BusbarSection related services in the case of a BusbarSection business related service failing.</li>
 * <li>Exposes a simpler, uniform BusbarSection interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill BusbarSection business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class BusbarSectionBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public BusbarSectionBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* BusbarSection Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	BusbarSectionBusinessDelegate
	*/
	public static BusbarSectionBusinessDelegate getBusbarSectionInstance() {
		return( new BusbarSectionBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createBusbarSection( CreateBusbarSectionCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getBusbarSectionId() == null )
				command.setBusbarSectionId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	BusbarSectionValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateBusbarSectionCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateBusbarSectionCommand of BusbarSection is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create BusbarSection - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateBusbarSectionCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateBusbarSection( UpdateBusbarSectionCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	BusbarSectionValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateBusbarSectionCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save BusbarSection - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteBusbarSectionCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteBusbarSectionCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	BusbarSectionValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteBusbarSectionCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete BusbarSection using Id = "  + command.getBusbarSectionId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the BusbarSection via BusbarSectionFetchOneSummary
     * @param 	summary BusbarSectionFetchOneSummary 
     * @return 	BusbarSectionFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public BusbarSection getBusbarSection( BusbarSectionFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "BusbarSectionFetchOneSummary arg cannot be null" );
    	
    	BusbarSection entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	BusbarSectionValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a BusbarSection
        	// --------------------------------------
        	CompletableFuture<BusbarSection> futureEntity = queryGateway.query(new FindBusbarSectionQuery( new LoadBusbarSectionFilter( summary.getBusbarSectionId() ) ), ResponseTypes.instanceOf(BusbarSection.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate BusbarSection with id " + summary.getBusbarSectionId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all BusbarSections
     *
     * @return 	List<BusbarSection> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<BusbarSection> getAllBusbarSection() 
    throws ProcessingException {
        List<BusbarSection> list = null;

        try {
        	CompletableFuture<List<BusbarSection>> futureList = queryGateway.query(new FindAllBusbarSectionQuery(), ResponseTypes.multipleInstancesOf(BusbarSection.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all BusbarSection";
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
	 * @return		BusbarSection
	 */
	protected BusbarSection load( UUID id ) throws ProcessingException {
		busbarSection = BusbarSectionBusinessDelegate.getBusbarSectionInstance().getBusbarSection( new BusbarSectionFetchOneSummary(id) );	
		return busbarSection;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private BusbarSection busbarSection 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(BusbarSectionBusinessDelegate.class.getName());
    
}
