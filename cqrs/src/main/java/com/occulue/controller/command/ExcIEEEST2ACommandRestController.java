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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEST2A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEST2A")
public class ExcIEEEST2ACommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcIEEEST2A.  if not key provided, calls create, otherwise calls save
     * @param		ExcIEEEST2A	excIEEEST2A
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcIEEEST2ACommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance().createExcIEEEST2A( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcIEEEST2A.  if no key provided, calls create, otherwise calls save
     * @param		ExcIEEEST2A excIEEEST2A
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcIEEEST2ACommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcIEEEST2ACommand
			// -----------------------------------------------
			completableFuture = ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance().updateExcIEEEST2A(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcIEEEST2AController:update() - successfully update ExcIEEEST2A - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcIEEEST2A entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excIEEEST2AId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcIEEEST2ACommand command = new DeleteExcIEEEST2ACommand( excIEEEST2AId );

    	try {
        	ExcIEEEST2ABusinessDelegate delegate = ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcIEEEST2A with key " + command.getExcIEEEST2AId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEST2A excIEEEST2A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEST2ACommandRestController.class.getName());
    
}
