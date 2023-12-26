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
 * Implements Spring Controller command CQRS processing for entity ExcHU.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcHU")
public class ExcHUCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcHU.  if not key provided, calls create, otherwise calls save
     * @param		ExcHU	excHU
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcHUCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcHUBusinessDelegate.getExcHUInstance().createExcHU( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcHU.  if no key provided, calls create, otherwise calls save
     * @param		ExcHU excHU
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcHUCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcHUCommand
			// -----------------------------------------------
			completableFuture = ExcHUBusinessDelegate.getExcHUInstance().updateExcHU(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcHUController:update() - successfully update ExcHU - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcHU entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excHUId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcHUCommand command = new DeleteExcHUCommand( excHUId );

    	try {
        	ExcHUBusinessDelegate delegate = ExcHUBusinessDelegate.getExcHUInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcHU with key " + command.getExcHUId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcHU excHU = null;
    private static final Logger LOGGER = Logger.getLogger(ExcHUCommandRestController.class.getName());
    
}
