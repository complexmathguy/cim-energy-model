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
 * Implements Spring Controller command CQRS processing for entity SvStatus.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SvStatus")
public class SvStatusCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a SvStatus.  if not key provided, calls create, otherwise calls save
     * @param		SvStatus	svStatus
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateSvStatusCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = SvStatusBusinessDelegate.getSvStatusInstance().createSvStatus( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a SvStatus.  if no key provided, calls create, otherwise calls save
     * @param		SvStatus svStatus
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateSvStatusCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateSvStatusCommand
			// -----------------------------------------------
			completableFuture = SvStatusBusinessDelegate.getSvStatusInstance().updateSvStatus(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "SvStatusController:update() - successfully update SvStatus - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a SvStatus entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID svStatusId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteSvStatusCommand command = new DeleteSvStatusCommand( svStatusId );

    	try {
        	SvStatusBusinessDelegate delegate = SvStatusBusinessDelegate.getSvStatusInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted SvStatus with key " + command.getSvStatusId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected SvStatus svStatus = null;
    private static final Logger LOGGER = Logger.getLogger(SvStatusCommandRestController.class.getName());
    
}
