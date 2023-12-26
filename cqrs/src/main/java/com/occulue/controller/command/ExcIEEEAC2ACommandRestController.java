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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEAC2A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEAC2A")
public class ExcIEEEAC2ACommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcIEEEAC2A.  if not key provided, calls create, otherwise calls save
     * @param		ExcIEEEAC2A	excIEEEAC2A
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcIEEEAC2ACommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().createExcIEEEAC2A( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcIEEEAC2A.  if no key provided, calls create, otherwise calls save
     * @param		ExcIEEEAC2A excIEEEAC2A
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcIEEEAC2ACommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcIEEEAC2ACommand
			// -----------------------------------------------
			completableFuture = ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance().updateExcIEEEAC2A(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcIEEEAC2AController:update() - successfully update ExcIEEEAC2A - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcIEEEAC2A entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excIEEEAC2AId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcIEEEAC2ACommand command = new DeleteExcIEEEAC2ACommand( excIEEEAC2AId );

    	try {
        	ExcIEEEAC2ABusinessDelegate delegate = ExcIEEEAC2ABusinessDelegate.getExcIEEEAC2AInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcIEEEAC2A with key " + command.getExcIEEEAC2AId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEAC2A excIEEEAC2A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC2ACommandRestController.class.getName());
    
}
