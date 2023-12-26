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
 * Implements Spring Controller query CQRS processing for entity ExcIEEEAC7B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEAC7B")
public class ExcIEEEAC7BQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcIEEEAC7B using a UUID
     * @param		UUID excIEEEAC7BId
     * @return		ExcIEEEAC7B
     */    
    @GetMapping("/load")
    public ExcIEEEAC7B load( @RequestParam(required=true) UUID excIEEEAC7BId ) {
    	ExcIEEEAC7B entity = null;

    	try {  
    		entity = ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().getExcIEEEAC7B( new ExcIEEEAC7BFetchOneSummary( excIEEEAC7BId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcIEEEAC7B using Id " + excIEEEAC7BId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcIEEEAC7B business objects
     * @return		Set<ExcIEEEAC7B>
     */
    @GetMapping("/")
    public List<ExcIEEEAC7B> loadAll() {                
    	List<ExcIEEEAC7B> excIEEEAC7BList = null;
        
    	try {
            // load the ExcIEEEAC7B
            excIEEEAC7BList = ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().getAllExcIEEEAC7B();
            
            if ( excIEEEAC7BList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcIEEEAC7Bs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcIEEEAC7Bs ", exc );
        	return null;
        }

        return excIEEEAC7BList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEAC7B excIEEEAC7B = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC7BQueryRestController.class.getName());
    
}
