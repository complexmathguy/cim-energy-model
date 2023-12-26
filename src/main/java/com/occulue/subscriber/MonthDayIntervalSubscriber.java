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
 * Subscriber for MonthDayInterval related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("monthDayInterval-subscriber")
public class MonthDayIntervalSubscriber extends BaseSubscriber {

	public MonthDayIntervalSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<MonthDayInterval>, MonthDayInterval> monthDayIntervalSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllMonthDayIntervalQuery(), 
                		ResponseTypes.multipleInstancesOf(MonthDayInterval.class),
                		ResponseTypes.instanceOf(MonthDayInterval.class));
    }

    public SubscriptionQueryResult<MonthDayInterval, MonthDayInterval> monthDayIntervalSubscribe(@DestinationVariable UUID monthDayIntervalId) {
        return queryGateway
                .subscriptionQuery(new FindMonthDayIntervalQuery(new LoadMonthDayIntervalFilter(monthDayIntervalId)), 
                		ResponseTypes.instanceOf(MonthDayInterval.class),
                		ResponseTypes.instanceOf(MonthDayInterval.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

