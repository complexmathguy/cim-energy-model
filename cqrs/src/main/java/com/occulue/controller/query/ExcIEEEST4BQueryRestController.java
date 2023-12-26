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
 * Implements Spring Controller query CQRS processing for entity ExcIEEEST4B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEST4B")
public class ExcIEEEST4BQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcIEEEST4B using a UUID
     * @param		UUID excIEEEST4BId
     * @return		ExcIEEEST4B
     */    
    @GetMapping("/load")
    public ExcIEEEST4B load( @RequestParam(required=true) UUID excIEEEST4BId ) {
    	ExcIEEEST4B entity = null;

    	try {  
    		entity = ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().getExcIEEEST4B( new ExcIEEEST4BFetchOneSummary( excIEEEST4BId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcIEEEST4B using Id " + excIEEEST4BId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcIEEEST4B business objects
     * @return		Set<ExcIEEEST4B>
     */
    @GetMapping("/")
    public List<ExcIEEEST4B> loadAll() {                
    	List<ExcIEEEST4B> excIEEEST4BList = null;
        
    	try {
            // load the ExcIEEEST4B
            excIEEEST4BList = ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().getAllExcIEEEST4B();
            
            if ( excIEEEST4BList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcIEEEST4Bs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcIEEEST4Bs ", exc );
        	return null;
        }

        return excIEEEST4BList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEST4B excIEEEST4B = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEST4BQueryRestController.class.getName());
    
}
