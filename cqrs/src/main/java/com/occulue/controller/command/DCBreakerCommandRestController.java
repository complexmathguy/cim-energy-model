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
 * Implements Spring Controller command CQRS processing for entity DCBreaker.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCBreaker")
public class DCBreakerCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a DCBreaker.  if not key provided, calls create, otherwise calls save
     * @param		DCBreaker	dCBreaker
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateDCBreakerCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = DCBreakerBusinessDelegate.getDCBreakerInstance().createDCBreaker( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a DCBreaker.  if no key provided, calls create, otherwise calls save
     * @param		DCBreaker dCBreaker
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateDCBreakerCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateDCBreakerCommand
			// -----------------------------------------------
			completableFuture = DCBreakerBusinessDelegate.getDCBreakerInstance().updateDCBreaker(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "DCBreakerController:update() - successfully update DCBreaker - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a DCBreaker entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID dCBreakerId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteDCBreakerCommand command = new DeleteDCBreakerCommand( dCBreakerId );

    	try {
        	DCBreakerBusinessDelegate delegate = DCBreakerBusinessDelegate.getDCBreakerInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted DCBreaker with key " + command.getDCBreakerId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected DCBreaker dCBreaker = null;
    private static final Logger LOGGER = Logger.getLogger(DCBreakerCommandRestController.class.getName());
    
}
