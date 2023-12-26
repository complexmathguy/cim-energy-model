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
 * Implements Spring Controller command CQRS processing for entity RotatingMachine.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/RotatingMachine")
public class RotatingMachineCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a RotatingMachine.  if not key provided, calls create, otherwise calls save
     * @param		RotatingMachine	rotatingMachine
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateRotatingMachineCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = RotatingMachineBusinessDelegate.getRotatingMachineInstance().createRotatingMachine( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a RotatingMachine.  if no key provided, calls create, otherwise calls save
     * @param		RotatingMachine rotatingMachine
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateRotatingMachineCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateRotatingMachineCommand
			// -----------------------------------------------
			completableFuture = RotatingMachineBusinessDelegate.getRotatingMachineInstance().updateRotatingMachine(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "RotatingMachineController:update() - successfully update RotatingMachine - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a RotatingMachine entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID rotatingMachineId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteRotatingMachineCommand command = new DeleteRotatingMachineCommand( rotatingMachineId );

    	try {
        	RotatingMachineBusinessDelegate delegate = RotatingMachineBusinessDelegate.getRotatingMachineInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted RotatingMachine with key " + command.getRotatingMachineId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected RotatingMachine rotatingMachine = null;
    private static final Logger LOGGER = Logger.getLogger(RotatingMachineCommandRestController.class.getName());
    
}
