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
 * Implements Spring Controller query CQRS processing for entity ExcIEEEST5B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEST5B")
public class ExcIEEEST5BQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcIEEEST5B using a UUID
     * @param		UUID excIEEEST5BId
     * @return		ExcIEEEST5B
     */    
    @GetMapping("/load")
    public ExcIEEEST5B load( @RequestParam(required=true) UUID excIEEEST5BId ) {
    	ExcIEEEST5B entity = null;

    	try {  
    		entity = ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().getExcIEEEST5B( new ExcIEEEST5BFetchOneSummary( excIEEEST5BId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcIEEEST5B using Id " + excIEEEST5BId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcIEEEST5B business objects
     * @return		Set<ExcIEEEST5B>
     */
    @GetMapping("/")
    public List<ExcIEEEST5B> loadAll() {                
    	List<ExcIEEEST5B> excIEEEST5BList = null;
        
    	try {
            // load the ExcIEEEST5B
            excIEEEST5BList = ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().getAllExcIEEEST5B();
            
            if ( excIEEEST5BList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcIEEEST5Bs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcIEEEST5Bs ", exc );
        	return null;
        }

        return excIEEEST5BList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEST5B excIEEEST5B = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEST5BQueryRestController.class.getName());
    
}
