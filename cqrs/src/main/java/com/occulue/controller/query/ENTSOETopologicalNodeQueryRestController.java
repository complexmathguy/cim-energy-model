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
 * Implements Spring Controller query CQRS processing for entity ENTSOETopologicalNode.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ENTSOETopologicalNode")
public class ENTSOETopologicalNodeQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ENTSOETopologicalNode using a UUID
     * @param		UUID eNTSOETopologicalNodeId
     * @return		ENTSOETopologicalNode
     */    
    @GetMapping("/load")
    public ENTSOETopologicalNode load( @RequestParam(required=true) UUID eNTSOETopologicalNodeId ) {
    	ENTSOETopologicalNode entity = null;

    	try {  
    		entity = ENTSOETopologicalNodeBusinessDelegate.getENTSOETopologicalNodeInstance().getENTSOETopologicalNode( new ENTSOETopologicalNodeFetchOneSummary( eNTSOETopologicalNodeId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ENTSOETopologicalNode using Id " + eNTSOETopologicalNodeId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ENTSOETopologicalNode business objects
     * @return		Set<ENTSOETopologicalNode>
     */
    @GetMapping("/")
    public List<ENTSOETopologicalNode> loadAll() {                
    	List<ENTSOETopologicalNode> eNTSOETopologicalNodeList = null;
        
    	try {
            // load the ENTSOETopologicalNode
            eNTSOETopologicalNodeList = ENTSOETopologicalNodeBusinessDelegate.getENTSOETopologicalNodeInstance().getAllENTSOETopologicalNode();
            
            if ( eNTSOETopologicalNodeList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ENTSOETopologicalNodes" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ENTSOETopologicalNodes ", exc );
        	return null;
        }

        return eNTSOETopologicalNodeList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ENTSOETopologicalNode eNTSOETopologicalNode = null;
    private static final Logger LOGGER = Logger.getLogger(ENTSOETopologicalNodeQueryRestController.class.getName());
    
}
