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
 * Implements Spring Controller command CQRS processing for entity OperationalLimitType.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/OperationalLimitType")
public class OperationalLimitTypeCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a OperationalLimitType.  if not key provided, calls create, otherwise calls save
     * @param		OperationalLimitType	operationalLimitType
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateOperationalLimitTypeCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = OperationalLimitTypeBusinessDelegate.getOperationalLimitTypeInstance().createOperationalLimitType( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a OperationalLimitType.  if no key provided, calls create, otherwise calls save
     * @param		OperationalLimitType operationalLimitType
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateOperationalLimitTypeCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateOperationalLimitTypeCommand
			// -----------------------------------------------
			completableFuture = OperationalLimitTypeBusinessDelegate.getOperationalLimitTypeInstance().updateOperationalLimitType(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "OperationalLimitTypeController:update() - successfully update OperationalLimitType - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a OperationalLimitType entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID operationalLimitTypeId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteOperationalLimitTypeCommand command = new DeleteOperationalLimitTypeCommand( operationalLimitTypeId );

    	try {
        	OperationalLimitTypeBusinessDelegate delegate = OperationalLimitTypeBusinessDelegate.getOperationalLimitTypeInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted OperationalLimitType with key " + command.getOperationalLimitTypeId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected OperationalLimitType operationalLimitType = null;
    private static final Logger LOGGER = Logger.getLogger(OperationalLimitTypeCommandRestController.class.getName());
    
}
