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
 * Implements Spring Controller query CQRS processing for entity DCTopologicalIsland.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCTopologicalIsland")
public class DCTopologicalIslandQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a DCTopologicalIsland using a UUID
     * @param		UUID dCTopologicalIslandId
     * @return		DCTopologicalIsland
     */    
    @GetMapping("/load")
    public DCTopologicalIsland load( @RequestParam(required=true) UUID dCTopologicalIslandId ) {
    	DCTopologicalIsland entity = null;

    	try {  
    		entity = DCTopologicalIslandBusinessDelegate.getDCTopologicalIslandInstance().getDCTopologicalIsland( new DCTopologicalIslandFetchOneSummary( dCTopologicalIslandId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load DCTopologicalIsland using Id " + dCTopologicalIslandId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all DCTopologicalIsland business objects
     * @return		Set<DCTopologicalIsland>
     */
    @GetMapping("/")
    public List<DCTopologicalIsland> loadAll() {                
    	List<DCTopologicalIsland> dCTopologicalIslandList = null;
        
    	try {
            // load the DCTopologicalIsland
            dCTopologicalIslandList = DCTopologicalIslandBusinessDelegate.getDCTopologicalIslandInstance().getAllDCTopologicalIsland();
            
            if ( dCTopologicalIslandList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all DCTopologicalIslands" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all DCTopologicalIslands ", exc );
        	return null;
        }

        return dCTopologicalIslandList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected DCTopologicalIsland dCTopologicalIsland = null;
    private static final Logger LOGGER = Logger.getLogger(DCTopologicalIslandQueryRestController.class.getName());
    
}
