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
 * PerLengthDCLineParameter business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of PerLengthDCLineParameter related services in the case of a PerLengthDCLineParameter business related service failing.</li>
 * <li>Exposes a simpler, uniform PerLengthDCLineParameter interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill PerLengthDCLineParameter business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class PerLengthDCLineParameterBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public PerLengthDCLineParameterBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* PerLengthDCLineParameter Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	PerLengthDCLineParameterBusinessDelegate
	*/
	public static PerLengthDCLineParameterBusinessDelegate getPerLengthDCLineParameterInstance() {
		return( new PerLengthDCLineParameterBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createPerLengthDCLineParameter( CreatePerLengthDCLineParameterCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getPerLengthDCLineParameterId() == null )
				command.setPerLengthDCLineParameterId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PerLengthDCLineParameterValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreatePerLengthDCLineParameterCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreatePerLengthDCLineParameterCommand of PerLengthDCLineParameter is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create PerLengthDCLineParameter - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdatePerLengthDCLineParameterCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updatePerLengthDCLineParameter( UpdatePerLengthDCLineParameterCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	PerLengthDCLineParameterValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdatePerLengthDCLineParameterCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save PerLengthDCLineParameter - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeletePerLengthDCLineParameterCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeletePerLengthDCLineParameterCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PerLengthDCLineParameterValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeletePerLengthDCLineParameterCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete PerLengthDCLineParameter using Id = "  + command.getPerLengthDCLineParameterId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the PerLengthDCLineParameter via PerLengthDCLineParameterFetchOneSummary
     * @param 	summary PerLengthDCLineParameterFetchOneSummary 
     * @return 	PerLengthDCLineParameterFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public PerLengthDCLineParameter getPerLengthDCLineParameter( PerLengthDCLineParameterFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "PerLengthDCLineParameterFetchOneSummary arg cannot be null" );
    	
    	PerLengthDCLineParameter entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	PerLengthDCLineParameterValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a PerLengthDCLineParameter
        	// --------------------------------------
        	CompletableFuture<PerLengthDCLineParameter> futureEntity = queryGateway.query(new FindPerLengthDCLineParameterQuery( new LoadPerLengthDCLineParameterFilter( summary.getPerLengthDCLineParameterId() ) ), ResponseTypes.instanceOf(PerLengthDCLineParameter.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate PerLengthDCLineParameter with id " + summary.getPerLengthDCLineParameterId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all PerLengthDCLineParameters
     *
     * @return 	List<PerLengthDCLineParameter> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<PerLengthDCLineParameter> getAllPerLengthDCLineParameter() 
    throws ProcessingException {
        List<PerLengthDCLineParameter> list = null;

        try {
        	CompletableFuture<List<PerLengthDCLineParameter>> futureList = queryGateway.query(new FindAllPerLengthDCLineParameterQuery(), ResponseTypes.multipleInstancesOf(PerLengthDCLineParameter.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all PerLengthDCLineParameter";
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
	 * @return		PerLengthDCLineParameter
	 */
	protected PerLengthDCLineParameter load( UUID id ) throws ProcessingException {
		perLengthDCLineParameter = PerLengthDCLineParameterBusinessDelegate.getPerLengthDCLineParameterInstance().getPerLengthDCLineParameter( new PerLengthDCLineParameterFetchOneSummary(id) );	
		return perLengthDCLineParameter;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private PerLengthDCLineParameter perLengthDCLineParameter 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(PerLengthDCLineParameterBusinessDelegate.class.getName());
    
}
