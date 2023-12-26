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
 * Implements Spring Controller query CQRS processing for entity StationSupply.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/StationSupply")
public class StationSupplyQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a StationSupply using a UUID
     * @param		UUID stationSupplyId
     * @return		StationSupply
     */    
    @GetMapping("/load")
    public StationSupply load( @RequestParam(required=true) UUID stationSupplyId ) {
    	StationSupply entity = null;

    	try {  
    		entity = StationSupplyBusinessDelegate.getStationSupplyInstance().getStationSupply( new StationSupplyFetchOneSummary( stationSupplyId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load StationSupply using Id " + stationSupplyId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all StationSupply business objects
     * @return		Set<StationSupply>
     */
    @GetMapping("/")
    public List<StationSupply> loadAll() {                
    	List<StationSupply> stationSupplyList = null;
        
    	try {
            // load the StationSupply
            stationSupplyList = StationSupplyBusinessDelegate.getStationSupplyInstance().getAllStationSupply();
            
            if ( stationSupplyList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all StationSupplys" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all StationSupplys ", exc );
        	return null;
        }

        return stationSupplyList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected StationSupply stationSupply = null;
    private static final Logger LOGGER = Logger.getLogger(StationSupplyQueryRestController.class.getName());
    
}
