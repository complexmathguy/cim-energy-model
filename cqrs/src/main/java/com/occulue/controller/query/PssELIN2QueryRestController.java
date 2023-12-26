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
 * Implements Spring Controller query CQRS processing for entity PssELIN2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PssELIN2")
public class PssELIN2QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a PssELIN2 using a UUID
     * @param		UUID pssELIN2Id
     * @return		PssELIN2
     */    
    @GetMapping("/load")
    public PssELIN2 load( @RequestParam(required=true) UUID pssELIN2Id ) {
    	PssELIN2 entity = null;

    	try {  
    		entity = PssELIN2BusinessDelegate.getPssELIN2Instance().getPssELIN2( new PssELIN2FetchOneSummary( pssELIN2Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load PssELIN2 using Id " + pssELIN2Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all PssELIN2 business objects
     * @return		Set<PssELIN2>
     */
    @GetMapping("/")
    public List<PssELIN2> loadAll() {                
    	List<PssELIN2> pssELIN2List = null;
        
    	try {
            // load the PssELIN2
            pssELIN2List = PssELIN2BusinessDelegate.getPssELIN2Instance().getAllPssELIN2();
            
            if ( pssELIN2List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all PssELIN2s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all PssELIN2s ", exc );
        	return null;
        }

        return pssELIN2List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected PssELIN2 pssELIN2 = null;
    private static final Logger LOGGER = Logger.getLogger(PssELIN2QueryRestController.class.getName());
    
}
