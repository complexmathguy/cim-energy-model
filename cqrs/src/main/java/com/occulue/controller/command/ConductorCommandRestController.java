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
 * Implements Spring Controller command CQRS processing for entity Conductor.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Conductor")
public class ConductorCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a Conductor.  if not key provided, calls create, otherwise calls save
     * @param		Conductor	conductor
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateConductorCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ConductorBusinessDelegate.getConductorInstance().createConductor( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a Conductor.  if no key provided, calls create, otherwise calls save
     * @param		Conductor conductor
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateConductorCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateConductorCommand
			// -----------------------------------------------
			completableFuture = ConductorBusinessDelegate.getConductorInstance().updateConductor(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ConductorController:update() - successfully update Conductor - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a Conductor entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID conductorId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteConductorCommand command = new DeleteConductorCommand( conductorId );

    	try {
        	ConductorBusinessDelegate delegate = ConductorBusinessDelegate.getConductorInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted Conductor with key " + command.getConductorId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected Conductor conductor = null;
    private static final Logger LOGGER = Logger.getLogger(ConductorCommandRestController.class.getName());
    
}
