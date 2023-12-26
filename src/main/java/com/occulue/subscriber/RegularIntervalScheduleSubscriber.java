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
 * Subscriber for RegularIntervalSchedule related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("regularIntervalSchedule-subscriber")
public class RegularIntervalScheduleSubscriber extends BaseSubscriber {

	public RegularIntervalScheduleSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<RegularIntervalSchedule>, RegularIntervalSchedule> regularIntervalScheduleSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllRegularIntervalScheduleQuery(), 
                		ResponseTypes.multipleInstancesOf(RegularIntervalSchedule.class),
                		ResponseTypes.instanceOf(RegularIntervalSchedule.class));
    }

    public SubscriptionQueryResult<RegularIntervalSchedule, RegularIntervalSchedule> regularIntervalScheduleSubscribe(@DestinationVariable UUID regularIntervalScheduleId) {
        return queryGateway
                .subscriptionQuery(new FindRegularIntervalScheduleQuery(new LoadRegularIntervalScheduleFilter(regularIntervalScheduleId)), 
                		ResponseTypes.instanceOf(RegularIntervalSchedule.class),
                		ResponseTypes.instanceOf(RegularIntervalSchedule.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

