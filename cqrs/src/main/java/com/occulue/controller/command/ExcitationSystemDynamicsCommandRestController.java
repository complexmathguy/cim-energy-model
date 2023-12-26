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
 * Implements Spring Controller command CQRS processing for entity ExcitationSystemDynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcitationSystemDynamics")
public class ExcitationSystemDynamicsCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcitationSystemDynamics.  if not key provided, calls create, otherwise calls save
     * @param		ExcitationSystemDynamics	excitationSystemDynamics
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcitationSystemDynamicsCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcitationSystemDynamicsBusinessDelegate.getExcitationSystemDynamicsInstance().createExcitationSystemDynamics( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcitationSystemDynamics.  if no key provided, calls create, otherwise calls save
     * @param		ExcitationSystemDynamics excitationSystemDynamics
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcitationSystemDynamicsCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcitationSystemDynamicsCommand
			// -----------------------------------------------
			completableFuture = ExcitationSystemDynamicsBusinessDelegate.getExcitationSystemDynamicsInstance().updateExcitationSystemDynamics(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcitationSystemDynamicsController:update() - successfully update ExcitationSystemDynamics - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcitationSystemDynamics entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excitationSystemDynamicsId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcitationSystemDynamicsCommand command = new DeleteExcitationSystemDynamicsCommand( excitationSystemDynamicsId );

    	try {
        	ExcitationSystemDynamicsBusinessDelegate delegate = ExcitationSystemDynamicsBusinessDelegate.getExcitationSystemDynamicsInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcitationSystemDynamics with key " + command.getExcitationSystemDynamicsId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcitationSystemDynamics excitationSystemDynamics = null;
    private static final Logger LOGGER = Logger.getLogger(ExcitationSystemDynamicsCommandRestController.class.getName());
    
}
