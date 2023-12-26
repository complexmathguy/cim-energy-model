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
 * Implements Spring Controller command CQRS processing for entity GovGAST.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovGAST")
public class GovGASTCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a GovGAST.  if not key provided, calls create, otherwise calls save
     * @param		GovGAST	govGAST
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateGovGASTCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = GovGASTBusinessDelegate.getGovGASTInstance().createGovGAST( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a GovGAST.  if no key provided, calls create, otherwise calls save
     * @param		GovGAST govGAST
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateGovGASTCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateGovGASTCommand
			// -----------------------------------------------
			completableFuture = GovGASTBusinessDelegate.getGovGASTInstance().updateGovGAST(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "GovGASTController:update() - successfully update GovGAST - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a GovGAST entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID govGASTId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteGovGASTCommand command = new DeleteGovGASTCommand( govGASTId );

    	try {
        	GovGASTBusinessDelegate delegate = GovGASTBusinessDelegate.getGovGASTInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted GovGAST with key " + command.getGovGASTId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected GovGAST govGAST = null;
    private static final Logger LOGGER = Logger.getLogger(GovGASTCommandRestController.class.getName());
    
}
