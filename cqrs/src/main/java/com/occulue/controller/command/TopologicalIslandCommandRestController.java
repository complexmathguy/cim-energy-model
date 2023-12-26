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
 * Implements Spring Controller command CQRS processing for entity TopologicalIsland.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TopologicalIsland")
public class TopologicalIslandCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a TopologicalIsland.  if not key provided, calls create, otherwise calls save
     * @param		TopologicalIsland	topologicalIsland
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateTopologicalIslandCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = TopologicalIslandBusinessDelegate.getTopologicalIslandInstance().createTopologicalIsland( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a TopologicalIsland.  if no key provided, calls create, otherwise calls save
     * @param		TopologicalIsland topologicalIsland
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateTopologicalIslandCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateTopologicalIslandCommand
			// -----------------------------------------------
			completableFuture = TopologicalIslandBusinessDelegate.getTopologicalIslandInstance().updateTopologicalIsland(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "TopologicalIslandController:update() - successfully update TopologicalIsland - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a TopologicalIsland entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID topologicalIslandId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteTopologicalIslandCommand command = new DeleteTopologicalIslandCommand( topologicalIslandId );

    	try {
        	TopologicalIslandBusinessDelegate delegate = TopologicalIslandBusinessDelegate.getTopologicalIslandInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted TopologicalIsland with key " + command.getTopologicalIslandId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected TopologicalIsland topologicalIsland = null;
    private static final Logger LOGGER = Logger.getLogger(TopologicalIslandCommandRestController.class.getName());
    
}
