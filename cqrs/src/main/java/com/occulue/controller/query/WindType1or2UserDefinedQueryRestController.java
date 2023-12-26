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
 * Implements Spring Controller query CQRS processing for entity WindType1or2UserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindType1or2UserDefined")
public class WindType1or2UserDefinedQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a WindType1or2UserDefined using a UUID
     * @param		UUID windType1or2UserDefinedId
     * @return		WindType1or2UserDefined
     */    
    @GetMapping("/load")
    public WindType1or2UserDefined load( @RequestParam(required=true) UUID windType1or2UserDefinedId ) {
    	WindType1or2UserDefined entity = null;

    	try {  
    		entity = WindType1or2UserDefinedBusinessDelegate.getWindType1or2UserDefinedInstance().getWindType1or2UserDefined( new WindType1or2UserDefinedFetchOneSummary( windType1or2UserDefinedId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load WindType1or2UserDefined using Id " + windType1or2UserDefinedId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all WindType1or2UserDefined business objects
     * @return		Set<WindType1or2UserDefined>
     */
    @GetMapping("/")
    public List<WindType1or2UserDefined> loadAll() {                
    	List<WindType1or2UserDefined> windType1or2UserDefinedList = null;
        
    	try {
            // load the WindType1or2UserDefined
            windType1or2UserDefinedList = WindType1or2UserDefinedBusinessDelegate.getWindType1or2UserDefinedInstance().getAllWindType1or2UserDefined();
            
            if ( windType1or2UserDefinedList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all WindType1or2UserDefineds" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all WindType1or2UserDefineds ", exc );
        	return null;
        }

        return windType1or2UserDefinedList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected WindType1or2UserDefined windType1or2UserDefined = null;
    private static final Logger LOGGER = Logger.getLogger(WindType1or2UserDefinedQueryRestController.class.getName());
    
}
