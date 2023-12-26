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
 * Aggregate handler for LoadGenericNonLinear as outlined for the CQRS pattern, all write responsibilities 
 * related to LoadGenericNonLinear are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class LoadGenericNonLinearAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public LoadGenericNonLinearAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public LoadGenericNonLinearAggregate(CreateLoadGenericNonLinearCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateLoadGenericNonLinearCommand" );
    	CreateLoadGenericNonLinearEvent event = new CreateLoadGenericNonLinearEvent(command.getLoadGenericNonLinearId(), command.getBs(), command.getBt(), command.getGenericNonLinearLoadModelType(), command.getLs(), command.getLt(), command.getPt(), command.getQt(), command.getTp(), command.getTq());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateLoadGenericNonLinearCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateLoadGenericNonLinearCommand" );
    	UpdateLoadGenericNonLinearEvent event = new UpdateLoadGenericNonLinearEvent(command.getLoadGenericNonLinearId(), command.getBs(), command.getBt(), command.getGenericNonLinearLoadModelType(), command.getLs(), command.getLt(), command.getPt(), command.getQt(), command.getTp(), command.getTq());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteLoadGenericNonLinearCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteLoadGenericNonLinearCommand" );
        apply(new DeleteLoadGenericNonLinearEvent(command.getLoadGenericNonLinearId()));
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
    void on(CreateLoadGenericNonLinearEvent event) {	
    	LOGGER.info( "Event sourcing CreateLoadGenericNonLinearEvent" );
    	this.loadGenericNonLinearId = event.getLoadGenericNonLinearId();
        this.bs = event.getBs();
        this.bt = event.getBt();
        this.genericNonLinearLoadModelType = event.getGenericNonLinearLoadModelType();
        this.ls = event.getLs();
        this.lt = event.getLt();
        this.pt = event.getPt();
        this.qt = event.getQt();
        this.tp = event.getTp();
        this.tq = event.getTq();
    }
    
    @EventSourcingHandler
    void on(UpdateLoadGenericNonLinearEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.bs = event.getBs();
        this.bt = event.getBt();
        this.genericNonLinearLoadModelType = event.getGenericNonLinearLoadModelType();
        this.ls = event.getLs();
        this.lt = event.getLt();
        this.pt = event.getPt();
        this.qt = event.getQt();
        this.tp = event.getTp();
        this.tq = event.getTq();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID loadGenericNonLinearId;
    
    private String bs;
    private String bt;
    private String genericNonLinearLoadModelType;
    private String ls;
    private String lt;
    private String pt;
    private String qt;
    private String tp;
    private String tq;

    private static final Logger LOGGER 	= Logger.getLogger(LoadGenericNonLinearAggregate.class.getName());
}
