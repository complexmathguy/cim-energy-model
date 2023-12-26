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
 * Implements Spring Controller query CQRS processing for entity RegulationSchedule.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/RegulationSchedule")
public class RegulationScheduleQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a RegulationSchedule using a UUID
     * @param		UUID regulationScheduleId
     * @return		RegulationSchedule
     */    
    @GetMapping("/load")
    public RegulationSchedule load( @RequestParam(required=true) UUID regulationScheduleId ) {
    	RegulationSchedule entity = null;

    	try {  
    		entity = RegulationScheduleBusinessDelegate.getRegulationScheduleInstance().getRegulationSchedule( new RegulationScheduleFetchOneSummary( regulationScheduleId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load RegulationSchedule using Id " + regulationScheduleId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all RegulationSchedule business objects
     * @return		Set<RegulationSchedule>
     */
    @GetMapping("/")
    public List<RegulationSchedule> loadAll() {                
    	List<RegulationSchedule> regulationScheduleList = null;
        
    	try {
            // load the RegulationSchedule
            regulationScheduleList = RegulationScheduleBusinessDelegate.getRegulationScheduleInstance().getAllRegulationSchedule();
            
            if ( regulationScheduleList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all RegulationSchedules" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all RegulationSchedules ", exc );
        	return null;
        }

        return regulationScheduleList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected RegulationSchedule regulationSchedule = null;
    private static final Logger LOGGER = Logger.getLogger(RegulationScheduleQueryRestController.class.getName());
    
}
