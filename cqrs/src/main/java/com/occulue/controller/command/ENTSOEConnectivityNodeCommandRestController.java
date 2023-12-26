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
 * Implements Spring Controller command CQRS processing for entity ENTSOEConnectivityNode.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ENTSOEConnectivityNode")
public class ENTSOEConnectivityNodeCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ENTSOEConnectivityNode.  if not key provided, calls create, otherwise calls save
     * @param		ENTSOEConnectivityNode	eNTSOEConnectivityNode
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateENTSOEConnectivityNodeCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ENTSOEConnectivityNodeBusinessDelegate.getENTSOEConnectivityNodeInstance().createENTSOEConnectivityNode( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ENTSOEConnectivityNode.  if no key provided, calls create, otherwise calls save
     * @param		ENTSOEConnectivityNode eNTSOEConnectivityNode
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateENTSOEConnectivityNodeCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateENTSOEConnectivityNodeCommand
			// -----------------------------------------------
			completableFuture = ENTSOEConnectivityNodeBusinessDelegate.getENTSOEConnectivityNodeInstance().updateENTSOEConnectivityNode(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ENTSOEConnectivityNodeController:update() - successfully update ENTSOEConnectivityNode - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ENTSOEConnectivityNode entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID eNTSOEConnectivityNodeId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteENTSOEConnectivityNodeCommand command = new DeleteENTSOEConnectivityNodeCommand( eNTSOEConnectivityNodeId );

    	try {
        	ENTSOEConnectivityNodeBusinessDelegate delegate = ENTSOEConnectivityNodeBusinessDelegate.getENTSOEConnectivityNodeInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ENTSOEConnectivityNode with key " + command.getENTSOEConnectivityNodeId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ENTSOEConnectivityNode eNTSOEConnectivityNode = null;
    private static final Logger LOGGER = Logger.getLogger(ENTSOEConnectivityNodeCommandRestController.class.getName());
    
}
