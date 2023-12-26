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
 * Implements Spring Controller query CQRS processing for entity DiagramObject.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DiagramObject")
public class DiagramObjectQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a DiagramObject using a UUID
     * @param		UUID diagramObjectId
     * @return		DiagramObject
     */    
    @GetMapping("/load")
    public DiagramObject load( @RequestParam(required=true) UUID diagramObjectId ) {
    	DiagramObject entity = null;

    	try {  
    		entity = DiagramObjectBusinessDelegate.getDiagramObjectInstance().getDiagramObject( new DiagramObjectFetchOneSummary( diagramObjectId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load DiagramObject using Id " + diagramObjectId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all DiagramObject business objects
     * @return		Set<DiagramObject>
     */
    @GetMapping("/")
    public List<DiagramObject> loadAll() {                
    	List<DiagramObject> diagramObjectList = null;
        
    	try {
            // load the DiagramObject
            diagramObjectList = DiagramObjectBusinessDelegate.getDiagramObjectInstance().getAllDiagramObject();
            
            if ( diagramObjectList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all DiagramObjects" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all DiagramObjects ", exc );
        	return null;
        }

        return diagramObjectList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected DiagramObject diagramObject = null;
    private static final Logger LOGGER = Logger.getLogger(DiagramObjectQueryRestController.class.getName());
    
}
