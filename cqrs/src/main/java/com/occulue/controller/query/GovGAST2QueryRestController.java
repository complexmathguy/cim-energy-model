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
 * Implements Spring Controller query CQRS processing for entity GovGAST2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovGAST2")
public class GovGAST2QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a GovGAST2 using a UUID
     * @param		UUID govGAST2Id
     * @return		GovGAST2
     */    
    @GetMapping("/load")
    public GovGAST2 load( @RequestParam(required=true) UUID govGAST2Id ) {
    	GovGAST2 entity = null;

    	try {  
    		entity = GovGAST2BusinessDelegate.getGovGAST2Instance().getGovGAST2( new GovGAST2FetchOneSummary( govGAST2Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load GovGAST2 using Id " + govGAST2Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all GovGAST2 business objects
     * @return		Set<GovGAST2>
     */
    @GetMapping("/")
    public List<GovGAST2> loadAll() {                
    	List<GovGAST2> govGAST2List = null;
        
    	try {
            // load the GovGAST2
            govGAST2List = GovGAST2BusinessDelegate.getGovGAST2Instance().getAllGovGAST2();
            
            if ( govGAST2List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all GovGAST2s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all GovGAST2s ", exc );
        	return null;
        }

        return govGAST2List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected GovGAST2 govGAST2 = null;
    private static final Logger LOGGER = Logger.getLogger(GovGAST2QueryRestController.class.getName());
    
}
