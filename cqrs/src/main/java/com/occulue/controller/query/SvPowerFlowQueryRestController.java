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
 * Implements Spring Controller query CQRS processing for entity SvPowerFlow.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SvPowerFlow")
public class SvPowerFlowQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a SvPowerFlow using a UUID
     * @param		UUID svPowerFlowId
     * @return		SvPowerFlow
     */    
    @GetMapping("/load")
    public SvPowerFlow load( @RequestParam(required=true) UUID svPowerFlowId ) {
    	SvPowerFlow entity = null;

    	try {  
    		entity = SvPowerFlowBusinessDelegate.getSvPowerFlowInstance().getSvPowerFlow( new SvPowerFlowFetchOneSummary( svPowerFlowId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load SvPowerFlow using Id " + svPowerFlowId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all SvPowerFlow business objects
     * @return		Set<SvPowerFlow>
     */
    @GetMapping("/")
    public List<SvPowerFlow> loadAll() {                
    	List<SvPowerFlow> svPowerFlowList = null;
        
    	try {
            // load the SvPowerFlow
            svPowerFlowList = SvPowerFlowBusinessDelegate.getSvPowerFlowInstance().getAllSvPowerFlow();
            
            if ( svPowerFlowList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all SvPowerFlows" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all SvPowerFlows ", exc );
        	return null;
        }

        return svPowerFlowList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected SvPowerFlow svPowerFlow = null;
    private static final Logger LOGGER = Logger.getLogger(SvPowerFlowQueryRestController.class.getName());
    
}
