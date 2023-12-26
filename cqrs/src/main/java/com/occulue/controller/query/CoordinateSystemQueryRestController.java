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
 * Implements Spring Controller query CQRS processing for entity CoordinateSystem.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/CoordinateSystem")
public class CoordinateSystemQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a CoordinateSystem using a UUID
     * @param		UUID coordinateSystemId
     * @return		CoordinateSystem
     */    
    @GetMapping("/load")
    public CoordinateSystem load( @RequestParam(required=true) UUID coordinateSystemId ) {
    	CoordinateSystem entity = null;

    	try {  
    		entity = CoordinateSystemBusinessDelegate.getCoordinateSystemInstance().getCoordinateSystem( new CoordinateSystemFetchOneSummary( coordinateSystemId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load CoordinateSystem using Id " + coordinateSystemId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all CoordinateSystem business objects
     * @return		Set<CoordinateSystem>
     */
    @GetMapping("/")
    public List<CoordinateSystem> loadAll() {                
    	List<CoordinateSystem> coordinateSystemList = null;
        
    	try {
            // load the CoordinateSystem
            coordinateSystemList = CoordinateSystemBusinessDelegate.getCoordinateSystemInstance().getAllCoordinateSystem();
            
            if ( coordinateSystemList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all CoordinateSystems" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all CoordinateSystems ", exc );
        	return null;
        }

        return coordinateSystemList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected CoordinateSystem coordinateSystem = null;
    private static final Logger LOGGER = Logger.getLogger(CoordinateSystemQueryRestController.class.getName());
    
}
