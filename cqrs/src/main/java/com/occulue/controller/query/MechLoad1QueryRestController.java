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
 * Implements Spring Controller query CQRS processing for entity MechLoad1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/MechLoad1")
public class MechLoad1QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a MechLoad1 using a UUID
     * @param		UUID mechLoad1Id
     * @return		MechLoad1
     */    
    @GetMapping("/load")
    public MechLoad1 load( @RequestParam(required=true) UUID mechLoad1Id ) {
    	MechLoad1 entity = null;

    	try {  
    		entity = MechLoad1BusinessDelegate.getMechLoad1Instance().getMechLoad1( new MechLoad1FetchOneSummary( mechLoad1Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load MechLoad1 using Id " + mechLoad1Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all MechLoad1 business objects
     * @return		Set<MechLoad1>
     */
    @GetMapping("/")
    public List<MechLoad1> loadAll() {                
    	List<MechLoad1> mechLoad1List = null;
        
    	try {
            // load the MechLoad1
            mechLoad1List = MechLoad1BusinessDelegate.getMechLoad1Instance().getAllMechLoad1();
            
            if ( mechLoad1List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all MechLoad1s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all MechLoad1s ", exc );
        	return null;
        }

        return mechLoad1List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected MechLoad1 mechLoad1 = null;
    private static final Logger LOGGER = Logger.getLogger(MechLoad1QueryRestController.class.getName());
    
}
