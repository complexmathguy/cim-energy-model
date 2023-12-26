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
 * Implements Spring Controller query CQRS processing for entity LinearShuntCompensator.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/LinearShuntCompensator")
public class LinearShuntCompensatorQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a LinearShuntCompensator using a UUID
     * @param		UUID linearShuntCompensatorId
     * @return		LinearShuntCompensator
     */    
    @GetMapping("/load")
    public LinearShuntCompensator load( @RequestParam(required=true) UUID linearShuntCompensatorId ) {
    	LinearShuntCompensator entity = null;

    	try {  
    		entity = LinearShuntCompensatorBusinessDelegate.getLinearShuntCompensatorInstance().getLinearShuntCompensator( new LinearShuntCompensatorFetchOneSummary( linearShuntCompensatorId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load LinearShuntCompensator using Id " + linearShuntCompensatorId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all LinearShuntCompensator business objects
     * @return		Set<LinearShuntCompensator>
     */
    @GetMapping("/")
    public List<LinearShuntCompensator> loadAll() {                
    	List<LinearShuntCompensator> linearShuntCompensatorList = null;
        
    	try {
            // load the LinearShuntCompensator
            linearShuntCompensatorList = LinearShuntCompensatorBusinessDelegate.getLinearShuntCompensatorInstance().getAllLinearShuntCompensator();
            
            if ( linearShuntCompensatorList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all LinearShuntCompensators" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all LinearShuntCompensators ", exc );
        	return null;
        }

        return linearShuntCompensatorList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected LinearShuntCompensator linearShuntCompensator = null;
    private static final Logger LOGGER = Logger.getLogger(LinearShuntCompensatorQueryRestController.class.getName());
    
}
