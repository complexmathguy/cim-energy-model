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
 * Implements Spring Controller query CQRS processing for entity TransformerEnd.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TransformerEnd")
public class TransformerEndQueryRestController extends BaseSpringRestController {

	
    /**
     * Handles loading a TransformerEnd using a UUID
     * @param		UUID transformerEndId
     * @return		TransformerEnd
     */    
    @GetMapping("/load")
    public TransformerEnd load( @RequestParam(required=true) UUID transformerEndId ) {
    	TransformerEnd entity = null;

    	try {  
    		entity = TransformerEndBusinessDelegate.getTransformerEndInstance().getTransformerEnd( new TransformerEndFetchOneSummary( transformerEndId ) );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING, "failed to load TransformerEnd using Id " + transformerEndId );
            return null;
        }

        return entity;
    }

    /**
     * Handles loading all TransformerEnd business objects
     * @return		Set<TransformerEnd>
     */
    @GetMapping("/")
    public List<TransformerEnd> loadAll() {                
    	List<TransformerEnd> transformerEndList = null;
        
    	try {
            // load the TransformerEnd
            transformerEndList = TransformerEndBusinessDelegate.getTransformerEndInstance().getAllTransformerEnd();
            
            if ( transformerEndList != null )
                LOGGER.log( Level.INFO,  "successfully loaded all TransformerEnds" );
        }
        catch( Throwable exc ) {
            LOGGER.log( Level.WARNING,  "failed to load all TransformerEnds ", exc );
        	return null;
        }

        return transformerEndList;
                            
    }



//************************************************************************    
// Attributes
//************************************************************************
    protected TransformerEnd transformerEnd = null;
    private static final Logger LOGGER = Logger.getLogger(TransformerEndQueryRestController.class.getName());
    
}
