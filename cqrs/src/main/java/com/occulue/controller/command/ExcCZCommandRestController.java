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
 * Implements Spring Controller command CQRS processing for entity ExcCZ.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcCZ")
public class ExcCZCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcCZ.  if not key provided, calls create, otherwise calls save
     * @param		ExcCZ	excCZ
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcCZCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcCZBusinessDelegate.getExcCZInstance().createExcCZ( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcCZ.  if no key provided, calls create, otherwise calls save
     * @param		ExcCZ excCZ
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcCZCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcCZCommand
			// -----------------------------------------------
			completableFuture = ExcCZBusinessDelegate.getExcCZInstance().updateExcCZ(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcCZController:update() - successfully update ExcCZ - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcCZ entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excCZId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcCZCommand command = new DeleteExcCZCommand( excCZId );

    	try {
        	ExcCZBusinessDelegate delegate = ExcCZBusinessDelegate.getExcCZInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcCZ with key " + command.getExcCZId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcCZ excCZ = null;
    private static final Logger LOGGER = Logger.getLogger(ExcCZCommandRestController.class.getName());
    
}
