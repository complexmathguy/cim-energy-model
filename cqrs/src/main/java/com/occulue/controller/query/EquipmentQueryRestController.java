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
 * Implements Spring Controller query CQRS processing for entity Equipment.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Equipment")
public class EquipmentQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Equipment using a UUID
     * @param		UUID equipmentId
     * @return		Equipment
     */    
    @GetMapping("/load")
    public Equipment load( @RequestParam(required=true) UUID equipmentId ) {
    	Equipment entity = null;

    	try {  
    		entity = EquipmentBusinessDelegate.getEquipmentInstance().getEquipment( new EquipmentFetchOneSummary( equipmentId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Equipment using Id " + equipmentId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Equipment business objects
     * @return		Set<Equipment>
     */
    @GetMapping("/")
    public List<Equipment> loadAll() {                
    	List<Equipment> equipmentList = null;
        
    	try {
            // load the Equipment
            equipmentList = EquipmentBusinessDelegate.getEquipmentInstance().getAllEquipment();
            
            if ( equipmentList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Equipments" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Equipments ", exc );
        	return null;
        }

        return equipmentList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Equipment equipment = null;
    private static final Logger LOGGER = Logger.getLogger(EquipmentQueryRestController.class.getName());
    
}
