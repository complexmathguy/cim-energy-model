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
 * Implements Spring Controller query CQRS processing for entity GovCT2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovCT2")
public class GovCT2QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a GovCT2 using a UUID
     * @param		UUID govCT2Id
     * @return		GovCT2
     */    
    @GetMapping("/load")
    public GovCT2 load( @RequestParam(required=true) UUID govCT2Id ) {
    	GovCT2 entity = null;

    	try {  
    		entity = GovCT2BusinessDelegate.getGovCT2Instance().getGovCT2( new GovCT2FetchOneSummary( govCT2Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load GovCT2 using Id " + govCT2Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all GovCT2 business objects
     * @return		Set<GovCT2>
     */
    @GetMapping("/")
    public List<GovCT2> loadAll() {                
    	List<GovCT2> govCT2List = null;
        
    	try {
            // load the GovCT2
            govCT2List = GovCT2BusinessDelegate.getGovCT2Instance().getAllGovCT2();
            
            if ( govCT2List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all GovCT2s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all GovCT2s ", exc );
        	return null;
        }

        return govCT2List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected GovCT2 govCT2 = null;
    private static final Logger LOGGER = Logger.getLogger(GovCT2QueryRestController.class.getName());
    
}
