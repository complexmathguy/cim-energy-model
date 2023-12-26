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
 * Implements Spring Controller command CQRS processing for entity DCEquipmentContainer.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCEquipmentContainer")
public class DCEquipmentContainerCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a DCEquipmentContainer.  if not key provided, calls create, otherwise calls save
     * @param		DCEquipmentContainer	dCEquipmentContainer
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateDCEquipmentContainerCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = DCEquipmentContainerBusinessDelegate.getDCEquipmentContainerInstance().createDCEquipmentContainer( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a DCEquipmentContainer.  if no key provided, calls create, otherwise calls save
     * @param		DCEquipmentContainer dCEquipmentContainer
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateDCEquipmentContainerCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateDCEquipmentContainerCommand
			// -----------------------------------------------
			completableFuture = DCEquipmentContainerBusinessDelegate.getDCEquipmentContainerInstance().updateDCEquipmentContainer(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "DCEquipmentContainerController:update() - successfully update DCEquipmentContainer - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a DCEquipmentContainer entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID dCEquipmentContainerId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteDCEquipmentContainerCommand command = new DeleteDCEquipmentContainerCommand( dCEquipmentContainerId );

    	try {
        	DCEquipmentContainerBusinessDelegate delegate = DCEquipmentContainerBusinessDelegate.getDCEquipmentContainerInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted DCEquipmentContainer with key " + command.getDCEquipmentContainerId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected DCEquipmentContainer dCEquipmentContainer = null;
    private static final Logger LOGGER = Logger.getLogger(DCEquipmentContainerCommandRestController.class.getName());
    
}
