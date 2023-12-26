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
 * Implements Spring Controller query CQRS processing for entity SvVoltage.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SvVoltage")
public class SvVoltageQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a SvVoltage using a UUID
     * @param		UUID svVoltageId
     * @return		SvVoltage
     */    
    @GetMapping("/load")
    public SvVoltage load( @RequestParam(required=true) UUID svVoltageId ) {
    	SvVoltage entity = null;

    	try {  
    		entity = SvVoltageBusinessDelegate.getSvVoltageInstance().getSvVoltage( new SvVoltageFetchOneSummary( svVoltageId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load SvVoltage using Id " + svVoltageId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all SvVoltage business objects
     * @return		Set<SvVoltage>
     */
    @GetMapping("/")
    public List<SvVoltage> loadAll() {                
    	List<SvVoltage> svVoltageList = null;
        
    	try {
            // load the SvVoltage
            svVoltageList = SvVoltageBusinessDelegate.getSvVoltageInstance().getAllSvVoltage();
            
            if ( svVoltageList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all SvVoltages" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all SvVoltages ", exc );
        	return null;
        }

        return svVoltageList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected SvVoltage svVoltage = null;
    private static final Logger LOGGER = Logger.getLogger(SvVoltageQueryRestController.class.getName());
    
}
