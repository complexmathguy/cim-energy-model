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
 * Implements Spring Controller query CQRS processing for entity Location.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Location")
public class LocationQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Location using a UUID
     * @param		UUID locationId
     * @return		Location
     */    
    @GetMapping("/load")
    public Location load( @RequestParam(required=true) UUID locationId ) {
    	Location entity = null;

    	try {  
    		entity = LocationBusinessDelegate.getLocationInstance().getLocation( new LocationFetchOneSummary( locationId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Location using Id " + locationId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Location business objects
     * @return		Set<Location>
     */
    @GetMapping("/")
    public List<Location> loadAll() {                
    	List<Location> locationList = null;
        
    	try {
            // load the Location
            locationList = LocationBusinessDelegate.getLocationInstance().getAllLocation();
            
            if ( locationList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Locations" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Locations ", exc );
        	return null;
        }

        return locationList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Location location = null;
    private static final Logger LOGGER = Logger.getLogger(LocationQueryRestController.class.getName());
    
}
