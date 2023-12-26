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
 * Aggregate handler for EquivalentBranch as outlined for the CQRS pattern, all write responsibilities 
 * related to EquivalentBranch are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class EquivalentBranchAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public EquivalentBranchAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public EquivalentBranchAggregate(CreateEquivalentBranchCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateEquivalentBranchCommand" );
    	CreateEquivalentBranchEvent event = new CreateEquivalentBranchEvent(command.getEquivalentBranchId(), command.getNegativeR12(), command.getNegativeR21(), command.getNegativeX12(), command.getNegativeX21(), command.getPositiveR12(), command.getPositiveR21(), command.getPositiveX12(), command.getPositiveX21(), command.getR(), command.getR21(), command.getX(), command.getX21(), command.getZeroR12(), command.getZeroR21(), command.getZeroX12(), command.getZeroX21());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateEquivalentBranchCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateEquivalentBranchCommand" );
    	UpdateEquivalentBranchEvent event = new UpdateEquivalentBranchEvent(command.getEquivalentBranchId(), command.getNegativeR12(), command.getNegativeR21(), command.getNegativeX12(), command.getNegativeX21(), command.getPositiveR12(), command.getPositiveR21(), command.getPositiveX12(), command.getPositiveX21(), command.getR(), command.getR21(), command.getX(), command.getX21(), command.getZeroR12(), command.getZeroR21(), command.getZeroX12(), command.getZeroX21());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteEquivalentBranchCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteEquivalentBranchCommand" );
        apply(new DeleteEquivalentBranchEvent(command.getEquivalentBranchId()));
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
    void on(CreateEquivalentBranchEvent event) {	
    	LOGGER.info( "Event sourcing CreateEquivalentBranchEvent" );
    	this.equivalentBranchId = event.getEquivalentBranchId();
        this.negativeR12 = event.getNegativeR12();
        this.negativeR21 = event.getNegativeR21();
        this.negativeX12 = event.getNegativeX12();
        this.negativeX21 = event.getNegativeX21();
        this.positiveR12 = event.getPositiveR12();
        this.positiveR21 = event.getPositiveR21();
        this.positiveX12 = event.getPositiveX12();
        this.positiveX21 = event.getPositiveX21();
        this.r = event.getR();
        this.r21 = event.getR21();
        this.x = event.getX();
        this.x21 = event.getX21();
        this.zeroR12 = event.getZeroR12();
        this.zeroR21 = event.getZeroR21();
        this.zeroX12 = event.getZeroX12();
        this.zeroX21 = event.getZeroX21();
    }
    
    @EventSourcingHandler
    void on(UpdateEquivalentBranchEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.negativeR12 = event.getNegativeR12();
        this.negativeR21 = event.getNegativeR21();
        this.negativeX12 = event.getNegativeX12();
        this.negativeX21 = event.getNegativeX21();
        this.positiveR12 = event.getPositiveR12();
        this.positiveR21 = event.getPositiveR21();
        this.positiveX12 = event.getPositiveX12();
        this.positiveX21 = event.getPositiveX21();
        this.r = event.getR();
        this.r21 = event.getR21();
        this.x = event.getX();
        this.x21 = event.getX21();
        this.zeroR12 = event.getZeroR12();
        this.zeroR21 = event.getZeroR21();
        this.zeroX12 = event.getZeroX12();
        this.zeroX21 = event.getZeroX21();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID equivalentBranchId;
    
    private String negativeR12;
    private String negativeR21;
    private String negativeX12;
    private String negativeX21;
    private String positiveR12;
    private String positiveR21;
    private String positiveX12;
    private String positiveX21;
    private String r;
    private String r21;
    private String x;
    private String x21;
    private String zeroR12;
    private String zeroR21;
    private String zeroX12;
    private String zeroX21;

    private static final Logger LOGGER 	= Logger.getLogger(EquivalentBranchAggregate.class.getName());
}
