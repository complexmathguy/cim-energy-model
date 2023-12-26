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
 * Implements Spring Controller command CQRS processing for entity GovHydroPID2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydroPID2")
public class GovHydroPID2CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a GovHydroPID2.  if not key provided, calls create, otherwise calls save
     * @param		GovHydroPID2	govHydroPID2
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateGovHydroPID2Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().createGovHydroPID2( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a GovHydroPID2.  if no key provided, calls create, otherwise calls save
     * @param		GovHydroPID2 govHydroPID2
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateGovHydroPID2Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateGovHydroPID2Command
			// -----------------------------------------------
			completableFuture = GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().updateGovHydroPID2(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "GovHydroPID2Controller:update() - successfully update GovHydroPID2 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a GovHydroPID2 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID govHydroPID2Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteGovHydroPID2Command command = new DeleteGovHydroPID2Command( govHydroPID2Id );

    	try {
        	GovHydroPID2BusinessDelegate delegate = GovHydroPID2BusinessDelegate.getGovHydroPID2Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted GovHydroPID2 with key " + command.getGovHydroPID2Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected GovHydroPID2 govHydroPID2 = null;
    private static final Logger LOGGER = Logger.getLogger(GovHydroPID2CommandRestController.class.getName());
    
}
