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
 * Aggregate handler for ExcIEEEST1A as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcIEEEST1A are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcIEEEST1AAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcIEEEST1AAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcIEEEST1AAggregate(CreateExcIEEEST1ACommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcIEEEST1ACommand" );
    	CreateExcIEEEST1AEvent event = new CreateExcIEEEST1AEvent(command.getExcIEEEST1AId(), command.getIlr(), command.getKa(), command.getKc(), command.getKf(), command.getKlr(), command.getPssin(), command.getTa(), command.getTb(), command.getTb1(), command.getTc(), command.getTc1(), command.getTf(), command.getUelin(), command.getVamax(), command.getVamin(), command.getVimax(), command.getVimin(), command.getVrmax(), command.getVrmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcIEEEST1ACommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcIEEEST1ACommand" );
    	UpdateExcIEEEST1AEvent event = new UpdateExcIEEEST1AEvent(command.getExcIEEEST1AId(), command.getIlr(), command.getKa(), command.getKc(), command.getKf(), command.getKlr(), command.getPssin(), command.getTa(), command.getTb(), command.getTb1(), command.getTc(), command.getTc1(), command.getTf(), command.getUelin(), command.getVamax(), command.getVamin(), command.getVimax(), command.getVimin(), command.getVrmax(), command.getVrmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcIEEEST1ACommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcIEEEST1ACommand" );
        apply(new DeleteExcIEEEST1AEvent(command.getExcIEEEST1AId()));
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
    void on(CreateExcIEEEST1AEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcIEEEST1AEvent" );
    	this.excIEEEST1AId = event.getExcIEEEST1AId();
        this.ilr = event.getIlr();
        this.ka = event.getKa();
        this.kc = event.getKc();
        this.kf = event.getKf();
        this.klr = event.getKlr();
        this.pssin = event.getPssin();
        this.ta = event.getTa();
        this.tb = event.getTb();
        this.tb1 = event.getTb1();
        this.tc = event.getTc();
        this.tc1 = event.getTc1();
        this.tf = event.getTf();
        this.uelin = event.getUelin();
        this.vamax = event.getVamax();
        this.vamin = event.getVamin();
        this.vimax = event.getVimax();
        this.vimin = event.getVimin();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
    }
    
    @EventSourcingHandler
    void on(UpdateExcIEEEST1AEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.ilr = event.getIlr();
        this.ka = event.getKa();
        this.kc = event.getKc();
        this.kf = event.getKf();
        this.klr = event.getKlr();
        this.pssin = event.getPssin();
        this.ta = event.getTa();
        this.tb = event.getTb();
        this.tb1 = event.getTb1();
        this.tc = event.getTc();
        this.tc1 = event.getTc1();
        this.tf = event.getTf();
        this.uelin = event.getUelin();
        this.vamax = event.getVamax();
        this.vamin = event.getVamin();
        this.vimax = event.getVimax();
        this.vimin = event.getVimin();
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
    private UUID excIEEEST1AId;
    
    private String ilr;
    private String ka;
    private String kc;
    private String kf;
    private String klr;
    private String pssin;
    private String ta;
    private String tb;
    private String tb1;
    private String tc;
    private String tc1;
    private String tf;
    private String uelin;
    private String vamax;
    private String vamin;
    private String vimax;
    private String vimin;
    private String vrmax;
    private String vrmin;

    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEST1AAggregate.class.getName());
}
