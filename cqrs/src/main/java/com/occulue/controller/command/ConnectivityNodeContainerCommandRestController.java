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
 * Implements Spring Controller command CQRS processing for entity ConnectivityNodeContainer.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ConnectivityNodeContainer")
public class ConnectivityNodeContainerCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ConnectivityNodeContainer.  if not key provided, calls create, otherwise calls save
     * @param		ConnectivityNodeContainer	connectivityNodeContainer
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateConnectivityNodeContainerCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ConnectivityNodeContainerBusinessDelegate.getConnectivityNodeContainerInstance().createConnectivityNodeContainer( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ConnectivityNodeContainer.  if no key provided, calls create, otherwise calls save
     * @param		ConnectivityNodeContainer connectivityNodeContainer
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateConnectivityNodeContainerCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateConnectivityNodeContainerCommand
			// -----------------------------------------------
			completableFuture = ConnectivityNodeContainerBusinessDelegate.getConnectivityNodeContainerInstance().updateConnectivityNodeContainer(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ConnectivityNodeContainerController:update() - successfully update ConnectivityNodeContainer - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ConnectivityNodeContainer entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID connectivityNodeContainerId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteConnectivityNodeContainerCommand command = new DeleteConnectivityNodeContainerCommand( connectivityNodeContainerId );

    	try {
        	ConnectivityNodeContainerBusinessDelegate delegate = ConnectivityNodeContainerBusinessDelegate.getConnectivityNodeContainerInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ConnectivityNodeContainer with key " + command.getConnectivityNodeContainerId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ConnectivityNodeContainer connectivityNodeContainer = null;
    private static final Logger LOGGER = Logger.getLogger(ConnectivityNodeContainerCommandRestController.class.getName());
    
}
