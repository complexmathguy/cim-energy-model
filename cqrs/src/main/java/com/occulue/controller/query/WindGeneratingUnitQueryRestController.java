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
 * Implements Spring Controller query CQRS processing for entity WindGeneratingUnit.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindGeneratingUnit")
public class WindGeneratingUnitQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a WindGeneratingUnit using a UUID
     * @param		UUID windGeneratingUnitId
     * @return		WindGeneratingUnit
     */    
    @GetMapping("/load")
    public WindGeneratingUnit load( @RequestParam(required=true) UUID windGeneratingUnitId ) {
    	WindGeneratingUnit entity = null;

    	try {  
    		entity = WindGeneratingUnitBusinessDelegate.getWindGeneratingUnitInstance().getWindGeneratingUnit( new WindGeneratingUnitFetchOneSummary( windGeneratingUnitId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load WindGeneratingUnit using Id " + windGeneratingUnitId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all WindGeneratingUnit business objects
     * @return		Set<WindGeneratingUnit>
     */
    @GetMapping("/")
    public List<WindGeneratingUnit> loadAll() {                
    	List<WindGeneratingUnit> windGeneratingUnitList = null;
        
    	try {
            // load the WindGeneratingUnit
            windGeneratingUnitList = WindGeneratingUnitBusinessDelegate.getWindGeneratingUnitInstance().getAllWindGeneratingUnit();
            
            if ( windGeneratingUnitList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all WindGeneratingUnits" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all WindGeneratingUnits ", exc );
        	return null;
        }

        return windGeneratingUnitList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected WindGeneratingUnit windGeneratingUnit = null;
    private static final Logger LOGGER = Logger.getLogger(WindGeneratingUnitQueryRestController.class.getName());
    
}
