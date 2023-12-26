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
 * Implements Spring Controller command CQRS processing for entity RegulatingCondEq.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/RegulatingCondEq")
public class RegulatingCondEqCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a RegulatingCondEq.  if not key provided, calls create, otherwise calls save
     * @param		RegulatingCondEq	regulatingCondEq
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateRegulatingCondEqCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = RegulatingCondEqBusinessDelegate.getRegulatingCondEqInstance().createRegulatingCondEq( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a RegulatingCondEq.  if no key provided, calls create, otherwise calls save
     * @param		RegulatingCondEq regulatingCondEq
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateRegulatingCondEqCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateRegulatingCondEqCommand
			// -----------------------------------------------
			completableFuture = RegulatingCondEqBusinessDelegate.getRegulatingCondEqInstance().updateRegulatingCondEq(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "RegulatingCondEqController:update() - successfully update RegulatingCondEq - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a RegulatingCondEq entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID regulatingCondEqId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteRegulatingCondEqCommand command = new DeleteRegulatingCondEqCommand( regulatingCondEqId );

    	try {
        	RegulatingCondEqBusinessDelegate delegate = RegulatingCondEqBusinessDelegate.getRegulatingCondEqInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted RegulatingCondEq with key " + command.getRegulatingCondEqId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected RegulatingCondEq regulatingCondEq = null;
    private static final Logger LOGGER = Logger.getLogger(RegulatingCondEqCommandRestController.class.getName());
    
}
