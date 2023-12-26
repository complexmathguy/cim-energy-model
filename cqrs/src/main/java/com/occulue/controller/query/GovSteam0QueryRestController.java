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
 * Implements Spring Controller query CQRS processing for entity GovSteam0.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovSteam0")
public class GovSteam0QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a GovSteam0 using a UUID
     * @param		UUID govSteam0Id
     * @return		GovSteam0
     */    
    @GetMapping("/load")
    public GovSteam0 load( @RequestParam(required=true) UUID govSteam0Id ) {
    	GovSteam0 entity = null;

    	try {  
    		entity = GovSteam0BusinessDelegate.getGovSteam0Instance().getGovSteam0( new GovSteam0FetchOneSummary( govSteam0Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load GovSteam0 using Id " + govSteam0Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all GovSteam0 business objects
     * @return		Set<GovSteam0>
     */
    @GetMapping("/")
    public List<GovSteam0> loadAll() {                
    	List<GovSteam0> govSteam0List = null;
        
    	try {
            // load the GovSteam0
            govSteam0List = GovSteam0BusinessDelegate.getGovSteam0Instance().getAllGovSteam0();
            
            if ( govSteam0List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all GovSteam0s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all GovSteam0s ", exc );
        	return null;
        }

        return govSteam0List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected GovSteam0 govSteam0 = null;
    private static final Logger LOGGER = Logger.getLogger(GovSteam0QueryRestController.class.getName());
    
}
