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
 * Aggregate handler for UnderexcLimIEEE2 as outlined for the CQRS pattern, all write responsibilities 
 * related to UnderexcLimIEEE2 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class UnderexcLimIEEE2Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public UnderexcLimIEEE2Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public UnderexcLimIEEE2Aggregate(CreateUnderexcLimIEEE2Command command) throws Exception {
    	LOGGER.info( "Handling command CreateUnderexcLimIEEE2Command" );
    	CreateUnderexcLimIEEE2Event event = new CreateUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id(), command.getK1(), command.getK2(), command.getKfb(), command.getKuf(), command.getKui(), command.getKul(), command.getP0(), command.getP1(), command.getP10(), command.getP2(), command.getP3(), command.getP4(), command.getP5(), command.getP6(), command.getP7(), command.getP8(), command.getP9(), command.getQ0(), command.getQ1(), command.getQ10(), command.getQ2(), command.getQ3(), command.getQ4(), command.getQ5(), command.getQ6(), command.getQ7(), command.getQ8(), command.getQ9(), command.getTu1(), command.getTu2(), command.getTu3(), command.getTu4(), command.getTul(), command.getTup(), command.getTuq(), command.getTuv(), command.getVuimax(), command.getVuimin(), command.getVulmax(), command.getVulmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateUnderexcLimIEEE2Command command) throws Exception {
    	LOGGER.info( "handling command UpdateUnderexcLimIEEE2Command" );
    	UpdateUnderexcLimIEEE2Event event = new UpdateUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id(), command.getK1(), command.getK2(), command.getKfb(), command.getKuf(), command.getKui(), command.getKul(), command.getP0(), command.getP1(), command.getP10(), command.getP2(), command.getP3(), command.getP4(), command.getP5(), command.getP6(), command.getP7(), command.getP8(), command.getP9(), command.getQ0(), command.getQ1(), command.getQ10(), command.getQ2(), command.getQ3(), command.getQ4(), command.getQ5(), command.getQ6(), command.getQ7(), command.getQ8(), command.getQ9(), command.getTu1(), command.getTu2(), command.getTu3(), command.getTu4(), command.getTul(), command.getTup(), command.getTuq(), command.getTuv(), command.getVuimax(), command.getVuimin(), command.getVulmax(), command.getVulmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteUnderexcLimIEEE2Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteUnderexcLimIEEE2Command" );
        apply(new DeleteUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
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
    void on(CreateUnderexcLimIEEE2Event event) {	
    	LOGGER.info( "Event sourcing CreateUnderexcLimIEEE2Event" );
    	this.underexcLimIEEE2Id = event.getUnderexcLimIEEE2Id();
        this.k1 = event.getK1();
        this.k2 = event.getK2();
        this.kfb = event.getKfb();
        this.kuf = event.getKuf();
        this.kui = event.getKui();
        this.kul = event.getKul();
        this.p0 = event.getP0();
        this.p1 = event.getP1();
        this.p10 = event.getP10();
        this.p2 = event.getP2();
        this.p3 = event.getP3();
        this.p4 = event.getP4();
        this.p5 = event.getP5();
        this.p6 = event.getP6();
        this.p7 = event.getP7();
        this.p8 = event.getP8();
        this.p9 = event.getP9();
        this.q0 = event.getQ0();
        this.q1 = event.getQ1();
        this.q10 = event.getQ10();
        this.q2 = event.getQ2();
        this.q3 = event.getQ3();
        this.q4 = event.getQ4();
        this.q5 = event.getQ5();
        this.q6 = event.getQ6();
        this.q7 = event.getQ7();
        this.q8 = event.getQ8();
        this.q9 = event.getQ9();
        this.tu1 = event.getTu1();
        this.tu2 = event.getTu2();
        this.tu3 = event.getTu3();
        this.tu4 = event.getTu4();
        this.tul = event.getTul();
        this.tup = event.getTup();
        this.tuq = event.getTuq();
        this.tuv = event.getTuv();
        this.vuimax = event.getVuimax();
        this.vuimin = event.getVuimin();
        this.vulmax = event.getVulmax();
        this.vulmin = event.getVulmin();
    }
    
    @EventSourcingHandler
    void on(UpdateUnderexcLimIEEE2Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.k1 = event.getK1();
        this.k2 = event.getK2();
        this.kfb = event.getKfb();
        this.kuf = event.getKuf();
        this.kui = event.getKui();
        this.kul = event.getKul();
        this.p0 = event.getP0();
        this.p1 = event.getP1();
        this.p10 = event.getP10();
        this.p2 = event.getP2();
        this.p3 = event.getP3();
        this.p4 = event.getP4();
        this.p5 = event.getP5();
        this.p6 = event.getP6();
        this.p7 = event.getP7();
        this.p8 = event.getP8();
        this.p9 = event.getP9();
        this.q0 = event.getQ0();
        this.q1 = event.getQ1();
        this.q10 = event.getQ10();
        this.q2 = event.getQ2();
        this.q3 = event.getQ3();
        this.q4 = event.getQ4();
        this.q5 = event.getQ5();
        this.q6 = event.getQ6();
        this.q7 = event.getQ7();
        this.q8 = event.getQ8();
        this.q9 = event.getQ9();
        this.tu1 = event.getTu1();
        this.tu2 = event.getTu2();
        this.tu3 = event.getTu3();
        this.tu4 = event.getTu4();
        this.tul = event.getTul();
        this.tup = event.getTup();
        this.tuq = event.getTuq();
        this.tuv = event.getTuv();
        this.vuimax = event.getVuimax();
        this.vuimin = event.getVuimin();
        this.vulmax = event.getVulmax();
        this.vulmin = event.getVulmin();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID underexcLimIEEE2Id;
    
    private String k1;
    private String k2;
    private String kfb;
    private String kuf;
    private String kui;
    private String kul;
    private String p0;
    private String p1;
    private String p10;
    private String p2;
    private String p3;
    private String p4;
    private String p5;
    private String p6;
    private String p7;
    private String p8;
    private String p9;
    private String q0;
    private String q1;
    private String q10;
    private String q2;
    private String q3;
    private String q4;
    private String q5;
    private String q6;
    private String q7;
    private String q8;
    private String q9;
    private String tu1;
    private String tu2;
    private String tu3;
    private String tu4;
    private String tul;
    private String tup;
    private String tuq;
    private String tuv;
    private String vuimax;
    private String vuimin;
    private String vulmax;
    private String vulmin;

    private static final Logger LOGGER 	= Logger.getLogger(UnderexcLimIEEE2Aggregate.class.getName());
}
