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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEAC8B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEAC8B")
public class ExcIEEEAC8BCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcIEEEAC8B.  if not key provided, calls create, otherwise calls save
     * @param		ExcIEEEAC8B	excIEEEAC8B
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcIEEEAC8BCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().createExcIEEEAC8B( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcIEEEAC8B.  if no key provided, calls create, otherwise calls save
     * @param		ExcIEEEAC8B excIEEEAC8B
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcIEEEAC8BCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcIEEEAC8BCommand
			// -----------------------------------------------
			completableFuture = ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().updateExcIEEEAC8B(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcIEEEAC8BController:update() - successfully update ExcIEEEAC8B - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcIEEEAC8B entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excIEEEAC8BId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcIEEEAC8BCommand command = new DeleteExcIEEEAC8BCommand( excIEEEAC8BId );

    	try {
        	ExcIEEEAC8BBusinessDelegate delegate = ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcIEEEAC8B with key " + command.getExcIEEEAC8BId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEAC8B excIEEEAC8B = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC8BCommandRestController.class.getName());
    
}
