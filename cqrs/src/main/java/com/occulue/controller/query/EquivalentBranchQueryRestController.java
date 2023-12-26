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
 * Implements Spring Controller query CQRS processing for entity EquivalentBranch.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/EquivalentBranch")
public class EquivalentBranchQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a EquivalentBranch using a UUID
     * @param		UUID equivalentBranchId
     * @return		EquivalentBranch
     */    
    @GetMapping("/load")
    public EquivalentBranch load( @RequestParam(required=true) UUID equivalentBranchId ) {
    	EquivalentBranch entity = null;

    	try {  
    		entity = EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().getEquivalentBranch( new EquivalentBranchFetchOneSummary( equivalentBranchId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load EquivalentBranch using Id " + equivalentBranchId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all EquivalentBranch business objects
     * @return		Set<EquivalentBranch>
     */
    @GetMapping("/")
    public List<EquivalentBranch> loadAll() {                
    	List<EquivalentBranch> equivalentBranchList = null;
        
    	try {
            // load the EquivalentBranch
            equivalentBranchList = EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().getAllEquivalentBranch();
            
            if ( equivalentBranchList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all EquivalentBranchs" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all EquivalentBranchs ", exc );
        	return null;
        }

        return equivalentBranchList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected EquivalentBranch equivalentBranch = null;
    private static final Logger LOGGER = Logger.getLogger(EquivalentBranchQueryRestController.class.getName());
    
}
