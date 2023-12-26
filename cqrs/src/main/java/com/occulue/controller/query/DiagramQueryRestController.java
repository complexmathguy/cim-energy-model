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
 * Implements Spring Controller query CQRS processing for entity Diagram.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Diagram")
public class DiagramQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Diagram using a UUID
     * @param		UUID diagramId
     * @return		Diagram
     */    
    @GetMapping("/load")
    public Diagram load( @RequestParam(required=true) UUID diagramId ) {
    	Diagram entity = null;

    	try {  
    		entity = DiagramBusinessDelegate.getDiagramInstance().getDiagram( new DiagramFetchOneSummary( diagramId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Diagram using Id " + diagramId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Diagram business objects
     * @return		Set<Diagram>
     */
    @GetMapping("/")
    public List<Diagram> loadAll() {                
    	List<Diagram> diagramList = null;
        
    	try {
            // load the Diagram
            diagramList = DiagramBusinessDelegate.getDiagramInstance().getAllDiagram();
            
            if ( diagramList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Diagrams" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Diagrams ", exc );
        	return null;
        }

        return diagramList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Diagram diagram = null;
    private static final Logger LOGGER = Logger.getLogger(DiagramQueryRestController.class.getName());
    
}
