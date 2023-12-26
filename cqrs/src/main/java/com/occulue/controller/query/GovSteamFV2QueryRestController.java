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
 * Implements Spring Controller query CQRS processing for entity GovSteamFV2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovSteamFV2")
public class GovSteamFV2QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a GovSteamFV2 using a UUID
     * @param		UUID govSteamFV2Id
     * @return		GovSteamFV2
     */    
    @GetMapping("/load")
    public GovSteamFV2 load( @RequestParam(required=true) UUID govSteamFV2Id ) {
    	GovSteamFV2 entity = null;

    	try {  
    		entity = GovSteamFV2BusinessDelegate.getGovSteamFV2Instance().getGovSteamFV2( new GovSteamFV2FetchOneSummary( govSteamFV2Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load GovSteamFV2 using Id " + govSteamFV2Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all GovSteamFV2 business objects
     * @return		Set<GovSteamFV2>
     */
    @GetMapping("/")
    public List<GovSteamFV2> loadAll() {                
    	List<GovSteamFV2> govSteamFV2List = null;
        
    	try {
            // load the GovSteamFV2
            govSteamFV2List = GovSteamFV2BusinessDelegate.getGovSteamFV2Instance().getAllGovSteamFV2();
            
            if ( govSteamFV2List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all GovSteamFV2s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all GovSteamFV2s ", exc );
        	return null;
        }

        return govSteamFV2List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected GovSteamFV2 govSteamFV2 = null;
    private static final Logger LOGGER = Logger.getLogger(GovSteamFV2QueryRestController.class.getName());
    
}
