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
 * Implements Spring Controller command CQRS processing for entity EquipmentBoundaryVersion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/EquipmentBoundaryVersion")
public class EquipmentBoundaryVersionCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a EquipmentBoundaryVersion.  if not key provided, calls create, otherwise calls save
     * @param		EquipmentBoundaryVersion	equipmentBoundaryVersion
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateEquipmentBoundaryVersionCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance().createEquipmentBoundaryVersion( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a EquipmentBoundaryVersion.  if no key provided, calls create, otherwise calls save
     * @param		EquipmentBoundaryVersion equipmentBoundaryVersion
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateEquipmentBoundaryVersionCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateEquipmentBoundaryVersionCommand
			// -----------------------------------------------
			completableFuture = EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance().updateEquipmentBoundaryVersion(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "EquipmentBoundaryVersionController:update() - successfully update EquipmentBoundaryVersion - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a EquipmentBoundaryVersion entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID equipmentBoundaryVersionId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteEquipmentBoundaryVersionCommand command = new DeleteEquipmentBoundaryVersionCommand( equipmentBoundaryVersionId );

    	try {
        	EquipmentBoundaryVersionBusinessDelegate delegate = EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted EquipmentBoundaryVersion with key " + command.getEquipmentBoundaryVersionId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected EquipmentBoundaryVersion equipmentBoundaryVersion = null;
    private static final Logger LOGGER = Logger.getLogger(EquipmentBoundaryVersionCommandRestController.class.getName());
    
}
