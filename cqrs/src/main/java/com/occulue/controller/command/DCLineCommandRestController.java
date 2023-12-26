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
 * Implements Spring Controller command CQRS processing for entity DCLine.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCLine")
public class DCLineCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a DCLine.  if not key provided, calls create, otherwise calls save
     * @param		DCLine	dCLine
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateDCLineCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = DCLineBusinessDelegate.getDCLineInstance().createDCLine( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a DCLine.  if no key provided, calls create, otherwise calls save
     * @param		DCLine dCLine
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateDCLineCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateDCLineCommand
			// -----------------------------------------------
			completableFuture = DCLineBusinessDelegate.getDCLineInstance().updateDCLine(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "DCLineController:update() - successfully update DCLine - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a DCLine entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID dCLineId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteDCLineCommand command = new DeleteDCLineCommand( dCLineId );

    	try {
        	DCLineBusinessDelegate delegate = DCLineBusinessDelegate.getDCLineInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted DCLine with key " + command.getDCLineId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected DCLine dCLine = null;
    private static final Logger LOGGER = Logger.getLogger(DCLineCommandRestController.class.getName());
    
}
