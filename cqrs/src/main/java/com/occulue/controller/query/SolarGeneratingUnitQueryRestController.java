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
 * Implements Spring Controller query CQRS processing for entity SolarGeneratingUnit.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SolarGeneratingUnit")
public class SolarGeneratingUnitQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a SolarGeneratingUnit using a UUID
     * @param		UUID solarGeneratingUnitId
     * @return		SolarGeneratingUnit
     */    
    @GetMapping("/load")
    public SolarGeneratingUnit load( @RequestParam(required=true) UUID solarGeneratingUnitId ) {
    	SolarGeneratingUnit entity = null;

    	try {  
    		entity = SolarGeneratingUnitBusinessDelegate.getSolarGeneratingUnitInstance().getSolarGeneratingUnit( new SolarGeneratingUnitFetchOneSummary( solarGeneratingUnitId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load SolarGeneratingUnit using Id " + solarGeneratingUnitId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all SolarGeneratingUnit business objects
     * @return		Set<SolarGeneratingUnit>
     */
    @GetMapping("/")
    public List<SolarGeneratingUnit> loadAll() {                
    	List<SolarGeneratingUnit> solarGeneratingUnitList = null;
        
    	try {
            // load the SolarGeneratingUnit
            solarGeneratingUnitList = SolarGeneratingUnitBusinessDelegate.getSolarGeneratingUnitInstance().getAllSolarGeneratingUnit();
            
            if ( solarGeneratingUnitList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all SolarGeneratingUnits" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all SolarGeneratingUnits ", exc );
        	return null;
        }

        return solarGeneratingUnitList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected SolarGeneratingUnit solarGeneratingUnit = null;
    private static final Logger LOGGER = Logger.getLogger(SolarGeneratingUnitQueryRestController.class.getName());
    
}
