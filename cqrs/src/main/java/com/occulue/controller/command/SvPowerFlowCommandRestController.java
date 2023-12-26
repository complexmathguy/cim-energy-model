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
 * Implements Spring Controller command CQRS processing for entity SvPowerFlow.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SvPowerFlow")
public class SvPowerFlowCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a SvPowerFlow.  if not key provided, calls create, otherwise calls save
     * @param		SvPowerFlow	svPowerFlow
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateSvPowerFlowCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = SvPowerFlowBusinessDelegate.getSvPowerFlowInstance().createSvPowerFlow( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a SvPowerFlow.  if no key provided, calls create, otherwise calls save
     * @param		SvPowerFlow svPowerFlow
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateSvPowerFlowCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateSvPowerFlowCommand
			// -----------------------------------------------
			completableFuture = SvPowerFlowBusinessDelegate.getSvPowerFlowInstance().updateSvPowerFlow(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "SvPowerFlowController:update() - successfully update SvPowerFlow - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a SvPowerFlow entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID svPowerFlowId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteSvPowerFlowCommand command = new DeleteSvPowerFlowCommand( svPowerFlowId );

    	try {
        	SvPowerFlowBusinessDelegate delegate = SvPowerFlowBusinessDelegate.getSvPowerFlowInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted SvPowerFlow with key " + command.getSvPowerFlowId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected SvPowerFlow svPowerFlow = null;
    private static final Logger LOGGER = Logger.getLogger(SvPowerFlowCommandRestController.class.getName());
    
}
