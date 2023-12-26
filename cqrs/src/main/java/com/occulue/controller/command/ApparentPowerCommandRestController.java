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
 * Implements Spring Controller command CQRS processing for entity ApparentPower.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ApparentPower")
public class ApparentPowerCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ApparentPower.  if not key provided, calls create, otherwise calls save
     * @param		ApparentPower	apparentPower
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateApparentPowerCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ApparentPowerBusinessDelegate.getApparentPowerInstance().createApparentPower( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ApparentPower.  if no key provided, calls create, otherwise calls save
     * @param		ApparentPower apparentPower
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateApparentPowerCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateApparentPowerCommand
			// -----------------------------------------------
			completableFuture = ApparentPowerBusinessDelegate.getApparentPowerInstance().updateApparentPower(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ApparentPowerController:update() - successfully update ApparentPower - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ApparentPower entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID apparentPowerId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteApparentPowerCommand command = new DeleteApparentPowerCommand( apparentPowerId );

    	try {
        	ApparentPowerBusinessDelegate delegate = ApparentPowerBusinessDelegate.getApparentPowerInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ApparentPower with key " + command.getApparentPowerId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ApparentPower apparentPower = null;
    private static final Logger LOGGER = Logger.getLogger(ApparentPowerCommandRestController.class.getName());
    
}
