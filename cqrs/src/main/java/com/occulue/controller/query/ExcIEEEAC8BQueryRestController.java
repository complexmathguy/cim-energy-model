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
 * Implements Spring Controller query CQRS processing for entity ExcIEEEAC8B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEAC8B")
public class ExcIEEEAC8BQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcIEEEAC8B using a UUID
     * @param		UUID excIEEEAC8BId
     * @return		ExcIEEEAC8B
     */    
    @GetMapping("/load")
    public ExcIEEEAC8B load( @RequestParam(required=true) UUID excIEEEAC8BId ) {
    	ExcIEEEAC8B entity = null;

    	try {  
    		entity = ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().getExcIEEEAC8B( new ExcIEEEAC8BFetchOneSummary( excIEEEAC8BId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcIEEEAC8B using Id " + excIEEEAC8BId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcIEEEAC8B business objects
     * @return		Set<ExcIEEEAC8B>
     */
    @GetMapping("/")
    public List<ExcIEEEAC8B> loadAll() {                
    	List<ExcIEEEAC8B> excIEEEAC8BList = null;
        
    	try {
            // load the ExcIEEEAC8B
            excIEEEAC8BList = ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().getAllExcIEEEAC8B();
            
            if ( excIEEEAC8BList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcIEEEAC8Bs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcIEEEAC8Bs ", exc );
        	return null;
        }

        return excIEEEAC8BList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEAC8B excIEEEAC8B = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC8BQueryRestController.class.getName());
    
}
