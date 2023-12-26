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
 * Implements Spring Controller query CQRS processing for entity GovHydroWPID.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydroWPID")
public class GovHydroWPIDQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a GovHydroWPID using a UUID
     * @param		UUID govHydroWPIDId
     * @return		GovHydroWPID
     */    
    @GetMapping("/load")
    public GovHydroWPID load( @RequestParam(required=true) UUID govHydroWPIDId ) {
    	GovHydroWPID entity = null;

    	try {  
    		entity = GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().getGovHydroWPID( new GovHydroWPIDFetchOneSummary( govHydroWPIDId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load GovHydroWPID using Id " + govHydroWPIDId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all GovHydroWPID business objects
     * @return		Set<GovHydroWPID>
     */
    @GetMapping("/")
    public List<GovHydroWPID> loadAll() {                
    	List<GovHydroWPID> govHydroWPIDList = null;
        
    	try {
            // load the GovHydroWPID
            govHydroWPIDList = GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().getAllGovHydroWPID();
            
            if ( govHydroWPIDList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all GovHydroWPIDs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all GovHydroWPIDs ", exc );
        	return null;
        }

        return govHydroWPIDList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected GovHydroWPID govHydroWPID = null;
    private static final Logger LOGGER = Logger.getLogger(GovHydroWPIDQueryRestController.class.getName());
    
}
