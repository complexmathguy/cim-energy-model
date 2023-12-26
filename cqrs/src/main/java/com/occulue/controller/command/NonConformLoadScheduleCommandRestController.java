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
 * Implements Spring Controller command CQRS processing for entity NonConformLoadSchedule.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/NonConformLoadSchedule")
public class NonConformLoadScheduleCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a NonConformLoadSchedule.  if not key provided, calls create, otherwise calls save
     * @param		NonConformLoadSchedule	nonConformLoadSchedule
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateNonConformLoadScheduleCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = NonConformLoadScheduleBusinessDelegate.getNonConformLoadScheduleInstance().createNonConformLoadSchedule( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a NonConformLoadSchedule.  if no key provided, calls create, otherwise calls save
     * @param		NonConformLoadSchedule nonConformLoadSchedule
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateNonConformLoadScheduleCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateNonConformLoadScheduleCommand
			// -----------------------------------------------
			completableFuture = NonConformLoadScheduleBusinessDelegate.getNonConformLoadScheduleInstance().updateNonConformLoadSchedule(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "NonConformLoadScheduleController:update() - successfully update NonConformLoadSchedule - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a NonConformLoadSchedule entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID nonConformLoadScheduleId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteNonConformLoadScheduleCommand command = new DeleteNonConformLoadScheduleCommand( nonConformLoadScheduleId );

    	try {
        	NonConformLoadScheduleBusinessDelegate delegate = NonConformLoadScheduleBusinessDelegate.getNonConformLoadScheduleInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted NonConformLoadSchedule with key " + command.getNonConformLoadScheduleId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected NonConformLoadSchedule nonConformLoadSchedule = null;
    private static final Logger LOGGER = Logger.getLogger(NonConformLoadScheduleCommandRestController.class.getName());
    
}
