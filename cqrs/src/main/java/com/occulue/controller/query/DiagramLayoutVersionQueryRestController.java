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
 * Implements Spring Controller query CQRS processing for entity DiagramLayoutVersion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DiagramLayoutVersion")
public class DiagramLayoutVersionQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a DiagramLayoutVersion using a UUID
     * @param		UUID diagramLayoutVersionId
     * @return		DiagramLayoutVersion
     */    
    @GetMapping("/load")
    public DiagramLayoutVersion load( @RequestParam(required=true) UUID diagramLayoutVersionId ) {
    	DiagramLayoutVersion entity = null;

    	try {  
    		entity = DiagramLayoutVersionBusinessDelegate.getDiagramLayoutVersionInstance().getDiagramLayoutVersion( new DiagramLayoutVersionFetchOneSummary( diagramLayoutVersionId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load DiagramLayoutVersion using Id " + diagramLayoutVersionId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all DiagramLayoutVersion business objects
     * @return		Set<DiagramLayoutVersion>
     */
    @GetMapping("/")
    public List<DiagramLayoutVersion> loadAll() {                
    	List<DiagramLayoutVersion> diagramLayoutVersionList = null;
        
    	try {
            // load the DiagramLayoutVersion
            diagramLayoutVersionList = DiagramLayoutVersionBusinessDelegate.getDiagramLayoutVersionInstance().getAllDiagramLayoutVersion();
            
            if ( diagramLayoutVersionList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all DiagramLayoutVersions" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all DiagramLayoutVersions ", exc );
        	return null;
        }

        return diagramLayoutVersionList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected DiagramLayoutVersion diagramLayoutVersion = null;
    private static final Logger LOGGER = Logger.getLogger(DiagramLayoutVersionQueryRestController.class.getName());
    
}
