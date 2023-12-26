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
 * Implements Spring Controller query CQRS processing for entity ACLineSegment.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ACLineSegment")
public class ACLineSegmentQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ACLineSegment using a UUID
     * @param		UUID aCLineSegmentId
     * @return		ACLineSegment
     */    
    @GetMapping("/load")
    public ACLineSegment load( @RequestParam(required=true) UUID aCLineSegmentId ) {
    	ACLineSegment entity = null;

    	try {  
    		entity = ACLineSegmentBusinessDelegate.getACLineSegmentInstance().getACLineSegment( new ACLineSegmentFetchOneSummary( aCLineSegmentId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ACLineSegment using Id " + aCLineSegmentId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ACLineSegment business objects
     * @return		Set<ACLineSegment>
     */
    @GetMapping("/")
    public List<ACLineSegment> loadAll() {                
    	List<ACLineSegment> aCLineSegmentList = null;
        
    	try {
            // load the ACLineSegment
            aCLineSegmentList = ACLineSegmentBusinessDelegate.getACLineSegmentInstance().getAllACLineSegment();
            
            if ( aCLineSegmentList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ACLineSegments" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ACLineSegments ", exc );
        	return null;
        }

        return aCLineSegmentList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ACLineSegment aCLineSegment = null;
    private static final Logger LOGGER = Logger.getLogger(ACLineSegmentQueryRestController.class.getName());
    
}
