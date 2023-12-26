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
 * Implements Spring Controller query CQRS processing for entity PhaseTapChangerSymmetrical.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PhaseTapChangerSymmetrical")
public class PhaseTapChangerSymmetricalQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a PhaseTapChangerSymmetrical using a UUID
     * @param		UUID phaseTapChangerSymmetricalId
     * @return		PhaseTapChangerSymmetrical
     */    
    @GetMapping("/load")
    public PhaseTapChangerSymmetrical load( @RequestParam(required=true) UUID phaseTapChangerSymmetricalId ) {
    	PhaseTapChangerSymmetrical entity = null;

    	try {  
    		entity = PhaseTapChangerSymmetricalBusinessDelegate.getPhaseTapChangerSymmetricalInstance().getPhaseTapChangerSymmetrical( new PhaseTapChangerSymmetricalFetchOneSummary( phaseTapChangerSymmetricalId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load PhaseTapChangerSymmetrical using Id " + phaseTapChangerSymmetricalId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all PhaseTapChangerSymmetrical business objects
     * @return		Set<PhaseTapChangerSymmetrical>
     */
    @GetMapping("/")
    public List<PhaseTapChangerSymmetrical> loadAll() {                
    	List<PhaseTapChangerSymmetrical> phaseTapChangerSymmetricalList = null;
        
    	try {
            // load the PhaseTapChangerSymmetrical
            phaseTapChangerSymmetricalList = PhaseTapChangerSymmetricalBusinessDelegate.getPhaseTapChangerSymmetricalInstance().getAllPhaseTapChangerSymmetrical();
            
            if ( phaseTapChangerSymmetricalList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all PhaseTapChangerSymmetricals" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all PhaseTapChangerSymmetricals ", exc );
        	return null;
        }

        return phaseTapChangerSymmetricalList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected PhaseTapChangerSymmetrical phaseTapChangerSymmetrical = null;
    private static final Logger LOGGER = Logger.getLogger(PhaseTapChangerSymmetricalQueryRestController.class.getName());
    
}
