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
 * Implements Spring Controller query CQRS processing for entity Area.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Area")
public class AreaQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Area using a UUID
     * @param		UUID areaId
     * @return		Area
     */    
    @GetMapping("/load")
    public Area load( @RequestParam(required=true) UUID areaId ) {
    	Area entity = null;

    	try {  
    		entity = AreaBusinessDelegate.getAreaInstance().getArea( new AreaFetchOneSummary( areaId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Area using Id " + areaId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Area business objects
     * @return		Set<Area>
     */
    @GetMapping("/")
    public List<Area> loadAll() {                
    	List<Area> areaList = null;
        
    	try {
            // load the Area
            areaList = AreaBusinessDelegate.getAreaInstance().getAllArea();
            
            if ( areaList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Areas" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Areas ", exc );
        	return null;
        }

        return areaList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Area area = null;
    private static final Logger LOGGER = Logger.getLogger(AreaQueryRestController.class.getName());
    
}
