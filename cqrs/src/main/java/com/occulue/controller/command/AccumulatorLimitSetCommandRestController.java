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
 * Implements Spring Controller command CQRS processing for entity AccumulatorLimitSet.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/AccumulatorLimitSet")
public class AccumulatorLimitSetCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a AccumulatorLimitSet.  if not key provided, calls create, otherwise calls save
     * @param		AccumulatorLimitSet	accumulatorLimitSet
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateAccumulatorLimitSetCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = AccumulatorLimitSetBusinessDelegate.getAccumulatorLimitSetInstance().createAccumulatorLimitSet( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a AccumulatorLimitSet.  if no key provided, calls create, otherwise calls save
     * @param		AccumulatorLimitSet accumulatorLimitSet
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateAccumulatorLimitSetCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateAccumulatorLimitSetCommand
			// -----------------------------------------------
			completableFuture = AccumulatorLimitSetBusinessDelegate.getAccumulatorLimitSetInstance().updateAccumulatorLimitSet(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "AccumulatorLimitSetController:update() - successfully update AccumulatorLimitSet - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a AccumulatorLimitSet entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID accumulatorLimitSetId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteAccumulatorLimitSetCommand command = new DeleteAccumulatorLimitSetCommand( accumulatorLimitSetId );

    	try {
        	AccumulatorLimitSetBusinessDelegate delegate = AccumulatorLimitSetBusinessDelegate.getAccumulatorLimitSetInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted AccumulatorLimitSet with key " + command.getAccumulatorLimitSetId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected AccumulatorLimitSet accumulatorLimitSet = null;
    private static final Logger LOGGER = Logger.getLogger(AccumulatorLimitSetCommandRestController.class.getName());
    
}
