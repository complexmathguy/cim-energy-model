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
 * Implements Spring Controller query CQRS processing for entity MeasurementValueQuality.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/MeasurementValueQuality")
public class MeasurementValueQualityQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a MeasurementValueQuality using a UUID
     * @param		UUID measurementValueQualityId
     * @return		MeasurementValueQuality
     */    
    @GetMapping("/load")
    public MeasurementValueQuality load( @RequestParam(required=true) UUID measurementValueQualityId ) {
    	MeasurementValueQuality entity = null;

    	try {  
    		entity = MeasurementValueQualityBusinessDelegate.getMeasurementValueQualityInstance().getMeasurementValueQuality( new MeasurementValueQualityFetchOneSummary( measurementValueQualityId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load MeasurementValueQuality using Id " + measurementValueQualityId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all MeasurementValueQuality business objects
     * @return		Set<MeasurementValueQuality>
     */
    @GetMapping("/")
    public List<MeasurementValueQuality> loadAll() {                
    	List<MeasurementValueQuality> measurementValueQualityList = null;
        
    	try {
            // load the MeasurementValueQuality
            measurementValueQualityList = MeasurementValueQualityBusinessDelegate.getMeasurementValueQualityInstance().getAllMeasurementValueQuality();
            
            if ( measurementValueQualityList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all MeasurementValueQualitys" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all MeasurementValueQualitys ", exc );
        	return null;
        }

        return measurementValueQualityList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected MeasurementValueQuality measurementValueQuality = null;
    private static final Logger LOGGER = Logger.getLogger(MeasurementValueQualityQueryRestController.class.getName());
    
}
