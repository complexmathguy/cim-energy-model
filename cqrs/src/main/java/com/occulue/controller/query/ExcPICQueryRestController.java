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
 * Implements Spring Controller query CQRS processing for entity ExcPIC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcPIC")
public class ExcPICQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcPIC using a UUID
     * @param		UUID excPICId
     * @return		ExcPIC
     */    
    @GetMapping("/load")
    public ExcPIC load( @RequestParam(required=true) UUID excPICId ) {
    	ExcPIC entity = null;

    	try {  
    		entity = ExcPICBusinessDelegate.getExcPICInstance().getExcPIC( new ExcPICFetchOneSummary( excPICId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcPIC using Id " + excPICId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcPIC business objects
     * @return		Set<ExcPIC>
     */
    @GetMapping("/")
    public List<ExcPIC> loadAll() {                
    	List<ExcPIC> excPICList = null;
        
    	try {
            // load the ExcPIC
            excPICList = ExcPICBusinessDelegate.getExcPICInstance().getAllExcPIC();
            
            if ( excPICList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcPICs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcPICs ", exc );
        	return null;
        }

        return excPICList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcPIC excPIC = null;
    private static final Logger LOGGER = Logger.getLogger(ExcPICQueryRestController.class.getName());
    
}
