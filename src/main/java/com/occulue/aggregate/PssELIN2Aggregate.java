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
 * Aggregate handler for PssELIN2 as outlined for the CQRS pattern, all write responsibilities 
 * related to PssELIN2 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PssELIN2Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PssELIN2Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PssELIN2Aggregate(CreatePssELIN2Command command) throws Exception {
    	LOGGER.info( "Handling command CreatePssELIN2Command" );
    	CreatePssELIN2Event event = new CreatePssELIN2Event(command.getPssELIN2Id(), command.getApss(), command.getKs1(), command.getKs2(), command.getPpss(), command.getPsslim(), command.getTs1(), command.getTs2(), command.getTs3(), command.getTs4(), command.getTs5(), command.getTs6());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePssELIN2Command command) throws Exception {
    	LOGGER.info( "handling command UpdatePssELIN2Command" );
    	UpdatePssELIN2Event event = new UpdatePssELIN2Event(command.getPssELIN2Id(), command.getApss(), command.getKs1(), command.getKs2(), command.getPpss(), command.getPsslim(), command.getTs1(), command.getTs2(), command.getTs3(), command.getTs4(), command.getTs5(), command.getTs6());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePssELIN2Command command) throws Exception {
    	LOGGER.info( "Handling command DeletePssELIN2Command" );
        apply(new DeletePssELIN2Event(command.getPssELIN2Id()));
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
    void on(CreatePssELIN2Event event) {	
    	LOGGER.info( "Event sourcing CreatePssELIN2Event" );
    	this.pssELIN2Id = event.getPssELIN2Id();
        this.apss = event.getApss();
        this.ks1 = event.getKs1();
        this.ks2 = event.getKs2();
        this.ppss = event.getPpss();
        this.psslim = event.getPsslim();
        this.ts1 = event.getTs1();
        this.ts2 = event.getTs2();
        this.ts3 = event.getTs3();
        this.ts4 = event.getTs4();
        this.ts5 = event.getTs5();
        this.ts6 = event.getTs6();
    }
    
    @EventSourcingHandler
    void on(UpdatePssELIN2Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.apss = event.getApss();
        this.ks1 = event.getKs1();
        this.ks2 = event.getKs2();
        this.ppss = event.getPpss();
        this.psslim = event.getPsslim();
        this.ts1 = event.getTs1();
        this.ts2 = event.getTs2();
        this.ts3 = event.getTs3();
        this.ts4 = event.getTs4();
        this.ts5 = event.getTs5();
        this.ts6 = event.getTs6();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID pssELIN2Id;
    
    private String apss;
    private String ks1;
    private String ks2;
    private String ppss;
    private String psslim;
    private String ts1;
    private String ts2;
    private String ts3;
    private String ts4;
    private String ts5;
    private String ts6;

    private static final Logger LOGGER 	= Logger.getLogger(PssELIN2Aggregate.class.getName());
}
