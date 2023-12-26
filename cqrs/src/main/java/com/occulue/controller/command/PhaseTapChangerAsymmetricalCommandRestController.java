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
 * Implements Spring Controller command CQRS processing for entity PhaseTapChangerAsymmetrical.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PhaseTapChangerAsymmetrical")
public class PhaseTapChangerAsymmetricalCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a PhaseTapChangerAsymmetrical.  if not key provided, calls create, otherwise calls save
     * @param		PhaseTapChangerAsymmetrical	phaseTapChangerAsymmetrical
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePhaseTapChangerAsymmetricalCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = PhaseTapChangerAsymmetricalBusinessDelegate.getPhaseTapChangerAsymmetricalInstance().createPhaseTapChangerAsymmetrical( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a PhaseTapChangerAsymmetrical.  if no key provided, calls create, otherwise calls save
     * @param		PhaseTapChangerAsymmetrical phaseTapChangerAsymmetrical
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePhaseTapChangerAsymmetricalCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePhaseTapChangerAsymmetricalCommand
			// -----------------------------------------------
			completableFuture = PhaseTapChangerAsymmetricalBusinessDelegate.getPhaseTapChangerAsymmetricalInstance().updatePhaseTapChangerAsymmetrical(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "PhaseTapChangerAsymmetricalController:update() - successfully update PhaseTapChangerAsymmetrical - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a PhaseTapChangerAsymmetrical entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID phaseTapChangerAsymmetricalId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePhaseTapChangerAsymmetricalCommand command = new DeletePhaseTapChangerAsymmetricalCommand( phaseTapChangerAsymmetricalId );

    	try {
        	PhaseTapChangerAsymmetricalBusinessDelegate delegate = PhaseTapChangerAsymmetricalBusinessDelegate.getPhaseTapChangerAsymmetricalInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted PhaseTapChangerAsymmetrical with key " + command.getPhaseTapChangerAsymmetricalId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected PhaseTapChangerAsymmetrical phaseTapChangerAsymmetrical = null;
    private static final Logger LOGGER = Logger.getLogger(PhaseTapChangerAsymmetricalCommandRestController.class.getName());
    
}
