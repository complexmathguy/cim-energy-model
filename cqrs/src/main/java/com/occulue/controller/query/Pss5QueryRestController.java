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
 * Implements Spring Controller query CQRS processing for entity Pss5.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Pss5")
public class Pss5QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Pss5 using a UUID
     * @param		UUID pss5Id
     * @return		Pss5
     */    
    @GetMapping("/load")
    public Pss5 load( @RequestParam(required=true) UUID pss5Id ) {
    	Pss5 entity = null;

    	try {  
    		entity = Pss5BusinessDelegate.getPss5Instance().getPss5( new Pss5FetchOneSummary( pss5Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Pss5 using Id " + pss5Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Pss5 business objects
     * @return		Set<Pss5>
     */
    @GetMapping("/")
    public List<Pss5> loadAll() {                
    	List<Pss5> pss5List = null;
        
    	try {
            // load the Pss5
            pss5List = Pss5BusinessDelegate.getPss5Instance().getAllPss5();
            
            if ( pss5List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Pss5s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Pss5s ", exc );
        	return null;
        }

        return pss5List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Pss5 pss5 = null;
    private static final Logger LOGGER = Logger.getLogger(Pss5QueryRestController.class.getName());
    
}
