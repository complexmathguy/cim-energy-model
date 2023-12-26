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
 * Implements Spring Controller query CQRS processing for entity ControlAreaGeneratingUnit.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ControlAreaGeneratingUnit")
public class ControlAreaGeneratingUnitQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ControlAreaGeneratingUnit using a UUID
     * @param		UUID controlAreaGeneratingUnitId
     * @return		ControlAreaGeneratingUnit
     */    
    @GetMapping("/load")
    public ControlAreaGeneratingUnit load( @RequestParam(required=true) UUID controlAreaGeneratingUnitId ) {
    	ControlAreaGeneratingUnit entity = null;

    	try {  
    		entity = ControlAreaGeneratingUnitBusinessDelegate.getControlAreaGeneratingUnitInstance().getControlAreaGeneratingUnit( new ControlAreaGeneratingUnitFetchOneSummary( controlAreaGeneratingUnitId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ControlAreaGeneratingUnit using Id " + controlAreaGeneratingUnitId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ControlAreaGeneratingUnit business objects
     * @return		Set<ControlAreaGeneratingUnit>
     */
    @GetMapping("/")
    public List<ControlAreaGeneratingUnit> loadAll() {                
    	List<ControlAreaGeneratingUnit> controlAreaGeneratingUnitList = null;
        
    	try {
            // load the ControlAreaGeneratingUnit
            controlAreaGeneratingUnitList = ControlAreaGeneratingUnitBusinessDelegate.getControlAreaGeneratingUnitInstance().getAllControlAreaGeneratingUnit();
            
            if ( controlAreaGeneratingUnitList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ControlAreaGeneratingUnits" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ControlAreaGeneratingUnits ", exc );
        	return null;
        }

        return controlAreaGeneratingUnitList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ControlAreaGeneratingUnit controlAreaGeneratingUnit = null;
    private static final Logger LOGGER = Logger.getLogger(ControlAreaGeneratingUnitQueryRestController.class.getName());
    
}
