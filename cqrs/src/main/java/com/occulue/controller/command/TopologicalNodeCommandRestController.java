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
 * Implements Spring Controller command CQRS processing for entity TopologicalNode.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TopologicalNode")
public class TopologicalNodeCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a TopologicalNode.  if not key provided, calls create, otherwise calls save
     * @param		TopologicalNode	topologicalNode
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateTopologicalNodeCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = TopologicalNodeBusinessDelegate.getTopologicalNodeInstance().createTopologicalNode( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a TopologicalNode.  if no key provided, calls create, otherwise calls save
     * @param		TopologicalNode topologicalNode
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateTopologicalNodeCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateTopologicalNodeCommand
			// -----------------------------------------------
			completableFuture = TopologicalNodeBusinessDelegate.getTopologicalNodeInstance().updateTopologicalNode(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "TopologicalNodeController:update() - successfully update TopologicalNode - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a TopologicalNode entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID topologicalNodeId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteTopologicalNodeCommand command = new DeleteTopologicalNodeCommand( topologicalNodeId );

    	try {
        	TopologicalNodeBusinessDelegate delegate = TopologicalNodeBusinessDelegate.getTopologicalNodeInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted TopologicalNode with key " + command.getTopologicalNodeId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected TopologicalNode topologicalNode = null;
    private static final Logger LOGGER = Logger.getLogger(TopologicalNodeCommandRestController.class.getName());
    
}
