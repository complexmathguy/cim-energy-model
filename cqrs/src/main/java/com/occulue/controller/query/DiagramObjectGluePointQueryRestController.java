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
 * Implements Spring Controller query CQRS processing for entity DiagramObjectGluePoint.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DiagramObjectGluePoint")
public class DiagramObjectGluePointQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a DiagramObjectGluePoint using a UUID
     * @param		UUID diagramObjectGluePointId
     * @return		DiagramObjectGluePoint
     */    
    @GetMapping("/load")
    public DiagramObjectGluePoint load( @RequestParam(required=true) UUID diagramObjectGluePointId ) {
    	DiagramObjectGluePoint entity = null;

    	try {  
    		entity = DiagramObjectGluePointBusinessDelegate.getDiagramObjectGluePointInstance().getDiagramObjectGluePoint( new DiagramObjectGluePointFetchOneSummary( diagramObjectGluePointId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load DiagramObjectGluePoint using Id " + diagramObjectGluePointId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all DiagramObjectGluePoint business objects
     * @return		Set<DiagramObjectGluePoint>
     */
    @GetMapping("/")
    public List<DiagramObjectGluePoint> loadAll() {                
    	List<DiagramObjectGluePoint> diagramObjectGluePointList = null;
        
    	try {
            // load the DiagramObjectGluePoint
            diagramObjectGluePointList = DiagramObjectGluePointBusinessDelegate.getDiagramObjectGluePointInstance().getAllDiagramObjectGluePoint();
            
            if ( diagramObjectGluePointList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all DiagramObjectGluePoints" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all DiagramObjectGluePoints ", exc );
        	return null;
        }

        return diagramObjectGluePointList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected DiagramObjectGluePoint diagramObjectGluePoint = null;
    private static final Logger LOGGER = Logger.getLogger(DiagramObjectGluePointQueryRestController.class.getName());
    
}
