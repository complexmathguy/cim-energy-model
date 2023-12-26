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
 * Subscriber for DayType related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("dayType-subscriber")
public class DayTypeSubscriber extends BaseSubscriber {

	public DayTypeSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<DayType>, DayType> dayTypeSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllDayTypeQuery(), 
                		ResponseTypes.multipleInstancesOf(DayType.class),
                		ResponseTypes.instanceOf(DayType.class));
    }

    public SubscriptionQueryResult<DayType, DayType> dayTypeSubscribe(@DestinationVariable UUID dayTypeId) {
        return queryGateway
                .subscriptionQuery(new FindDayTypeQuery(new LoadDayTypeFilter(dayTypeId)), 
                		ResponseTypes.instanceOf(DayType.class),
                		ResponseTypes.instanceOf(DayType.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

