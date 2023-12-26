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
 * Implements Spring Controller command CQRS processing for entity GovGAST3.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovGAST3")
public class GovGAST3CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a GovGAST3.  if not key provided, calls create, otherwise calls save
     * @param		GovGAST3	govGAST3
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateGovGAST3Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = GovGAST3BusinessDelegate.getGovGAST3Instance().createGovGAST3( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a GovGAST3.  if no key provided, calls create, otherwise calls save
     * @param		GovGAST3 govGAST3
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateGovGAST3Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateGovGAST3Command
			// -----------------------------------------------
			completableFuture = GovGAST3BusinessDelegate.getGovGAST3Instance().updateGovGAST3(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "GovGAST3Controller:update() - successfully update GovGAST3 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a GovGAST3 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID govGAST3Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteGovGAST3Command command = new DeleteGovGAST3Command( govGAST3Id );

    	try {
        	GovGAST3BusinessDelegate delegate = GovGAST3BusinessDelegate.getGovGAST3Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted GovGAST3 with key " + command.getGovGAST3Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected GovGAST3 govGAST3 = null;
    private static final Logger LOGGER = Logger.getLogger(GovGAST3CommandRestController.class.getName());
    
}
