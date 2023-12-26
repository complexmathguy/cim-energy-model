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
 * Implements Spring Controller command CQRS processing for entity VAdjIEEE.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/VAdjIEEE")
public class VAdjIEEECommandRestController extends BaseSpringRestController {

    /**
     * Handles create a VAdjIEEE.  if not key provided, calls create, otherwise calls save
     * @param		VAdjIEEE	vAdjIEEE
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateVAdjIEEECommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = VAdjIEEEBusinessDelegate.getVAdjIEEEInstance().createVAdjIEEE( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a VAdjIEEE.  if no key provided, calls create, otherwise calls save
     * @param		VAdjIEEE vAdjIEEE
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateVAdjIEEECommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateVAdjIEEECommand
			// -----------------------------------------------
			completableFuture = VAdjIEEEBusinessDelegate.getVAdjIEEEInstance().updateVAdjIEEE(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "VAdjIEEEController:update() - successfully update VAdjIEEE - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a VAdjIEEE entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID vAdjIEEEId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteVAdjIEEECommand command = new DeleteVAdjIEEECommand( vAdjIEEEId );

    	try {
        	VAdjIEEEBusinessDelegate delegate = VAdjIEEEBusinessDelegate.getVAdjIEEEInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted VAdjIEEE with key " + command.getVAdjIEEEId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected VAdjIEEE vAdjIEEE = null;
    private static final Logger LOGGER = Logger.getLogger(VAdjIEEECommandRestController.class.getName());
    
}
