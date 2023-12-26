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
 * Implements Spring Controller command CQRS processing for entity GovHydroPelton.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydroPelton")
public class GovHydroPeltonCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a GovHydroPelton.  if not key provided, calls create, otherwise calls save
     * @param		GovHydroPelton	govHydroPelton
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateGovHydroPeltonCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().createGovHydroPelton( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a GovHydroPelton.  if no key provided, calls create, otherwise calls save
     * @param		GovHydroPelton govHydroPelton
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateGovHydroPeltonCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateGovHydroPeltonCommand
			// -----------------------------------------------
			completableFuture = GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().updateGovHydroPelton(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "GovHydroPeltonController:update() - successfully update GovHydroPelton - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a GovHydroPelton entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID govHydroPeltonId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteGovHydroPeltonCommand command = new DeleteGovHydroPeltonCommand( govHydroPeltonId );

    	try {
        	GovHydroPeltonBusinessDelegate delegate = GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted GovHydroPelton with key " + command.getGovHydroPeltonId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected GovHydroPelton govHydroPelton = null;
    private static final Logger LOGGER = Logger.getLogger(GovHydroPeltonCommandRestController.class.getName());
    
}
