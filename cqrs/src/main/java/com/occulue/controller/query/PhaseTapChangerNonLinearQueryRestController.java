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
 * Implements Spring Controller query CQRS processing for entity PhaseTapChangerNonLinear.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PhaseTapChangerNonLinear")
public class PhaseTapChangerNonLinearQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a PhaseTapChangerNonLinear using a UUID
     * @param		UUID phaseTapChangerNonLinearId
     * @return		PhaseTapChangerNonLinear
     */    
    @GetMapping("/load")
    public PhaseTapChangerNonLinear load( @RequestParam(required=true) UUID phaseTapChangerNonLinearId ) {
    	PhaseTapChangerNonLinear entity = null;

    	try {  
    		entity = PhaseTapChangerNonLinearBusinessDelegate.getPhaseTapChangerNonLinearInstance().getPhaseTapChangerNonLinear( new PhaseTapChangerNonLinearFetchOneSummary( phaseTapChangerNonLinearId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load PhaseTapChangerNonLinear using Id " + phaseTapChangerNonLinearId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all PhaseTapChangerNonLinear business objects
     * @return		Set<PhaseTapChangerNonLinear>
     */
    @GetMapping("/")
    public List<PhaseTapChangerNonLinear> loadAll() {                
    	List<PhaseTapChangerNonLinear> phaseTapChangerNonLinearList = null;
        
    	try {
            // load the PhaseTapChangerNonLinear
            phaseTapChangerNonLinearList = PhaseTapChangerNonLinearBusinessDelegate.getPhaseTapChangerNonLinearInstance().getAllPhaseTapChangerNonLinear();
            
            if ( phaseTapChangerNonLinearList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all PhaseTapChangerNonLinears" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all PhaseTapChangerNonLinears ", exc );
        	return null;
        }

        return phaseTapChangerNonLinearList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected PhaseTapChangerNonLinear phaseTapChangerNonLinear = null;
    private static final Logger LOGGER = Logger.getLogger(PhaseTapChangerNonLinearQueryRestController.class.getName());
    
}
