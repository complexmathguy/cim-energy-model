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
 * Implements Spring Controller query CQRS processing for entity GovGAST.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovGAST")
public class GovGASTQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a GovGAST using a UUID
     * @param		UUID govGASTId
     * @return		GovGAST
     */    
    @GetMapping("/load")
    public GovGAST load( @RequestParam(required=true) UUID govGASTId ) {
    	GovGAST entity = null;

    	try {  
    		entity = GovGASTBusinessDelegate.getGovGASTInstance().getGovGAST( new GovGASTFetchOneSummary( govGASTId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load GovGAST using Id " + govGASTId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all GovGAST business objects
     * @return		Set<GovGAST>
     */
    @GetMapping("/")
    public List<GovGAST> loadAll() {                
    	List<GovGAST> govGASTList = null;
        
    	try {
            // load the GovGAST
            govGASTList = GovGASTBusinessDelegate.getGovGASTInstance().getAllGovGAST();
            
            if ( govGASTList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all GovGASTs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all GovGASTs ", exc );
        	return null;
        }

        return govGASTList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected GovGAST govGAST = null;
    private static final Logger LOGGER = Logger.getLogger(GovGASTQueryRestController.class.getName());
    
}
