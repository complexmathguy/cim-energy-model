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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEST1A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEST1A")
public class ExcIEEEST1ACommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcIEEEST1A.  if not key provided, calls create, otherwise calls save
     * @param		ExcIEEEST1A	excIEEEST1A
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcIEEEST1ACommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().createExcIEEEST1A( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcIEEEST1A.  if no key provided, calls create, otherwise calls save
     * @param		ExcIEEEST1A excIEEEST1A
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcIEEEST1ACommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcIEEEST1ACommand
			// -----------------------------------------------
			completableFuture = ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance().updateExcIEEEST1A(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcIEEEST1AController:update() - successfully update ExcIEEEST1A - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcIEEEST1A entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excIEEEST1AId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcIEEEST1ACommand command = new DeleteExcIEEEST1ACommand( excIEEEST1AId );

    	try {
        	ExcIEEEST1ABusinessDelegate delegate = ExcIEEEST1ABusinessDelegate.getExcIEEEST1AInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcIEEEST1A with key " + command.getExcIEEEST1AId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEST1A excIEEEST1A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEST1ACommandRestController.class.getName());
    
}
