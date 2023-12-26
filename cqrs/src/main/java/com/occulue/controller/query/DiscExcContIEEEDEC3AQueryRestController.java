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
 * Implements Spring Controller query CQRS processing for entity DiscExcContIEEEDEC3A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DiscExcContIEEEDEC3A")
public class DiscExcContIEEEDEC3AQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a DiscExcContIEEEDEC3A using a UUID
     * @param		UUID discExcContIEEEDEC3AId
     * @return		DiscExcContIEEEDEC3A
     */    
    @GetMapping("/load")
    public DiscExcContIEEEDEC3A load( @RequestParam(required=true) UUID discExcContIEEEDEC3AId ) {
    	DiscExcContIEEEDEC3A entity = null;

    	try {  
    		entity = DiscExcContIEEEDEC3ABusinessDelegate.getDiscExcContIEEEDEC3AInstance().getDiscExcContIEEEDEC3A( new DiscExcContIEEEDEC3AFetchOneSummary( discExcContIEEEDEC3AId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load DiscExcContIEEEDEC3A using Id " + discExcContIEEEDEC3AId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all DiscExcContIEEEDEC3A business objects
     * @return		Set<DiscExcContIEEEDEC3A>
     */
    @GetMapping("/")
    public List<DiscExcContIEEEDEC3A> loadAll() {                
    	List<DiscExcContIEEEDEC3A> discExcContIEEEDEC3AList = null;
        
    	try {
            // load the DiscExcContIEEEDEC3A
            discExcContIEEEDEC3AList = DiscExcContIEEEDEC3ABusinessDelegate.getDiscExcContIEEEDEC3AInstance().getAllDiscExcContIEEEDEC3A();
            
            if ( discExcContIEEEDEC3AList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all DiscExcContIEEEDEC3As" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all DiscExcContIEEEDEC3As ", exc );
        	return null;
        }

        return discExcContIEEEDEC3AList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected DiscExcContIEEEDEC3A discExcContIEEEDEC3A = null;
    private static final Logger LOGGER = Logger.getLogger(DiscExcContIEEEDEC3AQueryRestController.class.getName());
    
}
