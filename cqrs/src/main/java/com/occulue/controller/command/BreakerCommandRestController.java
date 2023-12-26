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
 * Implements Spring Controller command CQRS processing for entity Breaker.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Breaker")
public class BreakerCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a Breaker.  if not key provided, calls create, otherwise calls save
     * @param		Breaker	breaker
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateBreakerCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = BreakerBusinessDelegate.getBreakerInstance().createBreaker( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a Breaker.  if no key provided, calls create, otherwise calls save
     * @param		Breaker breaker
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateBreakerCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateBreakerCommand
			// -----------------------------------------------
			completableFuture = BreakerBusinessDelegate.getBreakerInstance().updateBreaker(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "BreakerController:update() - successfully update Breaker - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a Breaker entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID breakerId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteBreakerCommand command = new DeleteBreakerCommand( breakerId );

    	try {
        	BreakerBusinessDelegate delegate = BreakerBusinessDelegate.getBreakerInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted Breaker with key " + command.getBreakerId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected Breaker breaker = null;
    private static final Logger LOGGER = Logger.getLogger(BreakerCommandRestController.class.getName());
    
}
