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
 * Implements Spring Controller command CQRS processing for entity TopologyBoundaryVersion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TopologyBoundaryVersion")
public class TopologyBoundaryVersionCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a TopologyBoundaryVersion.  if not key provided, calls create, otherwise calls save
     * @param		TopologyBoundaryVersion	topologyBoundaryVersion
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateTopologyBoundaryVersionCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance().createTopologyBoundaryVersion( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a TopologyBoundaryVersion.  if no key provided, calls create, otherwise calls save
     * @param		TopologyBoundaryVersion topologyBoundaryVersion
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateTopologyBoundaryVersionCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateTopologyBoundaryVersionCommand
			// -----------------------------------------------
			completableFuture = TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance().updateTopologyBoundaryVersion(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "TopologyBoundaryVersionController:update() - successfully update TopologyBoundaryVersion - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a TopologyBoundaryVersion entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID topologyBoundaryVersionId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteTopologyBoundaryVersionCommand command = new DeleteTopologyBoundaryVersionCommand( topologyBoundaryVersionId );

    	try {
        	TopologyBoundaryVersionBusinessDelegate delegate = TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted TopologyBoundaryVersion with key " + command.getTopologyBoundaryVersionId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected TopologyBoundaryVersion topologyBoundaryVersion = null;
    private static final Logger LOGGER = Logger.getLogger(TopologyBoundaryVersionCommandRestController.class.getName());
    
}
