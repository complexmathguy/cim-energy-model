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
 * Aggregate handler for PssIEEE4B as outlined for the CQRS pattern, all write responsibilities 
 * related to PssIEEE4B are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PssIEEE4BAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PssIEEE4BAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PssIEEE4BAggregate(CreatePssIEEE4BCommand command) throws Exception {
    	LOGGER.info( "Handling command CreatePssIEEE4BCommand" );
    	CreatePssIEEE4BEvent event = new CreatePssIEEE4BEvent(command.getPssIEEE4BId(), command.getBwh1(), command.getBwh2(), command.getBwl1(), command.getBwl2(), command.getKh(), command.getKh1(), command.getKh11(), command.getKh17(), command.getKh2(), command.getKi(), command.getKi1(), command.getKi11(), command.getKi17(), command.getKi2(), command.getKl(), command.getKl1(), command.getKl11(), command.getKl17(), command.getKl2(), command.getOmeganh1(), command.getOmeganh2(), command.getOmeganl1(), command.getOmeganl2(), command.getTh1(), command.getTh10(), command.getTh11(), command.getTh12(), command.getTh2(), command.getTh3(), command.getTh4(), command.getTh5(), command.getTh6(), command.getTh7(), command.getTh8(), command.getTh9(), command.getTi1(), command.getTi10(), command.getTi11(), command.getTi12(), command.getTi2(), command.getTi3(), command.getTi4(), command.getTi5(), command.getTi6(), command.getTi7(), command.getTi8(), command.getTi9(), command.getTl1(), command.getTl10(), command.getTl11(), command.getTl12(), command.getTl2(), command.getTl3(), command.getTl4(), command.getTl5(), command.getTl6(), command.getTl7(), command.getTl8(), command.getTl9(), command.getVhmax(), command.getVhmin(), command.getVimax(), command.getVimin(), command.getVlmax(), command.getVlmin(), command.getVstmax(), command.getVstmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePssIEEE4BCommand command) throws Exception {
    	LOGGER.info( "handling command UpdatePssIEEE4BCommand" );
    	UpdatePssIEEE4BEvent event = new UpdatePssIEEE4BEvent(command.getPssIEEE4BId(), command.getBwh1(), command.getBwh2(), command.getBwl1(), command.getBwl2(), command.getKh(), command.getKh1(), command.getKh11(), command.getKh17(), command.getKh2(), command.getKi(), command.getKi1(), command.getKi11(), command.getKi17(), command.getKi2(), command.getKl(), command.getKl1(), command.getKl11(), command.getKl17(), command.getKl2(), command.getOmeganh1(), command.getOmeganh2(), command.getOmeganl1(), command.getOmeganl2(), command.getTh1(), command.getTh10(), command.getTh11(), command.getTh12(), command.getTh2(), command.getTh3(), command.getTh4(), command.getTh5(), command.getTh6(), command.getTh7(), command.getTh8(), command.getTh9(), command.getTi1(), command.getTi10(), command.getTi11(), command.getTi12(), command.getTi2(), command.getTi3(), command.getTi4(), command.getTi5(), command.getTi6(), command.getTi7(), command.getTi8(), command.getTi9(), command.getTl1(), command.getTl10(), command.getTl11(), command.getTl12(), command.getTl2(), command.getTl3(), command.getTl4(), command.getTl5(), command.getTl6(), command.getTl7(), command.getTl8(), command.getTl9(), command.getVhmax(), command.getVhmin(), command.getVimax(), command.getVimin(), command.getVlmax(), command.getVlmin(), command.getVstmax(), command.getVstmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePssIEEE4BCommand command) throws Exception {
    	LOGGER.info( "Handling command DeletePssIEEE4BCommand" );
        apply(new DeletePssIEEE4BEvent(command.getPssIEEE4BId()));
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
    void on(CreatePssIEEE4BEvent event) {	
    	LOGGER.info( "Event sourcing CreatePssIEEE4BEvent" );
    	this.pssIEEE4BId = event.getPssIEEE4BId();
        this.bwh1 = event.getBwh1();
        this.bwh2 = event.getBwh2();
        this.bwl1 = event.getBwl1();
        this.bwl2 = event.getBwl2();
        this.kh = event.getKh();
        this.kh1 = event.getKh1();
        this.kh11 = event.getKh11();
        this.kh17 = event.getKh17();
        this.kh2 = event.getKh2();
        this.ki = event.getKi();
        this.ki1 = event.getKi1();
        this.ki11 = event.getKi11();
        this.ki17 = event.getKi17();
        this.ki2 = event.getKi2();
        this.kl = event.getKl();
        this.kl1 = event.getKl1();
        this.kl11 = event.getKl11();
        this.kl17 = event.getKl17();
        this.kl2 = event.getKl2();
        this.omeganh1 = event.getOmeganh1();
        this.omeganh2 = event.getOmeganh2();
        this.omeganl1 = event.getOmeganl1();
        this.omeganl2 = event.getOmeganl2();
        this.th1 = event.getTh1();
        this.th10 = event.getTh10();
        this.th11 = event.getTh11();
        this.th12 = event.getTh12();
        this.th2 = event.getTh2();
        this.th3 = event.getTh3();
        this.th4 = event.getTh4();
        this.th5 = event.getTh5();
        this.th6 = event.getTh6();
        this.th7 = event.getTh7();
        this.th8 = event.getTh8();
        this.th9 = event.getTh9();
        this.ti1 = event.getTi1();
        this.ti10 = event.getTi10();
        this.ti11 = event.getTi11();
        this.ti12 = event.getTi12();
        this.ti2 = event.getTi2();
        this.ti3 = event.getTi3();
        this.ti4 = event.getTi4();
        this.ti5 = event.getTi5();
        this.ti6 = event.getTi6();
        this.ti7 = event.getTi7();
        this.ti8 = event.getTi8();
        this.ti9 = event.getTi9();
        this.tl1 = event.getTl1();
        this.tl10 = event.getTl10();
        this.tl11 = event.getTl11();
        this.tl12 = event.getTl12();
        this.tl2 = event.getTl2();
        this.tl3 = event.getTl3();
        this.tl4 = event.getTl4();
        this.tl5 = event.getTl5();
        this.tl6 = event.getTl6();
        this.tl7 = event.getTl7();
        this.tl8 = event.getTl8();
        this.tl9 = event.getTl9();
        this.vhmax = event.getVhmax();
        this.vhmin = event.getVhmin();
        this.vimax = event.getVimax();
        this.vimin = event.getVimin();
        this.vlmax = event.getVlmax();
        this.vlmin = event.getVlmin();
        this.vstmax = event.getVstmax();
        this.vstmin = event.getVstmin();
    }
    
    @EventSourcingHandler
    void on(UpdatePssIEEE4BEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.bwh1 = event.getBwh1();
        this.bwh2 = event.getBwh2();
        this.bwl1 = event.getBwl1();
        this.bwl2 = event.getBwl2();
        this.kh = event.getKh();
        this.kh1 = event.getKh1();
        this.kh11 = event.getKh11();
        this.kh17 = event.getKh17();
        this.kh2 = event.getKh2();
        this.ki = event.getKi();
        this.ki1 = event.getKi1();
        this.ki11 = event.getKi11();
        this.ki17 = event.getKi17();
        this.ki2 = event.getKi2();
        this.kl = event.getKl();
        this.kl1 = event.getKl1();
        this.kl11 = event.getKl11();
        this.kl17 = event.getKl17();
        this.kl2 = event.getKl2();
        this.omeganh1 = event.getOmeganh1();
        this.omeganh2 = event.getOmeganh2();
        this.omeganl1 = event.getOmeganl1();
        this.omeganl2 = event.getOmeganl2();
        this.th1 = event.getTh1();
        this.th10 = event.getTh10();
        this.th11 = event.getTh11();
        this.th12 = event.getTh12();
        this.th2 = event.getTh2();
        this.th3 = event.getTh3();
        this.th4 = event.getTh4();
        this.th5 = event.getTh5();
        this.th6 = event.getTh6();
        this.th7 = event.getTh7();
        this.th8 = event.getTh8();
        this.th9 = event.getTh9();
        this.ti1 = event.getTi1();
        this.ti10 = event.getTi10();
        this.ti11 = event.getTi11();
        this.ti12 = event.getTi12();
        this.ti2 = event.getTi2();
        this.ti3 = event.getTi3();
        this.ti4 = event.getTi4();
        this.ti5 = event.getTi5();
        this.ti6 = event.getTi6();
        this.ti7 = event.getTi7();
        this.ti8 = event.getTi8();
        this.ti9 = event.getTi9();
        this.tl1 = event.getTl1();
        this.tl10 = event.getTl10();
        this.tl11 = event.getTl11();
        this.tl12 = event.getTl12();
        this.tl2 = event.getTl2();
        this.tl3 = event.getTl3();
        this.tl4 = event.getTl4();
        this.tl5 = event.getTl5();
        this.tl6 = event.getTl6();
        this.tl7 = event.getTl7();
        this.tl8 = event.getTl8();
        this.tl9 = event.getTl9();
        this.vhmax = event.getVhmax();
        this.vhmin = event.getVhmin();
        this.vimax = event.getVimax();
        this.vimin = event.getVimin();
        this.vlmax = event.getVlmax();
        this.vlmin = event.getVlmin();
        this.vstmax = event.getVstmax();
        this.vstmin = event.getVstmin();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID pssIEEE4BId;
    
    private String bwh1;
    private String bwh2;
    private String bwl1;
    private String bwl2;
    private String kh;
    private String kh1;
    private String kh11;
    private String kh17;
    private String kh2;
    private String ki;
    private String ki1;
    private String ki11;
    private String ki17;
    private String ki2;
    private String kl;
    private String kl1;
    private String kl11;
    private String kl17;
    private String kl2;
    private String omeganh1;
    private String omeganh2;
    private String omeganl1;
    private String omeganl2;
    private String th1;
    private String th10;
    private String th11;
    private String th12;
    private String th2;
    private String th3;
    private String th4;
    private String th5;
    private String th6;
    private String th7;
    private String th8;
    private String th9;
    private String ti1;
    private String ti10;
    private String ti11;
    private String ti12;
    private String ti2;
    private String ti3;
    private String ti4;
    private String ti5;
    private String ti6;
    private String ti7;
    private String ti8;
    private String ti9;
    private String tl1;
    private String tl10;
    private String tl11;
    private String tl12;
    private String tl2;
    private String tl3;
    private String tl4;
    private String tl5;
    private String tl6;
    private String tl7;
    private String tl8;
    private String tl9;
    private String vhmax;
    private String vhmin;
    private String vimax;
    private String vimin;
    private String vlmax;
    private String vlmin;
    private String vstmax;
    private String vstmin;

    private static final Logger LOGGER 	= Logger.getLogger(PssIEEE4BAggregate.class.getName());
}
