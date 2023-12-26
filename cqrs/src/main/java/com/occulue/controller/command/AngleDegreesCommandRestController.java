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
 * Implements Spring Controller command CQRS processing for entity AngleDegrees.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/AngleDegrees")
public class AngleDegreesCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a AngleDegrees.  if not key provided, calls create, otherwise calls save
     * @param		AngleDegrees	angleDegrees
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateAngleDegreesCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = AngleDegreesBusinessDelegate.getAngleDegreesInstance().createAngleDegrees( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a AngleDegrees.  if no key provided, calls create, otherwise calls save
     * @param		AngleDegrees angleDegrees
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateAngleDegreesCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateAngleDegreesCommand
			// -----------------------------------------------
			completableFuture = AngleDegreesBusinessDelegate.getAngleDegreesInstance().updateAngleDegrees(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "AngleDegreesController:update() - successfully update AngleDegrees - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a AngleDegrees entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID angleDegreesId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteAngleDegreesCommand command = new DeleteAngleDegreesCommand( angleDegreesId );

    	try {
        	AngleDegreesBusinessDelegate delegate = AngleDegreesBusinessDelegate.getAngleDegreesInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted AngleDegrees with key " + command.getAngleDegreesId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected AngleDegrees angleDegrees = null;
    private static final Logger LOGGER = Logger.getLogger(AngleDegreesCommandRestController.class.getName());
    
}
