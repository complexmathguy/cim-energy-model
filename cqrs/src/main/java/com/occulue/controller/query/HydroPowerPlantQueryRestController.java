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
 * Implements Spring Controller query CQRS processing for entity HydroPowerPlant.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/HydroPowerPlant")
public class HydroPowerPlantQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a HydroPowerPlant using a UUID
     * @param		UUID hydroPowerPlantId
     * @return		HydroPowerPlant
     */    
    @GetMapping("/load")
    public HydroPowerPlant load( @RequestParam(required=true) UUID hydroPowerPlantId ) {
    	HydroPowerPlant entity = null;

    	try {  
    		entity = HydroPowerPlantBusinessDelegate.getHydroPowerPlantInstance().getHydroPowerPlant( new HydroPowerPlantFetchOneSummary( hydroPowerPlantId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load HydroPowerPlant using Id " + hydroPowerPlantId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all HydroPowerPlant business objects
     * @return		Set<HydroPowerPlant>
     */
    @GetMapping("/")
    public List<HydroPowerPlant> loadAll() {                
    	List<HydroPowerPlant> hydroPowerPlantList = null;
        
    	try {
            // load the HydroPowerPlant
            hydroPowerPlantList = HydroPowerPlantBusinessDelegate.getHydroPowerPlantInstance().getAllHydroPowerPlant();
            
            if ( hydroPowerPlantList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all HydroPowerPlants" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all HydroPowerPlants ", exc );
        	return null;
        }

        return hydroPowerPlantList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected HydroPowerPlant hydroPowerPlant = null;
    private static final Logger LOGGER = Logger.getLogger(HydroPowerPlantQueryRestController.class.getName());
    
}
