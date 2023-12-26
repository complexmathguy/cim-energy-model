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
 * Implements Spring Controller query CQRS processing for entity SubGeographicalRegion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SubGeographicalRegion")
public class SubGeographicalRegionQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a SubGeographicalRegion using a UUID
     * @param		UUID subGeographicalRegionId
     * @return		SubGeographicalRegion
     */    
    @GetMapping("/load")
    public SubGeographicalRegion load( @RequestParam(required=true) UUID subGeographicalRegionId ) {
    	SubGeographicalRegion entity = null;

    	try {  
    		entity = SubGeographicalRegionBusinessDelegate.getSubGeographicalRegionInstance().getSubGeographicalRegion( new SubGeographicalRegionFetchOneSummary( subGeographicalRegionId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load SubGeographicalRegion using Id " + subGeographicalRegionId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all SubGeographicalRegion business objects
     * @return		Set<SubGeographicalRegion>
     */
    @GetMapping("/")
    public List<SubGeographicalRegion> loadAll() {                
    	List<SubGeographicalRegion> subGeographicalRegionList = null;
        
    	try {
            // load the SubGeographicalRegion
            subGeographicalRegionList = SubGeographicalRegionBusinessDelegate.getSubGeographicalRegionInstance().getAllSubGeographicalRegion();
            
            if ( subGeographicalRegionList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all SubGeographicalRegions" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all SubGeographicalRegions ", exc );
        	return null;
        }

        return subGeographicalRegionList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected SubGeographicalRegion subGeographicalRegion = null;
    private static final Logger LOGGER = Logger.getLogger(SubGeographicalRegionQueryRestController.class.getName());
    
}
