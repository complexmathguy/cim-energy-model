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
 * Implements Spring Controller query CQRS processing for entity LoadAggregate.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/LoadAggregate")
public class LoadAggregateQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a LoadAggregate using a UUID
     * @param		UUID loadAggregateId
     * @return		LoadAggregate
     */    
    @GetMapping("/load")
    public LoadAggregate load( @RequestParam(required=true) UUID loadAggregateId ) {
    	LoadAggregate entity = null;

    	try {  
    		entity = LoadAggregateBusinessDelegate.getLoadAggregateInstance().getLoadAggregate( new LoadAggregateFetchOneSummary( loadAggregateId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load LoadAggregate using Id " + loadAggregateId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all LoadAggregate business objects
     * @return		Set<LoadAggregate>
     */
    @GetMapping("/")
    public List<LoadAggregate> loadAll() {                
    	List<LoadAggregate> loadAggregateList = null;
        
    	try {
            // load the LoadAggregate
            loadAggregateList = LoadAggregateBusinessDelegate.getLoadAggregateInstance().getAllLoadAggregate();
            
            if ( loadAggregateList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all LoadAggregates" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all LoadAggregates ", exc );
        	return null;
        }

        return loadAggregateList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected LoadAggregate loadAggregate = null;
    private static final Logger LOGGER = Logger.getLogger(LoadAggregateQueryRestController.class.getName());
    
}
