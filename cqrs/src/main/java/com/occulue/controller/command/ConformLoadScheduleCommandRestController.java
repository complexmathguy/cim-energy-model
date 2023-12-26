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
 * Implements Spring Controller command CQRS processing for entity ConformLoadSchedule.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ConformLoadSchedule")
public class ConformLoadScheduleCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ConformLoadSchedule.  if not key provided, calls create, otherwise calls save
     * @param		ConformLoadSchedule	conformLoadSchedule
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateConformLoadScheduleCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ConformLoadScheduleBusinessDelegate.getConformLoadScheduleInstance().createConformLoadSchedule( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ConformLoadSchedule.  if no key provided, calls create, otherwise calls save
     * @param		ConformLoadSchedule conformLoadSchedule
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateConformLoadScheduleCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateConformLoadScheduleCommand
			// -----------------------------------------------
			completableFuture = ConformLoadScheduleBusinessDelegate.getConformLoadScheduleInstance().updateConformLoadSchedule(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ConformLoadScheduleController:update() - successfully update ConformLoadSchedule - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ConformLoadSchedule entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID conformLoadScheduleId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteConformLoadScheduleCommand command = new DeleteConformLoadScheduleCommand( conformLoadScheduleId );

    	try {
        	ConformLoadScheduleBusinessDelegate delegate = ConformLoadScheduleBusinessDelegate.getConformLoadScheduleInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ConformLoadSchedule with key " + command.getConformLoadScheduleId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ConformLoadSchedule conformLoadSchedule = null;
    private static final Logger LOGGER = Logger.getLogger(ConformLoadScheduleCommandRestController.class.getName());
    
}
