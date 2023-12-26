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
 * Implements Spring Controller command CQRS processing for entity Conductance.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Conductance")
public class ConductanceCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a Conductance.  if not key provided, calls create, otherwise calls save
     * @param		Conductance	conductance
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateConductanceCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ConductanceBusinessDelegate.getConductanceInstance().createConductance( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a Conductance.  if no key provided, calls create, otherwise calls save
     * @param		Conductance conductance
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateConductanceCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateConductanceCommand
			// -----------------------------------------------
			completableFuture = ConductanceBusinessDelegate.getConductanceInstance().updateConductance(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ConductanceController:update() - successfully update Conductance - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a Conductance entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID conductanceId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteConductanceCommand command = new DeleteConductanceCommand( conductanceId );

    	try {
        	ConductanceBusinessDelegate delegate = ConductanceBusinessDelegate.getConductanceInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted Conductance with key " + command.getConductanceId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected Conductance conductance = null;
    private static final Logger LOGGER = Logger.getLogger(ConductanceCommandRestController.class.getName());
    
}
