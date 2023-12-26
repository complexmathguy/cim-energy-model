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
 * Implements Spring Controller command CQRS processing for entity AngleRadians.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/AngleRadians")
public class AngleRadiansCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a AngleRadians.  if not key provided, calls create, otherwise calls save
     * @param		AngleRadians	angleRadians
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateAngleRadiansCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = AngleRadiansBusinessDelegate.getAngleRadiansInstance().createAngleRadians( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a AngleRadians.  if no key provided, calls create, otherwise calls save
     * @param		AngleRadians angleRadians
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateAngleRadiansCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateAngleRadiansCommand
			// -----------------------------------------------
			completableFuture = AngleRadiansBusinessDelegate.getAngleRadiansInstance().updateAngleRadians(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "AngleRadiansController:update() - successfully update AngleRadians - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a AngleRadians entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID angleRadiansId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteAngleRadiansCommand command = new DeleteAngleRadiansCommand( angleRadiansId );

    	try {
        	AngleRadiansBusinessDelegate delegate = AngleRadiansBusinessDelegate.getAngleRadiansInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted AngleRadians with key " + command.getAngleRadiansId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected AngleRadians angleRadians = null;
    private static final Logger LOGGER = Logger.getLogger(AngleRadiansCommandRestController.class.getName());
    
}
