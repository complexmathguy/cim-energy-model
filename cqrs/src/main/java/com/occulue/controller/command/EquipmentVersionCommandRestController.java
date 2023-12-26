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
 * Implements Spring Controller command CQRS processing for entity EquipmentVersion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/EquipmentVersion")
public class EquipmentVersionCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a EquipmentVersion.  if not key provided, calls create, otherwise calls save
     * @param		EquipmentVersion	equipmentVersion
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateEquipmentVersionCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = EquipmentVersionBusinessDelegate.getEquipmentVersionInstance().createEquipmentVersion( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a EquipmentVersion.  if no key provided, calls create, otherwise calls save
     * @param		EquipmentVersion equipmentVersion
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateEquipmentVersionCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateEquipmentVersionCommand
			// -----------------------------------------------
			completableFuture = EquipmentVersionBusinessDelegate.getEquipmentVersionInstance().updateEquipmentVersion(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "EquipmentVersionController:update() - successfully update EquipmentVersion - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a EquipmentVersion entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID equipmentVersionId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteEquipmentVersionCommand command = new DeleteEquipmentVersionCommand( equipmentVersionId );

    	try {
        	EquipmentVersionBusinessDelegate delegate = EquipmentVersionBusinessDelegate.getEquipmentVersionInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted EquipmentVersion with key " + command.getEquipmentVersionId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected EquipmentVersion equipmentVersion = null;
    private static final Logger LOGGER = Logger.getLogger(EquipmentVersionCommandRestController.class.getName());
    
}
