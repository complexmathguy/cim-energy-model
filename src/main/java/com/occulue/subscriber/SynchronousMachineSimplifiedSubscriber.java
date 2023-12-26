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
 * Subscriber for SynchronousMachineSimplified related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("synchronousMachineSimplified-subscriber")
public class SynchronousMachineSimplifiedSubscriber extends BaseSubscriber {

	public SynchronousMachineSimplifiedSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<SynchronousMachineSimplified>, SynchronousMachineSimplified> synchronousMachineSimplifiedSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllSynchronousMachineSimplifiedQuery(), 
                		ResponseTypes.multipleInstancesOf(SynchronousMachineSimplified.class),
                		ResponseTypes.instanceOf(SynchronousMachineSimplified.class));
    }

    public SubscriptionQueryResult<SynchronousMachineSimplified, SynchronousMachineSimplified> synchronousMachineSimplifiedSubscribe(@DestinationVariable UUID synchronousMachineSimplifiedId) {
        return queryGateway
                .subscriptionQuery(new FindSynchronousMachineSimplifiedQuery(new LoadSynchronousMachineSimplifiedFilter(synchronousMachineSimplifiedId)), 
                		ResponseTypes.instanceOf(SynchronousMachineSimplified.class),
                		ResponseTypes.instanceOf(SynchronousMachineSimplified.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

