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
 * Implements Spring Controller query CQRS processing for entity GovHydro4.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydro4")
public class GovHydro4QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a GovHydro4 using a UUID
     * @param		UUID govHydro4Id
     * @return		GovHydro4
     */    
    @GetMapping("/load")
    public GovHydro4 load( @RequestParam(required=true) UUID govHydro4Id ) {
    	GovHydro4 entity = null;

    	try {  
    		entity = GovHydro4BusinessDelegate.getGovHydro4Instance().getGovHydro4( new GovHydro4FetchOneSummary( govHydro4Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load GovHydro4 using Id " + govHydro4Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all GovHydro4 business objects
     * @return		Set<GovHydro4>
     */
    @GetMapping("/")
    public List<GovHydro4> loadAll() {                
    	List<GovHydro4> govHydro4List = null;
        
    	try {
            // load the GovHydro4
            govHydro4List = GovHydro4BusinessDelegate.getGovHydro4Instance().getAllGovHydro4();
            
            if ( govHydro4List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all GovHydro4s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all GovHydro4s ", exc );
        	return null;
        }

        return govHydro4List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected GovHydro4 govHydro4 = null;
    private static final Logger LOGGER = Logger.getLogger(GovHydro4QueryRestController.class.getName());
    
}
