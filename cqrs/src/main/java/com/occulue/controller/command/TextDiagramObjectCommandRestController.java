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
 * Implements Spring Controller command CQRS processing for entity TextDiagramObject.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TextDiagramObject")
public class TextDiagramObjectCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a TextDiagramObject.  if not key provided, calls create, otherwise calls save
     * @param		TextDiagramObject	textDiagramObject
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateTextDiagramObjectCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = TextDiagramObjectBusinessDelegate.getTextDiagramObjectInstance().createTextDiagramObject( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a TextDiagramObject.  if no key provided, calls create, otherwise calls save
     * @param		TextDiagramObject textDiagramObject
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateTextDiagramObjectCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateTextDiagramObjectCommand
			// -----------------------------------------------
			completableFuture = TextDiagramObjectBusinessDelegate.getTextDiagramObjectInstance().updateTextDiagramObject(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "TextDiagramObjectController:update() - successfully update TextDiagramObject - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a TextDiagramObject entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID textDiagramObjectId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteTextDiagramObjectCommand command = new DeleteTextDiagramObjectCommand( textDiagramObjectId );

    	try {
        	TextDiagramObjectBusinessDelegate delegate = TextDiagramObjectBusinessDelegate.getTextDiagramObjectInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted TextDiagramObject with key " + command.getTextDiagramObjectId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected TextDiagramObject textDiagramObject = null;
    private static final Logger LOGGER = Logger.getLogger(TextDiagramObjectCommandRestController.class.getName());
    
}
