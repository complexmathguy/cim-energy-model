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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEST5B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEST5B")
public class ExcIEEEST5BCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcIEEEST5B.  if not key provided, calls create, otherwise calls save
     * @param		ExcIEEEST5B	excIEEEST5B
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcIEEEST5BCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().createExcIEEEST5B( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcIEEEST5B.  if no key provided, calls create, otherwise calls save
     * @param		ExcIEEEST5B excIEEEST5B
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcIEEEST5BCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcIEEEST5BCommand
			// -----------------------------------------------
			completableFuture = ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().updateExcIEEEST5B(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcIEEEST5BController:update() - successfully update ExcIEEEST5B - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcIEEEST5B entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excIEEEST5BId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcIEEEST5BCommand command = new DeleteExcIEEEST5BCommand( excIEEEST5BId );

    	try {
        	ExcIEEEST5BBusinessDelegate delegate = ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcIEEEST5B with key " + command.getExcIEEEST5BId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEST5B excIEEEST5B = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEST5BCommandRestController.class.getName());
    
}
