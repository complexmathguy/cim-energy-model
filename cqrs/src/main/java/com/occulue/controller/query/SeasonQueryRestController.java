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
 * Implements Spring Controller query CQRS processing for entity Season.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Season")
public class SeasonQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Season using a UUID
     * @param		UUID seasonId
     * @return		Season
     */    
    @GetMapping("/load")
    public Season load( @RequestParam(required=true) UUID seasonId ) {
    	Season entity = null;

    	try {  
    		entity = SeasonBusinessDelegate.getSeasonInstance().getSeason( new SeasonFetchOneSummary( seasonId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Season using Id " + seasonId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Season business objects
     * @return		Set<Season>
     */
    @GetMapping("/")
    public List<Season> loadAll() {                
    	List<Season> seasonList = null;
        
    	try {
            // load the Season
            seasonList = SeasonBusinessDelegate.getSeasonInstance().getAllSeason();
            
            if ( seasonList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Seasons" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Seasons ", exc );
        	return null;
        }

        return seasonList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Season season = null;
    private static final Logger LOGGER = Logger.getLogger(SeasonQueryRestController.class.getName());
    
}
