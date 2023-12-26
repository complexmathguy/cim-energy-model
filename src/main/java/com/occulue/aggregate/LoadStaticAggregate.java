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
 * Aggregate handler for LoadStatic as outlined for the CQRS pattern, all write responsibilities 
 * related to LoadStatic are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class LoadStaticAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public LoadStaticAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public LoadStaticAggregate(CreateLoadStaticCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateLoadStaticCommand" );
    	CreateLoadStaticEvent event = new CreateLoadStaticEvent(command.getLoadStaticId(), command.getEp1(), command.getEp2(), command.getEp3(), command.getEq1(), command.getEq2(), command.getEq3(), command.getKp1(), command.getKp2(), command.getKp3(), command.getKp4(), command.getKpf(), command.getKq1(), command.getKq2(), command.getKq3(), command.getKq4(), command.getKqf(), command.getStaticLoadModelType());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateLoadStaticCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateLoadStaticCommand" );
    	UpdateLoadStaticEvent event = new UpdateLoadStaticEvent(command.getLoadStaticId(), command.getEp1(), command.getEp2(), command.getEp3(), command.getEq1(), command.getEq2(), command.getEq3(), command.getKp1(), command.getKp2(), command.getKp3(), command.getKp4(), command.getKpf(), command.getKq1(), command.getKq2(), command.getKq3(), command.getKq4(), command.getKqf(), command.getStaticLoadModelType());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteLoadStaticCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteLoadStaticCommand" );
        apply(new DeleteLoadStaticEvent(command.getLoadStaticId()));
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
    void on(CreateLoadStaticEvent event) {	
    	LOGGER.info( "Event sourcing CreateLoadStaticEvent" );
    	this.loadStaticId = event.getLoadStaticId();
        this.ep1 = event.getEp1();
        this.ep2 = event.getEp2();
        this.ep3 = event.getEp3();
        this.eq1 = event.getEq1();
        this.eq2 = event.getEq2();
        this.eq3 = event.getEq3();
        this.kp1 = event.getKp1();
        this.kp2 = event.getKp2();
        this.kp3 = event.getKp3();
        this.kp4 = event.getKp4();
        this.kpf = event.getKpf();
        this.kq1 = event.getKq1();
        this.kq2 = event.getKq2();
        this.kq3 = event.getKq3();
        this.kq4 = event.getKq4();
        this.kqf = event.getKqf();
        this.staticLoadModelType = event.getStaticLoadModelType();
    }
    
    @EventSourcingHandler
    void on(UpdateLoadStaticEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.ep1 = event.getEp1();
        this.ep2 = event.getEp2();
        this.ep3 = event.getEp3();
        this.eq1 = event.getEq1();
        this.eq2 = event.getEq2();
        this.eq3 = event.getEq3();
        this.kp1 = event.getKp1();
        this.kp2 = event.getKp2();
        this.kp3 = event.getKp3();
        this.kp4 = event.getKp4();
        this.kpf = event.getKpf();
        this.kq1 = event.getKq1();
        this.kq2 = event.getKq2();
        this.kq3 = event.getKq3();
        this.kq4 = event.getKq4();
        this.kqf = event.getKqf();
        this.staticLoadModelType = event.getStaticLoadModelType();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID loadStaticId;
    
    private String ep1;
    private String ep2;
    private String ep3;
    private String eq1;
    private String eq2;
    private String eq3;
    private String kp1;
    private String kp2;
    private String kp3;
    private String kp4;
    private String kpf;
    private String kq1;
    private String kq2;
    private String kq3;
    private String kq4;
    private String kqf;
    private String staticLoadModelType;

    private static final Logger LOGGER 	= Logger.getLogger(LoadStaticAggregate.class.getName());
}
