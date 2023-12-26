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
 * Implements Spring Controller query CQRS processing for entity SvShuntCompensatorSections.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SvShuntCompensatorSections")
public class SvShuntCompensatorSectionsQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a SvShuntCompensatorSections using a UUID
     * @param		UUID svShuntCompensatorSectionsId
     * @return		SvShuntCompensatorSections
     */    
    @GetMapping("/load")
    public SvShuntCompensatorSections load( @RequestParam(required=true) UUID svShuntCompensatorSectionsId ) {
    	SvShuntCompensatorSections entity = null;

    	try {  
    		entity = SvShuntCompensatorSectionsBusinessDelegate.getSvShuntCompensatorSectionsInstance().getSvShuntCompensatorSections( new SvShuntCompensatorSectionsFetchOneSummary( svShuntCompensatorSectionsId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load SvShuntCompensatorSections using Id " + svShuntCompensatorSectionsId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all SvShuntCompensatorSections business objects
     * @return		Set<SvShuntCompensatorSections>
     */
    @GetMapping("/")
    public List<SvShuntCompensatorSections> loadAll() {                
    	List<SvShuntCompensatorSections> svShuntCompensatorSectionsList = null;
        
    	try {
            // load the SvShuntCompensatorSections
            svShuntCompensatorSectionsList = SvShuntCompensatorSectionsBusinessDelegate.getSvShuntCompensatorSectionsInstance().getAllSvShuntCompensatorSections();
            
            if ( svShuntCompensatorSectionsList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all SvShuntCompensatorSectionss" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all SvShuntCompensatorSectionss ", exc );
        	return null;
        }

        return svShuntCompensatorSectionsList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected SvShuntCompensatorSections svShuntCompensatorSections = null;
    private static final Logger LOGGER = Logger.getLogger(SvShuntCompensatorSectionsQueryRestController.class.getName());
    
}
