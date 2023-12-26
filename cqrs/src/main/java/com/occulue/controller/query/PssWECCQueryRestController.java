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
 * Implements Spring Controller query CQRS processing for entity PssWECC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PssWECC")
public class PssWECCQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a PssWECC using a UUID
     * @param		UUID pssWECCId
     * @return		PssWECC
     */    
    @GetMapping("/load")
    public PssWECC load( @RequestParam(required=true) UUID pssWECCId ) {
    	PssWECC entity = null;

    	try {  
    		entity = PssWECCBusinessDelegate.getPssWECCInstance().getPssWECC( new PssWECCFetchOneSummary( pssWECCId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load PssWECC using Id " + pssWECCId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all PssWECC business objects
     * @return		Set<PssWECC>
     */
    @GetMapping("/")
    public List<PssWECC> loadAll() {                
    	List<PssWECC> pssWECCList = null;
        
    	try {
            // load the PssWECC
            pssWECCList = PssWECCBusinessDelegate.getPssWECCInstance().getAllPssWECC();
            
            if ( pssWECCList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all PssWECCs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all PssWECCs ", exc );
        	return null;
        }

        return pssWECCList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected PssWECC pssWECC = null;
    private static final Logger LOGGER = Logger.getLogger(PssWECCQueryRestController.class.getName());
    
}
