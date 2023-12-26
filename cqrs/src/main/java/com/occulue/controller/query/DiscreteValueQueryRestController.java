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
 * Implements Spring Controller query CQRS processing for entity DiscreteValue.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DiscreteValue")
public class DiscreteValueQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a DiscreteValue using a UUID
     * @param		UUID discreteValueId
     * @return		DiscreteValue
     */    
    @GetMapping("/load")
    public DiscreteValue load( @RequestParam(required=true) UUID discreteValueId ) {
    	DiscreteValue entity = null;

    	try {  
    		entity = DiscreteValueBusinessDelegate.getDiscreteValueInstance().getDiscreteValue( new DiscreteValueFetchOneSummary( discreteValueId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load DiscreteValue using Id " + discreteValueId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all DiscreteValue business objects
     * @return		Set<DiscreteValue>
     */
    @GetMapping("/")
    public List<DiscreteValue> loadAll() {                
    	List<DiscreteValue> discreteValueList = null;
        
    	try {
            // load the DiscreteValue
            discreteValueList = DiscreteValueBusinessDelegate.getDiscreteValueInstance().getAllDiscreteValue();
            
            if ( discreteValueList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all DiscreteValues" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all DiscreteValues ", exc );
        	return null;
        }

        return discreteValueList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected DiscreteValue discreteValue = null;
    private static final Logger LOGGER = Logger.getLogger(DiscreteValueQueryRestController.class.getName());
    
}
