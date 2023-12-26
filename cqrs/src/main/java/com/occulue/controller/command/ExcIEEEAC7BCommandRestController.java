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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEAC7B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEAC7B")
public class ExcIEEEAC7BCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcIEEEAC7B.  if not key provided, calls create, otherwise calls save
     * @param		ExcIEEEAC7B	excIEEEAC7B
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcIEEEAC7BCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().createExcIEEEAC7B( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcIEEEAC7B.  if no key provided, calls create, otherwise calls save
     * @param		ExcIEEEAC7B excIEEEAC7B
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcIEEEAC7BCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcIEEEAC7BCommand
			// -----------------------------------------------
			completableFuture = ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().updateExcIEEEAC7B(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcIEEEAC7BController:update() - successfully update ExcIEEEAC7B - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcIEEEAC7B entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excIEEEAC7BId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcIEEEAC7BCommand command = new DeleteExcIEEEAC7BCommand( excIEEEAC7BId );

    	try {
        	ExcIEEEAC7BBusinessDelegate delegate = ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcIEEEAC7B with key " + command.getExcIEEEAC7BId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEAC7B excIEEEAC7B = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC7BCommandRestController.class.getName());
    
}
