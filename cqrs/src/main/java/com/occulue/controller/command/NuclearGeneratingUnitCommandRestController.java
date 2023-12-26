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
 * Implements Spring Controller command CQRS processing for entity NuclearGeneratingUnit.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/NuclearGeneratingUnit")
public class NuclearGeneratingUnitCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a NuclearGeneratingUnit.  if not key provided, calls create, otherwise calls save
     * @param		NuclearGeneratingUnit	nuclearGeneratingUnit
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateNuclearGeneratingUnitCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = NuclearGeneratingUnitBusinessDelegate.getNuclearGeneratingUnitInstance().createNuclearGeneratingUnit( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a NuclearGeneratingUnit.  if no key provided, calls create, otherwise calls save
     * @param		NuclearGeneratingUnit nuclearGeneratingUnit
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateNuclearGeneratingUnitCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateNuclearGeneratingUnitCommand
			// -----------------------------------------------
			completableFuture = NuclearGeneratingUnitBusinessDelegate.getNuclearGeneratingUnitInstance().updateNuclearGeneratingUnit(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "NuclearGeneratingUnitController:update() - successfully update NuclearGeneratingUnit - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a NuclearGeneratingUnit entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID nuclearGeneratingUnitId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteNuclearGeneratingUnitCommand command = new DeleteNuclearGeneratingUnitCommand( nuclearGeneratingUnitId );

    	try {
        	NuclearGeneratingUnitBusinessDelegate delegate = NuclearGeneratingUnitBusinessDelegate.getNuclearGeneratingUnitInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted NuclearGeneratingUnit with key " + command.getNuclearGeneratingUnitId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected NuclearGeneratingUnit nuclearGeneratingUnit = null;
    private static final Logger LOGGER = Logger.getLogger(NuclearGeneratingUnitCommandRestController.class.getName());
    
}
