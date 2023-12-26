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
 * Implements Spring Controller query CQRS processing for entity ConnectivityNodeContainer.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ConnectivityNodeContainer")
public class ConnectivityNodeContainerQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ConnectivityNodeContainer using a UUID
     * @param		UUID connectivityNodeContainerId
     * @return		ConnectivityNodeContainer
     */    
    @GetMapping("/load")
    public ConnectivityNodeContainer load( @RequestParam(required=true) UUID connectivityNodeContainerId ) {
    	ConnectivityNodeContainer entity = null;

    	try {  
    		entity = ConnectivityNodeContainerBusinessDelegate.getConnectivityNodeContainerInstance().getConnectivityNodeContainer( new ConnectivityNodeContainerFetchOneSummary( connectivityNodeContainerId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ConnectivityNodeContainer using Id " + connectivityNodeContainerId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ConnectivityNodeContainer business objects
     * @return		Set<ConnectivityNodeContainer>
     */
    @GetMapping("/")
    public List<ConnectivityNodeContainer> loadAll() {                
    	List<ConnectivityNodeContainer> connectivityNodeContainerList = null;
        
    	try {
            // load the ConnectivityNodeContainer
            connectivityNodeContainerList = ConnectivityNodeContainerBusinessDelegate.getConnectivityNodeContainerInstance().getAllConnectivityNodeContainer();
            
            if ( connectivityNodeContainerList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ConnectivityNodeContainers" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ConnectivityNodeContainers ", exc );
        	return null;
        }

        return connectivityNodeContainerList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ConnectivityNodeContainer connectivityNodeContainer = null;
    private static final Logger LOGGER = Logger.getLogger(ConnectivityNodeContainerQueryRestController.class.getName());
    
}
