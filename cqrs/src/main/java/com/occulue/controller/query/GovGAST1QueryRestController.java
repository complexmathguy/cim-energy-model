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
 * Implements Spring Controller query CQRS processing for entity GovGAST1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovGAST1")
public class GovGAST1QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a GovGAST1 using a UUID
     * @param		UUID govGAST1Id
     * @return		GovGAST1
     */    
    @GetMapping("/load")
    public GovGAST1 load( @RequestParam(required=true) UUID govGAST1Id ) {
    	GovGAST1 entity = null;

    	try {  
    		entity = GovGAST1BusinessDelegate.getGovGAST1Instance().getGovGAST1( new GovGAST1FetchOneSummary( govGAST1Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load GovGAST1 using Id " + govGAST1Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all GovGAST1 business objects
     * @return		Set<GovGAST1>
     */
    @GetMapping("/")
    public List<GovGAST1> loadAll() {                
    	List<GovGAST1> govGAST1List = null;
        
    	try {
            // load the GovGAST1
            govGAST1List = GovGAST1BusinessDelegate.getGovGAST1Instance().getAllGovGAST1();
            
            if ( govGAST1List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all GovGAST1s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all GovGAST1s ", exc );
        	return null;
        }

        return govGAST1List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected GovGAST1 govGAST1 = null;
    private static final Logger LOGGER = Logger.getLogger(GovGAST1QueryRestController.class.getName());
    
}
