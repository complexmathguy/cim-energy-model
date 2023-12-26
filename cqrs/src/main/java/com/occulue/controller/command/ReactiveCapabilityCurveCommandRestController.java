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
 * Implements Spring Controller command CQRS processing for entity ReactiveCapabilityCurve.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ReactiveCapabilityCurve")
public class ReactiveCapabilityCurveCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ReactiveCapabilityCurve.  if not key provided, calls create, otherwise calls save
     * @param		ReactiveCapabilityCurve	reactiveCapabilityCurve
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateReactiveCapabilityCurveCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ReactiveCapabilityCurveBusinessDelegate.getReactiveCapabilityCurveInstance().createReactiveCapabilityCurve( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ReactiveCapabilityCurve.  if no key provided, calls create, otherwise calls save
     * @param		ReactiveCapabilityCurve reactiveCapabilityCurve
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateReactiveCapabilityCurveCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateReactiveCapabilityCurveCommand
			// -----------------------------------------------
			completableFuture = ReactiveCapabilityCurveBusinessDelegate.getReactiveCapabilityCurveInstance().updateReactiveCapabilityCurve(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ReactiveCapabilityCurveController:update() - successfully update ReactiveCapabilityCurve - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ReactiveCapabilityCurve entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID reactiveCapabilityCurveId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteReactiveCapabilityCurveCommand command = new DeleteReactiveCapabilityCurveCommand( reactiveCapabilityCurveId );

    	try {
        	ReactiveCapabilityCurveBusinessDelegate delegate = ReactiveCapabilityCurveBusinessDelegate.getReactiveCapabilityCurveInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ReactiveCapabilityCurve with key " + command.getReactiveCapabilityCurveId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ReactiveCapabilityCurve reactiveCapabilityCurve = null;
    private static final Logger LOGGER = Logger.getLogger(ReactiveCapabilityCurveCommandRestController.class.getName());
    
}
