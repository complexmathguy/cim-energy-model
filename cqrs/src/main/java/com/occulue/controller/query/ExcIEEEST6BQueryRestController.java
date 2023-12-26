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
 * Implements Spring Controller query CQRS processing for entity ExcIEEEST6B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEST6B")
public class ExcIEEEST6BQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcIEEEST6B using a UUID
     * @param		UUID excIEEEST6BId
     * @return		ExcIEEEST6B
     */    
    @GetMapping("/load")
    public ExcIEEEST6B load( @RequestParam(required=true) UUID excIEEEST6BId ) {
    	ExcIEEEST6B entity = null;

    	try {  
    		entity = ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().getExcIEEEST6B( new ExcIEEEST6BFetchOneSummary( excIEEEST6BId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcIEEEST6B using Id " + excIEEEST6BId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcIEEEST6B business objects
     * @return		Set<ExcIEEEST6B>
     */
    @GetMapping("/")
    public List<ExcIEEEST6B> loadAll() {                
    	List<ExcIEEEST6B> excIEEEST6BList = null;
        
    	try {
            // load the ExcIEEEST6B
            excIEEEST6BList = ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().getAllExcIEEEST6B();
            
            if ( excIEEEST6BList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcIEEEST6Bs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcIEEEST6Bs ", exc );
        	return null;
        }

        return excIEEEST6BList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEST6B excIEEEST6B = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEST6BQueryRestController.class.getName());
    
}
