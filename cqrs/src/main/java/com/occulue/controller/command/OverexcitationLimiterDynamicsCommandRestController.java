/*******************************************************************************
  Turnstone Biologics Confidential
  
  2018 Turnstone Biologics
  All Rights Reserved.
  
  This file is subject to the terms and conditions defined in
  file 'license.txt', which is part of this source code package.
   
  Contributors :
        Turnstone Biologics - General Release
 ******************************************************************************/
package com.occulue.controller.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.projector.*;

import com.occulue.controller.*;

/** 
 * Implements Spring Controller command CQRS processing for entity OverexcitationLimiterDynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/OverexcitationLimiterDynamics")
public class OverexcitationLimiterDynamicsCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a OverexcitationLimiterDynamics.  if not key provided, calls create, otherwise calls save
     * @param		OverexcitationLimiterDynamics	overexcitationLimiterDynamics
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateOverexcitationLimiterDynamicsCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = OverexcitationLimiterDynamicsBusinessDelegate.getOverexcitationLimiterDynamicsInstance().createOverexcitationLimiterDynamics( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a OverexcitationLimiterDynamics.  if no key provided, calls create, otherwise calls save
     * @param		OverexcitationLimiterDynamics overexcitationLimiterDynamics
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateOverexcitationLimiterDynamicsCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateOverexcitationLimiterDynamicsCommand
			// -----------------------------------------------
			completableFuture = OverexcitationLimiterDynamicsBusinessDelegate.getOverexcitationLimiterDynamicsInstance().updateOverexcitationLimiterDynamics(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "OverexcitationLimiterDynamicsController:update() - successfully update OverexcitationLimiterDynamics - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a OverexcitationLimiterDynamics entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID overexcitationLimiterDynamicsId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteOverexcitationLimiterDynamicsCommand command = new DeleteOverexcitationLimiterDynamicsCommand( overexcitationLimiterDynamicsId );

    	try {
        	OverexcitationLimiterDynamicsBusinessDelegate delegate = OverexcitationLimiterDynamicsBusinessDelegate.getOverexcitationLimiterDynamicsInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted OverexcitationLimiterDynamics with key " + command.getOverexcitationLimiterDynamicsId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected OverexcitationLimiterDynamics overexcitationLimiterDynamics = null;
    private static final Logger LOGGER = Logger.getLogger(OverexcitationLimiterDynamicsCommandRestController.class.getName());
    
}
