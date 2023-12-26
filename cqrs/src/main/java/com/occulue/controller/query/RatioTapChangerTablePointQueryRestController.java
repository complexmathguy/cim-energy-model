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
 * Implements Spring Controller query CQRS processing for entity RatioTapChangerTablePoint.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/RatioTapChangerTablePoint")
public class RatioTapChangerTablePointQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a RatioTapChangerTablePoint using a UUID
     * @param		UUID ratioTapChangerTablePointId
     * @return		RatioTapChangerTablePoint
     */    
    @GetMapping("/load")
    public RatioTapChangerTablePoint load( @RequestParam(required=true) UUID ratioTapChangerTablePointId ) {
    	RatioTapChangerTablePoint entity = null;

    	try {  
    		entity = RatioTapChangerTablePointBusinessDelegate.getRatioTapChangerTablePointInstance().getRatioTapChangerTablePoint( new RatioTapChangerTablePointFetchOneSummary( ratioTapChangerTablePointId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load RatioTapChangerTablePoint using Id " + ratioTapChangerTablePointId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all RatioTapChangerTablePoint business objects
     * @return		Set<RatioTapChangerTablePoint>
     */
    @GetMapping("/")
    public List<RatioTapChangerTablePoint> loadAll() {                
    	List<RatioTapChangerTablePoint> ratioTapChangerTablePointList = null;
        
    	try {
            // load the RatioTapChangerTablePoint
            ratioTapChangerTablePointList = RatioTapChangerTablePointBusinessDelegate.getRatioTapChangerTablePointInstance().getAllRatioTapChangerTablePoint();
            
            if ( ratioTapChangerTablePointList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all RatioTapChangerTablePoints" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all RatioTapChangerTablePoints ", exc );
        	return null;
        }

        return ratioTapChangerTablePointList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected RatioTapChangerTablePoint ratioTapChangerTablePoint = null;
    private static final Logger LOGGER = Logger.getLogger(RatioTapChangerTablePointQueryRestController.class.getName());
    
}
