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
 * Implements Spring Controller query CQRS processing for entity TapChangerControl.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TapChangerControl")
public class TapChangerControlQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a TapChangerControl using a UUID
     * @param		UUID tapChangerControlId
     * @return		TapChangerControl
     */    
    @GetMapping("/load")
    public TapChangerControl load( @RequestParam(required=true) UUID tapChangerControlId ) {
    	TapChangerControl entity = null;

    	try {  
    		entity = TapChangerControlBusinessDelegate.getTapChangerControlInstance().getTapChangerControl( new TapChangerControlFetchOneSummary( tapChangerControlId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load TapChangerControl using Id " + tapChangerControlId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all TapChangerControl business objects
     * @return		Set<TapChangerControl>
     */
    @GetMapping("/")
    public List<TapChangerControl> loadAll() {                
    	List<TapChangerControl> tapChangerControlList = null;
        
    	try {
            // load the TapChangerControl
            tapChangerControlList = TapChangerControlBusinessDelegate.getTapChangerControlInstance().getAllTapChangerControl();
            
            if ( tapChangerControlList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all TapChangerControls" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all TapChangerControls ", exc );
        	return null;
        }

        return tapChangerControlList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected TapChangerControl tapChangerControl = null;
    private static final Logger LOGGER = Logger.getLogger(TapChangerControlQueryRestController.class.getName());
    
}
