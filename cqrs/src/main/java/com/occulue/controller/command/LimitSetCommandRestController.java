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
 * Implements Spring Controller command CQRS processing for entity LimitSet.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/LimitSet")
public class LimitSetCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a LimitSet.  if not key provided, calls create, otherwise calls save
     * @param		LimitSet	limitSet
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateLimitSetCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = LimitSetBusinessDelegate.getLimitSetInstance().createLimitSet( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a LimitSet.  if no key provided, calls create, otherwise calls save
     * @param		LimitSet limitSet
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateLimitSetCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateLimitSetCommand
			// -----------------------------------------------
			completableFuture = LimitSetBusinessDelegate.getLimitSetInstance().updateLimitSet(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "LimitSetController:update() - successfully update LimitSet - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a LimitSet entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID limitSetId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteLimitSetCommand command = new DeleteLimitSetCommand( limitSetId );

    	try {
        	LimitSetBusinessDelegate delegate = LimitSetBusinessDelegate.getLimitSetInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted LimitSet with key " + command.getLimitSetId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected LimitSet limitSet = null;
    private static final Logger LOGGER = Logger.getLogger(LimitSetCommandRestController.class.getName());
    
}
