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
 * Implements Spring Controller command CQRS processing for entity DiscExcContIEEEDEC3A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DiscExcContIEEEDEC3A")
public class DiscExcContIEEEDEC3ACommandRestController extends BaseSpringRestController {

    /**
     * Handles create a DiscExcContIEEEDEC3A.  if not key provided, calls create, otherwise calls save
     * @param		DiscExcContIEEEDEC3A	discExcContIEEEDEC3A
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateDiscExcContIEEEDEC3ACommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = DiscExcContIEEEDEC3ABusinessDelegate.getDiscExcContIEEEDEC3AInstance().createDiscExcContIEEEDEC3A( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a DiscExcContIEEEDEC3A.  if no key provided, calls create, otherwise calls save
     * @param		DiscExcContIEEEDEC3A discExcContIEEEDEC3A
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateDiscExcContIEEEDEC3ACommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateDiscExcContIEEEDEC3ACommand
			// -----------------------------------------------
			completableFuture = DiscExcContIEEEDEC3ABusinessDelegate.getDiscExcContIEEEDEC3AInstance().updateDiscExcContIEEEDEC3A(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "DiscExcContIEEEDEC3AController:update() - successfully update DiscExcContIEEEDEC3A - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a DiscExcContIEEEDEC3A entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID discExcContIEEEDEC3AId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteDiscExcContIEEEDEC3ACommand command = new DeleteDiscExcContIEEEDEC3ACommand( discExcContIEEEDEC3AId );

    	try {
        	DiscExcContIEEEDEC3ABusinessDelegate delegate = DiscExcContIEEEDEC3ABusinessDelegate.getDiscExcContIEEEDEC3AInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted DiscExcContIEEEDEC3A with key " + command.getDiscExcContIEEEDEC3AId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected DiscExcContIEEEDEC3A discExcContIEEEDEC3A = null;
    private static final Logger LOGGER = Logger.getLogger(DiscExcContIEEEDEC3ACommandRestController.class.getName());
    
}
