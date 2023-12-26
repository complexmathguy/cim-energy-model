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
 * Implements Spring Controller command CQRS processing for entity SetPoint.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SetPoint")
public class SetPointCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a SetPoint.  if not key provided, calls create, otherwise calls save
     * @param		SetPoint	setPoint
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateSetPointCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = SetPointBusinessDelegate.getSetPointInstance().createSetPoint( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a SetPoint.  if no key provided, calls create, otherwise calls save
     * @param		SetPoint setPoint
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateSetPointCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateSetPointCommand
			// -----------------------------------------------
			completableFuture = SetPointBusinessDelegate.getSetPointInstance().updateSetPoint(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "SetPointController:update() - successfully update SetPoint - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a SetPoint entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID setPointId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteSetPointCommand command = new DeleteSetPointCommand( setPointId );

    	try {
        	SetPointBusinessDelegate delegate = SetPointBusinessDelegate.getSetPointInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted SetPoint with key " + command.getSetPointId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected SetPoint setPoint = null;
    private static final Logger LOGGER = Logger.getLogger(SetPointCommandRestController.class.getName());
    
}
