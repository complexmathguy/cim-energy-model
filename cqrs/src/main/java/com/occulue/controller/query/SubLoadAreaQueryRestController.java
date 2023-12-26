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
 * Implements Spring Controller query CQRS processing for entity SubLoadArea.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SubLoadArea")
public class SubLoadAreaQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a SubLoadArea using a UUID
     * @param		UUID subLoadAreaId
     * @return		SubLoadArea
     */    
    @GetMapping("/load")
    public SubLoadArea load( @RequestParam(required=true) UUID subLoadAreaId ) {
    	SubLoadArea entity = null;

    	try {  
    		entity = SubLoadAreaBusinessDelegate.getSubLoadAreaInstance().getSubLoadArea( new SubLoadAreaFetchOneSummary( subLoadAreaId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load SubLoadArea using Id " + subLoadAreaId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all SubLoadArea business objects
     * @return		Set<SubLoadArea>
     */
    @GetMapping("/")
    public List<SubLoadArea> loadAll() {                
    	List<SubLoadArea> subLoadAreaList = null;
        
    	try {
            // load the SubLoadArea
            subLoadAreaList = SubLoadAreaBusinessDelegate.getSubLoadAreaInstance().getAllSubLoadArea();
            
            if ( subLoadAreaList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all SubLoadAreas" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all SubLoadAreas ", exc );
        	return null;
        }

        return subLoadAreaList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected SubLoadArea subLoadArea = null;
    private static final Logger LOGGER = Logger.getLogger(SubLoadAreaQueryRestController.class.getName());
    
}
