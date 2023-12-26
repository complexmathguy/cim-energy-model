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
 * Implements Spring Controller query CQRS processing for entity RegulatingCondEq.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/RegulatingCondEq")
public class RegulatingCondEqQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a RegulatingCondEq using a UUID
     * @param		UUID regulatingCondEqId
     * @return		RegulatingCondEq
     */    
    @GetMapping("/load")
    public RegulatingCondEq load( @RequestParam(required=true) UUID regulatingCondEqId ) {
    	RegulatingCondEq entity = null;

    	try {  
    		entity = RegulatingCondEqBusinessDelegate.getRegulatingCondEqInstance().getRegulatingCondEq( new RegulatingCondEqFetchOneSummary( regulatingCondEqId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load RegulatingCondEq using Id " + regulatingCondEqId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all RegulatingCondEq business objects
     * @return		Set<RegulatingCondEq>
     */
    @GetMapping("/")
    public List<RegulatingCondEq> loadAll() {                
    	List<RegulatingCondEq> regulatingCondEqList = null;
        
    	try {
            // load the RegulatingCondEq
            regulatingCondEqList = RegulatingCondEqBusinessDelegate.getRegulatingCondEqInstance().getAllRegulatingCondEq();
            
            if ( regulatingCondEqList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all RegulatingCondEqs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all RegulatingCondEqs ", exc );
        	return null;
        }

        return regulatingCondEqList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected RegulatingCondEq regulatingCondEq = null;
    private static final Logger LOGGER = Logger.getLogger(RegulatingCondEqQueryRestController.class.getName());
    
}
