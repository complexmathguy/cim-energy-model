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
 * Implements Spring Controller command CQRS processing for entity Capacitance.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Capacitance")
public class CapacitanceCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a Capacitance.  if not key provided, calls create, otherwise calls save
     * @param		Capacitance	capacitance
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateCapacitanceCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = CapacitanceBusinessDelegate.getCapacitanceInstance().createCapacitance( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a Capacitance.  if no key provided, calls create, otherwise calls save
     * @param		Capacitance capacitance
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateCapacitanceCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateCapacitanceCommand
			// -----------------------------------------------
			completableFuture = CapacitanceBusinessDelegate.getCapacitanceInstance().updateCapacitance(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "CapacitanceController:update() - successfully update Capacitance - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a Capacitance entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID capacitanceId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteCapacitanceCommand command = new DeleteCapacitanceCommand( capacitanceId );

    	try {
        	CapacitanceBusinessDelegate delegate = CapacitanceBusinessDelegate.getCapacitanceInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted Capacitance with key " + command.getCapacitanceId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected Capacitance capacitance = null;
    private static final Logger LOGGER = Logger.getLogger(CapacitanceCommandRestController.class.getName());
    
}
