/*******************************************************************************
  Turnstone Biologics Confidential
  
  2018 Turnstone Biologics
  All Rights Reserved.
  
  This file is subject to the terms and conditions defined in
  file 'license.txt', which is part of this source code package.
   
  Contributors :
        Turnstone Biologics - General Release
 ******************************************************************************/
package com.occulue.delegate;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import java.util.concurrent.*;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.validator.*;

/**
 * TextDiagramObject business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of TextDiagramObject related services in the case of a TextDiagramObject business related service failing.</li>
 * <li>Exposes a simpler, uniform TextDiagramObject interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill TextDiagramObject business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class TextDiagramObjectBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public TextDiagramObjectBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* TextDiagramObject Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	TextDiagramObjectBusinessDelegate
	*/
	public static TextDiagramObjectBusinessDelegate getTextDiagramObjectInstance() {
		return( new TextDiagramObjectBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createTextDiagramObject( CreateTextDiagramObjectCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getTextDiagramObjectId() == null )
				command.setTextDiagramObjectId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	TextDiagramObjectValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateTextDiagramObjectCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateTextDiagramObjectCommand of TextDiagramObject is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create TextDiagramObject - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateTextDiagramObjectCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateTextDiagramObject( UpdateTextDiagramObjectCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	TextDiagramObjectValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateTextDiagramObjectCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save TextDiagramObject - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteTextDiagramObjectCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteTextDiagramObjectCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	TextDiagramObjectValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteTextDiagramObjectCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete TextDiagramObject using Id = "  + command.getTextDiagramObjectId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the TextDiagramObject via TextDiagramObjectFetchOneSummary
     * @param 	summary TextDiagramObjectFetchOneSummary 
     * @return 	TextDiagramObjectFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public TextDiagramObject getTextDiagramObject( TextDiagramObjectFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "TextDiagramObjectFetchOneSummary arg cannot be null" );
    	
    	TextDiagramObject entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	TextDiagramObjectValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a TextDiagramObject
        	// --------------------------------------
        	CompletableFuture<TextDiagramObject> futureEntity = queryGateway.query(new FindTextDiagramObjectQuery( new LoadTextDiagramObjectFilter( summary.getTextDiagramObjectId() ) ), ResponseTypes.instanceOf(TextDiagramObject.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate TextDiagramObject with id " + summary.getTextDiagramObjectId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all TextDiagramObjects
     *
     * @return 	List<TextDiagramObject> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<TextDiagramObject> getAllTextDiagramObject() 
    throws ProcessingException {
        List<TextDiagramObject> list = null;

        try {
        	CompletableFuture<List<TextDiagramObject>> futureList = queryGateway.query(new FindAllTextDiagramObjectQuery(), ResponseTypes.multipleInstancesOf(TextDiagramObject.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all TextDiagramObject";
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return list;
    }




	/**
	 * Internal helper method to load the root 
	 * 
	 * @param		id	UUID
	 * @return		TextDiagramObject
	 */
	protected TextDiagramObject load( UUID id ) throws ProcessingException {
		textDiagramObject = TextDiagramObjectBusinessDelegate.getTextDiagramObjectInstance().getTextDiagramObject( new TextDiagramObjectFetchOneSummary(id) );	
		return textDiagramObject;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private TextDiagramObject textDiagramObject 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(TextDiagramObjectBusinessDelegate.class.getName());
    
}
