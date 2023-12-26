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
 * Implements Spring Controller query CQRS processing for entity TopologyBoundaryVersion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TopologyBoundaryVersion")
public class TopologyBoundaryVersionQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a TopologyBoundaryVersion using a UUID
     * @param		UUID topologyBoundaryVersionId
     * @return		TopologyBoundaryVersion
     */    
    @GetMapping("/load")
    public TopologyBoundaryVersion load( @RequestParam(required=true) UUID topologyBoundaryVersionId ) {
    	TopologyBoundaryVersion entity = null;

    	try {  
    		entity = TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance().getTopologyBoundaryVersion( new TopologyBoundaryVersionFetchOneSummary( topologyBoundaryVersionId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load TopologyBoundaryVersion using Id " + topologyBoundaryVersionId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all TopologyBoundaryVersion business objects
     * @return		Set<TopologyBoundaryVersion>
     */
    @GetMapping("/")
    public List<TopologyBoundaryVersion> loadAll() {                
    	List<TopologyBoundaryVersion> topologyBoundaryVersionList = null;
        
    	try {
            // load the TopologyBoundaryVersion
            topologyBoundaryVersionList = TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance().getAllTopologyBoundaryVersion();
            
            if ( topologyBoundaryVersionList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all TopologyBoundaryVersions" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all TopologyBoundaryVersions ", exc );
        	return null;
        }

        return topologyBoundaryVersionList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected TopologyBoundaryVersion topologyBoundaryVersion = null;
    private static final Logger LOGGER = Logger.getLogger(TopologyBoundaryVersionQueryRestController.class.getName());
    
}
