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
 * Implements Spring Controller query CQRS processing for entity MechanicalLoadUserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/MechanicalLoadUserDefined")
public class MechanicalLoadUserDefinedQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a MechanicalLoadUserDefined using a UUID
     * @param		UUID mechanicalLoadUserDefinedId
     * @return		MechanicalLoadUserDefined
     */    
    @GetMapping("/load")
    public MechanicalLoadUserDefined load( @RequestParam(required=true) UUID mechanicalLoadUserDefinedId ) {
    	MechanicalLoadUserDefined entity = null;

    	try {  
    		entity = MechanicalLoadUserDefinedBusinessDelegate.getMechanicalLoadUserDefinedInstance().getMechanicalLoadUserDefined( new MechanicalLoadUserDefinedFetchOneSummary( mechanicalLoadUserDefinedId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load MechanicalLoadUserDefined using Id " + mechanicalLoadUserDefinedId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all MechanicalLoadUserDefined business objects
     * @return		Set<MechanicalLoadUserDefined>
     */
    @GetMapping("/")
    public List<MechanicalLoadUserDefined> loadAll() {                
    	List<MechanicalLoadUserDefined> mechanicalLoadUserDefinedList = null;
        
    	try {
            // load the MechanicalLoadUserDefined
            mechanicalLoadUserDefinedList = MechanicalLoadUserDefinedBusinessDelegate.getMechanicalLoadUserDefinedInstance().getAllMechanicalLoadUserDefined();
            
            if ( mechanicalLoadUserDefinedList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all MechanicalLoadUserDefineds" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all MechanicalLoadUserDefineds ", exc );
        	return null;
        }

        return mechanicalLoadUserDefinedList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected MechanicalLoadUserDefined mechanicalLoadUserDefined = null;
    private static final Logger LOGGER = Logger.getLogger(MechanicalLoadUserDefinedQueryRestController.class.getName());
    
}
