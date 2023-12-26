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
 * Implements Spring Controller command CQRS processing for entity ENTSOETopologicalNode.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ENTSOETopologicalNode")
public class ENTSOETopologicalNodeCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ENTSOETopologicalNode.  if not key provided, calls create, otherwise calls save
     * @param		ENTSOETopologicalNode	eNTSOETopologicalNode
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateENTSOETopologicalNodeCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ENTSOETopologicalNodeBusinessDelegate.getENTSOETopologicalNodeInstance().createENTSOETopologicalNode( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ENTSOETopologicalNode.  if no key provided, calls create, otherwise calls save
     * @param		ENTSOETopologicalNode eNTSOETopologicalNode
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateENTSOETopologicalNodeCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateENTSOETopologicalNodeCommand
			// -----------------------------------------------
			completableFuture = ENTSOETopologicalNodeBusinessDelegate.getENTSOETopologicalNodeInstance().updateENTSOETopologicalNode(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ENTSOETopologicalNodeController:update() - successfully update ENTSOETopologicalNode - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ENTSOETopologicalNode entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID eNTSOETopologicalNodeId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteENTSOETopologicalNodeCommand command = new DeleteENTSOETopologicalNodeCommand( eNTSOETopologicalNodeId );

    	try {
        	ENTSOETopologicalNodeBusinessDelegate delegate = ENTSOETopologicalNodeBusinessDelegate.getENTSOETopologicalNodeInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ENTSOETopologicalNode with key " + command.getENTSOETopologicalNodeId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ENTSOETopologicalNode eNTSOETopologicalNode = null;
    private static final Logger LOGGER = Logger.getLogger(ENTSOETopologicalNodeCommandRestController.class.getName());
    
}
