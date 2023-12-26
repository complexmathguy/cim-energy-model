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
 * Implements Spring Controller query CQRS processing for entity GovCT1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovCT1")
public class GovCT1QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a GovCT1 using a UUID
     * @param		UUID govCT1Id
     * @return		GovCT1
     */    
    @GetMapping("/load")
    public GovCT1 load( @RequestParam(required=true) UUID govCT1Id ) {
    	GovCT1 entity = null;

    	try {  
    		entity = GovCT1BusinessDelegate.getGovCT1Instance().getGovCT1( new GovCT1FetchOneSummary( govCT1Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load GovCT1 using Id " + govCT1Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all GovCT1 business objects
     * @return		Set<GovCT1>
     */
    @GetMapping("/")
    public List<GovCT1> loadAll() {                
    	List<GovCT1> govCT1List = null;
        
    	try {
            // load the GovCT1
            govCT1List = GovCT1BusinessDelegate.getGovCT1Instance().getAllGovCT1();
            
            if ( govCT1List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all GovCT1s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all GovCT1s ", exc );
        	return null;
        }

        return govCT1List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected GovCT1 govCT1 = null;
    private static final Logger LOGGER = Logger.getLogger(GovCT1QueryRestController.class.getName());
    
}
