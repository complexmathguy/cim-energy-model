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
 * Aggregate handler for ExcST6B as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcST6B are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcST6BAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcST6BAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcST6BAggregate(CreateExcST6BCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcST6BCommand" );
    	CreateExcST6BEvent event = new CreateExcST6BEvent(command.getExcST6BId(), command.getIlr(), command.getK1(), command.getKcl(), command.getKff(), command.getKg(), command.getKia(), command.getKlr(), command.getKm(), command.getKpa(), command.getKvd(), command.getOelin(), command.getTg(), command.getTs(), command.getTvd(), command.getVamax(), command.getVamin(), command.getVilim(), command.getVimax(), command.getVimin(), command.getVmult(), command.getVrmax(), command.getVrmin(), command.getXc());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcST6BCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcST6BCommand" );
    	UpdateExcST6BEvent event = new UpdateExcST6BEvent(command.getExcST6BId(), command.getIlr(), command.getK1(), command.getKcl(), command.getKff(), command.getKg(), command.getKia(), command.getKlr(), command.getKm(), command.getKpa(), command.getKvd(), command.getOelin(), command.getTg(), command.getTs(), command.getTvd(), command.getVamax(), command.getVamin(), command.getVilim(), command.getVimax(), command.getVimin(), command.getVmult(), command.getVrmax(), command.getVrmin(), command.getXc());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcST6BCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcST6BCommand" );
        apply(new DeleteExcST6BEvent(command.getExcST6BId()));
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
    void on(CreateExcST6BEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcST6BEvent" );
    	this.excST6BId = event.getExcST6BId();
        this.ilr = event.getIlr();
        this.k1 = event.getK1();
        this.kcl = event.getKcl();
        this.kff = event.getKff();
        this.kg = event.getKg();
        this.kia = event.getKia();
        this.klr = event.getKlr();
        this.km = event.getKm();
        this.kpa = event.getKpa();
        this.kvd = event.getKvd();
        this.oelin = event.getOelin();
        this.tg = event.getTg();
        this.ts = event.getTs();
        this.tvd = event.getTvd();
        this.vamax = event.getVamax();
        this.vamin = event.getVamin();
        this.vilim = event.getVilim();
        this.vimax = event.getVimax();
        this.vimin = event.getVimin();
        this.vmult = event.getVmult();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
        this.xc = event.getXc();
    }
    
    @EventSourcingHandler
    void on(UpdateExcST6BEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.ilr = event.getIlr();
        this.k1 = event.getK1();
        this.kcl = event.getKcl();
        this.kff = event.getKff();
        this.kg = event.getKg();
        this.kia = event.getKia();
        this.klr = event.getKlr();
        this.km = event.getKm();
        this.kpa = event.getKpa();
        this.kvd = event.getKvd();
        this.oelin = event.getOelin();
        this.tg = event.getTg();
        this.ts = event.getTs();
        this.tvd = event.getTvd();
        this.vamax = event.getVamax();
        this.vamin = event.getVamin();
        this.vilim = event.getVilim();
        this.vimax = event.getVimax();
        this.vimin = event.getVimin();
        this.vmult = event.getVmult();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
        this.xc = event.getXc();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID excST6BId;
    
    private String ilr;
    private String k1;
    private String kcl;
    private String kff;
    private String kg;
    private String kia;
    private String klr;
    private String km;
    private String kpa;
    private String kvd;
    private String oelin;
    private String tg;
    private String ts;
    private String tvd;
    private String vamax;
    private String vamin;
    private String vilim;
    private String vimax;
    private String vimin;
    private String vmult;
    private String vrmax;
    private String vrmin;
    private String xc;

    private static final Logger LOGGER 	= Logger.getLogger(ExcST6BAggregate.class.getName());
}
