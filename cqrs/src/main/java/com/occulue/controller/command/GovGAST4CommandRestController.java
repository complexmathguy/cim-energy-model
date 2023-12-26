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
 * Implements Spring Controller command CQRS processing for entity GovGAST4.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovGAST4")
public class GovGAST4CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a GovGAST4.  if not key provided, calls create, otherwise calls save
     * @param		GovGAST4	govGAST4
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateGovGAST4Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = GovGAST4BusinessDelegate.getGovGAST4Instance().createGovGAST4( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a GovGAST4.  if no key provided, calls create, otherwise calls save
     * @param		GovGAST4 govGAST4
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateGovGAST4Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateGovGAST4Command
			// -----------------------------------------------
			completableFuture = GovGAST4BusinessDelegate.getGovGAST4Instance().updateGovGAST4(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "GovGAST4Controller:update() - successfully update GovGAST4 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a GovGAST4 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID govGAST4Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteGovGAST4Command command = new DeleteGovGAST4Command( govGAST4Id );

    	try {
        	GovGAST4BusinessDelegate delegate = GovGAST4BusinessDelegate.getGovGAST4Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted GovGAST4 with key " + command.getGovGAST4Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected GovGAST4 govGAST4 = null;
    private static final Logger LOGGER = Logger.getLogger(GovGAST4CommandRestController.class.getName());
    
}
