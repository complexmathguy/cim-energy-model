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
 * Implements Spring Controller command CQRS processing for entity LoadBreakSwitch.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/LoadBreakSwitch")
public class LoadBreakSwitchCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a LoadBreakSwitch.  if not key provided, calls create, otherwise calls save
     * @param		LoadBreakSwitch	loadBreakSwitch
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateLoadBreakSwitchCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = LoadBreakSwitchBusinessDelegate.getLoadBreakSwitchInstance().createLoadBreakSwitch( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a LoadBreakSwitch.  if no key provided, calls create, otherwise calls save
     * @param		LoadBreakSwitch loadBreakSwitch
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateLoadBreakSwitchCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateLoadBreakSwitchCommand
			// -----------------------------------------------
			completableFuture = LoadBreakSwitchBusinessDelegate.getLoadBreakSwitchInstance().updateLoadBreakSwitch(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "LoadBreakSwitchController:update() - successfully update LoadBreakSwitch - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a LoadBreakSwitch entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID loadBreakSwitchId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteLoadBreakSwitchCommand command = new DeleteLoadBreakSwitchCommand( loadBreakSwitchId );

    	try {
        	LoadBreakSwitchBusinessDelegate delegate = LoadBreakSwitchBusinessDelegate.getLoadBreakSwitchInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted LoadBreakSwitch with key " + command.getLoadBreakSwitchId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected LoadBreakSwitch loadBreakSwitch = null;
    private static final Logger LOGGER = Logger.getLogger(LoadBreakSwitchCommandRestController.class.getName());
    
}
