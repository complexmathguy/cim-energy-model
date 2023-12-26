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
 * Implements Spring Controller query CQRS processing for entity Length.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Length")
public class LengthQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Length using a UUID
     * @param		UUID lengthId
     * @return		Length
     */    
    @GetMapping("/load")
    public Length load( @RequestParam(required=true) UUID lengthId ) {
    	Length entity = null;

    	try {  
    		entity = LengthBusinessDelegate.getLengthInstance().getLength( new LengthFetchOneSummary( lengthId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Length using Id " + lengthId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Length business objects
     * @return		Set<Length>
     */
    @GetMapping("/")
    public List<Length> loadAll() {                
    	List<Length> lengthList = null;
        
    	try {
            // load the Length
            lengthList = LengthBusinessDelegate.getLengthInstance().getAllLength();
            
            if ( lengthList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Lengths" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Lengths ", exc );
        	return null;
        }

        return lengthList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Length length = null;
    private static final Logger LOGGER = Logger.getLogger(LengthQueryRestController.class.getName());
    
}
