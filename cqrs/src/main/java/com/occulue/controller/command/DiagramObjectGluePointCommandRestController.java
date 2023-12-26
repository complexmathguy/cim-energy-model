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
 * Implements Spring Controller command CQRS processing for entity DiagramObjectGluePoint.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DiagramObjectGluePoint")
public class DiagramObjectGluePointCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a DiagramObjectGluePoint.  if not key provided, calls create, otherwise calls save
     * @param		DiagramObjectGluePoint	diagramObjectGluePoint
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateDiagramObjectGluePointCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = DiagramObjectGluePointBusinessDelegate.getDiagramObjectGluePointInstance().createDiagramObjectGluePoint( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a DiagramObjectGluePoint.  if no key provided, calls create, otherwise calls save
     * @param		DiagramObjectGluePoint diagramObjectGluePoint
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateDiagramObjectGluePointCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateDiagramObjectGluePointCommand
			// -----------------------------------------------
			completableFuture = DiagramObjectGluePointBusinessDelegate.getDiagramObjectGluePointInstance().updateDiagramObjectGluePoint(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "DiagramObjectGluePointController:update() - successfully update DiagramObjectGluePoint - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a DiagramObjectGluePoint entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID diagramObjectGluePointId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteDiagramObjectGluePointCommand command = new DeleteDiagramObjectGluePointCommand( diagramObjectGluePointId );

    	try {
        	DiagramObjectGluePointBusinessDelegate delegate = DiagramObjectGluePointBusinessDelegate.getDiagramObjectGluePointInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted DiagramObjectGluePoint with key " + command.getDiagramObjectGluePointId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected DiagramObjectGluePoint diagramObjectGluePoint = null;
    private static final Logger LOGGER = Logger.getLogger(DiagramObjectGluePointCommandRestController.class.getName());
    
}
