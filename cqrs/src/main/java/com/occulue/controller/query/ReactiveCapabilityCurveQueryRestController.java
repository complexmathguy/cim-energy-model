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
 * Implements Spring Controller query CQRS processing for entity ReactiveCapabilityCurve.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ReactiveCapabilityCurve")
public class ReactiveCapabilityCurveQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ReactiveCapabilityCurve using a UUID
     * @param		UUID reactiveCapabilityCurveId
     * @return		ReactiveCapabilityCurve
     */    
    @GetMapping("/load")
    public ReactiveCapabilityCurve load( @RequestParam(required=true) UUID reactiveCapabilityCurveId ) {
    	ReactiveCapabilityCurve entity = null;

    	try {  
    		entity = ReactiveCapabilityCurveBusinessDelegate.getReactiveCapabilityCurveInstance().getReactiveCapabilityCurve( new ReactiveCapabilityCurveFetchOneSummary( reactiveCapabilityCurveId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ReactiveCapabilityCurve using Id " + reactiveCapabilityCurveId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ReactiveCapabilityCurve business objects
     * @return		Set<ReactiveCapabilityCurve>
     */
    @GetMapping("/")
    public List<ReactiveCapabilityCurve> loadAll() {                
    	List<ReactiveCapabilityCurve> reactiveCapabilityCurveList = null;
        
    	try {
            // load the ReactiveCapabilityCurve
            reactiveCapabilityCurveList = ReactiveCapabilityCurveBusinessDelegate.getReactiveCapabilityCurveInstance().getAllReactiveCapabilityCurve();
            
            if ( reactiveCapabilityCurveList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ReactiveCapabilityCurves" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ReactiveCapabilityCurves ", exc );
        	return null;
        }

        return reactiveCapabilityCurveList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ReactiveCapabilityCurve reactiveCapabilityCurve = null;
    private static final Logger LOGGER = Logger.getLogger(ReactiveCapabilityCurveQueryRestController.class.getName());
    
}
