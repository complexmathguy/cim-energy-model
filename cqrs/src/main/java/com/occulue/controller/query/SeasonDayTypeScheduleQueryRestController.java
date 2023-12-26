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
 * Implements Spring Controller query CQRS processing for entity SeasonDayTypeSchedule.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SeasonDayTypeSchedule")
public class SeasonDayTypeScheduleQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a SeasonDayTypeSchedule using a UUID
     * @param		UUID seasonDayTypeScheduleId
     * @return		SeasonDayTypeSchedule
     */    
    @GetMapping("/load")
    public SeasonDayTypeSchedule load( @RequestParam(required=true) UUID seasonDayTypeScheduleId ) {
    	SeasonDayTypeSchedule entity = null;

    	try {  
    		entity = SeasonDayTypeScheduleBusinessDelegate.getSeasonDayTypeScheduleInstance().getSeasonDayTypeSchedule( new SeasonDayTypeScheduleFetchOneSummary( seasonDayTypeScheduleId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load SeasonDayTypeSchedule using Id " + seasonDayTypeScheduleId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all SeasonDayTypeSchedule business objects
     * @return		Set<SeasonDayTypeSchedule>
     */
    @GetMapping("/")
    public List<SeasonDayTypeSchedule> loadAll() {                
    	List<SeasonDayTypeSchedule> seasonDayTypeScheduleList = null;
        
    	try {
            // load the SeasonDayTypeSchedule
            seasonDayTypeScheduleList = SeasonDayTypeScheduleBusinessDelegate.getSeasonDayTypeScheduleInstance().getAllSeasonDayTypeSchedule();
            
            if ( seasonDayTypeScheduleList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all SeasonDayTypeSchedules" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all SeasonDayTypeSchedules ", exc );
        	return null;
        }

        return seasonDayTypeScheduleList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected SeasonDayTypeSchedule seasonDayTypeSchedule = null;
    private static final Logger LOGGER = Logger.getLogger(SeasonDayTypeScheduleQueryRestController.class.getName());
    
}
