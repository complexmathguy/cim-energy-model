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
 * Implements Spring Controller query CQRS processing for entity LoadArea.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/LoadArea")
public class LoadAreaQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a LoadArea using a UUID
     * @param		UUID loadAreaId
     * @return		LoadArea
     */    
    @GetMapping("/load")
    public LoadArea load( @RequestParam(required=true) UUID loadAreaId ) {
    	LoadArea entity = null;

    	try {  
    		entity = LoadAreaBusinessDelegate.getLoadAreaInstance().getLoadArea( new LoadAreaFetchOneSummary( loadAreaId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load LoadArea using Id " + loadAreaId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all LoadArea business objects
     * @return		Set<LoadArea>
     */
    @GetMapping("/")
    public List<LoadArea> loadAll() {                
    	List<LoadArea> loadAreaList = null;
        
    	try {
            // load the LoadArea
            loadAreaList = LoadAreaBusinessDelegate.getLoadAreaInstance().getAllLoadArea();
            
            if ( loadAreaList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all LoadAreas" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all LoadAreas ", exc );
        	return null;
        }

        return loadAreaList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected LoadArea loadArea = null;
    private static final Logger LOGGER = Logger.getLogger(LoadAreaQueryRestController.class.getName());
    
}
