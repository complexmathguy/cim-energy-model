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
 * Implements Spring Controller query CQRS processing for entity InductancePerLength.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/InductancePerLength")
public class InductancePerLengthQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a InductancePerLength using a UUID
     * @param		UUID inductancePerLengthId
     * @return		InductancePerLength
     */    
    @GetMapping("/load")
    public InductancePerLength load( @RequestParam(required=true) UUID inductancePerLengthId ) {
    	InductancePerLength entity = null;

    	try {  
    		entity = InductancePerLengthBusinessDelegate.getInductancePerLengthInstance().getInductancePerLength( new InductancePerLengthFetchOneSummary( inductancePerLengthId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load InductancePerLength using Id " + inductancePerLengthId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all InductancePerLength business objects
     * @return		Set<InductancePerLength>
     */
    @GetMapping("/")
    public List<InductancePerLength> loadAll() {                
    	List<InductancePerLength> inductancePerLengthList = null;
        
    	try {
            // load the InductancePerLength
            inductancePerLengthList = InductancePerLengthBusinessDelegate.getInductancePerLengthInstance().getAllInductancePerLength();
            
            if ( inductancePerLengthList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all InductancePerLengths" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all InductancePerLengths ", exc );
        	return null;
        }

        return inductancePerLengthList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected InductancePerLength inductancePerLength = null;
    private static final Logger LOGGER = Logger.getLogger(InductancePerLengthQueryRestController.class.getName());
    
}
