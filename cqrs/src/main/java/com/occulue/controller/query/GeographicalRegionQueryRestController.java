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
 * Implements Spring Controller query CQRS processing for entity GeographicalRegion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GeographicalRegion")
public class GeographicalRegionQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a GeographicalRegion using a UUID
     * @param		UUID geographicalRegionId
     * @return		GeographicalRegion
     */    
    @GetMapping("/load")
    public GeographicalRegion load( @RequestParam(required=true) UUID geographicalRegionId ) {
    	GeographicalRegion entity = null;

    	try {  
    		entity = GeographicalRegionBusinessDelegate.getGeographicalRegionInstance().getGeographicalRegion( new GeographicalRegionFetchOneSummary( geographicalRegionId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load GeographicalRegion using Id " + geographicalRegionId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all GeographicalRegion business objects
     * @return		Set<GeographicalRegion>
     */
    @GetMapping("/")
    public List<GeographicalRegion> loadAll() {                
    	List<GeographicalRegion> geographicalRegionList = null;
        
    	try {
            // load the GeographicalRegion
            geographicalRegionList = GeographicalRegionBusinessDelegate.getGeographicalRegionInstance().getAllGeographicalRegion();
            
            if ( geographicalRegionList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all GeographicalRegions" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all GeographicalRegions ", exc );
        	return null;
        }

        return geographicalRegionList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected GeographicalRegion geographicalRegion = null;
    private static final Logger LOGGER = Logger.getLogger(GeographicalRegionQueryRestController.class.getName());
    
}
