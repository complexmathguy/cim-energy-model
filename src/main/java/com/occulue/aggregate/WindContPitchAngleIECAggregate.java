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
 * Aggregate handler for WindContPitchAngleIEC as outlined for the CQRS pattern, all write responsibilities 
 * related to WindContPitchAngleIEC are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class WindContPitchAngleIECAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public WindContPitchAngleIECAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public WindContPitchAngleIECAggregate(CreateWindContPitchAngleIECCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateWindContPitchAngleIECCommand" );
    	CreateWindContPitchAngleIECEvent event = new CreateWindContPitchAngleIECEvent(command.getWindContPitchAngleIECId(), command.getDthetamax(), command.getDthetamin(), command.getKic(), command.getKiomega(), command.getKpc(), command.getKpomega(), command.getKpx(), command.getThetamax(), command.getThetamin(), command.getTtheta());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateWindContPitchAngleIECCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateWindContPitchAngleIECCommand" );
    	UpdateWindContPitchAngleIECEvent event = new UpdateWindContPitchAngleIECEvent(command.getWindContPitchAngleIECId(), command.getDthetamax(), command.getDthetamin(), command.getKic(), command.getKiomega(), command.getKpc(), command.getKpomega(), command.getKpx(), command.getThetamax(), command.getThetamin(), command.getTtheta());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteWindContPitchAngleIECCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteWindContPitchAngleIECCommand" );
        apply(new DeleteWindContPitchAngleIECEvent(command.getWindContPitchAngleIECId()));
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
    void on(CreateWindContPitchAngleIECEvent event) {	
    	LOGGER.info( "Event sourcing CreateWindContPitchAngleIECEvent" );
    	this.windContPitchAngleIECId = event.getWindContPitchAngleIECId();
        this.dthetamax = event.getDthetamax();
        this.dthetamin = event.getDthetamin();
        this.kic = event.getKic();
        this.kiomega = event.getKiomega();
        this.kpc = event.getKpc();
        this.kpomega = event.getKpomega();
        this.kpx = event.getKpx();
        this.thetamax = event.getThetamax();
        this.thetamin = event.getThetamin();
        this.ttheta = event.getTtheta();
    }
    
    @EventSourcingHandler
    void on(UpdateWindContPitchAngleIECEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.dthetamax = event.getDthetamax();
        this.dthetamin = event.getDthetamin();
        this.kic = event.getKic();
        this.kiomega = event.getKiomega();
        this.kpc = event.getKpc();
        this.kpomega = event.getKpomega();
        this.kpx = event.getKpx();
        this.thetamax = event.getThetamax();
        this.thetamin = event.getThetamin();
        this.ttheta = event.getTtheta();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID windContPitchAngleIECId;
    
    private String dthetamax;
    private String dthetamin;
    private String kic;
    private String kiomega;
    private String kpc;
    private String kpomega;
    private String kpx;
    private String thetamax;
    private String thetamin;
    private String ttheta;

    private static final Logger LOGGER 	= Logger.getLogger(WindContPitchAngleIECAggregate.class.getName());
}
