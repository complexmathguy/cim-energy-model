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
 * Implements Spring Controller query CQRS processing for entity DCNode.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCNode")
public class DCNodeQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a DCNode using a UUID
     * @param		UUID dCNodeId
     * @return		DCNode
     */    
    @GetMapping("/load")
    public DCNode load( @RequestParam(required=true) UUID dCNodeId ) {
    	DCNode entity = null;

    	try {  
    		entity = DCNodeBusinessDelegate.getDCNodeInstance().getDCNode( new DCNodeFetchOneSummary( dCNodeId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load DCNode using Id " + dCNodeId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all DCNode business objects
     * @return		Set<DCNode>
     */
    @GetMapping("/")
    public List<DCNode> loadAll() {                
    	List<DCNode> dCNodeList = null;
        
    	try {
            // load the DCNode
            dCNodeList = DCNodeBusinessDelegate.getDCNodeInstance().getAllDCNode();
            
            if ( dCNodeList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all DCNodes" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all DCNodes ", exc );
        	return null;
        }

        return dCNodeList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected DCNode dCNode = null;
    private static final Logger LOGGER = Logger.getLogger(DCNodeQueryRestController.class.getName());
    
}
