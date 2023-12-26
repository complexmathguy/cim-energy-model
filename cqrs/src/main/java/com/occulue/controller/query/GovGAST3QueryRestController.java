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
 * Implements Spring Controller query CQRS processing for entity GovGAST3.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovGAST3")
public class GovGAST3QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a GovGAST3 using a UUID
     * @param		UUID govGAST3Id
     * @return		GovGAST3
     */    
    @GetMapping("/load")
    public GovGAST3 load( @RequestParam(required=true) UUID govGAST3Id ) {
    	GovGAST3 entity = null;

    	try {  
    		entity = GovGAST3BusinessDelegate.getGovGAST3Instance().getGovGAST3( new GovGAST3FetchOneSummary( govGAST3Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load GovGAST3 using Id " + govGAST3Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all GovGAST3 business objects
     * @return		Set<GovGAST3>
     */
    @GetMapping("/")
    public List<GovGAST3> loadAll() {                
    	List<GovGAST3> govGAST3List = null;
        
    	try {
            // load the GovGAST3
            govGAST3List = GovGAST3BusinessDelegate.getGovGAST3Instance().getAllGovGAST3();
            
            if ( govGAST3List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all GovGAST3s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all GovGAST3s ", exc );
        	return null;
        }

        return govGAST3List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected GovGAST3 govGAST3 = null;
    private static final Logger LOGGER = Logger.getLogger(GovGAST3QueryRestController.class.getName());
    
}
