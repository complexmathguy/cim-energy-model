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
 * Implements Spring Controller query CQRS processing for entity GovGAST4.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovGAST4")
public class GovGAST4QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a GovGAST4 using a UUID
     * @param		UUID govGAST4Id
     * @return		GovGAST4
     */    
    @GetMapping("/load")
    public GovGAST4 load( @RequestParam(required=true) UUID govGAST4Id ) {
    	GovGAST4 entity = null;

    	try {  
    		entity = GovGAST4BusinessDelegate.getGovGAST4Instance().getGovGAST4( new GovGAST4FetchOneSummary( govGAST4Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load GovGAST4 using Id " + govGAST4Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all GovGAST4 business objects
     * @return		Set<GovGAST4>
     */
    @GetMapping("/")
    public List<GovGAST4> loadAll() {                
    	List<GovGAST4> govGAST4List = null;
        
    	try {
            // load the GovGAST4
            govGAST4List = GovGAST4BusinessDelegate.getGovGAST4Instance().getAllGovGAST4();
            
            if ( govGAST4List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all GovGAST4s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all GovGAST4s ", exc );
        	return null;
        }

        return govGAST4List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected GovGAST4 govGAST4 = null;
    private static final Logger LOGGER = Logger.getLogger(GovGAST4QueryRestController.class.getName());
    
}
