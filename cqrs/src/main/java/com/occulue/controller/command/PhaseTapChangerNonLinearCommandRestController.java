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
 * Implements Spring Controller command CQRS processing for entity PhaseTapChangerNonLinear.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PhaseTapChangerNonLinear")
public class PhaseTapChangerNonLinearCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a PhaseTapChangerNonLinear.  if not key provided, calls create, otherwise calls save
     * @param		PhaseTapChangerNonLinear	phaseTapChangerNonLinear
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePhaseTapChangerNonLinearCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = PhaseTapChangerNonLinearBusinessDelegate.getPhaseTapChangerNonLinearInstance().createPhaseTapChangerNonLinear( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a PhaseTapChangerNonLinear.  if no key provided, calls create, otherwise calls save
     * @param		PhaseTapChangerNonLinear phaseTapChangerNonLinear
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePhaseTapChangerNonLinearCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePhaseTapChangerNonLinearCommand
			// -----------------------------------------------
			completableFuture = PhaseTapChangerNonLinearBusinessDelegate.getPhaseTapChangerNonLinearInstance().updatePhaseTapChangerNonLinear(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "PhaseTapChangerNonLinearController:update() - successfully update PhaseTapChangerNonLinear - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a PhaseTapChangerNonLinear entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID phaseTapChangerNonLinearId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePhaseTapChangerNonLinearCommand command = new DeletePhaseTapChangerNonLinearCommand( phaseTapChangerNonLinearId );

    	try {
        	PhaseTapChangerNonLinearBusinessDelegate delegate = PhaseTapChangerNonLinearBusinessDelegate.getPhaseTapChangerNonLinearInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted PhaseTapChangerNonLinear with key " + command.getPhaseTapChangerNonLinearId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected PhaseTapChangerNonLinear phaseTapChangerNonLinear = null;
    private static final Logger LOGGER = Logger.getLogger(PhaseTapChangerNonLinearCommandRestController.class.getName());
    
}
