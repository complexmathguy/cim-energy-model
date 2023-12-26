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
 * Implements Spring Controller command CQRS processing for entity PhaseTapChangerTable.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PhaseTapChangerTable")
public class PhaseTapChangerTableCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a PhaseTapChangerTable.  if not key provided, calls create, otherwise calls save
     * @param		PhaseTapChangerTable	phaseTapChangerTable
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreatePhaseTapChangerTableCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = PhaseTapChangerTableBusinessDelegate.getPhaseTapChangerTableInstance().createPhaseTapChangerTable( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a PhaseTapChangerTable.  if no key provided, calls create, otherwise calls save
     * @param		PhaseTapChangerTable phaseTapChangerTable
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdatePhaseTapChangerTableCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdatePhaseTapChangerTableCommand
			// -----------------------------------------------
			completableFuture = PhaseTapChangerTableBusinessDelegate.getPhaseTapChangerTableInstance().updatePhaseTapChangerTable(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "PhaseTapChangerTableController:update() - successfully update PhaseTapChangerTable - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a PhaseTapChangerTable entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID phaseTapChangerTableId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeletePhaseTapChangerTableCommand command = new DeletePhaseTapChangerTableCommand( phaseTapChangerTableId );

    	try {
        	PhaseTapChangerTableBusinessDelegate delegate = PhaseTapChangerTableBusinessDelegate.getPhaseTapChangerTableInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted PhaseTapChangerTable with key " + command.getPhaseTapChangerTableId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected PhaseTapChangerTable phaseTapChangerTable = null;
    private static final Logger LOGGER = Logger.getLogger(PhaseTapChangerTableCommandRestController.class.getName());
    
}
