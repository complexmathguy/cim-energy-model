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
 * Implements Spring Controller command CQRS processing for entity GenICompensationForGenJ.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GenICompensationForGenJ")
public class GenICompensationForGenJCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a GenICompensationForGenJ.  if not key provided, calls create, otherwise calls save
     * @param		GenICompensationForGenJ	genICompensationForGenJ
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateGenICompensationForGenJCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = GenICompensationForGenJBusinessDelegate.getGenICompensationForGenJInstance().createGenICompensationForGenJ( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a GenICompensationForGenJ.  if no key provided, calls create, otherwise calls save
     * @param		GenICompensationForGenJ genICompensationForGenJ
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateGenICompensationForGenJCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateGenICompensationForGenJCommand
			// -----------------------------------------------
			completableFuture = GenICompensationForGenJBusinessDelegate.getGenICompensationForGenJInstance().updateGenICompensationForGenJ(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "GenICompensationForGenJController:update() - successfully update GenICompensationForGenJ - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a GenICompensationForGenJ entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID genICompensationForGenJId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteGenICompensationForGenJCommand command = new DeleteGenICompensationForGenJCommand( genICompensationForGenJId );

    	try {
        	GenICompensationForGenJBusinessDelegate delegate = GenICompensationForGenJBusinessDelegate.getGenICompensationForGenJInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted GenICompensationForGenJ with key " + command.getGenICompensationForGenJId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected GenICompensationForGenJ genICompensationForGenJ = null;
    private static final Logger LOGGER = Logger.getLogger(GenICompensationForGenJCommandRestController.class.getName());
    
}
