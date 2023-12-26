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
 * Subscriber for Bay related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("bay-subscriber")
public class BaySubscriber extends BaseSubscriber {

	public BaySubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<Bay>, Bay> baySubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllBayQuery(), 
                		ResponseTypes.multipleInstancesOf(Bay.class),
                		ResponseTypes.instanceOf(Bay.class));
    }

    public SubscriptionQueryResult<Bay, Bay> baySubscribe(@DestinationVariable UUID bayId) {
        return queryGateway
                .subscriptionQuery(new FindBayQuery(new LoadBayFilter(bayId)), 
                		ResponseTypes.instanceOf(Bay.class),
                		ResponseTypes.instanceOf(Bay.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

