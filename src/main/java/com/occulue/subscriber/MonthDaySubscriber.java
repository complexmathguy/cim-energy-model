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
 * Subscriber for MonthDay related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("monthDay-subscriber")
public class MonthDaySubscriber extends BaseSubscriber {

	public MonthDaySubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<MonthDay>, MonthDay> monthDaySubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllMonthDayQuery(), 
                		ResponseTypes.multipleInstancesOf(MonthDay.class),
                		ResponseTypes.instanceOf(MonthDay.class));
    }

    public SubscriptionQueryResult<MonthDay, MonthDay> monthDaySubscribe(@DestinationVariable UUID monthDayId) {
        return queryGateway
                .subscriptionQuery(new FindMonthDayQuery(new LoadMonthDayFilter(monthDayId)), 
                		ResponseTypes.instanceOf(MonthDay.class),
                		ResponseTypes.instanceOf(MonthDay.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

