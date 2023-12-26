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
 * Implements Spring Controller command CQRS processing for entity ThermalGeneratingUnit.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ThermalGeneratingUnit")
public class ThermalGeneratingUnitCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ThermalGeneratingUnit.  if not key provided, calls create, otherwise calls save
     * @param		ThermalGeneratingUnit	thermalGeneratingUnit
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateThermalGeneratingUnitCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ThermalGeneratingUnitBusinessDelegate.getThermalGeneratingUnitInstance().createThermalGeneratingUnit( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ThermalGeneratingUnit.  if no key provided, calls create, otherwise calls save
     * @param		ThermalGeneratingUnit thermalGeneratingUnit
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateThermalGeneratingUnitCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateThermalGeneratingUnitCommand
			// -----------------------------------------------
			completableFuture = ThermalGeneratingUnitBusinessDelegate.getThermalGeneratingUnitInstance().updateThermalGeneratingUnit(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ThermalGeneratingUnitController:update() - successfully update ThermalGeneratingUnit - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ThermalGeneratingUnit entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID thermalGeneratingUnitId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteThermalGeneratingUnitCommand command = new DeleteThermalGeneratingUnitCommand( thermalGeneratingUnitId );

    	try {
        	ThermalGeneratingUnitBusinessDelegate delegate = ThermalGeneratingUnitBusinessDelegate.getThermalGeneratingUnitInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ThermalGeneratingUnit with key " + command.getThermalGeneratingUnitId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ThermalGeneratingUnit thermalGeneratingUnit = null;
    private static final Logger LOGGER = Logger.getLogger(ThermalGeneratingUnitCommandRestController.class.getName());
    
}
