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
 * Implements Spring Controller command CQRS processing for entity RegulationSchedule.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/RegulationSchedule")
public class RegulationScheduleCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a RegulationSchedule.  if not key provided, calls create, otherwise calls save
     * @param		RegulationSchedule	regulationSchedule
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateRegulationScheduleCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = RegulationScheduleBusinessDelegate.getRegulationScheduleInstance().createRegulationSchedule( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a RegulationSchedule.  if no key provided, calls create, otherwise calls save
     * @param		RegulationSchedule regulationSchedule
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateRegulationScheduleCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateRegulationScheduleCommand
			// -----------------------------------------------
			completableFuture = RegulationScheduleBusinessDelegate.getRegulationScheduleInstance().updateRegulationSchedule(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "RegulationScheduleController:update() - successfully update RegulationSchedule - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a RegulationSchedule entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID regulationScheduleId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteRegulationScheduleCommand command = new DeleteRegulationScheduleCommand( regulationScheduleId );

    	try {
        	RegulationScheduleBusinessDelegate delegate = RegulationScheduleBusinessDelegate.getRegulationScheduleInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted RegulationSchedule with key " + command.getRegulationScheduleId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected RegulationSchedule regulationSchedule = null;
    private static final Logger LOGGER = Logger.getLogger(RegulationScheduleCommandRestController.class.getName());
    
}
