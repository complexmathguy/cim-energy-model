/*******************************************************************************
  Turnstone Biologics Confidential
  
  2018 Turnstone Biologics
  All Rights Reserved.
  
  This file is subject to the terms and conditions defined in
  file 'license.txt', which is part of this source code package.
   
  Contributors :
        Turnstone Biologics - General Release
 ******************************************************************************/
package com.occulue.controller.query;

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
 * Implements Spring Controller query CQRS processing for entity BoundaryExtensions.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/BoundaryExtensions")
public class BoundaryExtensionsQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a BoundaryExtensions using a UUID
     * @param		UUID boundaryExtensionsId
     * @return		BoundaryExtensions
     */    
    @GetMapping("/load")
    public BoundaryExtensions load( @RequestParam(required=true) UUID boundaryExtensionsId ) {
    	BoundaryExtensions entity = null;

    	try {  
    		entity = BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance().getBoundaryExtensions( new BoundaryExtensionsFetchOneSummary( boundaryExtensionsId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load BoundaryExtensions using Id " + boundaryExtensionsId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all BoundaryExtensions business objects
     * @return		Set<BoundaryExtensions>
     */
    @GetMapping("/")
    public List<BoundaryExtensions> loadAll() {                
    	List<BoundaryExtensions> boundaryExtensionsList = null;
        
    	try {
            // load the BoundaryExtensions
            boundaryExtensionsList = BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance().getAllBoundaryExtensions();
            
            if ( boundaryExtensionsList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all BoundaryExtensionss" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all BoundaryExtensionss ", exc );
        	return null;
        }

        return boundaryExtensionsList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected BoundaryExtensions boundaryExtensions = null;
    private static final Logger LOGGER = Logger.getLogger(BoundaryExtensionsQueryRestController.class.getName());
    
}
