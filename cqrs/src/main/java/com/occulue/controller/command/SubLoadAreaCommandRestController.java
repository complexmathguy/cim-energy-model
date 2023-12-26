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
 * Implements Spring Controller command CQRS processing for entity SubLoadArea.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SubLoadArea")
public class SubLoadAreaCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a SubLoadArea.  if not key provided, calls create, otherwise calls save
     * @param		SubLoadArea	subLoadArea
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateSubLoadAreaCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = SubLoadAreaBusinessDelegate.getSubLoadAreaInstance().createSubLoadArea( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a SubLoadArea.  if no key provided, calls create, otherwise calls save
     * @param		SubLoadArea subLoadArea
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateSubLoadAreaCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateSubLoadAreaCommand
			// -----------------------------------------------
			completableFuture = SubLoadAreaBusinessDelegate.getSubLoadAreaInstance().updateSubLoadArea(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "SubLoadAreaController:update() - successfully update SubLoadArea - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a SubLoadArea entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID subLoadAreaId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteSubLoadAreaCommand command = new DeleteSubLoadAreaCommand( subLoadAreaId );

    	try {
        	SubLoadAreaBusinessDelegate delegate = SubLoadAreaBusinessDelegate.getSubLoadAreaInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted SubLoadArea with key " + command.getSubLoadAreaId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected SubLoadArea subLoadArea = null;
    private static final Logger LOGGER = Logger.getLogger(SubLoadAreaCommandRestController.class.getName());
    
}
