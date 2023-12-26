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
 * Aggregate handler for ExcELIN1 as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcELIN1 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcELIN1Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcELIN1Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcELIN1Aggregate(CreateExcELIN1Command command) throws Exception {
    	LOGGER.info( "Handling command CreateExcELIN1Command" );
    	CreateExcELIN1Event event = new CreateExcELIN1Event(command.getExcELIN1Id(), command.getDpnf(), command.getEfmax(), command.getEfmin(), command.getKs1(), command.getKs2(), command.getSmax(), command.getTfi(), command.getTnu(), command.getTs1(), command.getTs2(), command.getTsw(), command.getVpi(), command.getVpnf(), command.getVpu(), command.getXe());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcELIN1Command command) throws Exception {
    	LOGGER.info( "handling command UpdateExcELIN1Command" );
    	UpdateExcELIN1Event event = new UpdateExcELIN1Event(command.getExcELIN1Id(), command.getDpnf(), command.getEfmax(), command.getEfmin(), command.getKs1(), command.getKs2(), command.getSmax(), command.getTfi(), command.getTnu(), command.getTs1(), command.getTs2(), command.getTsw(), command.getVpi(), command.getVpnf(), command.getVpu(), command.getXe());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcELIN1Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcELIN1Command" );
        apply(new DeleteExcELIN1Event(command.getExcELIN1Id()));
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
    void on(CreateExcELIN1Event event) {	
    	LOGGER.info( "Event sourcing CreateExcELIN1Event" );
    	this.excELIN1Id = event.getExcELIN1Id();
        this.dpnf = event.getDpnf();
        this.efmax = event.getEfmax();
        this.efmin = event.getEfmin();
        this.ks1 = event.getKs1();
        this.ks2 = event.getKs2();
        this.smax = event.getSmax();
        this.tfi = event.getTfi();
        this.tnu = event.getTnu();
        this.ts1 = event.getTs1();
        this.ts2 = event.getTs2();
        this.tsw = event.getTsw();
        this.vpi = event.getVpi();
        this.vpnf = event.getVpnf();
        this.vpu = event.getVpu();
        this.xe = event.getXe();
    }
    
    @EventSourcingHandler
    void on(UpdateExcELIN1Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.dpnf = event.getDpnf();
        this.efmax = event.getEfmax();
        this.efmin = event.getEfmin();
        this.ks1 = event.getKs1();
        this.ks2 = event.getKs2();
        this.smax = event.getSmax();
        this.tfi = event.getTfi();
        this.tnu = event.getTnu();
        this.ts1 = event.getTs1();
        this.ts2 = event.getTs2();
        this.tsw = event.getTsw();
        this.vpi = event.getVpi();
        this.vpnf = event.getVpnf();
        this.vpu = event.getVpu();
        this.xe = event.getXe();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID excELIN1Id;
    
    private String dpnf;
    private String efmax;
    private String efmin;
    private String ks1;
    private String ks2;
    private String smax;
    private String tfi;
    private String tnu;
    private String ts1;
    private String ts2;
    private String tsw;
    private String vpi;
    private String vpnf;
    private String vpu;
    private String xe;

    private static final Logger LOGGER 	= Logger.getLogger(ExcELIN1Aggregate.class.getName());
}
