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
 * Implements Spring Controller query CQRS processing for entity DCEquipmentContainer.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCEquipmentContainer")
public class DCEquipmentContainerQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a DCEquipmentContainer using a UUID
     * @param		UUID dCEquipmentContainerId
     * @return		DCEquipmentContainer
     */    
    @GetMapping("/load")
    public DCEquipmentContainer load( @RequestParam(required=true) UUID dCEquipmentContainerId ) {
    	DCEquipmentContainer entity = null;

    	try {  
    		entity = DCEquipmentContainerBusinessDelegate.getDCEquipmentContainerInstance().getDCEquipmentContainer( new DCEquipmentContainerFetchOneSummary( dCEquipmentContainerId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load DCEquipmentContainer using Id " + dCEquipmentContainerId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all DCEquipmentContainer business objects
     * @return		Set<DCEquipmentContainer>
     */
    @GetMapping("/")
    public List<DCEquipmentContainer> loadAll() {                
    	List<DCEquipmentContainer> dCEquipmentContainerList = null;
        
    	try {
            // load the DCEquipmentContainer
            dCEquipmentContainerList = DCEquipmentContainerBusinessDelegate.getDCEquipmentContainerInstance().getAllDCEquipmentContainer();
            
            if ( dCEquipmentContainerList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all DCEquipmentContainers" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all DCEquipmentContainers ", exc );
        	return null;
        }

        return dCEquipmentContainerList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected DCEquipmentContainer dCEquipmentContainer = null;
    private static final Logger LOGGER = Logger.getLogger(DCEquipmentContainerQueryRestController.class.getName());
    
}
