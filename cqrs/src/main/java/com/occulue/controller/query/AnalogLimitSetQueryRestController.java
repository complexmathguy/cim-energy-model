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
 * Implements Spring Controller query CQRS processing for entity AnalogLimitSet.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/AnalogLimitSet")
public class AnalogLimitSetQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a AnalogLimitSet using a UUID
     * @param		UUID analogLimitSetId
     * @return		AnalogLimitSet
     */    
    @GetMapping("/load")
    public AnalogLimitSet load( @RequestParam(required=true) UUID analogLimitSetId ) {
    	AnalogLimitSet entity = null;

    	try {  
    		entity = AnalogLimitSetBusinessDelegate.getAnalogLimitSetInstance().getAnalogLimitSet( new AnalogLimitSetFetchOneSummary( analogLimitSetId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load AnalogLimitSet using Id " + analogLimitSetId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all AnalogLimitSet business objects
     * @return		Set<AnalogLimitSet>
     */
    @GetMapping("/")
    public List<AnalogLimitSet> loadAll() {                
    	List<AnalogLimitSet> analogLimitSetList = null;
        
    	try {
            // load the AnalogLimitSet
            analogLimitSetList = AnalogLimitSetBusinessDelegate.getAnalogLimitSetInstance().getAllAnalogLimitSet();
            
            if ( analogLimitSetList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all AnalogLimitSets" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all AnalogLimitSets ", exc );
        	return null;
        }

        return analogLimitSetList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected AnalogLimitSet analogLimitSet = null;
    private static final Logger LOGGER = Logger.getLogger(AnalogLimitSetQueryRestController.class.getName());
    
}
