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
 * Implements Spring Controller command CQRS processing for entity MeasurementValueQuality.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/MeasurementValueQuality")
public class MeasurementValueQualityCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a MeasurementValueQuality.  if not key provided, calls create, otherwise calls save
     * @param		MeasurementValueQuality	measurementValueQuality
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateMeasurementValueQualityCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = MeasurementValueQualityBusinessDelegate.getMeasurementValueQualityInstance().createMeasurementValueQuality( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a MeasurementValueQuality.  if no key provided, calls create, otherwise calls save
     * @param		MeasurementValueQuality measurementValueQuality
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateMeasurementValueQualityCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateMeasurementValueQualityCommand
			// -----------------------------------------------
			completableFuture = MeasurementValueQualityBusinessDelegate.getMeasurementValueQualityInstance().updateMeasurementValueQuality(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "MeasurementValueQualityController:update() - successfully update MeasurementValueQuality - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a MeasurementValueQuality entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID measurementValueQualityId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteMeasurementValueQualityCommand command = new DeleteMeasurementValueQualityCommand( measurementValueQualityId );

    	try {
        	MeasurementValueQualityBusinessDelegate delegate = MeasurementValueQualityBusinessDelegate.getMeasurementValueQualityInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted MeasurementValueQuality with key " + command.getMeasurementValueQualityId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected MeasurementValueQuality measurementValueQuality = null;
    private static final Logger LOGGER = Logger.getLogger(MeasurementValueQualityCommandRestController.class.getName());
    
}
