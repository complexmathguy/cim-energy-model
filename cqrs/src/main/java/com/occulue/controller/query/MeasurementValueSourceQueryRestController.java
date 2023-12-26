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
 * Implements Spring Controller query CQRS processing for entity MeasurementValueSource.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/MeasurementValueSource")
public class MeasurementValueSourceQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a MeasurementValueSource using a UUID
     * @param		UUID measurementValueSourceId
     * @return		MeasurementValueSource
     */    
    @GetMapping("/load")
    public MeasurementValueSource load( @RequestParam(required=true) UUID measurementValueSourceId ) {
    	MeasurementValueSource entity = null;

    	try {  
    		entity = MeasurementValueSourceBusinessDelegate.getMeasurementValueSourceInstance().getMeasurementValueSource( new MeasurementValueSourceFetchOneSummary( measurementValueSourceId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load MeasurementValueSource using Id " + measurementValueSourceId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all MeasurementValueSource business objects
     * @return		Set<MeasurementValueSource>
     */
    @GetMapping("/")
    public List<MeasurementValueSource> loadAll() {                
    	List<MeasurementValueSource> measurementValueSourceList = null;
        
    	try {
            // load the MeasurementValueSource
            measurementValueSourceList = MeasurementValueSourceBusinessDelegate.getMeasurementValueSourceInstance().getAllMeasurementValueSource();
            
            if ( measurementValueSourceList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all MeasurementValueSources" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all MeasurementValueSources ", exc );
        	return null;
        }

        return measurementValueSourceList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected MeasurementValueSource measurementValueSource = null;
    private static final Logger LOGGER = Logger.getLogger(MeasurementValueSourceQueryRestController.class.getName());
    
}
