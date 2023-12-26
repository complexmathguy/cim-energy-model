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
 * Implements Spring Controller command CQRS processing for entity ENTSOEOperationalLimitType.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ENTSOEOperationalLimitType")
public class ENTSOEOperationalLimitTypeCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a ENTSOEOperationalLimitType.  if not key provided, calls create, otherwise calls save
     * @param		ENTSOEOperationalLimitType	eNTSOEOperationalLimitType
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateENTSOEOperationalLimitTypeCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = ENTSOEOperationalLimitTypeBusinessDelegate.getENTSOEOperationalLimitTypeInstance().createENTSOEOperationalLimitType( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a ENTSOEOperationalLimitType.  if no key provided, calls create, otherwise calls save
     * @param		ENTSOEOperationalLimitType eNTSOEOperationalLimitType
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateENTSOEOperationalLimitTypeCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateENTSOEOperationalLimitTypeCommand
			// -----------------------------------------------
			completableFuture = ENTSOEOperationalLimitTypeBusinessDelegate.getENTSOEOperationalLimitTypeInstance().updateENTSOEOperationalLimitType(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "ENTSOEOperationalLimitTypeController:update() - successfully update ENTSOEOperationalLimitType - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a ENTSOEOperationalLimitType entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID eNTSOEOperationalLimitTypeId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteENTSOEOperationalLimitTypeCommand command = new DeleteENTSOEOperationalLimitTypeCommand( eNTSOEOperationalLimitTypeId );

    	try {
        	ENTSOEOperationalLimitTypeBusinessDelegate delegate = ENTSOEOperationalLimitTypeBusinessDelegate.getENTSOEOperationalLimitTypeInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted ENTSOEOperationalLimitType with key " + command.getENTSOEOperationalLimitTypeId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected ENTSOEOperationalLimitType eNTSOEOperationalLimitType = null;
    private static final Logger LOGGER = Logger.getLogger(ENTSOEOperationalLimitTypeCommandRestController.class.getName());
    
}
