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
 * Implements Spring Controller query CQRS processing for entity DCConverterUnit.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCConverterUnit")
public class DCConverterUnitQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a DCConverterUnit using a UUID
     * @param		UUID dCConverterUnitId
     * @return		DCConverterUnit
     */    
    @GetMapping("/load")
    public DCConverterUnit load( @RequestParam(required=true) UUID dCConverterUnitId ) {
    	DCConverterUnit entity = null;

    	try {  
    		entity = DCConverterUnitBusinessDelegate.getDCConverterUnitInstance().getDCConverterUnit( new DCConverterUnitFetchOneSummary( dCConverterUnitId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load DCConverterUnit using Id " + dCConverterUnitId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all DCConverterUnit business objects
     * @return		Set<DCConverterUnit>
     */
    @GetMapping("/")
    public List<DCConverterUnit> loadAll() {                
    	List<DCConverterUnit> dCConverterUnitList = null;
        
    	try {
            // load the DCConverterUnit
            dCConverterUnitList = DCConverterUnitBusinessDelegate.getDCConverterUnitInstance().getAllDCConverterUnit();
            
            if ( dCConverterUnitList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all DCConverterUnits" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all DCConverterUnits ", exc );
        	return null;
        }

        return dCConverterUnitList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected DCConverterUnit dCConverterUnit = null;
    private static final Logger LOGGER = Logger.getLogger(DCConverterUnitQueryRestController.class.getName());
    
}
