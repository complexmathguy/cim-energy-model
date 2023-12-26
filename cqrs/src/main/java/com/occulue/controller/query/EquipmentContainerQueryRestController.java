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
 * Implements Spring Controller query CQRS processing for entity EquipmentContainer.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/EquipmentContainer")
public class EquipmentContainerQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a EquipmentContainer using a UUID
     * @param		UUID equipmentContainerId
     * @return		EquipmentContainer
     */    
    @GetMapping("/load")
    public EquipmentContainer load( @RequestParam(required=true) UUID equipmentContainerId ) {
    	EquipmentContainer entity = null;

    	try {  
    		entity = EquipmentContainerBusinessDelegate.getEquipmentContainerInstance().getEquipmentContainer( new EquipmentContainerFetchOneSummary( equipmentContainerId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load EquipmentContainer using Id " + equipmentContainerId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all EquipmentContainer business objects
     * @return		Set<EquipmentContainer>
     */
    @GetMapping("/")
    public List<EquipmentContainer> loadAll() {                
    	List<EquipmentContainer> equipmentContainerList = null;
        
    	try {
            // load the EquipmentContainer
            equipmentContainerList = EquipmentContainerBusinessDelegate.getEquipmentContainerInstance().getAllEquipmentContainer();
            
            if ( equipmentContainerList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all EquipmentContainers" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all EquipmentContainers ", exc );
        	return null;
        }

        return equipmentContainerList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected EquipmentContainer equipmentContainer = null;
    private static final Logger LOGGER = Logger.getLogger(EquipmentContainerQueryRestController.class.getName());
    
}
