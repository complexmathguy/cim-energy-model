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
 * Implements Spring Controller query CQRS processing for entity AngleRadians.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/AngleRadians")
public class AngleRadiansQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a AngleRadians using a UUID
     * @param		UUID angleRadiansId
     * @return		AngleRadians
     */    
    @GetMapping("/load")
    public AngleRadians load( @RequestParam(required=true) UUID angleRadiansId ) {
    	AngleRadians entity = null;

    	try {  
    		entity = AngleRadiansBusinessDelegate.getAngleRadiansInstance().getAngleRadians( new AngleRadiansFetchOneSummary( angleRadiansId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load AngleRadians using Id " + angleRadiansId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all AngleRadians business objects
     * @return		Set<AngleRadians>
     */
    @GetMapping("/")
    public List<AngleRadians> loadAll() {                
    	List<AngleRadians> angleRadiansList = null;
        
    	try {
            // load the AngleRadians
            angleRadiansList = AngleRadiansBusinessDelegate.getAngleRadiansInstance().getAllAngleRadians();
            
            if ( angleRadiansList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all AngleRadianss" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all AngleRadianss ", exc );
        	return null;
        }

        return angleRadiansList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected AngleRadians angleRadians = null;
    private static final Logger LOGGER = Logger.getLogger(AngleRadiansQueryRestController.class.getName());
    
}
