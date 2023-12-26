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
 * Implements Spring Controller query CQRS processing for entity DayType.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DayType")
public class DayTypeQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a DayType using a UUID
     * @param		UUID dayTypeId
     * @return		DayType
     */    
    @GetMapping("/load")
    public DayType load( @RequestParam(required=true) UUID dayTypeId ) {
    	DayType entity = null;

    	try {  
    		entity = DayTypeBusinessDelegate.getDayTypeInstance().getDayType( new DayTypeFetchOneSummary( dayTypeId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load DayType using Id " + dayTypeId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all DayType business objects
     * @return		Set<DayType>
     */
    @GetMapping("/")
    public List<DayType> loadAll() {                
    	List<DayType> dayTypeList = null;
        
    	try {
            // load the DayType
            dayTypeList = DayTypeBusinessDelegate.getDayTypeInstance().getAllDayType();
            
            if ( dayTypeList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all DayTypes" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all DayTypes ", exc );
        	return null;
        }

        return dayTypeList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected DayType dayType = null;
    private static final Logger LOGGER = Logger.getLogger(DayTypeQueryRestController.class.getName());
    
}
