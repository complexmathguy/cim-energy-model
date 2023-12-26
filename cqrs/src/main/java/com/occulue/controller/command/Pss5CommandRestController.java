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
 * Implements Spring Controller command CQRS processing for entity Pss5.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Pss5")
public class Pss5CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a Pss5.  if not key provided, calls create, otherwise calls save
     * @param		Pss5	pss5
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePss5Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = Pss5BusinessDelegate.getPss5Instance().createPss5( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a Pss5.  if no key provided, calls create, otherwise calls save
     * @param		Pss5 pss5
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePss5Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePss5Command
			// -----------------------------------------------
			completableFuture = Pss5BusinessDelegate.getPss5Instance().updatePss5(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "Pss5Controller:update() - successfully update Pss5 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a Pss5 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID pss5Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePss5Command command = new DeletePss5Command( pss5Id );

    	try {
        	Pss5BusinessDelegate delegate = Pss5BusinessDelegate.getPss5Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted Pss5 with key " + command.getPss5Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected Pss5 pss5 = null;
    private static final Logger LOGGER = Logger.getLogger(Pss5CommandRestController.class.getName());
    
}
