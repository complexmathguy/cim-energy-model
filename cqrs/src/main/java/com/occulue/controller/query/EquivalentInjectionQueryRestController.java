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
 * Implements Spring Controller query CQRS processing for entity EquivalentInjection.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/EquivalentInjection")
public class EquivalentInjectionQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a EquivalentInjection using a UUID
     * @param		UUID equivalentInjectionId
     * @return		EquivalentInjection
     */    
    @GetMapping("/load")
    public EquivalentInjection load( @RequestParam(required=true) UUID equivalentInjectionId ) {
    	EquivalentInjection entity = null;

    	try {  
    		entity = EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance().getEquivalentInjection( new EquivalentInjectionFetchOneSummary( equivalentInjectionId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load EquivalentInjection using Id " + equivalentInjectionId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all EquivalentInjection business objects
     * @return		Set<EquivalentInjection>
     */
    @GetMapping("/")
    public List<EquivalentInjection> loadAll() {                
    	List<EquivalentInjection> equivalentInjectionList = null;
        
    	try {
            // load the EquivalentInjection
            equivalentInjectionList = EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance().getAllEquivalentInjection();
            
            if ( equivalentInjectionList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all EquivalentInjections" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all EquivalentInjections ", exc );
        	return null;
        }

        return equivalentInjectionList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected EquivalentInjection equivalentInjection = null;
    private static final Logger LOGGER = Logger.getLogger(EquivalentInjectionQueryRestController.class.getName());
    
}
