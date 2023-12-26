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
 * Implements Spring Controller query CQRS processing for entity ExcIEEEDC4B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEDC4B")
public class ExcIEEEDC4BQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ExcIEEEDC4B using a UUID
     * @param		UUID excIEEEDC4BId
     * @return		ExcIEEEDC4B
     */    
    @GetMapping("/load")
    public ExcIEEEDC4B load( @RequestParam(required=true) UUID excIEEEDC4BId ) {
    	ExcIEEEDC4B entity = null;

    	try {  
    		entity = ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().getExcIEEEDC4B( new ExcIEEEDC4BFetchOneSummary( excIEEEDC4BId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ExcIEEEDC4B using Id " + excIEEEDC4BId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ExcIEEEDC4B business objects
     * @return		Set<ExcIEEEDC4B>
     */
    @GetMapping("/")
    public List<ExcIEEEDC4B> loadAll() {                
    	List<ExcIEEEDC4B> excIEEEDC4BList = null;
        
    	try {
            // load the ExcIEEEDC4B
            excIEEEDC4BList = ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().getAllExcIEEEDC4B();
            
            if ( excIEEEDC4BList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ExcIEEEDC4Bs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ExcIEEEDC4Bs ", exc );
        	return null;
        }

        return excIEEEDC4BList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ExcIEEEDC4B excIEEEDC4B = null;
    private static final Logger LOGGER = Logger.getLogger(ExcIEEEDC4BQueryRestController.class.getName());
    
}
