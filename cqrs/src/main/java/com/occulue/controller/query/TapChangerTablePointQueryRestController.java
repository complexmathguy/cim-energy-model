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
 * Implements Spring Controller query CQRS processing for entity TapChangerTablePoint.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TapChangerTablePoint")
public class TapChangerTablePointQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a TapChangerTablePoint using a UUID
     * @param		UUID tapChangerTablePointId
     * @return		TapChangerTablePoint
     */    
    @GetMapping("/load")
    public TapChangerTablePoint load( @RequestParam(required=true) UUID tapChangerTablePointId ) {
    	TapChangerTablePoint entity = null;

    	try {  
    		entity = TapChangerTablePointBusinessDelegate.getTapChangerTablePointInstance().getTapChangerTablePoint( new TapChangerTablePointFetchOneSummary( tapChangerTablePointId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load TapChangerTablePoint using Id " + tapChangerTablePointId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all TapChangerTablePoint business objects
     * @return		Set<TapChangerTablePoint>
     */
    @GetMapping("/")
    public List<TapChangerTablePoint> loadAll() {                
    	List<TapChangerTablePoint> tapChangerTablePointList = null;
        
    	try {
            // load the TapChangerTablePoint
            tapChangerTablePointList = TapChangerTablePointBusinessDelegate.getTapChangerTablePointInstance().getAllTapChangerTablePoint();
            
            if ( tapChangerTablePointList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all TapChangerTablePoints" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all TapChangerTablePoints ", exc );
        	return null;
        }

        return tapChangerTablePointList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected TapChangerTablePoint tapChangerTablePoint = null;
    private static final Logger LOGGER = Logger.getLogger(TapChangerTablePointQueryRestController.class.getName());
    
}
