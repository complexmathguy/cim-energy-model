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
 * Implements Spring Controller query CQRS processing for entity PssSB4.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PssSB4")
public class PssSB4QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a PssSB4 using a UUID
     * @param		UUID pssSB4Id
     * @return		PssSB4
     */    
    @GetMapping("/load")
    public PssSB4 load( @RequestParam(required=true) UUID pssSB4Id ) {
    	PssSB4 entity = null;

    	try {  
    		entity = PssSB4BusinessDelegate.getPssSB4Instance().getPssSB4( new PssSB4FetchOneSummary( pssSB4Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load PssSB4 using Id " + pssSB4Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all PssSB4 business objects
     * @return		Set<PssSB4>
     */
    @GetMapping("/")
    public List<PssSB4> loadAll() {                
    	List<PssSB4> pssSB4List = null;
        
    	try {
            // load the PssSB4
            pssSB4List = PssSB4BusinessDelegate.getPssSB4Instance().getAllPssSB4();
            
            if ( pssSB4List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all PssSB4s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all PssSB4s ", exc );
        	return null;
        }

        return pssSB4List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected PssSB4 pssSB4 = null;
    private static final Logger LOGGER = Logger.getLogger(PssSB4QueryRestController.class.getName());
    
}
