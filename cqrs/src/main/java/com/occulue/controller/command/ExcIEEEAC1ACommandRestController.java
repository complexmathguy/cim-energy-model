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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEAC1A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEAC1A")
public class ExcIEEEAC1ACommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcIEEEAC1A.  if not key provided, calls create, otherwise calls save
     * @param		ExcIEEEAC1A	excIEEEAC1A
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcIEEEAC1ACommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().createExcIEEEAC1A( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcIEEEAC1A.  if no key provided, calls create, otherwise calls save
     * @param		ExcIEEEAC1A excIEEEAC1A
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcIEEEAC1ACommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcIEEEAC1ACommand
			// -----------------------------------------------
			completableFuture = ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().updateExcIEEEAC1A(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcIEEEAC1AController:update() - successfully update ExcIEEEAC1A - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcIEEEAC1A entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excIEEEAC1AId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcIEEEAC1ACommand command = new DeleteExcIEEEAC1ACommand( excIEEEAC1AId );

    	try {
        	ExcIEEEAC1ABusinessDelegate delegate = ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcIEEEAC1A with key " + command.getExcIEEEAC1AId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEAC1A excIEEEAC1A = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC1ACommandRestController.class.getName());
    
}
