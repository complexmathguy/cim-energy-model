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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEAC3A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEAC3A")
public class ExcIEEEAC3ACommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcIEEEAC3A.  if not key provided, calls create, otherwise calls save
     * @param		ExcIEEEAC3A	excIEEEAC3A
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcIEEEAC3ACommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().createExcIEEEAC3A( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcIEEEAC3A.  if no key provided, calls create, otherwise calls save
     * @param		ExcIEEEAC3A excIEEEAC3A
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcIEEEAC3ACommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcIEEEAC3ACommand
			// -----------------------------------------------
			completableFuture = ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().updateExcIEEEAC3A(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcIEEEAC3AController:update() - successfully update ExcIEEEAC3A - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcIEEEAC3A entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excIEEEAC3AId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcIEEEAC3ACommand command = new DeleteExcIEEEAC3ACommand( excIEEEAC3AId );

    	try {
        	ExcIEEEAC3ABusinessDelegate delegate = ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcIEEEAC3A with key " + command.getExcIEEEAC3AId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEAC3A excIEEEAC3A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC3ACommandRestController.class.getName());
    
}
