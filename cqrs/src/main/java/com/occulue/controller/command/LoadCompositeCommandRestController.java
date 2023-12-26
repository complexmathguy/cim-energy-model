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
 * Implements Spring Controller command CQRS processing for entity LoadComposite.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/LoadComposite")
public class LoadCompositeCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a LoadComposite.  if not key provided, calls create, otherwise calls save
     * @param		LoadComposite	loadComposite
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateLoadCompositeCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = LoadCompositeBusinessDelegate.getLoadCompositeInstance().createLoadComposite( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a LoadComposite.  if no key provided, calls create, otherwise calls save
     * @param		LoadComposite loadComposite
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateLoadCompositeCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateLoadCompositeCommand
			// -----------------------------------------------
			completableFuture = LoadCompositeBusinessDelegate.getLoadCompositeInstance().updateLoadComposite(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "LoadCompositeController:update() - successfully update LoadComposite - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a LoadComposite entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID loadCompositeId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteLoadCompositeCommand command = new DeleteLoadCompositeCommand( loadCompositeId );

    	try {
        	LoadCompositeBusinessDelegate delegate = LoadCompositeBusinessDelegate.getLoadCompositeInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted LoadComposite with key " + command.getLoadCompositeId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected LoadComposite loadComposite = null;
    private static final Logger LOGGER = Logger.getLogger(LoadCompositeCommandRestController.class.getName());
    
}
