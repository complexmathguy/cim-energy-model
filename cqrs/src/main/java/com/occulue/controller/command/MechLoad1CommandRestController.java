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
 * Implements Spring Controller command CQRS processing for entity MechLoad1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/MechLoad1")
public class MechLoad1CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a MechLoad1.  if not key provided, calls create, otherwise calls save
     * @param		MechLoad1	mechLoad1
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateMechLoad1Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = MechLoad1BusinessDelegate.getMechLoad1Instance().createMechLoad1( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a MechLoad1.  if no key provided, calls create, otherwise calls save
     * @param		MechLoad1 mechLoad1
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateMechLoad1Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateMechLoad1Command
			// -----------------------------------------------
			completableFuture = MechLoad1BusinessDelegate.getMechLoad1Instance().updateMechLoad1(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "MechLoad1Controller:update() - successfully update MechLoad1 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a MechLoad1 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID mechLoad1Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteMechLoad1Command command = new DeleteMechLoad1Command( mechLoad1Id );

    	try {
        	MechLoad1BusinessDelegate delegate = MechLoad1BusinessDelegate.getMechLoad1Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted MechLoad1 with key " + command.getMechLoad1Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected MechLoad1 mechLoad1 = null;
    private static final Logger LOGGER = Logger.getLogger(MechLoad1CommandRestController.class.getName());
    
}
