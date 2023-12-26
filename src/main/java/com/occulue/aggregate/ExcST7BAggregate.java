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
 * Aggregate handler for ExcST7B as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcST7B are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcST7BAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcST7BAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcST7BAggregate(CreateExcST7BCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcST7BCommand" );
    	CreateExcST7BEvent event = new CreateExcST7BEvent(command.getExcST7BId(), command.getKh(), command.getKia(), command.getKl(), command.getKpa(), command.getOelin(), command.getTb(), command.getTc(), command.getTf(), command.getTg(), command.getTia(), command.getTs(), command.getUelin(), command.getVmax(), command.getVmin(), command.getVrmax(), command.getVrmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcST7BCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcST7BCommand" );
    	UpdateExcST7BEvent event = new UpdateExcST7BEvent(command.getExcST7BId(), command.getKh(), command.getKia(), command.getKl(), command.getKpa(), command.getOelin(), command.getTb(), command.getTc(), command.getTf(), command.getTg(), command.getTia(), command.getTs(), command.getUelin(), command.getVmax(), command.getVmin(), command.getVrmax(), command.getVrmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcST7BCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcST7BCommand" );
        apply(new DeleteExcST7BEvent(command.getExcST7BId()));
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
    void on(CreateExcST7BEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcST7BEvent" );
    	this.excST7BId = event.getExcST7BId();
        this.kh = event.getKh();
        this.kia = event.getKia();
        this.kl = event.getKl();
        this.kpa = event.getKpa();
        this.oelin = event.getOelin();
        this.tb = event.getTb();
        this.tc = event.getTc();
        this.tf = event.getTf();
        this.tg = event.getTg();
        this.tia = event.getTia();
        this.ts = event.getTs();
        this.uelin = event.getUelin();
        this.vmax = event.getVmax();
        this.vmin = event.getVmin();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
    }
    
    @EventSourcingHandler
    void on(UpdateExcST7BEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.kh = event.getKh();
        this.kia = event.getKia();
        this.kl = event.getKl();
        this.kpa = event.getKpa();
        this.oelin = event.getOelin();
        this.tb = event.getTb();
        this.tc = event.getTc();
        this.tf = event.getTf();
        this.tg = event.getTg();
        this.tia = event.getTia();
        this.ts = event.getTs();
        this.uelin = event.getUelin();
        this.vmax = event.getVmax();
        this.vmin = event.getVmin();
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
    private UUID excST7BId;
    
    private String kh;
    private String kia;
    private String kl;
    private String kpa;
    private String oelin;
    private String tb;
    private String tc;
    private String tf;
    private String tg;
    private String tia;
    private String ts;
    private String uelin;
    private String vmax;
    private String vmin;
    private String vrmax;
    private String vrmin;

    private static final Logger LOGGER 	= Logger.getLogger(ExcST7BAggregate.class.getName());
}
