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
 * Subscriber for NonConformLoadGroup related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("nonConformLoadGroup-subscriber")
public class NonConformLoadGroupSubscriber extends BaseSubscriber {

	public NonConformLoadGroupSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<NonConformLoadGroup>, NonConformLoadGroup> nonConformLoadGroupSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllNonConformLoadGroupQuery(), 
                		ResponseTypes.multipleInstancesOf(NonConformLoadGroup.class),
                		ResponseTypes.instanceOf(NonConformLoadGroup.class));
    }

    public SubscriptionQueryResult<NonConformLoadGroup, NonConformLoadGroup> nonConformLoadGroupSubscribe(@DestinationVariable UUID nonConformLoadGroupId) {
        return queryGateway
                .subscriptionQuery(new FindNonConformLoadGroupQuery(new LoadNonConformLoadGroupFilter(nonConformLoadGroupId)), 
                		ResponseTypes.instanceOf(NonConformLoadGroup.class),
                		ResponseTypes.instanceOf(NonConformLoadGroup.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

