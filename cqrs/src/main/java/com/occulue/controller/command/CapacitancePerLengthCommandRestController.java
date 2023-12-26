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
 * Implements Spring Controller command CQRS processing for entity CapacitancePerLength.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/CapacitancePerLength")
public class CapacitancePerLengthCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a CapacitancePerLength.  if not key provided, calls create, otherwise calls save
     * @param		CapacitancePerLength	capacitancePerLength
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateCapacitancePerLengthCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = CapacitancePerLengthBusinessDelegate.getCapacitancePerLengthInstance().createCapacitancePerLength( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a CapacitancePerLength.  if no key provided, calls create, otherwise calls save
     * @param		CapacitancePerLength capacitancePerLength
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateCapacitancePerLengthCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateCapacitancePerLengthCommand
			// -----------------------------------------------
			completableFuture = CapacitancePerLengthBusinessDelegate.getCapacitancePerLengthInstance().updateCapacitancePerLength(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "CapacitancePerLengthController:update() - successfully update CapacitancePerLength - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a CapacitancePerLength entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID capacitancePerLengthId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteCapacitancePerLengthCommand command = new DeleteCapacitancePerLengthCommand( capacitancePerLengthId );

    	try {
        	CapacitancePerLengthBusinessDelegate delegate = CapacitancePerLengthBusinessDelegate.getCapacitancePerLengthInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted CapacitancePerLength with key " + command.getCapacitancePerLengthId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected CapacitancePerLength capacitancePerLength = null;
    private static final Logger LOGGER = Logger.getLogger(CapacitancePerLengthCommandRestController.class.getName());
    
}
