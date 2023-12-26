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
 * Implements Spring Controller command CQRS processing for entity RegularIntervalSchedule.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/RegularIntervalSchedule")
public class RegularIntervalScheduleCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a RegularIntervalSchedule.  if not key provided, calls create, otherwise calls save
     * @param		RegularIntervalSchedule	regularIntervalSchedule
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateRegularIntervalScheduleCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = RegularIntervalScheduleBusinessDelegate.getRegularIntervalScheduleInstance().createRegularIntervalSchedule( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a RegularIntervalSchedule.  if no key provided, calls create, otherwise calls save
     * @param		RegularIntervalSchedule regularIntervalSchedule
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateRegularIntervalScheduleCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateRegularIntervalScheduleCommand
			// -----------------------------------------------
			completableFuture = RegularIntervalScheduleBusinessDelegate.getRegularIntervalScheduleInstance().updateRegularIntervalSchedule(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "RegularIntervalScheduleController:update() - successfully update RegularIntervalSchedule - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a RegularIntervalSchedule entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID regularIntervalScheduleId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteRegularIntervalScheduleCommand command = new DeleteRegularIntervalScheduleCommand( regularIntervalScheduleId );

    	try {
        	RegularIntervalScheduleBusinessDelegate delegate = RegularIntervalScheduleBusinessDelegate.getRegularIntervalScheduleInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted RegularIntervalSchedule with key " + command.getRegularIntervalScheduleId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected RegularIntervalSchedule regularIntervalSchedule = null;
    private static final Logger LOGGER = Logger.getLogger(RegularIntervalScheduleCommandRestController.class.getName());
    
}
