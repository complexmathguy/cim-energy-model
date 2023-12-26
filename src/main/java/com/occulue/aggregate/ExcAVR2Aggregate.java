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
 * Aggregate handler for ExcAVR2 as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcAVR2 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcAVR2Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcAVR2Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcAVR2Aggregate(CreateExcAVR2Command command) throws Exception {
    	LOGGER.info( "Handling command CreateExcAVR2Command" );
    	CreateExcAVR2Event event = new CreateExcAVR2Event(command.getExcAVR2Id(), command.getE1(), command.getE2(), command.getKa(), command.getKf(), command.getSe1(), command.getSe2(), command.getTa(), command.getTb(), command.getTe(), command.getTf1(), command.getTf2(), command.getVrmn(), command.getVrmx());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcAVR2Command command) throws Exception {
    	LOGGER.info( "handling command UpdateExcAVR2Command" );
    	UpdateExcAVR2Event event = new UpdateExcAVR2Event(command.getExcAVR2Id(), command.getE1(), command.getE2(), command.getKa(), command.getKf(), command.getSe1(), command.getSe2(), command.getTa(), command.getTb(), command.getTe(), command.getTf1(), command.getTf2(), command.getVrmn(), command.getVrmx());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcAVR2Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcAVR2Command" );
        apply(new DeleteExcAVR2Event(command.getExcAVR2Id()));
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
    void on(CreateExcAVR2Event event) {	
    	LOGGER.info( "Event sourcing CreateExcAVR2Event" );
    	this.excAVR2Id = event.getExcAVR2Id();
        this.e1 = event.getE1();
        this.e2 = event.getE2();
        this.ka = event.getKa();
        this.kf = event.getKf();
        this.se1 = event.getSe1();
        this.se2 = event.getSe2();
        this.ta = event.getTa();
        this.tb = event.getTb();
        this.te = event.getTe();
        this.tf1 = event.getTf1();
        this.tf2 = event.getTf2();
        this.vrmn = event.getVrmn();
        this.vrmx = event.getVrmx();
    }
    
    @EventSourcingHandler
    void on(UpdateExcAVR2Event event) {
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
        this.tf1 = event.getTf1();
        this.tf2 = event.getTf2();
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
    private UUID excAVR2Id;
    
    private String e1;
    private String e2;
    private String ka;
    private String kf;
    private String se1;
    private String se2;
    private String ta;
    private String tb;
    private String te;
    private String tf1;
    private String tf2;
    private String vrmn;
    private String vrmx;

    private static final Logger LOGGER 	= Logger.getLogger(ExcAVR2Aggregate.class.getName());
}
