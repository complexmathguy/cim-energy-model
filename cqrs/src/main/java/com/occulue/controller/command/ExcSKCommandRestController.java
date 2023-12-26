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
 * Implements Spring Controller command CQRS processing for entity ExcSK.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcSK")
public class ExcSKCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcSK.  if not key provided, calls create, otherwise calls save
     * @param		ExcSK	excSK
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcSKCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcSKBusinessDelegate.getExcSKInstance().createExcSK( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcSK.  if no key provided, calls create, otherwise calls save
     * @param		ExcSK excSK
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcSKCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcSKCommand
			// -----------------------------------------------
			completableFuture = ExcSKBusinessDelegate.getExcSKInstance().updateExcSK(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcSKController:update() - successfully update ExcSK - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcSK entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excSKId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcSKCommand command = new DeleteExcSKCommand( excSKId );

    	try {
        	ExcSKBusinessDelegate delegate = ExcSKBusinessDelegate.getExcSKInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcSK with key " + command.getExcSKId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcSK excSK = null;
    private static final Logger LOGGER = Logger.getLogger(ExcSKCommandRestController.class.getName());
    
}
