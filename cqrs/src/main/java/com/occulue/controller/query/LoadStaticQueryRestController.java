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
 * Implements Spring Controller query CQRS processing for entity LoadStatic.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/LoadStatic")
public class LoadStaticQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a LoadStatic using a UUID
     * @param		UUID loadStaticId
     * @return		LoadStatic
     */    
    @GetMapping("/load")
    public LoadStatic load( @RequestParam(required=true) UUID loadStaticId ) {
    	LoadStatic entity = null;

    	try {  
    		entity = LoadStaticBusinessDelegate.getLoadStaticInstance().getLoadStatic( new LoadStaticFetchOneSummary( loadStaticId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load LoadStatic using Id " + loadStaticId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all LoadStatic business objects
     * @return		Set<LoadStatic>
     */
    @GetMapping("/")
    public List<LoadStatic> loadAll() {                
    	List<LoadStatic> loadStaticList = null;
        
    	try {
            // load the LoadStatic
            loadStaticList = LoadStaticBusinessDelegate.getLoadStaticInstance().getAllLoadStatic();
            
            if ( loadStaticList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all LoadStatics" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all LoadStatics ", exc );
        	return null;
        }

        return loadStaticList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected LoadStatic loadStatic = null;
    private static final Logger LOGGER = Logger.getLogger(LoadStaticQueryRestController.class.getName());
    
}
