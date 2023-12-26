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
 * Implements Spring Controller command CQRS processing for entity DiagramLayoutVersion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DiagramLayoutVersion")
public class DiagramLayoutVersionCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a DiagramLayoutVersion.  if not key provided, calls create, otherwise calls save
     * @param		DiagramLayoutVersion	diagramLayoutVersion
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateDiagramLayoutVersionCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = DiagramLayoutVersionBusinessDelegate.getDiagramLayoutVersionInstance().createDiagramLayoutVersion( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a DiagramLayoutVersion.  if no key provided, calls create, otherwise calls save
     * @param		DiagramLayoutVersion diagramLayoutVersion
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateDiagramLayoutVersionCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateDiagramLayoutVersionCommand
			// -----------------------------------------------
			completableFuture = DiagramLayoutVersionBusinessDelegate.getDiagramLayoutVersionInstance().updateDiagramLayoutVersion(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "DiagramLayoutVersionController:update() - successfully update DiagramLayoutVersion - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a DiagramLayoutVersion entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID diagramLayoutVersionId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteDiagramLayoutVersionCommand command = new DeleteDiagramLayoutVersionCommand( diagramLayoutVersionId );

    	try {
        	DiagramLayoutVersionBusinessDelegate delegate = DiagramLayoutVersionBusinessDelegate.getDiagramLayoutVersionInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted DiagramLayoutVersion with key " + command.getDiagramLayoutVersionId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected DiagramLayoutVersion diagramLayoutVersion = null;
    private static final Logger LOGGER = Logger.getLogger(DiagramLayoutVersionCommandRestController.class.getName());
    
}
