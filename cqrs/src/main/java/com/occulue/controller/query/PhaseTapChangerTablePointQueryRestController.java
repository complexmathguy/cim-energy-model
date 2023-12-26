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
 * Implements Spring Controller query CQRS processing for entity PhaseTapChangerTablePoint.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PhaseTapChangerTablePoint")
public class PhaseTapChangerTablePointQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a PhaseTapChangerTablePoint using a UUID
     * @param		UUID phaseTapChangerTablePointId
     * @return		PhaseTapChangerTablePoint
     */    
    @GetMapping("/load")
    public PhaseTapChangerTablePoint load( @RequestParam(required=true) UUID phaseTapChangerTablePointId ) {
    	PhaseTapChangerTablePoint entity = null;

    	try {  
    		entity = PhaseTapChangerTablePointBusinessDelegate.getPhaseTapChangerTablePointInstance().getPhaseTapChangerTablePoint( new PhaseTapChangerTablePointFetchOneSummary( phaseTapChangerTablePointId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load PhaseTapChangerTablePoint using Id " + phaseTapChangerTablePointId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all PhaseTapChangerTablePoint business objects
     * @return		Set<PhaseTapChangerTablePoint>
     */
    @GetMapping("/")
    public List<PhaseTapChangerTablePoint> loadAll() {                
    	List<PhaseTapChangerTablePoint> phaseTapChangerTablePointList = null;
        
    	try {
            // load the PhaseTapChangerTablePoint
            phaseTapChangerTablePointList = PhaseTapChangerTablePointBusinessDelegate.getPhaseTapChangerTablePointInstance().getAllPhaseTapChangerTablePoint();
            
            if ( phaseTapChangerTablePointList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all PhaseTapChangerTablePoints" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all PhaseTapChangerTablePoints ", exc );
        	return null;
        }

        return phaseTapChangerTablePointList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected PhaseTapChangerTablePoint phaseTapChangerTablePoint = null;
    private static final Logger LOGGER = Logger.getLogger(PhaseTapChangerTablePointQueryRestController.class.getName());
    
}
