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
 * Aggregate handler for WindPlantFreqPcontrolIEC as outlined for the CQRS pattern, all write responsibilities 
 * related to WindPlantFreqPcontrolIEC are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class WindPlantFreqPcontrolIECAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public WindPlantFreqPcontrolIECAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public WindPlantFreqPcontrolIECAggregate(CreateWindPlantFreqPcontrolIECCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateWindPlantFreqPcontrolIECCommand" );
    	CreateWindPlantFreqPcontrolIECEvent event = new CreateWindPlantFreqPcontrolIECEvent(command.getWindPlantFreqPcontrolIECId(), command.getDprefmax(), command.getDprefmin(), command.getKiwpp(), command.getKpwpp(), command.getPrefmax(), command.getPrefmin(), command.getTpft(), command.getTpfv(), command.getTwpffilt(), command.getTwppfilt());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateWindPlantFreqPcontrolIECCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateWindPlantFreqPcontrolIECCommand" );
    	UpdateWindPlantFreqPcontrolIECEvent event = new UpdateWindPlantFreqPcontrolIECEvent(command.getWindPlantFreqPcontrolIECId(), command.getDprefmax(), command.getDprefmin(), command.getKiwpp(), command.getKpwpp(), command.getPrefmax(), command.getPrefmin(), command.getTpft(), command.getTpfv(), command.getTwpffilt(), command.getTwppfilt());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteWindPlantFreqPcontrolIECCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteWindPlantFreqPcontrolIECCommand" );
        apply(new DeleteWindPlantFreqPcontrolIECEvent(command.getWindPlantFreqPcontrolIECId()));
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
    void on(CreateWindPlantFreqPcontrolIECEvent event) {	
    	LOGGER.info( "Event sourcing CreateWindPlantFreqPcontrolIECEvent" );
    	this.windPlantFreqPcontrolIECId = event.getWindPlantFreqPcontrolIECId();
        this.dprefmax = event.getDprefmax();
        this.dprefmin = event.getDprefmin();
        this.kiwpp = event.getKiwpp();
        this.kpwpp = event.getKpwpp();
        this.prefmax = event.getPrefmax();
        this.prefmin = event.getPrefmin();
        this.tpft = event.getTpft();
        this.tpfv = event.getTpfv();
        this.twpffilt = event.getTwpffilt();
        this.twppfilt = event.getTwppfilt();
    }
    
    @EventSourcingHandler
    void on(UpdateWindPlantFreqPcontrolIECEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.dprefmax = event.getDprefmax();
        this.dprefmin = event.getDprefmin();
        this.kiwpp = event.getKiwpp();
        this.kpwpp = event.getKpwpp();
        this.prefmax = event.getPrefmax();
        this.prefmin = event.getPrefmin();
        this.tpft = event.getTpft();
        this.tpfv = event.getTpfv();
        this.twpffilt = event.getTwpffilt();
        this.twppfilt = event.getTwppfilt();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID windPlantFreqPcontrolIECId;
    
    private String dprefmax;
    private String dprefmin;
    private String kiwpp;
    private String kpwpp;
    private String prefmax;
    private String prefmin;
    private String tpft;
    private String tpfv;
    private String twpffilt;
    private String twppfilt;

    private static final Logger LOGGER 	= Logger.getLogger(WindPlantFreqPcontrolIECAggregate.class.getName());
}
