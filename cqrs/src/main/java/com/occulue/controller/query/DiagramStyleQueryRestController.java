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
 * Implements Spring Controller query CQRS processing for entity DiagramStyle.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DiagramStyle")
public class DiagramStyleQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a DiagramStyle using a UUID
     * @param		UUID diagramStyleId
     * @return		DiagramStyle
     */    
    @GetMapping("/load")
    public DiagramStyle load( @RequestParam(required=true) UUID diagramStyleId ) {
    	DiagramStyle entity = null;

    	try {  
    		entity = DiagramStyleBusinessDelegate.getDiagramStyleInstance().getDiagramStyle( new DiagramStyleFetchOneSummary( diagramStyleId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load DiagramStyle using Id " + diagramStyleId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all DiagramStyle business objects
     * @return		Set<DiagramStyle>
     */
    @GetMapping("/")
    public List<DiagramStyle> loadAll() {                
    	List<DiagramStyle> diagramStyleList = null;
        
    	try {
            // load the DiagramStyle
            diagramStyleList = DiagramStyleBusinessDelegate.getDiagramStyleInstance().getAllDiagramStyle();
            
            if ( diagramStyleList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all DiagramStyles" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all DiagramStyles ", exc );
        	return null;
        }

        return diagramStyleList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected DiagramStyle diagramStyle = null;
    private static final Logger LOGGER = Logger.getLogger(DiagramStyleQueryRestController.class.getName());
    
}
