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
 * Implements Spring Controller query CQRS processing for entity Voltage.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Voltage")
public class VoltageQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Voltage using a UUID
     * @param		UUID voltageId
     * @return		Voltage
     */    
    @GetMapping("/load")
    public Voltage load( @RequestParam(required=true) UUID voltageId ) {
    	Voltage entity = null;

    	try {  
    		entity = VoltageBusinessDelegate.getVoltageInstance().getVoltage( new VoltageFetchOneSummary( voltageId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Voltage using Id " + voltageId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Voltage business objects
     * @return		Set<Voltage>
     */
    @GetMapping("/")
    public List<Voltage> loadAll() {                
    	List<Voltage> voltageList = null;
        
    	try {
            // load the Voltage
            voltageList = VoltageBusinessDelegate.getVoltageInstance().getAllVoltage();
            
            if ( voltageList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Voltages" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Voltages ", exc );
        	return null;
        }

        return voltageList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Voltage voltage = null;
    private static final Logger LOGGER = Logger.getLogger(VoltageQueryRestController.class.getName());
    
}
