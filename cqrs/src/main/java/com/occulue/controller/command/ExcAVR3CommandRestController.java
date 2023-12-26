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
 * Implements Spring Controller command CQRS processing for entity ExcAVR3.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcAVR3")
public class ExcAVR3CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ExcAVR3.  if not key provided, calls create, otherwise calls save
     * @param		ExcAVR3	excAVR3
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateExcAVR3Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ExcAVR3BusinessDelegate.getExcAVR3Instance().createExcAVR3( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ExcAVR3.  if no key provided, calls create, otherwise calls save
     * @param		ExcAVR3 excAVR3
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateExcAVR3Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateExcAVR3Command
			// -----------------------------------------------
			completableFuture = ExcAVR3BusinessDelegate.getExcAVR3Instance().updateExcAVR3(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ExcAVR3Controller:update() - successfully update ExcAVR3 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ExcAVR3 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID excAVR3Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteExcAVR3Command command = new DeleteExcAVR3Command( excAVR3Id );

    	try {
        	ExcAVR3BusinessDelegate delegate = ExcAVR3BusinessDelegate.getExcAVR3Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ExcAVR3 with key " + command.getExcAVR3Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcAVR3 excAVR3 = null;
    private static final Logger LOGGER = Logger.getLogger(ExcAVR3CommandRestController.class.getName());
    
}
