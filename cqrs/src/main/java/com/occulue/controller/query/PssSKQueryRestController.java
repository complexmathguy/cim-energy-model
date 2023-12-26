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
 * Implements Spring Controller query CQRS processing for entity PssSK.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PssSK")
public class PssSKQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a PssSK using a UUID
     * @param		UUID pssSKId
     * @return		PssSK
     */    
    @GetMapping("/load")
    public PssSK load( @RequestParam(required=true) UUID pssSKId ) {
    	PssSK entity = null;

    	try {  
    		entity = PssSKBusinessDelegate.getPssSKInstance().getPssSK( new PssSKFetchOneSummary( pssSKId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load PssSK using Id " + pssSKId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all PssSK business objects
     * @return		Set<PssSK>
     */
    @GetMapping("/")
    public List<PssSK> loadAll() {                
    	List<PssSK> pssSKList = null;
        
    	try {
            // load the PssSK
            pssSKList = PssSKBusinessDelegate.getPssSKInstance().getAllPssSK();
            
            if ( pssSKList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all PssSKs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all PssSKs ", exc );
        	return null;
        }

        return pssSKList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected PssSK pssSK = null;
    private static final Logger LOGGER = Logger.getLogger(PssSKQueryRestController.class.getName());
    
}
