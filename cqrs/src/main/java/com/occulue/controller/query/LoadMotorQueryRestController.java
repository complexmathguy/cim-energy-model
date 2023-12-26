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
 * Implements Spring Controller query CQRS processing for entity LoadMotor.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/LoadMotor")
public class LoadMotorQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a LoadMotor using a UUID
     * @param		UUID loadMotorId
     * @return		LoadMotor
     */    
    @GetMapping("/load")
    public LoadMotor load( @RequestParam(required=true) UUID loadMotorId ) {
    	LoadMotor entity = null;

    	try {  
    		entity = LoadMotorBusinessDelegate.getLoadMotorInstance().getLoadMotor( new LoadMotorFetchOneSummary( loadMotorId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load LoadMotor using Id " + loadMotorId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all LoadMotor business objects
     * @return		Set<LoadMotor>
     */
    @GetMapping("/")
    public List<LoadMotor> loadAll() {                
    	List<LoadMotor> loadMotorList = null;
        
    	try {
            // load the LoadMotor
            loadMotorList = LoadMotorBusinessDelegate.getLoadMotorInstance().getAllLoadMotor();
            
            if ( loadMotorList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all LoadMotors" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all LoadMotors ", exc );
        	return null;
        }

        return loadMotorList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected LoadMotor loadMotor = null;
    private static final Logger LOGGER = Logger.getLogger(LoadMotorQueryRestController.class.getName());
    
}
