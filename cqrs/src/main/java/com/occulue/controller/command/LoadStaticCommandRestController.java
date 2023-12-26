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
 * Implements Spring Controller command CQRS processing for entity LoadStatic.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/LoadStatic")
public class LoadStaticCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a LoadStatic.  if not key provided, calls create, otherwise calls save
     * @param		LoadStatic	loadStatic
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateLoadStaticCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = LoadStaticBusinessDelegate.getLoadStaticInstance().createLoadStatic( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a LoadStatic.  if no key provided, calls create, otherwise calls save
     * @param		LoadStatic loadStatic
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateLoadStaticCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateLoadStaticCommand
			// -----------------------------------------------
			completableFuture = LoadStaticBusinessDelegate.getLoadStaticInstance().updateLoadStatic(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "LoadStaticController:update() - successfully update LoadStatic - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a LoadStatic entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID loadStaticId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteLoadStaticCommand command = new DeleteLoadStaticCommand( loadStaticId );

    	try {
        	LoadStaticBusinessDelegate delegate = LoadStaticBusinessDelegate.getLoadStaticInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted LoadStatic with key " + command.getLoadStaticId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected LoadStatic loadStatic = null;
    private static final Logger LOGGER = Logger.getLogger(LoadStaticCommandRestController.class.getName());
    
}
