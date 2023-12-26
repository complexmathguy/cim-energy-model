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
 * Implements Spring Controller command CQRS processing for entity Equipment.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Equipment")
public class EquipmentCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a Equipment.  if not key provided, calls create, otherwise calls save
     * @param		Equipment	equipment
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateEquipmentCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = EquipmentBusinessDelegate.getEquipmentInstance().createEquipment( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a Equipment.  if no key provided, calls create, otherwise calls save
     * @param		Equipment equipment
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateEquipmentCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateEquipmentCommand
			// -----------------------------------------------
			completableFuture = EquipmentBusinessDelegate.getEquipmentInstance().updateEquipment(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "EquipmentController:update() - successfully update Equipment - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a Equipment entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID equipmentId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteEquipmentCommand command = new DeleteEquipmentCommand( equipmentId );

    	try {
        	EquipmentBusinessDelegate delegate = EquipmentBusinessDelegate.getEquipmentInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted Equipment with key " + command.getEquipmentId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected Equipment equipment = null;
    private static final Logger LOGGER = Logger.getLogger(EquipmentCommandRestController.class.getName());
    
}
