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
 * Implements Spring Controller command CQRS processing for entity Quality61850.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Quality61850")
public class Quality61850CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a Quality61850.  if not key provided, calls create, otherwise calls save
     * @param		Quality61850	quality61850
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateQuality61850Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = Quality61850BusinessDelegate.getQuality61850Instance().createQuality61850( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a Quality61850.  if no key provided, calls create, otherwise calls save
     * @param		Quality61850 quality61850
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateQuality61850Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateQuality61850Command
			// -----------------------------------------------
			completableFuture = Quality61850BusinessDelegate.getQuality61850Instance().updateQuality61850(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "Quality61850Controller:update() - successfully update Quality61850 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a Quality61850 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID quality61850Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteQuality61850Command command = new DeleteQuality61850Command( quality61850Id );

    	try {
        	Quality61850BusinessDelegate delegate = Quality61850BusinessDelegate.getQuality61850Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted Quality61850 with key " + command.getQuality61850Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected Quality61850 quality61850 = null;
    private static final Logger LOGGER = Logger.getLogger(Quality61850CommandRestController.class.getName());
    
}
