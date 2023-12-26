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
 * Implements Spring Controller query CQRS processing for entity Control.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Control")
public class ControlQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Control using a UUID
     * @param		UUID controlId
     * @return		Control
     */    
    @GetMapping("/load")
    public Control load( @RequestParam(required=true) UUID controlId ) {
    	Control entity = null;

    	try {  
    		entity = ControlBusinessDelegate.getControlInstance().getControl( new ControlFetchOneSummary( controlId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Control using Id " + controlId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Control business objects
     * @return		Set<Control>
     */
    @GetMapping("/")
    public List<Control> loadAll() {                
    	List<Control> controlList = null;
        
    	try {
            // load the Control
            controlList = ControlBusinessDelegate.getControlInstance().getAllControl();
            
            if ( controlList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Controls" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Controls ", exc );
        	return null;
        }

        return controlList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Control control = null;
    private static final Logger LOGGER = Logger.getLogger(ControlQueryRestController.class.getName());
    
}
