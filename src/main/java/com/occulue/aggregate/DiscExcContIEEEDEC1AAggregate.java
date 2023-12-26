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
 * Aggregate handler for DiscExcContIEEEDEC1A as outlined for the CQRS pattern, all write responsibilities 
 * related to DiscExcContIEEEDEC1A are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class DiscExcContIEEEDEC1AAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public DiscExcContIEEEDEC1AAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public DiscExcContIEEEDEC1AAggregate(CreateDiscExcContIEEEDEC1ACommand command) throws Exception {
    	LOGGER.info( "Handling command CreateDiscExcContIEEEDEC1ACommand" );
    	CreateDiscExcContIEEEDEC1AEvent event = new CreateDiscExcContIEEEDEC1AEvent(command.getDiscExcContIEEEDEC1AId(), command.getEsc(), command.getKan(), command.getKetl(), command.getTan(), command.getTd(), command.getTl1(), command.getTl2(), command.getTw5(), command.getValue(), command.getVanmax(), command.getVomax(), command.getVomin(), command.getVsmax(), command.getVsmin(), command.getVtc(), command.getVtlmt(), command.getVtm(), command.getVtn());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateDiscExcContIEEEDEC1ACommand command) throws Exception {
    	LOGGER.info( "handling command UpdateDiscExcContIEEEDEC1ACommand" );
    	UpdateDiscExcContIEEEDEC1AEvent event = new UpdateDiscExcContIEEEDEC1AEvent(command.getDiscExcContIEEEDEC1AId(), command.getEsc(), command.getKan(), command.getKetl(), command.getTan(), command.getTd(), command.getTl1(), command.getTl2(), command.getTw5(), command.getValue(), command.getVanmax(), command.getVomax(), command.getVomin(), command.getVsmax(), command.getVsmin(), command.getVtc(), command.getVtlmt(), command.getVtm(), command.getVtn());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteDiscExcContIEEEDEC1ACommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteDiscExcContIEEEDEC1ACommand" );
        apply(new DeleteDiscExcContIEEEDEC1AEvent(command.getDiscExcContIEEEDEC1AId()));
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
    void on(CreateDiscExcContIEEEDEC1AEvent event) {	
    	LOGGER.info( "Event sourcing CreateDiscExcContIEEEDEC1AEvent" );
    	this.discExcContIEEEDEC1AId = event.getDiscExcContIEEEDEC1AId();
        this.esc = event.getEsc();
        this.kan = event.getKan();
        this.ketl = event.getKetl();
        this.tan = event.getTan();
        this.td = event.getTd();
        this.tl1 = event.getTl1();
        this.tl2 = event.getTl2();
        this.tw5 = event.getTw5();
        this.value = event.getValue();
        this.vanmax = event.getVanmax();
        this.vomax = event.getVomax();
        this.vomin = event.getVomin();
        this.vsmax = event.getVsmax();
        this.vsmin = event.getVsmin();
        this.vtc = event.getVtc();
        this.vtlmt = event.getVtlmt();
        this.vtm = event.getVtm();
        this.vtn = event.getVtn();
    }
    
    @EventSourcingHandler
    void on(UpdateDiscExcContIEEEDEC1AEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.esc = event.getEsc();
        this.kan = event.getKan();
        this.ketl = event.getKetl();
        this.tan = event.getTan();
        this.td = event.getTd();
        this.tl1 = event.getTl1();
        this.tl2 = event.getTl2();
        this.tw5 = event.getTw5();
        this.value = event.getValue();
        this.vanmax = event.getVanmax();
        this.vomax = event.getVomax();
        this.vomin = event.getVomin();
        this.vsmax = event.getVsmax();
        this.vsmin = event.getVsmin();
        this.vtc = event.getVtc();
        this.vtlmt = event.getVtlmt();
        this.vtm = event.getVtm();
        this.vtn = event.getVtn();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID discExcContIEEEDEC1AId;
    
    private String esc;
    private String kan;
    private String ketl;
    private String tan;
    private String td;
    private String tl1;
    private String tl2;
    private String tw5;
    private String value;
    private String vanmax;
    private String vomax;
    private String vomin;
    private String vsmax;
    private String vsmin;
    private String vtc;
    private String vtlmt;
    private String vtm;
    private String vtn;

    private static final Logger LOGGER 	= Logger.getLogger(DiscExcContIEEEDEC1AAggregate.class.getName());
}
