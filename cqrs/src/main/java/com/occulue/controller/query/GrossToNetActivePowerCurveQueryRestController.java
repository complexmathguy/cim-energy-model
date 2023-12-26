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
 * Implements Spring Controller query CQRS processing for entity GrossToNetActivePowerCurve.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GrossToNetActivePowerCurve")
public class GrossToNetActivePowerCurveQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a GrossToNetActivePowerCurve using a UUID
     * @param		UUID grossToNetActivePowerCurveId
     * @return		GrossToNetActivePowerCurve
     */    
    @GetMapping("/load")
    public GrossToNetActivePowerCurve load( @RequestParam(required=true) UUID grossToNetActivePowerCurveId ) {
    	GrossToNetActivePowerCurve entity = null;

    	try {  
    		entity = GrossToNetActivePowerCurveBusinessDelegate.getGrossToNetActivePowerCurveInstance().getGrossToNetActivePowerCurve( new GrossToNetActivePowerCurveFetchOneSummary( grossToNetActivePowerCurveId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load GrossToNetActivePowerCurve using Id " + grossToNetActivePowerCurveId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all GrossToNetActivePowerCurve business objects
     * @return		Set<GrossToNetActivePowerCurve>
     */
    @GetMapping("/")
    public List<GrossToNetActivePowerCurve> loadAll() {                
    	List<GrossToNetActivePowerCurve> grossToNetActivePowerCurveList = null;
        
    	try {
            // load the GrossToNetActivePowerCurve
            grossToNetActivePowerCurveList = GrossToNetActivePowerCurveBusinessDelegate.getGrossToNetActivePowerCurveInstance().getAllGrossToNetActivePowerCurve();
            
            if ( grossToNetActivePowerCurveList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all GrossToNetActivePowerCurves" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all GrossToNetActivePowerCurves ", exc );
        	return null;
        }

        return grossToNetActivePowerCurveList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected GrossToNetActivePowerCurve grossToNetActivePowerCurve = null;
    private static final Logger LOGGER = Logger.getLogger(GrossToNetActivePowerCurveQueryRestController.class.getName());
    
}
