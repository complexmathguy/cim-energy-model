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
 * Implements Spring Controller command CQRS processing for entity CsConverter.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/CsConverter")
public class CsConverterCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a CsConverter.  if not key provided, calls create, otherwise calls save
     * @param		CsConverter	csConverter
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateCsConverterCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = CsConverterBusinessDelegate.getCsConverterInstance().createCsConverter( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a CsConverter.  if no key provided, calls create, otherwise calls save
     * @param		CsConverter csConverter
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateCsConverterCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateCsConverterCommand
			// -----------------------------------------------
			completableFuture = CsConverterBusinessDelegate.getCsConverterInstance().updateCsConverter(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "CsConverterController:update() - successfully update CsConverter - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a CsConverter entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID csConverterId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteCsConverterCommand command = new DeleteCsConverterCommand( csConverterId );

    	try {
        	CsConverterBusinessDelegate delegate = CsConverterBusinessDelegate.getCsConverterInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted CsConverter with key " + command.getCsConverterId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected CsConverter csConverter = null;
    private static final Logger LOGGER = Logger.getLogger(CsConverterCommandRestController.class.getName());
    
}
