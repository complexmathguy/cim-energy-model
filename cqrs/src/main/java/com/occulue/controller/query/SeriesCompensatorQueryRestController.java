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
 * Implements Spring Controller query CQRS processing for entity SeriesCompensator.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SeriesCompensator")
public class SeriesCompensatorQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a SeriesCompensator using a UUID
     * @param		UUID seriesCompensatorId
     * @return		SeriesCompensator
     */    
    @GetMapping("/load")
    public SeriesCompensator load( @RequestParam(required=true) UUID seriesCompensatorId ) {
    	SeriesCompensator entity = null;

    	try {  
    		entity = SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance().getSeriesCompensator( new SeriesCompensatorFetchOneSummary( seriesCompensatorId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load SeriesCompensator using Id " + seriesCompensatorId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all SeriesCompensator business objects
     * @return		Set<SeriesCompensator>
     */
    @GetMapping("/")
    public List<SeriesCompensator> loadAll() {                
    	List<SeriesCompensator> seriesCompensatorList = null;
        
    	try {
            // load the SeriesCompensator
            seriesCompensatorList = SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance().getAllSeriesCompensator();
            
            if ( seriesCompensatorList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all SeriesCompensators" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all SeriesCompensators ", exc );
        	return null;
        }

        return seriesCompensatorList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected SeriesCompensator seriesCompensator = null;
    private static final Logger LOGGER = Logger.getLogger(SeriesCompensatorQueryRestController.class.getName());
    
}
