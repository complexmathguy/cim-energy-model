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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEST4B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEST4B")
public class ExcIEEEST4BCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcIEEEST4B.  if not key provided, calls create, otherwise calls save
     * @param		ExcIEEEST4B	excIEEEST4B
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcIEEEST4BCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().createExcIEEEST4B( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcIEEEST4B.  if no key provided, calls create, otherwise calls save
     * @param		ExcIEEEST4B excIEEEST4B
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcIEEEST4BCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcIEEEST4BCommand
			// -----------------------------------------------
			completableFuture = ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().updateExcIEEEST4B(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcIEEEST4BController:update() - successfully update ExcIEEEST4B - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcIEEEST4B entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excIEEEST4BId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcIEEEST4BCommand command = new DeleteExcIEEEST4BCommand( excIEEEST4BId );

    	try {
        	ExcIEEEST4BBusinessDelegate delegate = ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcIEEEST4B with key " + command.getExcIEEEST4BId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEST4B excIEEEST4B = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEST4BCommandRestController.class.getName());
    
}
