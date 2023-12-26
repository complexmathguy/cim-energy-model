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
 * Aggregate handler for ExcIEEEDC4B as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcIEEEDC4B are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcIEEEDC4BAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcIEEEDC4BAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcIEEEDC4BAggregate(CreateExcIEEEDC4BCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcIEEEDC4BCommand" );
    	CreateExcIEEEDC4BEvent event = new CreateExcIEEEDC4BEvent(command.getExcIEEEDC4BId(), command.getEfd1(), command.getEfd2(), command.getKa(), command.getKd(), command.getKe(), command.getKf(), command.getKi(), command.getKp(), command.getOelin(), command.getSeefd1(), command.getSeefd2(), command.getTa(), command.getTd(), command.getTe(), command.getTf(), command.getUelin(), command.getVemin(), command.getVrmax(), command.getVrmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcIEEEDC4BCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcIEEEDC4BCommand" );
    	UpdateExcIEEEDC4BEvent event = new UpdateExcIEEEDC4BEvent(command.getExcIEEEDC4BId(), command.getEfd1(), command.getEfd2(), command.getKa(), command.getKd(), command.getKe(), command.getKf(), command.getKi(), command.getKp(), command.getOelin(), command.getSeefd1(), command.getSeefd2(), command.getTa(), command.getTd(), command.getTe(), command.getTf(), command.getUelin(), command.getVemin(), command.getVrmax(), command.getVrmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcIEEEDC4BCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcIEEEDC4BCommand" );
        apply(new DeleteExcIEEEDC4BEvent(command.getExcIEEEDC4BId()));
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
    void on(CreateExcIEEEDC4BEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcIEEEDC4BEvent" );
    	this.excIEEEDC4BId = event.getExcIEEEDC4BId();
        this.efd1 = event.getEfd1();
        this.efd2 = event.getEfd2();
        this.ka = event.getKa();
        this.kd = event.getKd();
        this.ke = event.getKe();
        this.kf = event.getKf();
        this.ki = event.getKi();
        this.kp = event.getKp();
        this.oelin = event.getOelin();
        this.seefd1 = event.getSeefd1();
        this.seefd2 = event.getSeefd2();
        this.ta = event.getTa();
        this.td = event.getTd();
        this.te = event.getTe();
        this.tf = event.getTf();
        this.uelin = event.getUelin();
        this.vemin = event.getVemin();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
    }
    
    @EventSourcingHandler
    void on(UpdateExcIEEEDC4BEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.efd1 = event.getEfd1();
        this.efd2 = event.getEfd2();
        this.ka = event.getKa();
        this.kd = event.getKd();
        this.ke = event.getKe();
        this.kf = event.getKf();
        this.ki = event.getKi();
        this.kp = event.getKp();
        this.oelin = event.getOelin();
        this.seefd1 = event.getSeefd1();
        this.seefd2 = event.getSeefd2();
        this.ta = event.getTa();
        this.td = event.getTd();
        this.te = event.getTe();
        this.tf = event.getTf();
        this.uelin = event.getUelin();
        this.vemin = event.getVemin();
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
    private UUID excIEEEDC4BId;
    
    private String efd1;
    private String efd2;
    private String ka;
    private String kd;
    private String ke;
    private String kf;
    private String ki;
    private String kp;
    private String oelin;
    private String seefd1;
    private String seefd2;
    private String ta;
    private String td;
    private String te;
    private String tf;
    private String uelin;
    private String vemin;
    private String vrmax;
    private String vrmin;

    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEDC4BAggregate.class.getName());
}
