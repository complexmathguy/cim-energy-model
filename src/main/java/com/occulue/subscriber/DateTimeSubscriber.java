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
 * Subscriber for DateTime related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("dateTime-subscriber")
public class DateTimeSubscriber extends BaseSubscriber {

	public DateTimeSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<DateTime>, DateTime> dateTimeSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllDateTimeQuery(), 
                		ResponseTypes.multipleInstancesOf(DateTime.class),
                		ResponseTypes.instanceOf(DateTime.class));
    }

    public SubscriptionQueryResult<DateTime, DateTime> dateTimeSubscribe(@DestinationVariable UUID dateTimeId) {
        return queryGateway
                .subscriptionQuery(new FindDateTimeQuery(new LoadDateTimeFilter(dateTimeId)), 
                		ResponseTypes.instanceOf(DateTime.class),
                		ResponseTypes.instanceOf(DateTime.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

