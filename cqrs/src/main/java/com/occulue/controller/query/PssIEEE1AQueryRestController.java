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
 * Implements Spring Controller query CQRS processing for entity PssIEEE1A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PssIEEE1A")
public class PssIEEE1AQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a PssIEEE1A using a UUID
     * @param		UUID pssIEEE1AId
     * @return		PssIEEE1A
     */    
    @GetMapping("/load")
    public PssIEEE1A load( @RequestParam(required=true) UUID pssIEEE1AId ) {
    	PssIEEE1A entity = null;

    	try {  
    		entity = PssIEEE1ABusinessDelegate.getPssIEEE1AInstance().getPssIEEE1A( new PssIEEE1AFetchOneSummary( pssIEEE1AId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load PssIEEE1A using Id " + pssIEEE1AId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all PssIEEE1A business objects
     * @return		Set<PssIEEE1A>
     */
    @GetMapping("/")
    public List<PssIEEE1A> loadAll() {                
    	List<PssIEEE1A> pssIEEE1AList = null;
        
    	try {
            // load the PssIEEE1A
            pssIEEE1AList = PssIEEE1ABusinessDelegate.getPssIEEE1AInstance().getAllPssIEEE1A();
            
            if ( pssIEEE1AList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all PssIEEE1As" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all PssIEEE1As ", exc );
        	return null;
        }

        return pssIEEE1AList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected PssIEEE1A pssIEEE1A = null;
    private static final Logger LOGGER = Logger.getLogger(PssIEEE1AQueryRestController.class.getName());
    
}
