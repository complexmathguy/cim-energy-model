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
 * Implements Spring Controller query CQRS processing for entity RegularIntervalSchedule.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/RegularIntervalSchedule")
public class RegularIntervalScheduleQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a RegularIntervalSchedule using a UUID
     * @param		UUID regularIntervalScheduleId
     * @return		RegularIntervalSchedule
     */    
    @GetMapping("/load")
    public RegularIntervalSchedule load( @RequestParam(required=true) UUID regularIntervalScheduleId ) {
    	RegularIntervalSchedule entity = null;

    	try {  
    		entity = RegularIntervalScheduleBusinessDelegate.getRegularIntervalScheduleInstance().getRegularIntervalSchedule( new RegularIntervalScheduleFetchOneSummary( regularIntervalScheduleId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load RegularIntervalSchedule using Id " + regularIntervalScheduleId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all RegularIntervalSchedule business objects
     * @return		Set<RegularIntervalSchedule>
     */
    @GetMapping("/")
    public List<RegularIntervalSchedule> loadAll() {                
    	List<RegularIntervalSchedule> regularIntervalScheduleList = null;
        
    	try {
            // load the RegularIntervalSchedule
            regularIntervalScheduleList = RegularIntervalScheduleBusinessDelegate.getRegularIntervalScheduleInstance().getAllRegularIntervalSchedule();
            
            if ( regularIntervalScheduleList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all RegularIntervalSchedules" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all RegularIntervalSchedules ", exc );
        	return null;
        }

        return regularIntervalScheduleList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected RegularIntervalSchedule regularIntervalSchedule = null;
    private static final Logger LOGGER = Logger.getLogger(RegularIntervalScheduleQueryRestController.class.getName());
    
}
