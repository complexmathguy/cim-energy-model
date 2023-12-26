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
 * Implements Spring Controller command CQRS processing for entity StateVariablesVersion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/StateVariablesVersion")
public class StateVariablesVersionCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a StateVariablesVersion.  if not key provided, calls create, otherwise calls save
     * @param		StateVariablesVersion	stateVariablesVersion
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateStateVariablesVersionCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = StateVariablesVersionBusinessDelegate.getStateVariablesVersionInstance().createStateVariablesVersion( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a StateVariablesVersion.  if no key provided, calls create, otherwise calls save
     * @param		StateVariablesVersion stateVariablesVersion
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateStateVariablesVersionCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateStateVariablesVersionCommand
			// -----------------------------------------------
			completableFuture = StateVariablesVersionBusinessDelegate.getStateVariablesVersionInstance().updateStateVariablesVersion(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "StateVariablesVersionController:update() - successfully update StateVariablesVersion - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a StateVariablesVersion entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID stateVariablesVersionId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteStateVariablesVersionCommand command = new DeleteStateVariablesVersionCommand( stateVariablesVersionId );

    	try {
        	StateVariablesVersionBusinessDelegate delegate = StateVariablesVersionBusinessDelegate.getStateVariablesVersionInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted StateVariablesVersion with key " + command.getStateVariablesVersionId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected StateVariablesVersion stateVariablesVersion = null;
    private static final Logger LOGGER = Logger.getLogger(StateVariablesVersionCommandRestController.class.getName());
    
}
