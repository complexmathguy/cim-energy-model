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
 * Implements Spring Controller command CQRS processing for entity ExcDC2A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcDC2A")
public class ExcDC2ACommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcDC2A.  if not key provided, calls create, otherwise calls save
     * @param		ExcDC2A	excDC2A
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcDC2ACommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcDC2ABusinessDelegate.getExcDC2AInstance().createExcDC2A( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcDC2A.  if no key provided, calls create, otherwise calls save
     * @param		ExcDC2A excDC2A
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcDC2ACommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcDC2ACommand
			// -----------------------------------------------
			completableFuture = ExcDC2ABusinessDelegate.getExcDC2AInstance().updateExcDC2A(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcDC2AController:update() - successfully update ExcDC2A - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcDC2A entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excDC2AId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcDC2ACommand command = new DeleteExcDC2ACommand( excDC2AId );

    	try {
        	ExcDC2ABusinessDelegate delegate = ExcDC2ABusinessDelegate.getExcDC2AInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcDC2A with key " + command.getExcDC2AId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcDC2A excDC2A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcDC2ACommandRestController.class.getName());
    
}
