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
 * Implements Spring Controller command CQRS processing for entity GeographicalRegion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GeographicalRegion")
public class GeographicalRegionCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a GeographicalRegion.  if not key provided, calls create, otherwise calls save
     * @param		GeographicalRegion	geographicalRegion
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateGeographicalRegionCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = GeographicalRegionBusinessDelegate.getGeographicalRegionInstance().createGeographicalRegion( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a GeographicalRegion.  if no key provided, calls create, otherwise calls save
     * @param		GeographicalRegion geographicalRegion
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateGeographicalRegionCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateGeographicalRegionCommand
			// -----------------------------------------------
			completableFuture = GeographicalRegionBusinessDelegate.getGeographicalRegionInstance().updateGeographicalRegion(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "GeographicalRegionController:update() - successfully update GeographicalRegion - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a GeographicalRegion entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID geographicalRegionId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteGeographicalRegionCommand command = new DeleteGeographicalRegionCommand( geographicalRegionId );

    	try {
        	GeographicalRegionBusinessDelegate delegate = GeographicalRegionBusinessDelegate.getGeographicalRegionInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted GeographicalRegion with key " + command.getGeographicalRegionId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected GeographicalRegion geographicalRegion = null;
    private static final Logger LOGGER = Logger.getLogger(GeographicalRegionCommandRestController.class.getName());
    
}
