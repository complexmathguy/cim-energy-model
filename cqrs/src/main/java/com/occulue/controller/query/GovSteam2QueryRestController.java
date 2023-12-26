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
 * Implements Spring Controller query CQRS processing for entity GovSteam2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovSteam2")
public class GovSteam2QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a GovSteam2 using a UUID
     * @param		UUID govSteam2Id
     * @return		GovSteam2
     */    
    @GetMapping("/load")
    public GovSteam2 load( @RequestParam(required=true) UUID govSteam2Id ) {
    	GovSteam2 entity = null;

    	try {  
    		entity = GovSteam2BusinessDelegate.getGovSteam2Instance().getGovSteam2( new GovSteam2FetchOneSummary( govSteam2Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load GovSteam2 using Id " + govSteam2Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all GovSteam2 business objects
     * @return		Set<GovSteam2>
     */
    @GetMapping("/")
    public List<GovSteam2> loadAll() {                
    	List<GovSteam2> govSteam2List = null;
        
    	try {
            // load the GovSteam2
            govSteam2List = GovSteam2BusinessDelegate.getGovSteam2Instance().getAllGovSteam2();
            
            if ( govSteam2List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all GovSteam2s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all GovSteam2s ", exc );
        	return null;
        }

        return govSteam2List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected GovSteam2 govSteam2 = null;
    private static final Logger LOGGER = Logger.getLogger(GovSteam2QueryRestController.class.getName());
    
}
