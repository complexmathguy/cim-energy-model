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
 * Implements Spring Controller query CQRS processing for entity EquipmentBoundaryVersion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/EquipmentBoundaryVersion")
public class EquipmentBoundaryVersionQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a EquipmentBoundaryVersion using a UUID
     * @param		UUID equipmentBoundaryVersionId
     * @return		EquipmentBoundaryVersion
     */    
    @GetMapping("/load")
    public EquipmentBoundaryVersion load( @RequestParam(required=true) UUID equipmentBoundaryVersionId ) {
    	EquipmentBoundaryVersion entity = null;

    	try {  
    		entity = EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance().getEquipmentBoundaryVersion( new EquipmentBoundaryVersionFetchOneSummary( equipmentBoundaryVersionId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load EquipmentBoundaryVersion using Id " + equipmentBoundaryVersionId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all EquipmentBoundaryVersion business objects
     * @return		Set<EquipmentBoundaryVersion>
     */
    @GetMapping("/")
    public List<EquipmentBoundaryVersion> loadAll() {                
    	List<EquipmentBoundaryVersion> equipmentBoundaryVersionList = null;
        
    	try {
            // load the EquipmentBoundaryVersion
            equipmentBoundaryVersionList = EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance().getAllEquipmentBoundaryVersion();
            
            if ( equipmentBoundaryVersionList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all EquipmentBoundaryVersions" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all EquipmentBoundaryVersions ", exc );
        	return null;
        }

        return equipmentBoundaryVersionList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected EquipmentBoundaryVersion equipmentBoundaryVersion = null;
    private static final Logger LOGGER = Logger.getLogger(EquipmentBoundaryVersionQueryRestController.class.getName());
    
}
