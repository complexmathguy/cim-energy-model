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
 * Implements Spring Controller query CQRS processing for entity SynchronousMachineDetailed.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SynchronousMachineDetailed")
public class SynchronousMachineDetailedQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a SynchronousMachineDetailed using a UUID
     * @param		UUID synchronousMachineDetailedId
     * @return		SynchronousMachineDetailed
     */    
    @GetMapping("/load")
    public SynchronousMachineDetailed load( @RequestParam(required=true) UUID synchronousMachineDetailedId ) {
    	SynchronousMachineDetailed entity = null;

    	try {  
    		entity = SynchronousMachineDetailedBusinessDelegate.getSynchronousMachineDetailedInstance().getSynchronousMachineDetailed( new SynchronousMachineDetailedFetchOneSummary( synchronousMachineDetailedId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load SynchronousMachineDetailed using Id " + synchronousMachineDetailedId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all SynchronousMachineDetailed business objects
     * @return		Set<SynchronousMachineDetailed>
     */
    @GetMapping("/")
    public List<SynchronousMachineDetailed> loadAll() {                
    	List<SynchronousMachineDetailed> synchronousMachineDetailedList = null;
        
    	try {
            // load the SynchronousMachineDetailed
            synchronousMachineDetailedList = SynchronousMachineDetailedBusinessDelegate.getSynchronousMachineDetailedInstance().getAllSynchronousMachineDetailed();
            
            if ( synchronousMachineDetailedList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all SynchronousMachineDetaileds" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all SynchronousMachineDetaileds ", exc );
        	return null;
        }

        return synchronousMachineDetailedList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected SynchronousMachineDetailed synchronousMachineDetailed = null;
    private static final Logger LOGGER = Logger.getLogger(SynchronousMachineDetailedQueryRestController.class.getName());
    
}
