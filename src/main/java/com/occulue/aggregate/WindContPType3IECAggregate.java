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
 * Aggregate handler for WindContPType3IEC as outlined for the CQRS pattern, all write responsibilities 
 * related to WindContPType3IEC are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class WindContPType3IECAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public WindContPType3IECAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public WindContPType3IECAggregate(CreateWindContPType3IECCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateWindContPType3IECCommand" );
    	CreateWindContPType3IECEvent event = new CreateWindContPType3IECEvent(command.getWindContPType3IECId(), command.getDpmax(), command.getDtrisemaxlvrt(), command.getKdtd(), command.getKip(), command.getKpp(), command.getMplvrt(), command.getOmegaoffset(), command.getPdtdmax(), command.getRramp(), command.getTdvs(), command.getTemin(), command.getTomegafilt(), command.getTpfilt(), command.getTpord(), command.getTufilt(), command.getTuscale(), command.getTwref(), command.getUdvs(), command.getUpdip(), command.getWdtd(), command.getZeta());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateWindContPType3IECCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateWindContPType3IECCommand" );
    	UpdateWindContPType3IECEvent event = new UpdateWindContPType3IECEvent(command.getWindContPType3IECId(), command.getDpmax(), command.getDtrisemaxlvrt(), command.getKdtd(), command.getKip(), command.getKpp(), command.getMplvrt(), command.getOmegaoffset(), command.getPdtdmax(), command.getRramp(), command.getTdvs(), command.getTemin(), command.getTomegafilt(), command.getTpfilt(), command.getTpord(), command.getTufilt(), command.getTuscale(), command.getTwref(), command.getUdvs(), command.getUpdip(), command.getWdtd(), command.getZeta());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteWindContPType3IECCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteWindContPType3IECCommand" );
        apply(new DeleteWindContPType3IECEvent(command.getWindContPType3IECId()));
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
    void on(CreateWindContPType3IECEvent event) {	
    	LOGGER.info( "Event sourcing CreateWindContPType3IECEvent" );
    	this.windContPType3IECId = event.getWindContPType3IECId();
        this.dpmax = event.getDpmax();
        this.dtrisemaxlvrt = event.getDtrisemaxlvrt();
        this.kdtd = event.getKdtd();
        this.kip = event.getKip();
        this.kpp = event.getKpp();
        this.mplvrt = event.getMplvrt();
        this.omegaoffset = event.getOmegaoffset();
        this.pdtdmax = event.getPdtdmax();
        this.rramp = event.getRramp();
        this.tdvs = event.getTdvs();
        this.temin = event.getTemin();
        this.tomegafilt = event.getTomegafilt();
        this.tpfilt = event.getTpfilt();
        this.tpord = event.getTpord();
        this.tufilt = event.getTufilt();
        this.tuscale = event.getTuscale();
        this.twref = event.getTwref();
        this.udvs = event.getUdvs();
        this.updip = event.getUpdip();
        this.wdtd = event.getWdtd();
        this.zeta = event.getZeta();
    }
    
    @EventSourcingHandler
    void on(UpdateWindContPType3IECEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.dpmax = event.getDpmax();
        this.dtrisemaxlvrt = event.getDtrisemaxlvrt();
        this.kdtd = event.getKdtd();
        this.kip = event.getKip();
        this.kpp = event.getKpp();
        this.mplvrt = event.getMplvrt();
        this.omegaoffset = event.getOmegaoffset();
        this.pdtdmax = event.getPdtdmax();
        this.rramp = event.getRramp();
        this.tdvs = event.getTdvs();
        this.temin = event.getTemin();
        this.tomegafilt = event.getTomegafilt();
        this.tpfilt = event.getTpfilt();
        this.tpord = event.getTpord();
        this.tufilt = event.getTufilt();
        this.tuscale = event.getTuscale();
        this.twref = event.getTwref();
        this.udvs = event.getUdvs();
        this.updip = event.getUpdip();
        this.wdtd = event.getWdtd();
        this.zeta = event.getZeta();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID windContPType3IECId;
    
    private String dpmax;
    private String dtrisemaxlvrt;
    private String kdtd;
    private String kip;
    private String kpp;
    private String mplvrt;
    private String omegaoffset;
    private String pdtdmax;
    private String rramp;
    private String tdvs;
    private String temin;
    private String tomegafilt;
    private String tpfilt;
    private String tpord;
    private String tufilt;
    private String tuscale;
    private String twref;
    private String udvs;
    private String updip;
    private String wdtd;
    private String zeta;

    private static final Logger LOGGER 	= Logger.getLogger(WindContPType3IECAggregate.class.getName());
}
