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
 * Implements Spring Controller command CQRS processing for entity Seconds.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Seconds")
public class SecondsCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a Seconds.  if not key provided, calls create, otherwise calls save
     * @param		Seconds	seconds
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateSecondsCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = SecondsBusinessDelegate.getSecondsInstance().createSeconds( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a Seconds.  if no key provided, calls create, otherwise calls save
     * @param		Seconds seconds
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateSecondsCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateSecondsCommand
			// -----------------------------------------------
			completableFuture = SecondsBusinessDelegate.getSecondsInstance().updateSeconds(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "SecondsController:update() - successfully update Seconds - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a Seconds entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID secondsId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteSecondsCommand command = new DeleteSecondsCommand( secondsId );

    	try {
        	SecondsBusinessDelegate delegate = SecondsBusinessDelegate.getSecondsInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted Seconds with key " + command.getSecondsId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected Seconds seconds = null;
    private static final Logger LOGGER = Logger.getLogger(SecondsCommandRestController.class.getName());
    
}
