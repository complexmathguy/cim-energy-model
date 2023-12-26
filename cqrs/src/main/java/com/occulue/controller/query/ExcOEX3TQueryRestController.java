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
 * Implements Spring Controller query CQRS processing for entity ExcOEX3T.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcOEX3T")
public class ExcOEX3TQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcOEX3T using a UUID
     * @param		UUID excOEX3TId
     * @return		ExcOEX3T
     */    
    @GetMapping("/load")
    public ExcOEX3T load( @RequestParam(required=true) UUID excOEX3TId ) {
    	ExcOEX3T entity = null;

    	try {  
    		entity = ExcOEX3TBusinessDelegate.getExcOEX3TInstance().getExcOEX3T( new ExcOEX3TFetchOneSummary( excOEX3TId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcOEX3T using Id " + excOEX3TId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcOEX3T business objects
     * @return		Set<ExcOEX3T>
     */
    @GetMapping("/")
    public List<ExcOEX3T> loadAll() {                
    	List<ExcOEX3T> excOEX3TList = null;
        
    	try {
            // load the ExcOEX3T
            excOEX3TList = ExcOEX3TBusinessDelegate.getExcOEX3TInstance().getAllExcOEX3T();
            
            if ( excOEX3TList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcOEX3Ts" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcOEX3Ts ", exc );
        	return null;
        }

        return excOEX3TList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcOEX3T excOEX3T = null;
    private static final Logger LOGGER = Logger.getLogger(ExcOEX3TQueryRestController.class.getName());
    
}
