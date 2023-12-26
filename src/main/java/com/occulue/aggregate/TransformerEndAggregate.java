package com.occulue.aggregate;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateMember;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import static org.axonframework.modelling.command.AggregateLifecycle.apply;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.context.annotation.Profile;

/**
 * Aggregate handler for TransformerEnd as outlined for the CQRS pattern, all write responsibilities 
 * related to TransformerEnd are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class TransformerEndAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public TransformerEndAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public TransformerEndAggregate(CreateTransformerEndCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateTransformerEndCommand" );
    	CreateTransformerEndEvent event = new CreateTransformerEndEvent(command.getTransformerEndId(), command.getEndNumber(), command.getGrounded(), command.getRground(), command.getXground());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateTransformerEndCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateTransformerEndCommand" );
    	UpdateTransformerEndEvent event = new UpdateTransformerEndEvent(command.getTransformerEndId(), command.getEndNumber(), command.getGrounded(), command.getRground(), command.getXground());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteTransformerEndCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteTransformerEndCommand" );
        apply(new DeleteTransformerEndEvent(command.getTransformerEndId()));
    }

	// ----------------------------------------------
	// association command handlers
	// ----------------------------------------------

    // single association commands

    // multiple association commands

	// ----------------------------------------------
	// intrinsic event source handlers
	// ----------------------------------------------
    @EventSourcingHandler
    void on(CreateTransformerEndEvent event) {	
    	LOGGER.info( "Event sourcing CreateTransformerEndEvent" );
    	this.transformerEndId = event.getTransformerEndId();
        this.endNumber = event.getEndNumber();
        this.grounded = event.getGrounded();
        this.rground = event.getRground();
        this.xground = event.getXground();
    }
    
    @EventSourcingHandler
    void on(UpdateTransformerEndEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.endNumber = event.getEndNumber();
        this.grounded = event.getGrounded();
        this.rground = event.getRground();
        this.xground = event.getXground();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID transformerEndId;
    
    private String endNumber;
    private String grounded;
    private String rground;
    private String xground;

    private static final Logger LOGGER 	= Logger.getLogger(TransformerEndAggregate.class.getName());
}
