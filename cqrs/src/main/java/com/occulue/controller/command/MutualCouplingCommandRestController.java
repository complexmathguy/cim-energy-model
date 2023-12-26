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
 * Implements Spring Controller command CQRS processing for entity MutualCoupling.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/MutualCoupling")
public class MutualCouplingCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a MutualCoupling.  if not key provided, calls create, otherwise calls save
     * @param		MutualCoupling	mutualCoupling
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateMutualCouplingCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = MutualCouplingBusinessDelegate.getMutualCouplingInstance().createMutualCoupling( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a MutualCoupling.  if no key provided, calls create, otherwise calls save
     * @param		MutualCoupling mutualCoupling
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateMutualCouplingCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateMutualCouplingCommand
			// -----------------------------------------------
			completableFuture = MutualCouplingBusinessDelegate.getMutualCouplingInstance().updateMutualCoupling(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "MutualCouplingController:update() - successfully update MutualCoupling - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a MutualCoupling entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID mutualCouplingId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteMutualCouplingCommand command = new DeleteMutualCouplingCommand( mutualCouplingId );

    	try {
        	MutualCouplingBusinessDelegate delegate = MutualCouplingBusinessDelegate.getMutualCouplingInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted MutualCoupling with key " + command.getMutualCouplingId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected MutualCoupling mutualCoupling = null;
    private static final Logger LOGGER = Logger.getLogger(MutualCouplingCommandRestController.class.getName());
    
}
