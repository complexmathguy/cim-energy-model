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
 * Aggregate handler for UnderexcLimIEEE1 as outlined for the CQRS pattern, all write responsibilities 
 * related to UnderexcLimIEEE1 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class UnderexcLimIEEE1Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public UnderexcLimIEEE1Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public UnderexcLimIEEE1Aggregate(CreateUnderexcLimIEEE1Command command) throws Exception {
    	LOGGER.info( "Handling command CreateUnderexcLimIEEE1Command" );
    	CreateUnderexcLimIEEE1Event event = new CreateUnderexcLimIEEE1Event(command.getUnderexcLimIEEE1Id(), command.getKuc(), command.getKuf(), command.getKui(), command.getKul(), command.getKur(), command.getTu1(), command.getTu2(), command.getTu3(), command.getTu4(), command.getVucmax(), command.getVuimax(), command.getVuimin(), command.getVulmax(), command.getVulmin(), command.getVurmax());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateUnderexcLimIEEE1Command command) throws Exception {
    	LOGGER.info( "handling command UpdateUnderexcLimIEEE1Command" );
    	UpdateUnderexcLimIEEE1Event event = new UpdateUnderexcLimIEEE1Event(command.getUnderexcLimIEEE1Id(), command.getKuc(), command.getKuf(), command.getKui(), command.getKul(), command.getKur(), command.getTu1(), command.getTu2(), command.getTu3(), command.getTu4(), command.getVucmax(), command.getVuimax(), command.getVuimin(), command.getVulmax(), command.getVulmin(), command.getVurmax());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteUnderexcLimIEEE1Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteUnderexcLimIEEE1Command" );
        apply(new DeleteUnderexcLimIEEE1Event(command.getUnderexcLimIEEE1Id()));
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
    void on(CreateUnderexcLimIEEE1Event event) {	
    	LOGGER.info( "Event sourcing CreateUnderexcLimIEEE1Event" );
    	this.underexcLimIEEE1Id = event.getUnderexcLimIEEE1Id();
        this.kuc = event.getKuc();
        this.kuf = event.getKuf();
        this.kui = event.getKui();
        this.kul = event.getKul();
        this.kur = event.getKur();
        this.tu1 = event.getTu1();
        this.tu2 = event.getTu2();
        this.tu3 = event.getTu3();
        this.tu4 = event.getTu4();
        this.vucmax = event.getVucmax();
        this.vuimax = event.getVuimax();
        this.vuimin = event.getVuimin();
        this.vulmax = event.getVulmax();
        this.vulmin = event.getVulmin();
        this.vurmax = event.getVurmax();
    }
    
    @EventSourcingHandler
    void on(UpdateUnderexcLimIEEE1Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.kuc = event.getKuc();
        this.kuf = event.getKuf();
        this.kui = event.getKui();
        this.kul = event.getKul();
        this.kur = event.getKur();
        this.tu1 = event.getTu1();
        this.tu2 = event.getTu2();
        this.tu3 = event.getTu3();
        this.tu4 = event.getTu4();
        this.vucmax = event.getVucmax();
        this.vuimax = event.getVuimax();
        this.vuimin = event.getVuimin();
        this.vulmax = event.getVulmax();
        this.vulmin = event.getVulmin();
        this.vurmax = event.getVurmax();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID underexcLimIEEE1Id;
    
    private String kuc;
    private String kuf;
    private String kui;
    private String kul;
    private String kur;
    private String tu1;
    private String tu2;
    private String tu3;
    private String tu4;
    private String vucmax;
    private String vuimax;
    private String vuimin;
    private String vulmax;
    private String vulmin;
    private String vurmax;

    private static final Logger LOGGER 	= Logger.getLogger(UnderexcLimIEEE1Aggregate.class.getName());
}
