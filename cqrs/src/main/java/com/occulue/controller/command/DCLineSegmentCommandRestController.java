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
 * Implements Spring Controller command CQRS processing for entity DCLineSegment.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCLineSegment")
public class DCLineSegmentCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a DCLineSegment.  if not key provided, calls create, otherwise calls save
     * @param		DCLineSegment	dCLineSegment
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateDCLineSegmentCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = DCLineSegmentBusinessDelegate.getDCLineSegmentInstance().createDCLineSegment( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a DCLineSegment.  if no key provided, calls create, otherwise calls save
     * @param		DCLineSegment dCLineSegment
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateDCLineSegmentCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateDCLineSegmentCommand
			// -----------------------------------------------
			completableFuture = DCLineSegmentBusinessDelegate.getDCLineSegmentInstance().updateDCLineSegment(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "DCLineSegmentController:update() - successfully update DCLineSegment - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a DCLineSegment entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID dCLineSegmentId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteDCLineSegmentCommand command = new DeleteDCLineSegmentCommand( dCLineSegmentId );

    	try {
        	DCLineSegmentBusinessDelegate delegate = DCLineSegmentBusinessDelegate.getDCLineSegmentInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted DCLineSegment with key " + command.getDCLineSegmentId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected DCLineSegment dCLineSegment = null;
    private static final Logger LOGGER = Logger.getLogger(DCLineSegmentCommandRestController.class.getName());
    
}
