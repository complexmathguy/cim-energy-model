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
 * Implements Spring Controller query CQRS processing for entity HydroGeneratingUnit.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/HydroGeneratingUnit")
public class HydroGeneratingUnitQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a HydroGeneratingUnit using a UUID
     * @param		UUID hydroGeneratingUnitId
     * @return		HydroGeneratingUnit
     */    
    @GetMapping("/load")
    public HydroGeneratingUnit load( @RequestParam(required=true) UUID hydroGeneratingUnitId ) {
    	HydroGeneratingUnit entity = null;

    	try {  
    		entity = HydroGeneratingUnitBusinessDelegate.getHydroGeneratingUnitInstance().getHydroGeneratingUnit( new HydroGeneratingUnitFetchOneSummary( hydroGeneratingUnitId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load HydroGeneratingUnit using Id " + hydroGeneratingUnitId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all HydroGeneratingUnit business objects
     * @return		Set<HydroGeneratingUnit>
     */
    @GetMapping("/")
    public List<HydroGeneratingUnit> loadAll() {                
    	List<HydroGeneratingUnit> hydroGeneratingUnitList = null;
        
    	try {
            // load the HydroGeneratingUnit
            hydroGeneratingUnitList = HydroGeneratingUnitBusinessDelegate.getHydroGeneratingUnitInstance().getAllHydroGeneratingUnit();
            
            if ( hydroGeneratingUnitList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all HydroGeneratingUnits" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all HydroGeneratingUnits ", exc );
        	return null;
        }

        return hydroGeneratingUnitList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected HydroGeneratingUnit hydroGeneratingUnit = null;
    private static final Logger LOGGER = Logger.getLogger(HydroGeneratingUnitQueryRestController.class.getName());
    
}
