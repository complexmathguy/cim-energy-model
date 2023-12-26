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
 * Implements Spring Controller query CQRS processing for entity GovHydroIEEE2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydroIEEE2")
public class GovHydroIEEE2QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a GovHydroIEEE2 using a UUID
     * @param		UUID govHydroIEEE2Id
     * @return		GovHydroIEEE2
     */    
    @GetMapping("/load")
    public GovHydroIEEE2 load( @RequestParam(required=true) UUID govHydroIEEE2Id ) {
    	GovHydroIEEE2 entity = null;

    	try {  
    		entity = GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().getGovHydroIEEE2( new GovHydroIEEE2FetchOneSummary( govHydroIEEE2Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load GovHydroIEEE2 using Id " + govHydroIEEE2Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all GovHydroIEEE2 business objects
     * @return		Set<GovHydroIEEE2>
     */
    @GetMapping("/")
    public List<GovHydroIEEE2> loadAll() {                
    	List<GovHydroIEEE2> govHydroIEEE2List = null;
        
    	try {
            // load the GovHydroIEEE2
            govHydroIEEE2List = GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().getAllGovHydroIEEE2();
            
            if ( govHydroIEEE2List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all GovHydroIEEE2s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all GovHydroIEEE2s ", exc );
        	return null;
        }

        return govHydroIEEE2List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected GovHydroIEEE2 govHydroIEEE2 = null;
    private static final Logger LOGGER = Logger.getLogger(GovHydroIEEE2QueryRestController.class.getName());
    
}
