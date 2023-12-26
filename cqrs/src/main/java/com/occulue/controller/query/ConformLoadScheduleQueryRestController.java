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
 * Implements Spring Controller query CQRS processing for entity ConformLoadSchedule.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ConformLoadSchedule")
public class ConformLoadScheduleQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ConformLoadSchedule using a UUID
     * @param		UUID conformLoadScheduleId
     * @return		ConformLoadSchedule
     */    
    @GetMapping("/load")
    public ConformLoadSchedule load( @RequestParam(required=true) UUID conformLoadScheduleId ) {
    	ConformLoadSchedule entity = null;

    	try {  
    		entity = ConformLoadScheduleBusinessDelegate.getConformLoadScheduleInstance().getConformLoadSchedule( new ConformLoadScheduleFetchOneSummary( conformLoadScheduleId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ConformLoadSchedule using Id " + conformLoadScheduleId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ConformLoadSchedule business objects
     * @return		Set<ConformLoadSchedule>
     */
    @GetMapping("/")
    public List<ConformLoadSchedule> loadAll() {                
    	List<ConformLoadSchedule> conformLoadScheduleList = null;
        
    	try {
            // load the ConformLoadSchedule
            conformLoadScheduleList = ConformLoadScheduleBusinessDelegate.getConformLoadScheduleInstance().getAllConformLoadSchedule();
            
            if ( conformLoadScheduleList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ConformLoadSchedules" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ConformLoadSchedules ", exc );
        	return null;
        }

        return conformLoadScheduleList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ConformLoadSchedule conformLoadSchedule = null;
    private static final Logger LOGGER = Logger.getLogger(ConformLoadScheduleQueryRestController.class.getName());
    
}
