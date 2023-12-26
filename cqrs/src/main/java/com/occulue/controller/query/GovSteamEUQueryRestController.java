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
 * Implements Spring Controller query CQRS processing for entity GovSteamEU.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovSteamEU")
public class GovSteamEUQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a GovSteamEU using a UUID
     * @param		UUID govSteamEUId
     * @return		GovSteamEU
     */    
    @GetMapping("/load")
    public GovSteamEU load( @RequestParam(required=true) UUID govSteamEUId ) {
    	GovSteamEU entity = null;

    	try {  
    		entity = GovSteamEUBusinessDelegate.getGovSteamEUInstance().getGovSteamEU( new GovSteamEUFetchOneSummary( govSteamEUId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load GovSteamEU using Id " + govSteamEUId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all GovSteamEU business objects
     * @return		Set<GovSteamEU>
     */
    @GetMapping("/")
    public List<GovSteamEU> loadAll() {                
    	List<GovSteamEU> govSteamEUList = null;
        
    	try {
            // load the GovSteamEU
            govSteamEUList = GovSteamEUBusinessDelegate.getGovSteamEUInstance().getAllGovSteamEU();
            
            if ( govSteamEUList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all GovSteamEUs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all GovSteamEUs ", exc );
        	return null;
        }

        return govSteamEUList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected GovSteamEU govSteamEU = null;
    private static final Logger LOGGER = Logger.getLogger(GovSteamEUQueryRestController.class.getName());
    
}
