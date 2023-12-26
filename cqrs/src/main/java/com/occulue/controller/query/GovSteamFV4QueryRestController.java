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
 * Implements Spring Controller query CQRS processing for entity GovSteamFV4.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovSteamFV4")
public class GovSteamFV4QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a GovSteamFV4 using a UUID
     * @param		UUID govSteamFV4Id
     * @return		GovSteamFV4
     */    
    @GetMapping("/load")
    public GovSteamFV4 load( @RequestParam(required=true) UUID govSteamFV4Id ) {
    	GovSteamFV4 entity = null;

    	try {  
    		entity = GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().getGovSteamFV4( new GovSteamFV4FetchOneSummary( govSteamFV4Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load GovSteamFV4 using Id " + govSteamFV4Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all GovSteamFV4 business objects
     * @return		Set<GovSteamFV4>
     */
    @GetMapping("/")
    public List<GovSteamFV4> loadAll() {                
    	List<GovSteamFV4> govSteamFV4List = null;
        
    	try {
            // load the GovSteamFV4
            govSteamFV4List = GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().getAllGovSteamFV4();
            
            if ( govSteamFV4List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all GovSteamFV4s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all GovSteamFV4s ", exc );
        	return null;
        }

        return govSteamFV4List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected GovSteamFV4 govSteamFV4 = null;
    private static final Logger LOGGER = Logger.getLogger(GovSteamFV4QueryRestController.class.getName());
    
}
