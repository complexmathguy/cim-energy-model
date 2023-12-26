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
 * Implements Spring Controller query CQRS processing for entity PhaseTapChanger.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PhaseTapChanger")
public class PhaseTapChangerQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a PhaseTapChanger using a UUID
     * @param		UUID phaseTapChangerId
     * @return		PhaseTapChanger
     */    
    @GetMapping("/load")
    public PhaseTapChanger load( @RequestParam(required=true) UUID phaseTapChangerId ) {
    	PhaseTapChanger entity = null;

    	try {  
    		entity = PhaseTapChangerBusinessDelegate.getPhaseTapChangerInstance().getPhaseTapChanger( new PhaseTapChangerFetchOneSummary( phaseTapChangerId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load PhaseTapChanger using Id " + phaseTapChangerId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all PhaseTapChanger business objects
     * @return		Set<PhaseTapChanger>
     */
    @GetMapping("/")
    public List<PhaseTapChanger> loadAll() {                
    	List<PhaseTapChanger> phaseTapChangerList = null;
        
    	try {
            // load the PhaseTapChanger
            phaseTapChangerList = PhaseTapChangerBusinessDelegate.getPhaseTapChangerInstance().getAllPhaseTapChanger();
            
            if ( phaseTapChangerList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all PhaseTapChangers" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all PhaseTapChangers ", exc );
        	return null;
        }

        return phaseTapChangerList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected PhaseTapChanger phaseTapChanger = null;
    private static final Logger LOGGER = Logger.getLogger(PhaseTapChangerQueryRestController.class.getName());
    
}
