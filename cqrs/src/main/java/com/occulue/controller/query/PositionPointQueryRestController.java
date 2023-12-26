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
 * Implements Spring Controller query CQRS processing for entity PositionPoint.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PositionPoint")
public class PositionPointQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a PositionPoint using a UUID
     * @param		UUID positionPointId
     * @return		PositionPoint
     */    
    @GetMapping("/load")
    public PositionPoint load( @RequestParam(required=true) UUID positionPointId ) {
    	PositionPoint entity = null;

    	try {  
    		entity = PositionPointBusinessDelegate.getPositionPointInstance().getPositionPoint( new PositionPointFetchOneSummary( positionPointId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load PositionPoint using Id " + positionPointId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all PositionPoint business objects
     * @return		Set<PositionPoint>
     */
    @GetMapping("/")
    public List<PositionPoint> loadAll() {                
    	List<PositionPoint> positionPointList = null;
        
    	try {
            // load the PositionPoint
            positionPointList = PositionPointBusinessDelegate.getPositionPointInstance().getAllPositionPoint();
            
            if ( positionPointList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all PositionPoints" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all PositionPoints ", exc );
        	return null;
        }

        return positionPointList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected PositionPoint positionPoint = null;
    private static final Logger LOGGER = Logger.getLogger(PositionPointQueryRestController.class.getName());
    
}
