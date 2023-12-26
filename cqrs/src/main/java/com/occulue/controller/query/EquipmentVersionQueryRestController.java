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
 * Implements Spring Controller query CQRS processing for entity EquipmentVersion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/EquipmentVersion")
public class EquipmentVersionQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a EquipmentVersion using a UUID
     * @param		UUID equipmentVersionId
     * @return		EquipmentVersion
     */    
    @GetMapping("/load")
    public EquipmentVersion load( @RequestParam(required=true) UUID equipmentVersionId ) {
    	EquipmentVersion entity = null;

    	try {  
    		entity = EquipmentVersionBusinessDelegate.getEquipmentVersionInstance().getEquipmentVersion( new EquipmentVersionFetchOneSummary( equipmentVersionId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load EquipmentVersion using Id " + equipmentVersionId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all EquipmentVersion business objects
     * @return		Set<EquipmentVersion>
     */
    @GetMapping("/")
    public List<EquipmentVersion> loadAll() {                
    	List<EquipmentVersion> equipmentVersionList = null;
        
    	try {
            // load the EquipmentVersion
            equipmentVersionList = EquipmentVersionBusinessDelegate.getEquipmentVersionInstance().getAllEquipmentVersion();
            
            if ( equipmentVersionList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all EquipmentVersions" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all EquipmentVersions ", exc );
        	return null;
        }

        return equipmentVersionList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected EquipmentVersion equipmentVersion = null;
    private static final Logger LOGGER = Logger.getLogger(EquipmentVersionQueryRestController.class.getName());
    
}
