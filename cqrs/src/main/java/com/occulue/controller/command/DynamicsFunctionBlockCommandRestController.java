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
 * Implements Spring Controller command CQRS processing for entity DynamicsFunctionBlock.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DynamicsFunctionBlock")
public class DynamicsFunctionBlockCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a DynamicsFunctionBlock.  if not key provided, calls create, otherwise calls save
     * @param		DynamicsFunctionBlock	dynamicsFunctionBlock
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateDynamicsFunctionBlockCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = DynamicsFunctionBlockBusinessDelegate.getDynamicsFunctionBlockInstance().createDynamicsFunctionBlock( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a DynamicsFunctionBlock.  if no key provided, calls create, otherwise calls save
     * @param		DynamicsFunctionBlock dynamicsFunctionBlock
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateDynamicsFunctionBlockCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateDynamicsFunctionBlockCommand
			// -----------------------------------------------
			completableFuture = DynamicsFunctionBlockBusinessDelegate.getDynamicsFunctionBlockInstance().updateDynamicsFunctionBlock(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "DynamicsFunctionBlockController:update() - successfully update DynamicsFunctionBlock - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a DynamicsFunctionBlock entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID dynamicsFunctionBlockId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteDynamicsFunctionBlockCommand command = new DeleteDynamicsFunctionBlockCommand( dynamicsFunctionBlockId );

    	try {
        	DynamicsFunctionBlockBusinessDelegate delegate = DynamicsFunctionBlockBusinessDelegate.getDynamicsFunctionBlockInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted DynamicsFunctionBlock with key " + command.getDynamicsFunctionBlockId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected DynamicsFunctionBlock dynamicsFunctionBlock = null;
    private static final Logger LOGGER = Logger.getLogger(DynamicsFunctionBlockCommandRestController.class.getName());
    
}
