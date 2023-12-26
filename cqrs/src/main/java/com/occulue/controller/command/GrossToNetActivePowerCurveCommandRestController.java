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
 * Implements Spring Controller command CQRS processing for entity GrossToNetActivePowerCurve.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GrossToNetActivePowerCurve")
public class GrossToNetActivePowerCurveCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a GrossToNetActivePowerCurve.  if not key provided, calls create, otherwise calls save
     * @param		GrossToNetActivePowerCurve	grossToNetActivePowerCurve
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateGrossToNetActivePowerCurveCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = GrossToNetActivePowerCurveBusinessDelegate.getGrossToNetActivePowerCurveInstance().createGrossToNetActivePowerCurve( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a GrossToNetActivePowerCurve.  if no key provided, calls create, otherwise calls save
     * @param		GrossToNetActivePowerCurve grossToNetActivePowerCurve
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateGrossToNetActivePowerCurveCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateGrossToNetActivePowerCurveCommand
			// -----------------------------------------------
			completableFuture = GrossToNetActivePowerCurveBusinessDelegate.getGrossToNetActivePowerCurveInstance().updateGrossToNetActivePowerCurve(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "GrossToNetActivePowerCurveController:update() - successfully update GrossToNetActivePowerCurve - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a GrossToNetActivePowerCurve entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID grossToNetActivePowerCurveId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteGrossToNetActivePowerCurveCommand command = new DeleteGrossToNetActivePowerCurveCommand( grossToNetActivePowerCurveId );

    	try {
        	GrossToNetActivePowerCurveBusinessDelegate delegate = GrossToNetActivePowerCurveBusinessDelegate.getGrossToNetActivePowerCurveInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted GrossToNetActivePowerCurve with key " + command.getGrossToNetActivePowerCurveId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected GrossToNetActivePowerCurve grossToNetActivePowerCurve = null;
    private static final Logger LOGGER = Logger.getLogger(GrossToNetActivePowerCurveCommandRestController.class.getName());
    
}
