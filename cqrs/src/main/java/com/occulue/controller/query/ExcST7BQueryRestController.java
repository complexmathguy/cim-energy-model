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
 * Implements Spring Controller query CQRS processing for entity ExcST7B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcST7B")
public class ExcST7BQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcST7B using a UUID
     * @param		UUID excST7BId
     * @return		ExcST7B
     */    
    @GetMapping("/load")
    public ExcST7B load( @RequestParam(required=true) UUID excST7BId ) {
    	ExcST7B entity = null;

    	try {  
    		entity = ExcST7BBusinessDelegate.getExcST7BInstance().getExcST7B( new ExcST7BFetchOneSummary( excST7BId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcST7B using Id " + excST7BId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcST7B business objects
     * @return		Set<ExcST7B>
     */
    @GetMapping("/")
    public List<ExcST7B> loadAll() {                
    	List<ExcST7B> excST7BList = null;
        
    	try {
            // load the ExcST7B
            excST7BList = ExcST7BBusinessDelegate.getExcST7BInstance().getAllExcST7B();
            
            if ( excST7BList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcST7Bs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcST7Bs ", exc );
        	return null;
        }

        return excST7BList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcST7B excST7B = null;
    private static final Logger LOGGER = Logger.getLogger(ExcST7BQueryRestController.class.getName());
    
}
