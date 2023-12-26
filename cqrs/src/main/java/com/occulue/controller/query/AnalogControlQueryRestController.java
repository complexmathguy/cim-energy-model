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
 * Implements Spring Controller query CQRS processing for entity AnalogControl.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/AnalogControl")
public class AnalogControlQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a AnalogControl using a UUID
     * @param		UUID analogControlId
     * @return		AnalogControl
     */    
    @GetMapping("/load")
    public AnalogControl load( @RequestParam(required=true) UUID analogControlId ) {
    	AnalogControl entity = null;

    	try {  
    		entity = AnalogControlBusinessDelegate.getAnalogControlInstance().getAnalogControl( new AnalogControlFetchOneSummary( analogControlId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load AnalogControl using Id " + analogControlId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all AnalogControl business objects
     * @return		Set<AnalogControl>
     */
    @GetMapping("/")
    public List<AnalogControl> loadAll() {                
    	List<AnalogControl> analogControlList = null;
        
    	try {
            // load the AnalogControl
            analogControlList = AnalogControlBusinessDelegate.getAnalogControlInstance().getAllAnalogControl();
            
            if ( analogControlList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all AnalogControls" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all AnalogControls ", exc );
        	return null;
        }

        return analogControlList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected AnalogControl analogControl = null;
    private static final Logger LOGGER = Logger.getLogger(AnalogControlQueryRestController.class.getName());
    
}
