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
 * Implements Spring Controller query CQRS processing for entity StringMeasurement.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/StringMeasurement")
public class StringMeasurementQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a StringMeasurement using a UUID
     * @param		UUID stringMeasurementId
     * @return		StringMeasurement
     */    
    @GetMapping("/load")
    public StringMeasurement load( @RequestParam(required=true) UUID stringMeasurementId ) {
    	StringMeasurement entity = null;

    	try {  
    		entity = StringMeasurementBusinessDelegate.getStringMeasurementInstance().getStringMeasurement( new StringMeasurementFetchOneSummary( stringMeasurementId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load StringMeasurement using Id " + stringMeasurementId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all StringMeasurement business objects
     * @return		Set<StringMeasurement>
     */
    @GetMapping("/")
    public List<StringMeasurement> loadAll() {                
    	List<StringMeasurement> stringMeasurementList = null;
        
    	try {
            // load the StringMeasurement
            stringMeasurementList = StringMeasurementBusinessDelegate.getStringMeasurementInstance().getAllStringMeasurement();
            
            if ( stringMeasurementList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all StringMeasurements" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all StringMeasurements ", exc );
        	return null;
        }

        return stringMeasurementList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected StringMeasurement stringMeasurement = null;
    private static final Logger LOGGER = Logger.getLogger(StringMeasurementQueryRestController.class.getName());
    
}
