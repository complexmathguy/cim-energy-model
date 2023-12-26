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
 * Implements Spring Controller command CQRS processing for entity TapChangerTablePoint.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TapChangerTablePoint")
public class TapChangerTablePointCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a TapChangerTablePoint.  if not key provided, calls create, otherwise calls save
     * @param		TapChangerTablePoint	tapChangerTablePoint
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateTapChangerTablePointCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = TapChangerTablePointBusinessDelegate.getTapChangerTablePointInstance().createTapChangerTablePoint( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a TapChangerTablePoint.  if no key provided, calls create, otherwise calls save
     * @param		TapChangerTablePoint tapChangerTablePoint
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateTapChangerTablePointCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateTapChangerTablePointCommand
			// -----------------------------------------------
			completableFuture = TapChangerTablePointBusinessDelegate.getTapChangerTablePointInstance().updateTapChangerTablePoint(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "TapChangerTablePointController:update() - successfully update TapChangerTablePoint - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a TapChangerTablePoint entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID tapChangerTablePointId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteTapChangerTablePointCommand command = new DeleteTapChangerTablePointCommand( tapChangerTablePointId );

    	try {
        	TapChangerTablePointBusinessDelegate delegate = TapChangerTablePointBusinessDelegate.getTapChangerTablePointInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted TapChangerTablePoint with key " + command.getTapChangerTablePointId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected TapChangerTablePoint tapChangerTablePoint = null;
    private static final Logger LOGGER = Logger.getLogger(TapChangerTablePointCommandRestController.class.getName());
    
}
