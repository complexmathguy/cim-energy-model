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
 * Implements Spring Controller query CQRS processing for entity ExcAC8B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcAC8B")
public class ExcAC8BQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcAC8B using a UUID
     * @param		UUID excAC8BId
     * @return		ExcAC8B
     */    
    @GetMapping("/load")
    public ExcAC8B load( @RequestParam(required=true) UUID excAC8BId ) {
    	ExcAC8B entity = null;

    	try {  
    		entity = ExcAC8BBusinessDelegate.getExcAC8BInstance().getExcAC8B( new ExcAC8BFetchOneSummary( excAC8BId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcAC8B using Id " + excAC8BId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcAC8B business objects
     * @return		Set<ExcAC8B>
     */
    @GetMapping("/")
    public List<ExcAC8B> loadAll() {                
    	List<ExcAC8B> excAC8BList = null;
        
    	try {
            // load the ExcAC8B
            excAC8BList = ExcAC8BBusinessDelegate.getExcAC8BInstance().getAllExcAC8B();
            
            if ( excAC8BList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcAC8Bs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcAC8Bs ", exc );
        	return null;
        }

        return excAC8BList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcAC8B excAC8B = null;
    private static final Logger LOGGER = Logger.getLogger(ExcAC8BQueryRestController.class.getName());
    
}
