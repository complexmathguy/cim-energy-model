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
 * Implements Spring Controller command CQRS processing for entity CurrentFlow.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/CurrentFlow")
public class CurrentFlowCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a CurrentFlow.  if not key provided, calls create, otherwise calls save
     * @param		CurrentFlow	currentFlow
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateCurrentFlowCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = CurrentFlowBusinessDelegate.getCurrentFlowInstance().createCurrentFlow( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a CurrentFlow.  if no key provided, calls create, otherwise calls save
     * @param		CurrentFlow currentFlow
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateCurrentFlowCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateCurrentFlowCommand
			// -----------------------------------------------
			completableFuture = CurrentFlowBusinessDelegate.getCurrentFlowInstance().updateCurrentFlow(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "CurrentFlowController:update() - successfully update CurrentFlow - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a CurrentFlow entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID currentFlowId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteCurrentFlowCommand command = new DeleteCurrentFlowCommand( currentFlowId );

    	try {
        	CurrentFlowBusinessDelegate delegate = CurrentFlowBusinessDelegate.getCurrentFlowInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted CurrentFlow with key " + command.getCurrentFlowId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected CurrentFlow currentFlow = null;
    private static final Logger LOGGER = Logger.getLogger(CurrentFlowCommandRestController.class.getName());
    
}
