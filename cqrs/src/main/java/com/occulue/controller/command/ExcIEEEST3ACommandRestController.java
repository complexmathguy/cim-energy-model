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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEST3A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEST3A")
public class ExcIEEEST3ACommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcIEEEST3A.  if not key provided, calls create, otherwise calls save
     * @param		ExcIEEEST3A	excIEEEST3A
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcIEEEST3ACommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().createExcIEEEST3A( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcIEEEST3A.  if no key provided, calls create, otherwise calls save
     * @param		ExcIEEEST3A excIEEEST3A
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcIEEEST3ACommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcIEEEST3ACommand
			// -----------------------------------------------
			completableFuture = ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().updateExcIEEEST3A(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcIEEEST3AController:update() - successfully update ExcIEEEST3A - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcIEEEST3A entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excIEEEST3AId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcIEEEST3ACommand command = new DeleteExcIEEEST3ACommand( excIEEEST3AId );

    	try {
        	ExcIEEEST3ABusinessDelegate delegate = ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcIEEEST3A with key " + command.getExcIEEEST3AId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEST3A excIEEEST3A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEST3ACommandRestController.class.getName());
    
}
