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
 * Implements Spring Controller command CQRS processing for entity Limit.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Limit")
public class LimitCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a Limit.  if not key provided, calls create, otherwise calls save
     * @param		Limit	limit
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateLimitCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = LimitBusinessDelegate.getLimitInstance().createLimit( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a Limit.  if no key provided, calls create, otherwise calls save
     * @param		Limit limit
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateLimitCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateLimitCommand
			// -----------------------------------------------
			completableFuture = LimitBusinessDelegate.getLimitInstance().updateLimit(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "LimitController:update() - successfully update Limit - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a Limit entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID limitId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteLimitCommand command = new DeleteLimitCommand( limitId );

    	try {
        	LimitBusinessDelegate delegate = LimitBusinessDelegate.getLimitInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted Limit with key " + command.getLimitId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected Limit limit = null;
    private static final Logger LOGGER = Logger.getLogger(LimitCommandRestController.class.getName());
    
}
