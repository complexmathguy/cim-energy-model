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
 * Implements Spring Controller command CQRS processing for entity VoltageLevel.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/VoltageLevel")
public class VoltageLevelCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a VoltageLevel.  if not key provided, calls create, otherwise calls save
     * @param		VoltageLevel	voltageLevel
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateVoltageLevelCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = VoltageLevelBusinessDelegate.getVoltageLevelInstance().createVoltageLevel( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a VoltageLevel.  if no key provided, calls create, otherwise calls save
     * @param		VoltageLevel voltageLevel
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateVoltageLevelCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateVoltageLevelCommand
			// -----------------------------------------------
			completableFuture = VoltageLevelBusinessDelegate.getVoltageLevelInstance().updateVoltageLevel(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "VoltageLevelController:update() - successfully update VoltageLevel - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a VoltageLevel entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID voltageLevelId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteVoltageLevelCommand command = new DeleteVoltageLevelCommand( voltageLevelId );

    	try {
        	VoltageLevelBusinessDelegate delegate = VoltageLevelBusinessDelegate.getVoltageLevelInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted VoltageLevel with key " + command.getVoltageLevelId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected VoltageLevel voltageLevel = null;
    private static final Logger LOGGER = Logger.getLogger(VoltageLevelCommandRestController.class.getName());
    
}
