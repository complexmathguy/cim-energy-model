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
 * Implements Spring Controller query CQRS processing for entity BusNameMarker.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/BusNameMarker")
public class BusNameMarkerQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a BusNameMarker using a UUID
     * @param		UUID busNameMarkerId
     * @return		BusNameMarker
     */    
    @GetMapping("/load")
    public BusNameMarker load( @RequestParam(required=true) UUID busNameMarkerId ) {
    	BusNameMarker entity = null;

    	try {  
    		entity = BusNameMarkerBusinessDelegate.getBusNameMarkerInstance().getBusNameMarker( new BusNameMarkerFetchOneSummary( busNameMarkerId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load BusNameMarker using Id " + busNameMarkerId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all BusNameMarker business objects
     * @return		Set<BusNameMarker>
     */
    @GetMapping("/")
    public List<BusNameMarker> loadAll() {                
    	List<BusNameMarker> busNameMarkerList = null;
        
    	try {
            // load the BusNameMarker
            busNameMarkerList = BusNameMarkerBusinessDelegate.getBusNameMarkerInstance().getAllBusNameMarker();
            
            if ( busNameMarkerList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all BusNameMarkers" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all BusNameMarkers ", exc );
        	return null;
        }

        return busNameMarkerList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected BusNameMarker busNameMarker = null;
    private static final Logger LOGGER = Logger.getLogger(BusNameMarkerQueryRestController.class.getName());
    
}
