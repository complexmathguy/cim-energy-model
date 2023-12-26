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
 * Implements Spring Controller query CQRS processing for entity Curve.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Curve")
public class CurveQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Curve using a UUID
     * @param		UUID curveId
     * @return		Curve
     */    
    @GetMapping("/load")
    public Curve load( @RequestParam(required=true) UUID curveId ) {
    	Curve entity = null;

    	try {  
    		entity = CurveBusinessDelegate.getCurveInstance().getCurve( new CurveFetchOneSummary( curveId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Curve using Id " + curveId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Curve business objects
     * @return		Set<Curve>
     */
    @GetMapping("/")
    public List<Curve> loadAll() {                
    	List<Curve> curveList = null;
        
    	try {
            // load the Curve
            curveList = CurveBusinessDelegate.getCurveInstance().getAllCurve();
            
            if ( curveList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Curves" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Curves ", exc );
        	return null;
        }

        return curveList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Curve curve = null;
    private static final Logger LOGGER = Logger.getLogger(CurveQueryRestController.class.getName());
    
}
