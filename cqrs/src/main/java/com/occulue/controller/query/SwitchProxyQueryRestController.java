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
 * Implements Spring Controller query CQRS processing for entity SwitchProxy.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SwitchProxy")
public class SwitchProxyQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a SwitchProxy using a UUID
     * @param		UUID switchProxyId
     * @return		SwitchProxy
     */    
    @GetMapping("/load")
    public SwitchProxy load( @RequestParam(required=true) UUID switchProxyId ) {
    	SwitchProxy entity = null;

    	try {  
    		entity = SwitchProxyBusinessDelegate.getSwitchProxyInstance().getSwitchProxy( new SwitchProxyFetchOneSummary( switchProxyId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load SwitchProxy using Id " + switchProxyId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all SwitchProxy business objects
     * @return		Set<SwitchProxy>
     */
    @GetMapping("/")
    public List<SwitchProxy> loadAll() {                
    	List<SwitchProxy> switchProxyList = null;
        
    	try {
            // load the SwitchProxy
            switchProxyList = SwitchProxyBusinessDelegate.getSwitchProxyInstance().getAllSwitchProxy();
            
            if ( switchProxyList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all SwitchProxys" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all SwitchProxys ", exc );
        	return null;
        }

        return switchProxyList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected SwitchProxy switchProxy = null;
    private static final Logger LOGGER = Logger.getLogger(SwitchProxyQueryRestController.class.getName());
    
}
