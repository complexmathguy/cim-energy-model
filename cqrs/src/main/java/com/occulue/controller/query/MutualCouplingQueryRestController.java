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
 * Implements Spring Controller query CQRS processing for entity MutualCoupling.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/MutualCoupling")
public class MutualCouplingQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a MutualCoupling using a UUID
     * @param		UUID mutualCouplingId
     * @return		MutualCoupling
     */    
    @GetMapping("/load")
    public MutualCoupling load( @RequestParam(required=true) UUID mutualCouplingId ) {
    	MutualCoupling entity = null;

    	try {  
    		entity = MutualCouplingBusinessDelegate.getMutualCouplingInstance().getMutualCoupling( new MutualCouplingFetchOneSummary( mutualCouplingId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load MutualCoupling using Id " + mutualCouplingId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all MutualCoupling business objects
     * @return		Set<MutualCoupling>
     */
    @GetMapping("/")
    public List<MutualCoupling> loadAll() {                
    	List<MutualCoupling> mutualCouplingList = null;
        
    	try {
            // load the MutualCoupling
            mutualCouplingList = MutualCouplingBusinessDelegate.getMutualCouplingInstance().getAllMutualCoupling();
            
            if ( mutualCouplingList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all MutualCouplings" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all MutualCouplings ", exc );
        	return null;
        }

        return mutualCouplingList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected MutualCoupling mutualCoupling = null;
    private static final Logger LOGGER = Logger.getLogger(MutualCouplingQueryRestController.class.getName());
    
}
