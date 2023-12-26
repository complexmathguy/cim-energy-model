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
 * Implements Spring Controller query CQRS processing for entity VisibilityLayer.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/VisibilityLayer")
public class VisibilityLayerQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a VisibilityLayer using a UUID
     * @param		UUID visibilityLayerId
     * @return		VisibilityLayer
     */    
    @GetMapping("/load")
    public VisibilityLayer load( @RequestParam(required=true) UUID visibilityLayerId ) {
    	VisibilityLayer entity = null;

    	try {  
    		entity = VisibilityLayerBusinessDelegate.getVisibilityLayerInstance().getVisibilityLayer( new VisibilityLayerFetchOneSummary( visibilityLayerId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load VisibilityLayer using Id " + visibilityLayerId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all VisibilityLayer business objects
     * @return		Set<VisibilityLayer>
     */
    @GetMapping("/")
    public List<VisibilityLayer> loadAll() {                
    	List<VisibilityLayer> visibilityLayerList = null;
        
    	try {
            // load the VisibilityLayer
            visibilityLayerList = VisibilityLayerBusinessDelegate.getVisibilityLayerInstance().getAllVisibilityLayer();
            
            if ( visibilityLayerList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all VisibilityLayers" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all VisibilityLayers ", exc );
        	return null;
        }

        return visibilityLayerList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected VisibilityLayer visibilityLayer = null;
    private static final Logger LOGGER = Logger.getLogger(VisibilityLayerQueryRestController.class.getName());
    
}
