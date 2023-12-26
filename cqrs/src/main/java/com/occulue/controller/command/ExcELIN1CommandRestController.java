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
 * Implements Spring Controller command CQRS processing for entity ExcELIN1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcELIN1")
public class ExcELIN1CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcELIN1.  if not key provided, calls create, otherwise calls save
     * @param		ExcELIN1	excELIN1
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcELIN1Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcELIN1BusinessDelegate.getExcELIN1Instance().createExcELIN1( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcELIN1.  if no key provided, calls create, otherwise calls save
     * @param		ExcELIN1 excELIN1
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcELIN1Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcELIN1Command
			// -----------------------------------------------
			completableFuture = ExcELIN1BusinessDelegate.getExcELIN1Instance().updateExcELIN1(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcELIN1Controller:update() - successfully update ExcELIN1 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcELIN1 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excELIN1Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcELIN1Command command = new DeleteExcELIN1Command( excELIN1Id );

    	try {
        	ExcELIN1BusinessDelegate delegate = ExcELIN1BusinessDelegate.getExcELIN1Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcELIN1 with key " + command.getExcELIN1Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcELIN1 excELIN1 = null;
    private static final Logger LOGGER = Logger.getLogger(ExcELIN1CommandRestController.class.getName());
    
}
