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
 * Implements Spring Controller command CQRS processing for entity PhaseTapChangerTabular.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PhaseTapChangerTabular")
public class PhaseTapChangerTabularCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a PhaseTapChangerTabular.  if not key provided, calls create, otherwise calls save
     * @param		PhaseTapChangerTabular	phaseTapChangerTabular
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePhaseTapChangerTabularCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = PhaseTapChangerTabularBusinessDelegate.getPhaseTapChangerTabularInstance().createPhaseTapChangerTabular( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a PhaseTapChangerTabular.  if no key provided, calls create, otherwise calls save
     * @param		PhaseTapChangerTabular phaseTapChangerTabular
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePhaseTapChangerTabularCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePhaseTapChangerTabularCommand
			// -----------------------------------------------
			completableFuture = PhaseTapChangerTabularBusinessDelegate.getPhaseTapChangerTabularInstance().updatePhaseTapChangerTabular(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "PhaseTapChangerTabularController:update() - successfully update PhaseTapChangerTabular - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a PhaseTapChangerTabular entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID phaseTapChangerTabularId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePhaseTapChangerTabularCommand command = new DeletePhaseTapChangerTabularCommand( phaseTapChangerTabularId );

    	try {
        	PhaseTapChangerTabularBusinessDelegate delegate = PhaseTapChangerTabularBusinessDelegate.getPhaseTapChangerTabularInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted PhaseTapChangerTabular with key " + command.getPhaseTapChangerTabularId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected PhaseTapChangerTabular phaseTapChangerTabular = null;
    private static final Logger LOGGER = Logger.getLogger(PhaseTapChangerTabularCommandRestController.class.getName());
    
}
