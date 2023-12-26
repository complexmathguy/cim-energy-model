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
 * Implements Spring Controller command CQRS processing for entity ACLineSegment.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ACLineSegment")
public class ACLineSegmentCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ACLineSegment.  if not key provided, calls create, otherwise calls save
     * @param		ACLineSegment	aCLineSegment
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateACLineSegmentCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ACLineSegmentBusinessDelegate.getACLineSegmentInstance().createACLineSegment( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ACLineSegment.  if no key provided, calls create, otherwise calls save
     * @param		ACLineSegment aCLineSegment
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateACLineSegmentCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateACLineSegmentCommand
			// -----------------------------------------------
			completableFuture = ACLineSegmentBusinessDelegate.getACLineSegmentInstance().updateACLineSegment(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ACLineSegmentController:update() - successfully update ACLineSegment - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ACLineSegment entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID aCLineSegmentId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteACLineSegmentCommand command = new DeleteACLineSegmentCommand( aCLineSegmentId );

    	try {
        	ACLineSegmentBusinessDelegate delegate = ACLineSegmentBusinessDelegate.getACLineSegmentInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ACLineSegment with key " + command.getACLineSegmentId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ACLineSegment aCLineSegment = null;
    private static final Logger LOGGER = Logger.getLogger(ACLineSegmentCommandRestController.class.getName());
    
}
