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
 * Implements Spring Controller command CQRS processing for entity AccumulatorLimit.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/AccumulatorLimit")
public class AccumulatorLimitCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a AccumulatorLimit.  if not key provided, calls create, otherwise calls save
     * @param		AccumulatorLimit	accumulatorLimit
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateAccumulatorLimitCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = AccumulatorLimitBusinessDelegate.getAccumulatorLimitInstance().createAccumulatorLimit( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a AccumulatorLimit.  if no key provided, calls create, otherwise calls save
     * @param		AccumulatorLimit accumulatorLimit
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateAccumulatorLimitCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateAccumulatorLimitCommand
			// -----------------------------------------------
			completableFuture = AccumulatorLimitBusinessDelegate.getAccumulatorLimitInstance().updateAccumulatorLimit(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "AccumulatorLimitController:update() - successfully update AccumulatorLimit - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a AccumulatorLimit entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID accumulatorLimitId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteAccumulatorLimitCommand command = new DeleteAccumulatorLimitCommand( accumulatorLimitId );

    	try {
        	AccumulatorLimitBusinessDelegate delegate = AccumulatorLimitBusinessDelegate.getAccumulatorLimitInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted AccumulatorLimit with key " + command.getAccumulatorLimitId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected AccumulatorLimit accumulatorLimit = null;
    private static final Logger LOGGER = Logger.getLogger(AccumulatorLimitCommandRestController.class.getName());
    
}
