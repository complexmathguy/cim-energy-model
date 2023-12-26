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
 * Implements Spring Controller command CQRS processing for entity DiagramStyle.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DiagramStyle")
public class DiagramStyleCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a DiagramStyle.  if not key provided, calls create, otherwise calls save
     * @param		DiagramStyle	diagramStyle
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateDiagramStyleCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = DiagramStyleBusinessDelegate.getDiagramStyleInstance().createDiagramStyle( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a DiagramStyle.  if no key provided, calls create, otherwise calls save
     * @param		DiagramStyle diagramStyle
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateDiagramStyleCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateDiagramStyleCommand
			// -----------------------------------------------
			completableFuture = DiagramStyleBusinessDelegate.getDiagramStyleInstance().updateDiagramStyle(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "DiagramStyleController:update() - successfully update DiagramStyle - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a DiagramStyle entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID diagramStyleId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteDiagramStyleCommand command = new DeleteDiagramStyleCommand( diagramStyleId );

    	try {
        	DiagramStyleBusinessDelegate delegate = DiagramStyleBusinessDelegate.getDiagramStyleInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted DiagramStyle with key " + command.getDiagramStyleId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected DiagramStyle diagramStyle = null;
    private static final Logger LOGGER = Logger.getLogger(DiagramStyleCommandRestController.class.getName());
    
}
