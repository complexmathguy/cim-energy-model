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
 * Implements Spring Controller query CQRS processing for entity DomainVersion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DomainVersion")
public class DomainVersionQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a DomainVersion using a UUID
     * @param		UUID domainVersionId
     * @return		DomainVersion
     */    
    @GetMapping("/load")
    public DomainVersion load( @RequestParam(required=true) UUID domainVersionId ) {
    	DomainVersion entity = null;

    	try {  
    		entity = DomainVersionBusinessDelegate.getDomainVersionInstance().getDomainVersion( new DomainVersionFetchOneSummary( domainVersionId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load DomainVersion using Id " + domainVersionId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all DomainVersion business objects
     * @return		Set<DomainVersion>
     */
    @GetMapping("/")
    public List<DomainVersion> loadAll() {                
    	List<DomainVersion> domainVersionList = null;
        
    	try {
            // load the DomainVersion
            domainVersionList = DomainVersionBusinessDelegate.getDomainVersionInstance().getAllDomainVersion();
            
            if ( domainVersionList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all DomainVersions" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all DomainVersions ", exc );
        	return null;
        }

        return domainVersionList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected DomainVersion domainVersion = null;
    private static final Logger LOGGER = Logger.getLogger(DomainVersionQueryRestController.class.getName());
    
}
