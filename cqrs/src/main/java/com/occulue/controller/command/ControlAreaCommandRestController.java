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
 * Implements Spring Controller command CQRS processing for entity ControlArea.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ControlArea")
public class ControlAreaCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ControlArea.  if not key provided, calls create, otherwise calls save
     * @param		ControlArea	controlArea
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateControlAreaCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ControlAreaBusinessDelegate.getControlAreaInstance().createControlArea( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ControlArea.  if no key provided, calls create, otherwise calls save
     * @param		ControlArea controlArea
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateControlAreaCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateControlAreaCommand
			// -----------------------------------------------
			completableFuture = ControlAreaBusinessDelegate.getControlAreaInstance().updateControlArea(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ControlAreaController:update() - successfully update ControlArea - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ControlArea entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID controlAreaId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteControlAreaCommand command = new DeleteControlAreaCommand( controlAreaId );

    	try {
        	ControlAreaBusinessDelegate delegate = ControlAreaBusinessDelegate.getControlAreaInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ControlArea with key " + command.getControlAreaId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ControlArea controlArea = null;
    private static final Logger LOGGER = Logger.getLogger(ControlAreaCommandRestController.class.getName());
    
}
