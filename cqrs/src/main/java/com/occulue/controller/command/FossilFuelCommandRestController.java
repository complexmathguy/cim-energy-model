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
 * Implements Spring Controller command CQRS processing for entity FossilFuel.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/FossilFuel")
public class FossilFuelCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a FossilFuel.  if not key provided, calls create, otherwise calls save
     * @param		FossilFuel	fossilFuel
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateFossilFuelCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = FossilFuelBusinessDelegate.getFossilFuelInstance().createFossilFuel( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a FossilFuel.  if no key provided, calls create, otherwise calls save
     * @param		FossilFuel fossilFuel
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateFossilFuelCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateFossilFuelCommand
			// -----------------------------------------------
			completableFuture = FossilFuelBusinessDelegate.getFossilFuelInstance().updateFossilFuel(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "FossilFuelController:update() - successfully update FossilFuel - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a FossilFuel entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID fossilFuelId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteFossilFuelCommand command = new DeleteFossilFuelCommand( fossilFuelId );

    	try {
        	FossilFuelBusinessDelegate delegate = FossilFuelBusinessDelegate.getFossilFuelInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted FossilFuel with key " + command.getFossilFuelId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected FossilFuel fossilFuel = null;
    private static final Logger LOGGER = Logger.getLogger(FossilFuelCommandRestController.class.getName());
    
}
