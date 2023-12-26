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
 * Implements Spring Controller command CQRS processing for entity DiscExcContIEEEDEC2A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DiscExcContIEEEDEC2A")
public class DiscExcContIEEEDEC2ACommandRestController extends BaseSpringRestController {

    /**
     * Handles create a DiscExcContIEEEDEC2A.  if not key provided, calls create, otherwise calls save
     * @param		DiscExcContIEEEDEC2A	discExcContIEEEDEC2A
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateDiscExcContIEEEDEC2ACommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = DiscExcContIEEEDEC2ABusinessDelegate.getDiscExcContIEEEDEC2AInstance().createDiscExcContIEEEDEC2A( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a DiscExcContIEEEDEC2A.  if no key provided, calls create, otherwise calls save
     * @param		DiscExcContIEEEDEC2A discExcContIEEEDEC2A
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateDiscExcContIEEEDEC2ACommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateDiscExcContIEEEDEC2ACommand
			// -----------------------------------------------
			completableFuture = DiscExcContIEEEDEC2ABusinessDelegate.getDiscExcContIEEEDEC2AInstance().updateDiscExcContIEEEDEC2A(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "DiscExcContIEEEDEC2AController:update() - successfully update DiscExcContIEEEDEC2A - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a DiscExcContIEEEDEC2A entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID discExcContIEEEDEC2AId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteDiscExcContIEEEDEC2ACommand command = new DeleteDiscExcContIEEEDEC2ACommand( discExcContIEEEDEC2AId );

    	try {
        	DiscExcContIEEEDEC2ABusinessDelegate delegate = DiscExcContIEEEDEC2ABusinessDelegate.getDiscExcContIEEEDEC2AInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted DiscExcContIEEEDEC2A with key " + command.getDiscExcContIEEEDEC2AId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected DiscExcContIEEEDEC2A discExcContIEEEDEC2A = null;
    private static final Logger LOGGER = Logger.getLogger(DiscExcContIEEEDEC2ACommandRestController.class.getName());
    
}
