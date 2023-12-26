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
 * Implements Spring Controller command CQRS processing for entity PssELIN2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PssELIN2")
public class PssELIN2CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a PssELIN2.  if not key provided, calls create, otherwise calls save
     * @param		PssELIN2	pssELIN2
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePssELIN2Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = PssELIN2BusinessDelegate.getPssELIN2Instance().createPssELIN2( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a PssELIN2.  if no key provided, calls create, otherwise calls save
     * @param		PssELIN2 pssELIN2
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePssELIN2Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePssELIN2Command
			// -----------------------------------------------
			completableFuture = PssELIN2BusinessDelegate.getPssELIN2Instance().updatePssELIN2(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "PssELIN2Controller:update() - successfully update PssELIN2 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a PssELIN2 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID pssELIN2Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePssELIN2Command command = new DeletePssELIN2Command( pssELIN2Id );

    	try {
        	PssELIN2BusinessDelegate delegate = PssELIN2BusinessDelegate.getPssELIN2Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted PssELIN2 with key " + command.getPssELIN2Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected PssELIN2 pssELIN2 = null;
    private static final Logger LOGGER = Logger.getLogger(PssELIN2CommandRestController.class.getName());
    
}
