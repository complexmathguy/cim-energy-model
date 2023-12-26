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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEST7B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEST7B")
public class ExcIEEEST7BCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcIEEEST7B.  if not key provided, calls create, otherwise calls save
     * @param		ExcIEEEST7B	excIEEEST7B
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcIEEEST7BCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance().createExcIEEEST7B( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcIEEEST7B.  if no key provided, calls create, otherwise calls save
     * @param		ExcIEEEST7B excIEEEST7B
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcIEEEST7BCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcIEEEST7BCommand
			// -----------------------------------------------
			completableFuture = ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance().updateExcIEEEST7B(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcIEEEST7BController:update() - successfully update ExcIEEEST7B - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcIEEEST7B entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excIEEEST7BId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcIEEEST7BCommand command = new DeleteExcIEEEST7BCommand( excIEEEST7BId );

    	try {
        	ExcIEEEST7BBusinessDelegate delegate = ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcIEEEST7B with key " + command.getExcIEEEST7BId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEST7B excIEEEST7B = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEST7BCommandRestController.class.getName());
    
}
