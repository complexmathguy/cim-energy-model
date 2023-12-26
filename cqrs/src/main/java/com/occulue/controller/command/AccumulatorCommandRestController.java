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
 * Implements Spring Controller command CQRS processing for entity Accumulator.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Accumulator")
public class AccumulatorCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a Accumulator.  if not key provided, calls create, otherwise calls save
     * @param		Accumulator	accumulator
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateAccumulatorCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = AccumulatorBusinessDelegate.getAccumulatorInstance().createAccumulator( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a Accumulator.  if no key provided, calls create, otherwise calls save
     * @param		Accumulator accumulator
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateAccumulatorCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateAccumulatorCommand
			// -----------------------------------------------
			completableFuture = AccumulatorBusinessDelegate.getAccumulatorInstance().updateAccumulator(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "AccumulatorController:update() - successfully update Accumulator - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a Accumulator entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID accumulatorId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteAccumulatorCommand command = new DeleteAccumulatorCommand( accumulatorId );

    	try {
        	AccumulatorBusinessDelegate delegate = AccumulatorBusinessDelegate.getAccumulatorInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted Accumulator with key " + command.getAccumulatorId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected Accumulator accumulator = null;
    private static final Logger LOGGER = Logger.getLogger(AccumulatorCommandRestController.class.getName());
    
}
