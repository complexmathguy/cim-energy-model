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
 * Implements Spring Controller command CQRS processing for entity LoadUserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/LoadUserDefined")
public class LoadUserDefinedCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a LoadUserDefined.  if not key provided, calls create, otherwise calls save
     * @param		LoadUserDefined	loadUserDefined
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateLoadUserDefinedCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = LoadUserDefinedBusinessDelegate.getLoadUserDefinedInstance().createLoadUserDefined( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a LoadUserDefined.  if no key provided, calls create, otherwise calls save
     * @param		LoadUserDefined loadUserDefined
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateLoadUserDefinedCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateLoadUserDefinedCommand
			// -----------------------------------------------
			completableFuture = LoadUserDefinedBusinessDelegate.getLoadUserDefinedInstance().updateLoadUserDefined(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "LoadUserDefinedController:update() - successfully update LoadUserDefined - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a LoadUserDefined entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID loadUserDefinedId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteLoadUserDefinedCommand command = new DeleteLoadUserDefinedCommand( loadUserDefinedId );

    	try {
        	LoadUserDefinedBusinessDelegate delegate = LoadUserDefinedBusinessDelegate.getLoadUserDefinedInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted LoadUserDefined with key " + command.getLoadUserDefinedId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected LoadUserDefined loadUserDefined = null;
    private static final Logger LOGGER = Logger.getLogger(LoadUserDefinedCommandRestController.class.getName());
    
}
