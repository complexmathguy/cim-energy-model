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
 * Implements Spring Controller query CQRS processing for entity Disconnector.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Disconnector")
public class DisconnectorQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Disconnector using a UUID
     * @param		UUID disconnectorId
     * @return		Disconnector
     */    
    @GetMapping("/load")
    public Disconnector load( @RequestParam(required=true) UUID disconnectorId ) {
    	Disconnector entity = null;

    	try {  
    		entity = DisconnectorBusinessDelegate.getDisconnectorInstance().getDisconnector( new DisconnectorFetchOneSummary( disconnectorId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Disconnector using Id " + disconnectorId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Disconnector business objects
     * @return		Set<Disconnector>
     */
    @GetMapping("/")
    public List<Disconnector> loadAll() {                
    	List<Disconnector> disconnectorList = null;
        
    	try {
            // load the Disconnector
            disconnectorList = DisconnectorBusinessDelegate.getDisconnectorInstance().getAllDisconnector();
            
            if ( disconnectorList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Disconnectors" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Disconnectors ", exc );
        	return null;
        }

        return disconnectorList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Disconnector disconnector = null;
    private static final Logger LOGGER = Logger.getLogger(DisconnectorQueryRestController.class.getName());
    
}
