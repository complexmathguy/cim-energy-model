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
 * Implements Spring Controller command CQRS processing for entity DiagramObject.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DiagramObject")
public class DiagramObjectCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a DiagramObject.  if not key provided, calls create, otherwise calls save
     * @param		DiagramObject	diagramObject
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateDiagramObjectCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = DiagramObjectBusinessDelegate.getDiagramObjectInstance().createDiagramObject( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a DiagramObject.  if no key provided, calls create, otherwise calls save
     * @param		DiagramObject diagramObject
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateDiagramObjectCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateDiagramObjectCommand
			// -----------------------------------------------
			completableFuture = DiagramObjectBusinessDelegate.getDiagramObjectInstance().updateDiagramObject(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "DiagramObjectController:update() - successfully update DiagramObject - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a DiagramObject entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID diagramObjectId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteDiagramObjectCommand command = new DeleteDiagramObjectCommand( diagramObjectId );

    	try {
        	DiagramObjectBusinessDelegate delegate = DiagramObjectBusinessDelegate.getDiagramObjectInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted DiagramObject with key " + command.getDiagramObjectId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected DiagramObject diagramObject = null;
    private static final Logger LOGGER = Logger.getLogger(DiagramObjectCommandRestController.class.getName());
    
}
