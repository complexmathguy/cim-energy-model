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
 * Implements Spring Controller command CQRS processing for entity VsCapabilityCurve.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/VsCapabilityCurve")
public class VsCapabilityCurveCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a VsCapabilityCurve.  if not key provided, calls create, otherwise calls save
     * @param		VsCapabilityCurve	vsCapabilityCurve
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateVsCapabilityCurveCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = VsCapabilityCurveBusinessDelegate.getVsCapabilityCurveInstance().createVsCapabilityCurve( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a VsCapabilityCurve.  if no key provided, calls create, otherwise calls save
     * @param		VsCapabilityCurve vsCapabilityCurve
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateVsCapabilityCurveCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateVsCapabilityCurveCommand
			// -----------------------------------------------
			completableFuture = VsCapabilityCurveBusinessDelegate.getVsCapabilityCurveInstance().updateVsCapabilityCurve(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "VsCapabilityCurveController:update() - successfully update VsCapabilityCurve - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a VsCapabilityCurve entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID vsCapabilityCurveId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteVsCapabilityCurveCommand command = new DeleteVsCapabilityCurveCommand( vsCapabilityCurveId );

    	try {
        	VsCapabilityCurveBusinessDelegate delegate = VsCapabilityCurveBusinessDelegate.getVsCapabilityCurveInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted VsCapabilityCurve with key " + command.getVsCapabilityCurveId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected VsCapabilityCurve vsCapabilityCurve = null;
    private static final Logger LOGGER = Logger.getLogger(VsCapabilityCurveCommandRestController.class.getName());
    
}
