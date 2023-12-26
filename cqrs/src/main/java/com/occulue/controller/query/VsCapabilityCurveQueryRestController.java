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
 * Implements Spring Controller query CQRS processing for entity VsCapabilityCurve.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/VsCapabilityCurve")
public class VsCapabilityCurveQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a VsCapabilityCurve using a UUID
     * @param		UUID vsCapabilityCurveId
     * @return		VsCapabilityCurve
     */    
    @GetMapping("/load")
    public VsCapabilityCurve load( @RequestParam(required=true) UUID vsCapabilityCurveId ) {
    	VsCapabilityCurve entity = null;

    	try {  
    		entity = VsCapabilityCurveBusinessDelegate.getVsCapabilityCurveInstance().getVsCapabilityCurve( new VsCapabilityCurveFetchOneSummary( vsCapabilityCurveId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load VsCapabilityCurve using Id " + vsCapabilityCurveId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all VsCapabilityCurve business objects
     * @return		Set<VsCapabilityCurve>
     */
    @GetMapping("/")
    public List<VsCapabilityCurve> loadAll() {                
    	List<VsCapabilityCurve> vsCapabilityCurveList = null;
        
    	try {
            // load the VsCapabilityCurve
            vsCapabilityCurveList = VsCapabilityCurveBusinessDelegate.getVsCapabilityCurveInstance().getAllVsCapabilityCurve();
            
            if ( vsCapabilityCurveList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all VsCapabilityCurves" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all VsCapabilityCurves ", exc );
        	return null;
        }

        return vsCapabilityCurveList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected VsCapabilityCurve vsCapabilityCurve = null;
    private static final Logger LOGGER = Logger.getLogger(VsCapabilityCurveQueryRestController.class.getName());
    
}
