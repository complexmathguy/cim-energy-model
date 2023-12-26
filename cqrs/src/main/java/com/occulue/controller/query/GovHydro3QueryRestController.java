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
 * Implements Spring Controller query CQRS processing for entity GovHydro3.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydro3")
public class GovHydro3QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a GovHydro3 using a UUID
     * @param		UUID govHydro3Id
     * @return		GovHydro3
     */    
    @GetMapping("/load")
    public GovHydro3 load( @RequestParam(required=true) UUID govHydro3Id ) {
    	GovHydro3 entity = null;

    	try {  
    		entity = GovHydro3BusinessDelegate.getGovHydro3Instance().getGovHydro3( new GovHydro3FetchOneSummary( govHydro3Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load GovHydro3 using Id " + govHydro3Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all GovHydro3 business objects
     * @return		Set<GovHydro3>
     */
    @GetMapping("/")
    public List<GovHydro3> loadAll() {                
    	List<GovHydro3> govHydro3List = null;
        
    	try {
            // load the GovHydro3
            govHydro3List = GovHydro3BusinessDelegate.getGovHydro3Instance().getAllGovHydro3();
            
            if ( govHydro3List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all GovHydro3s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all GovHydro3s ", exc );
        	return null;
        }

        return govHydro3List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected GovHydro3 govHydro3 = null;
    private static final Logger LOGGER = Logger.getLogger(GovHydro3QueryRestController.class.getName());
    
}
