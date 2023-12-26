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
 * Implements Spring Controller command CQRS processing for entity Pss2ST.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Pss2ST")
public class Pss2STCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a Pss2ST.  if not key provided, calls create, otherwise calls save
     * @param		Pss2ST	pss2ST
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePss2STCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = Pss2STBusinessDelegate.getPss2STInstance().createPss2ST( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a Pss2ST.  if no key provided, calls create, otherwise calls save
     * @param		Pss2ST pss2ST
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePss2STCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePss2STCommand
			// -----------------------------------------------
			completableFuture = Pss2STBusinessDelegate.getPss2STInstance().updatePss2ST(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "Pss2STController:update() - successfully update Pss2ST - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a Pss2ST entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID pss2STId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePss2STCommand command = new DeletePss2STCommand( pss2STId );

    	try {
        	Pss2STBusinessDelegate delegate = Pss2STBusinessDelegate.getPss2STInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted Pss2ST with key " + command.getPss2STId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected Pss2ST pss2ST = null;
    private static final Logger LOGGER = Logger.getLogger(Pss2STCommandRestController.class.getName());
    
}
