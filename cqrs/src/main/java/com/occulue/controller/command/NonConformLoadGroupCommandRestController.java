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
 * Implements Spring Controller command CQRS processing for entity NonConformLoadGroup.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/NonConformLoadGroup")
public class NonConformLoadGroupCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a NonConformLoadGroup.  if not key provided, calls create, otherwise calls save
     * @param		NonConformLoadGroup	nonConformLoadGroup
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateNonConformLoadGroupCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = NonConformLoadGroupBusinessDelegate.getNonConformLoadGroupInstance().createNonConformLoadGroup( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a NonConformLoadGroup.  if no key provided, calls create, otherwise calls save
     * @param		NonConformLoadGroup nonConformLoadGroup
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateNonConformLoadGroupCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateNonConformLoadGroupCommand
			// -----------------------------------------------
			completableFuture = NonConformLoadGroupBusinessDelegate.getNonConformLoadGroupInstance().updateNonConformLoadGroup(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "NonConformLoadGroupController:update() - successfully update NonConformLoadGroup - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a NonConformLoadGroup entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID nonConformLoadGroupId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteNonConformLoadGroupCommand command = new DeleteNonConformLoadGroupCommand( nonConformLoadGroupId );

    	try {
        	NonConformLoadGroupBusinessDelegate delegate = NonConformLoadGroupBusinessDelegate.getNonConformLoadGroupInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted NonConformLoadGroup with key " + command.getNonConformLoadGroupId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected NonConformLoadGroup nonConformLoadGroup = null;
    private static final Logger LOGGER = Logger.getLogger(NonConformLoadGroupCommandRestController.class.getName());
    
}
