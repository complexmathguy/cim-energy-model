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
 * Implements Spring Controller command CQRS processing for entity PhaseTapChangerLinear.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PhaseTapChangerLinear")
public class PhaseTapChangerLinearCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a PhaseTapChangerLinear.  if not key provided, calls create, otherwise calls save
     * @param		PhaseTapChangerLinear	phaseTapChangerLinear
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePhaseTapChangerLinearCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = PhaseTapChangerLinearBusinessDelegate.getPhaseTapChangerLinearInstance().createPhaseTapChangerLinear( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a PhaseTapChangerLinear.  if no key provided, calls create, otherwise calls save
     * @param		PhaseTapChangerLinear phaseTapChangerLinear
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePhaseTapChangerLinearCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePhaseTapChangerLinearCommand
			// -----------------------------------------------
			completableFuture = PhaseTapChangerLinearBusinessDelegate.getPhaseTapChangerLinearInstance().updatePhaseTapChangerLinear(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "PhaseTapChangerLinearController:update() - successfully update PhaseTapChangerLinear - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a PhaseTapChangerLinear entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID phaseTapChangerLinearId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePhaseTapChangerLinearCommand command = new DeletePhaseTapChangerLinearCommand( phaseTapChangerLinearId );

    	try {
        	PhaseTapChangerLinearBusinessDelegate delegate = PhaseTapChangerLinearBusinessDelegate.getPhaseTapChangerLinearInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted PhaseTapChangerLinear with key " + command.getPhaseTapChangerLinearId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected PhaseTapChangerLinear phaseTapChangerLinear = null;
    private static final Logger LOGGER = Logger.getLogger(PhaseTapChangerLinearCommandRestController.class.getName());
    
}
