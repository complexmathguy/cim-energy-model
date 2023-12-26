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
 * Implements Spring Controller query CQRS processing for entity GovHydroWEH.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydroWEH")
public class GovHydroWEHQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a GovHydroWEH using a UUID
     * @param		UUID govHydroWEHId
     * @return		GovHydroWEH
     */    
    @GetMapping("/load")
    public GovHydroWEH load( @RequestParam(required=true) UUID govHydroWEHId ) {
    	GovHydroWEH entity = null;

    	try {  
    		entity = GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().getGovHydroWEH( new GovHydroWEHFetchOneSummary( govHydroWEHId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load GovHydroWEH using Id " + govHydroWEHId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all GovHydroWEH business objects
     * @return		Set<GovHydroWEH>
     */
    @GetMapping("/")
    public List<GovHydroWEH> loadAll() {                
    	List<GovHydroWEH> govHydroWEHList = null;
        
    	try {
            // load the GovHydroWEH
            govHydroWEHList = GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().getAllGovHydroWEH();
            
            if ( govHydroWEHList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all GovHydroWEHs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all GovHydroWEHs ", exc );
        	return null;
        }

        return govHydroWEHList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected GovHydroWEH govHydroWEH = null;
    private static final Logger LOGGER = Logger.getLogger(GovHydroWEHQueryRestController.class.getName());
    
}
