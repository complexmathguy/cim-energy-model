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
 * Aggregate handler for ExcANS as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcANS are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcANSAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcANSAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcANSAggregate(CreateExcANSCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcANSCommand" );
    	CreateExcANSEvent event = new CreateExcANSEvent(command.getExcANSId(), command.getBlint(), command.getIfmn(), command.getIfmx(), command.getK2(), command.getK3(), command.getKce(), command.getKrvecc(), command.getKvfif(), command.getT1(), command.getT2(), command.getT3(), command.getTb(), command.getVrmn(), command.getVrmx());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcANSCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcANSCommand" );
    	UpdateExcANSEvent event = new UpdateExcANSEvent(command.getExcANSId(), command.getBlint(), command.getIfmn(), command.getIfmx(), command.getK2(), command.getK3(), command.getKce(), command.getKrvecc(), command.getKvfif(), command.getT1(), command.getT2(), command.getT3(), command.getTb(), command.getVrmn(), command.getVrmx());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcANSCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcANSCommand" );
        apply(new DeleteExcANSEvent(command.getExcANSId()));
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
    void on(CreateExcANSEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcANSEvent" );
    	this.excANSId = event.getExcANSId();
        this.blint = event.getBlint();
        this.ifmn = event.getIfmn();
        this.ifmx = event.getIfmx();
        this.k2 = event.getK2();
        this.k3 = event.getK3();
        this.kce = event.getKce();
        this.krvecc = event.getKrvecc();
        this.kvfif = event.getKvfif();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.tb = event.getTb();
        this.vrmn = event.getVrmn();
        this.vrmx = event.getVrmx();
    }
    
    @EventSourcingHandler
    void on(UpdateExcANSEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.blint = event.getBlint();
        this.ifmn = event.getIfmn();
        this.ifmx = event.getIfmx();
        this.k2 = event.getK2();
        this.k3 = event.getK3();
        this.kce = event.getKce();
        this.krvecc = event.getKrvecc();
        this.kvfif = event.getKvfif();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.tb = event.getTb();
        this.vrmn = event.getVrmn();
        this.vrmx = event.getVrmx();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID excANSId;
    
    private String blint;
    private String ifmn;
    private String ifmx;
    private String k2;
    private String k3;
    private String kce;
    private String krvecc;
    private String kvfif;
    private String t1;
    private String t2;
    private String t3;
    private String tb;
    private String vrmn;
    private String vrmx;

    private static final Logger LOGGER 	= Logger.getLogger(ExcANSAggregate.class.getName());
}
