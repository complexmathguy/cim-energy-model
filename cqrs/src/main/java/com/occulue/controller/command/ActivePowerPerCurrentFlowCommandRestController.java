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
 * Implements Spring Controller command CQRS processing for entity ActivePowerPerCurrentFlow.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ActivePowerPerCurrentFlow")
public class ActivePowerPerCurrentFlowCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ActivePowerPerCurrentFlow.  if not key provided, calls create, otherwise calls save
     * @param		ActivePowerPerCurrentFlow	activePowerPerCurrentFlow
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateActivePowerPerCurrentFlowCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ActivePowerPerCurrentFlowBusinessDelegate.getActivePowerPerCurrentFlowInstance().createActivePowerPerCurrentFlow( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ActivePowerPerCurrentFlow.  if no key provided, calls create, otherwise calls save
     * @param		ActivePowerPerCurrentFlow activePowerPerCurrentFlow
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateActivePowerPerCurrentFlowCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateActivePowerPerCurrentFlowCommand
			// -----------------------------------------------
			completableFuture = ActivePowerPerCurrentFlowBusinessDelegate.getActivePowerPerCurrentFlowInstance().updateActivePowerPerCurrentFlow(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ActivePowerPerCurrentFlowController:update() - successfully update ActivePowerPerCurrentFlow - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ActivePowerPerCurrentFlow entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID activePowerPerCurrentFlowId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteActivePowerPerCurrentFlowCommand command = new DeleteActivePowerPerCurrentFlowCommand( activePowerPerCurrentFlowId );

    	try {
        	ActivePowerPerCurrentFlowBusinessDelegate delegate = ActivePowerPerCurrentFlowBusinessDelegate.getActivePowerPerCurrentFlowInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ActivePowerPerCurrentFlow with key " + command.getActivePowerPerCurrentFlowId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ActivePowerPerCurrentFlow activePowerPerCurrentFlow = null;
    private static final Logger LOGGER = Logger.getLogger(ActivePowerPerCurrentFlowCommandRestController.class.getName());
    
}
