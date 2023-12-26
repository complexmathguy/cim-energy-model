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
 * Implements Spring Controller command CQRS processing for entity ResistancePerLength.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ResistancePerLength")
public class ResistancePerLengthCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ResistancePerLength.  if not key provided, calls create, otherwise calls save
     * @param		ResistancePerLength	resistancePerLength
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateResistancePerLengthCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ResistancePerLengthBusinessDelegate.getResistancePerLengthInstance().createResistancePerLength( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ResistancePerLength.  if no key provided, calls create, otherwise calls save
     * @param		ResistancePerLength resistancePerLength
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateResistancePerLengthCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateResistancePerLengthCommand
			// -----------------------------------------------
			completableFuture = ResistancePerLengthBusinessDelegate.getResistancePerLengthInstance().updateResistancePerLength(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ResistancePerLengthController:update() - successfully update ResistancePerLength - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ResistancePerLength entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID resistancePerLengthId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteResistancePerLengthCommand command = new DeleteResistancePerLengthCommand( resistancePerLengthId );

    	try {
        	ResistancePerLengthBusinessDelegate delegate = ResistancePerLengthBusinessDelegate.getResistancePerLengthInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ResistancePerLength with key " + command.getResistancePerLengthId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ResistancePerLength resistancePerLength = null;
    private static final Logger LOGGER = Logger.getLogger(ResistancePerLengthCommandRestController.class.getName());
    
}
