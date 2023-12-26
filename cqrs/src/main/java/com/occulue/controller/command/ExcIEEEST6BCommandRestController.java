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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEST6B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEST6B")
public class ExcIEEEST6BCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcIEEEST6B.  if not key provided, calls create, otherwise calls save
     * @param		ExcIEEEST6B	excIEEEST6B
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcIEEEST6BCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().createExcIEEEST6B( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcIEEEST6B.  if no key provided, calls create, otherwise calls save
     * @param		ExcIEEEST6B excIEEEST6B
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcIEEEST6BCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcIEEEST6BCommand
			// -----------------------------------------------
			completableFuture = ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().updateExcIEEEST6B(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcIEEEST6BController:update() - successfully update ExcIEEEST6B - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcIEEEST6B entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excIEEEST6BId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcIEEEST6BCommand command = new DeleteExcIEEEST6BCommand( excIEEEST6BId );

    	try {
        	ExcIEEEST6BBusinessDelegate delegate = ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcIEEEST6B with key " + command.getExcIEEEST6BId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEST6B excIEEEST6B = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEST6BCommandRestController.class.getName());
    
}
