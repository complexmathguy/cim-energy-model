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
 * Implements Spring Controller query CQRS processing for entity PssSH.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PssSH")
public class PssSHQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a PssSH using a UUID
     * @param		UUID pssSHId
     * @return		PssSH
     */    
    @GetMapping("/load")
    public PssSH load( @RequestParam(required=true) UUID pssSHId ) {
    	PssSH entity = null;

    	try {  
    		entity = PssSHBusinessDelegate.getPssSHInstance().getPssSH( new PssSHFetchOneSummary( pssSHId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load PssSH using Id " + pssSHId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all PssSH business objects
     * @return		Set<PssSH>
     */
    @GetMapping("/")
    public List<PssSH> loadAll() {                
    	List<PssSH> pssSHList = null;
        
    	try {
            // load the PssSH
            pssSHList = PssSHBusinessDelegate.getPssSHInstance().getAllPssSH();
            
            if ( pssSHList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all PssSHs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all PssSHs ", exc );
        	return null;
        }

        return pssSHList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected PssSH pssSH = null;
    private static final Logger LOGGER = Logger.getLogger(PssSHQueryRestController.class.getName());
    
}
