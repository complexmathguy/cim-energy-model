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
 * Implements Spring Controller command CQRS processing for entity RegularTimePoint.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/RegularTimePoint")
public class RegularTimePointCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a RegularTimePoint.  if not key provided, calls create, otherwise calls save
     * @param		RegularTimePoint	regularTimePoint
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateRegularTimePointCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = RegularTimePointBusinessDelegate.getRegularTimePointInstance().createRegularTimePoint( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a RegularTimePoint.  if no key provided, calls create, otherwise calls save
     * @param		RegularTimePoint regularTimePoint
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateRegularTimePointCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateRegularTimePointCommand
			// -----------------------------------------------
			completableFuture = RegularTimePointBusinessDelegate.getRegularTimePointInstance().updateRegularTimePoint(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "RegularTimePointController:update() - successfully update RegularTimePoint - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a RegularTimePoint entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID regularTimePointId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteRegularTimePointCommand command = new DeleteRegularTimePointCommand( regularTimePointId );

    	try {
        	RegularTimePointBusinessDelegate delegate = RegularTimePointBusinessDelegate.getRegularTimePointInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted RegularTimePoint with key " + command.getRegularTimePointId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected RegularTimePoint regularTimePoint = null;
    private static final Logger LOGGER = Logger.getLogger(RegularTimePointCommandRestController.class.getName());
    
}
