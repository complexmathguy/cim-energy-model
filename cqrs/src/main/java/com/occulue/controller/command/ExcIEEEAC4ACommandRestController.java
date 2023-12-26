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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEAC4A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEAC4A")
public class ExcIEEEAC4ACommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcIEEEAC4A.  if not key provided, calls create, otherwise calls save
     * @param		ExcIEEEAC4A	excIEEEAC4A
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcIEEEAC4ACommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcIEEEAC4ABusinessDelegate.getExcIEEEAC4AInstance().createExcIEEEAC4A( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcIEEEAC4A.  if no key provided, calls create, otherwise calls save
     * @param		ExcIEEEAC4A excIEEEAC4A
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcIEEEAC4ACommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcIEEEAC4ACommand
			// -----------------------------------------------
			completableFuture = ExcIEEEAC4ABusinessDelegate.getExcIEEEAC4AInstance().updateExcIEEEAC4A(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcIEEEAC4AController:update() - successfully update ExcIEEEAC4A - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcIEEEAC4A entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excIEEEAC4AId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcIEEEAC4ACommand command = new DeleteExcIEEEAC4ACommand( excIEEEAC4AId );

    	try {
        	ExcIEEEAC4ABusinessDelegate delegate = ExcIEEEAC4ABusinessDelegate.getExcIEEEAC4AInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcIEEEAC4A with key " + command.getExcIEEEAC4AId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEAC4A excIEEEAC4A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC4ACommandRestController.class.getName());
    
}
