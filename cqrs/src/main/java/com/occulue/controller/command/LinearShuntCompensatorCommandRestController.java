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
 * Implements Spring Controller command CQRS processing for entity LinearShuntCompensator.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/LinearShuntCompensator")
public class LinearShuntCompensatorCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a LinearShuntCompensator.  if not key provided, calls create, otherwise calls save
     * @param		LinearShuntCompensator	linearShuntCompensator
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateLinearShuntCompensatorCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = LinearShuntCompensatorBusinessDelegate.getLinearShuntCompensatorInstance().createLinearShuntCompensator( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a LinearShuntCompensator.  if no key provided, calls create, otherwise calls save
     * @param		LinearShuntCompensator linearShuntCompensator
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateLinearShuntCompensatorCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateLinearShuntCompensatorCommand
			// -----------------------------------------------
			completableFuture = LinearShuntCompensatorBusinessDelegate.getLinearShuntCompensatorInstance().updateLinearShuntCompensator(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "LinearShuntCompensatorController:update() - successfully update LinearShuntCompensator - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a LinearShuntCompensator entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID linearShuntCompensatorId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteLinearShuntCompensatorCommand command = new DeleteLinearShuntCompensatorCommand( linearShuntCompensatorId );

    	try {
        	LinearShuntCompensatorBusinessDelegate delegate = LinearShuntCompensatorBusinessDelegate.getLinearShuntCompensatorInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted LinearShuntCompensator with key " + command.getLinearShuntCompensatorId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected LinearShuntCompensator linearShuntCompensator = null;
    private static final Logger LOGGER = Logger.getLogger(LinearShuntCompensatorCommandRestController.class.getName());
    
}
