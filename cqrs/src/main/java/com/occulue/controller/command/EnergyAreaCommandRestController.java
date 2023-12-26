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
 * Implements Spring Controller command CQRS processing for entity EnergyArea.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/EnergyArea")
public class EnergyAreaCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a EnergyArea.  if not key provided, calls create, otherwise calls save
     * @param		EnergyArea	energyArea
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateEnergyAreaCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = EnergyAreaBusinessDelegate.getEnergyAreaInstance().createEnergyArea( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a EnergyArea.  if no key provided, calls create, otherwise calls save
     * @param		EnergyArea energyArea
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateEnergyAreaCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateEnergyAreaCommand
			// -----------------------------------------------
			completableFuture = EnergyAreaBusinessDelegate.getEnergyAreaInstance().updateEnergyArea(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "EnergyAreaController:update() - successfully update EnergyArea - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a EnergyArea entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID energyAreaId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteEnergyAreaCommand command = new DeleteEnergyAreaCommand( energyAreaId );

    	try {
        	EnergyAreaBusinessDelegate delegate = EnergyAreaBusinessDelegate.getEnergyAreaInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted EnergyArea with key " + command.getEnergyAreaId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected EnergyArea energyArea = null;
    private static final Logger LOGGER = Logger.getLogger(EnergyAreaCommandRestController.class.getName());
    
}
