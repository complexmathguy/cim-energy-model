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
 * Implements Spring Controller query CQRS processing for entity DiscExcContIEEEDEC2A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DiscExcContIEEEDEC2A")
public class DiscExcContIEEEDEC2AQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a DiscExcContIEEEDEC2A using a UUID
     * @param		UUID discExcContIEEEDEC2AId
     * @return		DiscExcContIEEEDEC2A
     */    
    @GetMapping("/load")
    public DiscExcContIEEEDEC2A load( @RequestParam(required=true) UUID discExcContIEEEDEC2AId ) {
    	DiscExcContIEEEDEC2A entity = null;

    	try {  
    		entity = DiscExcContIEEEDEC2ABusinessDelegate.getDiscExcContIEEEDEC2AInstance().getDiscExcContIEEEDEC2A( new DiscExcContIEEEDEC2AFetchOneSummary( discExcContIEEEDEC2AId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load DiscExcContIEEEDEC2A using Id " + discExcContIEEEDEC2AId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all DiscExcContIEEEDEC2A business objects
     * @return		Set<DiscExcContIEEEDEC2A>
     */
    @GetMapping("/")
    public List<DiscExcContIEEEDEC2A> loadAll() {                
    	List<DiscExcContIEEEDEC2A> discExcContIEEEDEC2AList = null;
        
    	try {
            // load the DiscExcContIEEEDEC2A
            discExcContIEEEDEC2AList = DiscExcContIEEEDEC2ABusinessDelegate.getDiscExcContIEEEDEC2AInstance().getAllDiscExcContIEEEDEC2A();
            
            if ( discExcContIEEEDEC2AList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all DiscExcContIEEEDEC2As" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all DiscExcContIEEEDEC2As ", exc );
        	return null;
        }

        return discExcContIEEEDEC2AList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected DiscExcContIEEEDEC2A discExcContIEEEDEC2A = null;
    private static final Logger LOGGER = Logger.getLogger(DiscExcContIEEEDEC2AQueryRestController.class.getName());
    
}
