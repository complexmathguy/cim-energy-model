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
 * Implements Spring Controller query CQRS processing for entity VoltageLevel.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/VoltageLevel")
public class VoltageLevelQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a VoltageLevel using a UUID
     * @param		UUID voltageLevelId
     * @return		VoltageLevel
     */    
    @GetMapping("/load")
    public VoltageLevel load( @RequestParam(required=true) UUID voltageLevelId ) {
    	VoltageLevel entity = null;

    	try {  
    		entity = VoltageLevelBusinessDelegate.getVoltageLevelInstance().getVoltageLevel( new VoltageLevelFetchOneSummary( voltageLevelId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load VoltageLevel using Id " + voltageLevelId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all VoltageLevel business objects
     * @return		Set<VoltageLevel>
     */
    @GetMapping("/")
    public List<VoltageLevel> loadAll() {                
    	List<VoltageLevel> voltageLevelList = null;
        
    	try {
            // load the VoltageLevel
            voltageLevelList = VoltageLevelBusinessDelegate.getVoltageLevelInstance().getAllVoltageLevel();
            
            if ( voltageLevelList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all VoltageLevels" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all VoltageLevels ", exc );
        	return null;
        }

        return voltageLevelList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected VoltageLevel voltageLevel = null;
    private static final Logger LOGGER = Logger.getLogger(VoltageLevelQueryRestController.class.getName());
    
}
