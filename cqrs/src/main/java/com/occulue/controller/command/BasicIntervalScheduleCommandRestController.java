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
 * Implements Spring Controller command CQRS processing for entity BasicIntervalSchedule.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/BasicIntervalSchedule")
public class BasicIntervalScheduleCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a BasicIntervalSchedule.  if not key provided, calls create, otherwise calls save
     * @param		BasicIntervalSchedule	basicIntervalSchedule
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateBasicIntervalScheduleCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = BasicIntervalScheduleBusinessDelegate.getBasicIntervalScheduleInstance().createBasicIntervalSchedule( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a BasicIntervalSchedule.  if no key provided, calls create, otherwise calls save
     * @param		BasicIntervalSchedule basicIntervalSchedule
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateBasicIntervalScheduleCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateBasicIntervalScheduleCommand
			// -----------------------------------------------
			completableFuture = BasicIntervalScheduleBusinessDelegate.getBasicIntervalScheduleInstance().updateBasicIntervalSchedule(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "BasicIntervalScheduleController:update() - successfully update BasicIntervalSchedule - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a BasicIntervalSchedule entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID basicIntervalScheduleId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteBasicIntervalScheduleCommand command = new DeleteBasicIntervalScheduleCommand( basicIntervalScheduleId );

    	try {
        	BasicIntervalScheduleBusinessDelegate delegate = BasicIntervalScheduleBusinessDelegate.getBasicIntervalScheduleInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted BasicIntervalSchedule with key " + command.getBasicIntervalScheduleId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected BasicIntervalSchedule basicIntervalSchedule = null;
    private static final Logger LOGGER = Logger.getLogger(BasicIntervalScheduleCommandRestController.class.getName());
    
}
