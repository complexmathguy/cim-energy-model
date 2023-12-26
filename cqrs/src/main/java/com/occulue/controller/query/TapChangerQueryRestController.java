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
 * Implements Spring Controller query CQRS processing for entity TapChanger.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TapChanger")
public class TapChangerQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a TapChanger using a UUID
     * @param		UUID tapChangerId
     * @return		TapChanger
     */    
    @GetMapping("/load")
    public TapChanger load( @RequestParam(required=true) UUID tapChangerId ) {
    	TapChanger entity = null;

    	try {  
    		entity = TapChangerBusinessDelegate.getTapChangerInstance().getTapChanger( new TapChangerFetchOneSummary( tapChangerId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load TapChanger using Id " + tapChangerId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all TapChanger business objects
     * @return		Set<TapChanger>
     */
    @GetMapping("/")
    public List<TapChanger> loadAll() {                
    	List<TapChanger> tapChangerList = null;
        
    	try {
            // load the TapChanger
            tapChangerList = TapChangerBusinessDelegate.getTapChangerInstance().getAllTapChanger();
            
            if ( tapChangerList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all TapChangers" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all TapChangers ", exc );
        	return null;
        }

        return tapChangerList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected TapChanger tapChanger = null;
    private static final Logger LOGGER = Logger.getLogger(TapChangerQueryRestController.class.getName());
    
}
