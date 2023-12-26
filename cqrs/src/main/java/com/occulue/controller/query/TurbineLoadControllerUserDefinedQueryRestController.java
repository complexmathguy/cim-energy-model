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
 * Implements Spring Controller query CQRS processing for entity TurbineLoadControllerUserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TurbineLoadControllerUserDefined")
public class TurbineLoadControllerUserDefinedQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a TurbineLoadControllerUserDefined using a UUID
     * @param		UUID turbineLoadControllerUserDefinedId
     * @return		TurbineLoadControllerUserDefined
     */    
    @GetMapping("/load")
    public TurbineLoadControllerUserDefined load( @RequestParam(required=true) UUID turbineLoadControllerUserDefinedId ) {
    	TurbineLoadControllerUserDefined entity = null;

    	try {  
    		entity = TurbineLoadControllerUserDefinedBusinessDelegate.getTurbineLoadControllerUserDefinedInstance().getTurbineLoadControllerUserDefined( new TurbineLoadControllerUserDefinedFetchOneSummary( turbineLoadControllerUserDefinedId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load TurbineLoadControllerUserDefined using Id " + turbineLoadControllerUserDefinedId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all TurbineLoadControllerUserDefined business objects
     * @return		Set<TurbineLoadControllerUserDefined>
     */
    @GetMapping("/")
    public List<TurbineLoadControllerUserDefined> loadAll() {                
    	List<TurbineLoadControllerUserDefined> turbineLoadControllerUserDefinedList = null;
        
    	try {
            // load the TurbineLoadControllerUserDefined
            turbineLoadControllerUserDefinedList = TurbineLoadControllerUserDefinedBusinessDelegate.getTurbineLoadControllerUserDefinedInstance().getAllTurbineLoadControllerUserDefined();
            
            if ( turbineLoadControllerUserDefinedList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all TurbineLoadControllerUserDefineds" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all TurbineLoadControllerUserDefineds ", exc );
        	return null;
        }

        return turbineLoadControllerUserDefinedList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected TurbineLoadControllerUserDefined turbineLoadControllerUserDefined = null;
    private static final Logger LOGGER = Logger.getLogger(TurbineLoadControllerUserDefinedQueryRestController.class.getName());
    
}
