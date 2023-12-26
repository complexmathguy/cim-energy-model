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
 * Implements Spring Controller query CQRS processing for entity Pss1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Pss1")
public class Pss1QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Pss1 using a UUID
     * @param		UUID pss1Id
     * @return		Pss1
     */    
    @GetMapping("/load")
    public Pss1 load( @RequestParam(required=true) UUID pss1Id ) {
    	Pss1 entity = null;

    	try {  
    		entity = Pss1BusinessDelegate.getPss1Instance().getPss1( new Pss1FetchOneSummary( pss1Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Pss1 using Id " + pss1Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Pss1 business objects
     * @return		Set<Pss1>
     */
    @GetMapping("/")
    public List<Pss1> loadAll() {                
    	List<Pss1> pss1List = null;
        
    	try {
            // load the Pss1
            pss1List = Pss1BusinessDelegate.getPss1Instance().getAllPss1();
            
            if ( pss1List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Pss1s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Pss1s ", exc );
        	return null;
        }

        return pss1List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Pss1 pss1 = null;
    private static final Logger LOGGER = Logger.getLogger(Pss1QueryRestController.class.getName());
    
}
