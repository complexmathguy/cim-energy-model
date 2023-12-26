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
 * Implements Spring Controller query CQRS processing for entity GroundDisconnector.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GroundDisconnector")
public class GroundDisconnectorQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a GroundDisconnector using a UUID
     * @param		UUID groundDisconnectorId
     * @return		GroundDisconnector
     */    
    @GetMapping("/load")
    public GroundDisconnector load( @RequestParam(required=true) UUID groundDisconnectorId ) {
    	GroundDisconnector entity = null;

    	try {  
    		entity = GroundDisconnectorBusinessDelegate.getGroundDisconnectorInstance().getGroundDisconnector( new GroundDisconnectorFetchOneSummary( groundDisconnectorId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load GroundDisconnector using Id " + groundDisconnectorId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all GroundDisconnector business objects
     * @return		Set<GroundDisconnector>
     */
    @GetMapping("/")
    public List<GroundDisconnector> loadAll() {                
    	List<GroundDisconnector> groundDisconnectorList = null;
        
    	try {
            // load the GroundDisconnector
            groundDisconnectorList = GroundDisconnectorBusinessDelegate.getGroundDisconnectorInstance().getAllGroundDisconnector();
            
            if ( groundDisconnectorList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all GroundDisconnectors" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all GroundDisconnectors ", exc );
        	return null;
        }

        return groundDisconnectorList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected GroundDisconnector groundDisconnector = null;
    private static final Logger LOGGER = Logger.getLogger(GroundDisconnectorQueryRestController.class.getName());
    
}
