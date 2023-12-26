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
 * Implements Spring Controller query CQRS processing for entity WindType3or4UserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindType3or4UserDefined")
public class WindType3or4UserDefinedQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a WindType3or4UserDefined using a UUID
     * @param		UUID windType3or4UserDefinedId
     * @return		WindType3or4UserDefined
     */    
    @GetMapping("/load")
    public WindType3or4UserDefined load( @RequestParam(required=true) UUID windType3or4UserDefinedId ) {
    	WindType3or4UserDefined entity = null;

    	try {  
    		entity = WindType3or4UserDefinedBusinessDelegate.getWindType3or4UserDefinedInstance().getWindType3or4UserDefined( new WindType3or4UserDefinedFetchOneSummary( windType3or4UserDefinedId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load WindType3or4UserDefined using Id " + windType3or4UserDefinedId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all WindType3or4UserDefined business objects
     * @return		Set<WindType3or4UserDefined>
     */
    @GetMapping("/")
    public List<WindType3or4UserDefined> loadAll() {                
    	List<WindType3or4UserDefined> windType3or4UserDefinedList = null;
        
    	try {
            // load the WindType3or4UserDefined
            windType3or4UserDefinedList = WindType3or4UserDefinedBusinessDelegate.getWindType3or4UserDefinedInstance().getAllWindType3or4UserDefined();
            
            if ( windType3or4UserDefinedList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all WindType3or4UserDefineds" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all WindType3or4UserDefineds ", exc );
        	return null;
        }

        return windType3or4UserDefinedList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected WindType3or4UserDefined windType3or4UserDefined = null;
    private static final Logger LOGGER = Logger.getLogger(WindType3or4UserDefinedQueryRestController.class.getName());
    
}
