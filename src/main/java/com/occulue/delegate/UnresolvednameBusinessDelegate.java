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
 * Unresolvedname business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of Unresolvedname related services in the case of a Unresolvedname business related service failing.</li>
 * <li>Exposes a simpler, uniform Unresolvedname interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill Unresolvedname business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class UnresolvednameBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public UnresolvednameBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* Unresolvedname Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	UnresolvednameBusinessDelegate
	*/
	public static UnresolvednameBusinessDelegate getUnresolvednameInstance() {
		return( new UnresolvednameBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createUnresolvedname( CreateUnresolvednameCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getUnresolvednameId() == null )
				command.setUnresolvednameId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	UnresolvednameValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateUnresolvednameCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateUnresolvednameCommand of Unresolvedname is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create Unresolvedname - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateUnresolvednameCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateUnresolvedname( UpdateUnresolvednameCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	UnresolvednameValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateUnresolvednameCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save Unresolvedname - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteUnresolvednameCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteUnresolvednameCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	UnresolvednameValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteUnresolvednameCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete Unresolvedname using Id = "  + command.getUnresolvednameId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the Unresolvedname via UnresolvednameFetchOneSummary
     * @param 	summary UnresolvednameFetchOneSummary 
     * @return 	UnresolvednameFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public Unresolvedname getUnresolvedname( UnresolvednameFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "UnresolvednameFetchOneSummary arg cannot be null" );
    	
    	Unresolvedname entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	UnresolvednameValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a Unresolvedname
        	// --------------------------------------
        	CompletableFuture<Unresolvedname> futureEntity = queryGateway.query(new FindUnresolvednameQuery( new LoadUnresolvednameFilter( summary.getUnresolvednameId() ) ), ResponseTypes.instanceOf(Unresolvedname.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate Unresolvedname with id " + summary.getUnresolvednameId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all Unresolvednames
     *
     * @return 	List<Unresolvedname> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<Unresolvedname> getAllUnresolvedname() 
    throws ProcessingException {
        List<Unresolvedname> list = null;

        try {
        	CompletableFuture<List<Unresolvedname>> futureList = queryGateway.query(new FindAllUnresolvednameQuery(), ResponseTypes.multipleInstancesOf(Unresolvedname.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all Unresolvedname";
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
	 * @return		Unresolvedname
	 */
	protected Unresolvedname load( UUID id ) throws ProcessingException {
		unresolvedname = UnresolvednameBusinessDelegate.getUnresolvednameInstance().getUnresolvedname( new UnresolvednameFetchOneSummary(id) );	
		return unresolvedname;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private Unresolvedname unresolvedname 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(UnresolvednameBusinessDelegate.class.getName());
    
}
