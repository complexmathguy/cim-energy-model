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
 * Implements Spring Controller query CQRS processing for entity PssPTIST3.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PssPTIST3")
public class PssPTIST3QueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a PssPTIST3 using a UUID
     * @param		UUID pssPTIST3Id
     * @return		PssPTIST3
     */    
    @GetMapping("/load")
    public PssPTIST3 load( @RequestParam(required=true) UUID pssPTIST3Id ) {
    	PssPTIST3 entity = null;

    	try {  
    		entity = PssPTIST3BusinessDelegate.getPssPTIST3Instance().getPssPTIST3( new PssPTIST3FetchOneSummary( pssPTIST3Id ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load PssPTIST3 using Id " + pssPTIST3Id );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all PssPTIST3 business objects
     * @return		Set<PssPTIST3>
     */
    @GetMapping("/")
    public List<PssPTIST3> loadAll() {                
    	List<PssPTIST3> pssPTIST3List = null;
        
    	try {
            // load the PssPTIST3
            pssPTIST3List = PssPTIST3BusinessDelegate.getPssPTIST3Instance().getAllPssPTIST3();
            
            if ( pssPTIST3List != null )
                LOGGER.log( Level.INFO,  "successfully loaded all PssPTIST3s" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all PssPTIST3s ", exc );
        	return null;
        }

        return pssPTIST3List;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected PssPTIST3 pssPTIST3 = null;
    private static final Logger LOGGER = Logger.getLogger(PssPTIST3QueryRestController.class.getName());
    
}
