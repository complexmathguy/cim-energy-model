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
 * Aggregate handler for ExcELIN2 as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcELIN2 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcELIN2Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcELIN2Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcELIN2Aggregate(CreateExcELIN2Command command) throws Exception {
    	LOGGER.info( "Handling command CreateExcELIN2Command" );
    	CreateExcELIN2Event event = new CreateExcELIN2Event(command.getExcELIN2Id(), command.getEfdbas(), command.getIefmax(), command.getIefmax2(), command.getIefmin(), command.getK1(), command.getK1ec(), command.getK2(), command.getK3(), command.getK4(), command.getKd1(), command.getKe2(), command.getKetb(), command.getPid1max(), command.getSeve1(), command.getSeve2(), command.getTb1(), command.getTe(), command.getTe2(), command.getTi1(), command.getTi3(), command.getTi4(), command.getTr4(), command.getUpmax(), command.getUpmin(), command.getVe1(), command.getVe2(), command.getXp());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcELIN2Command command) throws Exception {
    	LOGGER.info( "handling command UpdateExcELIN2Command" );
    	UpdateExcELIN2Event event = new UpdateExcELIN2Event(command.getExcELIN2Id(), command.getEfdbas(), command.getIefmax(), command.getIefmax2(), command.getIefmin(), command.getK1(), command.getK1ec(), command.getK2(), command.getK3(), command.getK4(), command.getKd1(), command.getKe2(), command.getKetb(), command.getPid1max(), command.getSeve1(), command.getSeve2(), command.getTb1(), command.getTe(), command.getTe2(), command.getTi1(), command.getTi3(), command.getTi4(), command.getTr4(), command.getUpmax(), command.getUpmin(), command.getVe1(), command.getVe2(), command.getXp());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcELIN2Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcELIN2Command" );
        apply(new DeleteExcELIN2Event(command.getExcELIN2Id()));
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
    void on(CreateExcELIN2Event event) {	
    	LOGGER.info( "Event sourcing CreateExcELIN2Event" );
    	this.excELIN2Id = event.getExcELIN2Id();
        this.efdbas = event.getEfdbas();
        this.iefmax = event.getIefmax();
        this.iefmax2 = event.getIefmax2();
        this.iefmin = event.getIefmin();
        this.k1 = event.getK1();
        this.k1ec = event.getK1ec();
        this.k2 = event.getK2();
        this.k3 = event.getK3();
        this.k4 = event.getK4();
        this.kd1 = event.getKd1();
        this.ke2 = event.getKe2();
        this.ketb = event.getKetb();
        this.pid1max = event.getPid1max();
        this.seve1 = event.getSeve1();
        this.seve2 = event.getSeve2();
        this.tb1 = event.getTb1();
        this.te = event.getTe();
        this.te2 = event.getTe2();
        this.ti1 = event.getTi1();
        this.ti3 = event.getTi3();
        this.ti4 = event.getTi4();
        this.tr4 = event.getTr4();
        this.upmax = event.getUpmax();
        this.upmin = event.getUpmin();
        this.ve1 = event.getVe1();
        this.ve2 = event.getVe2();
        this.xp = event.getXp();
    }
    
    @EventSourcingHandler
    void on(UpdateExcELIN2Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.efdbas = event.getEfdbas();
        this.iefmax = event.getIefmax();
        this.iefmax2 = event.getIefmax2();
        this.iefmin = event.getIefmin();
        this.k1 = event.getK1();
        this.k1ec = event.getK1ec();
        this.k2 = event.getK2();
        this.k3 = event.getK3();
        this.k4 = event.getK4();
        this.kd1 = event.getKd1();
        this.ke2 = event.getKe2();
        this.ketb = event.getKetb();
        this.pid1max = event.getPid1max();
        this.seve1 = event.getSeve1();
        this.seve2 = event.getSeve2();
        this.tb1 = event.getTb1();
        this.te = event.getTe();
        this.te2 = event.getTe2();
        this.ti1 = event.getTi1();
        this.ti3 = event.getTi3();
        this.ti4 = event.getTi4();
        this.tr4 = event.getTr4();
        this.upmax = event.getUpmax();
        this.upmin = event.getUpmin();
        this.ve1 = event.getVe1();
        this.ve2 = event.getVe2();
        this.xp = event.getXp();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID excELIN2Id;
    
    private String efdbas;
    private String iefmax;
    private String iefmax2;
    private String iefmin;
    private String k1;
    private String k1ec;
    private String k2;
    private String k3;
    private String k4;
    private String kd1;
    private String ke2;
    private String ketb;
    private String pid1max;
    private String seve1;
    private String seve2;
    private String tb1;
    private String te;
    private String te2;
    private String ti1;
    private String ti3;
    private String ti4;
    private String tr4;
    private String upmax;
    private String upmin;
    private String ve1;
    private String ve2;
    private String xp;

    private static final Logger LOGGER 	= Logger.getLogger(ExcELIN2Aggregate.class.getName());
}
