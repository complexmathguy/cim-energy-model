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
 * Implements Spring Controller query CQRS processing for entity MonthDayInterval.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/MonthDayInterval")
public class MonthDayIntervalQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a MonthDayInterval using a UUID
     * @param		UUID monthDayIntervalId
     * @return		MonthDayInterval
     */    
    @GetMapping("/load")
    public MonthDayInterval load( @RequestParam(required=true) UUID monthDayIntervalId ) {
    	MonthDayInterval entity = null;

    	try {  
    		entity = MonthDayIntervalBusinessDelegate.getMonthDayIntervalInstance().getMonthDayInterval( new MonthDayIntervalFetchOneSummary( monthDayIntervalId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load MonthDayInterval using Id " + monthDayIntervalId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all MonthDayInterval business objects
     * @return		Set<MonthDayInterval>
     */
    @GetMapping("/")
    public List<MonthDayInterval> loadAll() {                
    	List<MonthDayInterval> monthDayIntervalList = null;
        
    	try {
            // load the MonthDayInterval
            monthDayIntervalList = MonthDayIntervalBusinessDelegate.getMonthDayIntervalInstance().getAllMonthDayInterval();
            
            if ( monthDayIntervalList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all MonthDayIntervals" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all MonthDayIntervals ", exc );
        	return null;
        }

        return monthDayIntervalList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected MonthDayInterval monthDayInterval = null;
    private static final Logger LOGGER = Logger.getLogger(MonthDayIntervalQueryRestController.class.getName());
    
}
