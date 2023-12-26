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
 * Aggregate handler for WindContCurrLimIEC as outlined for the CQRS pattern, all write responsibilities 
 * related to WindContCurrLimIEC are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class WindContCurrLimIECAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public WindContCurrLimIECAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public WindContCurrLimIECAggregate(CreateWindContCurrLimIECCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateWindContCurrLimIECCommand" );
    	CreateWindContCurrLimIECEvent event = new CreateWindContCurrLimIECEvent(command.getWindContCurrLimIECId(), command.getImax(), command.getImaxdip(), command.getMdfslim(), command.getMqpri(), command.getTufilt());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateWindContCurrLimIECCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateWindContCurrLimIECCommand" );
    	UpdateWindContCurrLimIECEvent event = new UpdateWindContCurrLimIECEvent(command.getWindContCurrLimIECId(), command.getImax(), command.getImaxdip(), command.getMdfslim(), command.getMqpri(), command.getTufilt());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteWindContCurrLimIECCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteWindContCurrLimIECCommand" );
        apply(new DeleteWindContCurrLimIECEvent(command.getWindContCurrLimIECId()));
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
    void on(CreateWindContCurrLimIECEvent event) {	
    	LOGGER.info( "Event sourcing CreateWindContCurrLimIECEvent" );
    	this.windContCurrLimIECId = event.getWindContCurrLimIECId();
        this.imax = event.getImax();
        this.imaxdip = event.getImaxdip();
        this.mdfslim = event.getMdfslim();
        this.mqpri = event.getMqpri();
        this.tufilt = event.getTufilt();
    }
    
    @EventSourcingHandler
    void on(UpdateWindContCurrLimIECEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.imax = event.getImax();
        this.imaxdip = event.getImaxdip();
        this.mdfslim = event.getMdfslim();
        this.mqpri = event.getMqpri();
        this.tufilt = event.getTufilt();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID windContCurrLimIECId;
    
    private String imax;
    private String imaxdip;
    private String mdfslim;
    private String mqpri;
    private String tufilt;

    private static final Logger LOGGER 	= Logger.getLogger(WindContCurrLimIECAggregate.class.getName());
}
