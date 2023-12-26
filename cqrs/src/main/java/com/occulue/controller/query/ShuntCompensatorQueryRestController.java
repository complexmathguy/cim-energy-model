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
 * Implements Spring Controller query CQRS processing for entity ShuntCompensator.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ShuntCompensator")
public class ShuntCompensatorQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ShuntCompensator using a UUID
     * @param		UUID shuntCompensatorId
     * @return		ShuntCompensator
     */    
    @GetMapping("/load")
    public ShuntCompensator load( @RequestParam(required=true) UUID shuntCompensatorId ) {
    	ShuntCompensator entity = null;

    	try {  
    		entity = ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance().getShuntCompensator( new ShuntCompensatorFetchOneSummary( shuntCompensatorId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ShuntCompensator using Id " + shuntCompensatorId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ShuntCompensator business objects
     * @return		Set<ShuntCompensator>
     */
    @GetMapping("/")
    public List<ShuntCompensator> loadAll() {                
    	List<ShuntCompensator> shuntCompensatorList = null;
        
    	try {
            // load the ShuntCompensator
            shuntCompensatorList = ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance().getAllShuntCompensator();
            
            if ( shuntCompensatorList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ShuntCompensators" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ShuntCompensators ", exc );
        	return null;
        }

        return shuntCompensatorList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ShuntCompensator shuntCompensator = null;
    private static final Logger LOGGER = Logger.getLogger(ShuntCompensatorQueryRestController.class.getName());
    
}
