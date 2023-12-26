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
 * Implements Spring Controller query CQRS processing for entity GovSteamFV3.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovSteamFV3")
public class GovSteamFV3QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a GovSteamFV3 using a UUID
     * @param		UUID govSteamFV3Id
     * @return		GovSteamFV3
     */    
    @GetMapping("/load")
    public GovSteamFV3 load( @RequestParam(required=true) UUID govSteamFV3Id ) {
    	GovSteamFV3 entity = null;

    	try {  
    		entity = GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().getGovSteamFV3( new GovSteamFV3FetchOneSummary( govSteamFV3Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load GovSteamFV3 using Id " + govSteamFV3Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all GovSteamFV3 business objects
     * @return		Set<GovSteamFV3>
     */
    @GetMapping("/")
    public List<GovSteamFV3> loadAll() {                
    	List<GovSteamFV3> govSteamFV3List = null;
        
    	try {
            // load the GovSteamFV3
            govSteamFV3List = GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().getAllGovSteamFV3();
            
            if ( govSteamFV3List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all GovSteamFV3s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all GovSteamFV3s ", exc );
        	return null;
        }

        return govSteamFV3List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected GovSteamFV3 govSteamFV3 = null;
    private static final Logger LOGGER = Logger.getLogger(GovSteamFV3QueryRestController.class.getName());
    
}
