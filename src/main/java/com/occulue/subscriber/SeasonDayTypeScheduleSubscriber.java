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
 * Subscriber for SeasonDayTypeSchedule related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("seasonDayTypeSchedule-subscriber")
public class SeasonDayTypeScheduleSubscriber extends BaseSubscriber {

	public SeasonDayTypeScheduleSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<SeasonDayTypeSchedule>, SeasonDayTypeSchedule> seasonDayTypeScheduleSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllSeasonDayTypeScheduleQuery(), 
                		ResponseTypes.multipleInstancesOf(SeasonDayTypeSchedule.class),
                		ResponseTypes.instanceOf(SeasonDayTypeSchedule.class));
    }

    public SubscriptionQueryResult<SeasonDayTypeSchedule, SeasonDayTypeSchedule> seasonDayTypeScheduleSubscribe(@DestinationVariable UUID seasonDayTypeScheduleId) {
        return queryGateway
                .subscriptionQuery(new FindSeasonDayTypeScheduleQuery(new LoadSeasonDayTypeScheduleFilter(seasonDayTypeScheduleId)), 
                		ResponseTypes.instanceOf(SeasonDayTypeSchedule.class),
                		ResponseTypes.instanceOf(SeasonDayTypeSchedule.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

