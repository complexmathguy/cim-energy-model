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
 * Implements Spring Controller command CQRS processing for entity TopologyVersion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TopologyVersion")
public class TopologyVersionCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a TopologyVersion.  if not key provided, calls create, otherwise calls save
     * @param		TopologyVersion	topologyVersion
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateTopologyVersionCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = TopologyVersionBusinessDelegate.getTopologyVersionInstance().createTopologyVersion( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a TopologyVersion.  if no key provided, calls create, otherwise calls save
     * @param		TopologyVersion topologyVersion
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateTopologyVersionCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateTopologyVersionCommand
			// -----------------------------------------------
			completableFuture = TopologyVersionBusinessDelegate.getTopologyVersionInstance().updateTopologyVersion(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "TopologyVersionController:update() - successfully update TopologyVersion - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a TopologyVersion entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID topologyVersionId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteTopologyVersionCommand command = new DeleteTopologyVersionCommand( topologyVersionId );

    	try {
        	TopologyVersionBusinessDelegate delegate = TopologyVersionBusinessDelegate.getTopologyVersionInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted TopologyVersion with key " + command.getTopologyVersionId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected TopologyVersion topologyVersion = null;
    private static final Logger LOGGER = Logger.getLogger(TopologyVersionCommandRestController.class.getName());
    
}
