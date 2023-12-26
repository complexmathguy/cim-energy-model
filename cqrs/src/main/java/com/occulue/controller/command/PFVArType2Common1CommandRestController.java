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
 * Implements Spring Controller command CQRS processing for entity PFVArType2Common1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PFVArType2Common1")
public class PFVArType2Common1CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a PFVArType2Common1.  if not key provided, calls create, otherwise calls save
     * @param		PFVArType2Common1	pFVArType2Common1
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePFVArType2Common1Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = PFVArType2Common1BusinessDelegate.getPFVArType2Common1Instance().createPFVArType2Common1( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a PFVArType2Common1.  if no key provided, calls create, otherwise calls save
     * @param		PFVArType2Common1 pFVArType2Common1
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePFVArType2Common1Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePFVArType2Common1Command
			// -----------------------------------------------
			completableFuture = PFVArType2Common1BusinessDelegate.getPFVArType2Common1Instance().updatePFVArType2Common1(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "PFVArType2Common1Controller:update() - successfully update PFVArType2Common1 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a PFVArType2Common1 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID pFVArType2Common1Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePFVArType2Common1Command command = new DeletePFVArType2Common1Command( pFVArType2Common1Id );

    	try {
        	PFVArType2Common1BusinessDelegate delegate = PFVArType2Common1BusinessDelegate.getPFVArType2Common1Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted PFVArType2Common1 with key " + command.getPFVArType2Common1Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected PFVArType2Common1 pFVArType2Common1 = null;
    private static final Logger LOGGER = Logger.getLogger(PFVArType2Common1CommandRestController.class.getName());
    
}
