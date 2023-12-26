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
 * Aggregate handler for ExcPIC as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcPIC are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcPICAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcPICAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcPICAggregate(CreateExcPICCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcPICCommand" );
    	CreateExcPICEvent event = new CreateExcPICEvent(command.getExcPICId(), command.getE1(), command.getE2(), command.getEfdmax(), command.getEfdmin(), command.getKa(), command.getKc(), command.getKe(), command.getKf(), command.getKi(), command.getKp(), command.getSe1(), command.getSe2(), command.getTa1(), command.getTa2(), command.getTa3(), command.getTa4(), command.getTe(), command.getTf1(), command.getTf2(), command.getVr1(), command.getVr2(), command.getVrmax(), command.getVrmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcPICCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcPICCommand" );
    	UpdateExcPICEvent event = new UpdateExcPICEvent(command.getExcPICId(), command.getE1(), command.getE2(), command.getEfdmax(), command.getEfdmin(), command.getKa(), command.getKc(), command.getKe(), command.getKf(), command.getKi(), command.getKp(), command.getSe1(), command.getSe2(), command.getTa1(), command.getTa2(), command.getTa3(), command.getTa4(), command.getTe(), command.getTf1(), command.getTf2(), command.getVr1(), command.getVr2(), command.getVrmax(), command.getVrmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcPICCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcPICCommand" );
        apply(new DeleteExcPICEvent(command.getExcPICId()));
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
    void on(CreateExcPICEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcPICEvent" );
    	this.excPICId = event.getExcPICId();
        this.e1 = event.getE1();
        this.e2 = event.getE2();
        this.efdmax = event.getEfdmax();
        this.efdmin = event.getEfdmin();
        this.ka = event.getKa();
        this.kc = event.getKc();
        this.ke = event.getKe();
        this.kf = event.getKf();
        this.ki = event.getKi();
        this.kp = event.getKp();
        this.se1 = event.getSe1();
        this.se2 = event.getSe2();
        this.ta1 = event.getTa1();
        this.ta2 = event.getTa2();
        this.ta3 = event.getTa3();
        this.ta4 = event.getTa4();
        this.te = event.getTe();
        this.tf1 = event.getTf1();
        this.tf2 = event.getTf2();
        this.vr1 = event.getVr1();
        this.vr2 = event.getVr2();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
    }
    
    @EventSourcingHandler
    void on(UpdateExcPICEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.e1 = event.getE1();
        this.e2 = event.getE2();
        this.efdmax = event.getEfdmax();
        this.efdmin = event.getEfdmin();
        this.ka = event.getKa();
        this.kc = event.getKc();
        this.ke = event.getKe();
        this.kf = event.getKf();
        this.ki = event.getKi();
        this.kp = event.getKp();
        this.se1 = event.getSe1();
        this.se2 = event.getSe2();
        this.ta1 = event.getTa1();
        this.ta2 = event.getTa2();
        this.ta3 = event.getTa3();
        this.ta4 = event.getTa4();
        this.te = event.getTe();
        this.tf1 = event.getTf1();
        this.tf2 = event.getTf2();
        this.vr1 = event.getVr1();
        this.vr2 = event.getVr2();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID excPICId;
    
    private String e1;
    private String e2;
    private String efdmax;
    private String efdmin;
    private String ka;
    private String kc;
    private String ke;
    private String kf;
    private String ki;
    private String kp;
    private String se1;
    private String se2;
    private String ta1;
    private String ta2;
    private String ta3;
    private String ta4;
    private String te;
    private String tf1;
    private String tf2;
    private String vr1;
    private String vr2;
    private String vrmax;
    private String vrmin;

    private static final Logger LOGGER 	= Logger.getLogger(ExcPICAggregate.class.getName());
}
