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
 * Implements Spring Controller command CQRS processing for entity PhaseTapChangerTablePoint.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PhaseTapChangerTablePoint")
public class PhaseTapChangerTablePointCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a PhaseTapChangerTablePoint.  if not key provided, calls create, otherwise calls save
     * @param		PhaseTapChangerTablePoint	phaseTapChangerTablePoint
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePhaseTapChangerTablePointCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = PhaseTapChangerTablePointBusinessDelegate.getPhaseTapChangerTablePointInstance().createPhaseTapChangerTablePoint( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a PhaseTapChangerTablePoint.  if no key provided, calls create, otherwise calls save
     * @param		PhaseTapChangerTablePoint phaseTapChangerTablePoint
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePhaseTapChangerTablePointCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePhaseTapChangerTablePointCommand
			// -----------------------------------------------
			completableFuture = PhaseTapChangerTablePointBusinessDelegate.getPhaseTapChangerTablePointInstance().updatePhaseTapChangerTablePoint(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "PhaseTapChangerTablePointController:update() - successfully update PhaseTapChangerTablePoint - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a PhaseTapChangerTablePoint entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID phaseTapChangerTablePointId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePhaseTapChangerTablePointCommand command = new DeletePhaseTapChangerTablePointCommand( phaseTapChangerTablePointId );

    	try {
        	PhaseTapChangerTablePointBusinessDelegate delegate = PhaseTapChangerTablePointBusinessDelegate.getPhaseTapChangerTablePointInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted PhaseTapChangerTablePoint with key " + command.getPhaseTapChangerTablePointId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected PhaseTapChangerTablePoint phaseTapChangerTablePoint = null;
    private static final Logger LOGGER = Logger.getLogger(PhaseTapChangerTablePointCommandRestController.class.getName());
    
}
