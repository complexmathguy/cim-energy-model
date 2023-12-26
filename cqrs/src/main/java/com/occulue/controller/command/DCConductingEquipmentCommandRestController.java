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
 * Implements Spring Controller command CQRS processing for entity DCConductingEquipment.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCConductingEquipment")
public class DCConductingEquipmentCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a DCConductingEquipment.  if not key provided, calls create, otherwise calls save
     * @param		DCConductingEquipment	dCConductingEquipment
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateDCConductingEquipmentCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = DCConductingEquipmentBusinessDelegate.getDCConductingEquipmentInstance().createDCConductingEquipment( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a DCConductingEquipment.  if no key provided, calls create, otherwise calls save
     * @param		DCConductingEquipment dCConductingEquipment
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateDCConductingEquipmentCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateDCConductingEquipmentCommand
			// -----------------------------------------------
			completableFuture = DCConductingEquipmentBusinessDelegate.getDCConductingEquipmentInstance().updateDCConductingEquipment(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "DCConductingEquipmentController:update() - successfully update DCConductingEquipment - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a DCConductingEquipment entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID dCConductingEquipmentId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteDCConductingEquipmentCommand command = new DeleteDCConductingEquipmentCommand( dCConductingEquipmentId );

    	try {
        	DCConductingEquipmentBusinessDelegate delegate = DCConductingEquipmentBusinessDelegate.getDCConductingEquipmentInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted DCConductingEquipment with key " + command.getDCConductingEquipmentId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected DCConductingEquipment dCConductingEquipment = null;
    private static final Logger LOGGER = Logger.getLogger(DCConductingEquipmentCommandRestController.class.getName());
    
}
