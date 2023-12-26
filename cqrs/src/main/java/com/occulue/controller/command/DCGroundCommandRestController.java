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
 * Implements Spring Controller command CQRS processing for entity DCGround.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCGround")
public class DCGroundCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a DCGround.  if not key provided, calls create, otherwise calls save
     * @param		DCGround	dCGround
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateDCGroundCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = DCGroundBusinessDelegate.getDCGroundInstance().createDCGround( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a DCGround.  if no key provided, calls create, otherwise calls save
     * @param		DCGround dCGround
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateDCGroundCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateDCGroundCommand
			// -----------------------------------------------
			completableFuture = DCGroundBusinessDelegate.getDCGroundInstance().updateDCGround(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "DCGroundController:update() - successfully update DCGround - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a DCGround entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID dCGroundId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteDCGroundCommand command = new DeleteDCGroundCommand( dCGroundId );

    	try {
        	DCGroundBusinessDelegate delegate = DCGroundBusinessDelegate.getDCGroundInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted DCGround with key " + command.getDCGroundId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected DCGround dCGround = null;
    private static final Logger LOGGER = Logger.getLogger(DCGroundCommandRestController.class.getName());
    
}
