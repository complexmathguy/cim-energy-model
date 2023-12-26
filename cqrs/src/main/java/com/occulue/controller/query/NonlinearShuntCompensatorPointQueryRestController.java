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
 * Implements Spring Controller query CQRS processing for entity NonlinearShuntCompensatorPoint.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/NonlinearShuntCompensatorPoint")
public class NonlinearShuntCompensatorPointQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a NonlinearShuntCompensatorPoint using a UUID
     * @param		UUID nonlinearShuntCompensatorPointId
     * @return		NonlinearShuntCompensatorPoint
     */    
    @GetMapping("/load")
    public NonlinearShuntCompensatorPoint load( @RequestParam(required=true) UUID nonlinearShuntCompensatorPointId ) {
    	NonlinearShuntCompensatorPoint entity = null;

    	try {  
    		entity = NonlinearShuntCompensatorPointBusinessDelegate.getNonlinearShuntCompensatorPointInstance().getNonlinearShuntCompensatorPoint( new NonlinearShuntCompensatorPointFetchOneSummary( nonlinearShuntCompensatorPointId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load NonlinearShuntCompensatorPoint using Id " + nonlinearShuntCompensatorPointId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all NonlinearShuntCompensatorPoint business objects
     * @return		Set<NonlinearShuntCompensatorPoint>
     */
    @GetMapping("/")
    public List<NonlinearShuntCompensatorPoint> loadAll() {                
    	List<NonlinearShuntCompensatorPoint> nonlinearShuntCompensatorPointList = null;
        
    	try {
            // load the NonlinearShuntCompensatorPoint
            nonlinearShuntCompensatorPointList = NonlinearShuntCompensatorPointBusinessDelegate.getNonlinearShuntCompensatorPointInstance().getAllNonlinearShuntCompensatorPoint();
            
            if ( nonlinearShuntCompensatorPointList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all NonlinearShuntCompensatorPoints" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all NonlinearShuntCompensatorPoints ", exc );
        	return null;
        }

        return nonlinearShuntCompensatorPointList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected NonlinearShuntCompensatorPoint nonlinearShuntCompensatorPoint = null;
    private static final Logger LOGGER = Logger.getLogger(NonlinearShuntCompensatorPointQueryRestController.class.getName());
    
}
