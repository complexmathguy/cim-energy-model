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
 * Implements Spring Controller query CQRS processing for entity BasicIntervalSchedule.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/BasicIntervalSchedule")
public class BasicIntervalScheduleQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a BasicIntervalSchedule using a UUID
     * @param		UUID basicIntervalScheduleId
     * @return		BasicIntervalSchedule
     */    
    @GetMapping("/load")
    public BasicIntervalSchedule load( @RequestParam(required=true) UUID basicIntervalScheduleId ) {
    	BasicIntervalSchedule entity = null;

    	try {  
    		entity = BasicIntervalScheduleBusinessDelegate.getBasicIntervalScheduleInstance().getBasicIntervalSchedule( new BasicIntervalScheduleFetchOneSummary( basicIntervalScheduleId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load BasicIntervalSchedule using Id " + basicIntervalScheduleId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all BasicIntervalSchedule business objects
     * @return		Set<BasicIntervalSchedule>
     */
    @GetMapping("/")
    public List<BasicIntervalSchedule> loadAll() {                
    	List<BasicIntervalSchedule> basicIntervalScheduleList = null;
        
    	try {
            // load the BasicIntervalSchedule
            basicIntervalScheduleList = BasicIntervalScheduleBusinessDelegate.getBasicIntervalScheduleInstance().getAllBasicIntervalSchedule();
            
            if ( basicIntervalScheduleList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all BasicIntervalSchedules" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all BasicIntervalSchedules ", exc );
        	return null;
        }

        return basicIntervalScheduleList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected BasicIntervalSchedule basicIntervalSchedule = null;
    private static final Logger LOGGER = Logger.getLogger(BasicIntervalScheduleQueryRestController.class.getName());
    
}
