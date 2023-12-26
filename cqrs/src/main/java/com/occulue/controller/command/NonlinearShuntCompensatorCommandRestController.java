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
 * Implements Spring Controller command CQRS processing for entity NonlinearShuntCompensator.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/NonlinearShuntCompensator")
public class NonlinearShuntCompensatorCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a NonlinearShuntCompensator.  if not key provided, calls create, otherwise calls save
     * @param		NonlinearShuntCompensator	nonlinearShuntCompensator
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateNonlinearShuntCompensatorCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = NonlinearShuntCompensatorBusinessDelegate.getNonlinearShuntCompensatorInstance().createNonlinearShuntCompensator( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a NonlinearShuntCompensator.  if no key provided, calls create, otherwise calls save
     * @param		NonlinearShuntCompensator nonlinearShuntCompensator
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateNonlinearShuntCompensatorCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateNonlinearShuntCompensatorCommand
			// -----------------------------------------------
			completableFuture = NonlinearShuntCompensatorBusinessDelegate.getNonlinearShuntCompensatorInstance().updateNonlinearShuntCompensator(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "NonlinearShuntCompensatorController:update() - successfully update NonlinearShuntCompensator - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a NonlinearShuntCompensator entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID nonlinearShuntCompensatorId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteNonlinearShuntCompensatorCommand command = new DeleteNonlinearShuntCompensatorCommand( nonlinearShuntCompensatorId );

    	try {
        	NonlinearShuntCompensatorBusinessDelegate delegate = NonlinearShuntCompensatorBusinessDelegate.getNonlinearShuntCompensatorInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted NonlinearShuntCompensator with key " + command.getNonlinearShuntCompensatorId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected NonlinearShuntCompensator nonlinearShuntCompensator = null;
    private static final Logger LOGGER = Logger.getLogger(NonlinearShuntCompensatorCommandRestController.class.getName());
    
}
