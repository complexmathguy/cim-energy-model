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
 * Implements Spring Controller command CQRS processing for entity EquivalentEquipment.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/EquivalentEquipment")
public class EquivalentEquipmentCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a EquivalentEquipment.  if not key provided, calls create, otherwise calls save
     * @param		EquivalentEquipment	equivalentEquipment
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateEquivalentEquipmentCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = EquivalentEquipmentBusinessDelegate.getEquivalentEquipmentInstance().createEquivalentEquipment( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a EquivalentEquipment.  if no key provided, calls create, otherwise calls save
     * @param		EquivalentEquipment equivalentEquipment
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateEquivalentEquipmentCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateEquivalentEquipmentCommand
			// -----------------------------------------------
			completableFuture = EquivalentEquipmentBusinessDelegate.getEquivalentEquipmentInstance().updateEquivalentEquipment(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "EquivalentEquipmentController:update() - successfully update EquivalentEquipment - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a EquivalentEquipment entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID equivalentEquipmentId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteEquivalentEquipmentCommand command = new DeleteEquivalentEquipmentCommand( equivalentEquipmentId );

    	try {
        	EquivalentEquipmentBusinessDelegate delegate = EquivalentEquipmentBusinessDelegate.getEquivalentEquipmentInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted EquivalentEquipment with key " + command.getEquivalentEquipmentId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected EquivalentEquipment equivalentEquipment = null;
    private static final Logger LOGGER = Logger.getLogger(EquivalentEquipmentCommandRestController.class.getName());
    
}
