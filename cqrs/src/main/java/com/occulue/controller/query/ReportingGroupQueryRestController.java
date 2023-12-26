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
 * Implements Spring Controller query CQRS processing for entity ReportingGroup.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ReportingGroup")
public class ReportingGroupQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a ReportingGroup using a UUID
     * @param		UUID reportingGroupId
     * @return		ReportingGroup
     */    
    @GetMapping("/load")
    public ReportingGroup load( @RequestParam(required=true) UUID reportingGroupId ) {
    	ReportingGroup entity = null;

    	try {  
    		entity = ReportingGroupBusinessDelegate.getReportingGroupInstance().getReportingGroup( new ReportingGroupFetchOneSummary( reportingGroupId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load ReportingGroup using Id " + reportingGroupId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all ReportingGroup business objects
     * @return		Set<ReportingGroup>
     */
    @GetMapping("/")
    public List<ReportingGroup> loadAll() {                
    	List<ReportingGroup> reportingGroupList = null;
        
    	try {
            // load the ReportingGroup
            reportingGroupList = ReportingGroupBusinessDelegate.getReportingGroupInstance().getAllReportingGroup();
            
            if ( reportingGroupList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all ReportingGroups" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all ReportingGroups ", exc );
        	return null;
        }

        return reportingGroupList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected ReportingGroup reportingGroup = null;
    private static final Logger LOGGER = Logger.getLogger(ReportingGroupQueryRestController.class.getName());
    
}
