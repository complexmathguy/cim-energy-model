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
 * Implements Spring Controller command CQRS processing for entity HydroPowerPlant.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/HydroPowerPlant")
public class HydroPowerPlantCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a HydroPowerPlant.  if not key provided, calls create, otherwise calls save
     * @param		HydroPowerPlant	hydroPowerPlant
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateHydroPowerPlantCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = HydroPowerPlantBusinessDelegate.getHydroPowerPlantInstance().createHydroPowerPlant( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a HydroPowerPlant.  if no key provided, calls create, otherwise calls save
     * @param		HydroPowerPlant hydroPowerPlant
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateHydroPowerPlantCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateHydroPowerPlantCommand
			// -----------------------------------------------
			completableFuture = HydroPowerPlantBusinessDelegate.getHydroPowerPlantInstance().updateHydroPowerPlant(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "HydroPowerPlantController:update() - successfully update HydroPowerPlant - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a HydroPowerPlant entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID hydroPowerPlantId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteHydroPowerPlantCommand command = new DeleteHydroPowerPlantCommand( hydroPowerPlantId );

    	try {
        	HydroPowerPlantBusinessDelegate delegate = HydroPowerPlantBusinessDelegate.getHydroPowerPlantInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted HydroPowerPlant with key " + command.getHydroPowerPlantId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected HydroPowerPlant hydroPowerPlant = null;
    private static final Logger LOGGER = Logger.getLogger(HydroPowerPlantCommandRestController.class.getName());
    
}
