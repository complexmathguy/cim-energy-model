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
 * Implements Spring Controller query CQRS processing for entity ConductingEquipment.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ConductingEquipment")
public class ConductingEquipmentQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ConductingEquipment using a UUID
     * @param		UUID conductingEquipmentId
     * @return		ConductingEquipment
     */    
    @GetMapping("/load")
    public ConductingEquipment load( @RequestParam(required=true) UUID conductingEquipmentId ) {
    	ConductingEquipment entity = null;

    	try {  
    		entity = ConductingEquipmentBusinessDelegate.getConductingEquipmentInstance().getConductingEquipment( new ConductingEquipmentFetchOneSummary( conductingEquipmentId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ConductingEquipment using Id " + conductingEquipmentId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ConductingEquipment business objects
     * @return		Set<ConductingEquipment>
     */
    @GetMapping("/")
    public List<ConductingEquipment> loadAll() {                
    	List<ConductingEquipment> conductingEquipmentList = null;
        
    	try {
            // load the ConductingEquipment
            conductingEquipmentList = ConductingEquipmentBusinessDelegate.getConductingEquipmentInstance().getAllConductingEquipment();
            
            if ( conductingEquipmentList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ConductingEquipments" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ConductingEquipments ", exc );
        	return null;
        }

        return conductingEquipmentList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ConductingEquipment conductingEquipment = null;
    private static final Logger LOGGER = Logger.getLogger(ConductingEquipmentQueryRestController.class.getName());
    
}
