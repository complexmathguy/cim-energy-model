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
 * Implements Spring Controller command CQRS processing for entity GeographicalLocationVersion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GeographicalLocationVersion")
public class GeographicalLocationVersionCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a GeographicalLocationVersion.  if not key provided, calls create, otherwise calls save
     * @param		GeographicalLocationVersion	geographicalLocationVersion
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateGeographicalLocationVersionCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance().createGeographicalLocationVersion( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a GeographicalLocationVersion.  if no key provided, calls create, otherwise calls save
     * @param		GeographicalLocationVersion geographicalLocationVersion
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateGeographicalLocationVersionCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateGeographicalLocationVersionCommand
			// -----------------------------------------------
			completableFuture = GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance().updateGeographicalLocationVersion(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "GeographicalLocationVersionController:update() - successfully update GeographicalLocationVersion - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a GeographicalLocationVersion entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID geographicalLocationVersionId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteGeographicalLocationVersionCommand command = new DeleteGeographicalLocationVersionCommand( geographicalLocationVersionId );

    	try {
        	GeographicalLocationVersionBusinessDelegate delegate = GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted GeographicalLocationVersion with key " + command.getGeographicalLocationVersionId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected GeographicalLocationVersion geographicalLocationVersion = null;
    private static final Logger LOGGER = Logger.getLogger(GeographicalLocationVersionCommandRestController.class.getName());
    
}
