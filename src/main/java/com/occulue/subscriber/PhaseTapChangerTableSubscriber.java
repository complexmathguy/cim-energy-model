/*******************************************************************************
  Turnstone Biologics Confidential
  
  2018 Turnstone Biologics
  All Rights Reserved.
  
  This file is subject to the terms and conditions defined in
  file 'license.txt', which is part of this source code package.
   
  Contributors :
        Turnstone Biologics - General Release
 ******************************************************************************/
package com.occulue.subscriber;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.SubscriptionQueryResult;
import org.axonframework.messaging.responsetypes.ResponseTypes;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.stereotype.Component;


import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;

/**
 * Subscriber for PhaseTapChangerTable related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("phaseTapChangerTable-subscriber")
public class PhaseTapChangerTableSubscriber extends BaseSubscriber {

	public PhaseTapChangerTableSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<PhaseTapChangerTable>, PhaseTapChangerTable> phaseTapChangerTableSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllPhaseTapChangerTableQuery(), 
                		ResponseTypes.multipleInstancesOf(PhaseTapChangerTable.class),
                		ResponseTypes.instanceOf(PhaseTapChangerTable.class));
    }

    public SubscriptionQueryResult<PhaseTapChangerTable, PhaseTapChangerTable> phaseTapChangerTableSubscribe(@DestinationVariable UUID phaseTapChangerTableId) {
        return queryGateway
                .subscriptionQuery(new FindPhaseTapChangerTableQuery(new LoadPhaseTapChangerTableFilter(phaseTapChangerTableId)), 
                		ResponseTypes.instanceOf(PhaseTapChangerTable.class),
                		ResponseTypes.instanceOf(PhaseTapChangerTable.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

