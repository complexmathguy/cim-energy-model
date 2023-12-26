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
 * VsCapabilityCurve business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of VsCapabilityCurve related services in the case of a VsCapabilityCurve business related service failing.</li>
 * <li>Exposes a simpler, uniform VsCapabilityCurve interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill VsCapabilityCurve business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class VsCapabilityCurveBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public VsCapabilityCurveBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* VsCapabilityCurve Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	VsCapabilityCurveBusinessDelegate
	*/
	public static VsCapabilityCurveBusinessDelegate getVsCapabilityCurveInstance() {
		return( new VsCapabilityCurveBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createVsCapabilityCurve( CreateVsCapabilityCurveCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getVsCapabilityCurveId() == null )
				command.setVsCapabilityCurveId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	VsCapabilityCurveValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateVsCapabilityCurveCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateVsCapabilityCurveCommand of VsCapabilityCurve is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create VsCapabilityCurve - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateVsCapabilityCurveCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateVsCapabilityCurve( UpdateVsCapabilityCurveCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	VsCapabilityCurveValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateVsCapabilityCurveCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save VsCapabilityCurve - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteVsCapabilityCurveCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteVsCapabilityCurveCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	VsCapabilityCurveValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteVsCapabilityCurveCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete VsCapabilityCurve using Id = "  + command.getVsCapabilityCurveId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the VsCapabilityCurve via VsCapabilityCurveFetchOneSummary
     * @param 	summary VsCapabilityCurveFetchOneSummary 
     * @return 	VsCapabilityCurveFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public VsCapabilityCurve getVsCapabilityCurve( VsCapabilityCurveFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "VsCapabilityCurveFetchOneSummary arg cannot be null" );
    	
    	VsCapabilityCurve entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	VsCapabilityCurveValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a VsCapabilityCurve
        	// --------------------------------------
        	CompletableFuture<VsCapabilityCurve> futureEntity = queryGateway.query(new FindVsCapabilityCurveQuery( new LoadVsCapabilityCurveFilter( summary.getVsCapabilityCurveId() ) ), ResponseTypes.instanceOf(VsCapabilityCurve.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate VsCapabilityCurve with id " + summary.getVsCapabilityCurveId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all VsCapabilityCurves
     *
     * @return 	List<VsCapabilityCurve> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<VsCapabilityCurve> getAllVsCapabilityCurve() 
    throws ProcessingException {
        List<VsCapabilityCurve> list = null;

        try {
        	CompletableFuture<List<VsCapabilityCurve>> futureList = queryGateway.query(new FindAllVsCapabilityCurveQuery(), ResponseTypes.multipleInstancesOf(VsCapabilityCurve.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all VsCapabilityCurve";
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
	 * @return		VsCapabilityCurve
	 */
	protected VsCapabilityCurve load( UUID id ) throws ProcessingException {
		vsCapabilityCurve = VsCapabilityCurveBusinessDelegate.getVsCapabilityCurveInstance().getVsCapabilityCurve( new VsCapabilityCurveFetchOneSummary(id) );	
		return vsCapabilityCurve;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private VsCapabilityCurve vsCapabilityCurve 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(VsCapabilityCurveBusinessDelegate.class.getName());
    
}
