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
 * Implements Spring Controller query CQRS processing for entity ResistancePerLength.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ResistancePerLength")
public class ResistancePerLengthQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ResistancePerLength using a UUID
     * @param		UUID resistancePerLengthId
     * @return		ResistancePerLength
     */    
    @GetMapping("/load")
    public ResistancePerLength load( @RequestParam(required=true) UUID resistancePerLengthId ) {
    	ResistancePerLength entity = null;

    	try {  
    		entity = ResistancePerLengthBusinessDelegate.getResistancePerLengthInstance().getResistancePerLength( new ResistancePerLengthFetchOneSummary( resistancePerLengthId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ResistancePerLength using Id " + resistancePerLengthId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ResistancePerLength business objects
     * @return		Set<ResistancePerLength>
     */
    @GetMapping("/")
    public List<ResistancePerLength> loadAll() {                
    	List<ResistancePerLength> resistancePerLengthList = null;
        
    	try {
            // load the ResistancePerLength
            resistancePerLengthList = ResistancePerLengthBusinessDelegate.getResistancePerLengthInstance().getAllResistancePerLength();
            
            if ( resistancePerLengthList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ResistancePerLengths" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ResistancePerLengths ", exc );
        	return null;
        }

        return resistancePerLengthList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ResistancePerLength resistancePerLength = null;
    private static final Logger LOGGER = Logger.getLogger(ResistancePerLengthQueryRestController.class.getName());
    
}
