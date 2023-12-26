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
 * Implements Spring Controller query CQRS processing for entity DiagramObjectPoint.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DiagramObjectPoint")
public class DiagramObjectPointQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a DiagramObjectPoint using a UUID
     * @param		UUID diagramObjectPointId
     * @return		DiagramObjectPoint
     */    
    @GetMapping("/load")
    public DiagramObjectPoint load( @RequestParam(required=true) UUID diagramObjectPointId ) {
    	DiagramObjectPoint entity = null;

    	try {  
    		entity = DiagramObjectPointBusinessDelegate.getDiagramObjectPointInstance().getDiagramObjectPoint( new DiagramObjectPointFetchOneSummary( diagramObjectPointId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load DiagramObjectPoint using Id " + diagramObjectPointId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all DiagramObjectPoint business objects
     * @return		Set<DiagramObjectPoint>
     */
    @GetMapping("/")
    public List<DiagramObjectPoint> loadAll() {                
    	List<DiagramObjectPoint> diagramObjectPointList = null;
        
    	try {
            // load the DiagramObjectPoint
            diagramObjectPointList = DiagramObjectPointBusinessDelegate.getDiagramObjectPointInstance().getAllDiagramObjectPoint();
            
            if ( diagramObjectPointList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all DiagramObjectPoints" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all DiagramObjectPoints ", exc );
        	return null;
        }

        return diagramObjectPointList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected DiagramObjectPoint diagramObjectPoint = null;
    private static final Logger LOGGER = Logger.getLogger(DiagramObjectPointQueryRestController.class.getName());
    
}
