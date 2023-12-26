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
 * Aggregate handler for ExcAVR3 as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcAVR3 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcAVR3Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcAVR3Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcAVR3Aggregate(CreateExcAVR3Command command) throws Exception {
    	LOGGER.info( "Handling command CreateExcAVR3Command" );
    	CreateExcAVR3Event event = new CreateExcAVR3Event(command.getExcAVR3Id(), command.getE1(), command.getE2(), command.getKa(), command.getSe1(), command.getSe2(), command.getT1(), command.getT2(), command.getT3(), command.getT4(), command.getTe(), command.getVrmn(), command.getVrmx());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcAVR3Command command) throws Exception {
    	LOGGER.info( "handling command UpdateExcAVR3Command" );
    	UpdateExcAVR3Event event = new UpdateExcAVR3Event(command.getExcAVR3Id(), command.getE1(), command.getE2(), command.getKa(), command.getSe1(), command.getSe2(), command.getT1(), command.getT2(), command.getT3(), command.getT4(), command.getTe(), command.getVrmn(), command.getVrmx());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcAVR3Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcAVR3Command" );
        apply(new DeleteExcAVR3Event(command.getExcAVR3Id()));
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
    void on(CreateExcAVR3Event event) {	
    	LOGGER.info( "Event sourcing CreateExcAVR3Event" );
    	this.excAVR3Id = event.getExcAVR3Id();
        this.e1 = event.getE1();
        this.e2 = event.getE2();
        this.ka = event.getKa();
        this.se1 = event.getSe1();
        this.se2 = event.getSe2();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.te = event.getTe();
        this.vrmn = event.getVrmn();
        this.vrmx = event.getVrmx();
    }
    
    @EventSourcingHandler
    void on(UpdateExcAVR3Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.e1 = event.getE1();
        this.e2 = event.getE2();
        this.ka = event.getKa();
        this.se1 = event.getSe1();
        this.se2 = event.getSe2();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.te = event.getTe();
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
    private UUID excAVR3Id;
    
    private String e1;
    private String e2;
    private String ka;
    private String se1;
    private String se2;
    private String t1;
    private String t2;
    private String t3;
    private String t4;
    private String te;
    private String vrmn;
    private String vrmx;

    private static final Logger LOGGER 	= Logger.getLogger(ExcAVR3Aggregate.class.getName());
}
