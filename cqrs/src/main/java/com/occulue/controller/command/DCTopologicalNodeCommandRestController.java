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
 * Implements Spring Controller command CQRS processing for entity DCTopologicalNode.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCTopologicalNode")
public class DCTopologicalNodeCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a DCTopologicalNode.  if not key provided, calls create, otherwise calls save
     * @param		DCTopologicalNode	dCTopologicalNode
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateDCTopologicalNodeCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = DCTopologicalNodeBusinessDelegate.getDCTopologicalNodeInstance().createDCTopologicalNode( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a DCTopologicalNode.  if no key provided, calls create, otherwise calls save
     * @param		DCTopologicalNode dCTopologicalNode
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateDCTopologicalNodeCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateDCTopologicalNodeCommand
			// -----------------------------------------------
			completableFuture = DCTopologicalNodeBusinessDelegate.getDCTopologicalNodeInstance().updateDCTopologicalNode(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "DCTopologicalNodeController:update() - successfully update DCTopologicalNode - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a DCTopologicalNode entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID dCTopologicalNodeId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteDCTopologicalNodeCommand command = new DeleteDCTopologicalNodeCommand( dCTopologicalNodeId );

    	try {
        	DCTopologicalNodeBusinessDelegate delegate = DCTopologicalNodeBusinessDelegate.getDCTopologicalNodeInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted DCTopologicalNode with key " + command.getDCTopologicalNodeId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected DCTopologicalNode dCTopologicalNode = null;
    private static final Logger LOGGER = Logger.getLogger(DCTopologicalNodeCommandRestController.class.getName());
    
}
