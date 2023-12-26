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
 * Implements Spring Controller query CQRS processing for entity LoadBreakSwitch.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/LoadBreakSwitch")
public class LoadBreakSwitchQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a LoadBreakSwitch using a UUID
     * @param		UUID loadBreakSwitchId
     * @return		LoadBreakSwitch
     */    
    @GetMapping("/load")
    public LoadBreakSwitch load( @RequestParam(required=true) UUID loadBreakSwitchId ) {
    	LoadBreakSwitch entity = null;

    	try {  
    		entity = LoadBreakSwitchBusinessDelegate.getLoadBreakSwitchInstance().getLoadBreakSwitch( new LoadBreakSwitchFetchOneSummary( loadBreakSwitchId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load LoadBreakSwitch using Id " + loadBreakSwitchId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all LoadBreakSwitch business objects
     * @return		Set<LoadBreakSwitch>
     */
    @GetMapping("/")
    public List<LoadBreakSwitch> loadAll() {                
    	List<LoadBreakSwitch> loadBreakSwitchList = null;
        
    	try {
            // load the LoadBreakSwitch
            loadBreakSwitchList = LoadBreakSwitchBusinessDelegate.getLoadBreakSwitchInstance().getAllLoadBreakSwitch();
            
            if ( loadBreakSwitchList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all LoadBreakSwitchs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all LoadBreakSwitchs ", exc );
        	return null;
        }

        return loadBreakSwitchList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected LoadBreakSwitch loadBreakSwitch = null;
    private static final Logger LOGGER = Logger.getLogger(LoadBreakSwitchQueryRestController.class.getName());
    
}
