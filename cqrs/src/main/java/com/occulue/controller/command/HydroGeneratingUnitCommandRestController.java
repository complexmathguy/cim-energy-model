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
 * Implements Spring Controller command CQRS processing for entity HydroGeneratingUnit.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/HydroGeneratingUnit")
public class HydroGeneratingUnitCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a HydroGeneratingUnit.  if not key provided, calls create, otherwise calls save
     * @param		HydroGeneratingUnit	hydroGeneratingUnit
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateHydroGeneratingUnitCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = HydroGeneratingUnitBusinessDelegate.getHydroGeneratingUnitInstance().createHydroGeneratingUnit( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a HydroGeneratingUnit.  if no key provided, calls create, otherwise calls save
     * @param		HydroGeneratingUnit hydroGeneratingUnit
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateHydroGeneratingUnitCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateHydroGeneratingUnitCommand
			// -----------------------------------------------
			completableFuture = HydroGeneratingUnitBusinessDelegate.getHydroGeneratingUnitInstance().updateHydroGeneratingUnit(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "HydroGeneratingUnitController:update() - successfully update HydroGeneratingUnit - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a HydroGeneratingUnit entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID hydroGeneratingUnitId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteHydroGeneratingUnitCommand command = new DeleteHydroGeneratingUnitCommand( hydroGeneratingUnitId );

    	try {
        	HydroGeneratingUnitBusinessDelegate delegate = HydroGeneratingUnitBusinessDelegate.getHydroGeneratingUnitInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted HydroGeneratingUnit with key " + command.getHydroGeneratingUnitId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected HydroGeneratingUnit hydroGeneratingUnit = null;
    private static final Logger LOGGER = Logger.getLogger(HydroGeneratingUnitCommandRestController.class.getName());
    
}
