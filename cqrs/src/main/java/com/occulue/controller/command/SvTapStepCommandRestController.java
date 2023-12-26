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
 * Implements Spring Controller command CQRS processing for entity SvTapStep.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SvTapStep")
public class SvTapStepCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a SvTapStep.  if not key provided, calls create, otherwise calls save
     * @param		SvTapStep	svTapStep
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateSvTapStepCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = SvTapStepBusinessDelegate.getSvTapStepInstance().createSvTapStep( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a SvTapStep.  if no key provided, calls create, otherwise calls save
     * @param		SvTapStep svTapStep
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateSvTapStepCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateSvTapStepCommand
			// -----------------------------------------------
			completableFuture = SvTapStepBusinessDelegate.getSvTapStepInstance().updateSvTapStep(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "SvTapStepController:update() - successfully update SvTapStep - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a SvTapStep entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID svTapStepId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteSvTapStepCommand command = new DeleteSvTapStepCommand( svTapStepId );

    	try {
        	SvTapStepBusinessDelegate delegate = SvTapStepBusinessDelegate.getSvTapStepInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted SvTapStep with key " + command.getSvTapStepId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected SvTapStep svTapStep = null;
    private static final Logger LOGGER = Logger.getLogger(SvTapStepCommandRestController.class.getName());
    
}
