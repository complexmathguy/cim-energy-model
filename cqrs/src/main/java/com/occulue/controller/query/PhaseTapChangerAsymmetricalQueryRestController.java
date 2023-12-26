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
 * Implements Spring Controller query CQRS processing for entity PhaseTapChangerAsymmetrical.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PhaseTapChangerAsymmetrical")
public class PhaseTapChangerAsymmetricalQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a PhaseTapChangerAsymmetrical using a UUID
     * @param		UUID phaseTapChangerAsymmetricalId
     * @return		PhaseTapChangerAsymmetrical
     */    
    @GetMapping("/load")
    public PhaseTapChangerAsymmetrical load( @RequestParam(required=true) UUID phaseTapChangerAsymmetricalId ) {
    	PhaseTapChangerAsymmetrical entity = null;

    	try {  
    		entity = PhaseTapChangerAsymmetricalBusinessDelegate.getPhaseTapChangerAsymmetricalInstance().getPhaseTapChangerAsymmetrical( new PhaseTapChangerAsymmetricalFetchOneSummary( phaseTapChangerAsymmetricalId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load PhaseTapChangerAsymmetrical using Id " + phaseTapChangerAsymmetricalId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all PhaseTapChangerAsymmetrical business objects
     * @return		Set<PhaseTapChangerAsymmetrical>
     */
    @GetMapping("/")
    public List<PhaseTapChangerAsymmetrical> loadAll() {                
    	List<PhaseTapChangerAsymmetrical> phaseTapChangerAsymmetricalList = null;
        
    	try {
            // load the PhaseTapChangerAsymmetrical
            phaseTapChangerAsymmetricalList = PhaseTapChangerAsymmetricalBusinessDelegate.getPhaseTapChangerAsymmetricalInstance().getAllPhaseTapChangerAsymmetrical();
            
            if ( phaseTapChangerAsymmetricalList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all PhaseTapChangerAsymmetricals" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all PhaseTapChangerAsymmetricals ", exc );
        	return null;
        }

        return phaseTapChangerAsymmetricalList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected PhaseTapChangerAsymmetrical phaseTapChangerAsymmetrical = null;
    private static final Logger LOGGER = Logger.getLogger(PhaseTapChangerAsymmetricalQueryRestController.class.getName());
    
}
