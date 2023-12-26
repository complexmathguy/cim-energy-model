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
 * Aggregate handler for LoadComposite as outlined for the CQRS pattern, all write responsibilities 
 * related to LoadComposite are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class LoadCompositeAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public LoadCompositeAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public LoadCompositeAggregate(CreateLoadCompositeCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateLoadCompositeCommand" );
    	CreateLoadCompositeEvent event = new CreateLoadCompositeEvent(command.getLoadCompositeId(), command.getEpfd(), command.getEpfs(), command.getEpvd(), command.getEpvs(), command.getEqfd(), command.getEqfs(), command.getEqvd(), command.getEqvs(), command.getH(), command.getLfrac(), command.getPfrac());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateLoadCompositeCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateLoadCompositeCommand" );
    	UpdateLoadCompositeEvent event = new UpdateLoadCompositeEvent(command.getLoadCompositeId(), command.getEpfd(), command.getEpfs(), command.getEpvd(), command.getEpvs(), command.getEqfd(), command.getEqfs(), command.getEqvd(), command.getEqvs(), command.getH(), command.getLfrac(), command.getPfrac());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteLoadCompositeCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteLoadCompositeCommand" );
        apply(new DeleteLoadCompositeEvent(command.getLoadCompositeId()));
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
    void on(CreateLoadCompositeEvent event) {	
    	LOGGER.info( "Event sourcing CreateLoadCompositeEvent" );
    	this.loadCompositeId = event.getLoadCompositeId();
        this.epfd = event.getEpfd();
        this.epfs = event.getEpfs();
        this.epvd = event.getEpvd();
        this.epvs = event.getEpvs();
        this.eqfd = event.getEqfd();
        this.eqfs = event.getEqfs();
        this.eqvd = event.getEqvd();
        this.eqvs = event.getEqvs();
        this.h = event.getH();
        this.lfrac = event.getLfrac();
        this.pfrac = event.getPfrac();
    }
    
    @EventSourcingHandler
    void on(UpdateLoadCompositeEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.epfd = event.getEpfd();
        this.epfs = event.getEpfs();
        this.epvd = event.getEpvd();
        this.epvs = event.getEpvs();
        this.eqfd = event.getEqfd();
        this.eqfs = event.getEqfs();
        this.eqvd = event.getEqvd();
        this.eqvs = event.getEqvs();
        this.h = event.getH();
        this.lfrac = event.getLfrac();
        this.pfrac = event.getPfrac();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID loadCompositeId;
    
    private String epfd;
    private String epfs;
    private String epvd;
    private String epvs;
    private String eqfd;
    private String eqfs;
    private String eqvd;
    private String eqvs;
    private String h;
    private String lfrac;
    private String pfrac;

    private static final Logger LOGGER 	= Logger.getLogger(LoadCompositeAggregate.class.getName());
}
