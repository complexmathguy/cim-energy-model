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
 * Implements Spring Controller command CQRS processing for entity WindPlantReactiveControlIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindPlantReactiveControlIEC")
public class WindPlantReactiveControlIECCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a WindPlantReactiveControlIEC.  if not key provided, calls create, otherwise calls save
     * @param		WindPlantReactiveControlIEC	windPlantReactiveControlIEC
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateWindPlantReactiveControlIECCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance().createWindPlantReactiveControlIEC( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a WindPlantReactiveControlIEC.  if no key provided, calls create, otherwise calls save
     * @param		WindPlantReactiveControlIEC windPlantReactiveControlIEC
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateWindPlantReactiveControlIECCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateWindPlantReactiveControlIECCommand
			// -----------------------------------------------
			completableFuture = WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance().updateWindPlantReactiveControlIEC(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "WindPlantReactiveControlIECController:update() - successfully update WindPlantReactiveControlIEC - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a WindPlantReactiveControlIEC entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID windPlantReactiveControlIECId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteWindPlantReactiveControlIECCommand command = new DeleteWindPlantReactiveControlIECCommand( windPlantReactiveControlIECId );

    	try {
        	WindPlantReactiveControlIECBusinessDelegate delegate = WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted WindPlantReactiveControlIEC with key " + command.getWindPlantReactiveControlIECId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected WindPlantReactiveControlIEC windPlantReactiveControlIEC = null;
    private static final Logger LOGGER = Logger.getLogger(WindPlantReactiveControlIECCommandRestController.class.getName());
    
}
