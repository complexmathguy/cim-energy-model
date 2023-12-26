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
 * Implements Spring Controller query CQRS processing for entity GovSteamIEEE1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovSteamIEEE1")
public class GovSteamIEEE1QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a GovSteamIEEE1 using a UUID
     * @param		UUID govSteamIEEE1Id
     * @return		GovSteamIEEE1
     */    
    @GetMapping("/load")
    public GovSteamIEEE1 load( @RequestParam(required=true) UUID govSteamIEEE1Id ) {
    	GovSteamIEEE1 entity = null;

    	try {  
    		entity = GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().getGovSteamIEEE1( new GovSteamIEEE1FetchOneSummary( govSteamIEEE1Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load GovSteamIEEE1 using Id " + govSteamIEEE1Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all GovSteamIEEE1 business objects
     * @return		Set<GovSteamIEEE1>
     */
    @GetMapping("/")
    public List<GovSteamIEEE1> loadAll() {                
    	List<GovSteamIEEE1> govSteamIEEE1List = null;
        
    	try {
            // load the GovSteamIEEE1
            govSteamIEEE1List = GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().getAllGovSteamIEEE1();
            
            if ( govSteamIEEE1List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all GovSteamIEEE1s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all GovSteamIEEE1s ", exc );
        	return null;
        }

        return govSteamIEEE1List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected GovSteamIEEE1 govSteamIEEE1 = null;
    private static final Logger LOGGER = Logger.getLogger(GovSteamIEEE1QueryRestController.class.getName());
    
}
