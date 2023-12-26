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
 * Implements Spring Controller query CQRS processing for entity Junction.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Junction")
public class JunctionQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Junction using a UUID
     * @param		UUID junctionId
     * @return		Junction
     */    
    @GetMapping("/load")
    public Junction load( @RequestParam(required=true) UUID junctionId ) {
    	Junction entity = null;

    	try {  
    		entity = JunctionBusinessDelegate.getJunctionInstance().getJunction( new JunctionFetchOneSummary( junctionId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Junction using Id " + junctionId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Junction business objects
     * @return		Set<Junction>
     */
    @GetMapping("/")
    public List<Junction> loadAll() {                
    	List<Junction> junctionList = null;
        
    	try {
            // load the Junction
            junctionList = JunctionBusinessDelegate.getJunctionInstance().getAllJunction();
            
            if ( junctionList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Junctions" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Junctions ", exc );
        	return null;
        }

        return junctionList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Junction junction = null;
    private static final Logger LOGGER = Logger.getLogger(JunctionQueryRestController.class.getName());
    
}
