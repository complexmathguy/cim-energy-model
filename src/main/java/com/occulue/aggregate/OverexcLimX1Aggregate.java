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
 * Aggregate handler for OverexcLimX1 as outlined for the CQRS pattern, all write responsibilities 
 * related to OverexcLimX1 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class OverexcLimX1Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public OverexcLimX1Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public OverexcLimX1Aggregate(CreateOverexcLimX1Command command) throws Exception {
    	LOGGER.info( "Handling command CreateOverexcLimX1Command" );
    	CreateOverexcLimX1Event event = new CreateOverexcLimX1Event(command.getOverexcLimX1Id(), command.getEfd1(), command.getEfd2(), command.getEfd3(), command.getEfddes(), command.getEfdrated(), command.getKmx(), command.getT1(), command.getT2(), command.getT3(), command.getVlow());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateOverexcLimX1Command command) throws Exception {
    	LOGGER.info( "handling command UpdateOverexcLimX1Command" );
    	UpdateOverexcLimX1Event event = new UpdateOverexcLimX1Event(command.getOverexcLimX1Id(), command.getEfd1(), command.getEfd2(), command.getEfd3(), command.getEfddes(), command.getEfdrated(), command.getKmx(), command.getT1(), command.getT2(), command.getT3(), command.getVlow());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteOverexcLimX1Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteOverexcLimX1Command" );
        apply(new DeleteOverexcLimX1Event(command.getOverexcLimX1Id()));
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
    void on(CreateOverexcLimX1Event event) {	
    	LOGGER.info( "Event sourcing CreateOverexcLimX1Event" );
    	this.overexcLimX1Id = event.getOverexcLimX1Id();
        this.efd1 = event.getEfd1();
        this.efd2 = event.getEfd2();
        this.efd3 = event.getEfd3();
        this.efddes = event.getEfddes();
        this.efdrated = event.getEfdrated();
        this.kmx = event.getKmx();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.vlow = event.getVlow();
    }
    
    @EventSourcingHandler
    void on(UpdateOverexcLimX1Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.efd1 = event.getEfd1();
        this.efd2 = event.getEfd2();
        this.efd3 = event.getEfd3();
        this.efddes = event.getEfddes();
        this.efdrated = event.getEfdrated();
        this.kmx = event.getKmx();
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
    private UUID overexcLimX1Id;
    
    private String efd1;
    private String efd2;
    private String efd3;
    private String efddes;
    private String efdrated;
    private String kmx;
    private String t1;
    private String t2;
    private String t3;
    private String vlow;

    private static final Logger LOGGER 	= Logger.getLogger(OverexcLimX1Aggregate.class.getName());
}
