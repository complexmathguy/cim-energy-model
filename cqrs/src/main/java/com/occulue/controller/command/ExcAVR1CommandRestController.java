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
 * Implements Spring Controller command CQRS processing for entity ExcAVR1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcAVR1")
public class ExcAVR1CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcAVR1.  if not key provided, calls create, otherwise calls save
     * @param		ExcAVR1	excAVR1
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcAVR1Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcAVR1BusinessDelegate.getExcAVR1Instance().createExcAVR1( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcAVR1.  if no key provided, calls create, otherwise calls save
     * @param		ExcAVR1 excAVR1
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcAVR1Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcAVR1Command
			// -----------------------------------------------
			completableFuture = ExcAVR1BusinessDelegate.getExcAVR1Instance().updateExcAVR1(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcAVR1Controller:update() - successfully update ExcAVR1 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcAVR1 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excAVR1Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcAVR1Command command = new DeleteExcAVR1Command( excAVR1Id );

    	try {
        	ExcAVR1BusinessDelegate delegate = ExcAVR1BusinessDelegate.getExcAVR1Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcAVR1 with key " + command.getExcAVR1Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcAVR1 excAVR1 = null;
    private static final Logger LOGGER = Logger.getLogger(ExcAVR1CommandRestController.class.getName());
    
}
