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
 * Implements Spring Controller query CQRS processing for entity DCBusbar.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCBusbar")
public class DCBusbarQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a DCBusbar using a UUID
     * @param		UUID dCBusbarId
     * @return		DCBusbar
     */    
    @GetMapping("/load")
    public DCBusbar load( @RequestParam(required=true) UUID dCBusbarId ) {
    	DCBusbar entity = null;

    	try {  
    		entity = DCBusbarBusinessDelegate.getDCBusbarInstance().getDCBusbar( new DCBusbarFetchOneSummary( dCBusbarId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load DCBusbar using Id " + dCBusbarId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all DCBusbar business objects
     * @return		Set<DCBusbar>
     */
    @GetMapping("/")
    public List<DCBusbar> loadAll() {                
    	List<DCBusbar> dCBusbarList = null;
        
    	try {
            // load the DCBusbar
            dCBusbarList = DCBusbarBusinessDelegate.getDCBusbarInstance().getAllDCBusbar();
            
            if ( dCBusbarList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all DCBusbars" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all DCBusbars ", exc );
        	return null;
        }

        return dCBusbarList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected DCBusbar dCBusbar = null;
    private static final Logger LOGGER = Logger.getLogger(DCBusbarQueryRestController.class.getName());
    
}
