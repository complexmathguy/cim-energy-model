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
 * Implements Spring Controller query CQRS processing for entity PhaseTapChangerTable.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PhaseTapChangerTable")
public class PhaseTapChangerTableQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a PhaseTapChangerTable using a UUID
     * @param		UUID phaseTapChangerTableId
     * @return		PhaseTapChangerTable
     */    
    @GetMapping("/load")
    public PhaseTapChangerTable load( @RequestParam(required=true) UUID phaseTapChangerTableId ) {
    	PhaseTapChangerTable entity = null;

    	try {  
    		entity = PhaseTapChangerTableBusinessDelegate.getPhaseTapChangerTableInstance().getPhaseTapChangerTable( new PhaseTapChangerTableFetchOneSummary( phaseTapChangerTableId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load PhaseTapChangerTable using Id " + phaseTapChangerTableId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all PhaseTapChangerTable business objects
     * @return		Set<PhaseTapChangerTable>
     */
    @GetMapping("/")
    public List<PhaseTapChangerTable> loadAll() {                
    	List<PhaseTapChangerTable> phaseTapChangerTableList = null;
        
    	try {
            // load the PhaseTapChangerTable
            phaseTapChangerTableList = PhaseTapChangerTableBusinessDelegate.getPhaseTapChangerTableInstance().getAllPhaseTapChangerTable();
            
            if ( phaseTapChangerTableList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all PhaseTapChangerTables" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all PhaseTapChangerTables ", exc );
        	return null;
        }

        return phaseTapChangerTableList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected PhaseTapChangerTable phaseTapChangerTable = null;
    private static final Logger LOGGER = Logger.getLogger(PhaseTapChangerTableQueryRestController.class.getName());
    
}
