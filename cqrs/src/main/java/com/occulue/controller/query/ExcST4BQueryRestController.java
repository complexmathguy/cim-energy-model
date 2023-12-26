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
 * Implements Spring Controller query CQRS processing for entity ExcST4B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcST4B")
public class ExcST4BQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcST4B using a UUID
     * @param		UUID excST4BId
     * @return		ExcST4B
     */    
    @GetMapping("/load")
    public ExcST4B load( @RequestParam(required=true) UUID excST4BId ) {
    	ExcST4B entity = null;

    	try {  
    		entity = ExcST4BBusinessDelegate.getExcST4BInstance().getExcST4B( new ExcST4BFetchOneSummary( excST4BId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcST4B using Id " + excST4BId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcST4B business objects
     * @return		Set<ExcST4B>
     */
    @GetMapping("/")
    public List<ExcST4B> loadAll() {                
    	List<ExcST4B> excST4BList = null;
        
    	try {
            // load the ExcST4B
            excST4BList = ExcST4BBusinessDelegate.getExcST4BInstance().getAllExcST4B();
            
            if ( excST4BList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcST4Bs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcST4Bs ", exc );
        	return null;
        }

        return excST4BList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcST4B excST4B = null;
    private static final Logger LOGGER = Logger.getLogger(ExcST4BQueryRestController.class.getName());
    
}
