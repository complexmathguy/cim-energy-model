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
 * Implements Spring Controller query CQRS processing for entity PssPTIST1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PssPTIST1")
public class PssPTIST1QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a PssPTIST1 using a UUID
     * @param		UUID pssPTIST1Id
     * @return		PssPTIST1
     */    
    @GetMapping("/load")
    public PssPTIST1 load( @RequestParam(required=true) UUID pssPTIST1Id ) {
    	PssPTIST1 entity = null;

    	try {  
    		entity = PssPTIST1BusinessDelegate.getPssPTIST1Instance().getPssPTIST1( new PssPTIST1FetchOneSummary( pssPTIST1Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load PssPTIST1 using Id " + pssPTIST1Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all PssPTIST1 business objects
     * @return		Set<PssPTIST1>
     */
    @GetMapping("/")
    public List<PssPTIST1> loadAll() {                
    	List<PssPTIST1> pssPTIST1List = null;
        
    	try {
            // load the PssPTIST1
            pssPTIST1List = PssPTIST1BusinessDelegate.getPssPTIST1Instance().getAllPssPTIST1();
            
            if ( pssPTIST1List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all PssPTIST1s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all PssPTIST1s ", exc );
        	return null;
        }

        return pssPTIST1List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected PssPTIST1 pssPTIST1 = null;
    private static final Logger LOGGER = Logger.getLogger(PssPTIST1QueryRestController.class.getName());
    
}
