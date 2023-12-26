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
 * Implements Spring Controller command CQRS processing for entity DiscExcContIEEEDEC1A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DiscExcContIEEEDEC1A")
public class DiscExcContIEEEDEC1ACommandRestController extends BaseSpringRestController {

    /**
     * Handles create a DiscExcContIEEEDEC1A.  if not key provided, calls create, otherwise calls save
     * @param		DiscExcContIEEEDEC1A	discExcContIEEEDEC1A
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateDiscExcContIEEEDEC1ACommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().createDiscExcContIEEEDEC1A( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a DiscExcContIEEEDEC1A.  if no key provided, calls create, otherwise calls save
     * @param		DiscExcContIEEEDEC1A discExcContIEEEDEC1A
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateDiscExcContIEEEDEC1ACommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateDiscExcContIEEEDEC1ACommand
			// -----------------------------------------------
			completableFuture = DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().updateDiscExcContIEEEDEC1A(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "DiscExcContIEEEDEC1AController:update() - successfully update DiscExcContIEEEDEC1A - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a DiscExcContIEEEDEC1A entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID discExcContIEEEDEC1AId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteDiscExcContIEEEDEC1ACommand command = new DeleteDiscExcContIEEEDEC1ACommand( discExcContIEEEDEC1AId );

    	try {
        	DiscExcContIEEEDEC1ABusinessDelegate delegate = DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted DiscExcContIEEEDEC1A with key " + command.getDiscExcContIEEEDEC1AId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected DiscExcContIEEEDEC1A discExcContIEEEDEC1A = null;
    private static final Logger LOGGER = Logger.getLogger(DiscExcContIEEEDEC1ACommandRestController.class.getName());
    
}
