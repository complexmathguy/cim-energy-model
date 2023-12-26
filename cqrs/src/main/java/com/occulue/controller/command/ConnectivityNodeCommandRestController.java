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
 * Implements Spring Controller command CQRS processing for entity ConnectivityNode.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ConnectivityNode")
public class ConnectivityNodeCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ConnectivityNode.  if not key provided, calls create, otherwise calls save
     * @param		ConnectivityNode	connectivityNode
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateConnectivityNodeCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance().createConnectivityNode( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ConnectivityNode.  if no key provided, calls create, otherwise calls save
     * @param		ConnectivityNode connectivityNode
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateConnectivityNodeCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateConnectivityNodeCommand
			// -----------------------------------------------
			completableFuture = ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance().updateConnectivityNode(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ConnectivityNodeController:update() - successfully update ConnectivityNode - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ConnectivityNode entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID connectivityNodeId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteConnectivityNodeCommand command = new DeleteConnectivityNodeCommand( connectivityNodeId );

    	try {
        	ConnectivityNodeBusinessDelegate delegate = ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ConnectivityNode with key " + command.getConnectivityNodeId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ConnectivityNode connectivityNode = null;
    private static final Logger LOGGER = Logger.getLogger(ConnectivityNodeCommandRestController.class.getName());
    
}
