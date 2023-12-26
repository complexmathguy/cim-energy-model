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
 * Implements Spring Controller query CQRS processing for entity ConnectivityNode.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ConnectivityNode")
public class ConnectivityNodeQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ConnectivityNode using a UUID
     * @param		UUID connectivityNodeId
     * @return		ConnectivityNode
     */    
    @GetMapping("/load")
    public ConnectivityNode load( @RequestParam(required=true) UUID connectivityNodeId ) {
    	ConnectivityNode entity = null;

    	try {  
    		entity = ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance().getConnectivityNode( new ConnectivityNodeFetchOneSummary( connectivityNodeId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ConnectivityNode using Id " + connectivityNodeId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ConnectivityNode business objects
     * @return		Set<ConnectivityNode>
     */
    @GetMapping("/")
    public List<ConnectivityNode> loadAll() {                
    	List<ConnectivityNode> connectivityNodeList = null;
        
    	try {
            // load the ConnectivityNode
            connectivityNodeList = ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance().getAllConnectivityNode();
            
            if ( connectivityNodeList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ConnectivityNodes" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ConnectivityNodes ", exc );
        	return null;
        }

        return connectivityNodeList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ConnectivityNode connectivityNode = null;
    private static final Logger LOGGER = Logger.getLogger(ConnectivityNodeQueryRestController.class.getName());
    
}
