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
 * Implements Spring Controller query CQRS processing for entity PhaseTapChangerLinear.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PhaseTapChangerLinear")
public class PhaseTapChangerLinearQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a PhaseTapChangerLinear using a UUID
     * @param		UUID phaseTapChangerLinearId
     * @return		PhaseTapChangerLinear
     */    
    @GetMapping("/load")
    public PhaseTapChangerLinear load( @RequestParam(required=true) UUID phaseTapChangerLinearId ) {
    	PhaseTapChangerLinear entity = null;

    	try {  
    		entity = PhaseTapChangerLinearBusinessDelegate.getPhaseTapChangerLinearInstance().getPhaseTapChangerLinear( new PhaseTapChangerLinearFetchOneSummary( phaseTapChangerLinearId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load PhaseTapChangerLinear using Id " + phaseTapChangerLinearId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all PhaseTapChangerLinear business objects
     * @return		Set<PhaseTapChangerLinear>
     */
    @GetMapping("/")
    public List<PhaseTapChangerLinear> loadAll() {                
    	List<PhaseTapChangerLinear> phaseTapChangerLinearList = null;
        
    	try {
            // load the PhaseTapChangerLinear
            phaseTapChangerLinearList = PhaseTapChangerLinearBusinessDelegate.getPhaseTapChangerLinearInstance().getAllPhaseTapChangerLinear();
            
            if ( phaseTapChangerLinearList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all PhaseTapChangerLinears" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all PhaseTapChangerLinears ", exc );
        	return null;
        }

        return phaseTapChangerLinearList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected PhaseTapChangerLinear phaseTapChangerLinear = null;
    private static final Logger LOGGER = Logger.getLogger(PhaseTapChangerLinearQueryRestController.class.getName());
    
}
