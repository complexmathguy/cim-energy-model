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
 * Implements Spring Controller query CQRS processing for entity DateTime.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DateTime")
public class DateTimeQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a DateTime using a UUID
     * @param		UUID dateTimeId
     * @return		DateTime
     */    
    @GetMapping("/load")
    public DateTime load( @RequestParam(required=true) UUID dateTimeId ) {
    	DateTime entity = null;

    	try {  
    		entity = DateTimeBusinessDelegate.getDateTimeInstance().getDateTime( new DateTimeFetchOneSummary( dateTimeId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load DateTime using Id " + dateTimeId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all DateTime business objects
     * @return		Set<DateTime>
     */
    @GetMapping("/")
    public List<DateTime> loadAll() {                
    	List<DateTime> dateTimeList = null;
        
    	try {
            // load the DateTime
            dateTimeList = DateTimeBusinessDelegate.getDateTimeInstance().getAllDateTime();
            
            if ( dateTimeList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all DateTimes" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all DateTimes ", exc );
        	return null;
        }

        return dateTimeList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected DateTime dateTime = null;
    private static final Logger LOGGER = Logger.getLogger(DateTimeQueryRestController.class.getName());
    
}
