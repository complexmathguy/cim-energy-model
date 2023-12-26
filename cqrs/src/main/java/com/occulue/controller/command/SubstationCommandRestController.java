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
 * Implements Spring Controller command CQRS processing for entity Substation.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Substation")
public class SubstationCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a Substation.  if not key provided, calls create, otherwise calls save
     * @param		Substation	substation
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateSubstationCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = SubstationBusinessDelegate.getSubstationInstance().createSubstation( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a Substation.  if no key provided, calls create, otherwise calls save
     * @param		Substation substation
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateSubstationCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateSubstationCommand
			// -----------------------------------------------
			completableFuture = SubstationBusinessDelegate.getSubstationInstance().updateSubstation(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "SubstationController:update() - successfully update Substation - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a Substation entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID substationId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteSubstationCommand command = new DeleteSubstationCommand( substationId );

    	try {
        	SubstationBusinessDelegate delegate = SubstationBusinessDelegate.getSubstationInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted Substation with key " + command.getSubstationId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected Substation substation = null;
    private static final Logger LOGGER = Logger.getLogger(SubstationCommandRestController.class.getName());
    
}
