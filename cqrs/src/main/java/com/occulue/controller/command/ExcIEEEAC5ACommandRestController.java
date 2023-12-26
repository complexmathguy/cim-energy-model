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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEAC5A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEAC5A")
public class ExcIEEEAC5ACommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcIEEEAC5A.  if not key provided, calls create, otherwise calls save
     * @param		ExcIEEEAC5A	excIEEEAC5A
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcIEEEAC5ACommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().createExcIEEEAC5A( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcIEEEAC5A.  if no key provided, calls create, otherwise calls save
     * @param		ExcIEEEAC5A excIEEEAC5A
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcIEEEAC5ACommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcIEEEAC5ACommand
			// -----------------------------------------------
			completableFuture = ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().updateExcIEEEAC5A(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcIEEEAC5AController:update() - successfully update ExcIEEEAC5A - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcIEEEAC5A entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excIEEEAC5AId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcIEEEAC5ACommand command = new DeleteExcIEEEAC5ACommand( excIEEEAC5AId );

    	try {
        	ExcIEEEAC5ABusinessDelegate delegate = ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcIEEEAC5A with key " + command.getExcIEEEAC5AId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEAC5A excIEEEAC5A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC5ACommandRestController.class.getName());
    
}
