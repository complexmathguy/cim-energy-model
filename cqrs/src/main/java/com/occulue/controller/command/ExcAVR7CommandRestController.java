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
 * Implements Spring Controller command CQRS processing for entity ExcAVR7.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcAVR7")
public class ExcAVR7CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcAVR7.  if not key provided, calls create, otherwise calls save
     * @param		ExcAVR7	excAVR7
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcAVR7Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcAVR7BusinessDelegate.getExcAVR7Instance().createExcAVR7( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcAVR7.  if no key provided, calls create, otherwise calls save
     * @param		ExcAVR7 excAVR7
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcAVR7Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcAVR7Command
			// -----------------------------------------------
			completableFuture = ExcAVR7BusinessDelegate.getExcAVR7Instance().updateExcAVR7(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcAVR7Controller:update() - successfully update ExcAVR7 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcAVR7 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excAVR7Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcAVR7Command command = new DeleteExcAVR7Command( excAVR7Id );

    	try {
        	ExcAVR7BusinessDelegate delegate = ExcAVR7BusinessDelegate.getExcAVR7Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcAVR7 with key " + command.getExcAVR7Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcAVR7 excAVR7 = null;
    private static final Logger LOGGER = Logger.getLogger(ExcAVR7CommandRestController.class.getName());
    
}
