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
 * Implements Spring Controller query CQRS processing for entity DiscExcContIEEEDEC1A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DiscExcContIEEEDEC1A")
public class DiscExcContIEEEDEC1AQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a DiscExcContIEEEDEC1A using a UUID
     * @param		UUID discExcContIEEEDEC1AId
     * @return		DiscExcContIEEEDEC1A
     */    
    @GetMapping("/load")
    public DiscExcContIEEEDEC1A load( @RequestParam(required=true) UUID discExcContIEEEDEC1AId ) {
    	DiscExcContIEEEDEC1A entity = null;

    	try {  
    		entity = DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().getDiscExcContIEEEDEC1A( new DiscExcContIEEEDEC1AFetchOneSummary( discExcContIEEEDEC1AId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load DiscExcContIEEEDEC1A using Id " + discExcContIEEEDEC1AId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all DiscExcContIEEEDEC1A business objects
     * @return		Set<DiscExcContIEEEDEC1A>
     */
    @GetMapping("/")
    public List<DiscExcContIEEEDEC1A> loadAll() {                
    	List<DiscExcContIEEEDEC1A> discExcContIEEEDEC1AList = null;
        
    	try {
            // load the DiscExcContIEEEDEC1A
            discExcContIEEEDEC1AList = DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().getAllDiscExcContIEEEDEC1A();
            
            if ( discExcContIEEEDEC1AList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all DiscExcContIEEEDEC1As" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all DiscExcContIEEEDEC1As ", exc );
        	return null;
        }

        return discExcContIEEEDEC1AList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected DiscExcContIEEEDEC1A discExcContIEEEDEC1A = null;
    private static final Logger LOGGER = Logger.getLogger(DiscExcContIEEEDEC1AQueryRestController.class.getName());
    
}
