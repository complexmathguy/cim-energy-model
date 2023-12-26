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
 * Aggregate handler for PetersenCoil as outlined for the CQRS pattern, all write responsibilities 
 * related to PetersenCoil are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PetersenCoilAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PetersenCoilAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PetersenCoilAggregate(CreatePetersenCoilCommand command) throws Exception {
    	LOGGER.info( "Handling command CreatePetersenCoilCommand" );
    	CreatePetersenCoilEvent event = new CreatePetersenCoilEvent(command.getPetersenCoilId(), command.getMode(), command.getNominalU(), command.getOffsetCurrent(), command.getPositionCurrent(), command.getXGroundMax(), command.getXGroundMin(), command.getXGroundNominal());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePetersenCoilCommand command) throws Exception {
    	LOGGER.info( "handling command UpdatePetersenCoilCommand" );
    	UpdatePetersenCoilEvent event = new UpdatePetersenCoilEvent(command.getPetersenCoilId(), command.getMode(), command.getNominalU(), command.getOffsetCurrent(), command.getPositionCurrent(), command.getXGroundMax(), command.getXGroundMin(), command.getXGroundNominal());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePetersenCoilCommand command) throws Exception {
    	LOGGER.info( "Handling command DeletePetersenCoilCommand" );
        apply(new DeletePetersenCoilEvent(command.getPetersenCoilId()));
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
    void on(CreatePetersenCoilEvent event) {	
    	LOGGER.info( "Event sourcing CreatePetersenCoilEvent" );
    	this.petersenCoilId = event.getPetersenCoilId();
        this.mode = event.getMode();
        this.nominalU = event.getNominalU();
        this.offsetCurrent = event.getOffsetCurrent();
        this.positionCurrent = event.getPositionCurrent();
        this.xGroundMax = event.getXGroundMax();
        this.xGroundMin = event.getXGroundMin();
        this.xGroundNominal = event.getXGroundNominal();
    }
    
    @EventSourcingHandler
    void on(UpdatePetersenCoilEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.mode = event.getMode();
        this.nominalU = event.getNominalU();
        this.offsetCurrent = event.getOffsetCurrent();
        this.positionCurrent = event.getPositionCurrent();
        this.xGroundMax = event.getXGroundMax();
        this.xGroundMin = event.getXGroundMin();
        this.xGroundNominal = event.getXGroundNominal();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID petersenCoilId;
    
    private String mode;
    private String nominalU;
    private String offsetCurrent;
    private String positionCurrent;
    private String xGroundMax;
    private String xGroundMin;
    private String xGroundNominal;

    private static final Logger LOGGER 	= Logger.getLogger(PetersenCoilAggregate.class.getName());
}
