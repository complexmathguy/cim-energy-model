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
 * Implements Spring Controller command CQRS processing for entity ConductingEquipment.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ConductingEquipment")
public class ConductingEquipmentCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ConductingEquipment.  if not key provided, calls create, otherwise calls save
     * @param		ConductingEquipment	conductingEquipment
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateConductingEquipmentCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ConductingEquipmentBusinessDelegate.getConductingEquipmentInstance().createConductingEquipment( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ConductingEquipment.  if no key provided, calls create, otherwise calls save
     * @param		ConductingEquipment conductingEquipment
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateConductingEquipmentCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateConductingEquipmentCommand
			// -----------------------------------------------
			completableFuture = ConductingEquipmentBusinessDelegate.getConductingEquipmentInstance().updateConductingEquipment(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ConductingEquipmentController:update() - successfully update ConductingEquipment - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ConductingEquipment entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID conductingEquipmentId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteConductingEquipmentCommand command = new DeleteConductingEquipmentCommand( conductingEquipmentId );

    	try {
        	ConductingEquipmentBusinessDelegate delegate = ConductingEquipmentBusinessDelegate.getConductingEquipmentInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ConductingEquipment with key " + command.getConductingEquipmentId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ConductingEquipment conductingEquipment = null;
    private static final Logger LOGGER = Logger.getLogger(ConductingEquipmentCommandRestController.class.getName());
    
}
