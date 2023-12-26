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
 * Implements Spring Controller query CQRS processing for entity MechanicalLoadDynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/MechanicalLoadDynamics")
public class MechanicalLoadDynamicsQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a MechanicalLoadDynamics using a UUID
     * @param		UUID mechanicalLoadDynamicsId
     * @return		MechanicalLoadDynamics
     */    
    @GetMapping("/load")
    public MechanicalLoadDynamics load( @RequestParam(required=true) UUID mechanicalLoadDynamicsId ) {
    	MechanicalLoadDynamics entity = null;

    	try {  
    		entity = MechanicalLoadDynamicsBusinessDelegate.getMechanicalLoadDynamicsInstance().getMechanicalLoadDynamics( new MechanicalLoadDynamicsFetchOneSummary( mechanicalLoadDynamicsId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load MechanicalLoadDynamics using Id " + mechanicalLoadDynamicsId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all MechanicalLoadDynamics business objects
     * @return		Set<MechanicalLoadDynamics>
     */
    @GetMapping("/")
    public List<MechanicalLoadDynamics> loadAll() {                
    	List<MechanicalLoadDynamics> mechanicalLoadDynamicsList = null;
        
    	try {
            // load the MechanicalLoadDynamics
            mechanicalLoadDynamicsList = MechanicalLoadDynamicsBusinessDelegate.getMechanicalLoadDynamicsInstance().getAllMechanicalLoadDynamics();
            
            if ( mechanicalLoadDynamicsList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all MechanicalLoadDynamicss" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all MechanicalLoadDynamicss ", exc );
        	return null;
        }

        return mechanicalLoadDynamicsList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected MechanicalLoadDynamics mechanicalLoadDynamics = null;
    private static final Logger LOGGER = Logger.getLogger(MechanicalLoadDynamicsQueryRestController.class.getName());
    
}
