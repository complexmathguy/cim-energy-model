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
 * Implements Spring Controller query CQRS processing for entity VoltageAdjusterUserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/VoltageAdjusterUserDefined")
public class VoltageAdjusterUserDefinedQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a VoltageAdjusterUserDefined using a UUID
     * @param		UUID voltageAdjusterUserDefinedId
     * @return		VoltageAdjusterUserDefined
     */    
    @GetMapping("/load")
    public VoltageAdjusterUserDefined load( @RequestParam(required=true) UUID voltageAdjusterUserDefinedId ) {
    	VoltageAdjusterUserDefined entity = null;

    	try {  
    		entity = VoltageAdjusterUserDefinedBusinessDelegate.getVoltageAdjusterUserDefinedInstance().getVoltageAdjusterUserDefined( new VoltageAdjusterUserDefinedFetchOneSummary( voltageAdjusterUserDefinedId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load VoltageAdjusterUserDefined using Id " + voltageAdjusterUserDefinedId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all VoltageAdjusterUserDefined business objects
     * @return		Set<VoltageAdjusterUserDefined>
     */
    @GetMapping("/")
    public List<VoltageAdjusterUserDefined> loadAll() {                
    	List<VoltageAdjusterUserDefined> voltageAdjusterUserDefinedList = null;
        
    	try {
            // load the VoltageAdjusterUserDefined
            voltageAdjusterUserDefinedList = VoltageAdjusterUserDefinedBusinessDelegate.getVoltageAdjusterUserDefinedInstance().getAllVoltageAdjusterUserDefined();
            
            if ( voltageAdjusterUserDefinedList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all VoltageAdjusterUserDefineds" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all VoltageAdjusterUserDefineds ", exc );
        	return null;
        }

        return voltageAdjusterUserDefinedList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected VoltageAdjusterUserDefined voltageAdjusterUserDefined = null;
    private static final Logger LOGGER = Logger.getLogger(VoltageAdjusterUserDefinedQueryRestController.class.getName());
    
}
