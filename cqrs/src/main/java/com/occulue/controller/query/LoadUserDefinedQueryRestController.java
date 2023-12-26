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
 * Implements Spring Controller query CQRS processing for entity LoadUserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/LoadUserDefined")
public class LoadUserDefinedQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a LoadUserDefined using a UUID
     * @param		UUID loadUserDefinedId
     * @return		LoadUserDefined
     */    
    @GetMapping("/load")
    public LoadUserDefined load( @RequestParam(required=true) UUID loadUserDefinedId ) {
    	LoadUserDefined entity = null;

    	try {  
    		entity = LoadUserDefinedBusinessDelegate.getLoadUserDefinedInstance().getLoadUserDefined( new LoadUserDefinedFetchOneSummary( loadUserDefinedId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load LoadUserDefined using Id " + loadUserDefinedId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all LoadUserDefined business objects
     * @return		Set<LoadUserDefined>
     */
    @GetMapping("/")
    public List<LoadUserDefined> loadAll() {                
    	List<LoadUserDefined> loadUserDefinedList = null;
        
    	try {
            // load the LoadUserDefined
            loadUserDefinedList = LoadUserDefinedBusinessDelegate.getLoadUserDefinedInstance().getAllLoadUserDefined();
            
            if ( loadUserDefinedList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all LoadUserDefineds" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all LoadUserDefineds ", exc );
        	return null;
        }

        return loadUserDefinedList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected LoadUserDefined loadUserDefined = null;
    private static final Logger LOGGER = Logger.getLogger(LoadUserDefinedQueryRestController.class.getName());
    
}
