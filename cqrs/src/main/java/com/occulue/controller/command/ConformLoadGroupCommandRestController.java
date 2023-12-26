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
 * Implements Spring Controller command CQRS processing for entity ConformLoadGroup.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ConformLoadGroup")
public class ConformLoadGroupCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ConformLoadGroup.  if not key provided, calls create, otherwise calls save
     * @param		ConformLoadGroup	conformLoadGroup
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateConformLoadGroupCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ConformLoadGroupBusinessDelegate.getConformLoadGroupInstance().createConformLoadGroup( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ConformLoadGroup.  if no key provided, calls create, otherwise calls save
     * @param		ConformLoadGroup conformLoadGroup
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateConformLoadGroupCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateConformLoadGroupCommand
			// -----------------------------------------------
			completableFuture = ConformLoadGroupBusinessDelegate.getConformLoadGroupInstance().updateConformLoadGroup(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ConformLoadGroupController:update() - successfully update ConformLoadGroup - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ConformLoadGroup entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID conformLoadGroupId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteConformLoadGroupCommand command = new DeleteConformLoadGroupCommand( conformLoadGroupId );

    	try {
        	ConformLoadGroupBusinessDelegate delegate = ConformLoadGroupBusinessDelegate.getConformLoadGroupInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ConformLoadGroup with key " + command.getConformLoadGroupId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ConformLoadGroup conformLoadGroup = null;
    private static final Logger LOGGER = Logger.getLogger(ConformLoadGroupCommandRestController.class.getName());
    
}
