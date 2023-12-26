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
 * Implements Spring Controller query CQRS processing for entity TopologicalIsland.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TopologicalIsland")
public class TopologicalIslandQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a TopologicalIsland using a UUID
     * @param		UUID topologicalIslandId
     * @return		TopologicalIsland
     */    
    @GetMapping("/load")
    public TopologicalIsland load( @RequestParam(required=true) UUID topologicalIslandId ) {
    	TopologicalIsland entity = null;

    	try {  
    		entity = TopologicalIslandBusinessDelegate.getTopologicalIslandInstance().getTopologicalIsland( new TopologicalIslandFetchOneSummary( topologicalIslandId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load TopologicalIsland using Id " + topologicalIslandId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all TopologicalIsland business objects
     * @return		Set<TopologicalIsland>
     */
    @GetMapping("/")
    public List<TopologicalIsland> loadAll() {                
    	List<TopologicalIsland> topologicalIslandList = null;
        
    	try {
            // load the TopologicalIsland
            topologicalIslandList = TopologicalIslandBusinessDelegate.getTopologicalIslandInstance().getAllTopologicalIsland();
            
            if ( topologicalIslandList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all TopologicalIslands" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all TopologicalIslands ", exc );
        	return null;
        }

        return topologicalIslandList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected TopologicalIsland topologicalIsland = null;
    private static final Logger LOGGER = Logger.getLogger(TopologicalIslandQueryRestController.class.getName());
    
}
