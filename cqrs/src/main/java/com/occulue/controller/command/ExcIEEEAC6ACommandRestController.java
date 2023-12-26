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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEAC6A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEAC6A")
public class ExcIEEEAC6ACommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcIEEEAC6A.  if not key provided, calls create, otherwise calls save
     * @param		ExcIEEEAC6A	excIEEEAC6A
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcIEEEAC6ACommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().createExcIEEEAC6A( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcIEEEAC6A.  if no key provided, calls create, otherwise calls save
     * @param		ExcIEEEAC6A excIEEEAC6A
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcIEEEAC6ACommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcIEEEAC6ACommand
			// -----------------------------------------------
			completableFuture = ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().updateExcIEEEAC6A(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcIEEEAC6AController:update() - successfully update ExcIEEEAC6A - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcIEEEAC6A entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excIEEEAC6AId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcIEEEAC6ACommand command = new DeleteExcIEEEAC6ACommand( excIEEEAC6AId );

    	try {
        	ExcIEEEAC6ABusinessDelegate delegate = ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcIEEEAC6A with key " + command.getExcIEEEAC6AId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEAC6A excIEEEAC6A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC6ACommandRestController.class.getName());
    
}
