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
 * Implements Spring Controller command CQRS processing for entity SwitchSchedule.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SwitchSchedule")
public class SwitchScheduleCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a SwitchSchedule.  if not key provided, calls create, otherwise calls save
     * @param		SwitchSchedule	switchSchedule
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateSwitchScheduleCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = SwitchScheduleBusinessDelegate.getSwitchScheduleInstance().createSwitchSchedule( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a SwitchSchedule.  if no key provided, calls create, otherwise calls save
     * @param		SwitchSchedule switchSchedule
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateSwitchScheduleCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateSwitchScheduleCommand
			// -----------------------------------------------
			completableFuture = SwitchScheduleBusinessDelegate.getSwitchScheduleInstance().updateSwitchSchedule(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "SwitchScheduleController:update() - successfully update SwitchSchedule - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a SwitchSchedule entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID switchScheduleId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteSwitchScheduleCommand command = new DeleteSwitchScheduleCommand( switchScheduleId );

    	try {
        	SwitchScheduleBusinessDelegate delegate = SwitchScheduleBusinessDelegate.getSwitchScheduleInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted SwitchSchedule with key " + command.getSwitchScheduleId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected SwitchSchedule switchSchedule = null;
    private static final Logger LOGGER = Logger.getLogger(SwitchScheduleCommandRestController.class.getName());
    
}
