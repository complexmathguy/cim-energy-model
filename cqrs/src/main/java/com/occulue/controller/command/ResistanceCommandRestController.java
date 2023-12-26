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
 * Implements Spring Controller command CQRS processing for entity Resistance.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Resistance")
public class ResistanceCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a Resistance.  if not key provided, calls create, otherwise calls save
     * @param		Resistance	resistance
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateResistanceCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ResistanceBusinessDelegate.getResistanceInstance().createResistance( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a Resistance.  if no key provided, calls create, otherwise calls save
     * @param		Resistance resistance
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateResistanceCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateResistanceCommand
			// -----------------------------------------------
			completableFuture = ResistanceBusinessDelegate.getResistanceInstance().updateResistance(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ResistanceController:update() - successfully update Resistance - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a Resistance entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID resistanceId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteResistanceCommand command = new DeleteResistanceCommand( resistanceId );

    	try {
        	ResistanceBusinessDelegate delegate = ResistanceBusinessDelegate.getResistanceInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted Resistance with key " + command.getResistanceId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected Resistance resistance = null;
    private static final Logger LOGGER = Logger.getLogger(ResistanceCommandRestController.class.getName());
    
}
