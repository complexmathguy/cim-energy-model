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
 * Implements Spring Controller command CQRS processing for entity SubGeographicalRegion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SubGeographicalRegion")
public class SubGeographicalRegionCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a SubGeographicalRegion.  if not key provided, calls create, otherwise calls save
     * @param		SubGeographicalRegion	subGeographicalRegion
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateSubGeographicalRegionCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = SubGeographicalRegionBusinessDelegate.getSubGeographicalRegionInstance().createSubGeographicalRegion( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a SubGeographicalRegion.  if no key provided, calls create, otherwise calls save
     * @param		SubGeographicalRegion subGeographicalRegion
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateSubGeographicalRegionCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateSubGeographicalRegionCommand
			// -----------------------------------------------
			completableFuture = SubGeographicalRegionBusinessDelegate.getSubGeographicalRegionInstance().updateSubGeographicalRegion(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "SubGeographicalRegionController:update() - successfully update SubGeographicalRegion - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a SubGeographicalRegion entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID subGeographicalRegionId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteSubGeographicalRegionCommand command = new DeleteSubGeographicalRegionCommand( subGeographicalRegionId );

    	try {
        	SubGeographicalRegionBusinessDelegate delegate = SubGeographicalRegionBusinessDelegate.getSubGeographicalRegionInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted SubGeographicalRegion with key " + command.getSubGeographicalRegionId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected SubGeographicalRegion subGeographicalRegion = null;
    private static final Logger LOGGER = Logger.getLogger(SubGeographicalRegionCommandRestController.class.getName());
    
}
