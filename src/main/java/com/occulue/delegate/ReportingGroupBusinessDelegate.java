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
 * ReportingGroup business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of ReportingGroup related services in the case of a ReportingGroup business related service failing.</li>
 * <li>Exposes a simpler, uniform ReportingGroup interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill ReportingGroup business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class ReportingGroupBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public ReportingGroupBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* ReportingGroup Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	ReportingGroupBusinessDelegate
	*/
	public static ReportingGroupBusinessDelegate getReportingGroupInstance() {
		return( new ReportingGroupBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createReportingGroup( CreateReportingGroupCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getReportingGroupId() == null )
				command.setReportingGroupId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ReportingGroupValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateReportingGroupCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateReportingGroupCommand of ReportingGroup is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create ReportingGroup - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateReportingGroupCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateReportingGroup( UpdateReportingGroupCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	ReportingGroupValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateReportingGroupCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save ReportingGroup - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteReportingGroupCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteReportingGroupCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ReportingGroupValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteReportingGroupCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete ReportingGroup using Id = "  + command.getReportingGroupId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the ReportingGroup via ReportingGroupFetchOneSummary
     * @param 	summary ReportingGroupFetchOneSummary 
     * @return 	ReportingGroupFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public ReportingGroup getReportingGroup( ReportingGroupFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "ReportingGroupFetchOneSummary arg cannot be null" );
    	
    	ReportingGroup entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	ReportingGroupValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a ReportingGroup
        	// --------------------------------------
        	CompletableFuture<ReportingGroup> futureEntity = queryGateway.query(new FindReportingGroupQuery( new LoadReportingGroupFilter( summary.getReportingGroupId() ) ), ResponseTypes.instanceOf(ReportingGroup.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate ReportingGroup with id " + summary.getReportingGroupId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all ReportingGroups
     *
     * @return 	List<ReportingGroup> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<ReportingGroup> getAllReportingGroup() 
    throws ProcessingException {
        List<ReportingGroup> list = null;

        try {
        	CompletableFuture<List<ReportingGroup>> futureList = queryGateway.query(new FindAllReportingGroupQuery(), ResponseTypes.multipleInstancesOf(ReportingGroup.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all ReportingGroup";
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
	 * @return		ReportingGroup
	 */
	protected ReportingGroup load( UUID id ) throws ProcessingException {
		reportingGroup = ReportingGroupBusinessDelegate.getReportingGroupInstance().getReportingGroup( new ReportingGroupFetchOneSummary(id) );	
		return reportingGroup;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private ReportingGroup reportingGroup 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(ReportingGroupBusinessDelegate.class.getName());
    
}
