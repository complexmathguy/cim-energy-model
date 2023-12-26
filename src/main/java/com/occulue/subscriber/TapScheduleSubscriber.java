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
 * Subscriber for TapSchedule related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("tapSchedule-subscriber")
public class TapScheduleSubscriber extends BaseSubscriber {

	public TapScheduleSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<TapSchedule>, TapSchedule> tapScheduleSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllTapScheduleQuery(), 
                		ResponseTypes.multipleInstancesOf(TapSchedule.class),
                		ResponseTypes.instanceOf(TapSchedule.class));
    }

    public SubscriptionQueryResult<TapSchedule, TapSchedule> tapScheduleSubscribe(@DestinationVariable UUID tapScheduleId) {
        return queryGateway
                .subscriptionQuery(new FindTapScheduleQuery(new LoadTapScheduleFilter(tapScheduleId)), 
                		ResponseTypes.instanceOf(TapSchedule.class),
                		ResponseTypes.instanceOf(TapSchedule.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

