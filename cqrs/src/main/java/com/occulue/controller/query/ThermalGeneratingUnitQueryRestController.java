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
 * Implements Spring Controller query CQRS processing for entity ThermalGeneratingUnit.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ThermalGeneratingUnit")
public class ThermalGeneratingUnitQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ThermalGeneratingUnit using a UUID
     * @param		UUID thermalGeneratingUnitId
     * @return		ThermalGeneratingUnit
     */    
    @GetMapping("/load")
    public ThermalGeneratingUnit load( @RequestParam(required=true) UUID thermalGeneratingUnitId ) {
    	ThermalGeneratingUnit entity = null;

    	try {  
    		entity = ThermalGeneratingUnitBusinessDelegate.getThermalGeneratingUnitInstance().getThermalGeneratingUnit( new ThermalGeneratingUnitFetchOneSummary( thermalGeneratingUnitId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ThermalGeneratingUnit using Id " + thermalGeneratingUnitId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ThermalGeneratingUnit business objects
     * @return		Set<ThermalGeneratingUnit>
     */
    @GetMapping("/")
    public List<ThermalGeneratingUnit> loadAll() {                
    	List<ThermalGeneratingUnit> thermalGeneratingUnitList = null;
        
    	try {
            // load the ThermalGeneratingUnit
            thermalGeneratingUnitList = ThermalGeneratingUnitBusinessDelegate.getThermalGeneratingUnitInstance().getAllThermalGeneratingUnit();
            
            if ( thermalGeneratingUnitList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ThermalGeneratingUnits" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ThermalGeneratingUnits ", exc );
        	return null;
        }

        return thermalGeneratingUnitList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ThermalGeneratingUnit thermalGeneratingUnit = null;
    private static final Logger LOGGER = Logger.getLogger(ThermalGeneratingUnitQueryRestController.class.getName());
    
}
