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
 * Implements Spring Controller command CQRS processing for entity PositionPoint.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PositionPoint")
public class PositionPointCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a PositionPoint.  if not key provided, calls create, otherwise calls save
     * @param		PositionPoint	positionPoint
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePositionPointCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = PositionPointBusinessDelegate.getPositionPointInstance().createPositionPoint( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a PositionPoint.  if no key provided, calls create, otherwise calls save
     * @param		PositionPoint positionPoint
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePositionPointCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePositionPointCommand
			// -----------------------------------------------
			completableFuture = PositionPointBusinessDelegate.getPositionPointInstance().updatePositionPoint(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "PositionPointController:update() - successfully update PositionPoint - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a PositionPoint entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID positionPointId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePositionPointCommand command = new DeletePositionPointCommand( positionPointId );

    	try {
        	PositionPointBusinessDelegate delegate = PositionPointBusinessDelegate.getPositionPointInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted PositionPoint with key " + command.getPositionPointId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected PositionPoint positionPoint = null;
    private static final Logger LOGGER = Logger.getLogger(PositionPointCommandRestController.class.getName());
    
}
