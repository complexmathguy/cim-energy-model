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
 * Subscriber for LimitSet related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("limitSet-subscriber")
public class LimitSetSubscriber extends BaseSubscriber {

	public LimitSetSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<LimitSet>, LimitSet> limitSetSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllLimitSetQuery(), 
                		ResponseTypes.multipleInstancesOf(LimitSet.class),
                		ResponseTypes.instanceOf(LimitSet.class));
    }

    public SubscriptionQueryResult<LimitSet, LimitSet> limitSetSubscribe(@DestinationVariable UUID limitSetId) {
        return queryGateway
                .subscriptionQuery(new FindLimitSetQuery(new LoadLimitSetFilter(limitSetId)), 
                		ResponseTypes.instanceOf(LimitSet.class),
                		ResponseTypes.instanceOf(LimitSet.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

