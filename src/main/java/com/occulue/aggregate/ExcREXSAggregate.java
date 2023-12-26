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
 * Aggregate handler for ExcREXS as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcREXS are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcREXSAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcREXSAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcREXSAggregate(CreateExcREXSCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcREXSCommand" );
    	CreateExcREXSEvent event = new CreateExcREXSEvent(command.getExcREXSId(), command.getE1(), command.getE2(), command.getFbf(), command.getFlimf(), command.getKc(), command.getKd(), command.getKe(), command.getKefd(), command.getKf(), command.getKh(), command.getKii(), command.getKip(), command.getKs(), command.getKvi(), command.getKvp(), command.getKvphz(), command.getNvphz(), command.getSe1(), command.getSe2(), command.getTa(), command.getTb1(), command.getTb2(), command.getTc1(), command.getTc2(), command.getTe(), command.getTf(), command.getTf1(), command.getTf2(), command.getTp(), command.getVcmax(), command.getVfmax(), command.getVfmin(), command.getVimax(), command.getVrmax(), command.getVrmin(), command.getXc());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcREXSCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcREXSCommand" );
    	UpdateExcREXSEvent event = new UpdateExcREXSEvent(command.getExcREXSId(), command.getE1(), command.getE2(), command.getFbf(), command.getFlimf(), command.getKc(), command.getKd(), command.getKe(), command.getKefd(), command.getKf(), command.getKh(), command.getKii(), command.getKip(), command.getKs(), command.getKvi(), command.getKvp(), command.getKvphz(), command.getNvphz(), command.getSe1(), command.getSe2(), command.getTa(), command.getTb1(), command.getTb2(), command.getTc1(), command.getTc2(), command.getTe(), command.getTf(), command.getTf1(), command.getTf2(), command.getTp(), command.getVcmax(), command.getVfmax(), command.getVfmin(), command.getVimax(), command.getVrmax(), command.getVrmin(), command.getXc());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcREXSCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcREXSCommand" );
        apply(new DeleteExcREXSEvent(command.getExcREXSId()));
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
    void on(CreateExcREXSEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcREXSEvent" );
    	this.excREXSId = event.getExcREXSId();
        this.e1 = event.getE1();
        this.e2 = event.getE2();
        this.fbf = event.getFbf();
        this.flimf = event.getFlimf();
        this.kc = event.getKc();
        this.kd = event.getKd();
        this.ke = event.getKe();
        this.kefd = event.getKefd();
        this.kf = event.getKf();
        this.kh = event.getKh();
        this.kii = event.getKii();
        this.kip = event.getKip();
        this.ks = event.getKs();
        this.kvi = event.getKvi();
        this.kvp = event.getKvp();
        this.kvphz = event.getKvphz();
        this.nvphz = event.getNvphz();
        this.se1 = event.getSe1();
        this.se2 = event.getSe2();
        this.ta = event.getTa();
        this.tb1 = event.getTb1();
        this.tb2 = event.getTb2();
        this.tc1 = event.getTc1();
        this.tc2 = event.getTc2();
        this.te = event.getTe();
        this.tf = event.getTf();
        this.tf1 = event.getTf1();
        this.tf2 = event.getTf2();
        this.tp = event.getTp();
        this.vcmax = event.getVcmax();
        this.vfmax = event.getVfmax();
        this.vfmin = event.getVfmin();
        this.vimax = event.getVimax();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
        this.xc = event.getXc();
    }
    
    @EventSourcingHandler
    void on(UpdateExcREXSEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.e1 = event.getE1();
        this.e2 = event.getE2();
        this.fbf = event.getFbf();
        this.flimf = event.getFlimf();
        this.kc = event.getKc();
        this.kd = event.getKd();
        this.ke = event.getKe();
        this.kefd = event.getKefd();
        this.kf = event.getKf();
        this.kh = event.getKh();
        this.kii = event.getKii();
        this.kip = event.getKip();
        this.ks = event.getKs();
        this.kvi = event.getKvi();
        this.kvp = event.getKvp();
        this.kvphz = event.getKvphz();
        this.nvphz = event.getNvphz();
        this.se1 = event.getSe1();
        this.se2 = event.getSe2();
        this.ta = event.getTa();
        this.tb1 = event.getTb1();
        this.tb2 = event.getTb2();
        this.tc1 = event.getTc1();
        this.tc2 = event.getTc2();
        this.te = event.getTe();
        this.tf = event.getTf();
        this.tf1 = event.getTf1();
        this.tf2 = event.getTf2();
        this.tp = event.getTp();
        this.vcmax = event.getVcmax();
        this.vfmax = event.getVfmax();
        this.vfmin = event.getVfmin();
        this.vimax = event.getVimax();
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
    private UUID excREXSId;
    
    private String e1;
    private String e2;
    private String fbf;
    private String flimf;
    private String kc;
    private String kd;
    private String ke;
    private String kefd;
    private String kf;
    private String kh;
    private String kii;
    private String kip;
    private String ks;
    private String kvi;
    private String kvp;
    private String kvphz;
    private String nvphz;
    private String se1;
    private String se2;
    private String ta;
    private String tb1;
    private String tb2;
    private String tc1;
    private String tc2;
    private String te;
    private String tf;
    private String tf1;
    private String tf2;
    private String tp;
    private String vcmax;
    private String vfmax;
    private String vfmin;
    private String vimax;
    private String vrmax;
    private String vrmin;
    private String xc;

    private static final Logger LOGGER 	= Logger.getLogger(ExcREXSAggregate.class.getName());
}
