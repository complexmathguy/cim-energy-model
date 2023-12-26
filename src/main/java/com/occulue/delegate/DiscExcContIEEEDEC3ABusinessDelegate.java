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
 * DiscExcContIEEEDEC3A business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of DiscExcContIEEEDEC3A related services in the case of a DiscExcContIEEEDEC3A business related service failing.</li>
 * <li>Exposes a simpler, uniform DiscExcContIEEEDEC3A interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill DiscExcContIEEEDEC3A business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class DiscExcContIEEEDEC3ABusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public DiscExcContIEEEDEC3ABusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* DiscExcContIEEEDEC3A Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	DiscExcContIEEEDEC3ABusinessDelegate
	*/
	public static DiscExcContIEEEDEC3ABusinessDelegate getDiscExcContIEEEDEC3AInstance() {
		return( new DiscExcContIEEEDEC3ABusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createDiscExcContIEEEDEC3A( CreateDiscExcContIEEEDEC3ACommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getDiscExcContIEEEDEC3AId() == null )
				command.setDiscExcContIEEEDEC3AId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	DiscExcContIEEEDEC3AValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateDiscExcContIEEEDEC3ACommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateDiscExcContIEEEDEC3ACommand of DiscExcContIEEEDEC3A is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create DiscExcContIEEEDEC3A - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateDiscExcContIEEEDEC3ACommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateDiscExcContIEEEDEC3A( UpdateDiscExcContIEEEDEC3ACommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	DiscExcContIEEEDEC3AValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateDiscExcContIEEEDEC3ACommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save DiscExcContIEEEDEC3A - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteDiscExcContIEEEDEC3ACommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteDiscExcContIEEEDEC3ACommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	DiscExcContIEEEDEC3AValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteDiscExcContIEEEDEC3ACommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete DiscExcContIEEEDEC3A using Id = "  + command.getDiscExcContIEEEDEC3AId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the DiscExcContIEEEDEC3A via DiscExcContIEEEDEC3AFetchOneSummary
     * @param 	summary DiscExcContIEEEDEC3AFetchOneSummary 
     * @return 	DiscExcContIEEEDEC3AFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public DiscExcContIEEEDEC3A getDiscExcContIEEEDEC3A( DiscExcContIEEEDEC3AFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "DiscExcContIEEEDEC3AFetchOneSummary arg cannot be null" );
    	
    	DiscExcContIEEEDEC3A entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	DiscExcContIEEEDEC3AValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a DiscExcContIEEEDEC3A
        	// --------------------------------------
        	CompletableFuture<DiscExcContIEEEDEC3A> futureEntity = queryGateway.query(new FindDiscExcContIEEEDEC3AQuery( new LoadDiscExcContIEEEDEC3AFilter( summary.getDiscExcContIEEEDEC3AId() ) ), ResponseTypes.instanceOf(DiscExcContIEEEDEC3A.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate DiscExcContIEEEDEC3A with id " + summary.getDiscExcContIEEEDEC3AId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all DiscExcContIEEEDEC3As
     *
     * @return 	List<DiscExcContIEEEDEC3A> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<DiscExcContIEEEDEC3A> getAllDiscExcContIEEEDEC3A() 
    throws ProcessingException {
        List<DiscExcContIEEEDEC3A> list = null;

        try {
        	CompletableFuture<List<DiscExcContIEEEDEC3A>> futureList = queryGateway.query(new FindAllDiscExcContIEEEDEC3AQuery(), ResponseTypes.multipleInstancesOf(DiscExcContIEEEDEC3A.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all DiscExcContIEEEDEC3A";
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
	 * @return		DiscExcContIEEEDEC3A
	 */
	protected DiscExcContIEEEDEC3A load( UUID id ) throws ProcessingException {
		discExcContIEEEDEC3A = DiscExcContIEEEDEC3ABusinessDelegate.getDiscExcContIEEEDEC3AInstance().getDiscExcContIEEEDEC3A( new DiscExcContIEEEDEC3AFetchOneSummary(id) );	
		return discExcContIEEEDEC3A;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private DiscExcContIEEEDEC3A discExcContIEEEDEC3A 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(DiscExcContIEEEDEC3ABusinessDelegate.class.getName());
    
}
