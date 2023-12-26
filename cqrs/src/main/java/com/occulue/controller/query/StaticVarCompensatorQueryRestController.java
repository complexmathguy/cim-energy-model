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
 * Implements Spring Controller query CQRS processing for entity StaticVarCompensator.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/StaticVarCompensator")
public class StaticVarCompensatorQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a StaticVarCompensator using a UUID
     * @param		UUID staticVarCompensatorId
     * @return		StaticVarCompensator
     */    
    @GetMapping("/load")
    public StaticVarCompensator load( @RequestParam(required=true) UUID staticVarCompensatorId ) {
    	StaticVarCompensator entity = null;

    	try {  
    		entity = StaticVarCompensatorBusinessDelegate.getStaticVarCompensatorInstance().getStaticVarCompensator( new StaticVarCompensatorFetchOneSummary( staticVarCompensatorId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load StaticVarCompensator using Id " + staticVarCompensatorId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all StaticVarCompensator business objects
     * @return		Set<StaticVarCompensator>
     */
    @GetMapping("/")
    public List<StaticVarCompensator> loadAll() {                
    	List<StaticVarCompensator> staticVarCompensatorList = null;
        
    	try {
            // load the StaticVarCompensator
            staticVarCompensatorList = StaticVarCompensatorBusinessDelegate.getStaticVarCompensatorInstance().getAllStaticVarCompensator();
            
            if ( staticVarCompensatorList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all StaticVarCompensators" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all StaticVarCompensators ", exc );
        	return null;
        }

        return staticVarCompensatorList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected StaticVarCompensator staticVarCompensator = null;
    private static final Logger LOGGER = Logger.getLogger(StaticVarCompensatorQueryRestController.class.getName());
    
}
