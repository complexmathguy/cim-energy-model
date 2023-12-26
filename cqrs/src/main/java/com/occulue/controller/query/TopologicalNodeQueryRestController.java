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
 * Implements Spring Controller query CQRS processing for entity TopologicalNode.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TopologicalNode")
public class TopologicalNodeQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a TopologicalNode using a UUID
     * @param		UUID topologicalNodeId
     * @return		TopologicalNode
     */    
    @GetMapping("/load")
    public TopologicalNode load( @RequestParam(required=true) UUID topologicalNodeId ) {
    	TopologicalNode entity = null;

    	try {  
    		entity = TopologicalNodeBusinessDelegate.getTopologicalNodeInstance().getTopologicalNode( new TopologicalNodeFetchOneSummary( topologicalNodeId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load TopologicalNode using Id " + topologicalNodeId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all TopologicalNode business objects
     * @return		Set<TopologicalNode>
     */
    @GetMapping("/")
    public List<TopologicalNode> loadAll() {                
    	List<TopologicalNode> topologicalNodeList = null;
        
    	try {
            // load the TopologicalNode
            topologicalNodeList = TopologicalNodeBusinessDelegate.getTopologicalNodeInstance().getAllTopologicalNode();
            
            if ( topologicalNodeList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all TopologicalNodes" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all TopologicalNodes ", exc );
        	return null;
        }

        return topologicalNodeList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected TopologicalNode topologicalNode = null;
    private static final Logger LOGGER = Logger.getLogger(TopologicalNodeQueryRestController.class.getName());
    
}
