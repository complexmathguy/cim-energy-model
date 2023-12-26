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
 * Implements Spring Controller query CQRS processing for entity VoltageCompensatorUserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/VoltageCompensatorUserDefined")
public class VoltageCompensatorUserDefinedQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a VoltageCompensatorUserDefined using a UUID
     * @param		UUID voltageCompensatorUserDefinedId
     * @return		VoltageCompensatorUserDefined
     */    
    @GetMapping("/load")
    public VoltageCompensatorUserDefined load( @RequestParam(required=true) UUID voltageCompensatorUserDefinedId ) {
    	VoltageCompensatorUserDefined entity = null;

    	try {  
    		entity = VoltageCompensatorUserDefinedBusinessDelegate.getVoltageCompensatorUserDefinedInstance().getVoltageCompensatorUserDefined( new VoltageCompensatorUserDefinedFetchOneSummary( voltageCompensatorUserDefinedId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load VoltageCompensatorUserDefined using Id " + voltageCompensatorUserDefinedId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all VoltageCompensatorUserDefined business objects
     * @return		Set<VoltageCompensatorUserDefined>
     */
    @GetMapping("/")
    public List<VoltageCompensatorUserDefined> loadAll() {                
    	List<VoltageCompensatorUserDefined> voltageCompensatorUserDefinedList = null;
        
    	try {
            // load the VoltageCompensatorUserDefined
            voltageCompensatorUserDefinedList = VoltageCompensatorUserDefinedBusinessDelegate.getVoltageCompensatorUserDefinedInstance().getAllVoltageCompensatorUserDefined();
            
            if ( voltageCompensatorUserDefinedList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all VoltageCompensatorUserDefineds" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all VoltageCompensatorUserDefineds ", exc );
        	return null;
        }

        return voltageCompensatorUserDefinedList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected VoltageCompensatorUserDefined voltageCompensatorUserDefined = null;
    private static final Logger LOGGER = Logger.getLogger(VoltageCompensatorUserDefinedQueryRestController.class.getName());
    
}
