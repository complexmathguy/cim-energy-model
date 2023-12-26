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
 * Aggregate handler for ExcIEEEST7B as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcIEEEST7B are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcIEEEST7BAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcIEEEST7BAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcIEEEST7BAggregate(CreateExcIEEEST7BCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcIEEEST7BCommand" );
    	CreateExcIEEEST7BEvent event = new CreateExcIEEEST7BEvent(command.getExcIEEEST7BId(), command.getKh(), command.getKia(), command.getKl(), command.getKpa(), command.getOelin(), command.getTb(), command.getTc(), command.getTf(), command.getTg(), command.getTia(), command.getUelin(), command.getVmax(), command.getVmin(), command.getVrmax(), command.getVrmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcIEEEST7BCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcIEEEST7BCommand" );
    	UpdateExcIEEEST7BEvent event = new UpdateExcIEEEST7BEvent(command.getExcIEEEST7BId(), command.getKh(), command.getKia(), command.getKl(), command.getKpa(), command.getOelin(), command.getTb(), command.getTc(), command.getTf(), command.getTg(), command.getTia(), command.getUelin(), command.getVmax(), command.getVmin(), command.getVrmax(), command.getVrmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcIEEEST7BCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcIEEEST7BCommand" );
        apply(new DeleteExcIEEEST7BEvent(command.getExcIEEEST7BId()));
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
    void on(CreateExcIEEEST7BEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcIEEEST7BEvent" );
    	this.excIEEEST7BId = event.getExcIEEEST7BId();
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
        this.uelin = event.getUelin();
        this.vmax = event.getVmax();
        this.vmin = event.getVmin();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
    }
    
    @EventSourcingHandler
    void on(UpdateExcIEEEST7BEvent event) {
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
    private UUID excIEEEST7BId;
    
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
    private String uelin;
    private String vmax;
    private String vmin;
    private String vrmax;
    private String vrmin;

    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEST7BAggregate.class.getName());
}
