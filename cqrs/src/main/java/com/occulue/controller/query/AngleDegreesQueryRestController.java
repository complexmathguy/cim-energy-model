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
 * Implements Spring Controller query CQRS processing for entity AngleDegrees.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/AngleDegrees")
public class AngleDegreesQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a AngleDegrees using a UUID
     * @param		UUID angleDegreesId
     * @return		AngleDegrees
     */    
    @GetMapping("/load")
    public AngleDegrees load( @RequestParam(required=true) UUID angleDegreesId ) {
    	AngleDegrees entity = null;

    	try {  
    		entity = AngleDegreesBusinessDelegate.getAngleDegreesInstance().getAngleDegrees( new AngleDegreesFetchOneSummary( angleDegreesId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load AngleDegrees using Id " + angleDegreesId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all AngleDegrees business objects
     * @return		Set<AngleDegrees>
     */
    @GetMapping("/")
    public List<AngleDegrees> loadAll() {                
    	List<AngleDegrees> angleDegreesList = null;
        
    	try {
            // load the AngleDegrees
            angleDegreesList = AngleDegreesBusinessDelegate.getAngleDegreesInstance().getAllAngleDegrees();
            
            if ( angleDegreesList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all AngleDegreess" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all AngleDegreess ", exc );
        	return null;
        }

        return angleDegreesList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected AngleDegrees angleDegrees = null;
    private static final Logger LOGGER = Logger.getLogger(AngleDegreesQueryRestController.class.getName());
    
}
