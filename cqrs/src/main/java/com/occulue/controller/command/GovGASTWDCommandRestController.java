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
 * Implements Spring Controller command CQRS processing for entity GovGASTWD.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovGASTWD")
public class GovGASTWDCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a GovGASTWD.  if not key provided, calls create, otherwise calls save
     * @param		GovGASTWD	govGASTWD
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateGovGASTWDCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = GovGASTWDBusinessDelegate.getGovGASTWDInstance().createGovGASTWD( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a GovGASTWD.  if no key provided, calls create, otherwise calls save
     * @param		GovGASTWD govGASTWD
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateGovGASTWDCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateGovGASTWDCommand
			// -----------------------------------------------
			completableFuture = GovGASTWDBusinessDelegate.getGovGASTWDInstance().updateGovGASTWD(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "GovGASTWDController:update() - successfully update GovGASTWD - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a GovGASTWD entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID govGASTWDId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteGovGASTWDCommand command = new DeleteGovGASTWDCommand( govGASTWDId );

    	try {
        	GovGASTWDBusinessDelegate delegate = GovGASTWDBusinessDelegate.getGovGASTWDInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted GovGASTWD with key " + command.getGovGASTWDId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected GovGASTWD govGASTWD = null;
    private static final Logger LOGGER = Logger.getLogger(GovGASTWDCommandRestController.class.getName());
    
}
