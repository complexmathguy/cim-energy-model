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
 * Implements Spring Controller query CQRS processing for entity PerLengthDCLineParameter.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PerLengthDCLineParameter")
public class PerLengthDCLineParameterQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a PerLengthDCLineParameter using a UUID
     * @param		UUID perLengthDCLineParameterId
     * @return		PerLengthDCLineParameter
     */    
    @GetMapping("/load")
    public PerLengthDCLineParameter load( @RequestParam(required=true) UUID perLengthDCLineParameterId ) {
    	PerLengthDCLineParameter entity = null;

    	try {  
    		entity = PerLengthDCLineParameterBusinessDelegate.getPerLengthDCLineParameterInstance().getPerLengthDCLineParameter( new PerLengthDCLineParameterFetchOneSummary( perLengthDCLineParameterId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load PerLengthDCLineParameter using Id " + perLengthDCLineParameterId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all PerLengthDCLineParameter business objects
     * @return		Set<PerLengthDCLineParameter>
     */
    @GetMapping("/")
    public List<PerLengthDCLineParameter> loadAll() {                
    	List<PerLengthDCLineParameter> perLengthDCLineParameterList = null;
        
    	try {
            // load the PerLengthDCLineParameter
            perLengthDCLineParameterList = PerLengthDCLineParameterBusinessDelegate.getPerLengthDCLineParameterInstance().getAllPerLengthDCLineParameter();
            
            if ( perLengthDCLineParameterList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all PerLengthDCLineParameters" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all PerLengthDCLineParameters ", exc );
        	return null;
        }

        return perLengthDCLineParameterList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected PerLengthDCLineParameter perLengthDCLineParameter = null;
    private static final Logger LOGGER = Logger.getLogger(PerLengthDCLineParameterQueryRestController.class.getName());
    
}
