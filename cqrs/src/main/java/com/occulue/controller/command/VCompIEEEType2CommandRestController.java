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
 * Implements Spring Controller command CQRS processing for entity VCompIEEEType2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/VCompIEEEType2")
public class VCompIEEEType2CommandRestController extends BaseSpringRestController {

    /**
     * Handles create a VCompIEEEType2.  if not key provided, calls create, otherwise calls save
     * @param		VCompIEEEType2	vCompIEEEType2
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateVCompIEEEType2Command command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = VCompIEEEType2BusinessDelegate.getVCompIEEEType2Instance().createVCompIEEEType2( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a VCompIEEEType2.  if no key provided, calls create, otherwise calls save
     * @param		VCompIEEEType2 vCompIEEEType2
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateVCompIEEEType2Command command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateVCompIEEEType2Command
			// -----------------------------------------------
			completableFuture = VCompIEEEType2BusinessDelegate.getVCompIEEEType2Instance().updateVCompIEEEType2(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "VCompIEEEType2Controller:update() - successfully update VCompIEEEType2 - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a VCompIEEEType2 entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID vCompIEEEType2Id  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteVCompIEEEType2Command command = new DeleteVCompIEEEType2Command( vCompIEEEType2Id );

    	try {
        	VCompIEEEType2BusinessDelegate delegate = VCompIEEEType2BusinessDelegate.getVCompIEEEType2Instance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted VCompIEEEType2 with key " + command.getVCompIEEEType2Id() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected VCompIEEEType2 vCompIEEEType2 = null;
    private static final Logger LOGGER = Logger.getLogger(VCompIEEEType2CommandRestController.class.getName());
    
}
