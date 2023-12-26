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
 * SvShuntCompensatorSections business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of SvShuntCompensatorSections related services in the case of a SvShuntCompensatorSections business related service failing.</li>
 * <li>Exposes a simpler, uniform SvShuntCompensatorSections interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill SvShuntCompensatorSections business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class SvShuntCompensatorSectionsBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public SvShuntCompensatorSectionsBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* SvShuntCompensatorSections Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	SvShuntCompensatorSectionsBusinessDelegate
	*/
	public static SvShuntCompensatorSectionsBusinessDelegate getSvShuntCompensatorSectionsInstance() {
		return( new SvShuntCompensatorSectionsBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createSvShuntCompensatorSections( CreateSvShuntCompensatorSectionsCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getSvShuntCompensatorSectionsId() == null )
				command.setSvShuntCompensatorSectionsId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	SvShuntCompensatorSectionsValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateSvShuntCompensatorSectionsCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateSvShuntCompensatorSectionsCommand of SvShuntCompensatorSections is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create SvShuntCompensatorSections - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateSvShuntCompensatorSectionsCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateSvShuntCompensatorSections( UpdateSvShuntCompensatorSectionsCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	SvShuntCompensatorSectionsValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateSvShuntCompensatorSectionsCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save SvShuntCompensatorSections - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteSvShuntCompensatorSectionsCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteSvShuntCompensatorSectionsCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	SvShuntCompensatorSectionsValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteSvShuntCompensatorSectionsCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete SvShuntCompensatorSections using Id = "  + command.getSvShuntCompensatorSectionsId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the SvShuntCompensatorSections via SvShuntCompensatorSectionsFetchOneSummary
     * @param 	summary SvShuntCompensatorSectionsFetchOneSummary 
     * @return 	SvShuntCompensatorSectionsFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public SvShuntCompensatorSections getSvShuntCompensatorSections( SvShuntCompensatorSectionsFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "SvShuntCompensatorSectionsFetchOneSummary arg cannot be null" );
    	
    	SvShuntCompensatorSections entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	SvShuntCompensatorSectionsValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a SvShuntCompensatorSections
        	// --------------------------------------
        	CompletableFuture<SvShuntCompensatorSections> futureEntity = queryGateway.query(new FindSvShuntCompensatorSectionsQuery( new LoadSvShuntCompensatorSectionsFilter( summary.getSvShuntCompensatorSectionsId() ) ), ResponseTypes.instanceOf(SvShuntCompensatorSections.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate SvShuntCompensatorSections with id " + summary.getSvShuntCompensatorSectionsId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all SvShuntCompensatorSectionss
     *
     * @return 	List<SvShuntCompensatorSections> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<SvShuntCompensatorSections> getAllSvShuntCompensatorSections() 
    throws ProcessingException {
        List<SvShuntCompensatorSections> list = null;

        try {
        	CompletableFuture<List<SvShuntCompensatorSections>> futureList = queryGateway.query(new FindAllSvShuntCompensatorSectionsQuery(), ResponseTypes.multipleInstancesOf(SvShuntCompensatorSections.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all SvShuntCompensatorSections";
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
	 * @return		SvShuntCompensatorSections
	 */
	protected SvShuntCompensatorSections load( UUID id ) throws ProcessingException {
		svShuntCompensatorSections = SvShuntCompensatorSectionsBusinessDelegate.getSvShuntCompensatorSectionsInstance().getSvShuntCompensatorSections( new SvShuntCompensatorSectionsFetchOneSummary(id) );	
		return svShuntCompensatorSections;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private SvShuntCompensatorSections svShuntCompensatorSections 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(SvShuntCompensatorSectionsBusinessDelegate.class.getName());
    
}
