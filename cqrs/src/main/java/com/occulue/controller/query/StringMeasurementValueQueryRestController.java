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
 * Implements Spring Controller query CQRS processing for entity StringMeasurementValue.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/StringMeasurementValue")
public class StringMeasurementValueQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a StringMeasurementValue using a UUID
     * @param		UUID stringMeasurementValueId
     * @return		StringMeasurementValue
     */    
    @GetMapping("/load")
    public StringMeasurementValue load( @RequestParam(required=true) UUID stringMeasurementValueId ) {
    	StringMeasurementValue entity = null;

    	try {  
    		entity = StringMeasurementValueBusinessDelegate.getStringMeasurementValueInstance().getStringMeasurementValue( new StringMeasurementValueFetchOneSummary( stringMeasurementValueId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load StringMeasurementValue using Id " + stringMeasurementValueId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all StringMeasurementValue business objects
     * @return		Set<StringMeasurementValue>
     */
    @GetMapping("/")
    public List<StringMeasurementValue> loadAll() {                
    	List<StringMeasurementValue> stringMeasurementValueList = null;
        
    	try {
            // load the StringMeasurementValue
            stringMeasurementValueList = StringMeasurementValueBusinessDelegate.getStringMeasurementValueInstance().getAllStringMeasurementValue();
            
            if ( stringMeasurementValueList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all StringMeasurementValues" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all StringMeasurementValues ", exc );
        	return null;
        }

        return stringMeasurementValueList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected StringMeasurementValue stringMeasurementValue = null;
    private static final Logger LOGGER = Logger.getLogger(StringMeasurementValueQueryRestController.class.getName());
    
}
