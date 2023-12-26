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
 * Implements Spring Controller query CQRS processing for entity LoadComposite.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/LoadComposite")
public class LoadCompositeQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a LoadComposite using a UUID
     * @param		UUID loadCompositeId
     * @return		LoadComposite
     */    
    @GetMapping("/load")
    public LoadComposite load( @RequestParam(required=true) UUID loadCompositeId ) {
    	LoadComposite entity = null;

    	try {  
    		entity = LoadCompositeBusinessDelegate.getLoadCompositeInstance().getLoadComposite( new LoadCompositeFetchOneSummary( loadCompositeId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load LoadComposite using Id " + loadCompositeId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all LoadComposite business objects
     * @return		Set<LoadComposite>
     */
    @GetMapping("/")
    public List<LoadComposite> loadAll() {                
    	List<LoadComposite> loadCompositeList = null;
        
    	try {
            // load the LoadComposite
            loadCompositeList = LoadCompositeBusinessDelegate.getLoadCompositeInstance().getAllLoadComposite();
            
            if ( loadCompositeList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all LoadComposites" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all LoadComposites ", exc );
        	return null;
        }

        return loadCompositeList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected LoadComposite loadComposite = null;
    private static final Logger LOGGER = Logger.getLogger(LoadCompositeQueryRestController.class.getName());
    
}
