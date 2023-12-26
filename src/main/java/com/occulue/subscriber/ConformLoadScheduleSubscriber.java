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
 * Subscriber for ConformLoadSchedule related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("conformLoadSchedule-subscriber")
public class ConformLoadScheduleSubscriber extends BaseSubscriber {

	public ConformLoadScheduleSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ConformLoadSchedule>, ConformLoadSchedule> conformLoadScheduleSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllConformLoadScheduleQuery(), 
                		ResponseTypes.multipleInstancesOf(ConformLoadSchedule.class),
                		ResponseTypes.instanceOf(ConformLoadSchedule.class));
    }

    public SubscriptionQueryResult<ConformLoadSchedule, ConformLoadSchedule> conformLoadScheduleSubscribe(@DestinationVariable UUID conformLoadScheduleId) {
        return queryGateway
                .subscriptionQuery(new FindConformLoadScheduleQuery(new LoadConformLoadScheduleFilter(conformLoadScheduleId)), 
                		ResponseTypes.instanceOf(ConformLoadSchedule.class),
                		ResponseTypes.instanceOf(ConformLoadSchedule.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

