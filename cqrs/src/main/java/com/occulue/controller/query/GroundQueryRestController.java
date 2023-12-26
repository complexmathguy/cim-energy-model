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
 * Implements Spring Controller query CQRS processing for entity Ground.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Ground")
public class GroundQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Ground using a UUID
     * @param		UUID groundId
     * @return		Ground
     */    
    @GetMapping("/load")
    public Ground load( @RequestParam(required=true) UUID groundId ) {
    	Ground entity = null;

    	try {  
    		entity = GroundBusinessDelegate.getGroundInstance().getGround( new GroundFetchOneSummary( groundId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Ground using Id " + groundId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Ground business objects
     * @return		Set<Ground>
     */
    @GetMapping("/")
    public List<Ground> loadAll() {                
    	List<Ground> groundList = null;
        
    	try {
            // load the Ground
            groundList = GroundBusinessDelegate.getGroundInstance().getAllGround();
            
            if ( groundList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Grounds" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Grounds ", exc );
        	return null;
        }

        return groundList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Ground ground = null;
    private static final Logger LOGGER = Logger.getLogger(GroundQueryRestController.class.getName());
    
}
