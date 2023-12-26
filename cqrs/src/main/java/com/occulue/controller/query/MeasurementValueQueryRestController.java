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
 * Implements Spring Controller query CQRS processing for entity MeasurementValue.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/MeasurementValue")
public class MeasurementValueQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a MeasurementValue using a UUID
     * @param		UUID measurementValueId
     * @return		MeasurementValue
     */    
    @GetMapping("/load")
    public MeasurementValue load( @RequestParam(required=true) UUID measurementValueId ) {
    	MeasurementValue entity = null;

    	try {  
    		entity = MeasurementValueBusinessDelegate.getMeasurementValueInstance().getMeasurementValue( new MeasurementValueFetchOneSummary( measurementValueId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load MeasurementValue using Id " + measurementValueId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all MeasurementValue business objects
     * @return		Set<MeasurementValue>
     */
    @GetMapping("/")
    public List<MeasurementValue> loadAll() {                
    	List<MeasurementValue> measurementValueList = null;
        
    	try {
            // load the MeasurementValue
            measurementValueList = MeasurementValueBusinessDelegate.getMeasurementValueInstance().getAllMeasurementValue();
            
            if ( measurementValueList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all MeasurementValues" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all MeasurementValues ", exc );
        	return null;
        }

        return measurementValueList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected MeasurementValue measurementValue = null;
    private static final Logger LOGGER = Logger.getLogger(MeasurementValueQueryRestController.class.getName());
    
}
