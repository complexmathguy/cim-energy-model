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
 * Implements Spring Controller command CQRS processing for entity TransformerEnd.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TransformerEnd")
public class TransformerEndCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a TransformerEnd.  if not key provided, calls create, otherwise calls save
     * @param		TransformerEnd	transformerEnd
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateTransformerEndCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = TransformerEndBusinessDelegate.getTransformerEndInstance().createTransformerEnd( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a TransformerEnd.  if no key provided, calls create, otherwise calls save
     * @param		TransformerEnd transformerEnd
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateTransformerEndCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateTransformerEndCommand
			// -----------------------------------------------
			completableFuture = TransformerEndBusinessDelegate.getTransformerEndInstance().updateTransformerEnd(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "TransformerEndController:update() - successfully update TransformerEnd - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a TransformerEnd entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID transformerEndId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteTransformerEndCommand command = new DeleteTransformerEndCommand( transformerEndId );

    	try {
        	TransformerEndBusinessDelegate delegate = TransformerEndBusinessDelegate.getTransformerEndInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted TransformerEnd with key " + command.getTransformerEndId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected TransformerEnd transformerEnd = null;
    private static final Logger LOGGER = Logger.getLogger(TransformerEndCommandRestController.class.getName());
    
}
