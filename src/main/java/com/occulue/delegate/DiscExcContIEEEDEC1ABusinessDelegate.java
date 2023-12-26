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
 * DiscExcContIEEEDEC1A business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of DiscExcContIEEEDEC1A related services in the case of a DiscExcContIEEEDEC1A business related service failing.</li>
 * <li>Exposes a simpler, uniform DiscExcContIEEEDEC1A interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill DiscExcContIEEEDEC1A business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class DiscExcContIEEEDEC1ABusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public DiscExcContIEEEDEC1ABusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* DiscExcContIEEEDEC1A Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	DiscExcContIEEEDEC1ABusinessDelegate
	*/
	public static DiscExcContIEEEDEC1ABusinessDelegate getDiscExcContIEEEDEC1AInstance() {
		return( new DiscExcContIEEEDEC1ABusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createDiscExcContIEEEDEC1A( CreateDiscExcContIEEEDEC1ACommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getDiscExcContIEEEDEC1AId() == null )
				command.setDiscExcContIEEEDEC1AId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	DiscExcContIEEEDEC1AValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateDiscExcContIEEEDEC1ACommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateDiscExcContIEEEDEC1ACommand of DiscExcContIEEEDEC1A is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create DiscExcContIEEEDEC1A - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateDiscExcContIEEEDEC1ACommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateDiscExcContIEEEDEC1A( UpdateDiscExcContIEEEDEC1ACommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	DiscExcContIEEEDEC1AValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateDiscExcContIEEEDEC1ACommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save DiscExcContIEEEDEC1A - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteDiscExcContIEEEDEC1ACommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteDiscExcContIEEEDEC1ACommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	DiscExcContIEEEDEC1AValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteDiscExcContIEEEDEC1ACommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete DiscExcContIEEEDEC1A using Id = "  + command.getDiscExcContIEEEDEC1AId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the DiscExcContIEEEDEC1A via DiscExcContIEEEDEC1AFetchOneSummary
     * @param 	summary DiscExcContIEEEDEC1AFetchOneSummary 
     * @return 	DiscExcContIEEEDEC1AFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public DiscExcContIEEEDEC1A getDiscExcContIEEEDEC1A( DiscExcContIEEEDEC1AFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "DiscExcContIEEEDEC1AFetchOneSummary arg cannot be null" );
    	
    	DiscExcContIEEEDEC1A entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	DiscExcContIEEEDEC1AValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a DiscExcContIEEEDEC1A
        	// --------------------------------------
        	CompletableFuture<DiscExcContIEEEDEC1A> futureEntity = queryGateway.query(new FindDiscExcContIEEEDEC1AQuery( new LoadDiscExcContIEEEDEC1AFilter( summary.getDiscExcContIEEEDEC1AId() ) ), ResponseTypes.instanceOf(DiscExcContIEEEDEC1A.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate DiscExcContIEEEDEC1A with id " + summary.getDiscExcContIEEEDEC1AId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all DiscExcContIEEEDEC1As
     *
     * @return 	List<DiscExcContIEEEDEC1A> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<DiscExcContIEEEDEC1A> getAllDiscExcContIEEEDEC1A() 
    throws ProcessingException {
        List<DiscExcContIEEEDEC1A> list = null;

        try {
        	CompletableFuture<List<DiscExcContIEEEDEC1A>> futureList = queryGateway.query(new FindAllDiscExcContIEEEDEC1AQuery(), ResponseTypes.multipleInstancesOf(DiscExcContIEEEDEC1A.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all DiscExcContIEEEDEC1A";
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
	 * @return		DiscExcContIEEEDEC1A
	 */
	protected DiscExcContIEEEDEC1A load( UUID id ) throws ProcessingException {
		discExcContIEEEDEC1A = DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().getDiscExcContIEEEDEC1A( new DiscExcContIEEEDEC1AFetchOneSummary(id) );	
		return discExcContIEEEDEC1A;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private DiscExcContIEEEDEC1A discExcContIEEEDEC1A 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(DiscExcContIEEEDEC1ABusinessDelegate.class.getName());
    
}
