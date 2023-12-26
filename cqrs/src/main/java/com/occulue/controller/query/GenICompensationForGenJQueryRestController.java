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
 * Implements Spring Controller query CQRS processing for entity GenICompensationForGenJ.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GenICompensationForGenJ")
public class GenICompensationForGenJQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a GenICompensationForGenJ using a UUID
     * @param		UUID genICompensationForGenJId
     * @return		GenICompensationForGenJ
     */    
    @GetMapping("/load")
    public GenICompensationForGenJ load( @RequestParam(required=true) UUID genICompensationForGenJId ) {
    	GenICompensationForGenJ entity = null;

    	try {  
    		entity = GenICompensationForGenJBusinessDelegate.getGenICompensationForGenJInstance().getGenICompensationForGenJ( new GenICompensationForGenJFetchOneSummary( genICompensationForGenJId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load GenICompensationForGenJ using Id " + genICompensationForGenJId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all GenICompensationForGenJ business objects
     * @return		Set<GenICompensationForGenJ>
     */
    @GetMapping("/")
    public List<GenICompensationForGenJ> loadAll() {                
    	List<GenICompensationForGenJ> genICompensationForGenJList = null;
        
    	try {
            // load the GenICompensationForGenJ
            genICompensationForGenJList = GenICompensationForGenJBusinessDelegate.getGenICompensationForGenJInstance().getAllGenICompensationForGenJ();
            
            if ( genICompensationForGenJList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all GenICompensationForGenJs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all GenICompensationForGenJs ", exc );
        	return null;
        }

        return genICompensationForGenJList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected GenICompensationForGenJ genICompensationForGenJ = null;
    private static final Logger LOGGER = Logger.getLogger(GenICompensationForGenJQueryRestController.class.getName());
    
}
