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
 * Implements Spring Controller query CQRS processing for entity EnergySchedulingType.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/EnergySchedulingType")
public class EnergySchedulingTypeQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a EnergySchedulingType using a UUID
     * @param		UUID energySchedulingTypeId
     * @return		EnergySchedulingType
     */    
    @GetMapping("/load")
    public EnergySchedulingType load( @RequestParam(required=true) UUID energySchedulingTypeId ) {
    	EnergySchedulingType entity = null;

    	try {  
    		entity = EnergySchedulingTypeBusinessDelegate.getEnergySchedulingTypeInstance().getEnergySchedulingType( new EnergySchedulingTypeFetchOneSummary( energySchedulingTypeId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load EnergySchedulingType using Id " + energySchedulingTypeId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all EnergySchedulingType business objects
     * @return		Set<EnergySchedulingType>
     */
    @GetMapping("/")
    public List<EnergySchedulingType> loadAll() {                
    	List<EnergySchedulingType> energySchedulingTypeList = null;
        
    	try {
            // load the EnergySchedulingType
            energySchedulingTypeList = EnergySchedulingTypeBusinessDelegate.getEnergySchedulingTypeInstance().getAllEnergySchedulingType();
            
            if ( energySchedulingTypeList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all EnergySchedulingTypes" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all EnergySchedulingTypes ", exc );
        	return null;
        }

        return energySchedulingTypeList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected EnergySchedulingType energySchedulingType = null;
    private static final Logger LOGGER = Logger.getLogger(EnergySchedulingTypeQueryRestController.class.getName());
    
}
