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
 * Implements Spring Controller command CQRS processing for entity EquipmentContainer.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/EquipmentContainer")
public class EquipmentContainerCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a EquipmentContainer.  if not key provided, calls create, otherwise calls save
     * @param		EquipmentContainer	equipmentContainer
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateEquipmentContainerCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = EquipmentContainerBusinessDelegate.getEquipmentContainerInstance().createEquipmentContainer( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a EquipmentContainer.  if no key provided, calls create, otherwise calls save
     * @param		EquipmentContainer equipmentContainer
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateEquipmentContainerCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateEquipmentContainerCommand
			// -----------------------------------------------
			completableFuture = EquipmentContainerBusinessDelegate.getEquipmentContainerInstance().updateEquipmentContainer(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "EquipmentContainerController:update() - successfully update EquipmentContainer - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a EquipmentContainer entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID equipmentContainerId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteEquipmentContainerCommand command = new DeleteEquipmentContainerCommand( equipmentContainerId );

    	try {
        	EquipmentContainerBusinessDelegate delegate = EquipmentContainerBusinessDelegate.getEquipmentContainerInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted EquipmentContainer with key " + command.getEquipmentContainerId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected EquipmentContainer equipmentContainer = null;
    private static final Logger LOGGER = Logger.getLogger(EquipmentContainerCommandRestController.class.getName());
    
}
