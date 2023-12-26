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
 * Implements Spring Controller query CQRS processing for entity ExcST6B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcST6B")
public class ExcST6BQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcST6B using a UUID
     * @param		UUID excST6BId
     * @return		ExcST6B
     */    
    @GetMapping("/load")
    public ExcST6B load( @RequestParam(required=true) UUID excST6BId ) {
    	ExcST6B entity = null;

    	try {  
    		entity = ExcST6BBusinessDelegate.getExcST6BInstance().getExcST6B( new ExcST6BFetchOneSummary( excST6BId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcST6B using Id " + excST6BId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcST6B business objects
     * @return		Set<ExcST6B>
     */
    @GetMapping("/")
    public List<ExcST6B> loadAll() {                
    	List<ExcST6B> excST6BList = null;
        
    	try {
            // load the ExcST6B
            excST6BList = ExcST6BBusinessDelegate.getExcST6BInstance().getAllExcST6B();
            
            if ( excST6BList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcST6Bs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcST6Bs ", exc );
        	return null;
        }

        return excST6BList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcST6B excST6B = null;
    private static final Logger LOGGER = Logger.getLogger(ExcST6BQueryRestController.class.getName());
    
}
