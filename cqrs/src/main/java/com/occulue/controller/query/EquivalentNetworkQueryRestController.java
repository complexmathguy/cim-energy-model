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
 * Implements Spring Controller query CQRS processing for entity EquivalentNetwork.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/EquivalentNetwork")
public class EquivalentNetworkQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a EquivalentNetwork using a UUID
     * @param		UUID equivalentNetworkId
     * @return		EquivalentNetwork
     */    
    @GetMapping("/load")
    public EquivalentNetwork load( @RequestParam(required=true) UUID equivalentNetworkId ) {
    	EquivalentNetwork entity = null;

    	try {  
    		entity = EquivalentNetworkBusinessDelegate.getEquivalentNetworkInstance().getEquivalentNetwork( new EquivalentNetworkFetchOneSummary( equivalentNetworkId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load EquivalentNetwork using Id " + equivalentNetworkId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all EquivalentNetwork business objects
     * @return		Set<EquivalentNetwork>
     */
    @GetMapping("/")
    public List<EquivalentNetwork> loadAll() {                
    	List<EquivalentNetwork> equivalentNetworkList = null;
        
    	try {
            // load the EquivalentNetwork
            equivalentNetworkList = EquivalentNetworkBusinessDelegate.getEquivalentNetworkInstance().getAllEquivalentNetwork();
            
            if ( equivalentNetworkList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all EquivalentNetworks" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all EquivalentNetworks ", exc );
        	return null;
        }

        return equivalentNetworkList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected EquivalentNetwork equivalentNetwork = null;
    private static final Logger LOGGER = Logger.getLogger(EquivalentNetworkQueryRestController.class.getName());
    
}
