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
 * Implements Spring Controller command CQRS processing for entity PssSB4.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PssSB4")
public class PssSB4CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a PssSB4.  if not key provided, calls create, otherwise calls save
     * @param		PssSB4	pssSB4
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePssSB4Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = PssSB4BusinessDelegate.getPssSB4Instance().createPssSB4( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a PssSB4.  if no key provided, calls create, otherwise calls save
     * @param		PssSB4 pssSB4
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePssSB4Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePssSB4Command
			// -----------------------------------------------
			completableFuture = PssSB4BusinessDelegate.getPssSB4Instance().updatePssSB4(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "PssSB4Controller:update() - successfully update PssSB4 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a PssSB4 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID pssSB4Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePssSB4Command command = new DeletePssSB4Command( pssSB4Id );

    	try {
        	PssSB4BusinessDelegate delegate = PssSB4BusinessDelegate.getPssSB4Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted PssSB4 with key " + command.getPssSB4Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected PssSB4 pssSB4 = null;
    private static final Logger LOGGER = Logger.getLogger(PssSB4CommandRestController.class.getName());
    
}
