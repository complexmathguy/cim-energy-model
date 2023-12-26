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
 * Implements Spring Controller query CQRS processing for entity TieFlow.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TieFlow")
public class TieFlowQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a TieFlow using a UUID
     * @param		UUID tieFlowId
     * @return		TieFlow
     */    
    @GetMapping("/load")
    public TieFlow load( @RequestParam(required=true) UUID tieFlowId ) {
    	TieFlow entity = null;

    	try {  
    		entity = TieFlowBusinessDelegate.getTieFlowInstance().getTieFlow( new TieFlowFetchOneSummary( tieFlowId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load TieFlow using Id " + tieFlowId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all TieFlow business objects
     * @return		Set<TieFlow>
     */
    @GetMapping("/")
    public List<TieFlow> loadAll() {                
    	List<TieFlow> tieFlowList = null;
        
    	try {
            // load the TieFlow
            tieFlowList = TieFlowBusinessDelegate.getTieFlowInstance().getAllTieFlow();
            
            if ( tieFlowList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all TieFlows" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all TieFlows ", exc );
        	return null;
        }

        return tieFlowList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected TieFlow tieFlow = null;
    private static final Logger LOGGER = Logger.getLogger(TieFlowQueryRestController.class.getName());
    
}
