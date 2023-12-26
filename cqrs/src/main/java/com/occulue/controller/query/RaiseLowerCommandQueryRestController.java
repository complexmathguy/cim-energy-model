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
 * Implements Spring Controller query CQRS processing for entity RaiseLowerCommand.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/RaiseLowerCommand")
public class RaiseLowerCommandQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a RaiseLowerCommand using a UUID
     * @param		UUID raiseLowerCommandId
     * @return		RaiseLowerCommand
     */    
    @GetMapping("/load")
    public RaiseLowerCommand load( @RequestParam(required=true) UUID raiseLowerCommandId ) {
    	RaiseLowerCommand entity = null;

    	try {  
    		entity = RaiseLowerCommandBusinessDelegate.getRaiseLowerCommandInstance().getRaiseLowerCommand( new RaiseLowerCommandFetchOneSummary( raiseLowerCommandId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load RaiseLowerCommand using Id " + raiseLowerCommandId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all RaiseLowerCommand business objects
     * @return		Set<RaiseLowerCommand>
     */
    @GetMapping("/")
    public List<RaiseLowerCommand> loadAll() {                
    	List<RaiseLowerCommand> raiseLowerCommandList = null;
        
    	try {
            // load the RaiseLowerCommand
            raiseLowerCommandList = RaiseLowerCommandBusinessDelegate.getRaiseLowerCommandInstance().getAllRaiseLowerCommand();
            
            if ( raiseLowerCommandList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all RaiseLowerCommands" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all RaiseLowerCommands ", exc );
        	return null;
        }

        return raiseLowerCommandList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected RaiseLowerCommand raiseLowerCommand = null;
    private static final Logger LOGGER = Logger.getLogger(RaiseLowerCommandQueryRestController.class.getName());
    
}
