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
 * Implements Spring Controller query CQRS processing for entity Line.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Line")
public class LineQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a Line using a UUID
     * @param		UUID lineId
     * @return		Line
     */    
    @GetMapping("/load")
    public Line load( @RequestParam(required=true) UUID lineId ) {
    	Line entity = null;

    	try {  
    		entity = LineBusinessDelegate.getLineInstance().getLine( new LineFetchOneSummary( lineId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load Line using Id " + lineId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all Line business objects
     * @return		Set<Line>
     */
    @GetMapping("/")
    public List<Line> loadAll() {                
    	List<Line> lineList = null;
        
    	try {
            // load the Line
            lineList = LineBusinessDelegate.getLineInstance().getAllLine();
            
            if ( lineList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all Lines" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all Lines ", exc );
        	return null;
        }

        return lineList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected Line line = null;
    private static final Logger LOGGER = Logger.getLogger(LineQueryRestController.class.getName());
    
}
