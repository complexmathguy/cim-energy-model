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
 * Implements Spring Controller command CQRS processing for entity ExcPIC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcPIC")
public class ExcPICCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcPIC.  if not key provided, calls create, otherwise calls save
     * @param		ExcPIC	excPIC
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcPICCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcPICBusinessDelegate.getExcPICInstance().createExcPIC( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcPIC.  if no key provided, calls create, otherwise calls save
     * @param		ExcPIC excPIC
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcPICCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcPICCommand
			// -----------------------------------------------
			completableFuture = ExcPICBusinessDelegate.getExcPICInstance().updateExcPIC(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcPICController:update() - successfully update ExcPIC - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcPIC entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excPICId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcPICCommand command = new DeleteExcPICCommand( excPICId );

    	try {
        	ExcPICBusinessDelegate delegate = ExcPICBusinessDelegate.getExcPICInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcPIC with key " + command.getExcPICId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcPIC excPIC = null;
    private static final Logger LOGGER = Logger.getLogger(ExcPICCommandRestController.class.getName());
    
}
