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
 * Implements Spring Controller command CQRS processing for entity DiscontinuousExcitationControlUserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DiscontinuousExcitationControlUserDefined")
public class DiscontinuousExcitationControlUserDefinedCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a DiscontinuousExcitationControlUserDefined.  if not key provided, calls create, otherwise calls save
     * @param		DiscontinuousExcitationControlUserDefined	discontinuousExcitationControlUserDefined
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateDiscontinuousExcitationControlUserDefinedCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = DiscontinuousExcitationControlUserDefinedBusinessDelegate.getDiscontinuousExcitationControlUserDefinedInstance().createDiscontinuousExcitationControlUserDefined( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a DiscontinuousExcitationControlUserDefined.  if no key provided, calls create, otherwise calls save
     * @param		DiscontinuousExcitationControlUserDefined discontinuousExcitationControlUserDefined
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateDiscontinuousExcitationControlUserDefinedCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateDiscontinuousExcitationControlUserDefinedCommand
			// -----------------------------------------------
			completableFuture = DiscontinuousExcitationControlUserDefinedBusinessDelegate.getDiscontinuousExcitationControlUserDefinedInstance().updateDiscontinuousExcitationControlUserDefined(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "DiscontinuousExcitationControlUserDefinedController:update() - successfully update DiscontinuousExcitationControlUserDefined - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a DiscontinuousExcitationControlUserDefined entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID discontinuousExcitationControlUserDefinedId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteDiscontinuousExcitationControlUserDefinedCommand command = new DeleteDiscontinuousExcitationControlUserDefinedCommand( discontinuousExcitationControlUserDefinedId );

    	try {
        	DiscontinuousExcitationControlUserDefinedBusinessDelegate delegate = DiscontinuousExcitationControlUserDefinedBusinessDelegate.getDiscontinuousExcitationControlUserDefinedInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted DiscontinuousExcitationControlUserDefined with key " + command.getDiscontinuousExcitationControlUserDefinedId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected DiscontinuousExcitationControlUserDefined discontinuousExcitationControlUserDefined = null;
    private static final Logger LOGGER = Logger.getLogger(DiscontinuousExcitationControlUserDefinedCommandRestController.class.getName());
    
}
