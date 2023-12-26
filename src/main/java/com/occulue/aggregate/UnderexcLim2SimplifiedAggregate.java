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
 * Aggregate handler for UnderexcLim2Simplified as outlined for the CQRS pattern, all write responsibilities 
 * related to UnderexcLim2Simplified are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class UnderexcLim2SimplifiedAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public UnderexcLim2SimplifiedAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public UnderexcLim2SimplifiedAggregate(CreateUnderexcLim2SimplifiedCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateUnderexcLim2SimplifiedCommand" );
    	CreateUnderexcLim2SimplifiedEvent event = new CreateUnderexcLim2SimplifiedEvent(command.getUnderexcLim2SimplifiedId(), command.getKui(), command.getP0(), command.getP1(), command.getQ0(), command.getQ1(), command.getVuimax(), command.getVuimin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateUnderexcLim2SimplifiedCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateUnderexcLim2SimplifiedCommand" );
    	UpdateUnderexcLim2SimplifiedEvent event = new UpdateUnderexcLim2SimplifiedEvent(command.getUnderexcLim2SimplifiedId(), command.getKui(), command.getP0(), command.getP1(), command.getQ0(), command.getQ1(), command.getVuimax(), command.getVuimin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteUnderexcLim2SimplifiedCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteUnderexcLim2SimplifiedCommand" );
        apply(new DeleteUnderexcLim2SimplifiedEvent(command.getUnderexcLim2SimplifiedId()));
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
    void on(CreateUnderexcLim2SimplifiedEvent event) {	
    	LOGGER.info( "Event sourcing CreateUnderexcLim2SimplifiedEvent" );
    	this.underexcLim2SimplifiedId = event.getUnderexcLim2SimplifiedId();
        this.kui = event.getKui();
        this.p0 = event.getP0();
        this.p1 = event.getP1();
        this.q0 = event.getQ0();
        this.q1 = event.getQ1();
        this.vuimax = event.getVuimax();
        this.vuimin = event.getVuimin();
    }
    
    @EventSourcingHandler
    void on(UpdateUnderexcLim2SimplifiedEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.kui = event.getKui();
        this.p0 = event.getP0();
        this.p1 = event.getP1();
        this.q0 = event.getQ0();
        this.q1 = event.getQ1();
        this.vuimax = event.getVuimax();
        this.vuimin = event.getVuimin();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID underexcLim2SimplifiedId;
    
    private String kui;
    private String p0;
    private String p1;
    private String q0;
    private String q1;
    private String vuimax;
    private String vuimin;

    private static final Logger LOGGER 	= Logger.getLogger(UnderexcLim2SimplifiedAggregate.class.getName());
}
