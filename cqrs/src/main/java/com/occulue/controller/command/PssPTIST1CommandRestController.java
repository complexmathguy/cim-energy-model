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
 * Implements Spring Controller command CQRS processing for entity PssPTIST1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PssPTIST1")
public class PssPTIST1CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a PssPTIST1.  if not key provided, calls create, otherwise calls save
     * @param		PssPTIST1	pssPTIST1
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePssPTIST1Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = PssPTIST1BusinessDelegate.getPssPTIST1Instance().createPssPTIST1( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a PssPTIST1.  if no key provided, calls create, otherwise calls save
     * @param		PssPTIST1 pssPTIST1
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePssPTIST1Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePssPTIST1Command
			// -----------------------------------------------
			completableFuture = PssPTIST1BusinessDelegate.getPssPTIST1Instance().updatePssPTIST1(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "PssPTIST1Controller:update() - successfully update PssPTIST1 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a PssPTIST1 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID pssPTIST1Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePssPTIST1Command command = new DeletePssPTIST1Command( pssPTIST1Id );

    	try {
        	PssPTIST1BusinessDelegate delegate = PssPTIST1BusinessDelegate.getPssPTIST1Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted PssPTIST1 with key " + command.getPssPTIST1Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected PssPTIST1 pssPTIST1 = null;
    private static final Logger LOGGER = Logger.getLogger(PssPTIST1CommandRestController.class.getName());
    
}
