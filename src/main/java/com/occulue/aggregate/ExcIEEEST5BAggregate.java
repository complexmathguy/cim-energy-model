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
 * Aggregate handler for ExcIEEEST5B as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcIEEEST5B are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcIEEEST5BAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcIEEEST5BAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcIEEEST5BAggregate(CreateExcIEEEST5BCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcIEEEST5BCommand" );
    	CreateExcIEEEST5BEvent event = new CreateExcIEEEST5BEvent(command.getExcIEEEST5BId(), command.getKc(), command.getKr(), command.getT1(), command.getTb1(), command.getTb2(), command.getTc1(), command.getTc2(), command.getTob1(), command.getTob2(), command.getToc1(), command.getToc2(), command.getTub1(), command.getTub2(), command.getTuc1(), command.getTuc2(), command.getVrmax(), command.getVrmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcIEEEST5BCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcIEEEST5BCommand" );
    	UpdateExcIEEEST5BEvent event = new UpdateExcIEEEST5BEvent(command.getExcIEEEST5BId(), command.getKc(), command.getKr(), command.getT1(), command.getTb1(), command.getTb2(), command.getTc1(), command.getTc2(), command.getTob1(), command.getTob2(), command.getToc1(), command.getToc2(), command.getTub1(), command.getTub2(), command.getTuc1(), command.getTuc2(), command.getVrmax(), command.getVrmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcIEEEST5BCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcIEEEST5BCommand" );
        apply(new DeleteExcIEEEST5BEvent(command.getExcIEEEST5BId()));
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
    void on(CreateExcIEEEST5BEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcIEEEST5BEvent" );
    	this.excIEEEST5BId = event.getExcIEEEST5BId();
        this.kc = event.getKc();
        this.kr = event.getKr();
        this.t1 = event.getT1();
        this.tb1 = event.getTb1();
        this.tb2 = event.getTb2();
        this.tc1 = event.getTc1();
        this.tc2 = event.getTc2();
        this.tob1 = event.getTob1();
        this.tob2 = event.getTob2();
        this.toc1 = event.getToc1();
        this.toc2 = event.getToc2();
        this.tub1 = event.getTub1();
        this.tub2 = event.getTub2();
        this.tuc1 = event.getTuc1();
        this.tuc2 = event.getTuc2();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
    }
    
    @EventSourcingHandler
    void on(UpdateExcIEEEST5BEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.kc = event.getKc();
        this.kr = event.getKr();
        this.t1 = event.getT1();
        this.tb1 = event.getTb1();
        this.tb2 = event.getTb2();
        this.tc1 = event.getTc1();
        this.tc2 = event.getTc2();
        this.tob1 = event.getTob1();
        this.tob2 = event.getTob2();
        this.toc1 = event.getToc1();
        this.toc2 = event.getToc2();
        this.tub1 = event.getTub1();
        this.tub2 = event.getTub2();
        this.tuc1 = event.getTuc1();
        this.tuc2 = event.getTuc2();
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
    private UUID excIEEEST5BId;
    
    private String kc;
    private String kr;
    private String t1;
    private String tb1;
    private String tb2;
    private String tc1;
    private String tc2;
    private String tob1;
    private String tob2;
    private String toc1;
    private String toc2;
    private String tub1;
    private String tub2;
    private String tuc1;
    private String tuc2;
    private String vrmax;
    private String vrmin;

    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEST5BAggregate.class.getName());
}
