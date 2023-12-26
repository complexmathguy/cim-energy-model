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
 * Aggregate handler for WindContQIEC as outlined for the CQRS pattern, all write responsibilities 
 * related to WindContQIEC are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class WindContQIECAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public WindContQIECAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public WindContQIECAggregate(CreateWindContQIECCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateWindContQIECCommand" );
    	CreateWindContQIECEvent event = new CreateWindContQIECEvent(command.getWindContQIECId(), command.getIqh1(), command.getIqmax(), command.getIqmin(), command.getIqpost(), command.getKiq(), command.getKiu(), command.getKpq(), command.getKpu(), command.getKqv(), command.getQmax(), command.getQmin(), command.getRdroop(), command.getTiq(), command.getTpfilt(), command.getTpost(), command.getTqord(), command.getTufilt(), command.getUdb1(), command.getUdb2(), command.getUmax(), command.getUmin(), command.getUqdip(), command.getUref0(), command.getWindLVRTQcontrolModesType(), command.getWindQcontrolModesType(), command.getXdroop());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateWindContQIECCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateWindContQIECCommand" );
    	UpdateWindContQIECEvent event = new UpdateWindContQIECEvent(command.getWindContQIECId(), command.getIqh1(), command.getIqmax(), command.getIqmin(), command.getIqpost(), command.getKiq(), command.getKiu(), command.getKpq(), command.getKpu(), command.getKqv(), command.getQmax(), command.getQmin(), command.getRdroop(), command.getTiq(), command.getTpfilt(), command.getTpost(), command.getTqord(), command.getTufilt(), command.getUdb1(), command.getUdb2(), command.getUmax(), command.getUmin(), command.getUqdip(), command.getUref0(), command.getWindLVRTQcontrolModesType(), command.getWindQcontrolModesType(), command.getXdroop());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteWindContQIECCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteWindContQIECCommand" );
        apply(new DeleteWindContQIECEvent(command.getWindContQIECId()));
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
    void on(CreateWindContQIECEvent event) {	
    	LOGGER.info( "Event sourcing CreateWindContQIECEvent" );
    	this.windContQIECId = event.getWindContQIECId();
        this.iqh1 = event.getIqh1();
        this.iqmax = event.getIqmax();
        this.iqmin = event.getIqmin();
        this.iqpost = event.getIqpost();
        this.kiq = event.getKiq();
        this.kiu = event.getKiu();
        this.kpq = event.getKpq();
        this.kpu = event.getKpu();
        this.kqv = event.getKqv();
        this.qmax = event.getQmax();
        this.qmin = event.getQmin();
        this.rdroop = event.getRdroop();
        this.tiq = event.getTiq();
        this.tpfilt = event.getTpfilt();
        this.tpost = event.getTpost();
        this.tqord = event.getTqord();
        this.tufilt = event.getTufilt();
        this.udb1 = event.getUdb1();
        this.udb2 = event.getUdb2();
        this.umax = event.getUmax();
        this.umin = event.getUmin();
        this.uqdip = event.getUqdip();
        this.uref0 = event.getUref0();
        this.windLVRTQcontrolModesType = event.getWindLVRTQcontrolModesType();
        this.windQcontrolModesType = event.getWindQcontrolModesType();
        this.xdroop = event.getXdroop();
    }
    
    @EventSourcingHandler
    void on(UpdateWindContQIECEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.iqh1 = event.getIqh1();
        this.iqmax = event.getIqmax();
        this.iqmin = event.getIqmin();
        this.iqpost = event.getIqpost();
        this.kiq = event.getKiq();
        this.kiu = event.getKiu();
        this.kpq = event.getKpq();
        this.kpu = event.getKpu();
        this.kqv = event.getKqv();
        this.qmax = event.getQmax();
        this.qmin = event.getQmin();
        this.rdroop = event.getRdroop();
        this.tiq = event.getTiq();
        this.tpfilt = event.getTpfilt();
        this.tpost = event.getTpost();
        this.tqord = event.getTqord();
        this.tufilt = event.getTufilt();
        this.udb1 = event.getUdb1();
        this.udb2 = event.getUdb2();
        this.umax = event.getUmax();
        this.umin = event.getUmin();
        this.uqdip = event.getUqdip();
        this.uref0 = event.getUref0();
        this.windLVRTQcontrolModesType = event.getWindLVRTQcontrolModesType();
        this.windQcontrolModesType = event.getWindQcontrolModesType();
        this.xdroop = event.getXdroop();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID windContQIECId;
    
    private String iqh1;
    private String iqmax;
    private String iqmin;
    private String iqpost;
    private String kiq;
    private String kiu;
    private String kpq;
    private String kpu;
    private String kqv;
    private String qmax;
    private String qmin;
    private String rdroop;
    private String tiq;
    private String tpfilt;
    private String tpost;
    private String tqord;
    private String tufilt;
    private String udb1;
    private String udb2;
    private String umax;
    private String umin;
    private String uqdip;
    private String uref0;
    private String windLVRTQcontrolModesType;
    private String windQcontrolModesType;
    private String xdroop;

    private static final Logger LOGGER 	= Logger.getLogger(WindContQIECAggregate.class.getName());
}
