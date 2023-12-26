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
 * Implements Spring Controller command CQRS processing for entity PhaseTapChangerSymmetrical.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PhaseTapChangerSymmetrical")
public class PhaseTapChangerSymmetricalCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a PhaseTapChangerSymmetrical.  if not key provided, calls create, otherwise calls save
     * @param		PhaseTapChangerSymmetrical	phaseTapChangerSymmetrical
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePhaseTapChangerSymmetricalCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = PhaseTapChangerSymmetricalBusinessDelegate.getPhaseTapChangerSymmetricalInstance().createPhaseTapChangerSymmetrical( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a PhaseTapChangerSymmetrical.  if no key provided, calls create, otherwise calls save
     * @param		PhaseTapChangerSymmetrical phaseTapChangerSymmetrical
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePhaseTapChangerSymmetricalCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePhaseTapChangerSymmetricalCommand
			// -----------------------------------------------
			completableFuture = PhaseTapChangerSymmetricalBusinessDelegate.getPhaseTapChangerSymmetricalInstance().updatePhaseTapChangerSymmetrical(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "PhaseTapChangerSymmetricalController:update() - successfully update PhaseTapChangerSymmetrical - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a PhaseTapChangerSymmetrical entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID phaseTapChangerSymmetricalId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePhaseTapChangerSymmetricalCommand command = new DeletePhaseTapChangerSymmetricalCommand( phaseTapChangerSymmetricalId );

    	try {
        	PhaseTapChangerSymmetricalBusinessDelegate delegate = PhaseTapChangerSymmetricalBusinessDelegate.getPhaseTapChangerSymmetricalInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted PhaseTapChangerSymmetrical with key " + command.getPhaseTapChangerSymmetricalId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected PhaseTapChangerSymmetrical phaseTapChangerSymmetrical = null;
    private static final Logger LOGGER = Logger.getLogger(PhaseTapChangerSymmetricalCommandRestController.class.getName());
    
}
