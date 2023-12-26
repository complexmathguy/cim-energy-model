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
 * Implements Spring Controller command CQRS processing for entity SvShuntCompensatorSections.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SvShuntCompensatorSections")
public class SvShuntCompensatorSectionsCommandRestController extends BaseSpringRestController {

    /**
     * Handles create a SvShuntCompensatorSections.  if not key provided, calls create, otherwise calls save
     * @param		SvShuntCompensatorSections	svShuntCompensatorSections
     * @return		CompletableFuture<UUID> 
     */
	@PostMapping("/create")
    public CompletableFuture<UUID> create( @RequestBody(required=true) CreateSvShuntCompensatorSectionsCommand command ) {
		CompletableFuture<UUID> completableFuture = null;
		try {       
        	
			completableFuture = SvShuntCompensatorSectionsBusinessDelegate.getSvShuntCompensatorSectionsInstance().createSvShuntCompensatorSections( command );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage(), exc );        	
        }
		
		return completableFuture;
    }

    /**
     * Handles updating a SvShuntCompensatorSections.  if no key provided, calls create, otherwise calls save
     * @param		SvShuntCompensatorSections svShuntCompensatorSections
     * @return		CompletableFuture<Void>
     */
	@PutMapping("/update")
    public CompletableFuture<Void> update( @RequestBody(required=true) UpdateSvShuntCompensatorSectionsCommand command ) {
		CompletableFuture<Void> completableFuture = null;
		try {                        	        
			// -----------------------------------------------
			// delegate the UpdateSvShuntCompensatorSectionsCommand
			// -----------------------------------------------
			completableFuture = SvShuntCompensatorSectionsBusinessDelegate.getSvShuntCompensatorSectionsInstance().updateSvShuntCompensatorSections(command);;
	    }
	    catch( Throwable exc ) {
	    	LOGGER.log( Level.WARNING, "SvShuntCompensatorSectionsController:update() - successfully update SvShuntCompensatorSections - " + exc.getMessage());        	
	    }		
		
		return completableFuture;
	}
 
    /**
     * Handles deleting a SvShuntCompensatorSections entity
     * @param		command ${class.getDeleteCommandAlias()}
     * @return		CompletableFuture<Void>
     */
    @DeleteMapping("/delete")    
    public CompletableFuture<Void> delete( @RequestParam(required=true) UUID svShuntCompensatorSectionsId  ) {
    	CompletableFuture<Void> completableFuture = null;
		DeleteSvShuntCompensatorSectionsCommand command = new DeleteSvShuntCompensatorSectionsCommand( svShuntCompensatorSectionsId );

    	try {
        	SvShuntCompensatorSectionsBusinessDelegate delegate = SvShuntCompensatorSectionsBusinessDelegate.getSvShuntCompensatorSectionsInstance();

        	completableFuture = delegate.delete( command );
    		LOGGER.log( Level.WARNING, "Successfully deleted SvShuntCompensatorSections with key " + command.getSvShuntCompensatorSectionsId() );
        }
        catch( Throwable exc ) {
        	LOGGER.log( Level.WARNING, exc.getMessage() );
        }
        
        return completableFuture;
	}        
	



//************************************************************************    
// Attributes
//************************************************************************
    protected SvShuntCompensatorSections svShuntCompensatorSections = null;
    private static final Logger LOGGER = Logger.getLogger(SvShuntCompensatorSectionsCommandRestController.class.getName());
    
}
