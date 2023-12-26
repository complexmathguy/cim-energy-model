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
 * Implements Spring Controller query CQRS processing for entity NonConformLoadSchedule.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/NonConformLoadSchedule")
public class NonConformLoadScheduleQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a NonConformLoadSchedule using a UUID
     * @param		UUID nonConformLoadScheduleId
     * @return		NonConformLoadSchedule
     */    
    @GetMapping("/load")
    public NonConformLoadSchedule load( @RequestParam(required=true) UUID nonConformLoadScheduleId ) {
    	NonConformLoadSchedule entity = null;

    	try {  
    		entity = NonConformLoadScheduleBusinessDelegate.getNonConformLoadScheduleInstance().getNonConformLoadSchedule( new NonConformLoadScheduleFetchOneSummary( nonConformLoadScheduleId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load NonConformLoadSchedule using Id " + nonConformLoadScheduleId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all NonConformLoadSchedule business objects
     * @return		Set<NonConformLoadSchedule>
     */
    @GetMapping("/")
    public List<NonConformLoadSchedule> loadAll() {                
    	List<NonConformLoadSchedule> nonConformLoadScheduleList = null;
        
    	try {
            // load the NonConformLoadSchedule
            nonConformLoadScheduleList = NonConformLoadScheduleBusinessDelegate.getNonConformLoadScheduleInstance().getAllNonConformLoadSchedule();
            
            if ( nonConformLoadScheduleList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all NonConformLoadSchedules" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all NonConformLoadSchedules ", exc );
        	return null;
        }

        return nonConformLoadScheduleList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected NonConformLoadSchedule nonConformLoadSchedule = null;
    private static final Logger LOGGER = Logger.getLogger(NonConformLoadScheduleQueryRestController.class.getName());
    
}
