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
 * Implements Spring Controller command CQRS processing for entity ShuntCompensator.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ShuntCompensator")
public class ShuntCompensatorCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ShuntCompensator.  if not key provided, calls create, otherwise calls save
     * @param		ShuntCompensator	shuntCompensator
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateShuntCompensatorCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance().createShuntCompensator( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ShuntCompensator.  if no key provided, calls create, otherwise calls save
     * @param		ShuntCompensator shuntCompensator
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateShuntCompensatorCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateShuntCompensatorCommand
			// -----------------------------------------------
			completableFuture = ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance().updateShuntCompensator(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ShuntCompensatorController:update() - successfully update ShuntCompensator - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ShuntCompensator entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID shuntCompensatorId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteShuntCompensatorCommand command = new DeleteShuntCompensatorCommand( shuntCompensatorId );

    	try {
        	ShuntCompensatorBusinessDelegate delegate = ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ShuntCompensator with key " + command.getShuntCompensatorId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ShuntCompensator shuntCompensator = null;
    private static final Logger LOGGER = Logger.getLogger(ShuntCompensatorCommandRestController.class.getName());
    
}
