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
 * Implements Spring Controller query CQRS processing for entity GovGASTWD.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovGASTWD")
public class GovGASTWDQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a GovGASTWD using a UUID
     * @param		UUID govGASTWDId
     * @return		GovGASTWD
     */    
    @GetMapping("/load")
    public GovGASTWD load( @RequestParam(required=true) UUID govGASTWDId ) {
    	GovGASTWD entity = null;

    	try {  
    		entity = GovGASTWDBusinessDelegate.getGovGASTWDInstance().getGovGASTWD( new GovGASTWDFetchOneSummary( govGASTWDId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load GovGASTWD using Id " + govGASTWDId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all GovGASTWD business objects
     * @return		Set<GovGASTWD>
     */
    @GetMapping("/")
    public List<GovGASTWD> loadAll() {                
    	List<GovGASTWD> govGASTWDList = null;
        
    	try {
            // load the GovGASTWD
            govGASTWDList = GovGASTWDBusinessDelegate.getGovGASTWDInstance().getAllGovGASTWD();
            
            if ( govGASTWDList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all GovGASTWDs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all GovGASTWDs ", exc );
        	return null;
        }

        return govGASTWDList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected GovGASTWD govGASTWD = null;
    private static final Logger LOGGER = Logger.getLogger(GovGASTWDQueryRestController.class.getName());
    
}
