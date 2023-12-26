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
 * Implements Spring Controller command CQRS processing for entity SvVoltage.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SvVoltage")
public class SvVoltageCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a SvVoltage.  if not key provided, calls create, otherwise calls save
     * @param		SvVoltage	svVoltage
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateSvVoltageCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = SvVoltageBusinessDelegate.getSvVoltageInstance().createSvVoltage( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a SvVoltage.  if no key provided, calls create, otherwise calls save
     * @param		SvVoltage svVoltage
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateSvVoltageCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateSvVoltageCommand
			// -----------------------------------------------
			completableFuture = SvVoltageBusinessDelegate.getSvVoltageInstance().updateSvVoltage(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "SvVoltageController:update() - successfully update SvVoltage - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a SvVoltage entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID svVoltageId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteSvVoltageCommand command = new DeleteSvVoltageCommand( svVoltageId );

    	try {
        	SvVoltageBusinessDelegate delegate = SvVoltageBusinessDelegate.getSvVoltageInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted SvVoltage with key " + command.getSvVoltageId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected SvVoltage svVoltage = null;
    private static final Logger LOGGER = Logger.getLogger(SvVoltageCommandRestController.class.getName());
    
}
