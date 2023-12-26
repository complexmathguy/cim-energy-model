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
 * Implements Spring Controller query CQRS processing for entity Staticpowersystemmodel.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Staticpowersystemmodel")
public class StaticpowersystemmodelQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Staticpowersystemmodel using a UUID
     * @param		UUID staticpowersystemmodelId
     * @return		Staticpowersystemmodel
     */    
    @GetMapping("/load")
    public Staticpowersystemmodel load( @RequestParam(required=true) UUID staticpowersystemmodelId ) {
    	Staticpowersystemmodel entity = null;

    	try {  
    		entity = StaticpowersystemmodelBusinessDelegate.getStaticpowersystemmodelInstance().getStaticpowersystemmodel( new StaticpowersystemmodelFetchOneSummary( staticpowersystemmodelId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Staticpowersystemmodel using Id " + staticpowersystemmodelId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Staticpowersystemmodel business objects
     * @return		Set<Staticpowersystemmodel>
     */
    @GetMapping("/")
    public List<Staticpowersystemmodel> loadAll() {                
    	List<Staticpowersystemmodel> staticpowersystemmodelList = null;
        
    	try {
            // load the Staticpowersystemmodel
            staticpowersystemmodelList = StaticpowersystemmodelBusinessDelegate.getStaticpowersystemmodelInstance().getAllStaticpowersystemmodel();
            
            if ( staticpowersystemmodelList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Staticpowersystemmodels" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Staticpowersystemmodels ", exc );
        	return null;
        }

        return staticpowersystemmodelList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Staticpowersystemmodel staticpowersystemmodel = null;
    private static final Logger LOGGER = Logger.getLogger(StaticpowersystemmodelQueryRestController.class.getName());
    
}
