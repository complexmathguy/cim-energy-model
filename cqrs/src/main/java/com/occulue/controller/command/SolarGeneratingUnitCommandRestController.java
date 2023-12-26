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
 * Implements Spring Controller command CQRS processing for entity SolarGeneratingUnit.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SolarGeneratingUnit")
public class SolarGeneratingUnitCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a SolarGeneratingUnit.  if not key provided, calls create, otherwise calls save
     * @param		SolarGeneratingUnit	solarGeneratingUnit
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateSolarGeneratingUnitCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = SolarGeneratingUnitBusinessDelegate.getSolarGeneratingUnitInstance().createSolarGeneratingUnit( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a SolarGeneratingUnit.  if no key provided, calls create, otherwise calls save
     * @param		SolarGeneratingUnit solarGeneratingUnit
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateSolarGeneratingUnitCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateSolarGeneratingUnitCommand
			// -----------------------------------------------
			completableFuture = SolarGeneratingUnitBusinessDelegate.getSolarGeneratingUnitInstance().updateSolarGeneratingUnit(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "SolarGeneratingUnitController:update() - successfully update SolarGeneratingUnit - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a SolarGeneratingUnit entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID solarGeneratingUnitId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteSolarGeneratingUnitCommand command = new DeleteSolarGeneratingUnitCommand( solarGeneratingUnitId );

    	try {
        	SolarGeneratingUnitBusinessDelegate delegate = SolarGeneratingUnitBusinessDelegate.getSolarGeneratingUnitInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted SolarGeneratingUnit with key " + command.getSolarGeneratingUnitId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected SolarGeneratingUnit solarGeneratingUnit = null;
    private static final Logger LOGGER = Logger.getLogger(SolarGeneratingUnitCommandRestController.class.getName());
    
}
