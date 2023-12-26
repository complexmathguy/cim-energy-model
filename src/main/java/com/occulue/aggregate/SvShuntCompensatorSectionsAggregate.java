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
 * Aggregate handler for SvShuntCompensatorSections as outlined for the CQRS pattern, all write responsibilities 
 * related to SvShuntCompensatorSections are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class SvShuntCompensatorSectionsAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public SvShuntCompensatorSectionsAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public SvShuntCompensatorSectionsAggregate(CreateSvShuntCompensatorSectionsCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateSvShuntCompensatorSectionsCommand" );
    	CreateSvShuntCompensatorSectionsEvent event = new CreateSvShuntCompensatorSectionsEvent(command.getSvShuntCompensatorSectionsId(), command.getSections());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateSvShuntCompensatorSectionsCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateSvShuntCompensatorSectionsCommand" );
    	UpdateSvShuntCompensatorSectionsEvent event = new UpdateSvShuntCompensatorSectionsEvent(command.getSvShuntCompensatorSectionsId(), command.getSections());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteSvShuntCompensatorSectionsCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteSvShuntCompensatorSectionsCommand" );
        apply(new DeleteSvShuntCompensatorSectionsEvent(command.getSvShuntCompensatorSectionsId()));
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
    void on(CreateSvShuntCompensatorSectionsEvent event) {	
    	LOGGER.info( "Event sourcing CreateSvShuntCompensatorSectionsEvent" );
    	this.svShuntCompensatorSectionsId = event.getSvShuntCompensatorSectionsId();
        this.sections = event.getSections();
    }
    
    @EventSourcingHandler
    void on(UpdateSvShuntCompensatorSectionsEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.sections = event.getSections();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID svShuntCompensatorSectionsId;
    
    private String sections;

    private static final Logger LOGGER 	= Logger.getLogger(SvShuntCompensatorSectionsAggregate.class.getName());
}
