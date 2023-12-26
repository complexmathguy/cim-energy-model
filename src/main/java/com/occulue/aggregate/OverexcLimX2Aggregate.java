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
 * Aggregate handler for OverexcLimX2 as outlined for the CQRS pattern, all write responsibilities 
 * related to OverexcLimX2 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class OverexcLimX2Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public OverexcLimX2Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public OverexcLimX2Aggregate(CreateOverexcLimX2Command command) throws Exception {
    	LOGGER.info( "Handling command CreateOverexcLimX2Command" );
    	CreateOverexcLimX2Event event = new CreateOverexcLimX2Event(command.getOverexcLimX2Id(), command.getEfd1(), command.getEfd2(), command.getEfd3(), command.getEfddes(), command.getEfdrated(), command.getKmx(), command.getM(), command.getT1(), command.getT2(), command.getT3(), command.getVlow());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateOverexcLimX2Command command) throws Exception {
    	LOGGER.info( "handling command UpdateOverexcLimX2Command" );
    	UpdateOverexcLimX2Event event = new UpdateOverexcLimX2Event(command.getOverexcLimX2Id(), command.getEfd1(), command.getEfd2(), command.getEfd3(), command.getEfddes(), command.getEfdrated(), command.getKmx(), command.getM(), command.getT1(), command.getT2(), command.getT3(), command.getVlow());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteOverexcLimX2Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteOverexcLimX2Command" );
        apply(new DeleteOverexcLimX2Event(command.getOverexcLimX2Id()));
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
    void on(CreateOverexcLimX2Event event) {	
    	LOGGER.info( "Event sourcing CreateOverexcLimX2Event" );
    	this.overexcLimX2Id = event.getOverexcLimX2Id();
        this.efd1 = event.getEfd1();
        this.efd2 = event.getEfd2();
        this.efd3 = event.getEfd3();
        this.efddes = event.getEfddes();
        this.efdrated = event.getEfdrated();
        this.kmx = event.getKmx();
        this.m = event.getM();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.vlow = event.getVlow();
    }
    
    @EventSourcingHandler
    void on(UpdateOverexcLimX2Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.efd1 = event.getEfd1();
        this.efd2 = event.getEfd2();
        this.efd3 = event.getEfd3();
        this.efddes = event.getEfddes();
        this.efdrated = event.getEfdrated();
        this.kmx = event.getKmx();
        this.m = event.getM();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.vlow = event.getVlow();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID overexcLimX2Id;
    
    private String efd1;
    private String efd2;
    private String efd3;
    private String efddes;
    private String efdrated;
    private String kmx;
    private String m;
    private String t1;
    private String t2;
    private String t3;
    private String vlow;

    private static final Logger LOGGER 	= Logger.getLogger(OverexcLimX2Aggregate.class.getName());
}
