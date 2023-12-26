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
 * Implements Spring Controller command CQRS processing for entity EquivalentBranch.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/EquivalentBranch")
public class EquivalentBranchCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a EquivalentBranch.  if not key provided, calls create, otherwise calls save
     * @param		EquivalentBranch	equivalentBranch
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateEquivalentBranchCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().createEquivalentBranch( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a EquivalentBranch.  if no key provided, calls create, otherwise calls save
     * @param		EquivalentBranch equivalentBranch
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateEquivalentBranchCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateEquivalentBranchCommand
			// -----------------------------------------------
			completableFuture = EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().updateEquivalentBranch(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "EquivalentBranchController:update() - successfully update EquivalentBranch - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a EquivalentBranch entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID equivalentBranchId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteEquivalentBranchCommand command = new DeleteEquivalentBranchCommand( equivalentBranchId );

    	try {
        	EquivalentBranchBusinessDelegate delegate = EquivalentBranchBusinessDelegate.getEquivalentBranchInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted EquivalentBranch with key " + command.getEquivalentBranchId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected EquivalentBranch equivalentBranch = null;
    private static final Logger LOGGER = Logger.getLogger(EquivalentBranchCommandRestController.class.getName());
    
}
