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
 * Implements Spring Controller command CQRS processing for entity Connector.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Connector")
public class ConnectorCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a Connector.  if not key provided, calls create, otherwise calls save
     * @param		Connector	connector
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateConnectorCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ConnectorBusinessDelegate.getConnectorInstance().createConnector( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a Connector.  if no key provided, calls create, otherwise calls save
     * @param		Connector connector
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateConnectorCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateConnectorCommand
			// -----------------------------------------------
			completableFuture = ConnectorBusinessDelegate.getConnectorInstance().updateConnector(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ConnectorController:update() - successfully update Connector - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a Connector entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID connectorId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteConnectorCommand command = new DeleteConnectorCommand( connectorId );

    	try {
        	ConnectorBusinessDelegate delegate = ConnectorBusinessDelegate.getConnectorInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted Connector with key " + command.getConnectorId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected Connector connector = null;
    private static final Logger LOGGER = Logger.getLogger(ConnectorCommandRestController.class.getName());
    
}
