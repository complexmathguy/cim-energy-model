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
 * Implements Spring Controller query CQRS processing for entity GovSteamCC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovSteamCC")
public class GovSteamCCQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a GovSteamCC using a UUID
     * @param		UUID govSteamCCId
     * @return		GovSteamCC
     */    
    @GetMapping("/load")
    public GovSteamCC load( @RequestParam(required=true) UUID govSteamCCId ) {
    	GovSteamCC entity = null;

    	try {  
    		entity = GovSteamCCBusinessDelegate.getGovSteamCCInstance().getGovSteamCC( new GovSteamCCFetchOneSummary( govSteamCCId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load GovSteamCC using Id " + govSteamCCId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all GovSteamCC business objects
     * @return		Set<GovSteamCC>
     */
    @GetMapping("/")
    public List<GovSteamCC> loadAll() {                
    	List<GovSteamCC> govSteamCCList = null;
        
    	try {
            // load the GovSteamCC
            govSteamCCList = GovSteamCCBusinessDelegate.getGovSteamCCInstance().getAllGovSteamCC();
            
            if ( govSteamCCList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all GovSteamCCs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all GovSteamCCs ", exc );
        	return null;
        }

        return govSteamCCList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected GovSteamCC govSteamCC = null;
    private static final Logger LOGGER = Logger.getLogger(GovSteamCCQueryRestController.class.getName());
    
}
