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
 * Implements Spring Controller query CQRS processing for entity PFVArType2Common1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PFVArType2Common1")
public class PFVArType2Common1QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a PFVArType2Common1 using a UUID
     * @param		UUID pFVArType2Common1Id
     * @return		PFVArType2Common1
     */    
    @GetMapping("/load")
    public PFVArType2Common1 load( @RequestParam(required=true) UUID pFVArType2Common1Id ) {
    	PFVArType2Common1 entity = null;

    	try {  
    		entity = PFVArType2Common1BusinessDelegate.getPFVArType2Common1Instance().getPFVArType2Common1( new PFVArType2Common1FetchOneSummary( pFVArType2Common1Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load PFVArType2Common1 using Id " + pFVArType2Common1Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all PFVArType2Common1 business objects
     * @return		Set<PFVArType2Common1>
     */
    @GetMapping("/")
    public List<PFVArType2Common1> loadAll() {                
    	List<PFVArType2Common1> pFVArType2Common1List = null;
        
    	try {
            // load the PFVArType2Common1
            pFVArType2Common1List = PFVArType2Common1BusinessDelegate.getPFVArType2Common1Instance().getAllPFVArType2Common1();
            
            if ( pFVArType2Common1List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all PFVArType2Common1s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all PFVArType2Common1s ", exc );
        	return null;
        }

        return pFVArType2Common1List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected PFVArType2Common1 pFVArType2Common1 = null;
    private static final Logger LOGGER = Logger.getLogger(PFVArType2Common1QueryRestController.class.getName());
    
}
