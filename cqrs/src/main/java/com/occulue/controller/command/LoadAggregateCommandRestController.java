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
 * Implements Spring Controller command CQRS processing for entity LoadAggregate.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/LoadAggregate")
public class LoadAggregateCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a LoadAggregate.  if not key provided, calls create, otherwise calls save
     * @param		LoadAggregate	loadAggregate
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateLoadAggregateCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = LoadAggregateBusinessDelegate.getLoadAggregateInstance().createLoadAggregate( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a LoadAggregate.  if no key provided, calls create, otherwise calls save
     * @param		LoadAggregate loadAggregate
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateLoadAggregateCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateLoadAggregateCommand
			// -----------------------------------------------
			completableFuture = LoadAggregateBusinessDelegate.getLoadAggregateInstance().updateLoadAggregate(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "LoadAggregateController:update() - successfully update LoadAggregate - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a LoadAggregate entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID loadAggregateId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteLoadAggregateCommand command = new DeleteLoadAggregateCommand( loadAggregateId );

    	try {
        	LoadAggregateBusinessDelegate delegate = LoadAggregateBusinessDelegate.getLoadAggregateInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted LoadAggregate with key " + command.getLoadAggregateId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected LoadAggregate loadAggregate = null;
    private static final Logger LOGGER = Logger.getLogger(LoadAggregateCommandRestController.class.getName());
    
}
