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
 * Implements Spring Controller command CQRS processing for entity ExcOEX3T.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcOEX3T")
public class ExcOEX3TCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcOEX3T.  if not key provided, calls create, otherwise calls save
     * @param		ExcOEX3T	excOEX3T
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcOEX3TCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcOEX3TBusinessDelegate.getExcOEX3TInstance().createExcOEX3T( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcOEX3T.  if no key provided, calls create, otherwise calls save
     * @param		ExcOEX3T excOEX3T
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcOEX3TCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcOEX3TCommand
			// -----------------------------------------------
			completableFuture = ExcOEX3TBusinessDelegate.getExcOEX3TInstance().updateExcOEX3T(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcOEX3TController:update() - successfully update ExcOEX3T - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcOEX3T entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excOEX3TId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcOEX3TCommand command = new DeleteExcOEX3TCommand( excOEX3TId );

    	try {
        	ExcOEX3TBusinessDelegate delegate = ExcOEX3TBusinessDelegate.getExcOEX3TInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcOEX3T with key " + command.getExcOEX3TId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcOEX3T excOEX3T = null;
    private static final Logger LOGGER = Logger.getLogger(ExcOEX3TCommandRestController.class.getName());
    
}
