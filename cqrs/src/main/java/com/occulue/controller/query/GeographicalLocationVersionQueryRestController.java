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
 * Implements Spring Controller query CQRS processing for entity GeographicalLocationVersion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GeographicalLocationVersion")
public class GeographicalLocationVersionQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a GeographicalLocationVersion using a UUID
     * @param		UUID geographicalLocationVersionId
     * @return		GeographicalLocationVersion
     */    
    @GetMapping("/load")
    public GeographicalLocationVersion load( @RequestParam(required=true) UUID geographicalLocationVersionId ) {
    	GeographicalLocationVersion entity = null;

    	try {  
    		entity = GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance().getGeographicalLocationVersion( new GeographicalLocationVersionFetchOneSummary( geographicalLocationVersionId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load GeographicalLocationVersion using Id " + geographicalLocationVersionId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all GeographicalLocationVersion business objects
     * @return		Set<GeographicalLocationVersion>
     */
    @GetMapping("/")
    public List<GeographicalLocationVersion> loadAll() {                
    	List<GeographicalLocationVersion> geographicalLocationVersionList = null;
        
    	try {
            // load the GeographicalLocationVersion
            geographicalLocationVersionList = GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance().getAllGeographicalLocationVersion();
            
            if ( geographicalLocationVersionList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all GeographicalLocationVersions" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all GeographicalLocationVersions ", exc );
        	return null;
        }

        return geographicalLocationVersionList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected GeographicalLocationVersion geographicalLocationVersion = null;
    private static final Logger LOGGER = Logger.getLogger(GeographicalLocationVersionQueryRestController.class.getName());
    
}
