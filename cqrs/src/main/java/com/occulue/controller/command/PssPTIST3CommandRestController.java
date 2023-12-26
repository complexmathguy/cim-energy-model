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
 * Implements Spring Controller command CQRS processing for entity PssPTIST3.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PssPTIST3")
public class PssPTIST3CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a PssPTIST3.  if not key provided, calls create, otherwise calls save
     * @param		PssPTIST3	pssPTIST3
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePssPTIST3Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = PssPTIST3BusinessDelegate.getPssPTIST3Instance().createPssPTIST3( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a PssPTIST3.  if no key provided, calls create, otherwise calls save
     * @param		PssPTIST3 pssPTIST3
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePssPTIST3Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePssPTIST3Command
			// -----------------------------------------------
			completableFuture = PssPTIST3BusinessDelegate.getPssPTIST3Instance().updatePssPTIST3(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "PssPTIST3Controller:update() - successfully update PssPTIST3 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a PssPTIST3 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID pssPTIST3Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePssPTIST3Command command = new DeletePssPTIST3Command( pssPTIST3Id );

    	try {
        	PssPTIST3BusinessDelegate delegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted PssPTIST3 with key " + command.getPssPTIST3Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected PssPTIST3 pssPTIST3 = null;
    private static final Logger LOGGER = Logger.getLogger(PssPTIST3CommandRestController.class.getName());
    
}
