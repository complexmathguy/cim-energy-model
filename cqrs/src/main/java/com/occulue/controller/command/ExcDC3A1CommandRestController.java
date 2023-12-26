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
 * Implements Spring Controller command CQRS processing for entity ExcDC3A1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcDC3A1")
public class ExcDC3A1CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcDC3A1.  if not key provided, calls create, otherwise calls save
     * @param		ExcDC3A1	excDC3A1
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcDC3A1Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcDC3A1BusinessDelegate.getExcDC3A1Instance().createExcDC3A1( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcDC3A1.  if no key provided, calls create, otherwise calls save
     * @param		ExcDC3A1 excDC3A1
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcDC3A1Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcDC3A1Command
			// -----------------------------------------------
			completableFuture = ExcDC3A1BusinessDelegate.getExcDC3A1Instance().updateExcDC3A1(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcDC3A1Controller:update() - successfully update ExcDC3A1 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcDC3A1 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excDC3A1Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcDC3A1Command command = new DeleteExcDC3A1Command( excDC3A1Id );

    	try {
        	ExcDC3A1BusinessDelegate delegate = ExcDC3A1BusinessDelegate.getExcDC3A1Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcDC3A1 with key " + command.getExcDC3A1Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcDC3A1 excDC3A1 = null;
    private static final Logger LOGGER = Logger.getLogger(ExcDC3A1CommandRestController.class.getName());
    
}
