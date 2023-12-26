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
 * Implements Spring Controller query CQRS processing for entity ExcIEEEST7B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEST7B")
public class ExcIEEEST7BQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcIEEEST7B using a UUID
     * @param		UUID excIEEEST7BId
     * @return		ExcIEEEST7B
     */    
    @GetMapping("/load")
    public ExcIEEEST7B load( @RequestParam(required=true) UUID excIEEEST7BId ) {
    	ExcIEEEST7B entity = null;

    	try {  
    		entity = ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance().getExcIEEEST7B( new ExcIEEEST7BFetchOneSummary( excIEEEST7BId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcIEEEST7B using Id " + excIEEEST7BId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcIEEEST7B business objects
     * @return		Set<ExcIEEEST7B>
     */
    @GetMapping("/")
    public List<ExcIEEEST7B> loadAll() {                
    	List<ExcIEEEST7B> excIEEEST7BList = null;
        
    	try {
            // load the ExcIEEEST7B
            excIEEEST7BList = ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance().getAllExcIEEEST7B();
            
            if ( excIEEEST7BList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcIEEEST7Bs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcIEEEST7Bs ", exc );
        	return null;
        }

        return excIEEEST7BList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEST7B excIEEEST7B = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEST7BQueryRestController.class.getName());
    
}
