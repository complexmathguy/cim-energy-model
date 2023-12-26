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
 * Implements Spring Controller query CQRS processing for entity TopologyVersion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TopologyVersion")
public class TopologyVersionQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a TopologyVersion using a UUID
     * @param		UUID topologyVersionId
     * @return		TopologyVersion
     */    
    @GetMapping("/load")
    public TopologyVersion load( @RequestParam(required=true) UUID topologyVersionId ) {
    	TopologyVersion entity = null;

    	try {  
    		entity = TopologyVersionBusinessDelegate.getTopologyVersionInstance().getTopologyVersion( new TopologyVersionFetchOneSummary( topologyVersionId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load TopologyVersion using Id " + topologyVersionId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all TopologyVersion business objects
     * @return		Set<TopologyVersion>
     */
    @GetMapping("/")
    public List<TopologyVersion> loadAll() {                
    	List<TopologyVersion> topologyVersionList = null;
        
    	try {
            // load the TopologyVersion
            topologyVersionList = TopologyVersionBusinessDelegate.getTopologyVersionInstance().getAllTopologyVersion();
            
            if ( topologyVersionList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all TopologyVersions" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all TopologyVersions ", exc );
        	return null;
        }

        return topologyVersionList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected TopologyVersion topologyVersion = null;
    private static final Logger LOGGER = Logger.getLogger(TopologyVersionQueryRestController.class.getName());
    
}
