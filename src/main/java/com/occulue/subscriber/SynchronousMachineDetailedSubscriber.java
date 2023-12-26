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
 * Subscriber for SynchronousMachineDetailed related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("synchronousMachineDetailed-subscriber")
public class SynchronousMachineDetailedSubscriber extends BaseSubscriber {

	public SynchronousMachineDetailedSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<SynchronousMachineDetailed>, SynchronousMachineDetailed> synchronousMachineDetailedSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllSynchronousMachineDetailedQuery(), 
                		ResponseTypes.multipleInstancesOf(SynchronousMachineDetailed.class),
                		ResponseTypes.instanceOf(SynchronousMachineDetailed.class));
    }

    public SubscriptionQueryResult<SynchronousMachineDetailed, SynchronousMachineDetailed> synchronousMachineDetailedSubscribe(@DestinationVariable UUID synchronousMachineDetailedId) {
        return queryGateway
                .subscriptionQuery(new FindSynchronousMachineDetailedQuery(new LoadSynchronousMachineDetailedFilter(synchronousMachineDetailedId)), 
                		ResponseTypes.instanceOf(SynchronousMachineDetailed.class),
                		ResponseTypes.instanceOf(SynchronousMachineDetailed.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

