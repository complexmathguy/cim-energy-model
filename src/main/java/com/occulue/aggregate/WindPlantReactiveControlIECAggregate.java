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
 * Aggregate handler for WindPlantReactiveControlIEC as outlined for the CQRS pattern, all write responsibilities 
 * related to WindPlantReactiveControlIEC are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class WindPlantReactiveControlIECAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public WindPlantReactiveControlIECAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public WindPlantReactiveControlIECAggregate(CreateWindPlantReactiveControlIECCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateWindPlantReactiveControlIECCommand" );
    	CreateWindPlantReactiveControlIECEvent event = new CreateWindPlantReactiveControlIECEvent(command.getWindPlantReactiveControlIECId(), command.getKiwpx(), command.getKpwpx(), command.getKwpqu(), command.getMwppf(), command.getMwpu(), command.getTwppfilt(), command.getTwpqfilt(), command.getTwpufilt(), command.getTxft(), command.getTxfv(), command.getUwpqdip(), command.getXrefmax(), command.getXrefmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateWindPlantReactiveControlIECCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateWindPlantReactiveControlIECCommand" );
    	UpdateWindPlantReactiveControlIECEvent event = new UpdateWindPlantReactiveControlIECEvent(command.getWindPlantReactiveControlIECId(), command.getKiwpx(), command.getKpwpx(), command.getKwpqu(), command.getMwppf(), command.getMwpu(), command.getTwppfilt(), command.getTwpqfilt(), command.getTwpufilt(), command.getTxft(), command.getTxfv(), command.getUwpqdip(), command.getXrefmax(), command.getXrefmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteWindPlantReactiveControlIECCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteWindPlantReactiveControlIECCommand" );
        apply(new DeleteWindPlantReactiveControlIECEvent(command.getWindPlantReactiveControlIECId()));
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
    void on(CreateWindPlantReactiveControlIECEvent event) {	
    	LOGGER.info( "Event sourcing CreateWindPlantReactiveControlIECEvent" );
    	this.windPlantReactiveControlIECId = event.getWindPlantReactiveControlIECId();
        this.kiwpx = event.getKiwpx();
        this.kpwpx = event.getKpwpx();
        this.kwpqu = event.getKwpqu();
        this.mwppf = event.getMwppf();
        this.mwpu = event.getMwpu();
        this.twppfilt = event.getTwppfilt();
        this.twpqfilt = event.getTwpqfilt();
        this.twpufilt = event.getTwpufilt();
        this.txft = event.getTxft();
        this.txfv = event.getTxfv();
        this.uwpqdip = event.getUwpqdip();
        this.xrefmax = event.getXrefmax();
        this.xrefmin = event.getXrefmin();
    }
    
    @EventSourcingHandler
    void on(UpdateWindPlantReactiveControlIECEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.kiwpx = event.getKiwpx();
        this.kpwpx = event.getKpwpx();
        this.kwpqu = event.getKwpqu();
        this.mwppf = event.getMwppf();
        this.mwpu = event.getMwpu();
        this.twppfilt = event.getTwppfilt();
        this.twpqfilt = event.getTwpqfilt();
        this.twpufilt = event.getTwpufilt();
        this.txft = event.getTxft();
        this.txfv = event.getTxfv();
        this.uwpqdip = event.getUwpqdip();
        this.xrefmax = event.getXrefmax();
        this.xrefmin = event.getXrefmin();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID windPlantReactiveControlIECId;
    
    private String kiwpx;
    private String kpwpx;
    private String kwpqu;
    private String mwppf;
    private String mwpu;
    private String twppfilt;
    private String twpqfilt;
    private String twpufilt;
    private String txft;
    private String txfv;
    private String uwpqdip;
    private String xrefmax;
    private String xrefmin;

    private static final Logger LOGGER 	= Logger.getLogger(WindPlantReactiveControlIECAggregate.class.getName());
}
