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
 * Implements Spring Controller command CQRS processing for entity ExcELIN2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcELIN2")
public class ExcELIN2CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcELIN2.  if not key provided, calls create, otherwise calls save
     * @param		ExcELIN2	excELIN2
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcELIN2Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcELIN2BusinessDelegate.getExcELIN2Instance().createExcELIN2( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcELIN2.  if no key provided, calls create, otherwise calls save
     * @param		ExcELIN2 excELIN2
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcELIN2Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcELIN2Command
			// -----------------------------------------------
			completableFuture = ExcELIN2BusinessDelegate.getExcELIN2Instance().updateExcELIN2(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcELIN2Controller:update() - successfully update ExcELIN2 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcELIN2 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excELIN2Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcELIN2Command command = new DeleteExcELIN2Command( excELIN2Id );

    	try {
        	ExcELIN2BusinessDelegate delegate = ExcELIN2BusinessDelegate.getExcELIN2Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcELIN2 with key " + command.getExcELIN2Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcELIN2 excELIN2 = null;
    private static final Logger LOGGER = Logger.getLogger(ExcELIN2CommandRestController.class.getName());
    
}
