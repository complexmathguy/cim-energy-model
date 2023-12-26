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
 * Implements Spring Controller query CQRS processing for entity EquivalentEquipment.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/EquivalentEquipment")
public class EquivalentEquipmentQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a EquivalentEquipment using a UUID
     * @param		UUID equivalentEquipmentId
     * @return		EquivalentEquipment
     */    
    @GetMapping("/load")
    public EquivalentEquipment load( @RequestParam(required=true) UUID equivalentEquipmentId ) {
    	EquivalentEquipment entity = null;

    	try {  
    		entity = EquivalentEquipmentBusinessDelegate.getEquivalentEquipmentInstance().getEquivalentEquipment( new EquivalentEquipmentFetchOneSummary( equivalentEquipmentId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load EquivalentEquipment using Id " + equivalentEquipmentId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all EquivalentEquipment business objects
     * @return		Set<EquivalentEquipment>
     */
    @GetMapping("/")
    public List<EquivalentEquipment> loadAll() {                
    	List<EquivalentEquipment> equivalentEquipmentList = null;
        
    	try {
            // load the EquivalentEquipment
            equivalentEquipmentList = EquivalentEquipmentBusinessDelegate.getEquivalentEquipmentInstance().getAllEquivalentEquipment();
            
            if ( equivalentEquipmentList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all EquivalentEquipments" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all EquivalentEquipments ", exc );
        	return null;
        }

        return equivalentEquipmentList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected EquivalentEquipment equivalentEquipment = null;
    private static final Logger LOGGER = Logger.getLogger(EquivalentEquipmentQueryRestController.class.getName());
    
}
