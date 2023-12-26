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
 * Implements Spring Controller command CQRS processing for entity ExcBBC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcBBC")
public class ExcBBCCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcBBC.  if not key provided, calls create, otherwise calls save
     * @param		ExcBBC	excBBC
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcBBCCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcBBCBusinessDelegate.getExcBBCInstance().createExcBBC( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcBBC.  if no key provided, calls create, otherwise calls save
     * @param		ExcBBC excBBC
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcBBCCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcBBCCommand
			// -----------------------------------------------
			completableFuture = ExcBBCBusinessDelegate.getExcBBCInstance().updateExcBBC(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcBBCController:update() - successfully update ExcBBC - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcBBC entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excBBCId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcBBCCommand command = new DeleteExcBBCCommand( excBBCId );

    	try {
        	ExcBBCBusinessDelegate delegate = ExcBBCBusinessDelegate.getExcBBCInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcBBC with key " + command.getExcBBCId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcBBC excBBC = null;
    private static final Logger LOGGER = Logger.getLogger(ExcBBCCommandRestController.class.getName());
    
}
