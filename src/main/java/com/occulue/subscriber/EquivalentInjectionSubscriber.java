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
 * Subscriber for EquivalentInjection related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("equivalentInjection-subscriber")
public class EquivalentInjectionSubscriber extends BaseSubscriber {

	public EquivalentInjectionSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<EquivalentInjection>, EquivalentInjection> equivalentInjectionSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllEquivalentInjectionQuery(), 
                		ResponseTypes.multipleInstancesOf(EquivalentInjection.class),
                		ResponseTypes.instanceOf(EquivalentInjection.class));
    }

    public SubscriptionQueryResult<EquivalentInjection, EquivalentInjection> equivalentInjectionSubscribe(@DestinationVariable UUID equivalentInjectionId) {
        return queryGateway
                .subscriptionQuery(new FindEquivalentInjectionQuery(new LoadEquivalentInjectionFilter(equivalentInjectionId)), 
                		ResponseTypes.instanceOf(EquivalentInjection.class),
                		ResponseTypes.instanceOf(EquivalentInjection.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

