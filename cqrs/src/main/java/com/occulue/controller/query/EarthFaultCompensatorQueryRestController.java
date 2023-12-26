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
 * Implements Spring Controller query CQRS processing for entity EarthFaultCompensator.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/EarthFaultCompensator")
public class EarthFaultCompensatorQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a EarthFaultCompensator using a UUID
     * @param		UUID earthFaultCompensatorId
     * @return		EarthFaultCompensator
     */    
    @GetMapping("/load")
    public EarthFaultCompensator load( @RequestParam(required=true) UUID earthFaultCompensatorId ) {
    	EarthFaultCompensator entity = null;

    	try {  
    		entity = EarthFaultCompensatorBusinessDelegate.getEarthFaultCompensatorInstance().getEarthFaultCompensator( new EarthFaultCompensatorFetchOneSummary( earthFaultCompensatorId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load EarthFaultCompensator using Id " + earthFaultCompensatorId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all EarthFaultCompensator business objects
     * @return		Set<EarthFaultCompensator>
     */
    @GetMapping("/")
    public List<EarthFaultCompensator> loadAll() {                
    	List<EarthFaultCompensator> earthFaultCompensatorList = null;
        
    	try {
            // load the EarthFaultCompensator
            earthFaultCompensatorList = EarthFaultCompensatorBusinessDelegate.getEarthFaultCompensatorInstance().getAllEarthFaultCompensator();
            
            if ( earthFaultCompensatorList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all EarthFaultCompensators" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all EarthFaultCompensators ", exc );
        	return null;
        }

        return earthFaultCompensatorList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected EarthFaultCompensator earthFaultCompensator = null;
    private static final Logger LOGGER = Logger.getLogger(EarthFaultCompensatorQueryRestController.class.getName());
    
}
