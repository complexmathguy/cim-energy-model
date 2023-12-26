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
 * Implements Spring Controller query CQRS processing for entity DCConductingEquipment.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCConductingEquipment")
public class DCConductingEquipmentQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a DCConductingEquipment using a UUID
     * @param		UUID dCConductingEquipmentId
     * @return		DCConductingEquipment
     */    
    @GetMapping("/load")
    public DCConductingEquipment load( @RequestParam(required=true) UUID dCConductingEquipmentId ) {
    	DCConductingEquipment entity = null;

    	try {  
    		entity = DCConductingEquipmentBusinessDelegate.getDCConductingEquipmentInstance().getDCConductingEquipment( new DCConductingEquipmentFetchOneSummary( dCConductingEquipmentId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load DCConductingEquipment using Id " + dCConductingEquipmentId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all DCConductingEquipment business objects
     * @return		Set<DCConductingEquipment>
     */
    @GetMapping("/")
    public List<DCConductingEquipment> loadAll() {                
    	List<DCConductingEquipment> dCConductingEquipmentList = null;
        
    	try {
            // load the DCConductingEquipment
            dCConductingEquipmentList = DCConductingEquipmentBusinessDelegate.getDCConductingEquipmentInstance().getAllDCConductingEquipment();
            
            if ( dCConductingEquipmentList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all DCConductingEquipments" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all DCConductingEquipments ", exc );
        	return null;
        }

        return dCConductingEquipmentList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected DCConductingEquipment dCConductingEquipment = null;
    private static final Logger LOGGER = Logger.getLogger(DCConductingEquipmentQueryRestController.class.getName());
    
}
