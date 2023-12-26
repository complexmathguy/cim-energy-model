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
 * Subscriber for TieFlow related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("tieFlow-subscriber")
public class TieFlowSubscriber extends BaseSubscriber {

	public TieFlowSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<TieFlow>, TieFlow> tieFlowSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllTieFlowQuery(), 
                		ResponseTypes.multipleInstancesOf(TieFlow.class),
                		ResponseTypes.instanceOf(TieFlow.class));
    }

    public SubscriptionQueryResult<TieFlow, TieFlow> tieFlowSubscribe(@DestinationVariable UUID tieFlowId) {
        return queryGateway
                .subscriptionQuery(new FindTieFlowQuery(new LoadTieFlowFilter(tieFlowId)), 
                		ResponseTypes.instanceOf(TieFlow.class),
                		ResponseTypes.instanceOf(TieFlow.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

