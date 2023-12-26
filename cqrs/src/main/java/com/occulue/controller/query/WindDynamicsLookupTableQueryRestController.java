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
 * Implements Spring Controller query CQRS processing for entity WindDynamicsLookupTable.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindDynamicsLookupTable")
public class WindDynamicsLookupTableQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a WindDynamicsLookupTable using a UUID
     * @param		UUID windDynamicsLookupTableId
     * @return		WindDynamicsLookupTable
     */    
    @GetMapping("/load")
    public WindDynamicsLookupTable load( @RequestParam(required=true) UUID windDynamicsLookupTableId ) {
    	WindDynamicsLookupTable entity = null;

    	try {  
    		entity = WindDynamicsLookupTableBusinessDelegate.getWindDynamicsLookupTableInstance().getWindDynamicsLookupTable( new WindDynamicsLookupTableFetchOneSummary( windDynamicsLookupTableId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load WindDynamicsLookupTable using Id " + windDynamicsLookupTableId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all WindDynamicsLookupTable business objects
     * @return		Set<WindDynamicsLookupTable>
     */
    @GetMapping("/")
    public List<WindDynamicsLookupTable> loadAll() {                
    	List<WindDynamicsLookupTable> windDynamicsLookupTableList = null;
        
    	try {
            // load the WindDynamicsLookupTable
            windDynamicsLookupTableList = WindDynamicsLookupTableBusinessDelegate.getWindDynamicsLookupTableInstance().getAllWindDynamicsLookupTable();
            
            if ( windDynamicsLookupTableList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all WindDynamicsLookupTables" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all WindDynamicsLookupTables ", exc );
        	return null;
        }

        return windDynamicsLookupTableList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected WindDynamicsLookupTable windDynamicsLookupTable = null;
    private static final Logger LOGGER = Logger.getLogger(WindDynamicsLookupTableQueryRestController.class.getName());
    
}
