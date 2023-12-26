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
 * Implements Spring Controller command CQRS processing for entity LoadArea.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/LoadArea")
public class LoadAreaCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a LoadArea.  if not key provided, calls create, otherwise calls save
     * @param		LoadArea	loadArea
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateLoadAreaCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = LoadAreaBusinessDelegate.getLoadAreaInstance().createLoadArea( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a LoadArea.  if no key provided, calls create, otherwise calls save
     * @param		LoadArea loadArea
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateLoadAreaCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateLoadAreaCommand
			// -----------------------------------------------
			completableFuture = LoadAreaBusinessDelegate.getLoadAreaInstance().updateLoadArea(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "LoadAreaController:update() - successfully update LoadArea - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a LoadArea entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID loadAreaId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteLoadAreaCommand command = new DeleteLoadAreaCommand( loadAreaId );

    	try {
        	LoadAreaBusinessDelegate delegate = LoadAreaBusinessDelegate.getLoadAreaInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted LoadArea with key " + command.getLoadAreaId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected LoadArea loadArea = null;
    private static final Logger LOGGER = Logger.getLogger(LoadAreaCommandRestController.class.getName());
    
}
