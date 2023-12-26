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
 * Implements Spring Controller command CQRS processing for entity ExcST1A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcST1A")
public class ExcST1ACommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcST1A.  if not key provided, calls create, otherwise calls save
     * @param		ExcST1A	excST1A
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcST1ACommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcST1ABusinessDelegate.getExcST1AInstance().createExcST1A( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcST1A.  if no key provided, calls create, otherwise calls save
     * @param		ExcST1A excST1A
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcST1ACommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcST1ACommand
			// -----------------------------------------------
			completableFuture = ExcST1ABusinessDelegate.getExcST1AInstance().updateExcST1A(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcST1AController:update() - successfully update ExcST1A - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcST1A entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excST1AId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcST1ACommand command = new DeleteExcST1ACommand( excST1AId );

    	try {
        	ExcST1ABusinessDelegate delegate = ExcST1ABusinessDelegate.getExcST1AInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcST1A with key " + command.getExcST1AId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcST1A excST1A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcST1ACommandRestController.class.getName());
    
}
