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
 * Implements Spring Controller command CQRS processing for entity IdentifiedObject.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/IdentifiedObject")
public class IdentifiedObjectCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a IdentifiedObject.  if not key provided, calls create, otherwise calls save
     * @param		IdentifiedObject	identifiedObject
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateIdentifiedObjectCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = IdentifiedObjectBusinessDelegate.getIdentifiedObjectInstance().createIdentifiedObject( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a IdentifiedObject.  if no key provided, calls create, otherwise calls save
     * @param		IdentifiedObject identifiedObject
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateIdentifiedObjectCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateIdentifiedObjectCommand
			// -----------------------------------------------
			completableFuture = IdentifiedObjectBusinessDelegate.getIdentifiedObjectInstance().updateIdentifiedObject(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "IdentifiedObjectController:update() - successfully update IdentifiedObject - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a IdentifiedObject entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID identifiedObjectId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteIdentifiedObjectCommand command = new DeleteIdentifiedObjectCommand( identifiedObjectId );

    	try {
        	IdentifiedObjectBusinessDelegate delegate = IdentifiedObjectBusinessDelegate.getIdentifiedObjectInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted IdentifiedObject with key " + command.getIdentifiedObjectId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected IdentifiedObject identifiedObject = null;
    private static final Logger LOGGER = Logger.getLogger(IdentifiedObjectCommandRestController.class.getName());
    
}
