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
 * Implements Spring Controller command CQRS processing for entity PFVArControllerType2UserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PFVArControllerType2UserDefined")
public class PFVArControllerType2UserDefinedCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a PFVArControllerType2UserDefined.  if not key provided, calls create, otherwise calls save
     * @param		PFVArControllerType2UserDefined	pFVArControllerType2UserDefined
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePFVArControllerType2UserDefinedCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = PFVArControllerType2UserDefinedBusinessDelegate.getPFVArControllerType2UserDefinedInstance().createPFVArControllerType2UserDefined( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a PFVArControllerType2UserDefined.  if no key provided, calls create, otherwise calls save
     * @param		PFVArControllerType2UserDefined pFVArControllerType2UserDefined
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePFVArControllerType2UserDefinedCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePFVArControllerType2UserDefinedCommand
			// -----------------------------------------------
			completableFuture = PFVArControllerType2UserDefinedBusinessDelegate.getPFVArControllerType2UserDefinedInstance().updatePFVArControllerType2UserDefined(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "PFVArControllerType2UserDefinedController:update() - successfully update PFVArControllerType2UserDefined - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a PFVArControllerType2UserDefined entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID pFVArControllerType2UserDefinedId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePFVArControllerType2UserDefinedCommand command = new DeletePFVArControllerType2UserDefinedCommand( pFVArControllerType2UserDefinedId );

    	try {
        	PFVArControllerType2UserDefinedBusinessDelegate delegate = PFVArControllerType2UserDefinedBusinessDelegate.getPFVArControllerType2UserDefinedInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted PFVArControllerType2UserDefined with key " + command.getPFVArControllerType2UserDefinedId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected PFVArControllerType2UserDefined pFVArControllerType2UserDefined = null;
    private static final Logger LOGGER = Logger.getLogger(PFVArControllerType2UserDefinedCommandRestController.class.getName());
    
}
