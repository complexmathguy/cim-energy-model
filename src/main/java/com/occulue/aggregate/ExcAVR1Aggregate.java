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
 * Aggregate handler for ExcAVR1 as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcAVR1 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcAVR1Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcAVR1Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcAVR1Aggregate(CreateExcAVR1Command command) throws Exception {
    	LOGGER.info( "Handling command CreateExcAVR1Command" );
    	CreateExcAVR1Event event = new CreateExcAVR1Event(command.getExcAVR1Id(), command.getE1(), command.getE2(), command.getKa(), command.getKf(), command.getSe1(), command.getSe2(), command.getTa(), command.getTb(), command.getTe(), command.getTf(), command.getVrmn(), command.getVrmx());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcAVR1Command command) throws Exception {
    	LOGGER.info( "handling command UpdateExcAVR1Command" );
    	UpdateExcAVR1Event event = new UpdateExcAVR1Event(command.getExcAVR1Id(), command.getE1(), command.getE2(), command.getKa(), command.getKf(), command.getSe1(), command.getSe2(), command.getTa(), command.getTb(), command.getTe(), command.getTf(), command.getVrmn(), command.getVrmx());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcAVR1Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcAVR1Command" );
        apply(new DeleteExcAVR1Event(command.getExcAVR1Id()));
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
    void on(CreateExcAVR1Event event) {	
    	LOGGER.info( "Event sourcing CreateExcAVR1Event" );
    	this.excAVR1Id = event.getExcAVR1Id();
        this.e1 = event.getE1();
        this.e2 = event.getE2();
        this.ka = event.getKa();
        this.kf = event.getKf();
        this.se1 = event.getSe1();
        this.se2 = event.getSe2();
        this.ta = event.getTa();
        this.tb = event.getTb();
        this.te = event.getTe();
        this.tf = event.getTf();
        this.vrmn = event.getVrmn();
        this.vrmx = event.getVrmx();
    }
    
    @EventSourcingHandler
    void on(UpdateExcAVR1Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.e1 = event.getE1();
        this.e2 = event.getE2();
        this.ka = event.getKa();
        this.kf = event.getKf();
        this.se1 = event.getSe1();
        this.se2 = event.getSe2();
        this.ta = event.getTa();
        this.tb = event.getTb();
        this.te = event.getTe();
        this.tf = event.getTf();
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
    private UUID excAVR1Id;
    
    private String e1;
    private String e2;
    private String ka;
    private String kf;
    private String se1;
    private String se2;
    private String ta;
    private String tb;
    private String te;
    private String tf;
    private String vrmn;
    private String vrmx;

    private static final Logger LOGGER 	= Logger.getLogger(ExcAVR1Aggregate.class.getName());
}
