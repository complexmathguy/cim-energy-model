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
 * Implements Spring Controller command CQRS processing for entity Season.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Season")
public class SeasonCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a Season.  if not key provided, calls create, otherwise calls save
     * @param		Season	season
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateSeasonCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = SeasonBusinessDelegate.getSeasonInstance().createSeason( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a Season.  if no key provided, calls create, otherwise calls save
     * @param		Season season
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateSeasonCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateSeasonCommand
			// -----------------------------------------------
			completableFuture = SeasonBusinessDelegate.getSeasonInstance().updateSeason(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "SeasonController:update() - successfully update Season - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a Season entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID seasonId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteSeasonCommand command = new DeleteSeasonCommand( seasonId );

    	try {
        	SeasonBusinessDelegate delegate = SeasonBusinessDelegate.getSeasonInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted Season with key " + command.getSeasonId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected Season season = null;
    private static final Logger LOGGER = Logger.getLogger(SeasonCommandRestController.class.getName());
    
}
