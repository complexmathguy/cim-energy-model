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
 * Implements Spring Controller command CQRS processing for entity DiagramObjectPoint.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DiagramObjectPoint")
public class DiagramObjectPointCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a DiagramObjectPoint.  if not key provided, calls create, otherwise calls save
     * @param		DiagramObjectPoint	diagramObjectPoint
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateDiagramObjectPointCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = DiagramObjectPointBusinessDelegate.getDiagramObjectPointInstance().createDiagramObjectPoint( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a DiagramObjectPoint.  if no key provided, calls create, otherwise calls save
     * @param		DiagramObjectPoint diagramObjectPoint
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateDiagramObjectPointCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateDiagramObjectPointCommand
			// -----------------------------------------------
			completableFuture = DiagramObjectPointBusinessDelegate.getDiagramObjectPointInstance().updateDiagramObjectPoint(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "DiagramObjectPointController:update() - successfully update DiagramObjectPoint - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a DiagramObjectPoint entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID diagramObjectPointId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteDiagramObjectPointCommand command = new DeleteDiagramObjectPointCommand( diagramObjectPointId );

    	try {
        	DiagramObjectPointBusinessDelegate delegate = DiagramObjectPointBusinessDelegate.getDiagramObjectPointInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted DiagramObjectPoint with key " + command.getDiagramObjectPointId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected DiagramObjectPoint diagramObjectPoint = null;
    private static final Logger LOGGER = Logger.getLogger(DiagramObjectPointCommandRestController.class.getName());
    
}
