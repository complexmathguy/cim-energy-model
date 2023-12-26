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
 * Implements Spring Controller command CQRS processing for entity ExcDC1A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcDC1A")
public class ExcDC1ACommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcDC1A.  if not key provided, calls create, otherwise calls save
     * @param		ExcDC1A	excDC1A
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcDC1ACommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcDC1ABusinessDelegate.getExcDC1AInstance().createExcDC1A( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcDC1A.  if no key provided, calls create, otherwise calls save
     * @param		ExcDC1A excDC1A
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcDC1ACommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcDC1ACommand
			// -----------------------------------------------
			completableFuture = ExcDC1ABusinessDelegate.getExcDC1AInstance().updateExcDC1A(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcDC1AController:update() - successfully update ExcDC1A - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcDC1A entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excDC1AId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcDC1ACommand command = new DeleteExcDC1ACommand( excDC1AId );

    	try {
        	ExcDC1ABusinessDelegate delegate = ExcDC1ABusinessDelegate.getExcDC1AInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcDC1A with key " + command.getExcDC1AId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcDC1A excDC1A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcDC1ACommandRestController.class.getName());
    
}
