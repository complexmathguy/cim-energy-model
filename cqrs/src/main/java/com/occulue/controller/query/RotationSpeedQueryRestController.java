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
 * Implements Spring Controller query CQRS processing for entity RotationSpeed.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/RotationSpeed")
public class RotationSpeedQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a RotationSpeed using a UUID
     * @param		UUID rotationSpeedId
     * @return		RotationSpeed
     */    
    @GetMapping("/load")
    public RotationSpeed load( @RequestParam(required=true) UUID rotationSpeedId ) {
    	RotationSpeed entity = null;

    	try {  
    		entity = RotationSpeedBusinessDelegate.getRotationSpeedInstance().getRotationSpeed( new RotationSpeedFetchOneSummary( rotationSpeedId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load RotationSpeed using Id " + rotationSpeedId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all RotationSpeed business objects
     * @return		Set<RotationSpeed>
     */
    @GetMapping("/")
    public List<RotationSpeed> loadAll() {                
    	List<RotationSpeed> rotationSpeedList = null;
        
    	try {
            // load the RotationSpeed
            rotationSpeedList = RotationSpeedBusinessDelegate.getRotationSpeedInstance().getAllRotationSpeed();
            
            if ( rotationSpeedList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all RotationSpeeds" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all RotationSpeeds ", exc );
        	return null;
        }

        return rotationSpeedList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected RotationSpeed rotationSpeed = null;
    private static final Logger LOGGER = Logger.getLogger(RotationSpeedQueryRestController.class.getName());
    
}
