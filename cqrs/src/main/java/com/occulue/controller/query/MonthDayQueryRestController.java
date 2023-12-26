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
 * Implements Spring Controller query CQRS processing for entity MonthDay.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/MonthDay")
public class MonthDayQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a MonthDay using a UUID
     * @param		UUID monthDayId
     * @return		MonthDay
     */    
    @GetMapping("/load")
    public MonthDay load( @RequestParam(required=true) UUID monthDayId ) {
    	MonthDay entity = null;

    	try {  
    		entity = MonthDayBusinessDelegate.getMonthDayInstance().getMonthDay( new MonthDayFetchOneSummary( monthDayId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load MonthDay using Id " + monthDayId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all MonthDay business objects
     * @return		Set<MonthDay>
     */
    @GetMapping("/")
    public List<MonthDay> loadAll() {                
    	List<MonthDay> monthDayList = null;
        
    	try {
            // load the MonthDay
            monthDayList = MonthDayBusinessDelegate.getMonthDayInstance().getAllMonthDay();
            
            if ( monthDayList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all MonthDays" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all MonthDays ", exc );
        	return null;
        }

        return monthDayList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected MonthDay monthDay = null;
    private static final Logger LOGGER = Logger.getLogger(MonthDayQueryRestController.class.getName());
    
}
